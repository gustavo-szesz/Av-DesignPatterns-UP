public class Pacote {
    private double peso;
    private double dimensao;
    private String enderecoDestino;

    //Construtor
    public Pacote(double peso, double dimensao, String enderecoDestino) {
        this.peso = peso;
        this.dimensao = dimensao;
        this.enderecoDestino = enderecoDestino;
    }

    // Apenas os Getts
    public double getPeso() {
        return peso;
    }

    public double getDimensao() {
        return dimensao;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }
}
