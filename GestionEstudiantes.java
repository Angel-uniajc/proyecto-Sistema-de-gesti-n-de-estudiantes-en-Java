import java.util.ArrayList;
import java.util.Scanner;

public class GestionEstudiantes {
    //ArrayList para almacenar los estudiantes
    private ArrayList<Estudiante> estudiantes;

    //Constructor de la clase GestionEstudiantes
    public GestionEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }

    // Registrar un nuevo estudiante
    public void registrar(Estudiante estudiante) {
        // Evita registrar un id duplicado
        if (buscar(estudiante.getId()) != null) {
            System.out.println("Ya existe un estudiante con el id " + estudiante.getId());
            return;
        }
        estudiantes.add(estudiante);
        System.out.println("Estudiante registrado correctamente.");
    }

    // Eliminar un estudiante por id
    public boolean eliminar(String id) {
        Estudiante estudiante = buscar(id);
        if (estudiante != null) {
            estudiantes.remove(estudiante);
            System.out.println("Estudiante eliminado correctamente.");
            return true;
        }
        System.out.println("No se encontró un estudiante con el id " + id);
        return false;
    }

    // Buscar un estudiante por id
    public Estudiante buscar(String id) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId().equals(id)) {
                return estudiante;
            }
        }
        return null;
    }

    // Mostrar todos los estudiantes registrados
    public void mostrarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        // Mostrar la información de cada estudiante
        System.out.println("----- Lista de estudiantes -----");
        for (Estudiante estudiante : estudiantes) {
            System.out.println("ID: " + estudiante.getId());
            System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellido());
            System.out.println("Notas: " + estudiante.getNotas());
            System.out.println("Promedio: " + estudiante.calcularPromedio());
            System.out.println("Aprueba: " + (estudiante.aprueba() ? "Sí" : "No"));
            System.out.println("---------------------------------");
        }
    }

    // Getter para obtener la lista de estudiantes
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

}