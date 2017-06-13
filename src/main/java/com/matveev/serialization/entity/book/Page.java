package com.matveev.serialization.entity.book;

public class Page extends Sheet {
    private final int number;

    public Page(String text, int number) {
        super(text);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Page page = (Page) o;

        return number == page.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "Page{" +
                "number=" + number +
                ", text=" + getText() +
                '}';
    }
}
