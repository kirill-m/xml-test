package com.matveev.serialization.entity.common.book;

import com.matveev.serialization.entity.common.Author;
import com.matveev.serialization.entity.common.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookWithDifferentUid implements Book, Serializable {
    private static final long serialVersionUID = -9151124920686776577L;
    private final int publishingYear;
    private final Author author;
    private final List<Page> pages = new ArrayList<>();

    public BookWithDifferentUid(int publishingYear, Author author, Page... pages) {
        this.publishingYear = publishingYear;
        this.author = author;
        this.pages.addAll(Arrays.asList(pages));
    }

    @Override
    public int getPublishingYear() {
        return publishingYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookWithDifferentUid book = (BookWithDifferentUid) o;

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
