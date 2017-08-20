package com.matveev.serialization.entity.common;

import java.io.Serializable;

public class Author implements Writable, Serializable{
    private final String name;

    public Author(String name) {
        this.name = name;
    }

    public void write(String text) {
        System.out.println(name + " wrote " + text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return name.equals(author.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                '}';
    }
}
