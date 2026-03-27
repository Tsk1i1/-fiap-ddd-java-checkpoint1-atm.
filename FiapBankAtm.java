import java.util.Scanner;

public class FiapBankAtm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // CADASTRO DE NOME
        System.out.print("Seja bem-vindo ao [Fiap Bank] v0.1 alpha \nDigite seu nome completo: ");
        String nomeCompleto = sc.nextLine().trim();

        String primeiroNome = nomeCompleto.split(" ")[0];
        System.out.println("Olá, " + primeiroNome + "! Vamos configurar sua conta.");

        // CADASTRO DE SENHA FORTE
        String senhaCadastrada;
        String regexSenha = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*()\\-_+=?><]).{8,}$";

        // Repete até a senha ela ser válida
        while (true) {
            System.out.println("\nCadastre uma senha (mín. 8 caracteres, maiúscula, número e símbolo): ");
            senhaCadastrada = sc.nextLine();

            if (senhaCadastrada.matches(regexSenha)) {
                System.out.println("Senha cadastrada com sucesso!");
                break; // Sai do loop se a senha for forte
            } else {
                System.out.println("Senha muito fraca! Tente novamente seguindo os critérios (mín. 8 caracteres, maiúscula, número e símbolo).");
            }
        }

        // LOGIN
        int tentativas = 0;
        boolean loginSucesso = false;

        System.out.println("\nIniciando autenticação...");

        while (tentativas < 3) {
            System.out.print("Confirme sua senha para entrar: ");
            String senhaLogin = sc.nextLine();

            // Comparação das Strings
            if (senhaLogin.equals(senhaCadastrada)) {
                loginSucesso = true;
                System.out.println("\nLogin realizado com sucesso! Bem-vindo ao menu principal.");
                break; // Sai do loop de tentativas
            } else {
                tentativas++;
                int restantes = 3 - tentativas;

                if (restantes > 0) {
                    System.out.println("Senha incorreta! Você tem mais " + restantes + " tentativa(s).");
                }
            }
        }
        // LÓGICA DE BLOQUEIO
        if (!loginSucesso) {
            System.out.println("\n********************");
            System.out.println("ACESSO BLOQUEADO");
            System.out.println("********************");
            sc.close();
            return; // Encerra em caso de bloqueio
        }
        //  MENU PRINCIPAL

        double saldo = 0.0; // Saldo inicial zerado
        int opcao = 0;

        // Loop do Menu
        while (opcao != 4) {
            System.out.println("\n----------------------------");
            System.out.println("       MENU FIAP BANK       ");
            System.out.println("----------------------------");
            System.out.println("[ 1 ] Consultar Saldo");
            System.out.println("[ 2 ] Fazer Depósito");
            System.out.println("[ 3 ] Fazer Saque");
            System.out.println("[ 4 ] Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.printf("\nSaldo Atual: R$ %.2f%n", saldo);
                    break;

                case 2:
                    System.out.print("Digite o valor do depósito: R$ ");
                    double valorDeposito = sc.nextDouble();
                    sc.nextLine();

                    // Regra: Não permitir valores negativos ou zero
                    if (valorDeposito > 0) {
                        saldo += valorDeposito;
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Erro: O valor deve ser maior que zero.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o valor do saque: R$ ");
                    double valorSaque = sc.nextDouble();
                    sc.nextLine();

                    // Regras de saque: Não permitir negativos, nulos ou saldo insuficiente
                    if (valorSaque <= 0) {
                        System.out.println("Erro: Valor de saque inválido.");
                    } else if (valorSaque > saldo) {
                        System.out.println("Erro: Saldo insuficiente.");
                    } else {
                        saldo -= valorSaque;
                        System.out.println("Saque realizado com sucesso!");
                    }
                    break;

                case 4:
                    System.out.println("\nO FIAP Bank agradece sua preferência!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        }
        sc.close(); // Finaliza o Scanner.
    }
}