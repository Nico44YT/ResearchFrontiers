package nazario.researchfrontiers.research;

import nazario.researchfrontiers.util.DrawHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.crash.CrashCallable;
import net.minecraft.util.crash.CrashException;
import net.minecraft.util.crash.CrashReport;
import net.minecraft.util.crash.CrashReportSection;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2i;

import java.util.Optional;

public class Element {
    private static final Identifier FRAME_TEXTURE = Identifier.of("researchfrontiers:textures/gui/element_frame.png");

    public int index;
    public Item item;
    public String initials;
    public String name;

    public ElementCategory category;
    public ElementState state;

    public Vector2i position;

    public boolean isMetal;
    public ElementProperties[] properties;

    public Element(int index, String initials, String name, ElementCategory category, ElementState state) {
        this.index = index;
        this.initials = initials;
        this.name = name;
        this.category = category;
        this.state = state;
    }

    public Element setPosition(int x, int y) {
        this.position = new Vector2i(x, y);
        return this;
    }

    public Element setItem(Item item) {
        this.item = item;
        return this;
    }

}
