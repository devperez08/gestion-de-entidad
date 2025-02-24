// Estudiante.java
public class Estudiante {
    private String codigo; // Llave primaria
    private String nombre;
    private String apellido;
    private double notaDefinitiva;
    
    // Constructor
    public Estudiante(String codigo, String nombre, String apellido, double notaDefinitiva) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.notaDefinitiva = notaDefinitiva;
    }
    
    // Métodos getters y setters
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public double getNotaDefinitiva() {
        return notaDefinitiva;
    }
    
    public void setNotaDefinitiva(double notaDefinitiva) {
        this.notaDefinitiva = notaDefinitiva;
    }
    
    // Método toString para mostrar todos los datos
    @Override
    public String toString() {
        return "Código: " + codigo + 
               "\nNombre: " + nombre + 
               "\nApellido: " + apellido + 
               "\nNota Definitiva: " + notaDefinitiva;
    }
}