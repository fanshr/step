package com.fanshr.step.engine.core.domain.enums;

import com.fanshr.step.engine.common.enums.ErrorCode;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/6/13 22:58
 * @date : Modified at 2022/6/13 22:58
 */
public enum SelectEnum {
    /**
     *
     * 取消后缀冗余，单个单词进行标识  统一抽象为Select  具体条目为 SelectOption SelectObj  SelectValue SelectItem  SelectDetail
     *
     * 标签体系 tagSystem
     * 关联关系 correlation
     * 题目类别 questionCategory
     * 评论针对内容类别 contentCategory 针对回答，文章，博客，笔记等等的评论及及回复
     * 评论类别
     */

    TAG("tag", "标签体系"),
    CORRELATION("correlation", "关联关系"),
    QUESTION("question", "题目类别"),
    COMMENT("comment", "评论类别"),
    WAIT("wait", "标签体系")
    ;

    private String code;
    private String msg;


    private SelectEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    public static SelectEnum codeOf(String index) {
        for (SelectEnum state : values()) {
            if (state.code().equals(index)) {
                return state;
            }
        }
        return null;
    }
}
