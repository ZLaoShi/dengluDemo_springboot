package com.example.entity.vo.response;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@TableName("news_data")
@AllArgsConstructor
public class News {
    String title;
    String content;
    String url;
    Integer nid;
}