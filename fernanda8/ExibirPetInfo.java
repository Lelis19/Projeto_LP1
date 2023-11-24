import javax.swing.*;
import java.util.List;

public class ExibirPetInfo extends JFrame {
    private JList<String> listaNomesDonos;

    public ExibirPetInfo(List<PetInfo> listaPetInfo) {
        setTitle("Informações dos Pets");
        setSize(550, 300);
        setLocationRelativeTo(null);

        DefaultListModel<String> modeloInfo = new DefaultListModel<>();

        for (PetInfo petInfo : listaPetInfo) {
            String item = "Dono: " + petInfo.getNomeDono() +
                    "/ Pet: " + petInfo.getNomePet() +
                    "/ Tipo: " + petInfo.getTipoPet() +
                    "/ Raça: " + petInfo.getRacaPet() +
                    "/ Idade: " + petInfo.getIdadePet() +
                    "/ Tamanho: " + petInfo.getTamanhoPet();
            modeloInfo.addElement(item);
        }

        listaNomesDonos = new JList<>(modeloInfo);

        JScrollPane scrollPaneNomesDonos = new JScrollPane(listaNomesDonos);

        add(scrollPaneNomesDonos);

        setVisible(true);
    }
}

