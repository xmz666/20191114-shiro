package com.aaa.xmz.shiro.controller;


import com.aaa.xmz.shiro.model.Book;
import com.aaa.xmz.shiro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Company AAA软件教育
 * @Author xmz
 * @Date Create in 2019/10/12 17:28
 * @Description
 **/
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * @author xmz
     * @description
     *      ModelMap
     *      Model
     *      ModelAndView
     *      都能返回数据
     *      Model和ModelAndView返回的数据格式就是常规格式
     *     ModelMap:
     *          会把返回的常规格式转换为key:value类型
     * @param [modelMap]
     * @date 2019/10/12
     * @return java.lang.String
     * @throws 
    **/
    @RequestMapping("/allBooks")
    public String turnBookIndex(ModelMap modelMap) {
        // 需要从数据库中把所有的图书信息查询并返回到页面上
        Map<String, Object> resultMap = bookService.selectAllBooks();
        // 可以做判断-->以后还是不能(全是ajax)
        if("200".equals((String)resultMap.get("code")) && null != resultMap.get("data")) {
            modelMap.addAttribute("bookList", (List<Book>)resultMap.get("data"));
            return "book_index";
        }
        return "404";
    }

    /**
     * 只负责跳转页面
     * @return
     */
    @RequestMapping("/addBook")
    public String addBook() {


        return "addBook";
    }

    /**
     * 通过id删除数据库的信息
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping("/deleteBookById")
    public String deleteBookById(long id,ModelMap modelMap) {
        //通过id删除book
        bookService.deleteBookById(id);
        //删除之后跳转到主页,并展示删除之后的信息
        Map<String, Object> resultMap = bookService.selectAllBooks();
        // 可以做判断-->以后还是不能(全是ajax)
        if("200".equals((String)resultMap.get("code")) && null != resultMap.get("data")) {
            modelMap.addAttribute("bookList", (List<Book>)resultMap.get("data"));
            return "book_index";
        }
        return "404";
    }

    /**
     * 跳转到toUpdate页面,并把book的信息传给页面
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping("/toUpdateBookById")
    public String toUpdateBookById(long id,ModelMap modelMap) {
        //通过id获取book的信息,并返回给toUpdate页面
        Book book = bookService.toUpdateBookById(id);
       modelMap.addAttribute("book",book);

        return "toUpdate";
    }

    /**
     * 更新book信息,并传给数据库
     * @param book
     * @param modelMap
     * @return
     */
    @RequestMapping("/updateBook")
    public String updateBook(Book book,ModelMap modelMap) {
        //将toUpdate页面的book信息,接收回来,并更改数据库
        bookService.updateBookById(book);
        //更新之后跳转到主页,并展示添更新之后的信息
        Map<String, Object> resultMap = bookService.selectAllBooks();
        // 可以做判断-->以后还是不能(全是ajax)
        if("200".equals((String)resultMap.get("code")) && null != resultMap.get("data")) {
            modelMap.addAttribute("bookList", (List<Book>)resultMap.get("data"));
            return "book_index";
        }
        return "404";
    }

    /**
     * 通过接收前台的book信息,并添加到数据库
     * @param book
     * @param modelMap
     * @return
     */
    @RequestMapping("/insertBook")
    public String insertBook(Book book,ModelMap modelMap) {
        //将addbook页面的book信息,接收回来,并增加到数据库
        bookService.addBook(book);
        //添加之后跳转到主页,并展示添加之后的信息
        Map<String, Object> resultMap = bookService.selectAllBooks();
        // 可以做判断-->以后还是不能(全是ajax)
        if("200".equals((String)resultMap.get("code")) && null != resultMap.get("data")) {
            modelMap.addAttribute("bookList", (List<Book>)resultMap.get("data"));
            return "book_index";
        }
        return "404";
    }
}
