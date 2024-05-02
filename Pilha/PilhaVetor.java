package Pilha;

public class PilhaVetor<T> implements Pilha<T> {

    private Object[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        super();
        this.limite = limite;
        this.info = new Object[limite];
        this.tamanho = 0;
    }

    @Override
    public void push(T info) {
        if(tamanho < limite){
            this.info[tamanho] = info;
            this.tamanho++;
        }
    }

    @Override
    public T pop() {
        if(estaVazia())
            return null;
        T popInfo = (T)this.info[tamanho];
        this.info[tamanho] = null;
        tamanho--;
        return popInfo;
    }

    @Override
    public T peek() {
        if(estaVazia())
            return null;
        return (T)this.info[tamanho];
    }

    @Override
    public boolean estaVazia() {
        return tamanho < 1;
    }

    @Override
    public void liberar() {
        this.info = new Object[limite];
    }

}
