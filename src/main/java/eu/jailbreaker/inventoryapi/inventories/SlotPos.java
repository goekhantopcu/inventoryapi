package eu.jailbreaker.inventoryapi.inventories;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class SlotPos {

    private final int row;
    private final int column;

    public static SlotPos of(int row, int column) {
        return new SlotPos(row, column);
    }

    public int toSlot() {
        return this.row * this.column - 1;
    }

}
