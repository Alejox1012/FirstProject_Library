package book;

import author.Author;

public abstract class Book {
    private String name;
    private String type;
    private String editorial;
    private int year;
    private Author author;
    private boolean isAvailable;

    public Book(String name, String type, String editorial, int year, Author author) {
        this.name = name;
        this.type = type;
        this.editorial = editorial;
        this.year = year;
        this.author = author;
        this.isAvailable = true;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getEditorial() { return editorial; }
    public void setEditorial(String editorial) { this.editorial = editorial; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }

    
    // Método abstracto para obtener ID
    public abstract String obtenerId();
}
