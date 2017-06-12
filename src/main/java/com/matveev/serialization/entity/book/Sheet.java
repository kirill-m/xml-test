package com.matveev.serialization.entity.book;

import java.io.Serializable;

abstract public class Sheet implements Serializable {
    private final String text;

    public Sheet(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
