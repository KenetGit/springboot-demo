package top.kenetgit.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import top.kenetgit.springbootdemo.interceptor.HelloInterceptor;


@Configuration
// WebMvcConfigurerAdapter已过时，建议WebMvcConfigurationSupport代替
public class WebMvcConfigurer extends WebMvcConfigurationSupport {


    /*
    * 配置拦截器
    * 向Spring容器添加拦截器
    * */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new HelloInterceptor()).addPathPatterns("/hello/**");

        super.addInterceptors(registry);
    }

    /*
    * 配置CORS
    * 关于解决跨域问题的详解：https://my.oschina.net/wangnian/blog/689020
    * */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/cors/**")
                .allowedHeaders("*")
                .allowedMethods("POST","GET")
                .allowedOrigins("*");
        super.addCorsMappings(registry);
    }

    /*
    * 配置ViewController
    * 最经常用到的就是"/"、"/index"路径请求时不通过@RequestMapping配置，而是直接通过配置文件映射指定请求路径到指定View页面
    * */
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
//        registry.addViewController("/").setViewName("/index");
//
//    }

    /*
    * 配置ViewResolver
    * 配置html、Jsp页面视图时就会用到InternalResourceViewResolver配置类
    * */

    /*
    * 配置MessageConverter
    *
    * */
}
