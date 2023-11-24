import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Servico extends JFrame {
    private JComboBox<String> escolhaPetComboBox;
    private JComboBox<String> tipoServicoComboBox;
    private JComboBox<String> horarioFieldbox;
    private JTextField enderecoField;

    public Servico(List<PetInfo> listaPetInfo) {

        setTitle("Agendar Serviço");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel servicoPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        servicoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel escolhaPetLabel = new JLabel("Escolha do Pet:");
        escolhaPetComboBox = new JComboBox<>();
        preencherEscolhaPetComboBox(PetInfo.getListaPetInfo());

        JLabel tipoServicoLabel = new JLabel("Tipo de Serviço:");
        String[] tiposServico = {"Banho", "Tosa", "Banho e Tosa", "Dog Walker"};
        tipoServicoComboBox = new JComboBox<>(tiposServico);

        JLabel horarioLabel = new JLabel("Horário:");
        String[] horarios = {"08:00 - 09:00", "09:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00"};
        horarioFieldbox = new JComboBox<>(horarios);

        JLabel enderecoLabel = new JLabel("Endereço:");
        enderecoField = new JTextField();

        JButton agendarServicoButton = new JButton("Agendar Serviço");
        agendarServicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lidarComBotaoAgendarServico();
            }
        });

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarParaTelaInicial();
            }
        });

        servicoPanel.add(escolhaPetLabel);
        servicoPanel.add(escolhaPetComboBox);
        servicoPanel.add(tipoServicoLabel);
        servicoPanel.add(tipoServicoComboBox);
        servicoPanel.add(horarioLabel);
        servicoPanel.add(horarioFieldbox);
        servicoPanel.add(enderecoLabel);
        servicoPanel.add(enderecoField);
        servicoPanel.add(voltarButton); // Botão para voltar
        servicoPanel.add(agendarServicoButton);

        add(servicoPanel);

        setVisible(true);
    }

    private void preencherEscolhaPetComboBox(List<PetInfo> listaPetInfo) {
        for (PetInfo petInfo : listaPetInfo) {
            String item = petInfo.getNomeDono() + " - " + petInfo.getNomePet();
            escolhaPetComboBox.addItem(item);
        }
    }

    private void lidarComBotaoAgendarServico() {
        String escolhaPet = (String) escolhaPetComboBox.getSelectedItem();
        String tipoServico = (String) tipoServicoComboBox.getSelectedItem();
        String horario = (String) horarioFieldbox.getSelectedItem();
        String endereco = enderecoField.getText();

        if (escolhaPet == null || escolhaPet.isEmpty() ||endereco == null || endereco.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (horarioJaUsado(horario)) {
            JOptionPane.showMessageDialog(this, "Este horário já está sendo utilizado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        AgendaInfo agendaInfo = new AgendaInfo(escolhaPet, tipoServico, horario, endereco);

        enderecoField.setText("");

        String mensagem = "Pet escolhido: " + escolhaPet +
                "\nTipo de Serviço: " + tipoServico +
                "\nHorário: " + horario +
                "\nEndereço: " + endereco;

        JOptionPane.showMessageDialog(this, mensagem, "Serviço Agendado", JOptionPane.INFORMATION_MESSAGE);
    }
    private boolean horarioJaUsado(String horario) {
        for (AgendaInfo agendaInfo : AgendaInfo.getListaAgendamentos()) {
            if (agendaInfo.getHorario().equals(horario)) {
                return true;
            }
        }
        return false;
    }

    private void voltarParaTelaInicial() {
        dispose();
        new TelaInicial(null);
    }
}
