package com.its.karaoke.entity.enums;

import com.its.karaoke.type.PersistentEnum;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum KaraEventType implements PersistentEnum<Integer> {
    START(0),
    END(1);


    private int type;

    KaraEventType(int type) {
        this.type = type;
    }

    public static final Map<Integer, KaraEventType> INDEX = Arrays.stream(KaraEventType.values()).collect(Collectors.toMap(KaraEventType::getValue, e -> e));

    @Override
    public Integer getValue() {
        return this.type;
    }

    @Override
    public String getDisplayName() {
        return "";
    }

    @Override
    public Map<Integer, ? extends PersistentEnum<Integer>> getAll() {
        return INDEX;
    }

}

