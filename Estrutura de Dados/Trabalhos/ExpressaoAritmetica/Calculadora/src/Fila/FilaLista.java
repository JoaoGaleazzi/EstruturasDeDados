package Fila;

import Lista.ListaEncadeada;

public class FilaLista<T> implements Fila<T>{

    private ListaEncadeada<T> lista;

    public FilaLista() {
        super();
        lista = new ListaEncadeada<T>();
    }

    @Override
    public void inserir(T valor) {
        lista.inserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() {
        return estaVazia()? null : lista.obterNo(0).getInfo();
    }

    @Override
    public T retirar() {
        T valor =  estaVazia()? null : lista.obterNo(0).getInfo();
        lista.retirar(valor);
        return valor;
    }

    @Override
    public void liberar() {
        lista = new ListaEncadeada<T>();
    }
}
