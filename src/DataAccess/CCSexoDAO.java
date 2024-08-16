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

import DataAccess.DTO.CCSexoDTO;
import Framework.PatException;

public class CCSexoDAO extends CCEcuaFaunaDataHelper implements IDAO<CCSexoDTO> {

    @Override
    public CCSexoDTO readBy(Integer id) throws Exception {
        CCSexoDTO sexo = new CCSexoDTO();
        String query = " SELECT CodigoSexo "
                     + " ,NombreSexo  "
                     + " ,Estado      "
                     + " ,FechaCrea   "
                     + " ,FechaModifica "
                     + " FROM CCSexo "
                     + " WHERE Estado = 'A' AND CodigoSexo = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                sexo = new CCSexoDTO(rs.getInt(1),       // CodigoSexo
                                     rs.getString(2),   // NombreSexo
                                     rs.getString(3),   // Estado
                                     rs.getString(4),   // FechaCrea
                                     rs.getString(5));  // FechaModifica
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return sexo;
    }

    @Override
    public List<CCSexoDTO> readAll() throws Exception {
        List<CCSexoDTO> lst = new ArrayList<>();
        String query = " SELECT CodigoSexo "
                     + " ,NombreSexo  "
                     + " ,Estado      "
                     + " ,FechaCrea   "
                     + " ,FechaModifica "
                     + " FROM CCSexo "
                     + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CCSexoDTO sexo = new CCSexoDTO(rs.getInt(1),       // CodigoSexo
                                                rs.getString(2),   // NombreSexo
                                                rs.getString(3),   // Estado
                                                rs.getString(4),   // FechaCrea
                                                rs.getString(5));  // FechaModifica
                lst.add(sexo);
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(CCSexoDTO entity) throws Exception {
        String query = " INSERT INTO CCSexo (NombreSexo) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreSexo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(CCSexoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE CCSexo SET NombreSexo = ?, FechaModifica = ? WHERE CodigoSexo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreSexo());
            pstmt.setString(2, dtf.format(now));
            pstmt.setInt(3, entity.getCodigoSexo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE CCSexo SET Estado = ? WHERE CodigoSexo = ?";
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
        String query = " SELECT COUNT(*) TotalReg FROM CCSexo "
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
