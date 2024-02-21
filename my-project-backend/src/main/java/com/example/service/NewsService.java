package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.dto.Account;
import com.example.entity.vo.response.News;

import java.util.List;

public interface NewsService{
    List<News> getNewsList();

    News getNewsNid(int nid);
}
