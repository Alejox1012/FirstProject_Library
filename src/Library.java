import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import book.*;
import author.Author;
import reader.Readers;
import fine.Fine;

public class Library {
    private static List<Readers> readers = new ArrayList<>();
    private static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        // Inicializar libros y usuarios
        Author author = new Author("J.K. Rowling", new Date());
        books.add(new DigitalBook("Harry Potter", "Fantasy", "Bloomsbury", 1997, author));
        books.add(new PhysicalBook("The Hobbit", "Fantasy", "Houghton Mifflin", 1937, author));
        books.add(new CdRoom("Greatest Hits", "Music", "Sony", 2020, author));
        
        readers.add(new Readers("John Doe", "estudiante"));
        readers.add(new Readers("Jane Smith", "profesora"));

        Scanner scanner = new Scanner(System.in);
        int option;
        
        do {
            System.out.println("\n--- Menú Biblioteca ---");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Prestar un libro");
            System.out.println("3. Devolver un libro");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    lendBook(scanner);
                    break;
                case 3:
                    returnBook(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (option != 4);

        scanner.close();
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Nombre del usuario: ");
        String name = scanner.nextLine();
        System.out.print("Tipo de usuario (estudiante/profesor/otro): ");
        String userType = scanner.nextLine();
        
        Readers newReader = new Readers(name, userType);
        readers.add(newReader);
        System.out.println("Usuario registrado correctamente.");
    }

    private static void lendBook(Scanner scanner) {
        System.out.println("\nUsuarios registrados:");
        for (int i = 0; i < readers.size(); i++) {
            System.out.println((i + 1) + ". " + readers.get(i).getName());
        }
        
        System.out.print("Selecciona el usuario que quiere prestar el libro: ");
        int userIndex = scanner.nextInt() - 1;
        
        if (userIndex < 0 || userIndex >= readers.size()) {
            System.out.println("Usuario no válido.");
            return;
        }
        
        Readers reader = readers.get(userIndex);
        System.out.println("\nLibros disponibles:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i).getName());
        }
        
        System.out.print("Selecciona el libro que quieres prestar: ");
        int bookIndex = scanner.nextInt() - 1;
        
        if (bookIndex < 0 || bookIndex >= books.size()) {
            System.out.println("Libro no válido.");
            return;
        }

        Book selectedBook = books.get(bookIndex);
        
        // Registrar la fecha de retiro como la fecha actual
        Date today = new Date();
        reader.setFechaRetiro(today.getDate(), today.getMonth() + 1, today.getYear() + 1900); // Ajustar la fecha
        reader.borrowBook(selectedBook); // Añadir el libro a la lista de libros prestados

        System.out.println("Libro prestado exitosamente: " + selectedBook.getName());
        System.out.println("Fecha límite de devolución: " + reader.getFechaLimiteDevolucion());
    }

    private static void returnBook(Scanner scanner) {
        System.out.println("\nUsuarios registrados:");
        for (int i = 0; i < readers.size(); i++) {
            System.out.println((i + 1) + ". " + readers.get(i).getName());
        }
        
        System.out.print("Selecciona el usuario que va a devolver el libro: ");
        int userIndex = scanner.nextInt() - 1;
        
        if (userIndex < 0 || userIndex >= readers.size()) {
            System.out.println("Usuario no válido.");
            return;
        }

        Readers reader = readers.get(userIndex);
        
        // Mostrar los libros prestados por el usuario
        List<Book> borrowedBooks = reader.getBorrowedBooks();
        if (borrowedBooks.isEmpty()) {
            System.out.println("No hay libros prestados por este usuario.");
            return;
        }

        System.out.println("\nLibros prestados:");
        for (int i = 0; i < borrowedBooks.size(); i++) {
            System.out.println((i + 1) + ". " + borrowedBooks.get(i).getName());
        }
        
        System.out.print("Selecciona el libro que quieres devolver: ");
        int bookIndex = scanner.nextInt() - 1;
        
        if (bookIndex < 0 || bookIndex >= borrowedBooks.size()) {
            System.out.println("Libro no válido.");
            return;
        }

        // Obtener el libro a devolver y eliminarlo de la lista de prestados
        Book bookToReturn = borrowedBooks.get(bookIndex);
        reader.returnBook(bookToReturn); // Llamar al método para devolver el libro

        // Registrar la fecha de devolución como la fecha actual
        Date today = new Date();
        reader.setFechaDevolucion(today.getDate(), today.getMonth() + 1, today.getYear() + 1900); // Ajustar la fecha

        System.out.println("Devolución registrada para el libro: " + bookToReturn.getName());
    }
}
