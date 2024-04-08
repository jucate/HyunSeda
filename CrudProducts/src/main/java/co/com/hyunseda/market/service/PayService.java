package co.com.hyunseda.market.service;

import co.com.hyunseda.market.dataAccess.PluginManager;
import com.hyunseda.payhyunseda.IPaymentPlugin;
import com.hyunseda.payhyunseda.Payment;
public class PayService {
    
    public boolean pay(Payment payment) throws Exception {  
        PluginManager manager = PluginManager.getInstance();
        IPaymentPlugin payPlugin;
        payPlugin = manager.getPaymentPlugin("paymentMethod");
        if (payPlugin == null) {
            throw new Exception("No hay un plugin disponible para el método de pago especificado");
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


