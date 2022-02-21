package ru.job4j.cache;

import java.nio.file.Files;
import java.nio.file.Path;


public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;


    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String value = "";
        try {
            value = Files.readString(Path.of(cachingDir, key));
        } catch (Exception e) {
            System.err.println("File or directory not found!: " + e.getMessage());
        }
        return value;
    }
}
