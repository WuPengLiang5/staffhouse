package com.example.staffhouse.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * job_inf
 * @author silver
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobInf implements Serializable {
    private Integer id;

    private String name;

    private String remark;

    private static final long serialVersionUID = 1L;
}