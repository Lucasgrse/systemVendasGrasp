package main;

import java.util.Scanner;

import Produto.Produto;
import Venda.Venda;
import cliente.Cliente;

public class systemVendasGrasp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Produto p1 = new Produto("Celular", 1000.0, 10);
        Produto p2 = new Produto("Computador", 2000.0, 5);
        Cliente c1 = new Cliente("João", "joao@email.com", "1234-5678", "");

        Venda venda = new Venda(c1);
        int opcao = mostrarMenu();
        while (opcao != 3) {
            if (opcao == 1) {
                adicionarProduto(venda);
            } else if (opcao == 2) {
                finalizarVenda(venda);
                break;
            }
            opcao = mostrarMenu();
        }
    }

    private static int mostrarMenu() {
        System.out.println("1. Adicionar Produto");
        System.out.println("2. Finalizar Venda");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    private static void adicionarProduto(Venda venda) {
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.next();
        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        Produto produto = getProdutoPorNome(nomeProduto);
        if (produto == null) {
            System.out.println("Produto não encontrado");
        } else {
            boolean sucesso = venda.addProduto(produto, quantidade);
            if (sucesso) {
                System.out.println("Produto adicionado com sucesso");
            } else {
                System.out.println("Estoque insuficiente");
            }
        }
    }
    private static Produto[] listaProdutos = {
        new Produto("Notebook", 1500.0, 10),
        new Produto("Mouse", 50.0, 10),
        new Produto("Teclado", 100.0, 10),
        new Produto("Monitor", 700.0, 10)
    };

    private static Produto getProdutoPorNome(String nome) {
        for (Produto p : listaProdutos) {
            if (p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
        
    }

    private static void finalizarVenda(Venda venda) {
        System.out.println("Preço total: " + venda.getPrecoTotal());
        System.out.println("Cliente: " + venda.getCliente().getNome());
    }
    
}


