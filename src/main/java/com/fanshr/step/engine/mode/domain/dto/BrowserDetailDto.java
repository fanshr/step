package com.fanshr.step.engine.mode.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 浏览框条目明细
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Getter
@Setter
@TableName("mode_browser_detail")
@ApiModel(value = "BrowserDetailDto对象", description = "浏览框条目明细")
public class BrowserDetailDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("浏览框分类标识")
    @TableField("main_id")
    private Integer mainId;

    @ApiModelProperty("标签标识")
    @TableField("label_id")
    private Integer labelId;

    @ApiModelProperty("数据库类型")
    @TableField("db_type")
    private String dbType;

    @ApiModelProperty("页面链接")
    @TableField("browser_url")
    private String browserUrl;

    @ApiModelProperty("数据表")
    @TableField("table_name")
    private String tableName;

    @ApiModelProperty("字段名称")
    @TableField("field_name")
    private String fieldName;

    @ApiModelProperty("主键名称")
    @TableField("key_name")
    private String keyName;

    @ApiModelProperty("信息链接")
    @TableField("link_url")
    private String linkUrl;

    @ApiModelProperty("是否启用")
    @TableField("enable")
    private Integer enable;

    @ApiModelProperty("显示顺序")
    @TableField("display")
    private BigDecimal display;


}
