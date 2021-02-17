package com.nie.test;

import com.nie.pojo.Book;
import com.nie.pojo.Page;
import com.nie.service.BookService;
import com.nie.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/*
 *
 *@auth  wenzhao
 *@date 2021/2/3  18:36
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "应该可以成功都额", "1125", new BigDecimal(1000000), 100000000, 0, null));

    }

    @Test
    public void deleteBookById() {

        bookService.deleteBookById(20);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(20, "我是修改的！", "1125", new BigDecimal(999999), 10, 111110, null));

    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE ));
    }
    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,10,50 ));
    }

}