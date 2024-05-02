package Lista;

public class ListaDupla<T> {
    private NoListaDupla<T> primeiro;

    public ListaDupla() {
        super();
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info){
        NoListaDupla<T> novoNo = new NoListaDupla<T>();
        novoNo.setInfo(info);
        if(primeiro == null){
            primeiro = novoNo;
            return;
        }
        NoListaDupla<T> noAtual = primeiro;
        while(noAtual.getProximo() != null){
            noAtual = noAtual.getProximo();
        }
        novoNo.setAnteior(noAtual);
        noAtual.setProximo(novoNo);
    }

    //deixei incompleta para adiantar o resto
}
