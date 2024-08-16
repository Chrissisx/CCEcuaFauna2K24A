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

import DataAccess.DTO.CCProvinciaDTO;
import Framework.PatException;

public class CCProvinciaDAO extends CCEcuaFaunaDataHelper implements IDAO<CCProvinciaDTO> {

    @Override
    public CCProvinciaDTO readBy(Integer id) throws Exception {
        CCProvinciaDTO provincia = new CCProvinciaDTO();
        String query = " SELECT CodigoProvincia "
                     + " ,NombreProvincia  "
                     + " ,CodigoPais       "
                     + " ,CodigoRegion     "
                     + " ,Estado           "
                     + " ,FechaCrea        "
                     + " ,FechaModifica    "
                     + " FROM CCProvincia  "
                     + " WHERE Estado = 'A' AND CodigoProvincia = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                provincia = new CCProvinciaDTO(rs.getInt(1),       // CodigoProvincia
                                                rs.getString(2),   // NombreProvincia
                                                rs.getInt(3),       // CodigoPais
                                                rs.getInt(4),       // CodigoRegion
                                                rs.getString(5),   // Estado
                                                rs.getString(6),   // FechaCrea
                                                rs.getString(7));  // FechaModifica
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return provincia;
    }

    @Override
    public List<CCProvinciaDTO> readAll() throws Exception {
        List<CCProvinciaDTO> lst = new ArrayList<>();
        String query = " SELECT CodigoProvincia "
                     + " ,NombreProvincia  "
                     + " ,CodigoPais       "
                     + " ,CodigoRegion     "
                     + " ,Estado           "
                     + " ,FechaCrea        "
                     + " ,FechaModifica    "
                     + " FROM CCProvincia  "
                     + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CCProvinciaDTO provincia = new CCProvinciaDTO(rs.getInt(1),       // CodigoProvincia
                                                               rs.getString(2),   // NombreProvincia
                                                               rs.getInt(3),       // CodigoPais
                                                               rs.getInt(4),       // CodigoRegion
                                                               rs.getString(5),   // Estado
                                                               rs.getString(6),   // FechaCrea
                                                               rs.getString(7));  // FechaModifica
                lst.add(provincia);
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(CCProvinciaDTO entity) throws Exception {
        String query = " INSERT INTO CCProvincia (NombreProvincia, CodigoPais, CodigoRegion) VALUES (?, ?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreProvincia());
            pstmt.setInt(2, entity.getCodigoPais());
            pstmt.setInt(3, entity.getCodigoRegion());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(CCProvinciaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE CCProvincia SET NombreProvincia = ?, CodigoPais = ?, CodigoRegion = ?, FechaModifica = ? WHERE CodigoProvincia = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreProvincia());
            pstmt.setInt(2, entity.getCodigoPais());
            pstmt.setInt(3, entity.getCodigoRegion());
            pstmt.setString(4, dtf.format(now));
            pstmt.setInt(5, entity.getCodigoProvincia());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE CCProvincia SET Estado = ? WHERE CodigoProvincia = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public Integer getMaxRow() throws Exception {
        String query = " SELECT COUNT(*) TotalReg FROM CCProvincia "
                     + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
}
