/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.hyunseda.market.presentation;

import co.com.hyunseda.market.dataAccess.Product;
import co.com.hyunseda.market.presentation.observer.IOberver;
import co.com.hyunseda.market.service.ItemCompra;
import co.com.hyunseda.market.service.PayService;
import co.com.hyunseda.market.service.Service;
import co.unicauca.microkernel.plugin.manager.DeliveryPluginManager;
import com.hyunseda.payhyunseda.Payment;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class GUICarrito extends javax.swing.JFrame implements IOberver{
    private Service service;
    private PayService payService;
    List<ItemCompra> listProducts = new ArrayList<>();
    /**
     * Creates new form GUIProductsFind
     */
    public GUICarrito(Service service) {
        initComponents();
        initializeTable();
        this.service = service;
        this.payService = new PayService();
        setLocationRelativeTo(null); //centrar al ventana
    }
    public void setListProducts(List<ItemCompra> list){
        for (ItemCompra item : list) {
            listProducts.add(item);
        }
        fillTable(listProducts);
    }
    
    private void initializeTable() {
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Name", "Description", "Cantidad","Price"
                }
        ));
    }
    

        private void fillTable(List<ItemCompra> listProducts) {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
        Object rowData[] = new Object[5];//No columnas
        for (int i = 0; i < listProducts.size(); i++) {
            rowData[0] = listProducts.get(i).getProduct().getProductId();
            rowData[1] = listProducts.get(i).getProduct().getName();
            rowData[2] = listProducts.get(i).getProduct().getDescription();
            rowData[3] = listProducts.get(i).getCantidad();
            rowData[4] = listProducts.get(i).getProduct().getPrice()*listProducts.get(i).getCantidad();
            model.addRow(rowData);
        }
        
    }

    private void fillTable(Product product) {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
        //DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
        
        Object rowData[] = new Object[3];//No columnas
        rowData[0]=product.getProductId();
        rowData[1]=product.getName();
        rowData[2]=product.getDescription();
        model.addRow(rowData);
        }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        pnlNorth = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Carrito");

        pnlCenter.setLayout(new java.awt.BorderLayout());

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProducts);

        pnlCenter.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);
        getContentPane().add(pnlNorth, java.awt.BorderLayout.PAGE_START);

        jLabel1.setText("Cantidad:");
        jPanel1.add(jLabel1);

        txtSearch.setPreferredSize(new java.awt.Dimension(62, 32));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        jPanel1.add(txtSearch);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        jPanel1.add(btnPagar);

        btnClose.setText("Cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < listProducts.size(); i++) {
            if (tblProducts.isRowSelected(i)) {
                //service.findProductById((Long)tblProducts.getValueAt(i, 0));
                String cantidad = txtSearch.getText().trim();
                listProducts.get(i).setCantidad(Integer.parseInt(cantidad));
            }
        }
        update();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < listProducts.size(); i++) {
            if (tblProducts.isRowSelected(i)) {
                //service.findProductById((Long)tblProducts.getValueAt(i, 0));
                listProducts.remove(i);
            }
        }
        update();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        // TODO add your handling code here:
        String basePath = getBaseFilePath();
        try {
            DeliveryPluginManager.init(basePath);

            Consola2 presentationObject = new Consola2();
            presentationObject.handleDeliveryCostOption(20000, "pse", getTotalPrices());

        } catch (Exception ex) {
            Logger.getLogger("Application").log(Level.SEVERE, "Error al ejecutar la aplicación", ex);
        }
    }//GEN-LAST:event_btnPagarActionPerformed
    private double getTotalPrices(){
        double sum=0;
        for (int i = 0; i < listProducts.size(); i++) {
            for (int j = 0; j < listProducts.get(i).getCantidad(); j++) {
                sum=sum+listProducts.get(i).getProduct().getPrice();
            }       
        } 
        System.out.println(sum);
        return sum;
    }
    
    private static String getBaseFilePath() {
        try {
            String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            path = URLDecoder.decode(path, "UTF-8"); //This should solve the problem with spaces and special characters.
            File pathFile = new File(path);
            if (pathFile.isFile()) {
                path = pathFile.getParent();
                
                if (!path.endsWith(File.separator)) {
                    path += File.separator;
                }
                
            }

            return path;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error al eliminar espacios en la ruta del archivo", ex);
            return null;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnPagar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {
        fillTable(listProducts);
    }
}