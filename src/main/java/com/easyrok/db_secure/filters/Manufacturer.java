package com.easyrok.db_secure.filters;

public enum Manufacturer {
    LG("LG"),
    SAMSUNG("Samsung"),
    CISCO("CISCO"),
    SHURE("Shure"),
    EXTRON("Extron"),
    AMX("AMX");

    private final String value;
    Manufacturer(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
