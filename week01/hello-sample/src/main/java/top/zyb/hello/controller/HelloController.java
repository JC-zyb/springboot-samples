package top.zyb.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zyb.hello.vo.ResultVO;

/**
 * @Author : zhayubin
 * <--->
 * @Created On : 2026/3/5 17:20
 * <--->
 * @Description: HelloController接口控制
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    /**
     * 返回欢迎信息。
     *
     * @return 统一返回结果
     */
    @GetMapping("/hello")
    public ResultVO<String> hello() {
        return ResultVO.success("Hello Spring Boot");
    }
}
