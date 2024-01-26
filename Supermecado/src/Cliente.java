import java.util.ArrayList;

public class Cliente {
    private ArrayList<Integer> idCliente = new ArrayList<>();
    private ArrayList<String> nome = new ArrayList<>();
    private ArrayList<String> endereco = new ArrayList<>();
    private int contid = 0;

    public Cliente(int idCliente, String nome, String endereco) {
        this.idCliente.add(idCliente);
        this.nome.add(nome);
        this.endereco.add(endereco);
        contid++;

    }


    public Cliente() {
        this.idCliente = new ArrayList<>();
        this.nome = new ArrayList<>();
        this.endereco = new ArrayList<>();
        contid++;

        CadastrarCliente("Visitante", "Sem_Dados");
        CadastrarCliente("Vinicio", "Guanambi");
        CadastrarCliente("Fabilla", "Guanambi");
        CadastrarCliente("Heitor", "Cacule");
        CadastrarCliente("Gilson", "Pindai");
    }

    public int getIdCliente(int index) {
        return idCliente.get(index);
    }

    public void setIdCliente(int index, int idCliente) {
        this.idCliente.set(index, idCliente);
    }

    public String getNome(int id) {
        if (id >= 0 && id < nome.size()) {
            return nome.get(id);
        } else {
            System.out.println("Índice do Cliente inválido.");
            return "";
        }
    }

    public void setNome(int index, String nome) {
        this.nome.set(index, nome);
    }

    public String getEndereco(int index) {
        return endereco.get(index);
    }

    public void setEndereco(int index, String endereco) {
        this.endereco.set(index, endereco);
    }

    public void CadastrarCliente(String nome, String endereco) {
        this.idCliente.add(contid);
        this.nome.add(nome);
        this.endereco.add(endereco);
        contid++;
        System.out.println("Cliente Cadastrado com Sucesso");
    }

    public boolean RemoverCliente(int index) {
        if (index >= 0 && index < idCliente.size()) {
            this.idCliente.remove(index);
            this.nome.remove(index);
            this.endereco.remove(index);
            return true;
        }
        return false;
    }

    public boolean EditarCliente(int index, int novoIdCliente, String novoNome, String novoEndereco) {
        if (index >= 0 && index < idCliente.size()) {
            this.idCliente.set(index, novoIdCliente);
            this.nome.set(index, novoNome);
            this.endereco.set(index, novoEndereco);
            return true;
        }
        return false;
    }

    public void ConsultarCliente() {
        for (int i = 0; i < idCliente.size(); i++) {
            System.out.println("ID: " + getIdCliente(i));
            System.out.println("Nome: " + getNome(i));
            System.out.println("Endereço: " + getEndereco(i));
        }
    }
}
