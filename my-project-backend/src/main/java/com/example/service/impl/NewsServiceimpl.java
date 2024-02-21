package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.vo.response.News;
import com.example.mapper.NewsMapper;
import com.example.service.NewsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceimpl extends ServiceImpl<NewsMapper, News> implements NewsService {
    @Resource
    NewsMapper newsMapper;

    @Override
    public List<News> getNewsList() {

        return list();
    }

    @Override
    public News getNewsNid(int nid) {
        return newsMapper.getNewsNid(nid);
    }
}
