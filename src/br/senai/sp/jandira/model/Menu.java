package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Menu {
	Scanner teclado = new Scanner(System.in);
	
	CriarTarefa tarefa = new CriarTarefa(RegistrarUsuario.usuarios);
	RegistrarUsuario usuario = new RegistrarUsuario();
	MostrarTarefa mostrarTarefa = new MostrarTarefa();
	RemoverTarefa remover = new RemoverTarefa();
	EditarTarefa editar = new EditarTarefa();

	boolean continuar = true;
	
	public void iniciarMenu() {
		while(continuar) {
			System.out.println("------------------------------------------------------------");
			System.out.println("-------------------Olá, seja bem vindo----------------------");
			System.out.println("----------------ao Gerenciador de Tarefas-------------------");
			System.out.println("------------------------------------------------------------");
			System.out.println("- 1 - Cadastrar Usuário");
			System.out.println("- 2 - Criar Tarefa");
			System.out.println("- 3 - Mostrar Tarefas");
			System.out.println("- 4 - Excluir Tarefas");
			System.out.println("- 5 - Editar Tarefas");
			System.out.println("------------------------------------------------------------");
			
			int userOption = teclado.nextInt();
			
			switch (userOption) {
			case 1: 
				usuario.addUsuario();
				break;
			case 2:
				tarefa.addTarefa();
				break;
			case 3:
				mostrarTarefa.mostrarTarefa(tarefa.tarefas);
				break;
			case 4:
				remover.removerTarefa(tarefa.tarefas);
				break;
			case 5:
				editar.editarTarefa(tarefa.tarefas, RegistrarUsuario.usuarios);
				break;
			default:
				System.out.println("Opção Invalida");
				break;
			}
			
		}
	}
	
}
