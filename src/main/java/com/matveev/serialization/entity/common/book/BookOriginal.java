package com.matveev.serialization.entity.common.book;

import com.matveev.serialization.entity.common.Author;
import com.matveev.serialization.entity.common.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookOriginal implements Book, Serializable {
    private static final long serialVersionUID = -9151124920686776900L;

    private int publishingYear;
    private Author author;
    private List<Page> pages = new ArrayList<>();

    public BookOriginal(int publishingYear, Author author, Page... pages) {
        this.publishingYear = publishingYear;
        this.author = author;
        this.pages.addAll(Arrays.asList(pages));
    }

    public BookOriginal() {}

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

        BookOriginal bookOriginal = (BookOriginal) o;

        if (publishingYear != bookOriginal.publishingYear) return false;
        if (!author.equals(bookOriginal.author)) return false;
        return pages.equals(bookOriginal.pages);
    }

    @Override
    public int hashCode() {
        int result = publishingYear;
        result = 31 * result + author.hashCode();
        result = 31 * result + pages.hashCode();
        return result;
    }
}
