package top.kenetgit.springbootdemo.interceptor;


import com.alibaba.druid.support.json.JSONUtils;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.kenetgit.springbootdemo.util.JSONResult;
import top.kenetgit.springbootdemo.util.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class HelloInterceptor implements HandlerInterceptor {
    /*
    * 在请求处理之前进行调用 ，即Controller方法被调用之前
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("in HelloInterceptor preHandle is called....");

        returnErrorResponse(response, JSONResult.errorMsg("intercepted by HelloInterceptor."));
        return false;
//        return true;
    }

    /*
    * 请求处理之后，但在视图被渲染之前调用，即Controller方法执行之后
    * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    /*
    * 整个请求结束之后调用，也就是在DispatcherServlet完成视图渲染之后，主要用于清理资源
    * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }

    public void returnErrorResponse(HttpServletResponse response, JSONResult result) throws IOException {

        OutputStream outputStream = null;
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json");
            outputStream = response.getOutputStream();
            outputStream.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null)
                    outputStream.close();
        }
    }
}
