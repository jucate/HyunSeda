package co.com.hyunseda.market.presentation;
import co.com.hyunseda.market.dataAccess.Factory;
import co.com.hyunseda.market.service.Service;
import co.com.hyunseda.market.dataAccess.IProductRepository;
import co.com.hyunseda.market.dataAccess.PluginManager;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        IProductRepository repository = Factory.getInstance().getRepository("default");
        Service service = new Service(repository);
        GUIProducts instance = new GUIProducts(service);
        instance.setVisible(true);
    }
    */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        String basePath = getBaseFilePath();
        try {
            PluginManager.init(basePath);
            IProductRepository repository = Factory.getInstance().getRepository("default");
            Service service = new Service(repository);
            GUIProducts instance = new GUIProducts(service);
            instance.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger("Application").log(Level.SEVERE, "Error al ejecutar la aplicación", ex);
        }
        
        
    }
    
    /**
     * Obtiene la ruta base donde está corriendo la aplicación, sin importar que
     * sea desde un archivo .class o desde un paquete .jar.
     *
     */
    private static String getBaseFilePath() {
        String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println(path);
        File pathFile = new File(path);
        if (pathFile.isFile()) {
            path = pathFile.getParent();

            if (!path.endsWith(File.separator)) {
                path += File.separator;
            }
        }
        return path;
    }
}
