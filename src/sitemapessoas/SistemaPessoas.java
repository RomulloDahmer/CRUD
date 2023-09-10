package sitemapessoas;

import java.util.Scanner;

public class SistemaPessoas {

    public static void main(String[] args) {
        GerenciadorPessoas gerenciador = new GerenciadorPessoas();
        FilaPrioridade fila = new FilaPrioridade();
        Scanner scanner = new Scanner(System.in);

        boolean executar = true;

        while (executar) {
            System.out.println("=======================================");
            System.out.println("Selecione uma opcao:");
            System.out.println("1. Adicionar Pessoa");
            System.out.println("2. Atender Proxima Pessoa");
            System.out.println("3. Listar Pessoas no Sistema");
            System.out.println("4. Sair\n");
            System.out.println("---------------------------------------");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome da pessoa:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a idade da pessoa:");
                    int idade = scanner.nextInt();
                    Pessoa pessoa = new Pessoa();
                    pessoa.setNome(nome);
                    pessoa.setIdade(idade);
                    gerenciador.adicionarPessoa(pessoa);
                    fila.adicionarPessoa(pessoa);
                    System.out.println("Pessoa adicionada com sucesso! ");
                    break;
                case 2:
                    if (!fila.filaVazia()) {
                        Pessoa proximaPessoa = fila.atenderProximaPessoa();
                        System.out.println("Proxima pessoa a ser atendida: " + proximaPessoa.getNome());
                    } else {
                        System.out.println("A fila esta vazia.");
                    }
                    break;
                case 3:
                    System.out.println("Pessoas no sistema:");
                    for (Pessoa p : gerenciador.listarPessoas()) {
                        System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome() + ", Idade: " + p.getIdade());
                    }
                    break;
                case 4:
                    executar = false;
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
                    break;
            }
        }

        System.out.println("Saindo");
        scanner.close();
    }
}
