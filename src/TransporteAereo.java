public class TransporteAereo implements TransporteStrategy {
    public void deliver(Pacote pkg) {
        System.out.println("Pacote transportado por ar (avião, helicóptero e etc)");
    }
}
