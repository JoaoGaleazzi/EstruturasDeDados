package Arvore;

public abstract class ArvoreBinariaAbstract <T>{
    private NoArvoreBinaria<T> raiz;
	
	/**
	 * Cria uma �rvore vazia
	 */
	public ArvoreBinariaAbstract() {
		 raiz = null;
	}
	
	public NoArvoreBinaria<T> getRaiz() {
		return raiz;
	}
	
	/**
	 * Define a raiz da �rvore
	 * @param raiz Raiz da �rvore bin�ria
	 */
	protected void setRaiz(NoArvoreBinaria<T> raiz) {
		this.raiz = raiz;
	}
	

	/**
	 * Avalia se a �rvore est� vazia
	 * @return True se a �rvore estiver vazia, sen�o false
	 */
	public boolean estaVazia () {
		return (raiz == null);
	}




	/**
	 * Avalia se um determinado dado est� armazenado na �rvore.
	 * Inicia a busca, partindo da raiz da �rvore
	 * @param info valor a ser pesquisado
	 * @return True se o dado foi localizado
	 */
	public boolean pertence(T info) {
		 return buscar(info) != null;
	}

	private boolean pertence(NoArvoreBinaria<T> no, T info){
		if (no == null)
			return false;
		else
			return (no.getInfo().equals(info)) ||
					pertence(no.getEsquerda(), info) ||
					pertence(no.getDireita(), info);
	}

	/**
	 * Devolve a representa��o textual da �rvore
	 */
	public String toString() {
		return arvorePre(raiz);
	}
		
	
	private String arvorePre(NoArvoreBinaria<T> no) {
		if (no == null)
			return "<>";
		else 
			return "<" + 
					no.getInfo() + 
					arvorePre(no.getEsquerda()) +
					arvorePre(no.getDireita()) +
					">";
	}
	

	/**
	 * Calcula a quantidade de n�s existentes na �rvore
	 * @return N�mero de n�s da �rvore
	 */
	public int contarNos() {
		return contarNos(raiz);
	}
	
	
	
	private int contarNos(NoArvoreBinaria<T> no) {
		if (no == null) {
			return 0;
		} else {
			return 1 +  contarNos(no.getEsquerda()) +
						contarNos(no.getDireita());
		}
	}

	public int contarFolhas(NoArvoreBinaria<T> sa){
		if (sa == null) {
			return 0;
		} else {
			boolean ehFolha = sa.getDireita() == null && sa.getEsquerda() == null;
			return (ehFolha? 1:0) + 
				contarFolhas(sa.getEsquerda()) +
				contarFolhas(sa.getDireita());
		}
	}

    public abstract NoArvoreBinaria<T> buscar(T info);
}
