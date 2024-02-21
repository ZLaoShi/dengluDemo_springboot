package com.example.controller;

import com.example.entity.RestBean;
import com.example.entity.vo.response.News;
import com.example.service.NewsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Resource
    NewsService service;

    @GetMapping("/neirong")
    public RestBean getNewsContent()  {

        return RestBean.success(service.getNewsList());
    }

    @PostMapping("/nidxiangxi")
    public RestBean getNewsnid(@RequestBody News news) {
        int nid =  news.getNid();
        News news01 = service.getNewsNid(nid);

        return RestBean.success(news01);
    }

    @GetMapping("/test")
    public String  test()  {

        return "test";
    }
}
