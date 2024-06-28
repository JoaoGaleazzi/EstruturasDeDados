package Lista;

public abstract class ListaAbstract<T> {
    private Object[] info;
    private int tamanho;

    protected void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    protected Object[] getInfo() {
        return info;
    }

	/**
	 * Cria uma lista vazia
	 */
	public ListaAbstract() {
		info = new Object[10];
		tamanho = 0;
	}
	
	
	/**
	 * Adiciona um valor na lista
	 * @param valor Dado a ser adicionado
	 */
	abstract void inserir(T valor);

	/**
	 * Provoca um pseudo redimensionamento do vetor info
	 */
	protected void redimensionar() {
		Object[] novo = new Object[info.length + 10];

		for (int i=0; i<info.length; i++) {
			novo[i] = info[i];
		}
		
		info = novo;
	}	
	
	
	/**
	 * Exibe o conteúdo da lista
	 */
	public void exibir() {
		for (int i=0; i<tamanho; i++) {
			System.out.println(info[i]);
		}
	}
	
	
	/**
	 * Procura na lista um determinado valor
	 * @param valor Dado a ser pesquisado
	 * @return posição do valor na lista. Caso não seja encontrado
	 * retorna -1.
	 */
	abstract int buscar(T valor);
	
	/**
	 * Retira um dado da lista
	 * @param valor Dado a ser removido
	 */
	public void retirar(T valor) {
		int posicao = buscar(valor);
		
		if (posicao > -1) {
			for (int i=posicao+1; i<tamanho; i++) {
				info[i-1] = info[i];
			}
			
			tamanho--;
		}
	}
	
	
	/**
	 * limpa a estrutura de dados, de forma que a 
	 * lista esteja vazia
	 */
	public void liberar() {
		info = new Object[10];
		tamanho = 0;
	}
	
	
	/**
	 * Retorna o dado armazenado numa determinada posição
	 * da lista.
	 * @param posicao Posição do dado
	 * @return Dado localizado
	 */
	@SuppressWarnings("unchecked")
	public T obterElemento(int posicao) {
		if (posicao >= 0 && (posicao < tamanho)) {
			return (T)info[posicao];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	
	/**
	 * Avalia se a lista está vazia ou contem dados armazenados.
	 * @return true se a lista estiver vazia, senão false.
	 */
	public boolean estaVazia() {
		return tamanho==0;
	}
	
	
	/**
	 * Retorna o tamanho atual da lista, isto é,
	 * a quantidade de dados já armazenados na estrutura de dados
	 * @return Quantidade de dados armazenados
	 */
	public int getTamanho() {
		return tamanho;
	}
	
	
	/**
	 * Retorna string contendo os dados armazenados na lista
	 */
	@Override
	public String toString() {
		String resultado = "";
		
		for (int i=0; i<tamanho; i++) {
			if (i > 0) {
				resultado += ",";
			}
			resultado += info[i]; 
		}
		
		return resultado;
	}

	public void Inverter(){
		for (int i = 0; i < Math.floor(tamanho/2); i++) {
			Object val1 = info[i];
			info[i] = info[tamanho-i-1];
			info[tamanho-i-1] = val1;
		}
	}

}
