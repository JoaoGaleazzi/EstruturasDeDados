package Lista;

public class NoListaDupla<T> {

    private NoListaDupla<T> anteior;
    private NoListaDupla<T> proximo;
    private T info;

    public NoListaDupla<T> getAnteior() {
        return anteior;
    }

    public void setAnteior(NoListaDupla<T> anteior) {
        this.anteior = anteior;
    }

    public NoListaDupla<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoListaDupla<T> proximo) {
        this.proximo = proximo;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
