package pers.howard.personalspace.model;

import lombok.Data;

@Data
public class UpdateShareTagItem {
    private String shareId;
    private String[] tagIds;
}
