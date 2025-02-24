// MenuEstadisticas.java
import javax.swing.JOptionPane;

public class MenuEstadisticas {
    private GestorEstudiantes gestor;
    
    public MenuEstadisticas(GestorEstudiantes gestor) {
        this.gestor = gestor;
    }
    
    public void mostrar() {
        boolean volver = false;
        
        while (!volver) {
            String opcion = JOptionPane.showInputDialog(
                "===== ESTADÍSTICAS DE ESTUDIANTES =====\n" +
                "1. Estadística de aprobación/reprobación\n" +
                "2. Promedio general del curso\n" +
                "3. Distribución de notas por rangos\n" +
                "4. Volver al menú principal\n\n" +
                "Ingrese el número de la opción deseada:"
            );
            
            if (opcion == null) {
                volver = true;
                continue;
            }
            
            switch (opcion) {
                case "1":
                    gestor.calcularEstadisticaAprobacionReprobacion();
                    break;
                case "2":
                    gestor.calcularPromedioGeneral();
                    break;
                case "3":
                    gestor.calcularDistribucionNotas();
                    break;
                case "4":
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
