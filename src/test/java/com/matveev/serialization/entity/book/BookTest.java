package com.matveev.serialization.entity.book;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.*;

public class BookTest {
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private final String fileName = "book/book.txt";

    @Test
    public void testBookSerialization() throws IOException, ClassNotFoundException {
        Book book = getBook(100);

        oos.writeObject(book);
        Book result = (Book) ois.readObject();

        assertTrue(book.equals(result));
    }

    private Book getBook(int pagesNumber) {
        Page[] pages = new Page[pagesNumber];
        for (int i = 0; i < 100; i++) {
            pages[i] = new Page("Text on " + i + " page", i + 1);
        }

        Author author = new Author("Steven");

        return new Book(2017, author, pages);
    }

    @Before
    public void init() throws IOException {
        String file = getClass().getClassLoader().getResource(fileName).getFile();
        FileOutputStream out = new FileOutputStream(file);
        oos = new ObjectOutputStream(out);

        FileInputStream in = new FileInputStream(file);
        ois = new ObjectInputStream(in);
    }

    @After
    public void after() throws IOException {
        oos.flush();
        oos.close();
        ois.close();
    }
}
