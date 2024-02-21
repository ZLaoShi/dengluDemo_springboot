package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.vo.response.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NewsMapper extends BaseMapper<News> {
    @Select("SELECT * FROM news_data WHERE nid = #{nid}")
    News getNewsNid(int nid);
}
