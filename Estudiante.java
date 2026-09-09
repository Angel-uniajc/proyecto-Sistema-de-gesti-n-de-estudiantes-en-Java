public class Estudiante {
    
    private String nombre; 
    private String apellido;
    private double[] notas;
    private int cantidadNotasIngresadas;


    // Contructor estudiante con arrays para 3 notas 
        public Estudiante (String nombre, String apellido)
        {      
            this.nombre = nombre;
            this.apellido = apellido;
            this.notas = new double[3];
            this.cantidadNotasIngresadas = 0;
        }

        public String getApellido() {
            return apellido;
        }

        public int getCantidadNotasIngresadas() {
            return cantidadNotasIngresadas;
        }
        
        public String getNombre() {
            return nombre;
        }

        public double[] getNotas() {
            return notas;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public void setCantidadNotasIngresadas(int cantidadNotasIngresadas) {
            this.cantidadNotasIngresadas = cantidadNotasIngresadas;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        
        public void setNotas(double[] notas) {
            this.notas = notas;
        }
        
        public boolean agregarnotas( double nota){

            if (cantidadNotasIngresadas < notas.length){
                notas[cantidadNotasIngresadas] = nota;
                cantidadNotasIngresadas ++;
                return true;
            }

            return false; 
        }

        




}
