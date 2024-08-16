package DataAccess.DTO;

public class CCRegionDTO {
    private Integer CodigoRegion;
    private String NombreRegion;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;
    
    public CCRegionDTO(){}

    public CCRegionDTO(String nombreRegion) {
        this.NombreRegion = nombreRegion;
    }

    public CCRegionDTO(int codigoRegion, String nombreRegion, String estado, String fechaCrea, String fechaModifica){
        this.CodigoRegion = codigoRegion;
        this.NombreRegion = nombreRegion;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
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


    public Integer getCodigoRegion() {
        return CodigoRegion;
    }
    public void setCodigoRegion(Integer codigoRegion) {
        CodigoRegion = codigoRegion;
    }
    public String getNombreRegion() {
        return NombreRegion;
    }
    public void setNombreRegion(String nombreRegion) {
        NombreRegion = nombreRegion;
    }

    @Override
    public String toString(){
        return  getClass().getName()
                + "\n CodigoRegion     "+ getCodigoRegion()
                + "\n NombreRegion     "+ getNombreRegion()
                + "\n Estado           "+ getEstado()
                + "\n FechaCrea        "+ getFechaCrea()
                + "\n FechaModifica    "+ getFechaModifica();
    }
}
