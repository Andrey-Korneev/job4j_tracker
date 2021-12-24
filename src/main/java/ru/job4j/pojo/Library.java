package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book alphabet = new Book("The alphabet", 33);
        Book detective = new Book("The Poirot", 350);
        Book tales = new Book("Tales", 200);
        Book programming = new Book("Clean code", 450);

        Book[] books = new Book[4];
        books[0] = alphabet;
        books[1] = detective;
        books[2] = tales;
        books[3] = programming;

        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPages() + " pages.");
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println();
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPages() + " pages.");
        }

        System.out.println();
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " - " + book.getPages() + " pages.");
            }
        }
    }
}
