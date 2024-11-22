package main;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    public Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getIsbn(){
        return isbn;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    public void borrowBook(){
        if(isAvailable){
            isAvailable = false;
            System.out.println(title + " borrowed.");
        }else {
            System.out.println(title + " currently on loan.");
        }
    }

    public void returnBook(){
        isAvailable = true;
        System.out.println(title + "it was returned.");
    }
}
