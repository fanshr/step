package com.fanshr.step.engine.security.mapper;

import com.fanshr.step.engine.security.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 账户信息表 Mapper 接口
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}
