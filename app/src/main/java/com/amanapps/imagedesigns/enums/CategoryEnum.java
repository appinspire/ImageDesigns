package com.amanapps.imagedesigns.enums;

/**
 * Created by Bilal Rashid on 12/5/2018.
 */

public enum CategoryEnum {
    BEAUTIFUL(1),
    LATEST(2),
    MODERN(3),
    NEW_DIAMOND(4),
    SILK(5),
    TRENDY(6),
    WOMEN(7),
    JEWELLERY(8);

    private final int id;

    CategoryEnum(int id) {
        this.id = id;
    }

    public int getValue() {
        return id;
    }
}
