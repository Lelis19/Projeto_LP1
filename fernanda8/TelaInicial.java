import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {
    public TelaInicial(Administrador administrador) {

        setTitle("Opções - Administrador");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        JPanel painelOpcoes = new JPanel(new GridLayout(2, 2, 5, 5));
        painelOpcoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        OpAdm cadastrarPetOpcao = new CadastrarPetOp(this);
        OpAdm marcarServicoOpcao = new MarcarServicoOp(this);
        OpAdm verAgendaOpcao = new VerAgendaOp(this);
        OpAdm voltarOpcao = new OpAdm("Sair") {
            @Override
            public void executar() {
                voltarParaEntrada();
            }
        };

        JButton botaoCadastrarPet = criarBotaoOpcao(cadastrarPetOpcao);
        JButton botaoMarcarServico = criarBotaoOpcao(marcarServicoOpcao);
        JButton botaoVerAgenda = criarBotaoOpcao(verAgendaOpcao);
        JButton botaoVoltar = criarBotaoOpcao(voltarOpcao);

        painelOpcoes.add(botaoCadastrarPet);
        painelOpcoes.add(botaoMarcarServico);
        painelOpcoes.add(botaoVerAgenda);
        painelOpcoes.add(botaoVoltar);
        add(painelOpcoes);

        setVisible(true);
    }
    private JButton criarBotaoOpcao(OpAdm opcao) {
        JButton botao = new JButton(opcao.getNome());
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcao.executar();
            }
        });
        return botao;
    }
    private void voltarParaEntrada() {
        dispose();
        new Entrada(new GerenciadorAutenticacao());
    }
}