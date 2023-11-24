import java.util.ArrayList;
import java.util.List;

public class PetInfo {
    private String nomeDono;
    private String nomePet;
    private String tipoPet;
    private String racaPet;
    private String idadePet;
    private String tamanhoPet;
    private static List<PetInfo> listaPetInfo = new ArrayList<>();

    public PetInfo(String nomeDono, String nomePet, String tipoPet, String racaPet, String idadePet, String tamanhoPet) {
        this.nomeDono = nomeDono;
        this.nomePet = nomePet;
        this.tipoPet = tipoPet;
        this.racaPet = racaPet;
        this.idadePet = idadePet;
        this.tamanhoPet = tamanhoPet;

        listaPetInfo.add(this);
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public String getNomePet() {
        return nomePet;
    }

    public String getTipoPet() {
        return tipoPet;
    }

    public String getRacaPet() {
        return racaPet;
    }

    public String getIdadePet() {
        return idadePet;
    }

    public String getTamanhoPet() {
        return tamanhoPet;
    }

    public static List<PetInfo> getListaPetInfo() {
        return listaPetInfo;
    }
}