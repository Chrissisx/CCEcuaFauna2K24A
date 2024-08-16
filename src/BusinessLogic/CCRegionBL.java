package BusinessLogic;

import java.util.List;

import DataAccess.CCRegionDAO;
import DataAccess.DTO.CCRegionDTO;

public class CCRegionBL {
    private CCRegionDTO ccRegionDTO;
    private CCRegionDAO ccRegionDAO = new CCRegionDAO();

    public CCRegionBL(){}

    public List<CCRegionDTO> getAll() throws Exception{
        List<CCRegionDTO> lst = ccRegionDAO.readAll();
        for (CCRegionDTO ccRegionDTO : lst) 
            ccRegionDTO.setNombreRegion(ccRegionDTO.getNombreRegion().toUpperCase());
        return lst;
    }
    public CCRegionDTO getBy(int CodigoRegion) throws Exception{
        ccRegionDTO = ccRegionDAO.readBy(CodigoRegion);
        return ccRegionDTO;
    }
    public boolean add(CCRegionDTO ccRegionDTO) throws Exception{   
        return ccRegionDAO.create(ccRegionDTO);
    }
    public boolean update(CCRegionDTO ccRegionDTO) throws Exception{
        return ccRegionDAO.update(ccRegionDTO);
    }
    public boolean delete(int CodigoRegion) throws Exception{
        return ccRegionDAO.delete(CodigoRegion);
    }
}
