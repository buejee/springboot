package com.xxx.springboot.config.shiro.filter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.web.filter.authc.PassThruAuthenticationFilter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class MyPasswordThruAuthenticationFilter extends PassThruAuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if(this.isLoginRequest(request, response)){
            return true;
        }else{
            this.saveRequestAndRedirectToLogin(request, response);
            return false;
        }
    }

    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletResponse servletResponse = (HttpServletResponse)response;
        servletResponse.setHeader("Access-Control-Allow-Origin","*");
        servletResponse.setHeader("Access-Control-Allow-Credentials","true");
        servletResponse.setHeader("Access-Control-Max-Age","3600");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Map<String,Object> result = new HashMap<>();
        result.put("code",401);
        result.put("msg","未认证");
        ObjectMapper mapper = new ObjectMapper();
        String res = mapper.writeValueAsString(result);
        out.println(res);
        out.flush();
        out.close();
    }
}
