package com.fanshr.step.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/6 20:53
 * @date : Modified at 2021/11/6 20:53
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewItem {

    private Integer id;
    private String title;
    private Integer categoryId;
    private String tags;
    private String description;
    private String remark;
    private String answer;
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

    private InterviewCategory category;
    private List<InterviewTag> tagList;

}
