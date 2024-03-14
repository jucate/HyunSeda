package co.com.hyunseda.market.service;

import co.com.hyunseda.market.dataAccess.PluginManager;
import com.mycompany.payhyunseda.IPaymentPlugin;
import com.mycompany.payhyunseda.Payment;

/**
 *
 * @author IngSis
 */
public class PayService {
    
    public boolean pay(Payment payment) throws Exception {    
        int idPaymentDocument = payment.getIdPayDocument();
        PluginManager manager = PluginManager.getInstance();
        IPaymentPlugin payPlugin = manager.getPublisherPlugin("payment.getIdPayDocument()");
        if (payPlugin == null) {
            throw new Exception("No hay un plugin disponible para el país indicado: " + idPaymentDocument);
        }
        return payPlugin.payProcessing(payment);
    }
    //PluginManager manager = new PluginManager();
    /*public boolean pay(Payment payment){
        IPaymentPlugin payPlugin = manager.getPublisherPlugin(payment);
        return payPlugin.payProcessing(payment);
    }
*/
}
