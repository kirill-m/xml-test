package com.matveev.serialization.entity.common;

import com.matveev.serialization.classloader.DifferentUidClassLoader;
import com.matveev.serialization.entity.common.book.BookOriginal;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.*;
import java.net.URL;

import static com.matveev.serialization.entity.common.TestData.*;
import static org.junit.Assert.*;

@RunWith(SeparateClassloaderTestRunner.class)
public class BookTest {
    private static final BookOriginal bookOriginal = getBook();
    private static final String BOOK_DIR = TestData.YEAR_TYPE_LONG_FILE;

    @Test
    public void testBookWithNoDifference() throws Exception {
        BookOriginal result = readBook(FILE_NAME);

        assertTrue(bookOriginal.equals(result));
    }

    @Test(expected = InvalidClassException.class)
    public void testBookWithDifferentUid() throws Exception {
        readBook(DIFFERENT_UID_FILE);
    }

    @Test
    public void testBookWithDeletedField() throws Exception {
        BookOriginal result = readBook(DELETE_FIELD_FILE);

        assertNull(result.getAuthor());
        assertNotEquals(bookOriginal, result);
    }

    @Test
    public void testAuthorExtendsPerson() throws Exception {
        BookOriginal result = readBook(AUTHOR_EXTENDS_PERSON_FILE);

        assertNotNull(result.getAuthor());
        assertEquals(bookOriginal, result);
    }

    @Test
    public void testBookExtendsDocument() throws Exception {
        BookOriginal result = readBook(EXTEND_DOCUMENT_FILE);

        assertEquals(bookOriginal, result);
    }

    @Test(expected = InvalidClassException.class)
    public void testYearLongTypeDocument() throws Exception {
        readBook(YEAR_TYPE_LONG_FILE);
    }

    //@BeforeClass
    public static void init() throws IOException {
        FileOutputStream out = new FileOutputStream(new File(BOOK_DIR));
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(bookOriginal);
    }

    private static BookOriginal getBook() {
        Author author = new Author("Mike");
        return new BookOriginal(2014, author);
    }

    private BookOriginal readBook(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream in = new FileInputStream(new File(fileName));
             ObjectInputStream ois = new ObjectInputStream(in)) {
            BookOriginal bookOriginal = (BookOriginal) ois.readObject();
            ois.close();
            in.close();

            return bookOriginal;
        }
    }

    public void testBookUid() throws Exception {
        ClassLoader loader = new DifferentUidClassLoader(new URL[]{new File(BOOK_DIR).toURL()},
                Thread.currentThread().getContextClassLoader());
        Class<?> clazz = loader.loadClass("com.matveev.serialization.entity.common.book.BookOriginal");
        BookOriginal book = (BookOriginal) clazz.newInstance();
        FileInputStream in = new FileInputStream(new File(BOOK_DIR));
        ObjectInputStream ois = new ObjectInputStream(in);
        book = (BookOriginal) ois.readObject();
    }
}
