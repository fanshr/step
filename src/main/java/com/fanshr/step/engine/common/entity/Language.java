package com.fanshr.step.engine.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/3/16 11:10
 * @date : Modified at 2022/3/16 11:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {
    private Integer id;
    private String flag;
    private String description;
    private String encoding;
    private Boolean enable;
}
