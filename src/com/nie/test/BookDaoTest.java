package com.nie.test;

import com.nie.dao.BookDao;
import com.nie.dao.imp.BookDaoImpl;
import com.nie.pojo.Book;
import com.nie.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/*
 *
 *@auth  wenzhao
 *@date 2021/2/3  18:27
 */
public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "测试得第一条", "191125", new BigDecimal(9999), 1100000, 0, null
        ));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(18);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(19, "测试得第mmm条", "大哥", new BigDecimal(9999), 1100000, 0, null
        ));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(19));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10, 50));
    }

    @Test
    public void queryForPageItems() {

        for (Book book : bookDao.queryForPageItems(8, Page.PAGE_SIZE)) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageItemsByPrice() {
        for (Book book : bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE, 10, 50)) {
            System.out.println(book);
        }
    }
}