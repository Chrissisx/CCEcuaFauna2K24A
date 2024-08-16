package DataAccess.DTO;

public class CCPaisDTO {
    private Integer CodigoPais;
    private String NombrePais;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;
    
    public CCPaisDTO(){}

    public CCPaisDTO(String nombrePais) {
        this.NombrePais = nombrePais;
    }

    public CCPaisDTO(int codigoPais, String nombrePais, String estado, String fechaCrea, String fechaModifica){
        this.CodigoPais = codigoPais;
        this.NombrePais = nombrePais;
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

    public Integer getCodigoPais() {
        return CodigoPais;
    }
    public void setCodigoPais(Integer codigoPais) {
        CodigoPais = codigoPais;
    }
    public String getNombrePais() {
        return NombrePais;
    }
    public void setNombrePais(String nombrePais) {
        NombrePais = nombrePais;
    }

    @Override
    public String toString(){
        return  getClass().getName()
                + "\n CodigoPais       "+ getCodigoPais()
                + "\n NombrePais       "+ getNombrePais()
                + "\n Estado           "+ getEstado()
                + "\n FechaCrea        "+ getFechaCrea()
                + "\n FechaModifica    "+ getFechaModifica();
    }
}
