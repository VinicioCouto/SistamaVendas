import java.util.Scanner;

public class Supermercado {
    private Scanner scanner = new Scanner(System.in);
    private Produto produto = new Produto();
    private Cliente cliente = new Cliente();
    private Caixa caixa = new Caixa(0);
    private Vendas vendas = new Vendas();


    public void limparTela() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public void executarOpcao(int esc) {
        switch (esc) {
            case 1:
                mostrarProdutos();
                break;
            case 2:
                mostrarCliente();
                break;
            case 3:
                cadastrarNovoCliente();
                break;
            case 4:
                mostrarCaixa();
                break;
            case 5:
                venderProdutos();
                break;
            case 6:
                adicionarNovoProduto();
                break;
            case 7:
                limparTela();
                break;
            case 8:
                System.out.println("Saindo do programa. Até mais!");
                break;
            default:
                System.out.println("Número inválido");
        }
    }

    private void mostrarCaixa(){
        int mostrarCaixa = 1;
        do {
            caixa.MostrarCaixa();
            System.out.println("Digite > 0 para voltar ao menu");
            System.out.print("> ");
            mostrarCaixa = scanner.nextInt();
        } while (mostrarCaixa == 1);
    }

    private  void  mostrarCliente(){
        int mostrarCliente;
        do {
            cliente.ConsultarCliente();
            System.out.println("Digite > 0 para voltar ao menu");
            System.out.print("> ");
            mostrarCliente = scanner.nextInt();
        } while (mostrarCliente == 1);
    }


    private void mostrarProdutos() {
        int mostrarProduto;
        do {
            produto.MostrarProduto();
            System.out.println("Digite > 0 para voltar ao menu");
            System.out.print("> ");
            mostrarProduto = scanner.nextInt();
        } while (mostrarProduto == 1);
    }

    private void adicionarNovoProduto() {
        int cont, adicionar = 1;
        do {
            System.out.println("NOVO PRODUTO");
            System.out.println("Digite o nome do produto:");
            System.out.print("> ");
            String nomeproduto = scanner.next();
            System.out.println("Digite o preço por unidade do produto:");
            System.out.print("> ");
            String precoString = scanner.next();
            double precoproduto = Double.parseDouble(precoString);
            System.out.println("Digite a quantidade em estoque:");
            System.out.println("> ");
            int quantestoq = scanner.nextInt();
            System.out.println("Você realmente deseja adicionar esse novo produto?");
            System.out.println("Digite > 1 para SIM ou > 0 para Não:");
            System.out.print("> ");
            cont = scanner.nextInt();
            if (cont == 1) {
                produto.AdicionarProduto(nomeproduto, precoproduto, quantestoq);
                System.out.println("Novo Produto Adicionado com Sucesso!");
            } else {
                System.out.println("Cadastro não finalizado!");
            }
            System.out.println("Digite > 0 para voltar ao menu ou 1 para Adicionar Outro produto:");
            System.out.print("> ");
            adicionar = scanner.nextInt();
        } while (adicionar == 1);
    }

    private void cadastrarNovoCliente() {
        int cadastroVerificacao;
        do {
            System.out.println("Cadastrar um novo Cliente: ");
            System.out.print("Nome > ");
            String nomeCliente = scanner.next();
            System.out.print("Endereço > ");
            String enderecoCliente = scanner.next();
            System.out.println("Você realmente deseja cadastrar esse cliente?");
            System.out.println("Digite > 1 para confirmar ou > 0 para Cancelar");
            System.out.print("> ");
            int confirmacao = scanner.nextInt();
            if (confirmacao == 1) {
                cliente.CadastrarCliente(nomeCliente, enderecoCliente);
            } else {
                System.out.println("Novo Cliente cancelado com sucesso");
            }
            System.out.println("Digite > 0 para voltar ao menu ou > 1 para Cadastrar outro Cliente");
            System.out.print("> ");
            cadastroVerificacao = scanner.nextInt();
        } while (cadastroVerificacao == 1);
    }

    private void venderProdutos() {
        int venderVerificacao;
        do {
            System.out.println("VENDENDO: ");
            System.out.println("Digite o ID do Cliente/ Caso for Visitante digite 0");
            System.out.print("ID > ");
            int idCliente = scanner.nextInt();
            System.out.println("Digite o ID do Produto");
            System.out.print("ID > ");
            int idProduto = scanner.nextInt();
            System.out.println("Digite a quantidade de produtos comprados");
            System.out.print("Quantidade > ");
            int quantidade = scanner.nextInt();
            System.out.println("Você realmente deseja cadastrar essa venda?");
            System.out.println("Digite > 1 para confirmar ou > 0 para Cancelar");
            System.out.print("> ");
            int confirmacao = scanner.nextInt();
            if (confirmacao == 1) {
                vendas.realizarVenda(idCliente, idProduto, quantidade);
            } else {
                System.out.println("Venda cancelada com sucesso");
            }
            System.out.println("Digite > 0 para voltar ao menu ou > 1 para Cadastrar outra Venda");
            System.out.print("> ");
            venderVerificacao = scanner.nextInt();
        } while (venderVerificacao == 1);
    }

}