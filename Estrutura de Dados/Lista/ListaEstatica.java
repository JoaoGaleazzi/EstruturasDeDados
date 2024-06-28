package Lista;
public class ListaEstatica<T> extends ListaAbstract<T>{
	
	private Object[] info = getInfo();

	public int buscar(T valor) {
		for (int i=0; i<getTamanho(); i++) {
			if (info[i] == valor) {
				return i;
			}
		}
		
		return -1;
	}

	public void inserir(T valor) {
		
		if (getTamanho() == info.length) {
			redimensionar();
		}
		info[getTamanho()] = valor;
		setTamanho(getTamanho() + 1);
	}
}
