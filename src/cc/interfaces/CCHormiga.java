package cc.interfaces;

import cc.model.CCAlimento;
import cc.model.CCIngestaNativa;

public interface CCHormiga {
    boolean ccComer(CCAlimento alimento);

    void setEstado(String string);

    CCIngestaNativa getUbicacion();
}
