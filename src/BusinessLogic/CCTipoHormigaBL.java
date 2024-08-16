package BusinessLogic;

import java.util.List;

import DataAccess.CCTipoHormigaDAO;
import DataAccess.DTO.CCTipoHormigaDTO;

public class CCTipoHormigaBL {
    private CCTipoHormigaDTO ccTipoHormigaDTO;
    private CCTipoHormigaDAO ccTipoHormigaDAO = new CCTipoHormigaDAO();

    public CCTipoHormigaBL(){}

    public List<CCTipoHormigaDTO> getAll() throws Exception{
        List<CCTipoHormigaDTO> lst = ccTipoHormigaDAO.readAll();
        for (CCTipoHormigaDTO ccTipoHormigaDTO : lst) 
            ccTipoHormigaDTO.setNombreTipoHormiga(ccTipoHormigaDTO.getNombreTipoHormiga().toUpperCase());
        return lst;
    }
    public CCTipoHormigaDTO getBy(int CodigoTipoHormiga) throws Exception{
        ccTipoHormigaDTO = ccTipoHormigaDAO.readBy(CodigoTipoHormiga);
        return ccTipoHormigaDTO;
    }
    public boolean add(CCTipoHormigaDTO ccTipoHormigaDTO) throws Exception{   
        return ccTipoHormigaDAO.create(ccTipoHormigaDTO);
    }
    public boolean update(CCTipoHormigaDTO ccTipoHormigaDTO) throws Exception{
        return ccTipoHormigaDAO.update(ccTipoHormigaDTO);
    }
    public boolean delete(int CodigoTipoHormiga) throws Exception{
        return ccTipoHormigaDAO.delete(CodigoTipoHormiga);
    }
}
