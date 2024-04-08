/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.hyunseda.market.presentation;

import co.com.hyunseda.market.dataAccess.Category;
import co.com.hyunseda.market.presentation.observer.IOberver;
import co.com.hyunseda.market.service.Service;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class GUICategoryFind extends javax.swing.JDialog implements IOberver {
    private Service service;
    /**
     * Creates new form GUIProductsFind
     */
    public GUICategoryFind(java.awt.Frame parent, boolean modal, Service service) {
        super(parent, modal);
        initComponents();
        initializeTable();
        this.service = service;
        setLocationRelativeTo(null); //centrar al ventana
    }
    
    private void initializeTable() {
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Category"
                }
        ));
    }
    

        private void fillTable(List<Category> listCategorys) {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();

        Object rowData[] = new Object[3];//No columnas
        for (int i = 0; i < listCategorys.size(); i++) {
            rowData[0] = listCategorys.get(i).getCategoryId();
            rowData[1] = listCategorys.get(i).getName();
            
            model.addRow(rowData);
        }
        
    }
    private void fillTable(Category category) {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();

        Object rowData[] = new Object[3];//No columnas
        rowData[0]=category.getCategoryId();
        rowData[1]=category.getName();      
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
        jLabel1 = new javax.swing.JLabel();
        rdoName = new javax.swing.JRadioButton();
        rdoCategoryId = new javax.swing.JRadioButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnSearchAll = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Búsqueda de categorias");

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

        jLabel1.setText("Buscar por:");
        pnlNorth.add(jLabel1);

        buttonGroup1.add(rdoName);
        rdoName.setText("Nombre de la categoria");
        pnlNorth.add(rdoName);

        buttonGroup1.add(rdoCategoryId);
        rdoCategoryId.setText("CategoryID");
        rdoCategoryId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoCategoryIdActionPerformed(evt);
            }
        });
        pnlNorth.add(rdoCategoryId);

        txtSearch.setPreferredSize(new java.awt.Dimension(62, 32));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        pnlNorth.add(txtSearch);

        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        pnlNorth.add(btnSearch);

        btnSearchAll.setText("Buscar Todos");
        btnSearchAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAllActionPerformed(evt);
            }
        });
        pnlNorth.add(btnSearchAll);

        getContentPane().add(pnlNorth, java.awt.BorderLayout.PAGE_START);

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

    private void btnSearchAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAllActionPerformed
        fillTable(service.findAllCategorys());
    }//GEN-LAST:event_btnSearchAllActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        txtSearchActionPerformed(evt);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        String idText  = txtSearch.getText().trim();
        if (rdoName.isSelected()) {
            fillTable(service.findCategoryByName(idText));
        }
        if (rdoCategoryId.isSelected()) {
            Long ide = Long.valueOf(idText);
            fillTable(service.findCategoryById(ide));
        }
    }//GEN-LAST:event_txtSearchActionPerformed

    private void rdoCategoryIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoCategoryIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoCategoryIdActionPerformed
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchAll;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JRadioButton rdoCategoryId;
    private javax.swing.JRadioButton rdoName;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtSearch;

    @Override
    public void update() {
        fillTable(service.findAllCategorys());
    }
    // End of variables declaration//GEN-END:variables
}
