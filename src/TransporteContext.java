public class TransporteContext {
    private TransporteStrategy strategy;

    public void setStrategy(TransporteStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Pacote pkg) {
        strategy.deliver(pkg);
    }
}
