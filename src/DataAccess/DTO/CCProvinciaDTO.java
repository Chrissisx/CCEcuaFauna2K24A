package DataAccess.DTO;

public class CCProvinciaDTO {
    private Integer CodigoProvincia;
    private String NombreProvincia;
    private Integer CodigoPais;
    private Integer CodigoRegion;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;

    public CCProvinciaDTO() {}

    public CCProvinciaDTO(String nombreProvincia, Integer codigoPais, Integer codigoRegion) {
        this.NombreProvincia = nombreProvincia;
        this.CodigoPais = codigoPais;
        this.CodigoRegion = codigoRegion;
    }

    public CCProvinciaDTO(Integer codigoProvincia, String nombreProvincia, Integer codigoPais, Integer codigoRegion, String estado, String fechaCrea, String fechaModifica) {
        this.CodigoProvincia = codigoProvincia;
        this.NombreProvincia = nombreProvincia;
        this.CodigoPais = codigoPais;
        this.CodigoRegion = codigoRegion;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }

    public Integer getCodigoProvincia() {
        return CodigoProvincia;
    }

    public void setCodigoProvincia(Integer codigoProvincia) {
        CodigoProvincia = codigoProvincia;
    }

    public String getNombreProvincia() {
        return NombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        NombreProvincia = nombreProvincia;
    }

    public Integer getCodigoPais() {
        return CodigoPais;
    }

    public void setCodigoPais(Integer codigoPais) {
        CodigoPais = codigoPais;
    }

    public Integer getCodigoRegion() {
        return CodigoRegion;
    }

    public void setCodigoRegion(Integer codigoRegion) {
        CodigoRegion = codigoRegion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getFechaCrea() {
        return FechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }

    public String getFechaModifica() {
        return FechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "\n CodigoProvincia   " + getCodigoProvincia()
                + "\n NombreProvincia   " + getNombreProvincia()
                + "\n CodigoPais        " + getCodigoPais()
                + "\n CodigoRegion      " + getCodigoRegion()
                + "\n Estado            " + getEstado()
                + "\n FechaCrea         " + getFechaCrea()
                + "\n FechaModifica     " + getFechaModifica();
    }
}
