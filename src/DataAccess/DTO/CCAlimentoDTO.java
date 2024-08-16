package DataAccess.DTO;

public class CCAlimentoDTO {
    private Integer ccCodigoAlimento;
    private String ccNombreAlimento;
    private Integer ccCodigoIngestaNativa;
    private Integer ccCodigoGenoAlimento;
    private String ccDescripcionAlimento;
    private String ccEstado;
    private String ccFechaCrea;
    private String ccFechaModifica;

    public CCAlimentoDTO() {}

    public CCAlimentoDTO(String nombreAlimento) {
        this.ccNombreAlimento = nombreAlimento;
    }

    public CCAlimentoDTO(Integer codigoAlimento, String nombreAlimento, Integer codigoIngestaNativa, Integer codigoGenoAlimento, String descripcionAlimento, String estado, String fechaCrea, String fechaModifica) {
        this.ccCodigoAlimento = codigoAlimento;
        this.ccNombreAlimento = nombreAlimento;
        this.ccCodigoIngestaNativa = codigoIngestaNativa;
        this.ccCodigoGenoAlimento = codigoGenoAlimento;
        this.ccDescripcionAlimento = descripcionAlimento;
        this.ccEstado = estado;
        this.ccFechaCrea = fechaCrea;
        this.ccFechaModifica = fechaModifica;
    }

    public Integer ccGetCodigoAlimento() {
        return ccCodigoAlimento;
    }

    public void ccSetCodigoAlimento(Integer codigoAlimento) {
        this.ccCodigoAlimento = codigoAlimento;
    }

    public String ccGetNombreAlimento() {
        return ccNombreAlimento;
    }

    public void ccSetNombreAlimento(String nombreAlimento) {
        this.ccNombreAlimento = nombreAlimento;
    }

    public Integer ccGetCodigoIngestaNativa() {
        return ccCodigoIngestaNativa;
    }

    public void ccSetCodigoIngestaNativa(Integer codigoIngestaNativa) {
        this.ccCodigoIngestaNativa = codigoIngestaNativa;
    }

    public Integer ccGetCodigoGenoAlimento() {
        return ccCodigoGenoAlimento;
    }

    public void ccSetCodigoGenoAlimento(Integer codigoGenoAlimento) {
        this.ccCodigoGenoAlimento = codigoGenoAlimento;
    }

    public String ccGetDescripcionAlimento() {
        return ccDescripcionAlimento;
    }

    public void ccSetDescripcionAlimento(String descripcionAlimento) {
        this.ccDescripcionAlimento = descripcionAlimento;
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
                + "\n CodigoAlimento      " + ccGetCodigoAlimento()
                + "\n NombreAlimento      " + ccGetNombreAlimento()
                + "\n CodigoIngestaNativa " + ccGetCodigoIngestaNativa()
                + "\n CodigoGenoAlimento  " + ccGetCodigoGenoAlimento()
                + "\n DescripcionAlimento " + ccGetDescripcionAlimento()
                + "\n Estado              " + ccGetEstado()
                + "\n FechaCrea           " + ccGetFechaCrea()
                + "\n FechaModifica       " + ccGetFechaModifica();
    }
}
