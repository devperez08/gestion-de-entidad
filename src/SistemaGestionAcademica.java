// SistemaGestionAcademica.java
// Autor: [Tu nombre]
// Fecha: [Fecha]
// Descripción: Clase principal que inicia la aplicación.

public class SistemaGestionAcademica {
    public static void main(String[] args) {
        GestorEstudiantes gestor = new GestorEstudiantes();
        MenuPrincipal menuPrincipal = new MenuPrincipal(gestor);
        menuPrincipal.mostrar();
    }
}