package pers.howard.personalspace.service;

import pers.howard.personalspace.model.RemarkItem;
import pers.howard.personalspace.model.ShareDetailItem;

import java.util.List;

public interface PersonalShareService {
    List<ShareDetailItem> retrieveAt(String userID, int page);
    void updateStatusAt(String shareID, boolean status);
    boolean retrieveStatusAt(String shareID);
    void deleteAt(String shareID);
    void remarkWith(RemarkItem remarkItem);
    void likeAt(String shareID);
}
