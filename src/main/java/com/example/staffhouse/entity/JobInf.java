package com.example.staffhouse.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * job_inf
 * @author silver
 */
@Data
public class JobInf implements Serializable {
    private Integer id;

    private String name;

    private String remark;

    private static final long serialVersionUID = 1L;
}