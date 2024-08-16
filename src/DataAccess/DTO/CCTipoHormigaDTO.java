package DataAccess.DTO;

public class CCTipoHormigaDTO {
    private Integer CodigoTipoHormiga;
    private String NombreTipoHormiga;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;

    public CCTipoHormigaDTO() {}

    public CCTipoHormigaDTO(String nombreTipoHormiga) {
        this.NombreTipoHormiga = nombreTipoHormiga;
    }

    public CCTipoHormigaDTO(Integer codigoTipoHormiga, String nombreTipoHormiga, String estado, String fechaCrea, String fechaModifica) {
        this.CodigoTipoHormiga = codigoTipoHormiga;
        this.NombreTipoHormiga = nombreTipoHormiga;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }

    public Integer getCodigoTipoHormiga() {
        return CodigoTipoHormiga;
    }

    public void setCodigoTipoHormiga(Integer codigoTipoHormiga) {
        CodigoTipoHormiga = codigoTipoHormiga;
    }

    public String getNombreTipoHormiga() {
        return NombreTipoHormiga;
    }

    public void setNombreTipoHormiga(String nombreTipoHormiga) {
        NombreTipoHormiga = nombreTipoHormiga;
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
                + "\n CodigoTipoHormiga   " + getCodigoTipoHormiga()
                + "\n NombreTipoHormiga   " + getNombreTipoHormiga()
                + "\n Estado              " + getEstado()
                + "\n FechaCrea           " + getFechaCrea()
                + "\n FechaModifica       " + getFechaModifica();
    }
}
