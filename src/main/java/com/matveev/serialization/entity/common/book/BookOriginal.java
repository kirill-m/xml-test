package com.matveev.serialization.entity.common.book;

import com.matveev.serialization.entity.common.Author;

import java.io.Serializable;

public class BookOriginal implements Book, Serializable {
    private static final long serialVersionUID = -9151124920686776900L;

    private final int publishingYear;
    private final Author author;

    public BookOriginal(int publishingYear, Author author) {
        this.publishingYear = publishingYear;
        this.author = author;
    }

    @Override
    public int getPublishingYear() {
        return publishingYear;
    }


    public Author getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookOriginal that = (BookOriginal) o;

        if (publishingYear != that.publishingYear) return false;
        return author != null ? author.equals(that.author) : that.author == null;

    }

    @Override
    public int hashCode() {
        int result = publishingYear;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}
