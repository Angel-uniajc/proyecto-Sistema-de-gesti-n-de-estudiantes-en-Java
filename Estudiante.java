import java.util.ArrayList;
public class Estudiante {
    
    private String nombre; 
    private String apellido;
    private ArrayList<Double> notas;
    private String id;


    // Contructor estudiante con arrays para 3 notas 
        public Estudiante (String nombre, String apellido, String id)
        {      
            this.nombre = nombre;
            this.apellido = apellido;
            this.notas = new ArrayList<>();
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public String getApellido() {
            return apellido;
        }

        public String getNombre() {
            return nombre;
        }

        public ArrayList<Double> getNotas() {
            return notas;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }


        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setNotas(ArrayList<Double> notas) {
            this.notas = notas;
        }

        public void setId(String id) {
            this.id = id;
        }

        // Limitador de 3 notas por estudiante
        public void agregarnotas( double nota){

            if (notas.size() < 3){
                notas.add(nota);
            } else {
                System.out.println("El estudiante ya tiene 3 notas");
            }

        }

        //calcular promedio de cada estudiante
        public double calcularPromedio(){
            double suma = 0;            

            for ( int i = 0; i < notas.size(); i++){
                suma =+ notas.get(i);
            }

            double promedio = suma / notas.size(); 

            return promedio;
        }

        




}
