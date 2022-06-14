package com.fanshr.step.engine.core.domain.vo;

import com.fanshr.step.engine.core.domain.dto.TagDto;
import com.fanshr.step.engine.mode.domain.dto.SelectOptionDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/6/12 23:45
 * @date : Modified at 2022/6/12 23:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "TagGroupVo对象", description = "标签组信息")
public class TagGroupVo  implements Serializable {
    private static final long serialVersionUID = -4543921663267633584L;
    private Integer id;

    @ApiModelProperty("标签体系类别")
    private Integer typeId;

    @ApiModelProperty("标签组名称")
    private String title;

    @ApiModelProperty("标签组标识")
    private String mark;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("显示顺序")
    private BigDecimal display;

    @ApiModelProperty("标签集合")
    private List<TagDto> tagDtoList;

    @ApiModelProperty("所属标签体系")
    private SelectOptionDto tagSelectOption;

}
