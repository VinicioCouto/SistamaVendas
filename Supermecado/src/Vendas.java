import java.util.ArrayList;
import java.util.Scanner;

public class Vendas {
    private Produto produto = new Produto();
    private Cliente cliente = new Cliente();
    private Caixa caixa = new Caixa(0);
    private ArrayList<String> historico;
    private double valorDaVenda;
    private int idVenda;




    public Vendas(Produto produto, Cliente cliente, Caixa caixa, ArrayList<String> historico, double valorDaVenda, int idVenda) {
        this.produto = produto;
        this.historico = historico;
        this.valorDaVenda = valorDaVenda;
        this.idVenda = idVenda;
    }

    public Vendas() {
        this.produto = new Produto();
        this.historico = new ArrayList<>();
        this.valorDaVenda = 0.0;
        this.idVenda = 0;
    }


    public ArrayList<String> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<String> historico) {
        this.historico = historico;
    }

    public double getValorDaVenda() {
        return valorDaVenda;
    }

    public void setValorDaVenda(double valorDaVenda) {
        this.valorDaVenda = valorDaVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public boolean realizarVenda(int idCliente, int idProduto, int quantidade) {
        String escolha2;
        Scanner scanner = new Scanner(System.in);
        double soma = produto.getPreco(idProduto) * quantidade;

        do {
            System.out.println("Produto: " + produto.getNome(idProduto));
            System.out.println("------------------------");
            System.out.println("Valor unitário: R$" + String.format("%.2f", produto.getPreco(idProduto)));
            System.out.println("------------------------");
            System.out.println("Valor a pagar: R$" + String.format("%.2f", soma));
            System.out.println("------------------------");
            System.out.println("Deseja finalizar o pedido? (sim/nao)");
            System.out.print("> ");
            escolha2 = scanner.next();

            if (produto.getQuantidadeEmEstoque(idProduto) < quantidade) {
                System.out.println("Não temos estoque suficiente para completar a sua compra");
                System.out.println("Estoque restante: " + produto.getQuantidadeEmEstoque(idProduto));
                System.out.println("Digite 0 para voltar para o menu ou 1 para realizar outra compra:");
                System.out.print("> ");
                int escolha1 = scanner.nextInt();
                for (int i = 0; i < 30; i++) {
                    System.out.println();
                }
                if (escolha1 == 0) {
                    return false;
                }
            } else {
                if (escolha2.equals("sim")) {
                    caixa.registrarVenda(soma);
                    int quant1 = produto.getQuantidadeEmEstoque(idProduto) - quantidade;
                    produto.Editarestoque(idProduto, quant1);
                    System.out.println("Obrigado pela preferência ");
                    System.out.println("Digite 0 para voltar para o menu ou 1 para realizar outra compra:");
                    System.out.print("> ");
                    int escolha1 = scanner.nextInt();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < 30; i++) {
                        System.out.println();
                    }
                    return true;
                } else {
                    System.out.println("Compra cancelada");
                    System.out.println("Digite 0 para voltar para o menu ou 1 para realizar outra compra:");
                    System.out.print("> ");
                    int escolha1 = scanner.nextInt();
                    for (int i = 0; i < 30; i++) {
                        System.out.println();
                    }
                    if (escolha1 == 0) {
                        return false;
                    }
                }
            }
        } while (true);
    }
}
