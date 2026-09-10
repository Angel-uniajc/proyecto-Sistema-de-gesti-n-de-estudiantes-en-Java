import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

            
    

} catch (IOException)
        System.out.println("ERROR AL GUARDAR");
        

}
}
