abstract class OpAdm {
    private String nome;

    public OpAdm(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract void executar();
}