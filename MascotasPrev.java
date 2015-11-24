/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotasprev;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class MascotasPrev {

    
    public static void main(String[] args) {
    String usuario="root";
        String clave="";
        Scanner in=new Scanner(System.in);
        Menu m=new Menu();
        boolean salir=false;
        while(salir==false){
            m.mostrarmenu();
            int opcion=Integer.parseInt(in.nextLine());
            switch(opcion){
                case 1:{
                    m.opcioninsert();
                    break;
                }
                case 2:{
                    m.opcioneliminar();
                    break;
                }
                case 3:{
                    m.opcionActualizar();
                    break;
                }
                
            }
        
        
        
        }
    }
    
    
}
class Menu{
    public void mostrarmenu(){
    System.out.println("1. insertar");
    System.out.println("2. eliminar");
    System.out.println("3. actualizar");
    System.out.println("4. mostrar");
    System.out.println("5. buscar");
    System.out.println("6. creditos");
    System.out.println("7. salir");
    System.out.println("ELEGIR UNA OPCION");
    }
    public void opcioninsert(){
      String usuario="root";
      String clave="";
      Scanner in=new Scanner(System.in);
        
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            String url="jdbc:mysql://localhost:3306/progra01";
            Connection con=DriverManager.getConnection(url,usuario,clave);
            Statement stmt=con.createStatement();
            System.out.println("Ingrese nombre");
            String nombre= in.nextLine();
            System.out.println("Ingrese edad");
            int edad=Integer.parseInt(in.nextLine());
            System.out.println("Ingrese peso");
            String peso=in.nextLine();
            stmt.executeUpdate("insert into Mascotas(nombre,edad,peso) values('"+nombre+"','"+edad+"','"+peso+"')");
            }catch(Exception ex){
            System.out.println("ERROR:"+ex.getMessage());
            }

    }
    // esultSet resultado = stmt.executeQuery(select * from mascotas);
    
    public void opcioneliminar(){
      String usuario="root";
      String clave="";
      Scanner in=new Scanner(System.in);
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            String url="jdbc:mysql://localhost:3306/progra01";
            Connection con=DriverManager.getConnection(url,usuario,clave);
            Statement stmt=con.createStatement();
            System.out.println("Ingrese id del usuario que quiere eliminar");
            int idu=Integer.parseInt(in.nextLine());
            stmt.executeUpdate("delete from Usuarios where usuario_id="+idu);
            }catch(Exception ex){
            System.out.println("ERROR:"+ex.getMessage());
            }
    
    }
    public void opcionActualizar(){
      String usuario="root";
      String clave="";
      Scanner in=new Scanner(System.in);
      System.out.println("1.Nombre");
      System.out.println("2.edad");
      System.out.println("3.peso");
      System.out.println("4.volver");
      System.out.println("ELEGIR UNA OPCION");
      boolean volver=false;
      int opcion=Integer.parseInt(in.nextLine());
        while(volver=false){        
                switch(opcion){
                    case 1:{
                       try{
                    Class.forName("org.gjt.mm.mysql.Driver");
                    String url="jdbc:mysql://localhost:3306/progra01";
                    Connection con=DriverManager.getConnection(url,usuario,clave);
                    Statement stmt=con.createStatement();
                    System.out.println("INGRESE NOMBRE");
                    String nombre=in.nextLine();
                    System.out.println("INGRESE ID DEL USUARIO");
                    int id=Integer.parseInt(in.nextLine());
                    stmt.executeUpdate("update Usuarios set nombre='"+nombre+"' where usuario_id="+id);
                    }catch(Exception ex){
                    System.out.println("ERROR:"+ex.getMessage());
                    break;
                    }

                    }
                    case 2:{
                            try{
                          Class.forName("org.gjt.mm.mysql.Driver");
                          String url="jdbc:mysql://localhost:3306/progra01";
                          Connection con=DriverManager.getConnection(url,usuario,clave);
                          Statement stmt=con.createStatement();
                          System.out.println("INGRESE EDAD");
                          String nombre=in.nextLine();
                          System.out.println("INGRESE ID DEL USUARIO");
                          int id=Integer.parseInt(in.nextLine());
                          stmt.executeUpdate("update Usuarios set edad='"+nombre+"' where usuario_id="+id);
                          }catch(Exception ex){
                          System.out.println("ERROR:"+ex.getMessage());
                          break;
                          }     
                    }
                    case 3:{
                              try{
                          Class.forName("org.gjt.mm.mysql.Driver");
                          String url="jdbc:mysql://localhost:3306/progra01";
                          Connection con=DriverManager.getConnection(url,usuario,clave);
                          Statement stmt=con.createStatement();
                          System.out.println("INGRESE PESO");
                          String nombre=in.nextLine();
                          System.out.println("INGRESE ID DEL USUARIO");
                          int id=Integer.parseInt(in.nextLine());
                          stmt.executeUpdate("update Usuarios set peso='"+nombre+"' where usuario_id="+id);
                          }catch(Exception ex){
                          System.out.println("ERROR:"+ex.getMessage());
                          break;
                          }
                    }
                    case 4:{
                        volver=true;
                        break;
                    }
            }
        }        
    
    }
    
    
    
}