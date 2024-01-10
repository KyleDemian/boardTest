package study.boardtest.board.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BoardCategoriesConverter implements AttributeConverter<BoardCategories, String> {


    @Override
    public String convertToDatabaseColumn(BoardCategories attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getBoardName();
    }

    @Override
    public BoardCategories convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        try {
            return BoardCategories.parsing(dbData);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
