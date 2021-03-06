package com.example.staffhouse.filter;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.example.staffhouse.config.PassToken;
import com.example.staffhouse.entity.UserInfo;
import com.example.staffhouse.service.UserService;
import com.example.staffhouse.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class JwtAuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserService accountService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 从请求头中取出 token  这里需要和前端约定好把jwt放到请求头一个叫token的地方
        String token = httpServletRequest.getHeader("token");
        if (!(httpServletRequest.getRequestURI().equalsIgnoreCase("/error"))){
            // 如果不是映射到方法直接通过
            if (!(object instanceof HandlerMethod)) {
                return true;
            }
            HandlerMethod handlerMethod = (HandlerMethod) object;
            Method method = handlerMethod.getMethod();
            //检查是否有passtoken注释，有则跳过认证
            if (method.isAnnotationPresent(PassToken.class)) {
                PassToken passToken = method.getAnnotation(PassToken.class);
                if (passToken.required()) {
                    return true;
                }
            }
            //默认全部检查
            else {
                // 执行认证
                if (token == null) {
                    //这里其实是登录失效,没token了
                    throw new RuntimeException("无token，请重新登录");
                }

                // 获取 token 中的 userId
                String userId;
                try{
                    userId = JwtUtils.getAudience(token);
                }
                catch (JWTDecodeException e){
                    throw new RuntimeException("401");
                }


                //找找看是否有这个user   因为我们需要检查用户是否存在，读者可以自行修改逻辑
                UserInfo user = accountService.getUserInfoById(Integer.valueOf(userId));

                if (user == null) {
                    throw new RuntimeException("用户不存在");
                }

                // 验证 token
                JwtUtils.verifyToken(token, userId);

                return true;

            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
