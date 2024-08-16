package cc.model;

import java.util.List;

public class CCIngestaNativa {
    private List<CCAlimento> ccAlimentos;

    public CCIngestaNativa(List<CCAlimento> ccAlimentos) {
        this.ccAlimentos = ccAlimentos;
    }

    public List<CCAlimento> ccGetAlimentos() {
        return ccAlimentos;
    }

    public void ccAddAlimento(CCAlimento alimento) {
        this.ccAlimentos.add(alimento);
    }
}
