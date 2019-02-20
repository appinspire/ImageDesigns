package com.amanapps.imagedesigns.enums;

/**
 * Created by Bilal Rashid on 12/5/2018.
 */

public enum CategoryEnum {
    FANCY(1),
    HAND(2),
    INDIAN(3),
    BRIDAL(4);

    private final int id;

    CategoryEnum(int id) {
        this.id = id;
    }

    public int getValue() {
        return id;
    }
}
