package com.eatbetter.Texts;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TextService {
    private final TextRepository textRepository;
    private final TextTypeService textTypeService;

    public Texts getText(Integer id) {
        return textRepository.findById(Long.valueOf(id)).orElseThrow(() -> new RuntimeException("Text not found"));
    }

    public void addText(TextsDto textsDto) {
        Texts text = new Texts();
        text.setData(textsDto.getData());
        text.setTextType(textTypeService.getTextType(textsDto.getTextTypeID()));
        textRepository.save(text);
    }

    public void updateText(TextsDto textsDto, Integer id) {
        Texts text = getText(id);
        text.setData(textsDto.getData());
        text.setTextType(textTypeService.getTextType(textsDto.getTextTypeID()));
        textRepository.save(text);
    }

    public void deleteText(Integer id) {
        textRepository.delete(getText(id));
    }
}
