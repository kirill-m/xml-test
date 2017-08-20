package com.sbt.matveev.jaxb;

import com.matveev.serialization.entity.common.Author;
import com.matveev.serialization.entity.common.Page;
import com.sbt.matveev.jaxb.entity.MutableBook;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class JAXBExample {
    public static void main(String[] args) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(MutableBook.class);
        MutableBook book = getBook(100);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        String filerName = JAXBExample.class.getClassLoader().getResource("jaxb/book.xml").getFile();
        File file = new File(filerName);
        jaxbMarshaller.marshal(book, file);
        jaxbMarshaller.marshal(book, System.out);
    }

    private static MutableBook getBook(int pagesNumber) {
        Page[] pages = new Page[pagesNumber];
        for (int i = 0; i < 100; i++) {
            pages[i] = new Page("Text on " + (i + 1) + " page", i + 1);
        }

        Author author = new Author("Mike");
        MutableBook book = new MutableBook();
        book.setAuthor(author);
        book.setPublishingYear(2017);
        book.setPages(Arrays.asList(pages));

        return book;
    }
}
