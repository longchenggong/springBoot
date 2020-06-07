package com.ello.oa.shiro.service;

import com.ello.oa.common.ShiroUtils;
import com.ello.oa.common.config.DateUtils;
import com.ello.oa.common.constant.Constants;
import com.ello.oa.common.enums.UserStatus;
import com.ello.oa.common.exception.user.UserDeleteException;
import com.ello.oa.common.exception.user.UserNotExistsException;
import com.ello.oa.common.utils.MessageUtils;
import com.ello.oa.domain.SysUser;
import com.ello.oa.manager.AsyncFactory;
import com.ello.oa.manager.AsyncManager;
import com.ello.oa.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.validation.constraints.NotNull;

/**
 * @create 2020/5/7  15:45 author：longchenggong
 */
@Component
public class SysLoginService {

    @Autowired
    private SysPasswordService passwordService;

    @Autowired
    private ISysUserService userService;
    //登陆
    public SysUser login(@NotNull String userName, @NotNull String password){
      //  AsyncManager.getInstance().execute(AsyncFactory.recordLogininfor(userName, Constants.LOGIN_FAIL, MessageUtils.message("not.null")));

        // 查询用户信息
        SysUser user = userService.selectUserByLoginName(userName);

        //校验
        if (user == null)
        {
            AsyncManager.getInstance().execute(AsyncFactory.recordLogininfor(userName, Constants.LOGIN_FAIL, MessageUtils.message("user.not.exists")));
            throw new UserNotExistsException();
        }
        if (UserStatus.DELETED.getCode().equals(user.getDelFlag())) {
            AsyncManager.getInstance().execute(AsyncFactory.recordLogininfor(userName, Constants.LOGIN_FAIL, MessageUtils.message("user.password.delete")));
            throw new UserDeleteException();
        }
        recordLoginInfo(user);
        return user;
    }

    /**
     * 记录登录信息
     */
    public void recordLoginInfo(SysUser user)
    {
        user.setLoginIp(ShiroUtils.getIp());
        user.setLoginDate(DateUtils.getNowDate());
        userService.updateUserInfo(user);
    }
}
