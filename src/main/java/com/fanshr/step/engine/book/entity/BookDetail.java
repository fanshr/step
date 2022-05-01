package com.fanshr.step.engine.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/3/16 11:00
 * @date : Modified at 2022/3/16 11:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDetail {
    private Integer id;
    private Integer bookId;
    private String acquireDate;
    private Boolean isPaper;
    private Integer readCount;
}
