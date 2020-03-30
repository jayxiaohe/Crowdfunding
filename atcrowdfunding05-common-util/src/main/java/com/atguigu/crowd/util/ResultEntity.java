package com.atguigu.crowd.util;

/**
 * 统一项目中ajax请求返回的结果
 * @author HePengTao
 *
 * @param <T>
 */
public class ResultEntity<T> {
    
    private static final String SUCCESS = "SUCCESS";

    private static final String FAILED = "FAILED";

    // 封装当前请求处理的结果
    private String result;

    // 请求处理失败时返回的错误消息
    private String message;
    
    // 要返回的数据
    private T data;

    /**
     * 请求处理成功且不需要返回数据时用的方法
     * @param <Type>
     * @return
     */
    public static <Type> ResultEntity<Type> successWithOutData() {
        return new ResultEntity<Type>(SUCCESS, null, null);
    }
    
    /**
     * 请求处理成功且不需要返回数据时用的方法
     * @param <Type>
     * @param data 要返回的数据
     * @return
     */
    public static <Type> ResultEntity<Type> successWithData(Type data) {
        return new ResultEntity<Type>(SUCCESS, null, data);
    }
    
    /**
     * 请求失败后使用的工具方法
     * @param <Type>
     * @param message 失败的错误消息
     * @return
     */
    public static <Type> ResultEntity<Type> failed(String message) {
        return new ResultEntity<Type>(FAILED, message, null);
    }
    
    public ResultEntity() {
        super();
    }

    public ResultEntity(String result, String message, T data) {
        super();
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultEntity [result=" + result + ", message=" + message + ", data=" + data + "]";
    }
}
