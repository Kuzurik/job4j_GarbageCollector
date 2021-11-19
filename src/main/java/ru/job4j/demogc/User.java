package ru.job4j.demogc;


public class User {

    private final String user;
    private final String email;
    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public User(String user, String email) {
        this.user = user;
        this.email = email;
    }

    @Override
    protected void finalize() {
        System.out.printf("Removed %s %s%n", user, email);
    }


    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Max: %d%n", maxMemory / MB);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new User("U" + i, "E" + i);
        }
        System.gc();
        info();
    }
}
