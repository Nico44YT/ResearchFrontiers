package nazario.researchfrontiers.research;

import net.minecraft.item.Item;
import org.joml.Vector2i;

public class Element {
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
