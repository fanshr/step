package com.fanshr.step.engine.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/6 20:53
 * @date : Modified at 2021/11/6 20:53
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRecord {
    private Integer id;
    private Integer bookId;
    private String startDate;
    private String endDate;
    private String note;

}
