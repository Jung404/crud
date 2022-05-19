/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;
import classes.Cliente;
import classes.Produto;
import modulos.Clientemodulo;
import modulos.Produtomodulo;
import java.util.ArrayList;

/**
 *
 * @author Usuário
 */
public class Crud {
     public static void main(String[] args) {

        Cliente cliente = new Cliente(3);
        Clientemodulo c1 = new Clientemodulo();

        cliente.setId(3);
        cliente.setNome("Lucas");
        cliente.setEmail("joaozinho157@hotmail.com");
        cliente.setIdade(25);
        cliente.setNickname("Indisponível");
        // c1.adicionar(cliente);
       // c1.atualizar(cliente);
        //c1.excluir(0);

        ArrayList<Cliente> clientes = c1.listar();

        for (Cliente cliente1 : clientes) {
            int id = cliente1.getId();
            String nome = cliente1.getNome();
            String email = cliente1.getEmail();
            int idade = cliente1.getIdade();
            String nickname = cliente1.getNickname();

            

        }
        System.out.print(clientes);

        Produto produto =  new Produto(2);
        Produtomodulo p1 = new Produtomodulo();
        
        produto.setId(2);
        produto.setModelo("guitarra");
        produto.setMarca("HellWord");
        produto.setPreco(300.47);
        produto.setQuantidade(2);
        p1.atualizar(produto);
       
         ArrayList<Produto> produtos = p1.listar();

        for (Produto produto1 : produtos) {
            int id = produto1.getId();
            String modelo = produto1.getModelo();
            String marca = produto1.getMarca();
            double preço = produto1.getPreco();
            int quantidade = produto1.getQuantidade();

            

        }
        
        System.out.print(produtos);
        
        
    }

}
