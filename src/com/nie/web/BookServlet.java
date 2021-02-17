package com.nie.web;/*
 *
 *@auth  wenzhao
 *@date 2021/2/3  21:07
 */

import com.nie.pojo.Book;
import com.nie.pojo.Page;
import com.nie.service.BookService;
import com.nie.service.impl.BookServiceImpl;
import com.nie.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();


    /**
     * 添加
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo=WebUtils.parseInt(req.getParameter("pageNo"),0);
        pageNo+=1;
        //        1、获取请求的参数==封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
//        2、调用BookService.addBook()保存图书
        bookService.addBook(book);
//        3、跳到图书列表页面
//                /manager/bookServlet?action=list
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);

        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);

    }

    /**
     * 显示要修改修改的数据
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2 调用bookService.queryBookById查询图书
        Book book = bookService.queryBookById(id);
        //3 保存到图书到Request域中
        req.setAttribute("book", book);
        //4 请求转发到。pages/manager/book_edit.jsp页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }


    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、获取请求的参数id，图书编程
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
//        2、调用bookService.deleteBookById();删除图书
        bookService.deleteBookById(id);
//        3、重定向回图书列表管理页面
//                /book/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }


    /**
     * 遍历所有数据
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 通过BookService查询群不图书
        List<Book> books = bookService.queryBooks();
        //2 把全吧图书保存到Request狱中
        req.setAttribute("books", books);
        //3 请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }


    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、获取请求的参数==封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
//        2、调用BookService.updateBook( book );修改图书
        bookService.updateBook(book);
//        3、重定向回图书列表管理页面
//        地址：/工程名/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }


    /**
     * 分页处理
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求的参数pageno和pangesize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //调用BookService.page(pageNo,pageSize):page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=page");
        //3保存page对象到Request中
        req.setAttribute("page", page);

        //4 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

}
