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

}