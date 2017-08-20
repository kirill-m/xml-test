package com.matveev.serialization.entity.common.book;

import com.matveev.serialization.entity.common.Author;
import com.matveev.serialization.entity.common.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookWithUid implements Book, Serializable {
    private static final long serialVersionUID = -9151124920686776596L;
    private final int publishingYear;
    private final Author author;
    private final List<Page> pages = new ArrayList<>();

    public BookWithUid(int publishingYear, Author author, Page... pages) {
        this.publishingYear = publishingYear;
        this.author = author;
        this.pages.addAll(Arrays.asList(pages));
    }

    @Override
    public int getPublishingYear() {
        return publishingYear;
    }

    @Override
    public List<Page> getPages() {
        return pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookWithUid book = (BookWithUid) o;

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

    @Override
    public String toString() {
        return "BookWithUid{" +
                "publishingYear=" + publishingYear +
                ", author=" + author +
                ", pages=" + pages +
                '}';
    }
}
