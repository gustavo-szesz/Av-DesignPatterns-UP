public class TransporteTerrestre implements TransporteStrategy {
    public void deliver(Pacote pkg) {
        System.out.println("Pacote transportado por terra (caminhão, moto e etc)");
    }
}
