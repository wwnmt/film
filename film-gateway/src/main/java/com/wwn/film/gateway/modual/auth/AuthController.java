package com.wwn.film.gateway.modual.auth;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wwn.film.api.service.user.UserService;
import com.wwn.film.gateway.modual.auth.dto.AuthRequest;
import com.wwn.film.gateway.modual.auth.dto.AuthResponse;
import com.wwn.film.gateway.response.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 请求验证的
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:22
 */
@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Reference(interfaceClass = UserService.class, check = false)
    private UserService userService;

    @RequestMapping(value = "${jwt.auth-path}")
    public ResponseVO<?> createAuthenticationToken(AuthRequest authRequest) {

        boolean validate = true;
        int userId = userService.login(authRequest.getUserName(),authRequest.getPassword());
        if(userId==0){
            validate = false;
        }

        if (validate) {
            // randomKey和token已经生成完毕
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(""+userId, randomKey);
            // 返回值
            return ResponseVO.success(new AuthResponse(token, randomKey));
        } else {
            return ResponseVO.serviceFail("用户名或密码错误");
        }
    }
}
