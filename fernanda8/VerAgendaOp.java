class VerAgendaOp extends OpAdm {
    private TelaInicial telaInicial;

    public VerAgendaOp(TelaInicial telaInicial) {
        super("Ver Agenda");
        this.telaInicial = telaInicial;
    }

    @Override
    public void executar() {
        new Agenda(AgendaInfo.getListaAgendamentos());
        telaInicial.dispose();
    }
}