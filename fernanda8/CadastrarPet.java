import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class CadastrarPet extends JFrame {
    private JTextField nomeDonoField;
    private JTextField nomePetField;
    private JComboBox<String> tipoPetField;
    private JTextField racaPetField;
    private JTextField idadePetField;
    private JComboBox<String> tamanhoPetComboBox;
    private TelaInicial telaInicial;
    private static List<PetInfo> listaPetInfo = new ArrayList<>();
    public CadastrarPet(TelaInicial telaInicial) {
        this.telaInicial = telaInicial;
        setTitle("Cadastrar Pet");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel cadastroPanel = new JPanel(new GridLayout(8, 2, 5, 5));
        cadastroPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel nomeDonoLabel = new JLabel("Nome do Dono:");
        nomeDonoField = new JTextField();
        JLabel nomePetLabel = new JLabel("Nome do Pet:");
        nomePetField = new JTextField();
        JLabel tipoPetLabel = new JLabel("Tipo do Pet:");
        String[] tipos = {"Cachorro", "Gato"};
        tipoPetField = new JComboBox<>(tipos);
        JLabel racaPetLabel = new JLabel("Raça do Pet:");
        racaPetField = new JTextField();
        JLabel idadePetLabel = new JLabel("Idade do Pet:");
        idadePetField = new JTextField();
        JLabel tamanhoPetLabel = new JLabel("Tamanho do Pet:");
        String[] tamanhos = {"PP", "P", "M", "G", "GG"};
        tamanhoPetComboBox = new JComboBox<>(tamanhos);
        JButton cadastrarPetButton = new JButton("Cadastrar Pet");
        cadastrarPetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lidarComBotaoCadastrarPet();
            }
        });
        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarParaTelaInicial();
            }
        });
        cadastroPanel.add(nomeDonoLabel);
        cadastroPanel.add(nomeDonoField);
        cadastroPanel.add(nomePetLabel);
        cadastroPanel.add(nomePetField);
        cadastroPanel.add(tipoPetLabel);
        cadastroPanel.add(tipoPetField);
        cadastroPanel.add(racaPetLabel);
        cadastroPanel.add(racaPetField);
        cadastroPanel.add(idadePetLabel);
        cadastroPanel.add(idadePetField);
        cadastroPanel.add(tamanhoPetLabel);
        cadastroPanel.add(tamanhoPetComboBox);
        cadastroPanel.add(voltarButton);
        cadastroPanel.add(cadastrarPetButton);
        add(cadastroPanel);
        setVisible(true);
    }
    private void lidarComBotaoCadastrarPet() {
        String nomeDono = nomeDonoField.getText();
        String nomePet = nomePetField.getText();
        String tipoPet = (String) tipoPetField.getSelectedItem();
        String racaPet = racaPetField.getText();
        String idadePet = idadePetField.getText();
        String tamanhoPet = (String) tamanhoPetComboBox.getSelectedItem();
        if (nomeDono.isEmpty() || nomePet.isEmpty() || tipoPet.isEmpty() || racaPet.isEmpty() || idadePet.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos obrigatórios.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (nomeDonoJaUsado(nomeDono) && nomePetJaUsado(nomePet)){
            JOptionPane.showMessageDialog(this, "O pet já foi cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;  // Sai do método se houver um erro
        }
        PetInfo petInfo = new PetInfo(nomeDono, nomePet, tipoPet, racaPet, idadePet, tamanhoPet);
        nomeDonoField.setText("");
        nomePetField.setText("");
        racaPetField.setText("");
        idadePetField.setText("");
        String mensagem = "Dono: " + petInfo.getNomeDono() + "\nPet: " + petInfo.getNomePet() + "\nTipo: " + petInfo.getTipoPet() +
                "\nRaça: " + petInfo.getRacaPet() + "\nIdade: " + petInfo.getIdadePet() +
                "\nTamanho: " + petInfo.getTamanhoPet();

        JOptionPane.showMessageDialog(this, mensagem, "Pet Cadastrado", JOptionPane.INFORMATION_MESSAGE);
    }
    private boolean nomeDonoJaUsado(String nomeDono) {
        for (PetInfo petInfo : PetInfo.getListaPetInfo()) {
            if (petInfo.getNomeDono().equals(nomeDono)) {
                return true;
            }
        }
        return false;
    }
    private boolean nomePetJaUsado(String nomePet) {
        for (PetInfo petInfo : PetInfo.getListaPetInfo()) {
            if (petInfo.getNomePet().equals(nomePet)) {
                return true;
            }
        }
        return false;
    }

    private void voltarParaTelaInicial() {
        dispose();
        telaInicial.setVisible(true);
    }
}


