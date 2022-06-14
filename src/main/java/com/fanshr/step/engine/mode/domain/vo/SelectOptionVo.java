package com.fanshr.step.engine.mode.domain.vo;

import com.fanshr.step.engine.mode.domain.dto.SelectDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/6/12 23:02
 * @date : Modified at 2022/6/12 23:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectOptionVo implements Serializable {

    private static final long serialVersionUID = -3026537047266802225L;
    private Integer id;

    @ApiModelProperty("选择框标识")
    private Integer mainId;

    @ApiModelProperty("条目名称")
    private String selectName;

    @ApiModelProperty("条目值")
    private Integer selectValue;

    @ApiModelProperty("是否默认选中")
    private Boolean checked;

    @ApiModelProperty("是否封存")
    private Boolean canceled;

    @ApiModelProperty("拼音检索")
    private String pinyin;

    @ApiModelProperty("显示顺序")
    private BigDecimal display;

    @ApiModelProperty("选择框标识")
    private SelectDto selectDto;
}
