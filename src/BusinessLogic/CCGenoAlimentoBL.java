package BusinessLogic;

import java.util.List;

import DataAccess.CCGenoAlimentoDAO;
import DataAccess.DTO.CCGenoAlimentoDTO;

public class CCGenoAlimentoBL {
    private CCGenoAlimentoDTO ccGenoAlimentoDTO;
    private CCGenoAlimentoDAO ccGenoAlimentoDAO = new CCGenoAlimentoDAO();

    public CCGenoAlimentoBL(){}

    public List<CCGenoAlimentoDTO> getAll() throws Exception{
        List<CCGenoAlimentoDTO> lst = ccGenoAlimentoDAO.readAll();
        for (CCGenoAlimentoDTO ccGenoAlimentoDTO : lst) 
            ccGenoAlimentoDTO.setNombreGenoAlimento(ccGenoAlimentoDTO.getNombreGenoAlimento().toUpperCase());
        return lst;
    }
    public CCGenoAlimentoDTO getBy(int CodigoGenoAlimento) throws Exception{
        ccGenoAlimentoDTO = ccGenoAlimentoDAO.readBy(CodigoGenoAlimento);
        return ccGenoAlimentoDTO;
    }
    public boolean add(CCGenoAlimentoDTO ccGenoAlimentoDTO) throws Exception{   
        return ccGenoAlimentoDAO.create(ccGenoAlimentoDTO);
    }
    public boolean update(CCGenoAlimentoDTO ccGenoAlimentoDTO) throws Exception{
        return ccGenoAlimentoDAO.update(ccGenoAlimentoDTO);
    }
    public boolean delete(int CodigoGenoAlimento) throws Exception{
        return ccGenoAlimentoDAO.delete(CodigoGenoAlimento);
    }
}
