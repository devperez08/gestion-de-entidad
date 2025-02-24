// MenuPrincipal.java
import javax.swing.JOptionPane;

public class MenuPrincipal {
    private GestorEstudiantes gestor;
    
    public MenuPrincipal(GestorEstudiantes gestor) {
        this.gestor = gestor;
    }
    
    public void mostrar() {
        boolean salir = false;
        
        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                "===== SISTEMA DE GESTIÓN ACADÉMICA =====\n" +
                "1. Gestión de Estudiantes\n" +
                "2. Listados\n" +
                "3. Estadísticas\n" +
                "4. Acerca de...\n" +
                "5. Salir de la aplicación\n\n" +
                "Ingrese el número de la opción deseada:"
            );
            
            if (opcion == null) {
                int confirmacion = JOptionPane.showConfirmDialog(null, 
                    "¿Está seguro que desea salir?", 
                    "Confirmar salida", 
                    JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    salir = true;
                }
                continue;
            }
            
            switch (opcion) {
                case "1":
                    MenuGestionEstudiantes menuGestion = new MenuGestionEstudiantes(gestor);
                    menuGestion.mostrar();
                    break;
                case "2":
                    MenuListados menuListados = new MenuListados(gestor);
                    menuListados.mostrar();
                    break;
                case "3":
                    MenuEstadisticas menuEstadisticas = new MenuEstadisticas(gestor);
                    menuEstadisticas.mostrar();
                    break;
                case "4":
                    gestor.mostrarAcercaDe();
                    break;
                case "5":
                    int confirmacion = JOptionPane.showConfirmDialog(null, 
                        "¿Está seguro que desea salir?", 
                        "Confirmar salida", 
                        JOptionPane.YES_NO_OPTION);
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        salir = true;
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, 
                        "Opción no válida. Por favor, intente nuevamente.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        
        JOptionPane.showMessageDialog(null, 
            "Gracias por utilizar el Sistema de Gestión Académica.", 
            "Despedida", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}