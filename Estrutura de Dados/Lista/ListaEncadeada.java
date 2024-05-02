package Lista;

public class ListaEncadeada<T> {
    private NoLista<T> primeiro;

    public ListaEncadeada() {
        super();
    }

    public NoLista<T> getPrimeiro(){
        return primeiro;
    }

    public void inserir(T info){
        NoLista<T> novoNo = new NoLista<T>();
        novoNo.setInfo(info);
        if(estaVazia())
            novoNo.setProximo(primeiro);
        primeiro = novoNo;
    }

    public boolean estaVazia(){
        return primeiro == null;
    }

    public NoLista<T> buscar(T info){
        NoLista<T> noAtual = primeiro;
        while(noAtual != null){
            if(noAtual.getInfo().equals(info))
                break;
            noAtual = noAtual.getProximo();
        }
        return noAtual;
    }

    public void retirar(T info){
        if(!estaVazia() && primeiro.getInfo().equals(info)){
            primeiro = primeiro.getProximo();
            return;
        }
        NoLista<T> noAtual = primeiro;
        while(noAtual.getProximo() != null){
            if(noAtual.getProximo().getInfo().equals(info)){
                noAtual.setProximo(noAtual.getProximo().getProximo());
                return;
            }
            noAtual = noAtual.getProximo();
        }
    }

    public int obterComprimento(){
        int count = 0;
        NoLista<T> noAtual = primeiro;
        while(noAtual != null){
            count++;
            noAtual = noAtual.getProximo();
        }
        return count;
    }

    public NoLista<T> obterNo(int idx){
        if(idx < 0 || estaVazia())
            throw new IndexOutOfBoundsException();
        
        NoLista<T> noAtual = primeiro;
        for (int i = 0; i < idx; i++) {
            if(noAtual == null)
                throw new IndexOutOfBoundsException();
            noAtual = noAtual.getProximo();
        }

        return noAtual;
    }

    @Override
	public String toString() {
        if(estaVazia())
            return "";
        
		String resultado = "";
        NoLista<T> noAtual = primeiro;

		resultado += noAtual.getInfo().toString();
        while(noAtual != null){
            if(!noAtual.equals(primeiro))
                resultado += ", " + noAtual.getInfo();
            noAtual = noAtual.getProximo();
        }

		
		return resultado;
	}
}
