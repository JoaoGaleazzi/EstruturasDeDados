package MapaDispersao;

import Lista.ListaEncadeada;
import Lista.NoLista;

public class MapaDispersao<T> {
    private ListaEncadeada<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho) {
        super();
        info = new ListaEncadeada[tamanho];
    }

    private int calcularHash(int chave){
        return chave % info.length;
    }

    public void inserir(int chave, T dado){
        int index = calcularHash(chave);
        NoMapa<T> noMapa = new NoMapa<T>();
        noMapa.setChave(chave);
        noMapa.setInfo(dado);
        if(info[index] == null)
            info[index] = new ListaEncadeada<NoMapa<T>>();
        info[index].inserir(noMapa);
    }

    public void remover(int chave){
        int index = calcularHash(chave);
        NoMapa<T> noMapa = new NoMapa<T>();
        noMapa.setChave(chave);
        if(info[index] != null)
            info[index].retirar(noMapa);
    }

    public T buscar(int chave){
        int index = calcularHash(chave);
        NoMapa<T> noMapa = new NoMapa<T>();
        noMapa.setChave(chave);
        if(info[index] != null){
            NoLista<NoMapa<T>> noLista = info[index].buscar(noMapa);
            if(noLista != null)
                return noLista.getInfo().getInfo();
        }
        return null;
    }

    public void realocarMapa(int novoTamanho){
        ListaEncadeada<NoMapa<T>>[] velhaInfo = info;
        info = new ListaEncadeada[novoTamanho];

        for (ListaEncadeada<NoMapa<T>> listaEncadeada : velhaInfo) {
            if(listaEncadeada == null || listaEncadeada.estaVazia()){
                continue;
            }
            NoLista<NoMapa<T>> noAtual = listaEncadeada.getPrimeiro();
            while(noAtual != null){
                inserir(noAtual.getInfo().getChave(), noAtual.getInfo().getInfo());
                noAtual = noAtual.getProximo();
            }
        }
    }
}
