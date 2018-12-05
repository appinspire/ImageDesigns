package com.amanapps.imagedesigns.enums;

/**
 * Created by Bilal Rashid on 12/5/2018.
 */

public enum CategoryEnum {
    COUPLE(1),
    ENGAGEMENT(2),
    WEDDING(3),
    PROMISE(4),
    NEW(5),
    UNIQUE(6),
    DIAMOND(7),
    JEWELLERY(8);

    private final int id;

    CategoryEnum(int id) {
        this.id = id;
    }

    public int getValue() {
        return id;
    }
}
