// MenuGestionEstudiantes.java
import javax.swing.JOptionPane;

public class MenuGestionEstudiantes {
    private GestorEstudiantes gestor;
    
    public MenuGestionEstudiantes(GestorEstudiantes gestor) {
        this.gestor = gestor;
    }
    
    public void mostrar() {
        boolean volver = false;
        
        while (!volver) {
            String opcion = JOptionPane.showInputDialog(
                "===== GESTIÓN DE ESTUDIANTES =====\n" +
                "1. Nuevo estudiante\n" +
                "2. Consultar estudiante\n" +
                "3. Modificar estudiante\n" +
                "4. Eliminar estudiante\n" +
                "5. Volver al menú principal\n\n" +
                "Ingrese el número de la opción deseada:"
            );
            
            if (opcion == null) {
                volver = true;
                continue;
            }
            
            switch (opcion) {
                case "1":
                    gestor.nuevoEstudiante();
                    break;
                case "2":
                    gestor.consultarEstudiante();
                    break;
                case "3":
                    gestor.modificarEstudiante();
                    break;
                case "4":
                    gestor.eliminarEstudiante();
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