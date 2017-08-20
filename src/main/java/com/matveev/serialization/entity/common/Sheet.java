package com.matveev.serialization.entity.common;

import java.io.Serializable;

abstract public class Sheet implements Serializable {
    private final String text;

    public Sheet(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Sheet{" +
                "text='" + text + '\'' +
                '}';
    }
}
