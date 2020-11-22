package com.example.booksmanagerdemo11.domain;

public class Book {
    private String book_id;
    private String book_name;
    private String author;
    private String classifying;
    private double price;
    private int size;

    public Book() {
    }

    public Book(String book_id, String book_name, String author, String classifying, double price, int size) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.author = author;
        this.classifying = classifying;
        this.price = price;
        this.size = size;
    }

    @Override
    public String toString() {
        return "book{" +
                "book_id='" + book_id + '\'' +
                ", book_name='" + book_name + '\'' +
                ", author='" + author + '\'' +
                ", classifying='" + classifying + '\'' +
                ", price=" + price +
                ", size=" + size +
                '}';
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getClassifying() {
        return classifying;
    }

    public void setClassifying(String classifying) {
        this.classifying = classifying;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
