package BusinessLogic;

import java.util.List;

import DataAccess.CCEstadoDAO;
import DataAccess.DTO.CCEstadoDTO;

public class CCEstadoBL {
    private CCEstadoDTO ccEstadoDTO;
    private CCEstadoDAO ccEstadoDAO = new CCEstadoDAO();

    public CCEstadoBL(){}

    public List<CCEstadoDTO> getAll() throws Exception{
        List<CCEstadoDTO> lst = ccEstadoDAO.readAll();
        for (CCEstadoDTO ccEstadoDTO : lst) 
            ccEstadoDTO.setNombreEstado(ccEstadoDTO.getNombreEstado().toUpperCase());
        return lst;
    }
    public CCEstadoDTO getBy(int CodigoEstado) throws Exception{
        ccEstadoDTO = ccEstadoDAO.readBy(CodigoEstado);
        return ccEstadoDTO;
    }
    public boolean add(CCEstadoDTO ccEstadoDTO) throws Exception{   
        return ccEstadoDAO.create(ccEstadoDTO);
    }
    public boolean update(CCEstadoDTO ccEstadoDTO) throws Exception{
        return ccEstadoDAO.update(ccEstadoDTO);
    }
    public boolean delete(int CodigoEstado) throws Exception{
        return ccEstadoDAO.delete(CodigoEstado);
    }
}