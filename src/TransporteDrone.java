public class TransporteDrone implements TransporteStrategy {
    public void deliver(Pacote pkg) {
        System.out.println("Pacote transportado por drone");
    }
}
