package org.example.presistance.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.presistance.enums.Rate;

@Converter
public class RateConverter implements AttributeConverter<Rate, String> {


    @Override
    public String convertToDatabaseColumn(Rate rating) {
        return rating.name().replace('_', '-');
    }

    @Override
    public Rate convertToEntityAttribute(String dbData) {
        return Rate.valueOf(dbData.replace('-', '_'));
    }
}

