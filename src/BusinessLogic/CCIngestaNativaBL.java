package BusinessLogic;

import java.util.List;

import DataAccess.CCIngestaNativaDAO;
import DataAccess.DTO.CCIngestaNativaDTO;

public class CCIngestaNativaBL {
    private CCIngestaNativaDTO ccIngestaNativaDTO;
    private CCIngestaNativaDAO ccIngestaNativaDAO = new CCIngestaNativaDAO();

    public CCIngestaNativaBL(){}

    public List<CCIngestaNativaDTO> getAll() throws Exception{
        List<CCIngestaNativaDTO> lst = ccIngestaNativaDAO.readAll();
        for (CCIngestaNativaDTO ccIngestaNativaDTO : lst) 
            ccIngestaNativaDTO.setNombreIngestaNativa(ccIngestaNativaDTO.getNombreIngestaNativa().toUpperCase());
        return lst;
    }
    public CCIngestaNativaDTO getBy(int CodigoIngestaNativa) throws Exception{
        ccIngestaNativaDTO = ccIngestaNativaDAO.readBy(CodigoIngestaNativa);
        return ccIngestaNativaDTO;
    }
    public boolean add(CCIngestaNativaDTO ccIngestaNativaDTO) throws Exception{   
        return ccIngestaNativaDAO.create(ccIngestaNativaDTO);
    }
    public boolean update(CCIngestaNativaDTO ccIngestaNativaDTO) throws Exception{
        return ccIngestaNativaDAO.update(ccIngestaNativaDTO);
    }
    public boolean delete(int CodigoIngestaNativa) throws Exception{
        return ccIngestaNativaDAO.delete(CodigoIngestaNativa);
    }
}
