package apresentacao;

import java.util.List;
import java.util.Scanner;

import persistencia.SetorDAO;
import pojo.Setor;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// INICIALIZANDO DAO's -->
		SetorDAO setorDAO = new SetorDAO();
		// FIM DA INICIALIZA��O -->

		int menu;

		// INICIO DO MENU -->
		do {
			System.out.println("--- Menu ---\n1. Setores\n2. Sair\n------------");
			menu = sc.nextInt();
			switch (menu) {
			case 1: // SETORES -->
				System.out.println("------------\n1. Listar\n2. Inserir\n3. Editar\n4. Deletar\n------------");
				menu = sc.nextInt();
				if (menu == 1) { //LISTAR SETORES -->
					List<Setor> listaSetor = setorDAO.pesquisar(); //PERCORRE TABELA SETOR
					for (Setor setor : listaSetor) {
						System.out.println("ID: " + setor.getCodSetor() + " | Setor: " + setor.getSetor() + " | Salario: " + setor.getSalario() + "\n");
					}
				} else if (menu == 2) { //INSERIR SETOR -->
					Setor setor = new Setor();
					System.out.println("Informe um nome para o setor:"); setor.setSetor(sc.next());
					System.out.println("Informe o sal�rio do setor:"); setor.setSalario(sc.nextDouble());
					setorDAO.salvar(setor);
					System.out.println("\n> Setor (" + setor.getSetor() + ") cadastrado com sucesso!\n");
				} else if (menu == 3) { //EDITAR SETOR
					Setor setor = new Setor();
					System.out.println("Informe o (ID) do setor que deseja editar:"); setor.setCodSetor(sc.nextLong());
					System.out.println("Informe um novo nome para o setor:"); setor.setSetor(sc.next());
					System.out.println("Informe o novo sal�rio do setor:"); setor.setSalario(sc.nextDouble());
					setorDAO.editar(setor);
					System.out.println("\n> Setor editado com sucesso!\n");
				} else if (menu == 4) { //DELETAR SETOR
					System.out.println("Informe o (ID) do setor que deseja deletar:"); setorDAO.deletar(sc.nextLong());
					System.out.println("\n> Setor deletado com sucesso!\n");
				}
				menu = 0; // ZERA A VARIAVEL PARA O MENU RODAR NOVAMENTE -->
				break;
			// FIM SETORES -->
			case 2:
				System.out.println("Sistema fechado com sucesso!");
				break;
			}
		} while (menu != 2);
		// FIM DO MENU -->

	}

}