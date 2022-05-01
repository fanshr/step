package com.fanshr.step.engine.book.entity;

import com.fanshr.step.engine.common.entity.Celebrity;
import com.fanshr.step.engine.common.entity.Language;
import com.fanshr.step.engine.question.entity.Category;
import com.fanshr.step.engine.question.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/6 20:53
 * @date : Modified at 2021/11/6 20:53
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer id;
    private String isbn;
    private String title;
    private String description;
    private Integer typeId;
    private String publisher;
    private String publishedDate;
    private String summary;
    private String remark;
    private String translators;
    private Integer languageId;
    private String authors;
    private Boolean canceled;
    private Double showOrder;
    private String uuid;
    private Integer creatorId;
    private String createDate;
    private String createTime;
    private Date createAt;
    private Integer modifierId;
    private String modifyDate;
    private String modifyTime;
    private Date modifyAt;

    private BookType bookType;
    private Language language;
    private List<Celebrity> authorList;
    private List<Celebrity> translatorList;
}
