package com.example.staffhouse.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    private Integer id;
    private Integer userId;
    private String title;
    private String filename;
    private String remark;
    private String createDate;
    private String path;

}
