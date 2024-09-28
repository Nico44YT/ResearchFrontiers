package nazario.researchfrontiers.research;

import nazario.researchfrontiers.ResearchFrontiers;
import nazario.researchfrontiers.util.DrawHelper;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ElementDrawer {
    private static final Identifier FRAME_TEXTURE = ResearchFrontiers.id("textures/gui/element_frame.png");

    public static void draw(DrawContext context, int x, int y) {

    }

    public static void drawSingle(DrawContext context, int x, int y, Element element, int mouseX, int mouseY) {
        if(element.position == null) return;

        context.drawTexture(FRAME_TEXTURE, x + element.position.x, y + element.position.y, 0, 0, 16, 16, 16, 16);



        if(element.item != null) {
            DrawHelper.drawItem(context, null, null, new ItemStack(element.item), x + element.position.x, y + element.position.y, 0, 0, 12);
        }


    }
}
