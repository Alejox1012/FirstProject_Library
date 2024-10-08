package fine;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fine {
    private Date fechaRetiro;
    private Date fechaDevolucion;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Fine(Date fechaRetiro, Date fechaDevolucion) {
        this.fechaRetiro = fechaRetiro;
        this.fechaDevolucion = fechaDevolucion;
    }

    // Método 
    public void validateAndFine(Date fechaRetiro, Date fechaDevolucion) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaRetiro);
        calendar.add(Calendar.DAY_OF_MONTH, 14); // se define 14 dias

        Date fechaLimite = calendar.getTime();

        System.out.println("Fecha de retiro: " + dateFormat.format(fechaRetiro));
        System.out.println("Fecha de devolucion: " + dateFormat.format(fechaDevolucion));
        System.out.println("Fecha limite de devolucion: " + dateFormat.format(fechaLimite));

        // Verificar 
        if (fechaDevolucion.after(fechaLimite)) {
            System.out.println("El libro fue devuelto despues del tiempo limite.");
            // aplicar multa, deshabilitar al lector
        } else {
            System.out.println("El libro fue devuelto a tiempo.");
        }
    }

    

    // Getters y Setters 
    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }


    
}
