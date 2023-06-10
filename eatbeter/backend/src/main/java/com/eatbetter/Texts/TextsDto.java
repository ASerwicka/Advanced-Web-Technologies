package com.eatbetter.Texts;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Texts} entity
 */
@Data
public class TextsDto implements Serializable {
    private final Integer textTypeID;
    private final String data;
}