package com.matveev.serialization.entity.book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Serializable {
    private final int publishingYear;
    private final Author author;
    private final List<Page> pages = new ArrayList<>();

    public Book(int publishingYear, Author author, Page... pages) {
        this.publishingYear = publishingYear;
        this.author = author;
        this.pages.addAll(Arrays.asList(pages));
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public List<Page> getPages() {
        return pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (publishingYear != book.publishingYear) return false;
        if (!author.equals(book.author)) return false;
        return pages.equals(book.pages);
    }

    @Override
    public int hashCode() {
        int result = publishingYear;
        result = 31 * result + author.hashCode();
        result = 31 * result + pages.hashCode();
        return result;
    }
}
