package com.example.demo.model.entity.fenum;

public enum FilmRating {
    G("G"),
    PG("PG"),
    PG_13("PG-13"),
    R("R"),
    NC_17("NC-17");



    private final String displayName;


    FilmRating(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static FilmRating fromDbValue(String dbValue) {
        for (FilmRating status : FilmRating.values()) {
            if (status.getDisplayName().equalsIgnoreCase(dbValue)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown database value: " + dbValue);
    }
}
