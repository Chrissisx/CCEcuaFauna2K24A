package DataAccess;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.CCRegionDTO;
import Framework.PatException;

public class CCRegionDAO extends CCEcuaFaunaDataHelper implements IDAO<CCRegionDTO> {

    @Override
    public CCRegionDTO readBy(Integer id) throws Exception {
            CCRegionDTO oS = new CCRegionDTO();
            String query =" SELEC CodigoRegion "
                     + " ,NombreRegion     "
                     + " ,Estado           "
                     + " ,FechaCrea        "
                     + " ,FechaModifica    "
                     + " FROM   CCRegion   "
                     + " WHERE  Estado = 'A' AND CodigoRegion =     "+id.toString();
            try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                oS = new CCRegionDTO( rs.getInt(1)       // CodigoRegion
                                     ,rs.getString(2)   // NombreRegion
                                     ,rs.getString(3)   // Estado             
                                     ,rs.getString(4)   // FechaCrea         
                                     ,rs.getString(5)); // FechaModifica
            }
        } 
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
    public List<CCRegionDTO> readAll() throws Exception {
        List <CCRegionDTO> lst = new ArrayList<>();
        String query =" SELECT CodigoRegion "
                     + " ,NombreRegion     "
                     + " ,Estado           "
                     + " ,FechaCrea        "
                     + " ,FechaModifica    "
                     + " FROM   CCRegion   "
                     + " WHERE  Estado = 'A' ";

            try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                CCRegionDTO s = new CCRegionDTO( rs.getInt(1)       // CodigoRegion
                                                ,rs.getString(2)   // NombreRegion
                                                ,rs.getString(3)   // Estado             
                                                ,rs.getString(4)   // FechaCrea         
                                                ,rs.getString(5)); // FechaModifica
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean create(CCRegionDTO entity) throws Exception {
        String query = " INSERT INTO CCREGION (NombreRegion) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreRegion());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }


    @Override
    public boolean update(CCRegionDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE CCREGION SET NombreRegion = ?, FechaModifica = ? WHERE CodigoRegion = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreRegion());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getCodigoRegion());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    } 

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE CCREGION SET Estado = ? WHERE CodigoRegion = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public Integer getMaxRow() throws Exception {
        String query =" SELECT COUNT(*) TotalReg FROM CCREGION "
                     +" WHERE   Estado = 'A' ";
        try{
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);
            }
        }
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
}
