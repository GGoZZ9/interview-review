package cn.oldensheepdog.testannotation.model;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;


public class Response<T> implements Serializable{

    private static final long serialVersionUID = -5579809353871767251L;
    private T data;

    private Integer code;

    private String message;

    public Response(T data, Integer code, String message){
        super();
        this.data=data;
        this.code=code;
        this.message=message;
    }

    public T getData() {
        return data;
    }

    public void setData(){
        this.data=data;
    }

    public Integer getCode(){
        return code;
    }

    public void setCode(){
        this.code=code;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(){
        this.message=message;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
