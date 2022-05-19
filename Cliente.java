/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import classes.DB;

/**
 *
 * @author Usuário
 */
public class Cliente {
    
    protected int id;
    protected String nome;
    protected String email;
    protected int idade;
    protected String nickname;

    public Cliente(int id){
        if(id>0){
            String sql = "SELECT * FROM cliente WHERE id = ?";
            
            try{
                Connection con = DB.conexao();
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, id);
                ResultSet registro = stmt.executeQuery();
                
                while(registro.next()){
                    this.setId(registro.getInt("id"));
                    this.setNome(registro.getString("nome"));
                    this.setEmail(registro.getString("email"));
                    this.setIdade(registro.getInt("idade"));
                    this.setNickname(registro.getString("nickname"));
                }
                
            }catch(SQLException e){
                System.out.print("Erro na consulta de Cliente: "+e.toString());
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", idade=" + idade + ", nickname=" + nickname + '}';
    }
    
   
}
