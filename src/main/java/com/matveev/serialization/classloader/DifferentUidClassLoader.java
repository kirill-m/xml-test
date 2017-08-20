package com.matveev.serialization.classloader;

import java.net.URL;
import java.net.URLClassLoader;

public class DifferentUidClassLoader extends URLClassLoader {
    public DifferentUidClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.startsWith("java")) {
            return super.loadClass(name);
        }

        return findClass(name);
    }
}
