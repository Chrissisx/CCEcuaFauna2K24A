package BusinessLogic;

import java.util.List;

import DataAccess.CCPaisDAO;
import DataAccess.DTO.CCPaisDTO;

public class CCPaisBL {
    private CCPaisDTO ccPaisDTO;
    private CCPaisDAO ccPaisDAO = new CCPaisDAO();

    public CCPaisBL(){}

    public List<CCPaisDTO> getAll() throws Exception{
        List<CCPaisDTO> lst = ccPaisDAO.readAll();
        for (CCPaisDTO ccPaisDTO : lst) 
            ccPaisDTO.setNombrePais(ccPaisDTO.getNombrePais().toUpperCase());
        return lst;
    }
    public CCPaisDTO getBy(int CodigoPais) throws Exception{
        ccPaisDTO = ccPaisDAO.readBy(CodigoPais);
        return ccPaisDTO;
    }
    public boolean add(CCPaisDTO ccPaisDTO) throws Exception{   
        return ccPaisDAO.create(ccPaisDTO);
    }
    public boolean update(CCPaisDTO ccPaisDTO) throws Exception{
        return ccPaisDAO.update(ccPaisDTO);
    }
    public boolean delete(int CodigoPais) throws Exception{
        return ccPaisDAO.delete(CodigoPais);
    }
}

