package ContaBanco;

public class ContaInvestimento extends Conta{
	
	public int valorDoInvestimento;
	public int juros;
	public int mes;
	public int retorno;
	

	public ContaInvestimento(String nome, int cpf, double saldo, double limite, int numeroConta, int agencia, int banco,
			String titular, int valorDoInvestimento, int juros, int mes, int retorno) {
		super(nome, cpf, saldo, limite, numeroConta, agencia, banco, titular);
		this.valorDoInvestimento = valorDoInvestimento;
		this.juros = juros;
		this.mes = mes;
		this.retorno = retorno;
	}


		
		public double investimento(double valor, int mes, int juros) {
		int investir = 0;
		if (investir < 0) {
			System.out.println(" O investimento deve ser maior que 0 reais ");
		} else {
			retorno = (int) (valor * mes * juros);
			System.out.println("O seu saldo investido e de " + retorno);
		}
		return investir;

			
		}


	

}
