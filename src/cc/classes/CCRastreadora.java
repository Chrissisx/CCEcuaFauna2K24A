package cc.classes;

import cc.interfaces.CCHormiga;
import cc.model.CCAlimento;
import cc.model.CCIngestaNativa;

public class CCRastreadora implements CCHormiga {
    @Override
    public boolean ccComer(CCAlimento alimento) {
        // Implementar la lógica para determinar si el RaCCRastreadora puede comer el alimento.
        return false; // Ejemplo de retorno
    }

    @Override
    public String toString() {
        return "RaCCRastreadora";
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