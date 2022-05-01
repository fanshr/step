package com.fanshr.step.engine.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/3/16 11:14
 * @date : Modified at 2022/3/16 11:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Celebrity {
    private Integer id;
    private Integer lastname;
    private Integer sex;
    private Integer nationalityId;
    private String birthday;
    private String deathDay;
    private Integer age;
    private String summary;
    private String details;
    private String biography;
    private String remark;


    private Boolean canceled;
    private Double showOrder;
    private String uuid;
    private Integer creatorId;
    private String createDate;
    private String createTime;
    private Date createAt;
    private Integer modifierId;
    private String modifyDate;
    private String modifyTime;
    private Date modifyAt;
}
