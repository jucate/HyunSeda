package co.com.hyunseda.market.presentation;

import co.com.hyunseda.market.dataAccess.Category;
import co.com.hyunseda.market.dataAccess.Product;
import co.com.hyunseda.market.service.*;

import javax.swing.JOptionPane;

/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class GUICategory extends javax.swing.JFrame {


    private boolean addOption;
    private Service service;
    /**
     * Creates new form GUIProducts
     */
    public GUICategory(Service service) {
        initComponents();
        this.service = service;
        stateInitial();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSouth = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Category");

        pnlSouth.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        pnlSouth.add(btnNuevo);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pnlSouth.add(btnEditar);

        btnSave.setText("Grabar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        pnlSouth.add(btnSave);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlSouth.add(btnCancelar);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnlSouth.add(btnEliminar);

        btnFind.setText("Buscar");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        pnlSouth.add(btnFind);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        pnlSouth.add(btnCerrar);

        getContentPane().add(pnlSouth, java.awt.BorderLayout.SOUTH);

        pnlCenter.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCenter.setLayout(new java.awt.GridLayout(3, 2));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("*CategoryId:");
        pnlCenter.add(jLabel1);

        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdFocusLost(evt);
            }
        });
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        pnlCenter.add(txtId);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("*Nombre:");
        pnlCenter.add(jLabel2);
        pnlCenter.add(txtName);

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        stateNew();
        txtName.requestFocus();
        addOption = true;
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        stateInitial();
        cleanControls();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (txtName.getText().trim().equals("")) {
            Messages.showMessageDialog("Debe ingresar el nombre de la categoria", "Atención");
            txtName.requestFocus();
            return;
        }
        if (addOption) {
            //Agregar
            addCategory();

        } else {
            //Editar
            
            editCategory();
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        addOption = false;
        stateEdit();
        txtId.requestFocus();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusLost
        if (txtId.getText().trim().isEmpty()) {
            return;
        }
        Long productId = Long.parseLong(txtId.getText());
        Product prod = service.findProductById(productId);
        if (prod == null) {
            Messages.showMessageDialog("El identificador del producto no existe", "Error");
            txtId.setText("");
            txtId.requestFocus();
        } else {
            txtName.setText(prod.getName());

        }
    }//GEN-LAST:event_txtIdFocusLost

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String id = txtId.getText().trim();
        if (id.equals("")) {
            Messages.showMessageDialog("Debe buscar el producto a eliminar", "Atención");
            txtId.requestFocus();
            return;
        }
        Long productId = Long.parseLong(id);
        if (Messages.showConfirmDialog("Está seguro que desea eliminar este producto?", "Confirmación") == JOptionPane.YES_NO_OPTION) {
            if (service.deleteProduct(productId)) {
                Messages.showMessageDialog("Producto eliminado con éxito", "Atención");
                stateInitial();
                cleanControls();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        GUICategoryFind instance = new GUICategoryFind(this, true, service);
        instance.setVisible(true);
    }//GEN-LAST:event_btnFindActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed
    private void stateEdit() {
        btnNuevo.setVisible(false);
        btnEditar.setVisible(false);
        btnEliminar.setVisible(true);
        btnCancelar.setVisible(true);
        btnCerrar.setVisible(false);
        btnSave.setVisible(true);
        btnFind.setVisible(false);
        txtId.setEnabled(true);
        txtName.setEnabled(true);
    }

    private void stateInitial() {
        btnNuevo.setVisible(true);
        btnEditar.setVisible(true);
        btnEliminar.setVisible(false);
        btnCancelar.setVisible(false);
        btnCerrar.setVisible(true);
        btnSave.setVisible(false);
        btnFind.setVisible(true);
        txtId.setEnabled(false);
        txtName.setEnabled(false);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlSouth;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    private void stateNew() {
        btnNuevo.setVisible(false);
        btnEditar.setVisible(false);
        btnEliminar.setVisible(false);
        btnCancelar.setVisible(true);
        btnCerrar.setVisible(false);
        btnSave.setVisible(true);
        btnFind.setVisible(false);
        txtId.setEnabled(false);
        txtName.setEnabled(true);

    }

    private void cleanControls() {
        txtId.setText("");
        txtName.setText("");
    }

    private void addCategory() {
        String name = txtName.getText().trim();
        
        Category newCategory = new Category();
        newCategory.setName(name);
        if (service.saveCategory(newCategory)) {
            Messages.showMessageDialog("Se grabó con éxito", "Atención");
            cleanControls();
            stateInitial();
        } else {
            Messages.showMessageDialog("Error al grabar, lo siento mucho", "Atención");
        }
    }

    private void editCategory() {
        String id = txtId.getText().trim();
        if (id.equals("")) {
            Messages.showMessageDialog("Debe buscar el producto a editar", "Atención");
            txtId.requestFocus();
            return;
        }
        Long categoryId = Long.parseLong(id);
        Category cat = new Category();
        cat.setName(txtName.getText().trim());

        if (service.editCategory(categoryId, cat)) {
            Messages.showMessageDialog("Se editó con éxito", "Atención");
            cleanControls();
            stateInitial();
        } else {
            Messages.showMessageDialog("Error al editar, lo siento mucho", "Atención");
        }
    }

}
