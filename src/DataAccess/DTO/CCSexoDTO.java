package DataAccess.DTO;

public class CCSexoDTO {
    private Integer CodigoSexo;
    private String NombreSexo;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;

    public CCSexoDTO() {}

    public CCSexoDTO(String nombreSexo) {
        this.NombreSexo = nombreSexo;
    }

    public CCSexoDTO(Integer codigoSexo, String nombreSexo, String estado, String fechaCrea, String fechaModifica) {
        this.CodigoSexo = codigoSexo;
        this.NombreSexo = nombreSexo;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }

    public Integer getCodigoSexo() {
        return CodigoSexo;
    }

    public void setCodigoSexo(Integer codigoSexo) {
        CodigoSexo = codigoSexo;
    }

    public String getNombreSexo() {
        return NombreSexo;
    }

    public void setNombreSexo(String nombreSexo) {
        NombreSexo = nombreSexo;
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
                + "\n CodigoSexo        " + getCodigoSexo()
                + "\n NombreSexo        " + getNombreSexo()
                + "\n Estado            " + getEstado()
                + "\n FechaCrea         " + getFechaCrea()
                + "\n FechaModifica     " + getFechaModifica();
    }
}
