import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        Locadora locadora = new Locadora();

        final String MENU = """
            === MENU LOCADORA ===
            1 - Cadastrar carro
            2 - Cadastrar cliente
            3 - Alugar carro
            4 - Devolver carro
            5 - Listar carros disponíveis
            6 - Sair
            """;

        while (true) {
            String opcaoStr = JOptionPane.showInputDialog(null, MENU, "Sistema Locadora", JOptionPane.QUESTION_MESSAGE);
            if (opcaoStr == null) {
                int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) break;
                else continue;
            }

            int opcao;
            try {
                opcao = Integer.parseInt(opcaoStr.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, digite um número válido.");
                continue;
            }

            switch (opcao) {
                case 1 -> cadastrarCarro(locadora);
                case 2 -> cadastrarCliente(locadora);
                case 3 -> alugarCarro(locadora);
                case 4 -> devolverCarro(locadora);
                case 5 -> listarCarrosDisponiveis(locadora);
                case 6 -> {
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema. Até logo!");
                    return;
                }
                default -> JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarCarro(Locadora locadora) {
        String modelo = JOptionPane.showInputDialog("Informe o modelo do carro:");
        if (modelo == null || modelo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado.");
            return;
        }

        String anoStr = JOptionPane.showInputDialog("Informe o ano do carro:");
        if (anoStr == null || anoStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado.");
            return;
        }

        int ano;
        try {
            ano = Integer.parseInt(anoStr.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ano inválido.");
            return;
        }

        String cor = JOptionPane.showInputDialog("Informe a cor do carro:");
        if (cor == null || cor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado.");
            return;
        }

        Carro carro = new Carro(modelo.trim(), ano, cor.trim(), true);
        locadora.cadastrarCarro(carro);
        JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!");
    }

    private static void cadastrarCliente(Locadora locadora) {
        String nome = JOptionPane.showInputDialog("Informe o nome do cliente:");
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado.");
            return;
        }

        String cpf = JOptionPane.showInputDialog("Informe o CPF do cliente:");
        if (cpf == null || cpf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado.");
            return;
        }

        String idadeStr = JOptionPane.showInputDialog("Informe a idade do cliente:");
        if (idadeStr == null || idadeStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado.");
            return;
        }

        int idade;
        try {
            idade = Integer.parseInt(idadeStr.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Idade inválida.");
            return;
        }

        Cliente cliente = new Cliente(nome.trim(), cpf.trim(), idade);
        locadora.cadastrarCliente(cliente);
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
    }

    private static void alugarCarro(Locadora locadora) {
        String modelo = JOptionPane.showInputDialog("Informe o modelo do carro para alugar:");
        if (modelo == null || modelo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Operação cancelada.");
            return;
        }

        boolean sucesso = locadora.alugarCarro(modelo.trim());
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Carro alugado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao alugar o carro. Verifique se está disponível.");
        }
    }

    private static void devolverCarro(Locadora locadora) {
        String modelo = JOptionPane.showInputDialog("Informe o modelo do carro para devolver:");
        if (modelo == null || modelo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Operação cancelada.");
            return;
        }

        boolean sucesso = locadora.devolverCarro(modelo.trim());
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Carro devolvido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao devolver o carro. Verifique se o carro foi alugado.");
        }
    }

    private static void listarCarrosDisponiveis(Locadora locadora) {
        ArrayList<Carro> carros = locadora.getCarros();
        StringBuilder sb = new StringBuilder("Carros disponíveis:\n");

        boolean temDisponivel = false;
        for (Carro c : carros) {
            if (c.isDisponivel()) {
                sb.append(c).append("\n");
                temDisponivel = true;
            }
        }
        if (!temDisponivel) {
            sb.append("Nenhum carro disponível no momento.");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
