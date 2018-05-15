package com.job.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Daejong on 2017/10/20.
 */
@Controller
public class ErrorController {

    @GetMapping(value = "/400")
    public String badRequest() {
        return "error/400";
    }

    @GetMapping(value = "/404")
    public String notFound() {
        return "error/404";
    }

    @GetMapping(value = "/500")
    public String innerServerError() {
        return "error/500";
    }

    // 配置默认页面
    @GetMapping(value = "/")
    public String hello() {
        return "shouye";
    }

}
