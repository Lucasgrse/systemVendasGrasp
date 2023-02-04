package Venda;

import java.util.ArrayList;
import java.util.List;

import Pagamento.Pagamento;
import Produto.Produto;
import cliente.Cliente;

public class Venda {
    private Cliente cliente;
    private Produto produto;
    private int quantidade;
    private double precoTotal;
    private Pagamento pagamento;
    private List<ItemVenda> itens;

    public Venda(Cliente cliente, Produto produto, int quantidade) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoTotal = produto.getPreco() * quantidade;
        this.pagamento = null;
    }
    public Venda(Cliente cliente) {
        this.itens = new ArrayList<>();
        this.cliente = cliente;
    }

    private class ItemVenda {
        private Produto produto;
        private int quantidade;

        public ItemVenda(Produto produto, int quantidade) {
            this.produto = produto;
            this.quantidade = quantidade;
    }

        public double getPreco() {
            return produto.getPreco() * quantidade;
        }
    }

    public void addItem(Produto produto, int quantidade) {
        itens.add(new ItemVenda(produto, quantidade));
    }

    public boolean addProduto(Produto produto, int quantidade) {
        if (produto.verificarEstoque(quantidade)) {
            itens.add(new ItemVenda(produto, quantidade));
            produto.atualizarEstoque(quantidade);
            return true;
        } else {
            return false;
        }
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoTotal() {
        double precoTotal = 0;
        for (ItemVenda item : itens) {
            precoTotal += item.getPreco();
        }
        return precoTotal;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
