package nazario.researchfrontiers.block.blast_furnace;

import net.minecraft.util.StringIdentifiable;

public enum BlastFurnaceState implements StringIdentifiable {
    CLOSED, OPEN;

    public String toString() {
        return this.asString();
    }

    public String asString() {
        return this == CLOSED ? "closed" : "open";
    }
}
