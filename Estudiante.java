public class Estudiante {
    
    private String nombre; 
    private String apellido;
    private double[] notas;
    private int cantidadNotasIngresadas;


    // Contructor estudiante con arrays para 3 notas 
        public Estudiante (String nombre, String apellido, int cantidadNotasIngresadas)
        {      
            this.nombre = nombre;
            this.apellido = apellido;
            this.notas = new double[3];
            this.cantidadNotasIngresadas = 0;
        }

        




}
