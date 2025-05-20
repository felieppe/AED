import java.util.LinkedList;
import java.util.Collections;

public class TArbolTrieTelefonos implements IArbolTrieTelefonos {

    private TNodoTrieTelefonos raiz;

    public TArbolTrieTelefonos() {
        raiz = new TNodoTrieTelefonos();
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        if (unAbonado != null) {
            raiz.insertar(unAbonado);
        }
    }

    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        LinkedList<TAbonado> abonados = new LinkedList<>();
        raiz.buscarTelefonos(pais + area, abonados);
        Collections.sort(abonados, (a1, a2) -> a1.getNombre().compareTo(a2.getNombre()));
        return abonados;
    }
}
