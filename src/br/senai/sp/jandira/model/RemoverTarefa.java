package br.senai.sp.jandira.model;

import java.util.List;
import java.util.Scanner;

public class RemoverTarefa {
    Scanner teclado = new Scanner(System.in);

    public void removerTarefa(List<Tarefa> tarefas) {
        if (tarefas.isEmpty()) {
            System.out.println("A lista de tarefas está vazia. Não há tarefas para remover.");
            return;
        }

        System.out.println("Lista de Tarefas:");
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println(i + 1 + ". " + tarefas.get(i).titulo);
        }

        System.out.print("Digite o número da tarefa que deseja remover: ");
        int tarefaARemover = Integer.parseInt(teclado.nextLine());

        if (tarefaARemover >= 1 && tarefaARemover <= tarefas.size()) {
            Tarefa tarefaRemovida = tarefas.remove(tarefaARemover - 1);
            System.out.println("Tarefa removida: " + tarefaRemovida.titulo);
        } else {
            System.out.println("Opção inválida. Nenhuma tarefa foi removida.");
        }
    }
}
