package cc.model;

public class CCAlimento {
    private String ccTipo;

    public CCAlimento(String ccTipo) {
        this.ccTipo = ccTipo;
    }

    public String ccGetTipo() {
        return ccTipo;
    }

    @Override
    public String toString() {
        return ccTipo;
    }
}
