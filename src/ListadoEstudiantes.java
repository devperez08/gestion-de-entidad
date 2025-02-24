// ListadoEstudiantes.java
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ListadoEstudiantes {
    
    // Método para listar todos los estudiantes
    public static void listarTodosEstudiantes(ArrayList<Estudiante> estudiantes) {
        if (estudiantes.isEmpty()) {
            System.out.println("===== LISTADO GENERAL DE ESTUDIANTES =====");
            System.out.println("No hay estudiantes registrados en el sistema.");
            System.out.println("=======================================");
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados en el sistema.");
            return;
        }
        
        System.out.println("===== LISTADO GENERAL DE ESTUDIANTES =====");
        for (Estudiante estudiante : estudiantes) {
            System.out.println("\n" + estudiante.toString());
            System.out.println("----------------------------------------");
        }
        System.out.println("Total de estudiantes: " + estudiantes.size());
        System.out.println("=======================================");
        
        JOptionPane.showMessageDialog(null, 
            "El listado general ha sido mostrado en la consola.\nTotal de estudiantes: " + estudiantes.size(), 
            "Listado General", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Método para listar estudiantes por nombre
    public static void listarEstudiantesPorNombre(ArrayList<Estudiante> estudiantes) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre o parte del nombre a buscar:");
        
        if (nombre == null) {
            return;
        }
        
        ArrayList<Estudiante> resultado = new ArrayList<>();
        
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(estudiante);
            }
        }
        
        if (resultado.isEmpty()) {
            System.out.println("===== LISTADO DE ESTUDIANTES POR NOMBRE =====");
            System.out.println("No se encontraron estudiantes con el nombre: " + nombre);
            System.out.println("==========================================");
            JOptionPane.showMessageDialog(null, "No se encontraron estudiantes con el nombre: " + nombre);
            return;
        }
        
        System.out.println("===== LISTADO DE ESTUDIANTES POR NOMBRE =====");
        System.out.println("Nombre buscado: " + nombre);
        for (Estudiante estudiante : resultado) {
            System.out.println("\n" + estudiante.toString());
            System.out.println("----------------------------------------");
        }
        System.out.println("Total de estudiantes encontrados: " + resultado.size());
        System.out.println("==========================================");
        
        JOptionPane.showMessageDialog(null, 
            "El listado por nombre ha sido mostrado en la consola.\nTotal de estudiantes encontrados: " + resultado.size(), 
            "Listado por Nombre", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Método para listar estudiantes por apellido
    public static void listarEstudiantesPorApellido(ArrayList<Estudiante> estudiantes) {
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido o parte del apellido a buscar:");
        
        if (apellido == null) {
            return;
        }
        
        ArrayList<Estudiante> resultado = new ArrayList<>();
        
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getApellido().toLowerCase().contains(apellido.toLowerCase())) {
                resultado.add(estudiante);
            }
        }
        
        if (resultado.isEmpty()) {
            System.out.println("===== LISTADO DE ESTUDIANTES POR APELLIDO =====");
            System.out.println("No se encontraron estudiantes con el apellido: " + apellido);
            System.out.println("===========================================");
            JOptionPane.showMessageDialog(null, "No se encontraron estudiantes con el apellido: " + apellido);
            return;
        }
        
        System.out.println("===== LISTADO DE ESTUDIANTES POR APELLIDO =====");
        System.out.println("Apellido buscado: " + apellido);
        for (Estudiante estudiante : resultado) {
            System.out.println("\n" + estudiante.toString());
            System.out.println("----------------------------------------");
        }
        System.out.println("Total de estudiantes encontrados: " + resultado.size());
        System.out.println("===========================================");
        
        JOptionPane.showMessageDialog(null, 
            "El listado por apellido ha sido mostrado en la consola.\nTotal de estudiantes encontrados: " + resultado.size(), 
            "Listado por Apellido", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Método para listar estudiantes por nota mínima
    public static void listarEstudiantesPorNotaMinima(ArrayList<Estudiante> estudiantes) {
        String notaStr = JOptionPane.showInputDialog("Ingrese la nota mínima (0-5):");
        
        if (notaStr == null) {
            return;
        }
        
        double notaMinima;
        try {
            notaMinima = Double.parseDouble(notaStr);
            
            // Validar que la nota esté en el rango correcto
            if (notaMinima < 0 || notaMinima > 5) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                "Nota inválida. Debe ser un número entre 0 y 5.",
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ArrayList<Estudiante> resultado = new ArrayList<>();
        
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNotaDefinitiva() >= notaMinima) {
                resultado.add(estudiante);
            }
        }
        
        if (resultado.isEmpty()) {
            System.out.println("===== LISTADO DE ESTUDIANTES POR NOTA MÍNIMA =====");
            System.out.println("No se encontraron estudiantes con nota igual o mayor a: " + notaMinima);
            System.out.println("====================================================");
            JOptionPane.showMessageDialog(null, "No se encontraron estudiantes con nota igual o mayor a: " + notaMinima);
            return;
        }
        
        System.out.println("===== LISTADO DE ESTUDIANTES POR NOTA MÍNIMA =====");
        System.out.println("Nota mínima: " + notaMinima);
        for (Estudiante estudiante : resultado) {
            System.out.println("\n" + estudiante.toString());
            System.out.println("----------------------------------------");
        }
        System.out.println("Total de estudiantes encontrados: " + resultado.size());
        System.out.println("====================================================");
        
        JOptionPane.showMessageDialog(null, 
            "El listado por nota mínima ha sido mostrado en la consola.\nTotal de estudiantes encontrados: " + resultado.size(), 
            "Listado por Nota", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}