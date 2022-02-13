package com.fanshr.step.engine.question.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/6 20:53
 * @date : Modified at 2021/11/6 20:53
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    private Integer id;
    private String title;
    private Integer parentId;
    private String description;
    private String remark;
    private Double frequency;
    private Double percentage;
    private Double showOrder;
    private Boolean isDisable;
    private Boolean isCancel;
    private Integer moduleId;
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
