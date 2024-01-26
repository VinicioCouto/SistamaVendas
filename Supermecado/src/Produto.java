import java.util.ArrayList;

public class Produto {
    private static ArrayList<Integer> idProduto;
    private static ArrayList<String> nome;
    private static ArrayList<Double> preco;
    private static ArrayList<Integer> quantidadeEmEstoque;
    private int contid = 0;

    public Produto() {
        idProduto = new ArrayList<>();
        nome = new ArrayList<>();
        preco = new ArrayList<>();
        quantidadeEmEstoque = new ArrayList<>();


        AdicionarProduto("Arroz", 5.99, 50);
        AdicionarProduto("Feijão", 3.49, 30);
        AdicionarProduto("Óleo de Soja", 2.99, 20);
        AdicionarProduto("Macarrão", 1.99, 40);
    }

    public int getIdProduto(int index) {
        return idProduto.get(index);
    }

    public void setIdProduto(int index, int idProduto) {
        this.idProduto.set(index, idProduto);
    }

    public String getNome(int id) {
        if (id >= 0 && id < nome.size()) {
            return nome.get(id);
        } else {
            System.out.println("Índice do produto inválido.");
            return "";
        }
    }

    public void setNome(int index, String nome) {
        this.nome.set(index, nome);
    }

    public double getPreco(int id) {
        if (id >= 0 && id < preco.size()) {
            return preco.get(id);
        } else {
            System.out.println("Índice do produto inválido.");
            return 0.0;
        }
    }

    public void setPreco(int index, double preco) {
        this.preco.set(index, preco);
    }

    public int getQuantidadeEmEstoque(int id) {
        if (id >= 0 && id < quantidadeEmEstoque.size()) {
            return quantidadeEmEstoque.get(id);
        } else {
            System.out.println("Índice do produto inválido.");
            return 0;
        }
    }

    public void setQuantidadeEmEstoque(int index, int quantidadeEmEstoque) {
        this.quantidadeEmEstoque.set(index, quantidadeEmEstoque);
    }

    public boolean AdicionarProduto(String nome, double preco, int quantidadeEmEstoque) {
        this.idProduto.add(contid);
        this.nome.add(nome);
        this.preco.add(preco);
        this.quantidadeEmEstoque.add(quantidadeEmEstoque);
        contid++;
        return true;
    }

    public void MostrarProduto() {
        for (int i = 0; i < idProduto.size(); i++) {
            System.out.println("ID do Produto: " + getIdProduto(i));
            System.out.println("Nome do Produto: " + getNome(i));
            System.out.println("Preço do Produto: " + getPreco(i));
            System.out.println("Quantidade em Estoque: " + getQuantidadeEmEstoque(i));
            System.out.println("");
        }
    }

    public boolean EditarProduto(int index, int novoIdProduto, String novoNome, double novoPreco, int novaQuantidade) {
        this.idProduto.set(index, novoIdProduto);
        this.nome.set(index, novoNome);
        this.preco.set(index, novoPreco);
        this.quantidadeEmEstoque.set(index, novaQuantidade);
        return true;
    }

    public boolean Editarestoque(int id, int novaQuantidade) {
        this.quantidadeEmEstoque.set(id, novaQuantidade);
        System.out.println("Venda registrada. Quantidade atual em estoque: " + getQuantidadeEmEstoque(id));
        return true;
    }

    public boolean RemoverProduto(int index) {
        if (index >= 0 && index < idProduto.size()) {
            this.idProduto.remove(index);
            this.nome.remove(index);
            this.preco.remove(index);
            this.quantidadeEmEstoque.remove(index);
            return true;
        } else {
            System.out.println("Índice do produto inválido.");
            return false;
        }
    }

    public void AtualizarEstoque(int index, int novaQuantidade) {
        if (index >= 0 && index < quantidadeEmEstoque.size()) {
            this.quantidadeEmEstoque.set(index, novaQuantidade);
        } else {
            System.out.println("Índice do produto inválido.");
        }
    }
}
