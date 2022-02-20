package pers.howard.personalspace.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import pers.howard.personalspace.service.RedisService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    RedisService redisService;

    private final String[] paramNames = {"userId", "token"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        String userId = null, clientValue = null;
        for (Cookie temp : cookies) {
            if (temp.getName().equals(paramNames[0]))
                userId = temp.getValue();
            else if (temp.getName().equals(paramNames[1]))
                clientValue = temp.getValue();
        }
        // 没有token
        if (userId == null || clientValue == null) {
            response.sendRedirect("/login/index");
            return false;
        }
        String serverValue = redisService.getTokenItem(userId);
        // token过期
        if (serverValue == null || !clientValue.equals(serverValue)) {
            response.sendRedirect("/login/index");
            return false;
        }
        return true;
    }
}
