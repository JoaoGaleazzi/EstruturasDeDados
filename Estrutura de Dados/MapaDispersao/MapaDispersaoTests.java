package MapaDispersao;

public class MapaDispersaoTests {
    public static void main(String[] args) {
        MapaDispersao<Integer> mapa = new MapaDispersao<Integer>(10);



        mapa.inserir(1, 1);
        mapa.inserir(13,13);
        mapa.realocarMapa(15);
    }
}
