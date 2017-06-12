package com.matveev.serialization.entity.book;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BookExample {
    private static final Book book = getBook(100);

    public static void main(String[] args) throws IOException {
        String file = BookExample.class.getClassLoader().getResource("book/book.txt").getFile();
        FileOutputStream out = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(book);
        oos.flush();
        oos.close();
    }

    private static Book getBook(int pagesNumber) {
        Page[] pages = new Page[pagesNumber];
        for (int i = 0; i < 100; i++) {
            pages[i] = new Page("Text on " + i + " page", i + 1);
        }

        Author author = new Author("Steven");

        return new Book(2017, author, pages);
    }
}
