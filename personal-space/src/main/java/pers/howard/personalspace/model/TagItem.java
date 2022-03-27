package pers.howard.personalspace.model;

import lombok.Data;

@Data
public class TagItem {
    private String tagId;
    private String name;
    private boolean canSee;
    private String userId;
}
