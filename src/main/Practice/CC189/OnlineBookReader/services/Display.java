package main.Practice.CC189.OnlineBookReader.services;

import main.Practice.CC189.OnlineBookReader.models.Book;
import main.Practice.CC189.OnlineBookReader.models.User;

public class Display {
    private Book book;
    private User user;
    private int pageNumber;

    public Display(Book book, User user, int pageNumber) {
        this.book = book;
        this.user = user;
        this.pageNumber = pageNumber;
    }

    public Display() {

    }

    public void switchUser(User user) {
        this.user = user;
        this.book = null;
        refresh();
    }

    public void nextPage() {
        pageNumber++;
        refreshPage();
    }

    public void previousPage() {
        pageNumber--;
    }

    public void jumpToPage(int pageNumber) {
        this.pageNumber = pageNumber;
        refreshPage();
    }

    private void refreshPage() {
    }

    public void switchBook(Book book) {
        this.book = book;
        pageNumber = 0;
        refresh();
    }

    private void refresh() {

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
