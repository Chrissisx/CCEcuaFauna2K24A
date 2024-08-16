package cc.classes;

import cc.interfaces.CCHormiga;
import cc.model.CCAlimento;
import cc.model.CCIngestaNativa;

public class CCZangano implements CCHormiga {
    public CCZangano(CCIngestaNativa ccIngestaNativa) {
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean ccComer(CCAlimento alimento) {
        // Implementar la lógica para determinar si el ZangCCZangano puede comer el alimento.
        return false; // Ejemplo de retorno
    }

    @Override
    public String toString() {
        return "ZangCCZangano";
    }

    @Override
    public void setEstado(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEstado'");
    }

    @Override
    public CCIngestaNativa getUbicacion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUbicacion'");
    }
}