package com.eatbetter.InspirationData;

import com.eatbetter.Texts.TextRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class InspirationDataService {

    private final InspirationDataRepository inspirationDataRepository;
    private final TextRepository textRepository;


    public InspirationData getInspirationData(Integer id) {
        return inspirationDataRepository.findById(Long.valueOf(id)).orElseThrow(() -> new RuntimeException("InspirationData not found"));
    }

    public void addInspirationData(InspirationDataDto inspirationDataDto) {
        InspirationData inspirationData = new InspirationData();
        inspirationData.setImagePath(inspirationDataDto.getImagePath());
        inspirationData.setTexts(textRepository.findById(inspirationDataDto.getTextsID()).orElseThrow(() -> new RuntimeException("Text not found")));
        inspirationDataRepository.save(inspirationData);
    }

    public void updateInspirationData(InspirationDataDto inspirationDataDto, Integer id) {
        InspirationData inspirationData  = inspirationDataRepository.findById(Long.valueOf(id)).orElseThrow(() -> new RuntimeException("InspirationData not found"));
        inspirationData.setImagePath(inspirationDataDto.getImagePath());
        inspirationData.setTexts(textRepository.findById(inspirationDataDto.getTextsID()).orElseThrow(() -> new RuntimeException("Text not found")));
        inspirationDataRepository.save(inspirationData);
    }

    public void deleteInspirationData(Integer id) {
        inspirationDataRepository.deleteById(Long.valueOf(id));
    }
}
