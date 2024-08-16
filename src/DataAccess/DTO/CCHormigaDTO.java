package DataAccess.DTO;

public class CCHormigaDTO {
    private Integer ccCodigoHormiga;
    private String ccNombreHormiga;
    private Integer ccCodigoSexo;
    private Integer ccCodigoTipoHormiga;
    private Integer ccCodigoEstado;
    private Integer ccCodigoProvincia;
    private Integer ccCodigoAlimento;
    private String ccEstado;
    private String ccFechaCrea;
    private String ccFechaModifica;

    public CCHormigaDTO() {}

    public CCHormigaDTO(Integer codigoHormiga, String nombreHormiga, Integer codigoSexo, Integer codigoTipoHormiga, Integer codigoEstado, Integer codigoProvincia, Integer codigoAlimento, String estado, String fechaCrea, String fechaModifica) {
        this.ccCodigoHormiga = codigoHormiga;
        this.ccNombreHormiga = nombreHormiga;
        this.ccCodigoSexo = codigoSexo;
        this.ccCodigoTipoHormiga = codigoTipoHormiga;
        this.ccCodigoEstado = codigoEstado;
        this.ccCodigoProvincia = codigoProvincia;
        this.ccCodigoAlimento = codigoAlimento;
        this.ccEstado = estado;
        this.ccFechaCrea = fechaCrea;
        this.ccFechaModifica = fechaModifica;
    }

    public Integer ccGetCodigoHormiga() {
        return ccCodigoHormiga;
    }

    public void ccSetCodigoHormiga(Integer codigoHormiga) {
        this.ccCodigoHormiga = codigoHormiga;
    }

    public String ccGetNombreHormiga() {
        return ccNombreHormiga;
    }

    public void ccSetNombreHormiga(String nombreHormiga) {
        this.ccNombreHormiga = nombreHormiga;
    }

    public Integer ccGetCodigoSexo() {
        return ccCodigoSexo;
    }

    public void ccSetCodigoSexo(Integer codigoSexo) {
        this.ccCodigoSexo = codigoSexo;
    }

    public Integer ccGetCodigoTipoHormiga() {
        return ccCodigoTipoHormiga;
    }

    public void ccSetCodigoTipoHormiga(Integer codigoTipoHormiga) {
        this.ccCodigoTipoHormiga = codigoTipoHormiga;
    }

    public Integer ccGetCodigoEstado() {
        return ccCodigoEstado;
    }

    public void ccSetCodigoEstado(Integer codigoEstado) {
        this.ccCodigoEstado = codigoEstado;
    }

    public Integer ccGetCodigoProvincia() {
        return ccCodigoProvincia;
    }

    public void ccSetCodigoProvincia(Integer codigoProvincia) {
        this.ccCodigoProvincia = codigoProvincia;
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
                + "\n CodigoHormiga      " + ccGetCodigoHormiga()
                + "\n NombreHormiga      " + ccGetNombreHormiga()
                + "\n CodigoSexo         " + ccGetCodigoSexo()
                + "\n CodigoTipoHormiga  " + ccGetCodigoTipoHormiga()
                + "\n CodigoEstado       " + ccGetCodigoEstado()
                + "\n CodigoProvincia    " + ccGetCodigoProvincia()
                + "\n CodigoAlimento     " + ccGetCodigoAlimento()
                + "\n Estado             " + ccGetEstado()
                + "\n FechaCrea          " + ccGetFechaCrea()
                + "\n FechaModifica      " + ccGetFechaModifica();
    }
}
