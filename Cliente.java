package ContaBanco;

public class Cliente implements Dao, Dea {

	
	private int codigo;
	private String nome;
	
	public Cliente(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
			
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}


	
	public void inserir() {
	}

	@Override
	public void excluir() {
		
	}

	@Override
	public void localizar() {
		
	}

	@Override
	public void calcular() {
		
	}

	@Override
	public void listar() {
		
	}

	@Override
	public void atualizarLista() {
		
	}

	@Override
	public void excluirLista() {
		
	}
	
}
