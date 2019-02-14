package com.amanapps.imagedesigns.enums;

/**
 * Created by Bilal Rashid on 12/5/2018.
 */

public enum CategoryEnum {
    BANGLE(1),
    BEADS(2),
    FRIENDSHIP(3),
    GOLD(4),
    RUBBER(5),
    SIMPLE(6);

    private final int id;

    CategoryEnum(int id) {
        this.id = id;
    }

    public int getValue() {
        return id;
    }
}
