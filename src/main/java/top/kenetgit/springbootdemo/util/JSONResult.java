package top.kenetgit.springbootdemo.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/*
* @Description: 自定义响应JSON的数据结构
*               200: 表示成功
*               500: 表示错误，错误信心写在msg字段
*
*
* */
public class JSONResult {

    private static final ObjectMapper MAPPER = new ObjectMapper();


    private Integer status; // 请求处理状态
    private String msg;     // 反馈信息
    private Object data;    // 返回的数据

    public static JSONResult build(Integer status, String msg, Object data) {
        return new JSONResult(status, msg, data);
    }

    public static JSONResult okBuild(Object data) {
        return new JSONResult(data);
    }

    public static JSONResult errorMsg(String error) {
        return new JSONResult(500,error,null);
    }

    public JSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JSONResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public boolean isOk() {
        return this.status == 200;
    }
}
