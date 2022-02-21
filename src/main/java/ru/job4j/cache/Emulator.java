package ru.job4j.cache;

import java.io.IOException;
import java.util.Scanner;


public class Emulator {

    private String key;
    private AbstractCache<String, String> cache;

    public void getPath() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter directory for caching");
        this.cache = new DirFileCache(scanner.nextLine());
        System.out.println("enter cache file");
        this.key = scanner.nextLine();

    }

    public String getFromCash() throws IOException {
        return cache.get(key);
    }

    public static void main(String[] args) throws IOException {
        Emulator em = new Emulator();
        em.getPath();
        System.out.println(em.getFromCash());


    }
}
