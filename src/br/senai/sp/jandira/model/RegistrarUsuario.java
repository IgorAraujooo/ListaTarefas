package br.senai.sp.jandira.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistrarUsuario {
	public String nome;

	Scanner teclado = new Scanner(System.in);
	public static List<RegistrarUsuario> usuarios = new ArrayList<>();

	public void addUsuario() {
		do {
			System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			System.out.println("------------------Cadastro Usuário--------------------");
			System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");

			RegistrarUsuario usuario = new RegistrarUsuario();

			System.out.print("Insira o nome do cliente: ");
			usuario.nome = teclado.nextLine();
			System.out.println("------------------------------------------------------");

			usuarios.add(usuario);

			System.out.println("Deseja cadastrar mais um cliente? (S/N): ");

		} while (teclado.nextLine().equalsIgnoreCase("S"));
	}
}