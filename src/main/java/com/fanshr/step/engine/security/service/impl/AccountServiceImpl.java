package com.fanshr.step.engine.security.service.impl;

import com.fanshr.step.engine.security.entity.Account;
import com.fanshr.step.engine.security.mapper.AccountMapper;
import com.fanshr.step.engine.security.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账户信息表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}