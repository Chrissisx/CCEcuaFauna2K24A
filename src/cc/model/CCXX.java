package cc.model;

import cc.interfaces.CCHormiga;

public class CCXX extends CCGenomaAlimento implements CCHormiga{
    public CCXX(CCIngestaNativa ccIngestaNativa) {
        super(ccIngestaNativa);
    }

    @Override
    public boolean ccComer(CCAlimento alimento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ccComer'");
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

    // Métodos específicos para CCXX (hembra)
}
