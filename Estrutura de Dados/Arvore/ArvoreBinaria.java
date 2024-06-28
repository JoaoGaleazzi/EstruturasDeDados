package Arvore;
public class ArvoreBinaria <T> extends ArvoreBinariaAbstract<T>{

	@Override
	public NoArvoreBinaria<T> buscar(T info) {
		return buscar(getRaiz(), info);
	}

	private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
		if(no == null)
			return null;
		else{
			if(no.getInfo().equals(info))
				return no;
		}
		//termina
		return null;
	}

	public void setRaiz(NoArvoreBinaria<T> raiz) {
		super.setRaiz(raiz);
	}
}


