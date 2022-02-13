package com.fanshr.step.engine.test.service;

import com.fanshr.step.engine.common.dto.Execution;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/10 13:02
 * @date : Modified at 2022/2/10 13:02
 */

public interface FieldTypeService {


    public Execution getList(int current,int pageSize);

}
