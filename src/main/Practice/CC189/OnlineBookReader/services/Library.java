package main.Practice.CC189.OnlineBookReader.services;

import main.Practice.CC189.OnlineBookReader.models.Book;

import java.util.Map;

public class Library {
    private Map<Integer, Book> books;

    public Book addBook(int id, String details) {
        if (books.containsKey(id)) {
            return null;
        }

        Book book = new Book(id, details);
        books.put(id, book);
        return book;
    }

    public boolean removeBook(Book book) {
        return removeBook(book.getId());
    }

    public boolean removeBook(int id) {
        Book book = books.getOrDefault(id, null);
        if (book == null) {
            return false;
        } else {
            books.remove(id);
        }
        return true;
    }

    public Book find(Book book) {
        return find(book.getId());
    }

    public Book find(int id){
        return books.getOrDefault(id, null);
    }
}
