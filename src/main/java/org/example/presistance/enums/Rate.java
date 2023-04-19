package org.example.presistance.enums;

public enum Rate {
    G("G"),
    PG("PG"),
    PG_13("PG-13"),
    R("R"),
    NC_17("NC-17");

    private String desc;

    Rate(String d) {
        this.desc = d;
    }

    public String getDescription() {
        return desc;
    }

}
