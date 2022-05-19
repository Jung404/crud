/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuário
 */
public class DB {
    public static String servidor = "127.0.0.1:3306";
    public static String usuario = "root";
    public static String senha = "";
    public static String nome_banco = "aula_java";

    public static Connection conexao(){
        Connection conexao = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(
                "jdbc:mysql://"+servidor+"/"+nome_banco+"?useTimezone=true&serverTimezone=UTC", usuario, senha
            );

        }catch(SQLException e){
            System.out.print("Erro de conexão:"+ e.toString());
        }catch(ClassNotFoundException e){
            System.out.print("Classe não encontrada:"+ e.toString());
        }

        return conexao;

   }
    
}
