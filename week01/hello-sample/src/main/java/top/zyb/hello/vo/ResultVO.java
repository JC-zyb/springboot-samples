package top.zyb.hello.vo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

/**
 * @Author : zhayubin
 * <--->
 * @Created On : 2026/3/5 17:16
 * <--->
 * @Description: 统一返回的结果
 */
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ResultVO<T> {
    /**
     * 成功状态码。
     */
    private static final Integer SUCCESS_CODE = 200;
    /**
     * 失败状态码。
     */
    private static final Integer FAIL_CODE = 500;
    /**
     * 默认成功消息。
     */
    private static final String SUCCESS_MSG = "success";
    /**
     * 默认失败消息。
     */
    private static final String FAIL_MSG = "fail";

    /**
     * 业务状态码。
     */
    private Integer code;
    /**
     * 响应消息。
     */
    private String msg;
    /**
     * 响应数据。
     */
    private T data;

    public ResultVO() {
    }

    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功返回（默认消息）。
     *
     * @param data 响应数据
     * @param <T> 数据类型
     * @return 统一返回对象
     */
    public static <T> ResultVO<T> success(T data) {
        return success(SUCCESS_MSG, data);
    }

    /**
     * 成功返回（自定义消息）。
     *
     * @param msg 成功消息
     * @param data 响应数据
     * @param <T> 数据类型
     * @return 统一返回对象
     */
    public static <T> ResultVO<T> success(String msg, T data) {
        return new ResultVO<>(SUCCESS_CODE, msg, data);
    }

    /**
     * 失败返回（默认消息）。
     *
     * @param <T> 数据类型
     * @return 统一返回对象
     */
    public static <T> ResultVO<T> fail() {
        return fail(FAIL_MSG);
    }

    /**
     * 失败返回（自定义消息）。
     *
     * @param msg 失败消息
     * @param <T> 数据类型
     * @return 统一返回对象
     */
    public static <T> ResultVO<T> fail(String msg) {
        return fail(FAIL_CODE, msg);
    }

    /**
     * 失败返回（自定义状态码与消息）。
     *
     * @param code 失败状态码
     * @param msg 失败消息
     * @param <T> 数据类型
     * @return 统一返回对象
     */
    public static <T> ResultVO<T> fail(Integer code, String msg) {
        return new ResultVO<>(code, msg, null);
    }
}
