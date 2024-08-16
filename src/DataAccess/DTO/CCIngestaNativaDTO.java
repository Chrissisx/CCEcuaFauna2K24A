package DataAccess.DTO;

public class CCIngestaNativaDTO {
    private Integer CodigoIngestaNativa;
    private String NombreIngestaNativa;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;

    public CCIngestaNativaDTO() {}

    public CCIngestaNativaDTO(String nombreIngestaNativa) {
        this.NombreIngestaNativa = nombreIngestaNativa;
    }

    public CCIngestaNativaDTO(Integer codigoIngestaNativa, String nombreIngestaNativa, String estado, String fechaCrea, String fechaModifica) {
        this.CodigoIngestaNativa = codigoIngestaNativa;
        this.NombreIngestaNativa = nombreIngestaNativa;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }

    public Integer getCodigoIngestaNativa() {
        return CodigoIngestaNativa;
    }

    public void setCodigoIngestaNativa(Integer codigoIngestaNativa) {
        CodigoIngestaNativa = codigoIngestaNativa;
    }

    public String getNombreIngestaNativa() {
        return NombreIngestaNativa;
    }

    public void setNombreIngestaNativa(String nombreIngestaNativa) {
        NombreIngestaNativa = nombreIngestaNativa;
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
                + "\n CodigoIngestaNativa " + getCodigoIngestaNativa()
                + "\n NombreIngestaNativa " + getNombreIngestaNativa()
                + "\n Estado              " + getEstado()
                + "\n FechaCrea           " + getFechaCrea()
                + "\n FechaModifica       " + getFechaModifica();
    }
}
