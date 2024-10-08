package book;
import author.Author;

public class DigitalBook extends Book {
    public DigitalBook(String name, String type, String editorial, int year, Author author) {
        super(name, type, editorial, year, author);
    }

    @Override
    public String obtenerId() {
        //obtener el ID de un DigitalBook
        return "DIGITAL-" + getName() + "-" + getYear();
    }
}

