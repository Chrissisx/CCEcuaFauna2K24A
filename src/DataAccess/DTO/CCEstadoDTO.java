package DataAccess.DTO;

public class CCEstadoDTO {
    private Integer CodigoEstado;
    private String NombreEstado;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;

    public CCEstadoDTO() {}

    public CCEstadoDTO(String nombreEstado) {
        this.NombreEstado = nombreEstado;
    }

    public CCEstadoDTO(Integer codigoEstado, String nombreEstado, String estado, String fechaCrea, String fechaModifica) {
        this.CodigoEstado = codigoEstado;
        this.NombreEstado = nombreEstado;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }

    public Integer getCodigoEstado() {
        return CodigoEstado;
    }

    public void setCodigoEstado(Integer codigoEstado) {
        CodigoEstado = codigoEstado;
    }

    public String getNombreEstado() {
        return NombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        NombreEstado = nombreEstado;
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
                + "\n CodigoEstado      " + getCodigoEstado()
                + "\n NombreEstado      " + getNombreEstado()
                + "\n Estado            " + getEstado()
                + "\n FechaCrea         " + getFechaCrea()
                + "\n FechaModifica     " + getFechaModifica();
    }
}
