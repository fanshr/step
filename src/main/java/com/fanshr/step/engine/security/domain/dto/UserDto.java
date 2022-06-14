package com.fanshr.step.engine.security.domain.dto;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Getter
@Setter
@TableName("security_user")
@ApiModel(value = "UserDto对象", description = "用户信息表")
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("姓名")
    @TableField("lastname")
    private String lastname;

    @ApiModelProperty("昵称")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty("账号")
    @TableField("username")
    private String username;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("头像")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty("性别")
    @TableField("gender")
    private Integer gender;

    @ApiModelProperty("生日")
    @TableField("birthday")
    private String birthday;

    @ApiModelProperty("电话")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("简介")
    @TableField("description")
    private String description;

    @ApiModelProperty("是否锁定")
    @TableField("locked")
    private Integer locked;

    @ApiModelProperty("登录状态")
    @TableField("login")
    private Integer login;

    @ApiModelProperty("上次登录ip")
    @TableField("last_login_ip")
    private String lastLoginIp;

    @ApiModelProperty("上次登录时间")
    @TableField("last_login_time")
    private Date lastLoginTime;

    @ApiModelProperty("是否封存")
    @TableField("canceled")
    private Integer canceled;

    @ApiModelProperty("拼音检索")
    @TableField("pinyin")
    private String pinyin;

    @ApiModelProperty("显示顺序")
    @TableField("display")
    private BigDecimal display;

    @ApiModelProperty("逻辑删除标识")
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

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
