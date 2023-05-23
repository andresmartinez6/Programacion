package accesobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Accesobd {

    public static void main(String[] args) {
        Connection conexion;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager
                    .getConnection("jdbc:mysql://localhost/empresa",
                                   "root","");
            String nombre="Recursos humanos";
            String localizacion="Islas Caiman";
            
            String sql="INSERT INTO DEPARTAMENTOS "
                    +  "VALUES (NULL,'"+
                                nombre+"','"+
                                localizacion+"')";
            System.out.println(sql);
            
            Statement insertar=conexion.createStatement();
            
            insertar.executeUpdate(sql);
            
            insertar.close();
            
//            String consulta="SELECT * FROM departamentos";
//            Statement sentencia=conexion.createStatement();
//            
//            ResultSet resultado=sentencia.executeQuery(consulta);
//            
//            String salida="";
//            while(resultado.next()){
////                salida+="ID:"+resultado.getInt(1)+"\n"+
////                        "NOMBRE:"+resultado.getString(2)+"\n"+
////                        "LOC:"+resultado.getString(3)+"\n";
//                
//                salida+="ID:"+resultado.getInt("id")+"\n"+
//                        "NOMBRE:"+resultado.getString("nombre")+"\n"+
//                        "LOC:"+resultado.getString("localizacion")+"\n";
//            }
//            
//            System.out.println(salida);
//            
//            resultado.close();
//            sentencia.close();
            conexion.close();
        }catch(ClassNotFoundException cnfe){
            System.out.println("Error al cargar el driver");
        }catch(SQLException sqle){
            System.out.println("Error de SQL");
        }
        
    }
    
}
