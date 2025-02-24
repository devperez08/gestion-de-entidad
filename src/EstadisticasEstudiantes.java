// EstadisticasEstudiantes.java
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EstadisticasEstudiantes {
    
    // Método para calcular estadística de aprobación/reprobación
    public static void calcularEstadisticaAprobacionReprobacion(ArrayList<Estudiante> estudiantes) {
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
        
        System.out.println("===== ESTADÍSTICA DE APROBACIÓN/REPROBACIÓN =====");
        System.out.println("Total de estudiantes: " + estudiantes.size());
        System.out.println("Estudiantes aprobados: " + aprobados + " (" + String.format("%.2f", porcentajeAprobados) + "%)");
        System.out.println("Estudiantes reprobados: " + reprobados + " (" + String.format("%.2f", porcentajeReprobados) + "%)");
        System.out.println("=================================================");
        
        JOptionPane.showMessageDialog(null,
            "Estadística de Aprobación/Reprobación:\n\n" +
            "Total de estudiantes: " + estudiantes.size() + "\n" +
            "Estudiantes aprobados: " + aprobados + " (" + String.format("%.2f", porcentajeAprobados) + "%)\n" +
            "Estudiantes reprobados: " + reprobados + " (" + String.format("%.2f", porcentajeReprobados) + "%)",
            "Estadística de Aprobación/Reprobación",
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Método para calcular el promedio general
    public static void calcularPromedioGeneral(ArrayList<Estudiante> estudiantes) {
        if (estudiantes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados");
            return;
        }
        
        double sumaNotas = 0;
        
        for (Estudiante estudiante : estudiantes) {
            sumaNotas += estudiante.getNotaDefinitiva();
        }
        
        double promedioGeneral = sumaNotas / estudiantes.size();
        
        System.out.println("===== PROMEDIO GENERAL DEL CURSO =====");
        System.out.println("Total de estudiantes: " + estudiantes.size());
        System.out.println("Promedio general: " + String.format("%.2f", promedioGeneral));
        System.out.println("======================================");
        
        JOptionPane.showMessageDialog(null,
            "Promedio General del Curso:\n\n" +
            "Total de estudiantes: " + estudiantes.size() + "\n" +
            "Promedio general: " + String.format("%.2f", promedioGeneral),
            "Promedio General",
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Método para calcular la distribución de notas por rangos
    public static void calcularDistribucionNotas(ArrayList<Estudiante> estudiantes) {
        if (estudiantes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados");
            return;
        }
        
        int[] rangos = new int[5]; // 0-0.99, 1-1.99, 2-2.99, 3-3.99, 4-5
        
        for (Estudiante estudiante : estudiantes) {
            double nota = estudiante.getNotaDefinitiva();
            
            if (nota < 1) {
                rangos[0]++;
            } else if (nota < 2) {
                rangos[1]++;
            } else if (nota < 3) {
                rangos[2]++;
            } else if (nota < 4) {
                rangos[3]++;
            } else {
                rangos[4]++;
            }
        }
        
        // Calcular porcentajes
        double[] porcentajes = new double[5];
        for (int i = 0; i < 5; i++) {
            porcentajes[i] = (double) rangos[i] / estudiantes.size() * 100;
        }
        
        System.out.println("===== DISTRIBUCIÓN DE NOTAS POR RANGOS =====");
        System.out.println("Total de estudiantes: " + estudiantes.size());
        System.out.println("Rango 0.0 - 0.99: " + rangos[0] + " estudiantes (" + String.format("%.2f", porcentajes[0]) + "%)");
        System.out.println("Rango 1.0 - 1.99: " + rangos[1] + " estudiantes (" + String.format("%.2f", porcentajes[1]) + "%)");
        System.out.println("Rango 2.0 - 2.99: " + rangos[2] + " estudiantes (" + String.format("%.2f", porcentajes[2]) + "%)");
        System.out.println("Rango 3.0 - 3.99: " + rangos[3] + " estudiantes (" + String.format("%.2f", porcentajes[3]) + "%)");
        System.out.println("Rango 4.0 - 5.00: " + rangos[4] + " estudiantes (" + String.format("%.2f", porcentajes[4]) + "%)");
        System.out.println("===========================================");
        
        JOptionPane.showMessageDialog(null,
            "Distribución de Notas por Rangos:\n\n" +
            "Total de estudiantes: " + estudiantes.size() + "\n" +
            "Rango 0.0 - 0.99: " + rangos[0] + " estudiantes (" + String.format("%.2f", porcentajes[0]) + "%)\n" +
            "Rango 1.0 - 1.99: " + rangos[1] + " estudiantes (" + String.format("%.2f", porcentajes[1]) + "%)\n" +
            "Rango 2.0 - 2.99: " + rangos[2] + " estudiantes (" + String.format("%.2f", porcentajes[2]) + "%)\n" +
            "Rango 3.0 - 3.99: " + rangos[3] + " estudiantes (" + String.format("%.2f", porcentajes[3]) + "%)\n" +
            "Rango 4.0 - 5.00: " + rangos[4] + " estudiantes (" + String.format("%.2f", porcentajes[4]) + "%)",
            "Distribución de Notas",
            JOptionPane.INFORMATION_MESSAGE);
    }
}