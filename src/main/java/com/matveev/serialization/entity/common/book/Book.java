package com.matveev.serialization.entity.common.book;

import com.matveev.serialization.entity.common.Page;

import java.util.List;

public interface Book {
    int getPublishingYear();
    List<Page> getPages();
}
