package nazario.researchfrontiers.util;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class LibyDrawHelper {
    public static void drawItem(DrawContext context, @Nullable LivingEntity entity, @Nullable World world, ItemStack stack, int x, int y, int z, int seed, float scale) {
        drawItem(context, entity, world, stack, x, y, z, seed, 15728880, scale, scale, scale);
    }
    public static void drawItemShadow(DrawContext context, @Nullable LivingEntity entity, @Nullable World world, ItemStack stack, int x, int y, int z, int seed, float scale) {
        drawItem(context, entity, world, stack, x, y, z, seed, 0, scale, scale, scale);
    }

    public static void drawItem(DrawContext context, @Nullable LivingEntity entity, @Nullable World world, ItemStack stack, int x, int y, int z, int seed, int light, float scaleX, float scaleY, float scaleZ) {
        MatrixStack matrices = context.getMatrices();
        if (stack.isEmpty()) return;

        BakedModel bakedModel = MinecraftClient.getInstance().getItemRenderer().getModel(stack, world, entity, seed);
        matrices.push();
        matrices.translate((float)(x + 8), (float)(y + 8), (float)(150 + (bakedModel.hasDepth() ? z : 0)));

        try {
            matrices.multiplyPositionMatrix((new Matrix4f()).scaling(1.0F, -1.0F, 1.0F));
            matrices.scale(scaleX, scaleY, scaleZ);

            if (!bakedModel.isSideLit()) DiffuseLighting.disableGuiDepthLighting();

            MinecraftClient.getInstance().getItemRenderer().renderItem(
                    stack,
                    ModelTransformationMode.GUI,
                    false,
                    matrices,
                    context.getVertexConsumers(),
                    light,
                    OverlayTexture.DEFAULT_UV,
                    bakedModel
            );

            context.draw();

            if (!bakedModel.isSideLit()) DiffuseLighting.enableGuiDepthLighting();

        } catch (Exception ignored) {}

        matrices.pop();

    }

    public static void drawEntity(DrawContext context, int x1, int y1, int x2, int y2, int size, float f, float mouseX, float mouseY, Entity entity) {
        float g = (float)(x1 + x2) / 2.0F;
        float h = (float)(y1 + y2) / 2.0F;
        context.enableScissor(x1, y1, x2, y2);
        float mouseXQuat = (float)Math.atan((double)((g - mouseX) / 40.0F));
        float mouseYQout = (float)Math.atan((double)((h - mouseY) / 40.0F));
        Quaternionf quaternionf = new Quaternionf().rotateZ((float) Math.PI);
        Quaternionf quaternionf2 = new Quaternionf().rotateX(mouseYQout * 20.0F * (float) (Math.PI / 180.0));
        quaternionf.mul(quaternionf2);
        float bodyYaw = entity.getBodyYaw();
        if(entity instanceof LivingEntity livingEntity) {
            bodyYaw = livingEntity.bodyYaw;

        }

        float yaw = entity.getYaw();
        float pi = entity.getPitch();

        float prevHeadYaw = 1;
        if(entity instanceof LivingEntity livingEntity) {
            prevHeadYaw = livingEntity.prevHeadYaw;
        }

        float headYaw = entity.getHeadYaw();
        entity.setBodyYaw(180.0F + mouseXQuat * 20.0F);


        entity.setYaw(180.0F + mouseXQuat * 40.0F);
        entity.setPitch(-mouseYQout * 20.0F);
        if(entity instanceof LivingEntity livingEntity) {
            livingEntity.headYaw = entity.getYaw();
            livingEntity.prevHeadYaw = entity.getYaw();
        }
        float scale = 1;
        if(entity instanceof LivingEntity livingEntity) {
            scale = livingEntity.getScale();
        }

        Vector3f vector3f = new Vector3f(0.0F, entity.getHeight() / 2.0F + f * scale, 0.0F);
        float q = (float)size / scale;
        drawEntity(context, g, h, q, vector3f, quaternionf, quaternionf2, entity);
        if(entity instanceof LivingEntity livingEntity) {
            livingEntity.bodyYaw = bodyYaw;
        }
        entity.setYaw(yaw);
        entity.setPitch(pi);
        if(entity instanceof LivingEntity livingEntity) {
            livingEntity.prevHeadYaw = prevHeadYaw;
            livingEntity.headYaw = headYaw;
        }
        context.disableScissor();
    }

    public static void drawEntity(DrawContext context, float x, float y, float size, Vector3f vector3f, Quaternionf quaternionf, @Nullable Quaternionf quaternionf2, Entity entity) {
        context.getMatrices().push();
        context.getMatrices().translate((double)x, (double)y, 50.0);
        context.getMatrices().scale(size, size, -size);
        context.getMatrices().translate(vector3f.x, vector3f.y, vector3f.z);
        context.getMatrices().multiply(quaternionf);
        DiffuseLighting.method_34742();
        EntityRenderDispatcher entityRenderDispatcher = MinecraftClient.getInstance().getEntityRenderDispatcher();
        if (quaternionf2 != null) {
            entityRenderDispatcher.setRotation(quaternionf2.conjugate(new Quaternionf()).rotateY((float) Math.PI));
        }

        entityRenderDispatcher.setRenderShadows(false);
        RenderSystem.runAsFancy(() -> entityRenderDispatcher.render(entity, 0.0, 0.0, 0.0, 0.0F, 1.0F, context.getMatrices(), context.getVertexConsumers(), 15728880));
        context.draw();
        entityRenderDispatcher.setRenderShadows(true);
        context.getMatrices().pop();
        DiffuseLighting.enableGuiDepthLighting();
    }
}
