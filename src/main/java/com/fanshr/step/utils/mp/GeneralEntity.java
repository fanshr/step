package com.fanshr.step.utils.mp;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/5/2 23:12
 * @date : Modified at 2022/5/2 23:12
 */
@Getter
@Setter
// @TableName("sys_user")
@ApiModel(value = "通用实体对象", description = "通用实体对象")
public class GeneralEntity implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("是否封存")
    @TableField("canceled")
    private Boolean canceled;

    @ApiModelProperty("拼音检索")
    @TableField("pinyin")
    private String pinyin;

    @ApiModelProperty("显示顺序")
    @TableField("display")
    private BigDecimal display;

    @ApiModelProperty("逻辑删除标识")
    @TableField("deleted")
    @TableLogic
    private Boolean deleted;

    @ApiModelProperty("版本号")
    @TableField("version")
    @Version
    private Integer version;

    @ApiModelProperty("uuid")
    @TableField("uuid")
    private String uuid;

    @ApiModelProperty("创建人")
    @TableField("creator_id")
    private Integer creatorId;

    @ApiModelProperty("创建日期")
    @TableField("create_date")
    private String createDate;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private String createTime;

    @ApiModelProperty("创建时刻")
    @TableField("created")
    private Date created;

    @ApiModelProperty("修改人")
    @TableField("modifier_id")
    private Integer modifierId;

    @ApiModelProperty("修改日期")
    @TableField("modify_date")
    private String modifyDate;

    @ApiModelProperty("修改时间")
    @TableField("modify_time")
    private String modifyTime;

    @ApiModelProperty("修改时刻")
    @TableField("modified")
    private Date modified;
}
