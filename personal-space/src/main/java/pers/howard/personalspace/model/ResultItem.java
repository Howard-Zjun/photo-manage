package pers.howard.personalspace.model;

import lombok.Data;

@Data
public class ResultItem {
    protected String color;
    protected String describe;
    public ResultItem(String color, String describe) {
        this.color = color;
        this.describe = describe;
    }
}
