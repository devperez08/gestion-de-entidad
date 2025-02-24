// GestionEstudiantes.java
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestionEstudiantes {
    
    // Método para crear un nuevo estudiante
    public static void nuevoEstudiante(GestorEstudiantes gestor, ArrayList<Estudiante> estudiantes) {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del estudiante (llave primaria):");
        
        if (codigo == null) {
            return;
        }
        
        // Verificar si ya existe un estudiante con ese código
        if (gestor.buscarEstudiantePorCodigo(codigo) != null) {
            JOptionPane.showMessageDialog(null, 
                "Ya existe un estudiante con el código: " + codigo, 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
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
            
            // Validar que la nota esté en el rango correcto
            if (notaDefinitiva < 0 || notaDefinitiva > 5) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                "Nota inválida. Debe ser un número entre 0 y 5.", 
                "Advertencia", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Crear y agregar el nuevo estudiante
        Estudiante nuevoEstudiante = new Estudiante(codigo, nombre, apellido, notaDefinitiva);
        estudiantes.add(nuevoEstudiante);
        
        JOptionPane.showMessageDialog(null, 
            "Estudiante agregado con éxito:\n\n" + nuevoEstudiante.toString(), 
            "Estudiante Agregado", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Método para consultar un estudiante
    public static void consultarEstudiante(GestorEstudiantes gestor) {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del estudiante a consultar:");
        
        if (codigo == null) {
            return;
        }
        
        Estudiante estudiante = gestor.buscarEstudiantePorCodigo(codigo);
        
        if (estudiante != null) {
            JOptionPane.showMessageDialog(null, 
                "Información del estudiante:\n\n" + estudiante.toString(), 
                "Consulta de Estudiante", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, 
                "No se encontró ningún estudiante con el código: " + codigo, 
                "Estudiante No Encontrado", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método para modificar un estudiante
    public static void modificarEstudiante(GestorEstudiantes gestor) {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del estudiante a modificar:");
        
        if (codigo == null) {
            return;
        }
        
        Estudiante estudiante = gestor.buscarEstudiantePorCodigo(codigo);
        
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
                                
                                // Validar que la nota esté en el rango correcto
                                if (nuevaNota < 0 || nuevaNota > 5) {
                                    throw new NumberFormatException();
                                }
                                
                                estudiante.setNotaDefinitiva(nuevaNota);
                                JOptionPane.showMessageDialog(null, "Nota definitiva modificada con éxito.");
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, 
                                "Nota inválida. Debe ser un número entre 0 y 5.", 
                                "Error", 
                                JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, 
                "No se encontró ningún estudiante con el código: " + codigo, 
                "Estudiante No Encontrado", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método para eliminar un estudiante
    public static void eliminarEstudiante(GestorEstudiantes gestor, ArrayList<Estudiante> estudiantes) {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del estudiante a eliminar:");
        
        if (codigo == null) {
            return;
        }
        
        Estudiante estudiante = gestor.buscarEstudiantePorCodigo(codigo);
        
        if (estudiante != null) {
            int confirmacion = JOptionPane.showConfirmDialog(null, 
                "¿Está seguro que desea eliminar el siguiente estudiante?\n\n" + estudiante.toString(), 
                "Confirmar Eliminación", 
                JOptionPane.YES_NO_OPTION);
                
            if (confirmacion == JOptionPane.YES_OPTION) {
                estudiantes.remove(estudiante);
                JOptionPane.showMessageDialog(null, 
                    "El estudiante ha sido eliminado con éxito.", 
                    "Estudiante Eliminado", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, 
                "No se encontró ningún estudiante con el código: " + codigo, 
                "Estudiante No Encontrado", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
