package kr.co.ureca.blog.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.SerializationUtils;

import java.util.Base64;

public class CookieUtil {
    //요청값을 바탕으로 쿠키 추가
    public static void addCookie(HttpServletResponse response
                                        , String name, String value, int maxAge){
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");                    //클라이언트가 쿠키를 반환하는 위치 설정
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    //쿠키 이름을 입력 받아 삭제
    public static void deleteCookie(HttpServletRequest request
                                    , HttpServletResponse response
                                    , String name){
        Cookie[] cookies = request.getCookies();
        if(cookies==null){
            return;
        }
        for(Cookie cookie : cookies){
            if(name.equals(cookie.getName())){
                cookie.setValue("");
                cookie.setPath("/");
                cookie.setMaxAge(0);        //창 닫으면 쿠키가 삭제되게 MaxAge 설정
                response.addCookie(cookie);
            }
        }
    }

    //객체를 직렬화 해 쿠키 값으로 변환
    public static String serialize(Object obj){
        return Base64.getEncoder()
                        .encodeToString(SerializationUtils.serialize(obj));
    }

    //쿠키를 역직렬화를 통해 객체로 반환
    public static <T> T deSerialize(Cookie cookie, Class<T> cls){
        return cls.cast(
                SerializationUtils.deserialize(
                        Base64.getUrlDecoder().decode(cookie.getValue())
                )
        );
    }
}
