package com.matveev.serialization.entity.common;

import com.matveev.serialization.classloader.DifferentUidClassLoader;
import com.matveev.serialization.entity.common.book.Book;
import com.matveev.serialization.entity.common.book.BookOriginal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;

public class BookTest {
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private boolean isInit = false;

    private static final String FILE_NAME = "/Users/kirill/IdeaProjects/xml-test/serialized-book/book.txt";
    private static final String DIFFERENT_UID = "/Users/kirill/IdeaProjects/xml-test/jar/different-uid.jar";

    @Test
    public void testBookSerialization() throws IOException, ClassNotFoundException {
        BookOriginal bookOriginal = getBook(100);

        oos.writeObject(bookOriginal);
        BookOriginal result = (BookOriginal) ois.readObject();

        assertTrue(bookOriginal.equals(result));
    }

    @Test
    public void testBookWithDifferentUid() throws Exception {
        FileInputStream in = new FileInputStream(new File(FILE_NAME));
        ois = new ObjectInputStream(in);

        DifferentUidClassLoader loader = new DifferentUidClassLoader(new URL[]{new File(DIFFERENT_UID).toURL()},
                Thread.currentThread().getContextClassLoader());
        Class<?> clazz = loader.loadClass("com.matveev.serialization.entity.common.book.BookOriginal");
        BookOriginal book = (BookOriginal) clazz.newInstance();
        book = (BookOriginal) ois.readObject();
    }


    private BookOriginal getBook(int pagesNumber) {
        Page[] pages = new Page[pagesNumber];
        for (int i = 0; i < 100; i++) {
            pages[i] = new Page("Text on " + i + " page", i + 1);
        }

        Author author = new Author("Steven");

        return new BookOriginal(2017, author, pages);
    }

    //@Before
    public void init() throws IOException {
        if (!isInit) {
            //String file = getClass().getClassLoader().getResource(FILE_NAME).getFile();
            FileOutputStream out = new FileOutputStream(new File(FILE_NAME));
            oos = new ObjectOutputStream(out);

            FileInputStream in = new FileInputStream(new File(FILE_NAME));
            ois = new ObjectInputStream(in);

            isInit = true;
        }
    }

    @After
    public void after() throws IOException {
        //oos.flush();
        //oos.close();
        ois.close();
    }
}
