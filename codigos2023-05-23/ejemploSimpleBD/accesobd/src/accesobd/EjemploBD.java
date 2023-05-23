package accesobd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EjemploBD {

    public static void main(String[] args) {
        
        try {
            Connection conexion;
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa",
                    "root", //usuario de la BD
                    ""); //contraseña
           
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT * FROM departamentos";
            ResultSet resul = sentencia.executeQuery(sql);
            String salida="";
            
            while (resul.next()) {
                salida+=resul.getInt("id")+"\n"+
                        resul.getString("nombre")+"\n"+
                        resul.getString("localizacion")+"\n"+
                        "-------------------------------\n";
            }
            
            System.out.println("DEPARTAMENTOS: \n"+salida);
            String nombre="Pepinos";
            String localizacion="Carchuna";
            sql = "INSERT INTO departamentos VALUES (NULL,'"+nombre+"', '"+localizacion+"')";
            
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            
            localizacion="Torrenueva";
            sql = "UPDATE departamentos SET localizacion='"+localizacion+"' WHERE nombre='"+nombre+"';";
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            
            sql = "DELETE FROM departamentos WHERE localizacion='"+localizacion+"'";
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            
            
            resul.close();
            sentencia.close();
            conexion.close();
            
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null,"Falta libreria MySQL");
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null,"Error de SQL\n"+sqle.getMessage());
        }
        
    }

}
