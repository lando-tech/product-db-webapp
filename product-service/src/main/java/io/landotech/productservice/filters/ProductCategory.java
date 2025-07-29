package io.landotech.productservice.filters;

public enum ProductCategory {
    VIDEO("Video"),
    AUDIO("Audio"),
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
