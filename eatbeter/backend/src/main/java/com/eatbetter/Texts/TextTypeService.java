package com.eatbetter.Texts;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TextTypeService {


    private final TextTypeRepository textTypeRepository;
    public TextType getTextType(Integer id){
        return textTypeRepository.findById(id.longValue()).orElseThrow();
    }

    public void addTextType(TextType textType) {
        textTypeRepository.save(textType);
    }

    public void updateTextType(TextType textType, Integer id) {
        TextType textType1 = textTypeRepository.findById(id.longValue()).orElseThrow();
        textType1.setName(textType.getName());
        textType1.setId(textType.getId());
        textTypeRepository.save(textType1);
    }

    public void deleteTextType(Integer id) {
        textTypeRepository.deleteById(id.longValue());
    }
}
