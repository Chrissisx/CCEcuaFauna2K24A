package cc.model;

public class CCGenomaAlimento {
    private CCIngestaNativa ccIngestaNativa;

    public CCGenomaAlimento(CCIngestaNativa ccIngestaNativa) {
        this.ccIngestaNativa = ccIngestaNativa;
    }

    public CCIngestaNativa ccGetIngestaNativa() {
        return ccIngestaNativa;
    }
}
