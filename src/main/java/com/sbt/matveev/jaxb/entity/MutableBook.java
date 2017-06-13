package com.sbt.matveev.jaxb.entity;

import com.matveev.serialization.entity.book.Author;
import com.matveev.serialization.entity.book.Page;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class MutableBook {
    private int publishingYear;
    private Author author;
    private List<Page> pages = new ArrayList<>();

    public int getPublishingYear() {
        return publishingYear;
    }

    @XmlAttribute
    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public Author getAuthor() {
        return author;
    }

    @XmlElement
    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Page> getPages() {
        return pages;
    }

    @XmlElement
    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
}
