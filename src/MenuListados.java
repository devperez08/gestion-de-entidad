// MenuListados.java
import javax.swing.JOptionPane;

public class MenuListados {
    private GestorEstudiantes gestor;
    
    public MenuListados(GestorEstudiantes gestor) {
        this.gestor = gestor;
    }
    
    public void mostrar() {
        boolean volver = false;
        
        while (!volver) {
            String opcion = JOptionPane.showInputDialog(
                "===== LISTADOS DE ESTUDIANTES =====\n" +
                "1. Listado general\n" +
                "2. Listado por nombre\n" +
                "3. Listado por apellido\n" +
                "4. Listado por nota mínima\n" +
                "5. Volver al menú principal\n\n" +
                "Ingrese el número de la opción deseada:"
            );
            
            if (opcion == null) {
                volver = true;
                continue;
            }
            
            switch (opcion) {
                case "1":
                    gestor.listarTodosEstudiantes();
                    break;
                case "2":
                    gestor.listarEstudiantesPorNombre();
                    break;
                case "3":
                    gestor.listarEstudiantesPorApellido();
                    break;
                case "4":
                    gestor.listarEstudiantesPorNotaMinima();
                    break;
                case "5":
                    volver = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, 
                        "Opción no válida. Por favor, intente nuevamente.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}