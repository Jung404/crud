/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulos;
import classes.Cliente;
import classes.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuário
 */
public class Clientemodulo {
    public void adicionar(Cliente cliente) {
        String sql = "INSERT INTO cliente(id, nome, email, idade, nickname)VALUES(?, ?, ?,?,?)";

        try {
            Connection con = DB.conexao();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());
            stmt.setInt(4, cliente.getIdade());
            stmt.setString(5, cliente.getNickname());
            stmt.execute();

        } catch (SQLException e) {
            System.out.print("Erro no adicionar Cliente:" + e.getMessage());
        }
    }

    public static ArrayList<Cliente> listar() {
        String sql = "SELECT * FROM cliente";
        ArrayList<Cliente> cliente = new ArrayList<>();

        try {
            Connection con = DB.conexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet registros = stmt.executeQuery();

            while (registros.next()) {
                Cliente temp = new Cliente(0);
                temp.setId(registros.getInt("id"));
                temp.setNome(registros.getString("nome"));
                temp.setEmail(registros.getString("email"));
                temp.setIdade(registros.getInt("idade"));
                temp.setNickname(registros.getString("nickname"));

                cliente.add(temp);
            }

        } catch (SQLException e) {
            System.out.print("Erro no Listar Cliente:" + e.toString());
        }
        return cliente;
    }

    
      public void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, email = ?, idade = ?, nickname = ? WHERE id = ?";

        try {
            Connection con = DB.conexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setInt(3, cliente.getIdade());
            stmt.setString(4,cliente.getNickname());
            stmt.setInt(5, cliente.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.print("Erro no Atualizar:" + e.toString());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";

        try {
            Connection con = DB.conexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.print("Erro no excluir:" + e.toString());
        }
    }
    
}
