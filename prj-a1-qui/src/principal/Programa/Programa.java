package principal.Programa;
import java.util.List;
import java.util.Scanner;

import principal.Modelos.Estoque;
import principal.Modelos.Loja;
import principal.daos.EstoqueDAO;
import principal.daos.LojaDAO;

public class Programa {

	
	
	public static void main(String[] args) {
		Scanner scannerEscolha = new Scanner(System.in);
		Scanner scannerString = new Scanner(System.in);


		Loja loja = new Loja();
        loja.setNome("Loja Prova"); 


		LojaDAO lojaDAO = new LojaDAO();
		lojaDAO.salvarLoja(loja);


		while(true){

			System.out.println("[1] Create Estoque");
			System.out.println("[2] Read Estoque");
			System.out.println("[3] Update Estoque");
			System.out.println("[4] Delete Estoque");

			System.out.println("[0] Sair");

			int escolha = scannerEscolha.nextInt();

			switch (escolha){
				case 1:
					Estoque estoque = new Estoque(loja);
					System.out.println("Digite o nome da localizacao da loja: ");
					String localizacao = scannerString.nextLine();
					estoque.setLocalizacao(localizacao);
					EstoqueDAO estoqueDAO = new EstoqueDAO();
					estoqueDAO.salvarEstoque(estoque);
					System.out.println("Estoque criado");
					break;
				case 2:
				    EstoqueDAO estoqueDAOListar = new EstoqueDAO();
					List<Estoque> estoqueListar = estoqueDAOListar.listar();
					for(Estoque item : estoqueListar){
						System.out.println("ID: " + item.getId());
						System.out.println("Localizacao: " + item.getLocalizacao());
					}
					break;
				case 3:

					System.out.println("Digite o ID do estoque para modificar: ");
					String id = scannerString.nextLine();
					System.out.println("Digite o nome do barrio para atualizar: ");
					String bairro = scannerString.nextLine();

					EstoqueDAO estoqueID = new EstoqueDAO();
					estoqueID.atualizar(id, bairro);
					System.out.println("Atualizado");

					break;
				case 4:
					
					System.out.println("Digite o ID do estoque para deletar:");
					int idDelete = scannerString.nextInt();
					EstoqueDAO estoqueDelete = new EstoqueDAO();
					estoqueDelete.deletar(idDelete);
					System.out.println("Estoque Deletado.");

					break;
				case 0:

					scannerEscolha.close();
					scannerString.close();
					break;
			}
			if(escolha == 0){
				break;
			}
		}


		
		
	}
}
