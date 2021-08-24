package com.wzb.controller;

/**
 * @Author Administrator
 * @Date 2021/8/24 0024 13:28
 */

import com.wzb.util.HttpClientUtils;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class githubLogin {
    private static String GITHUB_CLIENT_ID = "bc45f7da238826f3b77e";
    private static String GITHUB_CLIENT_SECRET = "1a6ea9d5b73e6fb3108bc9716d7234c11b1260ea";
    private static String GITHUB_REDIRECT_URL = "http://127.0.0.1:8888/githubCallback";

    public githubLogin() {
    }

    @RequestMapping({"/githubLogin"})
    public void githubLogin(HttpServletResponse response) throws Exception {
        String url = "https://github.com/login/oauth/authorize";
        String state = "200";
        String param = "response_type=code&client_id=" + GITHUB_CLIENT_ID + "&state=" + state + "&redirect_uri=" + GITHUB_REDIRECT_URL;
        response.sendRedirect(url + "?" + param);
    }

    @RequestMapping({"/githubCallback"})
    public void githubCallback(String code, String state, HttpServletResponse response) throws Exception {
        if (!"200".equals(state)) {
            throw new Exception("State验证失败");
        } else {
            String url = "https://github.com/login/oauth/access_token";
            String param = "grant_type=authorization_code&code=" + code + "&redirect_uri=" + GITHUB_REDIRECT_URL + "&client_id=" + GITHUB_CLIENT_ID + "&client_secret=" + GITHUB_CLIENT_SECRET;
            boolean b = true;
            String result = HttpClientUtils.sendPostRequest(url, param, b);
            Map<String, String> resultMap = HttpClientUtils.params2Map(result);
            System.out.println(resultMap);
            if (resultMap.containsKey("error")) {
                throw new Exception((String)resultMap.get("error_description"));
            } else if (!resultMap.containsKey("access_token")) {
                throw new Exception("获取token失败");
            } else {
                String accessToken = (String)resultMap.get("access_token");
                String tokenType = (String)resultMap.get("token_type");
                String userUrl = "https://api.github.com/user";
                String userParam = "access_token=" + accessToken + "&token_type=" + tokenType;
                String userResult = HttpClientUtils.sendGetRequest(userUrl, userParam);
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write(userResult);
            }
        }
    }
}

