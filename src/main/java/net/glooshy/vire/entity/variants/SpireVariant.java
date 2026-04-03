package net.glooshy.vire.entity.variants;

import java.util.Arrays;
import java.util.Comparator;

public enum SpireVariant {
    DEFAULT(0),
    BROWN(1);

    private static final SpireVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(SpireVariant::getId)).toArray(SpireVariant[]::new);
    private final int id;

    SpireVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static SpireVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
