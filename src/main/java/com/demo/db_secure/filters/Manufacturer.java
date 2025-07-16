package com.demo.db_secure.filters;

/*
 * Example for vendor based filters
 */

public enum Manufacturer {
    LG("LG"),
    SAMSUNG("Samsung"),
    CISCO("CISCO"),
    SHURE("Shure");

    private final String value;
    Manufacturer(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
