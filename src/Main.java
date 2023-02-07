/*
1. Crear la BBDD dado el fichero SQL adjunto // done
2. Insertar dos ambulatorios
3. Insertar tres pacientes (uno en un ambulatorio y dos en el otro) con foto incluida
4. Vacunar a 2 pacientes con una vacuna cada uno y a un tercer con tres (las vacunas ya están creadas)
5. Cambiar la foto a un paciente
6. Listar todos los pacientes por ambulatorio con las vacunas puestas
7. Eliminar un paciente dado su nsip (suponemos que siempre exist
*/

//Examen de segunda evaluacion Sorin C

// no me ha dadotiempo hacer el metodo para leer ...

public class Main {

    
    
    public static void main(String[] args) {
       
    Gestor_conexion conexion = new Gestor_conexion();
    
    conexion.insertar_BBDD("ambulatorio.sql"); // aqui creamos e insertamos en MySQL la base de datos ambulatorio
    
    Ambulatorio Grao = new Ambulatorio(1, "La Marina", "Calle Alonso 13", "934 756 263");
    Ambulatorio Castellon = new Ambulatorio(2, "General", "Calle Herreros 56", "904 342 222");
    
    //Creamos los ambulatorios y los metemos en la BBDD
    
    conexion.insertar_ambulatorio_MySQL(Grao);
    conexion.insertar_ambulatorio_MySQL(Castellon);
    /*
    Pacientes Pepe = new Pacientes(123456789, "Alejandro", "Espanyol", 50, 1);
    Pacientes Putin = new Pacientes(987654321, "Putin", "Mama Russia", 55, 2);
    Pacientes Trump = new Pacientes(123451234, "Trump", "Mama America", 54, 2);
    */
    // Creamos abajo los pacientes y los insertamos en la base de datos con los blobs
    /*
    conexion.insertar_paciente_MySQL(1, Pepe, "pepe.jpg");
    conexion.insertar_paciente_MySQL(1, Putin, "eva.jpg");
    conexion.insertar_paciente_MySQL(2, Trump, "eva2.jpg");
    */
    // abajo tenemos el metodo para insertar vacunas nuevas con el objeto de composicion
    /*
    Vacunas Jonson = new Vacunas("Johnson"); // creamos una vacuna de la clase composicion
    Composicion comp = new Composicion("Activo", 2, "Algo", 4); 
    conexion.insertar_vacunas_MySQL(Jonson, comp); // llamamos a lmetodo de insertar_vacuna para insertarla en la bbdd
    */
    /*
    Vacuna_paciente vac1 = new Vacuna_paciente(123456789, 1, 1); // creamos la vacuna y la asignamos a un cliente
    Vacuna_paciente vac2 = new Vacuna_paciente(987654321, 7, 2);
    Vacuna_paciente vac3 = new Vacuna_paciente(123451234, 1, 1);
    Vacuna_paciente vac4 = new Vacuna_paciente(123451234, 2, 2);
    Vacuna_paciente vac5 = new Vacuna_paciente(123451234, 3, 3);
    
    conexion.insertar_vacuna_MySQL(vac1); // llamamos al metodo de insercion de vacunas
    conexion.insertar_vacuna_MySQL(vac2);
    conexion.insertar_vacuna_MySQL(vac3);
    conexion.insertar_vacuna_MySQL(vac4);
    conexion.insertar_vacuna_MySQL(vac5);
    */
    // primero he promabo el delete si me borra primero un paciente antes de meter datos en la tabla "vacuna_paciente"
    //conexion.delete_paciente_from_MySQL(987654321); // metodo para eliminar paciente dado en numero sip
    
    //conexion.update_blob_paciente(987654321, "eva.jpg");
    conexion.leer_tablas_MySQL();
    
    conexion.close();
    
    }
    
}
