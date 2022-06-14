package com.fanshr.step.engine.test.entity;

import com.fanshr.step.engine.question.domain.entity.QuestionTag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/5 23:02
 * @date : Modified at 2022/2/5 23:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DBFieldType {
    private Integer id;
    private Boolean field1;
    private  Boolean field2;
    private  Boolean field3;
    private String tags;
    private String title;
    private String description;
    private String remark;
    private Boolean isDisable;
    private Boolean isCancel;
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
    private Integer aTinyint;
    private Integer aSmallint;
    private Integer aMediumint;
    private Integer aInt;
    private Long aBigint;
    private Float aFloat;
    private Double aDouble;
    private Double aDecimal;
    private String aText;




    private List<QuestionTag> questionTagList;
}
