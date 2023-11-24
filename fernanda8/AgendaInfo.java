import java.util.ArrayList;
import java.util.List;

public class AgendaInfo {
    private String escolhaPet;
    private String tipoServico;
    private String horario;
    private String endereco;
    private static List<AgendaInfo> listaAgendamentos = new ArrayList<>();
    public AgendaInfo(String escolhaPet, String tipoServico, String horario, String endereco) {
        this.escolhaPet = escolhaPet;
        this.tipoServico = tipoServico;
        this.horario = horario;
        this.endereco = endereco;
        listaAgendamentos.add(this);
    }
    public String getEscolhaPet() {
        return escolhaPet;
    }
    public String getTipoServico() {

        return tipoServico;
    }
    public String getHorario() {

        return horario;
    }
    public String getEndereco() {
        return endereco;
    }
    public static List<AgendaInfo> getListaAgendamentos() {
        return listaAgendamentos;
    }
}