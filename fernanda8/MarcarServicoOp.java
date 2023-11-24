class MarcarServicoOp extends OpAdm {
    private TelaInicial telaInicial;

    public MarcarServicoOp(TelaInicial telaInicial) {
        super("Marcar Serviço");
        this.telaInicial = telaInicial;
    }

    @Override
    public void executar() {
        new Servico(PetInfo.getListaPetInfo());
        telaInicial.dispose();
    }
}