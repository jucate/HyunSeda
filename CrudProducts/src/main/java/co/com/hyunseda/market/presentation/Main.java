
package co.com.hyunseda.market.presentation;

import co.com.hyunseda.market.dataAccess.Factory;
import co.com.hyunseda.market.service.Service;
import co.com.hyunseda.market.dataAccess.IProductRepository;

/**
 *
 * @author Libardo Pantoja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IProductRepository repository = Factory.getInstance().getRepository("default");
        Service service = new Service(repository);
        GUIProducts instance = new GUIProducts(service);
        instance.setVisible(true);
    }
    
}
