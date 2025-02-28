// MenuPrincipal.java
// Autor: [Tu nombre]
// Fecha: [Fecha]
// Descripción: Clase que muestra el menú principal del sistema.

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
                "4. Salir de la aplicación\n\n" +
                "Ingrese el número de la opción deseada:"
            );

            if (opcion == null) {
                salir = true;
                continue;
            }

            switch (opcion) {
                case "1":
                    gestor.gestionarEstudiantes();
                    break;
                case "2":
                    gestor.listarTodosEstudiantes();
                    break;
                case "3":
                    gestor.calcularEstadisticaAprobacionReprobacion();
                    break;
                case "4":
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        JOptionPane.showMessageDialog(null, "Gracias por utilizar el Sistema de Gestión Académica.", "Despedida", JOptionPane.INFORMATION_MESSAGE);
    }
}