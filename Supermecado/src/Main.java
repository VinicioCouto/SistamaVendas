import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Supermercado supermercado = new Supermercado();


        int esc;
        do {
            supermercado.limparTela();
            System.out.println("-- SUPERMERCADO.com --");
            System.out.println("-------- Menu --------");
            System.out.println("1- Mostrar Produtos em Estoque");
            System.out.println("2- Mostrar Clientes");
            System.out.println("3- Cadastrar Novo Cliente");
            System.out.println("4- Mostrar Dinheiro em Caixa");
            System.out.println("5- Vender Produtos");
            System.out.println("6- Adicionar Novo Produto");
            System.out.println("7- Limpar Tela");
            System.out.println("8- Sair");
            System.out.println("----------------------");
            System.out.print("(1 a 8)>> ");
            esc = scanner.nextInt();
            supermercado.executarOpcao(esc);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (esc != 8);

    }
}
