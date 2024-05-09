package Pilha;

import Lista.ListaEncadeada;

public class PilhaLista<T> implements Pilha<T>{

    private ListaEncadeada<T> lista;

    public PilhaLista() {
        super();
        this.lista = new ListaEncadeada<T>();
    }

    @Override
    public void push(T info) {
        this.lista.inserir(info);
    }

    @Override
    public T pop() {
        if(estaVazia())
            return null;
        T poplista = lista.obterNo(0).getInfo();
        lista.retirar(poplista);
        return poplista;
    }

    @Override
    public T peek() {
        if(estaVazia())
            return null;
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        this.lista = new ListaEncadeada<T>();
    }
}
