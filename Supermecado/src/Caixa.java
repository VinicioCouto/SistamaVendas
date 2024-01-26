public class Caixa {
    private static double valorEmCaixa;


    public Caixa(double valorInicial) {
        this.valorEmCaixa = valorInicial;
    }

    public double getValorEmCaixa() {
        return valorEmCaixa;
    }

    public void setValorEmCaixa(double valorEmCaixa) {
        this.valorEmCaixa = valorEmCaixa;
    }

    public void AtualizarValorEmCaixa(double valor) {
        setValorEmCaixa(valor);
    }

    public void MostrarCaixa() {
        System.out.println("Valor em Caixa: R$" + String.format("%.2f",valorEmCaixa));
    }

    public void registrarVenda(double valor) {
        this.valorEmCaixa += valor;
        System.out.println("Venda registrada. Valor atual do caixa: R$" + String.format("%.2f",valorEmCaixa));
    }
}
