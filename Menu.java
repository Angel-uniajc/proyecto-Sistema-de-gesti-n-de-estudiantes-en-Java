import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private GestionEstudiantes gestion;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.gestion = new GestionEstudiantes();
    }

    public void mostrarMenu() { //método para mostrar el menú 
        int opcion = 0;

        do {
            System.out.println("\n========================================");
            System.out.println("  SISTEMA DE GESTIÓN DE ESTUDIANTES");
            System.out.println("========================================");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Eliminar estudiante");
            System.out.println("3. Buscar estudiante");
            System.out.println("4. Mostrar todos los estudiantes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            // Validar que se ingrese un número
            if (scanner.hasNextInt()) { // boooleano para ver si el valor registrado es un entero
                opcion = scanner.nextInt();
                scanner.nextLine(); 
                procesarOpcion(opcion);
            } else {
                System.out.println("⚠️ Opción inválida.");
                scanner.nextLine(); 
            }

        } while (opcion != 5);
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                solicitarRegistro();
                break;
            case 2:
                solicitarEliminacion();
                break;
            case 3:
                solicitarBusqueda();
                break;
            case 4:
                gestion.mostrarEstudiantes();
                break;
            case 5:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("⚠️ Opción fuera de rango.");
        }
    }

    // Pedir datos para registrar un nuevo estudiante
    private void solicitarRegistro() {
        System.out.println("\n--- REGISTRAR ESTUDIANTE ---");
        
        System.out.print("Ingrese ID: ");
        String id = scanner.nextLine().trim();

        // Validar si la identificación ya existe
        if (gestion.buscar(id) != null) {
            System.out.println("⚠️ Ya existe un estudiante con el ID: " + id);
            return;
        }

        System.out.print("Ingrese Nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Ingrese Apellido: ");
        String apellido = scanner.nextLine().trim();

        //objeto estudiante
        Estudiante nuevoEstudiante = new Estudiante(nombre, apellido, id);

        // Capturar las 3 notas requeridas
        System.out.println("Ingrese las 3 notas:");
        for (int i = 1; i <= 3; i++) {
            double nota = pedirNotaValida("Nota " + i + ": ");
            nuevoEstudiante.agregarnotas(nota);
        }

        // Guardar en la lista
        gestion.registrar(nuevoEstudiante);
    }

    // Pedir ID para eliminar
    private void solicitarEliminacion() {
        System.out.println("\n--- ELIMINAR ESTUDIANTE ---");
        System.out.print("Ingrese el ID: ");
        String id = scanner.nextLine().trim();
        gestion.eliminar(id);
    }

    // Pedir ID para buscar
    private void solicitarBusqueda() {
        System.out.println("\n--- BUSCAR ESTUDIANTE ---");
        System.out.print("Ingrese el ID: ");
        String id = scanner.nextLine().trim();

        Estudiante estudiante = gestion.buscar(id);

        if (estudiante != null) {
            System.out.println("\n--- Estudiante Encontrado ---");
            System.out.println("ID: " + estudiante.getId());
            System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellido());
            System.out.println("Notas: " + estudiante.getNotas());
            System.out.println("Promedio: " + estudiante.calcularPromedio());
            System.out.println("Estado: " + (estudiante.aprueba() ? "Aprobado" : "Reprobado"));
        } else {
            System.out.println("⚠️ No se encontró ningún estudiante con el ID: " + id);
        }
    }

    // Validar nota
    private double pedirNotaValida(String mensaje) {
        double nota = -1;
        while (nota < 0 || nota > 5) {
            System.out.print(mensaje);
            if (scanner.hasNextDouble()) {
                nota = scanner.nextDouble();
                if (nota < 0 || nota > 5) {
                    System.out.println("⚠️ La nota debe estar entre 0.0 y 5.0.");
                }
            } else {
                System.out.println("⚠️ Entrada inválida. Ingrese un número.");
                scanner.next(); 
            }
        }
        scanner.nextLine(); 
        return nota;
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        
        menu.mostrarMenu();
    }
}