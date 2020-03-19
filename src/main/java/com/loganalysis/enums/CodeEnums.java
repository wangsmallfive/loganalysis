package com.loganalysis.enums;

public enum CodeEnums {
    SUCCESS(1), FAIL(0);

    private int value;

    private CodeEnums(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
