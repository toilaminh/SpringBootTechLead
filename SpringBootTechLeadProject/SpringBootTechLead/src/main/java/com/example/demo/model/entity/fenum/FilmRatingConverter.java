package com.example.demo.model.entity.fenum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FilmRatingConverter implements AttributeConverter<FilmRating, String> {

    @Override
    public String convertToDatabaseColumn(FilmRating rating) {
        return rating != null ? rating.getDisplayName() : null;
    }

    @Override
    public FilmRating convertToEntityAttribute(String dbData) {
        return dbData != null ? FilmRating.fromDbValue(dbData) : null;
    }
}
