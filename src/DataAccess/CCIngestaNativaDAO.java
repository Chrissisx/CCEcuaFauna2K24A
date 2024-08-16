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

import DataAccess.DTO.CCIngestaNativaDTO;
import Framework.PatException;

public class CCIngestaNativaDAO extends CCEcuaFaunaDataHelper implements IDAO<CCIngestaNativaDTO> {

    @Override
    public CCIngestaNativaDTO readBy(Integer id) throws Exception {
        CCIngestaNativaDTO ingesta = new CCIngestaNativaDTO();
        String query = " SELECT CodigoIngestaNativa "
                     + " ,NombreIngestaNativa "
                     + " ,Estado             "
                     + " ,FechaCrea          "
                     + " ,FechaModifica      "
                     + " FROM CCIngestaNativa "
                     + " WHERE Estado = 'A' AND CodigoIngestaNativa = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ingesta = new CCIngestaNativaDTO(rs.getInt(1),       // CodigoIngestaNativa
                                                 rs.getString(2),   // NombreIngestaNativa
                                                 rs.getString(3),   // Estado
                                                 rs.getString(4),   // FechaCrea
                                                 rs.getString(5));  // FechaModifica
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return ingesta;
    }

    @Override
    public List<CCIngestaNativaDTO> readAll() throws Exception {
        List<CCIngestaNativaDTO> lst = new ArrayList<>();
        String query = " SELECT CodigoIngestaNativa "
                     + " ,NombreIngestaNativa "
                     + " ,Estado             "
                     + " ,FechaCrea          "
                     + " ,FechaModifica      "
                     + " FROM CCIngestaNativa "
                     + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CCIngestaNativaDTO ingesta = new CCIngestaNativaDTO(rs.getInt(1),       // CodigoIngestaNativa
                                                                   rs.getString(2),   // NombreIngestaNativa
                                                                   rs.getString(3),   // Estado
                                                                   rs.getString(4),   // FechaCrea
                                                                   rs.getString(5));  // FechaModifica
                lst.add(ingesta);
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(CCIngestaNativaDTO entity) throws Exception {
        String query = " INSERT INTO CCIngestaNativa (NombreIngestaNativa) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreIngestaNativa());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(CCIngestaNativaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE CCIngestaNativa SET NombreIngestaNativa = ?, FechaModifica = ? WHERE CodigoIngestaNativa = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreIngestaNativa());
            pstmt.setString(2, dtf.format(now));
            pstmt.setInt(3, entity.getCodigoIngestaNativa());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE CCIngestaNativa SET Estado = ? WHERE CodigoIngestaNativa = ?";
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
        String query = " SELECT COUNT(*) TotalReg FROM CCIngestaNativa "
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
