package com.fanshr.step.engine.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 账户信息表
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@Getter
@Setter
@TableName("sys_account")
@ApiModel(value = "Account对象", description = "账户信息表")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("账号")
    @TableField("username")
    private String username;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("描述")
    @TableField("description")
    private String description;

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
