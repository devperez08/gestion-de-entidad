// GestorEstudiantes.java
// Autor: [Tu nombre]
// Fecha: [Fecha]
// Descripción: Clase que gestiona las operaciones relacionadas con los estudiantes.

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestorEstudiantes {
    private ArrayList<Estudiante> estudiantes;

    // Constructor
    public GestorEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    // Método para mostrar el menú de gestión de estudiantes
    public void gestionarEstudiantes() {
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
                    nuevoEstudiante();
                    break;
                case "2":
                    consultarEstudiante();
                    break;
                case "3":
                    modificarEstudiante();
                    break;
                case "4":
                    eliminarEstudiante();
                    break;
                case "5":
                    volver = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Método para agregar un nuevo estudiante
    private void nuevoEstudiante() {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del estudiante (llave primaria):");
        if (codigo == null) return;

        if (buscarEstudiantePorCodigo(codigo) != null) {
            JOptionPane.showMessageDialog(null, "Ya existe un estudiante con el código: " + codigo, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
        if (nombre == null) return;

        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del estudiante:");
        if (apellido == null) return;

        double notaDefinitiva = 0.0;
        try {
            String notaStr = JOptionPane.showInputDialog("Ingrese la nota definitiva (0-5):");
            if (notaStr == null) return;
            notaDefinitiva = Double.parseDouble(notaStr);

            if (notaDefinitiva < 0 || notaDefinitiva > 5) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Nota inválida. Debe ser un número entre 0 y 5.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Estudiante nuevoEstudiante = new Estudiante(codigo, nombre, apellido, notaDefinitiva);
        estudiantes.add(nuevoEstudiante);
        JOptionPane.showMessageDialog(null, "Estudiante agregado con éxito:\n\n" + nuevoEstudiante.toString(), "Estudiante Agregado", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para consultar un estudiante
    private void consultarEstudiante() {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del estudiante a consultar:");
        if (codigo == null) return;

        Estudiante estudiante = buscarEstudiantePorCodigo(codigo);
        if (estudiante != null) {
            JOptionPane.showMessageDialog(null, "Información del estudiante:\n\n" + estudiante.toString(), "Consulta de Estudiante", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún estudiante con el código: " + codigo, "Estudiante No Encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para modificar un estudiante
    private void modificarEstudiante() {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del estudiante a modificar:");
        if (codigo == null) return;

        Estudiante estudiante = buscarEstudiantePorCodigo(codigo);
        if (estudiante != null) {
            boolean volver = false;

            while (!volver) {
                String opcion = JOptionPane.showInputDialog(
                    "===== MODIFICAR ESTUDIANTE =====\n" +
                    "Estudiante seleccionado: " + estudiante.getNombre() + " " + estudiante.getApellido() + "\n\n" +
                    "1. Modificar nombre\n" +
                    "2. Modificar apellido\n" +
                    "3. Modificar nota definitiva\n" +
                    "4. Volver al menú de gestión\n\n" +
                    "Ingrese el número de la opción deseada:"
                );

                if (opcion == null) {
                    volver = true;
                    continue;
                }

                switch (opcion) {
                    case "1":
                        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:", estudiante.getNombre());
                        if (nuevoNombre != null) {
                            estudiante.setNombre(nuevoNombre);
                            JOptionPane.showMessageDialog(null, "Nombre modificado con éxito.");
                        }
                        break;
                    case "2":
                        String nuevoApellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido:", estudiante.getApellido());
                        if (nuevoApellido != null) {
                            estudiante.setApellido(nuevoApellido);
                            JOptionPane.showMessageDialog(null, "Apellido modificado con éxito.");
                        }
                        break;
                    case "3":
                        try {
                            String notaStr = JOptionPane.showInputDialog("Ingrese la nueva nota definitiva (0-5):", estudiante.getNotaDefinitiva());
                            if (notaStr != null) {
                                double nuevaNota = Double.parseDouble(notaStr);

                                if (nuevaNota < 0 || nuevaNota > 5) {
                                    throw new NumberFormatException();
                                }

                                estudiante.setNotaDefinitiva(nuevaNota);
                                JOptionPane.showMessageDialog(null, "Nota definitiva modificada con éxito.");
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Nota inválida. Debe ser un número entre 0 y 5.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case "4":
                        volver = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, intente nuevamente.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún estudiante con el código: " + codigo, "Estudiante No Encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un estudiante
    private void eliminarEstudiante() {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del estudiante a eliminar:");
        if (codigo == null) return;

        Estudiante estudiante = buscarEstudiantePorCodigo(codigo);
        if (estudiante != null) {
            int confirmacion = JOptionPane.showConfirmDialog(null, 
                "¿Está seguro que desea eliminar el siguiente estudiante?\n\n" + estudiante.toString(), 
                "Confirmar Eliminación", 
                JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                estudiantes.remove(estudiante);
                JOptionPane.showMessageDialog(null, "El estudiante ha sido eliminado con éxito.", "Estudiante Eliminado", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún estudiante con el código: " + codigo, "Estudiante No Encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para buscar un estudiante por código
    private Estudiante buscarEstudiantePorCodigo(String codigo) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigo().equals(codigo)) {
                return estudiante;
            }
        }
        return null;
    }

    // Método para listar todos los estudiantes
    public void listarTodosEstudiantes() {
        if (estudiantes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados en el sistema.");
            return;
        }

        StringBuilder listado = new StringBuilder("===== LISTADO GENERAL DE ESTUDIANTES =====\n");
        for (Estudiante estudiante : estudiantes) {
            listado.append("\n").append(estudiante.toString()).append("\n----------------------------------------\n");
        }
        listado.append("Total de estudiantes: ").append(estudiantes.size()).append("\n=======================================");
        JOptionPane.showMessageDialog(null, listado.toString(), "Listado General", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para calcular estadísticas de aprobación/reprobación
    public void calcularEstadisticaAprobacionReprobacion() {
        if (estudiantes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados");
            return;
        }

        int aprobados = 0;
        int reprobados = 0;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNotaDefinitiva() >= 3.0) {
                aprobados++;
            } else {
                reprobados++;
            }
        }

        double porcentajeAprobados = (double) aprobados / estudiantes.size() * 100;
        double porcentajeReprobados = (double) reprobados / estudiantes.size() * 100;

        String estadistica = "===== ESTADÍSTICA DE APROBACIÓN/REPROBACIÓN =====\n" +
                            "Total de estudiantes: " + estudiantes.size() + "\n" +
                            "Estudiantes aprobados: " + aprobados + " (" + String.format("%.2f", porcentajeAprobados) + "%)\n" +
                            "Estudiantes reprobados: " + reprobados + " (" + String.format("%.2f", porcentajeReprobados) + "%)\n" +
                            "=================================================";

        JOptionPane.showMessageDialog(null, estadistica, "Estadística de Aprobación/Reprobación", JOptionPane.INFORMATION_MESSAGE);
    }
}