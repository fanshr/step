package com.fanshr.step.dto;


import com.fanshr.step.enums.StateEnum;
import lombok.Data;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/15 11:22
 * @date : Modified at 2021/11/15 11:22
 */

@Data
public class Execution {

    private int state;
    private String stateInfo;
    private Object obj;
    private List list;
    private int count;

    public Execution() {
        this.state = StateEnum.SUCCESS.getState();
        this.stateInfo = StateEnum.SUCCESS.getStateInfo();
    }

    public Execution(StateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public Execution( List list) {
        this.state = StateEnum.SUCCESS.getState();
        this.stateInfo = StateEnum.SUCCESS.getStateInfo();
        this.list = list;
        this.count = list.size();
    }

    public Execution( List list,int count) {
        this.state = StateEnum.SUCCESS.getState();
        this.stateInfo = StateEnum.SUCCESS.getStateInfo();
        this.list = list;
        this.count = count;
    }
}
