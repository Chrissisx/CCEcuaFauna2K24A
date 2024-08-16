package DataAccess.DTO;

public class CCHormigaAlimentoDTO {
    private Integer ccCodigoHormigaAlimento;
    private Integer ccCodigoHormiga;
    private Integer ccCodigoAlimento;
    private String ccEstado;
    private String ccFechaCrea;
    private String ccFechaModifica;

    public CCHormigaAlimentoDTO() {}

    public CCHormigaAlimentoDTO(Integer codigoHormigaAlimento, Integer codigoHormiga, Integer codigoAlimento, String estado, String fechaCrea, String fechaModifica) {
        this.ccCodigoHormigaAlimento = codigoHormigaAlimento;
        this.ccCodigoHormiga = codigoHormiga;
        this.ccCodigoAlimento = codigoAlimento;
        this.ccEstado = estado;
        this.ccFechaCrea = fechaCrea;
        this.ccFechaModifica = fechaModifica;
    }

    public Integer ccGetCodigoHormigaAlimento() {
        return ccCodigoHormigaAlimento;
    }

    public void ccSetCodigoHormigaAlimento(Integer codigoHormigaAlimento) {
        this.ccCodigoHormigaAlimento = codigoHormigaAlimento;
    }

    public Integer ccGetCodigoHormiga() {
        return ccCodigoHormiga;
    }

    public void ccSetCodigoHormiga(Integer codigoHormiga) {
        this.ccCodigoHormiga = codigoHormiga;
    }

    public Integer ccGetCodigoAlimento() {
        return ccCodigoAlimento;
    }

    public void ccSetCodigoAlimento(Integer codigoAlimento) {
        this.ccCodigoAlimento = codigoAlimento;
    }

    public String ccGetEstado() {
        return ccEstado;
    }

    public void ccSetEstado(String estado) {
        this.ccEstado = estado;
    }

    public String ccGetFechaCrea() {
        return ccFechaCrea;
    }

    public void ccSetFechaCrea(String fechaCrea) {
        this.ccFechaCrea = fechaCrea;
    }

    public String ccGetFechaModifica() {
        return ccFechaModifica;
    }

    public void ccSetFechaModifica(String fechaModifica) {
        this.ccFechaModifica = fechaModifica;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "\n CodigoHormigaAlimento " + ccGetCodigoHormigaAlimento()
                + "\n CodigoHormiga         " + ccGetCodigoHormiga()
                + "\n CodigoAlimento        " + ccGetCodigoAlimento()
                + "\n Estado               " + ccGetEstado()
                + "\n FechaCrea            " + ccGetFechaCrea()
                + "\n FechaModifica        " + ccGetFechaModifica();
    }
}
