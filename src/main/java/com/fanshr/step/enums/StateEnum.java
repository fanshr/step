package com.fanshr.step.enums;

/**
 * 状态枚举常量
 *
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/12 09:54
 * @date : Modified at 2021/11/12 09:54
 */
public enum StateEnum {


    SUCCESS(1, "操作成功"),
    INNER_ERROR(0, "操作失败"),
    EMPTY(-1, "关键信息为空");

    private int state;
    private String stateInfo;

    private StateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static StateEnum stateOf(int index) {
        for (StateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }

        return null;
    }
}
