package book;
import author.Author;

public class CdRoom extends Book {
    public CdRoom(String name, String type, String editorial, int year, Author author) {
        super(name, type, editorial, year, author);
    }

    @Override
    public String obtenerId() {
        //obtener el ID de un CDRoom
        return "CD-" + getName() + "-" + getYear();
    }
}

