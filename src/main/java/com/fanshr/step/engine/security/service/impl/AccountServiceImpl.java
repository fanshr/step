package com.fanshr.step.engine.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanshr.step.engine.security.domain.entity.Account;
import com.fanshr.step.engine.security.dao.AccountMapper;
import com.fanshr.step.engine.security.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账户信息表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}
