package Paquete_de_Clases;
import java.time.LocalDate;

public class Cliente {
    private String nombre;
    private String sexo;
    private int edad;
    private LocalDate fechaCumpleanos;
    private String prediccion;
    private String[] numerosDeLaSuerte;

    public Cliente(String nombre, String sexo, int edad, LocalDate fechaCumpleanos) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.fechaCumpleanos = fechaCumpleanos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public LocalDate getFechaCumpleanos() {
        return fechaCumpleanos;
    }

    public String getPrediccion() {
        return prediccion;
    }

    public void setPrediccion(String prediccion) {
        this.prediccion = prediccion;
    }

    public String[] getNumerosDeLaSuerte() {
        return numerosDeLaSuerte;
    }

    public void setNumerosDeLaSuerte(String[] numerosDeLaSuerte) {
        this.numerosDeLaSuerte = numerosDeLaSuerte;
    }
}
