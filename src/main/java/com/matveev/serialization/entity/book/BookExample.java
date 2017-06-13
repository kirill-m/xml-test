package com.matveev.serialization.entity.book;

import java.io.*;

public class BookExample {
    private static final BookWithUid book = getBook(100);
    private static final String FILE_NAME = "book/book.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        write();
        BookWithUid bookWithUid = read();
        System.out.println(bookWithUid);
    }

    private static BookWithUid getBook(int pagesNumber) {
        Page[] pages = new Page[pagesNumber];
        for (int i = 0; i < 100; i++) {
            pages[i] = new Page("Text on " + (i + 1) + " page", i + 1);
        }

        Author author = new Author("Mike");

        return new BookWithUid(2017, author, pages);
    }

    private static void write() throws IOException {
        String file = BookExample.class.getClassLoader().getResource(FILE_NAME).getFile();
        FileOutputStream out = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(book);
        oos.flush();
        oos.close();
    }

    private static BookWithUid read() throws IOException, ClassNotFoundException {
        String file = BookExample.class.getClassLoader().getResource(FILE_NAME).getFile();
        FileInputStream in = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(in);

        return (BookWithUid) ois.readObject();
    }
}
