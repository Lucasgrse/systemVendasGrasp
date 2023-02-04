package Produto;

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public boolean verificarEstoque(int quantidade) {
        return quantidade <= quantidadeEstoque;
    }

    public void atualizarEstoque(int quantidade) {
        quantidadeEstoque -= quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidadeEstoque;
    }

    public void setQuantidade(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
