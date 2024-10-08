import DataAccess.CCPaisDAO;
import DataAccess.CCRegionDAO;
import DataAccess.CCProvinciaDAO;
import DataAccess.CCTipoHormigaDAO;
import DataAccess.CCSexoDAO;
import BusinessLogic.CCRegionBL;
import DataAccess.CCEstadoDAO;
import DataAccess.CCIngestaNativaDAO;
import DataAccess.CCGenoAlimentoDAO;
import DataAccess.DTO.CCPaisDTO;
import DataAccess.DTO.CCRegionDTO;
import DataAccess.DTO.CCProvinciaDTO;
import DataAccess.DTO.CCTipoHormigaDTO;
import DataAccess.DTO.CCSexoDTO;
import DataAccess.DTO.CCEstadoDTO;
import DataAccess.DTO.CCIngestaNativaDTO;
import DataAccess.DTO.CCGenoAlimentoDTO;
import DataAccess.CCAlimentoDAO;
import DataAccess.CCHormigaAlimentoDAO;
import DataAccess.CCHormigaDAO;
import DataAccess.DTO.CCAlimentoDTO;
import DataAccess.DTO.CCHormigaAlimentoDTO;
import DataAccess.DTO.CCHormigaDTO;
import UserInterface.Form.CCLogin;
import UserInterface.Form.SplashScreen;

public class App {
    public static void main(String[] args) {

        try {
            // Test CCRegionDAO
            CCRegionDAO ccRegionDAO = new CCRegionDAO();
            System.out.println("CCRegion:");
            for (CCRegionDTO ccRegion : ccRegionDAO.readAll())
                System.out.println(ccRegion.toString());
        } catch (Exception e) {
            System.out.println("Error en CCRegionDAO: " + e.toString());
        }

        // BL
        
        try {
            // Test CCRegionDAO
            CCRegionBL ccRegionBCCRegionBL = new CCRegionBL();
            System.out.println("CCRegion:");
            for (CCRegionDTO ccRegion : ccRegionBCCRegionBL.getAll())
                System.out.println(ccRegion.toString());
        } catch (Exception e) {
            System.out.println("Error en CCRegionDAO: " + e.toString());
        }

        try {
            // Test CCPaisDAO
            CCPaisDAO ccPaisDAO = new CCPaisDAO();
            System.out.println("CCPais:");
            for (CCPaisDTO ccPais : ccPaisDAO.readAll())
                System.out.println(ccPais.toString());
        } catch (Exception e) {
            System.out.println("Error en CCPaisDAO: " + e.toString());
        }

        try {
            // Test CCProvinciaDAO
            CCProvinciaDAO ccProvinciaDAO = new CCProvinciaDAO();
            System.out.println("CCProvincia:");
            for (CCProvinciaDTO ccProvincia : ccProvinciaDAO.readAll())
                System.out.println(ccProvincia.toString());
        } catch (Exception e) {
            System.out.println("Error en CCProvinciaDAO: " + e.toString());
        }

        try {
            // Test CCTipoHormigaDAO
            CCTipoHormigaDAO ccTipoHormigaDAO = new CCTipoHormigaDAO();
            System.out.println("CCTipoHormiga:");
            for (CCTipoHormigaDTO ccTipoHormiga : ccTipoHormigaDAO.readAll())
                System.out.println(ccTipoHormiga.toString());
        } catch (Exception e) {
            System.out.println("Error en CCTipoHormigaDAO: " + e.toString());
        }

        try {
            // Test CCSexoDAO
            CCSexoDAO ccSexoDAO = new CCSexoDAO();
            System.out.println("CCSexo:");
            for (CCSexoDTO ccSexo : ccSexoDAO.readAll())
                System.out.println(ccSexo.toString());
        } catch (Exception e) {
            System.out.println("Error en CCSexoDAO: " + e.toString());
        }

        try {
            // Test CCEstadoDAO
            CCEstadoDAO ccEstadoDAO = new CCEstadoDAO();
            System.out.println("CCEstado:");
            for (CCEstadoDTO ccEstado : ccEstadoDAO.readAll())
                System.out.println(ccEstado.toString());
        } catch (Exception e) {
            System.out.println("Error en CCEstadoDAO: " + e.toString());
        }

        try {
            // Test CCIngestaNativaDAO
            CCIngestaNativaDAO ccIngestaNativaDAO = new CCIngestaNativaDAO();
            System.out.println("CCIngestaNativa:");
            for (CCIngestaNativaDTO ccIngestaNativa : ccIngestaNativaDAO.readAll())
                System.out.println(ccIngestaNativa.toString());
        } catch (Exception e) {
            System.out.println("Error en CCIngestaNativaDAO: " + e.toString());
        }

        try {
            // Test CCGenoAlimentoDAO
            CCGenoAlimentoDAO ccGenoAlimentoDAO = new CCGenoAlimentoDAO();
            System.out.println("CCGenoAlimento:");
            for (CCGenoAlimentoDTO ccGenoAlimento : ccGenoAlimentoDAO.readAll())
                System.out.println(ccGenoAlimento.toString());
        } catch (Exception e) {
            System.out.println("Error en CCGenoAlimentoDAO: " + e.toString());
        }
        
        try {
            // Test CCAlimentoDAO
            CCAlimentoDAO ccAlimentoDAO = new CCAlimentoDAO();
            System.out.println("CCAlimento:");
            for (CCAlimentoDTO ccAlimento : ccAlimentoDAO.readAll())
                System.out.println(ccAlimento.toString());
        } catch (Exception e) {
            System.out.println("Error en CCAlimentoDAO: " + e.toString());
        }

        
        try {
            // Test CCHormigaAlimentoDAO
            CCHormigaAlimentoDAO ccHormigaAlimentoDAO = new CCHormigaAlimentoDAO();
            System.out.println("CCHormigaAlimento:");
            for (CCHormigaAlimentoDTO ccHormigaAlimento : ccHormigaAlimentoDAO.readAll())
            System.out.println(ccHormigaAlimento.toString());
        } catch (Exception e) {
            System.out.println("Error en CCHormigaAlimentoDAO: " + e.toString());
        }

        try {
            // Test CCHormigaDAO
        CCHormigaDAO ccHormigaDAO = new CCHormigaDAO();
        System.out.println("CCHormiga:");
        for (CCHormigaDTO ccHormiga : ccHormigaDAO.readAll())
            System.out.println(ccHormiga.toString());
        } catch (Exception e) {
            System.out.println("Error en CCHormigaDAO: " + e.toString());
        }

        SplashScreen.show();
        CCLogin.showLogin();
    }
}

