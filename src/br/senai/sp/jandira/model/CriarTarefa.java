
package br.senai.sp.jandira.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CriarTarefa {
    Scanner teclado = new Scanner(System.in);

    public List<Tarefa> tarefas = new ArrayList<>();
    public List<RegistrarUsuario> usuarios = new ArrayList<>();

    public CriarTarefa(List<RegistrarUsuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void addTarefa() {
        do {
            Tarefa tarefa = new Tarefa();

            System.out.println("Insira a tarefa: ");
            tarefa.titulo = teclado.nextLine();

            System.out.println("Digite a descrição da tarefa: ");
            tarefa.descricao = teclado.nextLine();
            
            tarefa.concluida = false;

            System.out.println("Insira a data em que a tarefa irá expirar: ");
            tarefa.data = teclado.nextLine();

            System.out.println("Essa tarefa será atribuída a qual usuário?");
            System.out.println("Usuários cadastrados:");

            for (int i = 0; i < usuarios.size(); i++) {
                System.out.println(i + 1 + ". " + usuarios.get(i).nome);
            }

            System.out.print("Escolha o número do usuário a quem atribuir a tarefa: ");
            int usuarioChoice = Integer.parseInt(teclado.nextLine());

            if (usuarioChoice >= 1 && usuarioChoice <= usuarios.size()) {
                tarefa.usuarioAtribuido = usuarios.get(usuarioChoice - 1);
                System.out.println("Tarefa atribuída ao usuário: " + usuarios.get(usuarioChoice - 1).nome);
                tarefas.add(tarefa);
            } else {
                System.out.println("Opção inválida. Tarefa não atribuída a nenhum usuário.");
            }

            System.out.println("Deseja criar mais uma tarefa? (S/N)");

        } while (teclado.nextLine().equalsIgnoreCase("s"));
    }
}
