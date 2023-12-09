package com.serializationanddeserialization.tasks;

import java.io.*;

public class Book implements Externalizable {
    private String author;
    private int pages;
    private String title;

    public Book(String author) {
        this.author = author;
    }

    public Book(String author, int pages, String title) {
        this.author = author;
        this.pages = pages;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", pages=" + pages +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(author.substring(0, 2));
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        Book o = (Book) objectInput.readObject();
        this.author = o.getAuthor();
    }
}
