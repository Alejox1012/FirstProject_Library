package book;
import author.Author;

public class PhysicalBook extends Book {
    public PhysicalBook(String name, String type, String editorial, int year, Author author) {
        super(name, type, editorial, year, author);
    }

    @Override
    public String obtenerId() {
        // obtener el ID de un PhysicalBook
        return "PHYSICAL-" + getName() + "-" + getYear();
    }
}

