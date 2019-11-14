package com.aaa.xmz.shiro.mapper;


import com.aaa.xmz.shiro.model.Book;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Book record);

    Book selectByPrimaryKey(Long id);

    List<Book> selectAll();

    int updateByPrimaryKey(Book record);
}