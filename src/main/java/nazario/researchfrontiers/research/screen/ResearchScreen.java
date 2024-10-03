package nazario.researchfrontiers.research.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.lambdaurora.spruceui.screen.SpruceScreen;
import nazario.researchfrontiers.ResearchFrontiers;
import nazario.researchfrontiers.research.Element;
import nazario.researchfrontiers.research.ElementDrawer;
import nazario.researchfrontiers.research.Elements;
import nazario.liby.util.LibyDrawHelper;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ThreePartsLayoutWidget;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ResearchScreen extends SpruceScreen {

    private static final Identifier WINDOW_TEXTURE = ResearchFrontiers.id("textures/gui/research_table.png");
    public static final int TEXTURE_WIDTH = 432;
    //public static final int TEXTURE_WIDTH = 317;
    public static final int TEXTURE_HEIGHT = 182;
    private final ThreePartsLayoutWidget layout = new ThreePartsLayoutWidget(this);

    protected int selectedElement = 5;

    protected ItemEntity entity;
    protected int roX = 0;

    public ResearchScreen(Text title) {
        super(title);
    }

    @Override
    protected void init() {
        super.init();

        this.layout.addHeader(Text.literal("Research Table"), this.textRenderer);
        this.entity = new ItemEntity(EntityType.ITEM, this.client.world);
        this.entity.setStack(new ItemStack(Items.DIAMOND));
        this.entity.setBodyYaw(0);

        System.out.println("INIT");
    }

    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        int x = (this.width - TEXTURE_WIDTH) / 2;
        int y = (this.height - TEXTURE_HEIGHT) / 2;

        this.drawWindow(context, x, y);

        this.drawElements(context, x, y, mouseX, mouseY, delta);

    }

    private void drawElements(DrawContext context, int x, int y, int mouseX, int mouseY, float delta) {

        int windowX = x + 130;
        int windowY = y + 23;

        for(int i = 0; i < Elements.ELEMENTS.length; i++) {
            ElementDrawer.drawSingle(context, windowX, windowY, Elements.ELEMENTS[i], mouseX, mouseY);

            if(Elements.ELEMENTS[i].position == null) continue;
            if(mouseX >= windowX+Elements.ELEMENTS[i].position.x && mouseX < windowX+Elements.ELEMENTS[i].position.x + 16 && mouseY >= windowY+Elements.ELEMENTS[i].position.y && mouseY < windowY+Elements.ELEMENTS[i].position.y + 16) {
                context.fill(windowX+Elements.ELEMENTS[i].position.x, windowY+Elements.ELEMENTS[i].position.y, windowX+Elements.ELEMENTS[i].position.x + 16, windowY+Elements.ELEMENTS[i].position.y + 16, 0x80FFFFFF);
            }
        }

        if(selectedElement != -1) {
            if(Elements.ELEMENTS[selectedElement].item != null) {
                this.entity.setBodyYaw(0);
                this.entity.age++;

                this.entity.setBodyYaw(roX++);

                LibyDrawHelper.drawEntity(context, x+15, y+30, x+107,y+150 ,100,0f, 0, 0, entity);
            }
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int windowX =  ((this.width - TEXTURE_WIDTH) / 2) + 130;
        int windowY =  ((this.height - TEXTURE_HEIGHT) / 2) + 23;


        for(Element ele : Elements.ELEMENTS) {
            if(ele.position == null) continue;
            if(mouseX > windowX+ele.position.x && mouseX < windowX+ele.position.x + 16 && mouseY > windowY+ele.position.y && mouseY < windowY+ele.position.y + 16) {
                if(ele.item == null) continue;

                if(button == 0) {
                    this.selectedElement = ele.index-1;

                    entity.setStack(new ItemStack(Elements.ELEMENTS[selectedElement].item));
                    return true;
                }
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    public void drawWindow(DrawContext context, int x, int y) {
        RenderSystem.enableBlend();
        context.drawTexture(WINDOW_TEXTURE, x, y, 0, 0, TEXTURE_WIDTH, TEXTURE_HEIGHT, TEXTURE_WIDTH, TEXTURE_HEIGHT);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
