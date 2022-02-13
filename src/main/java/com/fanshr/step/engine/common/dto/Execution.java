package com.fanshr.step.engine.common.dto;


import com.fanshr.step.engine.common.enums.StateEnum;
import lombok.Data;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/15 11:22
 * @date : Modified at 2021/11/15 11:22
 */

@Data
public class Execution<T> {

    private int state;
    private String stateInfo;
    private T obj;
    private List<T> list;
    private long total;

    public Execution() {
        this.state = StateEnum.SUCCESS.getState();
        this.stateInfo = StateEnum.SUCCESS.getStateInfo();
    }

    public Execution(StateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }
    public Execution(T obj) {
        this.state = StateEnum.SUCCESS.getState();
        this.stateInfo = StateEnum.SUCCESS.getStateInfo();
        this.obj = obj;
    }

    public Execution( List<T> list,long total) {
        this.state = StateEnum.SUCCESS.getState();
        this.stateInfo = StateEnum.SUCCESS.getStateInfo();
        this.list = list;
        this.total = total;
    }
}
