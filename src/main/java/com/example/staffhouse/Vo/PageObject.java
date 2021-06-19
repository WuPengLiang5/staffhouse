package com.example.staffhouse.Vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class PageObject<T> implements Serializable {
    private static final long serialVersionUID = 2980944444536993353L;
    /**总记录数*/
    private Long total;
    /**当前页记录*/
    private List<T> records;


    public PageObject(Long total, List<T> records) {
        this.total= total;
        this.records = records;
    }
}
