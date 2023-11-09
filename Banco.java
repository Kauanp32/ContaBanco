package ContaBanco;

import java.util.Scanner;

public class Banco {

    private double cpf;
    private String nome;
    private double idade;
    private double saldo;

    // Construtor da classe Banco
    public Banco(double cpf, String nome, double idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.saldo = 0.0; // Inicializa o saldo com zero
    }

    // Métodos para sacar e depositar
    public void sacar(double valor) {
      
    	if (valor <= saldo) {
            saldo -= valor;
         
            System.out.println("Saque de " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque!");
        }
    }

    public void depositar(double valor) {
       
    	if (valor > 0) {
            saldo += valor;
         
            System.out.println("Depósito de " + valor + " realizado com sucesso.");
        } else {
            System.out.println("O valor a ser depositado deve ser maior que zero.");
        }
    }

    // Método para exibir informações da conta
    public void exibirInformacoes() {
        System.out.println("CPF: " + cpf);
       
        System.out.println("Nome: " + nome);
        
        System.out.println("Idade: " + idade);
      
        System.out.println("Saldo: " + saldo);
   
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o CPF: ");
        double cpf = sc.nextDouble();
        
        System.out.println("Digite o nome: ");
        
        String nome = sc.nextLine();
       
        System.out.println("Digite a idade: ");
        double idade = sc.nextDouble();

        Banco minhaConta = new Banco(cpf, nome, idade);

        minhaConta.exibirInformacoes();

        System.out.println("Digite o valor a ser depositado: ");
        double valorDeposito = sc.nextDouble();
        
        minhaConta.depositar(valorDeposito);

        minhaConta.exibirInformacoes();

        System.out.println("Digite o valor a ser sacado: ");
        double valorSaque = sc.nextDouble();
        
        minhaConta.sacar(valorSaque);

        minhaConta.exibirInformacoes();
    }
}