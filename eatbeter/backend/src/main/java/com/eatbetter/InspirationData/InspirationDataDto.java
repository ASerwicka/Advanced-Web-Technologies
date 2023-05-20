package com.eatbetter.InspirationData;

import com.eatbetter.InspirationData.InspirationData;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link InspirationData} entity
 */
@Data
public class InspirationDataDto implements Serializable {
    private final Long textsID;
    private final String imagePath;
}