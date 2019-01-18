package com.pm.mc.chat.netty.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义jsonResult结果
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysResult implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 定义jackson对象
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 200	成功
     * 201	错误
     * 400	参数错误
     */
    private Integer status;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应中的数据
     */
    private Object data;

    /**
     * SysResult创建
     *
     * @param status
     * @param msg
     * @param data
     * @return
     */
    public static SysResult build(Integer status, String msg, Object data) {
        return new SysResult(status, msg, data);
    }

    /**
     * 带返回参数的成功
     *
     * @param data
     * @return
     */
    public static SysResult oK(Object data) {
        return new SysResult(data);
    }

    /**
     * 不带返回参数的成功
     *
     * @return
     */
    public static SysResult oK() {
        return new SysResult(null);
    }

    /**
     * 状态201的返回
     *
     * @return
     */
    public static SysResult fail() {
        return SysResult.build(201, "FAIL");
    }

    /**
     * 参数错误，状态400的返回
     *
     * @param data
     * @return
     */
    public static SysResult ParamError(Object data) {
        return SysResult.build(400, "ParamError", data);
    }

    /**
     * 无参构造
     */
    public SysResult() {

    }

    /**
     * SysResult的build不带参数
     *
     * @param status
     * @param msg
     * @return
     */
    public static SysResult build(Integer status, String msg) {
        return new SysResult(status, msg, null);
    }

    /**
     * 构造方法，带3个参数
     *
     * @param status
     * @param msg
     * @param data
     */
    public SysResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 默认200调用方法
     *
     * @param data
     */
    public SysResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    /**
     * 判断是否成功
     *
     * @return
     */
    public Boolean isOk() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 将json结果集转化为SysResult对象
     *
     * @param jsonData json数据
     * @param clazz    SysResult中的object类型
     * @return
     */
    public static SysResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, SysResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static SysResult format(String json) {
        try {
            return MAPPER.readValue(json, SysResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     *
     * @param jsonData json数据
     * @param clazz    集合中的类型
     * @return
     */
    public static SysResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}