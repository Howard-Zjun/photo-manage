package pers.howard.personalspace.service;

import org.springframework.web.multipart.MultipartFile;
import pers.howard.personalspace.model.PersonItem;
import pers.howard.personalspace.model.PreferenceItem;

public interface SettingService {
    PersonItem retrieveBasicAt(String userID);
    void updateBasicWith(PersonItem personItem);
    PreferenceItem retrievePreferenceAt(String userID);
    void updatePreferenceWith(PreferenceItem preferenceItem);
    void updateHeadIconAt(String userID, MultipartFile file);
}
