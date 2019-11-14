package com.aaa.xmz.shiro.service;

import com.aaa.xmz.shiro.mapper.BookMapper;
import com.aaa.xmz.shiro.model.Book;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Company AAA软件教育
 * @Author xmz
 * @Date Create in 2019/10/13 17:30
 * @Description
 **/
@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    /**
     * @author  xmz
     * @description
     *      查询所有的图书信息
     * @param []
     * @date 2019/10/13
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @throws 
    **/
    public Map<String, Object> selectAllBooks() {
        Map<String, Object> reusltMap = new HashMap<String, Object>();
        List<Book> bookList = bookMapper.selectAll();
        if(bookList.size() > 0) {
            reusltMap.put("code", "200");
            reusltMap.put("data", bookList);
        } else {
            reusltMap.put("code", "400");
            reusltMap.put("msg", "暂时没有图书！");
        }
        return reusltMap;
    }

    /**
     * @author  xmz
     * @description
     *      新增图书
     * @param [book]
     * @date 2019/10/13
     * @return java.lang.String
     * @throws 
    **/
    @RequiresPermissions("book:insert")
    public int addBook(Book book) {
        int i = bookMapper.insert(book);
        return i;
    }

    /**
     * 通过id删除book
     * @param id
     */
    @RequiresPermissions("book:delete")
    public void deleteBookById(long id){
        bookMapper.deleteByPrimaryKey(id);
    }

    /**
     * 通过id获取需要更新的book信息
     * @param id
     * @return
     */
    @RequiresPermissions("book:update")
    public Book toUpdateBookById(long id){
        return  bookMapper.selectByPrimaryKey(id);
    }

    /**
     *前台传输数据更新book信息
     * @param book
     * @return
     */


    public int updateBookById(Book book){
        int i = bookMapper.updateByPrimaryKey(book);
        return i;

    }
}
