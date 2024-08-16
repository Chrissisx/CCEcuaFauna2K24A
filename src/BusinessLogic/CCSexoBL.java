package BusinessLogic;

import java.util.List;

import DataAccess.CCSexoDAO;
import DataAccess.DTO.CCSexoDTO;

public class CCSexoBL {
    private CCSexoDTO ccSexoDTO;
    private CCSexoDAO ccSexoDAO = new CCSexoDAO();

    public CCSexoBL(){}

    public List<CCSexoDTO> getAll() throws Exception{
        List<CCSexoDTO> lst = ccSexoDAO.readAll();
        for (CCSexoDTO ccSexoDTO : lst) 
            ccSexoDTO.setNombreSexo(ccSexoDTO.getNombreSexo().toUpperCase());
        return lst;
    }
    public CCSexoDTO getBy(int CodigoSexo) throws Exception{
        ccSexoDTO = ccSexoDAO.readBy(CodigoSexo);
        return ccSexoDTO;
    }
    public boolean add(CCSexoDTO ccSexoDTO) throws Exception{   
        return ccSexoDAO.create(ccSexoDTO);
    }
    public boolean update(CCSexoDTO ccSexoDTO) throws Exception{
        return ccSexoDAO.update(ccSexoDTO);
    }
    public boolean delete(int CodigoSexo) throws Exception{
        return ccSexoDAO.delete(CodigoSexo);
    }
}
