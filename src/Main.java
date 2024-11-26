import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            // Solicita ao usuário as características do pacote
            System.out.print("Digite o peso do pacote (Kg): ");
            double peso = scanner.nextDouble();

            System.out.print("Digite a dimensão do pacote  em metros cubicos: ");
            double dimensao = scanner.nextDouble();

            System.out.print("Digite o destino do pacote: ");
            String enderecoDestino = scanner.next();

            Pacote pkg = new Pacote(peso, dimensao, enderecoDestino);

            TransporteContext context = new TransporteContext();

            // Solicita ao usuário o tipo de transporte
            System.out.println("Escolha o tipo de transporte: ");
            System.out.println("1. Transporte Terrestre");
            System.out.println("2. Transporte Aéreo");
            System.out.println("3. Transporte Marítimo");
            System.out.println("4. Transporte por Drone");
            int escolha = scanner.nextInt();

            // Seleciona a estratégia de transporte com base na escolha do usuário
            switch (escolha) {
                case 1:
                    context.setStrategy(new TransporteTerrestre());
                    break;
                case 2:
                    // Verifica se o pacote excede os limites de peso ou dimensão para transporte aéreo
                    if (pkg.getPeso() > 50 || pkg.getDimensao() > 100) {
                        System.out.println("Pacote excede os limites de peso ou dimensão para transporte aéreo.");
                        return;
                    }
                    context.setStrategy(new TransporteAereo());
                    break;
                case 3:
                    if (!pkg.getEnderecoDestino().equalsIgnoreCase("International")) {
                        System.out.println("Transporte marítimo é apenas para entregas internacionais.");
                        return;
                    }
                    context.setStrategy(new TransporteMar());
                    break;
                case 4:
                    if (pkg.getPeso() > 2 || pkg.getDimensao() > 5) {
                        System.out.println("Pacote excede os limites de peso ou dimensão para entrega por drone.");
                        return;
                    }
                    context.setStrategy(new TransporteDrone());
                    break;
                default:
                    System.out.println("Opção inválida.");
                    return;
            }

            // Executa a estratégia de transporte selecionada
            context.executeStrategy(pkg);
        }catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira um número válido.");
        } finally {
            scanner.close();
        }
    }
}