package com.fanshr.step.engine.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fanshr.step.engine.security.domain.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 账户信息表 Mapper 接口
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}
