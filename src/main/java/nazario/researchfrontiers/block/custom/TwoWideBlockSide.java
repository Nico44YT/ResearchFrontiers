package nazario.researchfrontiers.block.custom;

import net.minecraft.util.StringIdentifiable;

public enum TwoWideBlockSide implements StringIdentifiable {
    LEFT, RIGHT;

    public String toString() {
        return this.asString();
    }

    public String asString() {
        return this == LEFT ? "left" : "right";
    }
}
