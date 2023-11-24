import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class    Agenda extends JFrame {
    private JList<String> listaAgenda;

    public Agenda(List<AgendaInfo> listaAgendaInfo) {
        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarParaTelaInicial();
            }
        });
        JButton verAnimaisButton = new JButton("Informação dos Animais");
        verAnimaisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verAnimaisCadastrados(PetInfo.getListaPetInfo());
            }
        });
        setTitle("Agenda");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        for (AgendaInfo agendaInfo : listaAgendaInfo) {
            String item = "Dono - Pet: " + agendaInfo.getEscolhaPet() +
                    "  /  Serviço: " + agendaInfo.getTipoServico() +
                    "  /  Horário: " + agendaInfo.getHorario() +
                    "  /  Endereço: " + agendaInfo.getEndereco();
            modeloLista.addElement(item);
        }
        listaAgenda = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaAgenda);
        add(scrollPane);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(voltarButton);
        buttonPanel.add(verAnimaisButton);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
    private void voltarParaTelaInicial() {
        dispose();

        new TelaInicial(null);
    }
    private void verAnimaisCadastrados(List<PetInfo> listaPetInfo) {
        new ExibirPetInfo(listaPetInfo);
    }
}