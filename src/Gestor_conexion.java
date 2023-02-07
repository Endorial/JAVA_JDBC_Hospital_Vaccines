
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gestor_conexion {

    Statement st = null;

    Connection conexion = null;
    // creates the connexion 
    
    public Gestor_conexion() {

        try {

            String url = "jdbc:mysql://localhost:3306/";
            String user = "root";
            String password = "";
            conexion = DriverManager.getConnection(url, user, password);

            if (conexion != null) {
                System.out.println("Conectado al servidor MySql.");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR: No se a podido conectar con el servidor.");
            ex.printStackTrace();
        }
    }
    // close the conexion
    public void close() {
        try {
            conexion.close();
            System.out.println("Desconectado MySQL.");
        } catch (SQLException ex) {
            System.out.print("ERROR: Al cerrar la conexión.");
            ex.printStackTrace();
        }
    }
    
    public void insertar_BBDD(String archivo) { // // creates the database and access the sql file

        String consulta = "";
        String linea;
        try {

            FileReader f = new FileReader(archivo);
            BufferedReader br = new BufferedReader(f);
            Statement stmt = (Statement) conexion.createStatement();

            do {

                linea = br.readLine();
                if (linea != null) {
                    if (!linea.equals("") && !linea.substring(0, 1).equals("-")) {

                        if (!linea.substring((linea.length() - 1), linea.length()).equals(";")) {
                            consulta += linea;
                        } else {
                            consulta += linea;
                            stmt.executeUpdate(consulta);
                            consulta = "";
                        }
                    }
                }

            } while (linea != null);
            br.close();
            System.out.println("BBDD insertada correctamente");
        } catch (SQLException ex) {
            System.out.println("ERROR: Al hacer un Insert");
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Gestor_conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void useMySQL() { // this method we use for the methods so they know what database to use which in this case is "salud"
        try {
            Statement st = conexion.createStatement();
            String consulta = "USE salud";
            ResultSet rs = st.executeQuery(consulta);

        } catch (SQLException ex) {
            Logger.getLogger(Gestor_conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertar_ambulatorio_MySQL(Ambulatorio ambul) { // method to insert ambulatorio

        useMySQL();

        String sql = "INSERT INTO ambulatorios(ncodigo, cnombre, cdireccion, ctelefono) VALUES (?,?,?,?)";
        try {
            // set all the preparedstatement parameters
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setInt(1, ambul.getNcodigo());
            st.setString(2, ambul.getCnombre());
            st.setString(3, ambul.getCdireccion());
            st.setString(4, ambul.getCtelefono());

            // execute the preparedstatement insert
            int result = st.executeUpdate();
            st.close();
        } catch (SQLException se) {
            try {
                // log exception
                throw se;
            } catch (SQLException ex) {
                Logger.getLogger(Gestor_conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void insertar_paciente_MySQL(int nr,Pacientes paciente, String foto) { // method to insert patient

        useMySQL();

        //ByteArrayOutputStream ba = new ByteArrayOutputStream();
        //ObjectOutputStream oos;
        String consulta = "INSERT INTO pacientes(nsip, cnombre, capellidos, nedad, nambulatorio, bfoto) VALUES(?,?,?,?,?,?);";

        try {
            FileInputStream fis = new FileInputStream(foto);
            //oos = new ObjectOutputStream(ba);
            //oos.writeObject(o);
            PreparedStatement ps = conexion.prepareStatement(consulta);

            ps.setInt(1, paciente.getNsip());
            ps.setString(2, paciente.getCnombre());
            ps.setString(3, paciente.getCapellidos());
            ps.setInt(4, paciente.getNedad());
            ps.setInt(5, paciente.getNambulatorio());
            ps.setBinaryStream(6, fis);
            //ps.setBytes(4, ba.toByteArray());
            ps.executeUpdate();

            fis.close();
            //ba.close();
            ps.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Gestor_conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Gestor_conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Gestor_conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertar_vacunas_MySQL(Vacunas vacuna, Object o) { // method to insert vaccines

        useMySQL();

        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        String consulta = "INSERT INTO vacunas( cnombre, bcomposicion) VALUES(?,?);";

        try {
            oos = new ObjectOutputStream(ba);
            oos.writeObject(o);
            PreparedStatement ps = conexion.prepareStatement(consulta);

            ps.setString(1, vacuna.getCnombre());
            ps.setBytes(2, ba.toByteArray());
            ps.executeUpdate();

            ba.close();
            ps.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Gestor_conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Gestor_conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Gestor_conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete_paciente_from_MySQL(int sip) { // method that eliminates patient from database

        useMySQL();

        String sql = "DELETE FROM vacuna_paciente WHERE npaciente=" + sip;
        String sql2 = "DELETE FROM pacientes WHERE nsip=" + sip;

        try {
            Statement stmt = conexion.createStatement();

            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            //stmt.executeUpdate(sql2);
            System.out.println("Dato borrado succesfully xD");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertar_vacuna_MySQL(Vacuna_paciente vacuna) { // method to insert vaccine
        useMySQL();

        String consulta = "INSERT INTO vacuna_paciente(npaciente, nvacuna, ndosis) VALUES(?,?,?);";

        try {

            PreparedStatement ps = conexion.prepareStatement(consulta);

            ps.setInt(1, vacuna.getNpaciente());
            ps.setInt(2, vacuna.getNvacuna());
            ps.setInt(3, vacuna.getNdosis());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Gestor_conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update_blob_paciente(int sip, String foto) { // method that updates the immage  in patient
        useMySQL();
        PreparedStatement pstmt;
        try {
            pstmt = conexion.prepareStatement("UPDATE pacientes set bfoto =? WHERE nsip =" + sip);

            File blob = new File(foto);
            FileInputStream in = new FileInputStream(blob);

            pstmt.setBinaryStream(1, in, (int) blob.length());
            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Gestor_conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Gestor_conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void leer_pacientes() { // reads patient 

        useMySQL();

        Object dato = null;
        Statement stmt;
        try {
            stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pacientes");

            if (rs.next()) {
                Blob blob = rs.getBlob("bfoto");
                long blobLength = blob.length();

                int pos = 1;
                int len = 10;
                byte[] bytes = blob.getBytes(pos, len);

                InputStream is = blob.getBinaryStream();
                int b = is.read();
                System.out.println();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Gestor_conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Gestor_conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public void leer_tablas_MySQL()  { // reads mysql tables
        useMySQL();

        Object dato = null;
        Statement stmt_1;
        Statement stmt_2;
        Statement stmt_3;
        Statement stmt_4;
        Statement stmt_5;
           
        try {
            stmt_1 = conexion.createStatement();
            stmt_2 = conexion.createStatement();
            stmt_3 = conexion.createStatement();
            stmt_4 = conexion.createStatement();
            stmt_5 = conexion.createStatement();
            ResultSet ambulatorio = stmt_1.executeQuery     ("SELECT cnombre FROM ambulatorios");
            ResultSet nombre_paciente = stmt_2.executeQuery ("SELECT cnombre, capellidos, nedad FROM pacientes");
            ResultSet vacuna = stmt_3.executeQuery          ("SELECT cnombre FROM vacunas");
            ResultSet vacuna_paciente = stmt_4.executeQuery ("SELECT ndosis FROM vacuna_paciente");
            ResultSet activo = stmt_5.executeQuery          ("SELECT cnombre FROM vacunas");
            
            while (ambulatorio.next()) {
                Ambulatorio amb = new Ambulatorio();
                amb.setCnombre(ambulatorio.getString("cnombre"));

                System.out.println("Ambulatorio : "+amb.getCnombre());
                
                while (nombre_paciente.next()) {
                    Pacientes pac = new Pacientes();
                    pac.setCnombre(nombre_paciente.getString("cnombre"));
                    pac.setCapellidos(nombre_paciente.getString("capellidos"));
                    pac.setNedad(nombre_paciente.getInt("nedad"));
                    
                    System.out.println(" Nombre : " + pac.getCnombre()+ ", Apellidos : " + pac.getCapellidos()+ ", Edad: "+ pac.getNedad());
                    
                    while (vacuna.next()) {
                        Vacunas vac = new Vacunas();
                        vac.setCnombre(vacuna.getString("cnombre"));  
                        
                        System.out.println("   "+", Vacuna : "+vac.getCnombre());
                        
                            while (vacuna_paciente.next()) {
                                Vacuna_paciente vac_p = new Vacuna_paciente();
                                vac_p.setNdosis(vacuna_paciente.getInt("ndosis"));  

                                System.out.print("   "+", Dosis : "+vac_p.getNdosis());
                                
                            } 
                    }    
                }
            }
        
        ambulatorio.close();
        nombre_paciente.close();
        vacuna.close();
        vacuna_paciente.close();
        vacuna_paciente.close();
        
        stmt_1.close();
        stmt_2.close();
        stmt_3.close();
        stmt_4.close();
        stmt_5.close();
        }
        
        catch (SQLException ex) {
            Logger.getLogger(Gestor_conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
