package pers.howard.personalspace.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
public class ToolKit {

    @Value("${local.token.keep-time}")
    private String hourTime;

    public Cookie getSingleCookieAtName(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            return null;
        for (Cookie temp : cookies) {
            if (temp.getName().equals(name))
                return temp;
        }
        return null;
    }

    public int getTokenKeepTimeInSecond() {
        int coverTime = Integer.valueOf(hourTime);
        return coverTime * 60 * 60;
    }
}
