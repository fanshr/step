package com.fanshr.step.engine.mode.domain.vo;

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
 * 字段明细信息
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Getter
@Setter
@TableName("mode_field")
@ApiModel(value = "FieldVo对象", description = "字段明细信息")
public class FieldVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("表单标识")
    @TableField("form_id")
    private Integer formId;

    @ApiModelProperty("字段标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("标签标识")
    @TableField("label_id")
    private Integer labelId;

    @ApiModelProperty("数据库名称")
    @TableField("field_name")
    private String fieldName;

    @ApiModelProperty("对应数据库类型")
    @TableField("db_type")
    private String dbType;

    @ApiModelProperty("一级字段类型标识")
    @TableField("html_type")
    private Integer htmlType;

    @ApiModelProperty("二级字段类型标识")
    @TableField("type_id")
    private Integer typeId;

    @ApiModelProperty("是否主表字段")
    @TableField("is_main")
    private Integer isMain;

    @ApiModelProperty("从属主表")
    @TableField("dt_from")
    private String dtFrom;

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