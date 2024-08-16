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

import DataAccess.DTO.CCGenoAlimentoDTO;
import Framework.PatException;

public class CCGenoAlimentoDAO extends CCEcuaFaunaDataHelper implements IDAO<CCGenoAlimentoDTO> {

    @Override
    public CCGenoAlimentoDTO readBy(Integer id) throws Exception {
        CCGenoAlimentoDTO geno = new CCGenoAlimentoDTO();
        String query = " SELECT CodigoGenoAlimento "
                     + " ,NombreGenoAlimento "
                     + " ,Estado             "
                     + " ,FechaCrea          "
                     + " ,FechaModifica      "
                     + " FROM CCGenoAlimento "
                     + " WHERE Estado = 'A' AND CodigoGenoAlimento = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                geno = new CCGenoAlimentoDTO(rs.getInt(1),       // CodigoGenoAlimento
                                              rs.getString(2),   // NombreGenoAlimento
                                              rs.getString(3),   // Estado
                                              rs.getString(4),   // FechaCrea
                                              rs.getString(5));  // FechaModifica
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return geno;
    }

    @Override
    public List<CCGenoAlimentoDTO> readAll() throws Exception {
        List<CCGenoAlimentoDTO> lst = new ArrayList<>();
        String query = " SELECT CodigoGenoAlimento "
                     + " ,NombreGenoAlimento "
                     + " ,Estado             "
                     + " ,FechaCrea          "
                     + " ,FechaModifica      "
                     + " FROM CCGenoAlimento "
                     + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CCGenoAlimentoDTO geno = new CCGenoAlimentoDTO(rs.getInt(1),       // CodigoGenoAlimento
                                                               rs.getString(2),   // NombreGenoAlimento
                                                               rs.getString(3),   // Estado
                                                               rs.getString(4),   // FechaCrea
                                                               rs.getString(5));  // FechaModifica
                lst.add(geno);
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(CCGenoAlimentoDTO entity) throws Exception {
        String query = " INSERT INTO CCGenoAlimento (NombreGenoAlimento) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreGenoAlimento());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(CCGenoAlimentoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE CCGenoAlimento SET NombreGenoAlimento = ?, FechaModifica = ? WHERE CodigoGenoAlimento = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreGenoAlimento());
            pstmt.setString(2, dtf.format(now));
            pstmt.setInt(3, entity.getCodigoGenoAlimento());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE CCGenoAlimento SET Estado = ? WHERE CodigoGenoAlimento = ?";
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
        String query = " SELECT COUNT(*) TotalReg FROM CCGenoAlimento "
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
