package com.amanapps.imagedesigns.enums;

/**
 * Created by Bilal Rashid on 12/5/2018.
 */

public enum CategoryEnum {
    BEAUTIFUL(1),
    CHOKER(2),
    DIAMOND(3),
    GOLD(4),
    LETTER(5),
    WOMEN(6);

    private final int id;

    CategoryEnum(int id) {
        this.id = id;
    }

    public int getValue() {
        return id;
    }
}
