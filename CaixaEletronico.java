package ContaBanco;

import java.util.Scanner;

public class CaixaEletronico {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		
		ContaInvestimento conta1 = new ContaInvestimento(null, 1000, 5, 12, opcao, opcao, opcao, null, opcao, opcao, opcao, opcao);
		
		System.out.println("######### Bem vindo ao Banco do Povo ############");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("###################################");

		try {
			

				int opcao1 = 0;

				System.out.println("Escolha uma opção:");
				System.out.println("Opção 1: Consultar Saldo.");
				System.out.println("Opção 2: Depositar.");
				System.out.println("Opção 3: Sacar.");
				System.out.println("Opção 4: Investir ");
				//System.out.println("Opção 5: Sair ");
				opcao1= sc.nextInt();
				

				switch (opcao1) {

				case 1:

					conta1.consultaSaldo();

				case 2:
					System.out.println("Digite o valor do depósito:");
					double deposito;
					deposito = sc.nextDouble();
					//conta1.depositar();
			
				case 3:
					double saque;
					System.out.println("Digite o valor de saque");
					saque = sc.nextDouble();
					conta1.sacar(saque);

				case 4:
					break;
					
				//case 5:
				//	break;

				}
			
		} catch (Exception e) {
			System.out.print("Erro");

		}
          sc.close();
	}

}