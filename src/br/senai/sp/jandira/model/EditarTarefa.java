package br.senai.sp.jandira.model;

import java.util.List;
import java.util.Scanner;

public class EditarTarefa {
	Scanner teclado = new Scanner(System.in);

	public void editarTarefa(List<Tarefa> tarefas, List<RegistrarUsuario> usuarios) {
		if (tarefas.isEmpty()) {
			System.out.println("Não há tarefas cadastradas para editar.");
			return;
		}

		System.out.println("Lista de Tarefas para Edição:");
		for (int i = 0; i < tarefas.size(); i++) {
			System.out.println(i + 1 + ". " + tarefas.get(i).titulo);
		}

		System.out.print("Digite o número da tarefa que deseja editar: ");
		int tarefaAEditar = Integer.parseInt(teclado.nextLine());

		if (tarefaAEditar >= 1 && tarefaAEditar <= tarefas.size()) {
			Tarefa tarefa = tarefas.get(tarefaAEditar - 1);

			System.out.println("Tarefa selecionada para edição: " + tarefa.titulo);

			System.out.print("Novo Título (ou pressione Enter para manter o atual): ");
			String novoTitulo = teclado.nextLine();
			if (!novoTitulo.isEmpty()) {
				tarefa.titulo = novoTitulo;
			}

			System.out.print("Nova Descrição (ou pressione Enter para manter a atual): ");
			String novaDescricao = teclado.nextLine();
			if (!novaDescricao.isEmpty()) {
				tarefa.descricao = novaDescricao;
			}

			System.out.print("Nova Data (ou pressione Enter para manter a atual): ");
			String novaData = teclado.nextLine();
			if (!novaData.isEmpty()) {
				tarefa.data = novaData;
			}

			System.out.println("Atribuir a outra pessoa? (S/N)");
			String atribuirOutraPessoa = teclado.nextLine();
			if (atribuirOutraPessoa.equalsIgnoreCase("S")) {
				System.out.println("Usuários cadastrados:");
				for (int i = 0; i < usuarios.size(); i++) {
					System.out.println(i + 1 + ". " + usuarios.get(i).nome);
				}
				System.out.print("Escolha o número do novo usuário: ");
				int novoUsuario = Integer.parseInt(teclado.nextLine());
				if (novoUsuario >= 1 && novoUsuario <= usuarios.size()) {
					tarefa.usuarioAtribuido = usuarios.get(novoUsuario - 1);
				} else {
					System.out.println("Opção inválida. Tarefa mantida com o usuário atual.");
				}
			}
			System.out.println("Editar Status? (S/N)");
			String editarStatus = teclado.nextLine();
			if (editarStatus.equalsIgnoreCase("S")) {
				System.out.println("Status atual: " + (tarefa.concluida ? "Concluída" : "Não Concluída"));
				System.out.print("Novo Status (Concluída ou Não Concluída): ");
				String novoStatus = teclado.nextLine();
				if (novoStatus.equalsIgnoreCase("Concluída")) {
					tarefa.concluida = true;
				} else if (novoStatus.equalsIgnoreCase("Não Concluída")) {
					tarefa.concluida = false;
				} else {
					System.out.println("Opção de status inválida. O status da tarefa não foi alterado.");
				}
			}
			System.out.println("Tarefa editada com sucesso.");
		} else {
			System.out.println("Opção inválida. Nenhuma tarefa foi editada.");
		}
	}
}
