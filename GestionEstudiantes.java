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

}