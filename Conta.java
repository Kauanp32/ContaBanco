package ContaBanco;

import java.util.Scanner;

public class Conta {
 
	 Scanner sc = new Scanner(System.in);
	
	public String titular;
	public int cpf;
	public double saldo;
	public double limite;
	public int numeroConta;
	public int agencia;
	public int banco;

	// Metodo construtor da classe 
	public Conta(String nome, int cpf, double saldo, double limite, int numeroConta, int agencia, int banco, String titular) {

		this.titular = titular;
		this.cpf = cpf;
		this.saldo = saldo;
		this.limite = limite;
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.banco = banco;

	}
	
	
    // Metodo consultarSaldo 
	public void consultaSaldo() {
		System.out.println("Titular:" + titular);
		System.out.println("CPF:" + cpf);
		System.out.println("Agência :" + agencia);
		System.out.println("Banco : " + banco);
		System.out.println("Saldo:" + saldo);
	}
	
	
     // Metodo Sacar
	public double sacar(double saque) {
		
		if (saque < 0) {
			System.out.println("O valor do saque deve ser maior que zero.");
		} else if (saque > (saldo + limite)) {
			System.out.println("Saldo indisponível! Saldo: " + saldo);
		} 
			return saldo -= saque;
		}
	
	
	// Metodo depositar dinheiro
	public double depositar(double depositar) {
	
		return saldo+= depositar;
	}



	
	}
	
	
