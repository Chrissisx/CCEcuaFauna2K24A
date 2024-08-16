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

import DataAccess.DTO.CCTipoHormigaDTO;
import Framework.PatException;

public class CCTipoHormigaDAO extends CCEcuaFaunaDataHelper implements IDAO<CCTipoHormigaDTO> {

    @Override
    public CCTipoHormigaDTO readBy(Integer id) throws Exception {
        CCTipoHormigaDTO tipoHormiga = new CCTipoHormigaDTO();
        String query = " SELECT CodigoTipoHormiga "
                     + " ,NombreTipoHormiga  "
                     + " ,Estado             "
                     + " ,FechaCrea          "
                     + " ,FechaModifica      "
                     + " FROM CCTipoHormiga  "
                     + " WHERE Estado = 'A' AND CodigoTipoHormiga = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                tipoHormiga = new CCTipoHormigaDTO(rs.getInt(1),       // CodigoTipoHormiga
                                                    rs.getString(2),   // NombreTipoHormiga
                                                    rs.getString(3),   // Estado
                                                    rs.getString(4),   // FechaCrea
                                                    rs.getString(5));  // FechaModifica
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return tipoHormiga;
    }

    @Override
    public List<CCTipoHormigaDTO> readAll() throws Exception {
        List<CCTipoHormigaDTO> lst = new ArrayList<>();
        String query = " SELECT CodigoTipoHormiga "
                     + " ,NombreTipoHormiga  "
                     + " ,Estado             "
                     + " ,FechaCrea          "
                     + " ,FechaModifica      "
                     + " FROM CCTipoHormiga  "
                     + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CCTipoHormigaDTO tipoHormiga = new CCTipoHormigaDTO(rs.getInt(1),       // CodigoTipoHormiga
                                                                   rs.getString(2),   // NombreTipoHormiga
                                                                   rs.getString(3),   // Estado
                                                                   rs.getString(4),   // FechaCrea
                                                                   rs.getString(5));  // FechaModifica
                lst.add(tipoHormiga);
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(CCTipoHormigaDTO entity) throws Exception {
        String query = " INSERT INTO CCTipoHormiga (NombreTipoHormiga) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreTipoHormiga());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(CCTipoHormigaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE CCTipoHormiga SET NombreTipoHormiga = ?, FechaModifica = ? WHERE CodigoTipoHormiga = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreTipoHormiga());
            pstmt.setString(2, dtf.format(now));
            pstmt.setInt(3, entity.getCodigoTipoHormiga());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE CCTipoHormiga SET Estado = ? WHERE CodigoTipoHormiga = ?";
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
        String query = " SELECT COUNT(*) TotalReg FROM CCTipoHormiga "
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
