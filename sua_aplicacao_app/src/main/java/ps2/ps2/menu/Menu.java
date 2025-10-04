package ps2.ps2.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ps2.ps2.dao.AlunoRepository;
import ps2.ps2.models.Aluno;

import java.util.List;
import java.util.Scanner;

@Component
public class Menu implements CommandLineRunner {

    @Autowired
    private AlunoRepository repo;

    @Override
    public void run(String... args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMENU - GERENCIAR ALUNOS");
            System.out.println("1 - Listar todos");
            System.out.println("2 - Buscar por ID");
            System.out.println("3 - Criar novo");
            System.out.println("4 - Alterar");
            System.out.println("5 - Deletar por ID");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    List<Aluno> alunos = repo.findAll();
                    alunos.forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Digite o ID: ");
                    Long idBusca = sc.nextLong();
                    repo.findById(idBusca).ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Aluno não encontrado.")
                    );
                    break;

                case 3:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Curso: ");
                    String curso = sc.nextLine();
                    repo.save(new Aluno(nome, curso));
                    System.out.println("Aluno cadastrado!");
                    break;

                case 4:
                    System.out.print("Digite o ID para alterar: ");
                    Long idAlt = sc.nextLong();
                    sc.nextLine();
                    repo.findById(idAlt).ifPresentOrElse(aluno -> {
                        System.out.print("Novo nome: ");
                        aluno.setNome(sc.nextLine());
                        System.out.print("Novo curso: ");
                        aluno.setCurso(sc.nextLine());
                        repo.save(aluno);
                        System.out.println("Alterado!");
                    }, () -> System.out.println("Aluno não encontrado."));
                    break;

                case 5:
                    System.out.print("Digite o ID para excluir: ");
                    Long idExc = sc.nextLong();
                    repo.deleteById(idExc);
                    System.out.println("Excluído!");
                    break;
                    
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        sc.close();
    }
}     