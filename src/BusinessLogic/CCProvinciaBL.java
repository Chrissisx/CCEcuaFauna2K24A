package BusinessLogic;

import java.util.List;

import DataAccess.CCProvinciaDAO;
import DataAccess.DTO.CCProvinciaDTO;

public class CCProvinciaBL {
    private CCProvinciaDTO ccProvinciaDTO;
    private CCProvinciaDAO ccProvinciaDAO = new CCProvinciaDAO();

    public CCProvinciaBL(){}

    public List<CCProvinciaDTO> getAll() throws Exception{
        List<CCProvinciaDTO> lst = ccProvinciaDAO.readAll();
        for (CCProvinciaDTO ccProvinciaDTO : lst) 
            ccProvinciaDTO.setNombreProvincia(ccProvinciaDTO.getNombreProvincia().toUpperCase());
        return lst;
    }
    public CCProvinciaDTO getBy(int CodigoProvincia) throws Exception{
        ccProvinciaDTO = ccProvinciaDAO.readBy(CodigoProvincia);
        return ccProvinciaDTO;
    }
    public boolean add(CCProvinciaDTO ccProvinciaDTO) throws Exception{   
        return ccProvinciaDAO.create(ccProvinciaDTO);
    }
    public boolean update(CCProvinciaDTO ccProvinciaDTO) throws Exception{
        return ccProvinciaDAO.update(ccProvinciaDTO);
    }
    public boolean delete(int CodigoProvincia) throws Exception{
        return ccProvinciaDAO.delete(CodigoProvincia);
    }
}
