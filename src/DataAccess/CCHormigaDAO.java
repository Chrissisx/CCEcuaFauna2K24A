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

import DataAccess.DTO.CCHormigaDTO;
import Framework.PatException;

public class CCHormigaDAO extends CCEcuaFaunaDataHelper implements IDAO<CCHormigaDTO> {

    @Override
    public CCHormigaDTO readBy(Integer id) throws Exception {
        CCHormigaDTO hormiga = new CCHormigaDTO();
        String query = " SELECT CodigoHormiga "
                     + " ,NombreHormiga "
                     + " ,CodigoSexo "
                     + " ,CodigoTipoHormiga "
                     + " ,CodigoEstado "
                     + " ,CodigoProvincia "
                     + " ,CodigoAlimento "
                     + " ,Estado "
                     + " ,FechaCrea "
                     + " ,FechaModifica "
                     + " FROM CCHormiga "
                     + " WHERE Estado = 'A' AND CodigoHormiga = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                hormiga = new CCHormigaDTO(rs.getInt(1),       // CodigoHormiga
                                           rs.getString(2),   // NombreHormiga
                                           rs.getInt(3),       // CodigoSexo
                                           rs.getInt(4),       // CodigoTipoHormiga
                                           rs.getInt(5),       // CodigoEstado
                                           rs.getInt(6),       // CodigoProvincia
                                           rs.getInt(7),       // CodigoAlimento
                                           rs.getString(8),   // Estado
                                           rs.getString(9),   // FechaCrea
                                           rs.getString(10)); // FechaModifica
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return hormiga;
    }

    @Override
    public List<CCHormigaDTO> readAll() throws Exception {
        List<CCHormigaDTO> lst = new ArrayList<>();
        String query = " SELECT CodigoHormiga "
                     + " ,NombreHormiga "
                     + " ,CodigoSexo "
                     + " ,CodigoTipoHormiga "
                     + " ,CodigoEstado "
                     + " ,CodigoProvincia "
                     + " ,CodigoAlimento "
                     + " ,Estado "
                     + " ,FechaCrea "
                     + " ,FechaModifica "
                     + " FROM CCHormiga "
                     + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CCHormigaDTO hormiga = new CCHormigaDTO(rs.getInt(1),       // CodigoHormiga
                                                         rs.getString(2),   // NombreHormiga
                                                         rs.getInt(3),       // CodigoSexo
                                                         rs.getInt(4),       // CodigoTipoHormiga
                                                         rs.getInt(5),       // CodigoEstado
                                                         rs.getInt(6),       // CodigoProvincia
                                                         rs.getInt(7),       // CodigoAlimento
                                                         rs.getString(8),   // Estado
                                                         rs.getString(9),   // FechaCrea
                                                         rs.getString(10)); // FechaModifica
                lst.add(hormiga);
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(CCHormigaDTO entity) throws Exception {
        String query = " INSERT INTO CCHormiga (NombreHormiga, CodigoSexo, CodigoTipoHormiga, CodigoEstado, CodigoProvincia, CodigoAlimento) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.ccGetNombreHormiga());
            pstmt.setInt(2, entity.ccGetCodigoSexo());
            pstmt.setInt(3, entity.ccGetCodigoTipoHormiga());
            pstmt.setInt(4, entity.ccGetCodigoEstado());
            pstmt.setInt(5, entity.ccGetCodigoProvincia());
            pstmt.setInt(6, entity.ccGetCodigoAlimento());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(CCHormigaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE CCHormiga SET NombreHormiga = ?, CodigoSexo = ?, CodigoTipoHormiga = ?, CodigoEstado = ?, CodigoProvincia = ?, CodigoAlimento = ?, FechaModifica = ? WHERE CodigoHormiga = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.ccGetNombreHormiga());
            pstmt.setInt(2, entity.ccGetCodigoSexo());
            pstmt.setInt(3, entity.ccGetCodigoTipoHormiga());
            pstmt.setInt(4, entity.ccGetCodigoEstado());
            pstmt.setInt(5, entity.ccGetCodigoProvincia());
            pstmt.setInt(6, entity.ccGetCodigoAlimento());
            pstmt.setString(7, dtf.format(now));
            pstmt.setInt(8, entity.ccGetCodigoHormiga());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE CCHormiga SET Estado = ? WHERE CodigoHormiga = ?";
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
        String query = " SELECT COUNT(*) TotalReg FROM CCHormiga "
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
