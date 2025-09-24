import java.util.ArrayList;

public class Locadora {
    private ArrayList<Cliente> clientes;
    private ArrayList<Carro> carros;

    public Locadora() {
        this.clientes = new ArrayList<>();
        this.carros = new ArrayList<>();
    }

    public void cadastrarCarro(Carro c) {
        carros.add(c);
        System.out.println("Carro cadastrado: " + c.getModelo());
    }

    public void cadastrarCliente(Cliente c) {
        clientes.add(c);
        System.out.println("Cliente cadastrado: " + c.getNome());
    }

    public boolean alugarCarro(String modelo) {
        for (Carro c : carros) {
            if (c.getModelo().equalsIgnoreCase(modelo) && c.isDisponivel()) {
                c.setDisponivel(false);
                System.out.println("Carro alugado: " + modelo);
                return true;
            }
        }
        System.out.println("Carro não está disponível para aluguel: " + modelo);
        return false;
    }

    public boolean devolverCarro(String modelo) {
        for (Carro c : carros) {
            if (c.getModelo().equalsIgnoreCase(modelo) && !c.isDisponivel()) {
                c.setDisponivel(true);
                System.out.println("Carro devolvido: " + modelo);
                return true;
            }
        }
        System.out.println("Carro não encontrado ou já disponível: " + modelo);
        return false;
    }

    public void listarCarrosDisponiveis() {
        System.out.println("Carros disponíveis para aluguel:");
        for (Carro c : carros) {
            if (c.isDisponivel()) {
                System.out.println(c);
            }
        }
    }
    public ArrayList<Carro> getCarros() {
        return this.carros;
    }

    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }
}
