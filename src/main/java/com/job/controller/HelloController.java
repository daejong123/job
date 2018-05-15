package com.job.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.job.entity.JobEntity;
import com.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Daejong on 2017/10/20.
 */
@Controller
@RequestMapping(value = "/search")
public class HelloController {

    @Autowired
    private JobService jobService;

    // 配置默认页面
    @GetMapping(value = "/")
    public String hello() {
        return "index";
    }

//    @GetMapping(value = "/all")
//    public String all(Model model) {
//        List<JobEntity> list = jobService.findAll();
//        model.addAttribute("list", list);
//        return "list";
//    }

    @GetMapping(value = "/page")
    public ModelAndView all(@RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "searchKey", defaultValue = "", required = false) String key,
                            @RequestParam(value = "searchCondition", defaultValue = "", required = false) String condition,
                            ModelAndView modelAndView) {
        PageHelper.startPage(page, 10);
//        List<JobEntity> list = jobService.findAll();
        List<JobEntity> list = jobService.findByCondition(key);
        PageInfo<JobEntity> jobEntityPageInfo = new PageInfo<>(list);
//        if (condition != null && !condition.equals("")) {
//            jobEntityPageInfo.getList().sort(Comparator.comparing(jobEntity -> {
//                String[] split = jobEntity.getSalary().split("-");
//                String s = split[0];
//                return Integer.valueOf(s);
//            }));
//        }
//        jobEntityPageInfo.getList().forEach(jobEntity -> {
//            System.out.println(jobEntity.getSalary());
//        });
        modelAndView.addObject("pageInfo", jobEntityPageInfo);
        modelAndView.addObject("list", list);
        modelAndView.setViewName("list");
        modelAndView.addObject("searchKey", key);
        return modelAndView;
    }
//    @Autowired
//    private JobMapper jobMapper;
//
//    @GetMapping(value = "/test")
//    @ResponseBody
//    public String test() {
//        List<JobEntity> jobEntityList = jobMapper.fingByCondition("上海");
//        return jobEntityList.toString();
//    }

}
