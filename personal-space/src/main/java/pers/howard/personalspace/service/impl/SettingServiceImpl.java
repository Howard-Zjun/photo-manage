package pers.howard.personalspace.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pers.howard.personalspace.dao.PreferenceDao;
import pers.howard.personalspace.dao.UserDao;
import pers.howard.personalspace.model.PersonItem;
import pers.howard.personalspace.model.PreferenceItem;
import pers.howard.personalspace.service.SettingService;

import javax.annotation.Resource;

@Service
public class SettingServiceImpl implements SettingService {

    @Resource
    PreferenceDao preferenceDao;

    @Resource
    UserDao userDao;

    @Override
    public PersonItem retrieveBasicAt(String userID) {
        return userDao.retrieveBasic(userID);
    }

    @Override
    public void updateBasicWith(PersonItem personItem) {
        userDao.updateBasic(personItem);
    }

    @Override
    public PreferenceItem retrievePreferenceAt(String userID) {
        return preferenceDao.retrievePrefer(userID);
    }

    @Override
    public void updatePreferenceWith(PreferenceItem preferenceItem) {
        preferenceDao.updatePrefer(preferenceItem);
    }

    @Override
    public void updateHeadIconAt(String userID, MultipartFile file) {

    }
}
