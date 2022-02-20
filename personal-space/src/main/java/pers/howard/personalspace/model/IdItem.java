package pers.howard.personalspace.model;

import lombok.Data;

/**
 * mongodb 自增集合模型
 */
@Data
public class IdItem {
    private int num;
    private String name;
}
