package Arvore;
public class NoArvoreBinaria <T> {
	
	private T info;
	private NoArvoreBinaria<T> esquerda;
	private NoArvoreBinaria<T> direita;
	
	/**
	 * Cria um n� sem sub-arvores � esquerda e direita
	 * @param info Valor a ser armazenado na �rvore
	 */
	public NoArvoreBinaria(T info) {
		this.info = info;
		esquerda = null;
		direita = null;
	}
	
	
	/**
	 * Cria um novo com sub-�rvores pr�-estabelecidas
	 * @param info Valor armazenado pelo n�
	 * @param esq Sub-arvore � esquerda
	 * @param dir Sub-�rvore � direita
	 */
	public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq,
						           NoArvoreBinaria<T> dir) {
		this.info = info;
		this.esquerda = esq;
		this.direita = dir;
	}
	
	/**
	 * Define o valor a ser armazenado pelo n�
	 * @param info Valor a ser armazenado
	 */
	public void setInfo (T info) {
		this.info = info;
	}
	
	
	/**
	 * Retorna o valor armazenado pelo n�
	 * @return Valor armazenado pelo n�
	 */
	public T getInfo() {
		return info;
	}
	
	
	/**
	 * Retorna a sub-�rvore � esquerda
	 * @return Sub-�rvore da esquerda
	 */
	public NoArvoreBinaria<T> getEsquerda () {
		return esquerda;
	}
	
	
	/**
	 * Retorna a sub-�rvore � direita
	 * @return Sub-�rvore da direita
	 */
	public NoArvoreBinaria<T> getDireita () {
		return direita;
	}


	/**
	 * Define a raiz da sub-arvore � esquerda do n� corrente 
	 * @param esquerda Raiz da sub-�rvore
	 */
	public void setEsquerda(NoArvoreBinaria<T> esquerda) {
		this.esquerda = esquerda;
	}
	

	/**
	 * Define a raiz da sub-arvore � direita do n� corrente 
	 * @param direita Raiz da sub-�rvore
	 */
	public void setDireita(NoArvoreBinaria<T> direita) {
		this.direita = direita;
	}
	
	
}
