// GestorEstudiantes.java
import java.util.ArrayList;

public class GestorEstudiantes {
    private ArrayList<Estudiante> estudiantes;
    
    // Constructor
    public GestorEstudiantes() {
        estudiantes = new ArrayList<>();
    }
    
    // Método para mostrar el menú principal
    public void mostrarMenuPrincipal() {
        MenuPrincipal menuPrincipal = new MenuPrincipal(this);
        menuPrincipal.mostrar();
    }
    
    // Método para buscar un estudiante por su código (llave primaria)
    public Estudiante buscarEstudiantePorCodigo(String codigo) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigo().equals(codigo)) {
                return estudiante;
            }
        }
        return null;
    }
    
    // Métodos de gestión de estudiantes
    public void nuevoEstudiante() {
        GestionEstudiantes.nuevoEstudiante(this, estudiantes);
    }
    
    public void consultarEstudiante() {
        GestionEstudiantes.consultarEstudiante(this);
    }
    
    public void modificarEstudiante() {
        GestionEstudiantes.modificarEstudiante(this);
    }
    
    public void eliminarEstudiante() {
        GestionEstudiantes.eliminarEstudiante(this, estudiantes);
    }
    
    // Métodos de listados
    public void listarTodosEstudiantes() {
        ListadoEstudiantes.listarTodosEstudiantes(estudiantes);
    }
    
    public void listarEstudiantesPorNombre() {
        ListadoEstudiantes.listarEstudiantesPorNombre(estudiantes);
    }
    
    public void listarEstudiantesPorApellido() {
        ListadoEstudiantes.listarEstudiantesPorApellido(estudiantes);
    }
    
    public void listarEstudiantesPorNotaMinima() {
        ListadoEstudiantes.listarEstudiantesPorNotaMinima(estudiantes);
    }
    
    // Métodos de estadísticas
    public void calcularEstadisticaAprobacionReprobacion() {
        EstadisticasEstudiantes.calcularEstadisticaAprobacionReprobacion(estudiantes);
    }
    
    public void calcularPromedioGeneral() {
        EstadisticasEstudiantes.calcularPromedioGeneral(estudiantes);
    }
    
    public void calcularDistribucionNotas() {
        EstadisticasEstudiantes.calcularDistribucionNotas(estudiantes);
    }
    
    public void mostrarAcercaDe() {
        AcercaDe.mostrar();
    }
}