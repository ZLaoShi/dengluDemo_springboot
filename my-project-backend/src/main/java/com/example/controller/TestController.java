package com.example.controller;

import com.example.entity.RestBean;
import com.example.entity.vo.response.News;
import com.example.service.NewsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jipiao")
public class TestController {
    @Resource
    NewsService service;


    @GetMapping("/hello")
    public String test() {
        return "hello world!";
    }

    @PostMapping("/")
    public RestBean getNewsnid(@RequestBody News news) {
        int nid =  news.getNid();
        News news01 = service.getNewsNid(nid);

        return RestBean.success(news01);
    }



}
