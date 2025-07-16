package com.easyrok.db_secure.filters;

public enum ProductCategory {
    VIDEO("Video"),
    AUDIO("Audio"),
    CONTROL("Control"),
    NETWORKING("Networking"),
    FRAMING_AND_FINISHING("Framing and Finishing"),
    FURNITURE("Furniture"),
    CONSTRUCTION_MATERIALS("Construction Materials");

    private final String displayName;
    ProductCategory(String s) {
        this.displayName = s;
    }

    public String getDisplayName() {
        return displayName;
    }
}
