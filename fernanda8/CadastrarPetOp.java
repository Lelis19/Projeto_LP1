class CadastrarPetOp extends OpAdm {
    private TelaInicial telaInicial;

    public CadastrarPetOp(TelaInicial telaInicial) {
        super("Cadastrar Pet");
        this.telaInicial = telaInicial;
    }

    @Override
    public void executar() {
        new CadastrarPet(telaInicial);
        telaInicial.dispose();
    }
}