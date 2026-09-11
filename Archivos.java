import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

public class Archivos {
    
    private static final String name_archivo = "estudiantes.txt";  // Nombre del archivo

    // Método para guardar los datos en el archivo
    public static void guardarEstudiantes(ArrayList<Estudiante> estudiantes) {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(name_archivo))){ //creamos un metodo para guardar los datos en el archivo
            
            for (Estudiante estudiante : estudiantes) { //recorremos la lista de estudiantes

                writer.write( //escribimos cada estudiante en el archivo
                    estudiante.getId() + ";" + 
                    estudiante.getNombre() + ";" +
                    estudiante.getApellido() + ";"
                );
           
            ArrayList<Double> notas = estudiante.getNotas(); //obtenemos las notas del estudiante
                for ( int i = 0; i < notas.size(); i++){//recorrer  las notas
                    writer.write(String.valueOf(notas.get(i))); // para escribir cada nota

                    if( i < notas.size()-1){
                        writer.write(",");
                    }
                }
               writer.newLine(); //para escribir una nueva linea

    
        }
            System.out.println("save");

            
    

} catch (IOException e){
        System.out.println("ERROR AL GUARDAR");


}
}

 // Cargar estudiantes desde el archivo
    public static ArrayList<Estudiante> cargarEstudiantes() { //

        ArrayList<Estudiante> estudiantes = new ArrayList<>();//creamos una lista para guardar los estudiantes

        File archivo = new File(name_archivo); // Creamos un objeto File para el archivo

        // Si el archivo no existe, devuelve una lista vacía
        if (!archivo.exists()) {
            return estudiantes;
        }

        try (BufferedReader lector = new BufferedReader(
                new FileReader(name_archivo))) {

            String linea;

            while ((linea = lector.readLine()) != null) {

                String[] datos = linea.split(";");

                String id = datos[0];
                String nombre = datos[1];
                String apellido = datos[2];
                String notasTexto = datos[3];

                Estudiante estudiante = new Estudiante(
                    nombre,
                    apellido,
                    id
                );

                if (!notasTexto.isEmpty()) {
                    String[] notasArray = notasTexto.split(",");

                    for (String notaStr : notasArray) {
                        estudiante.agregarnotas(Double.parseDouble(notaStr));
                    }
                }

                estudiantes.add(estudiante);
            }

            return estudiantes;

        } catch (IOException e) {
            System.out.println("ERROR AL CARGAR");
            return estudiantes;
        }
    }
}
