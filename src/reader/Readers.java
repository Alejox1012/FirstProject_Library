package reader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import book.Book; // Asegúrate de importar la clase Book

public class Readers {
    private String name;
    private String vinculo; // estudiante, profesor, invitado
    private boolean isAvailable;
    private Date fechaRetiro;
    private Date fechaDevolucion;
    private List<Book> borrowedBooks; // Lista para almacenar libros prestados

    public Readers(String name, String vinculo) {
        this.name = name;
        this.vinculo = vinculo;
        this.isAvailable = true; 
        this.borrowedBooks = new ArrayList<>(); // Inicializar la lista
    }

    // Método para establecer la fecha de retiro
    public void setFechaRetiro(int dia, int mes, int anio) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(anio, mes - 1, dia); // En Java, enero es el mes 0
        this.fechaRetiro = calendar.getTime();
    }

    // Método para establecer la fecha de devolución
    public void setFechaDevolucion(int dia, int mes, int anio) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(anio, mes - 1, dia);
        this.fechaDevolucion = calendar.getTime();
    }

    // Método para obtener la fecha máxima de devolución (14 días)
    public Date getFechaLimiteDevolucion() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaRetiro);
        calendar.add(Calendar.DAY_OF_MONTH, 14); // Añadir 14 días
        return calendar.getTime();
    }

    // Método para obtener libros prestados
    public List<Book> getBorrowedBooks() {
        return borrowedBooks; // Retorna la lista de libros prestados
    }

    // Método para añadir un libro a la lista de prestados
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        isAvailable = false; // Marcar como no disponible al prestar
    }

    // Método para devolver un libro
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        // Si no hay más libros prestados, marcar como disponible
        if (borrowedBooks.isEmpty()) {
            isAvailable = true;
        }
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVinculo() {
        return vinculo;
    }

    public void setVinculo(String vinculo) {
        this.vinculo = vinculo;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }
}
