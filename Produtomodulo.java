/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulos;
import classes.Cliente;
import classes.Produto;
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
public class Produtomodulo {
    public void adicionar(Produto produto) {
        String sql = "INSERT INTO produto(id, modelo, marca, preco, quantidade)VALUES(?, ?, ?,?,?)";

        try {
            Connection con = DB.conexao();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getModelo());
            stmt.setString(3, produto.getMarca());
            stmt.setDouble(4, produto.getPreco());
            stmt.setInt(5, produto.getQuantidade());
            stmt.execute();

        } catch (SQLException e) {
            System.out.print("Erro no adicionar produto:" + e.getMessage());
        }
    }

    public static ArrayList<Produto> listar() {
        String sql = "SELECT * FROM produto";
        ArrayList<Produto> produto = new ArrayList<>();

        try {
            Connection con = DB.conexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet registros = stmt.executeQuery();

            while (registros.next()) {
                Produto temp = new Produto(0);
                temp.setId(registros.getInt("id"));
                temp.setModelo(registros.getString("modelo"));
                temp.setMarca(registros.getString("marca"));
                temp.setPreco(registros.getDouble("preco"));
                temp.setQuantidade(registros.getInt("quantidade"));

                produto.add(temp);
            }

        } catch (SQLException e) {
            System.out.print("Erro no Listar Cliente:" + e.toString());
        }
        return produto;
    }

    
      public void atualizar(Produto produto) {
        String sql = "UPDATE produto SET modelo = ?, marca = ?, preco = ?, quantidade = ? WHERE id = ?";

        try {
            Connection con = DB.conexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getModelo());
            stmt.setString(2, produto.getMarca());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4,produto.getQuantidade());
            stmt.setInt(5, produto.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.print("Erro no Atualizar:" + e.toString());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";

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
