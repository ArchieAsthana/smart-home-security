/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smart.home.security.view;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import smart.home.security.model.Device;
import smart.home.security.model.Devices;
import smart.home.security.utilities.DeviceSocketManager;

/**
 *
 * @author chana
 */
public class AddDevicePanel extends javax.swing.JPanel {
    private String ipAddress;
    /**
     * Creates new form AddDevicePanel
     */
    public AddDevicePanel(String address, String ipAddress) {        
        initComponents();
        this.ipAddress = ipAddress;
        macAddressTextfield.setText(address); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        nameTextField = new javax.swing.JTextField();
        macAddressTextfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ADD DEVICE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 12))); // NOI18N
        setPreferredSize(new java.awt.Dimension(408, 309));

        saveButton.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        saveButton.setText("Save");
        saveButton.setToolTipText("Click to save the device");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        nameTextField.setToolTipText("Enter the device name");
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        macAddressTextfield.setToolTipText(" mac-address of the device");
        macAddressTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                macAddressTextfieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel1.setText("Name");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel2.setText("Address");
        jLabel2.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21)
                        .addComponent(macAddressTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(saveButton)
                        .addGap(12, 12, 12)
                        .addComponent(cancelButton)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(macAddressTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(102, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Returns from add device panel to smart home security frame.

    private SmartHomeSecurityFrame getSmartHomeSecurityFrame() {
        return (SmartHomeSecurityFrame) SwingUtilities.getWindowAncestor(this);
    }

    /**
     * Provides Validation to the name field and address.
     *
     * @param evt
     */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String name = nameTextField.getText();
        String address = ipAddress;

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter a valid device name!");
        } else if (address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter a valid device address!");
        } else {
            Device device = new Device(name, address, macAddressTextfield.getText());
            Devices.getInstance().addDevice(device);
            
            DeviceSocketManager.getInstance().connectDevice(device);
            JOptionPane.showMessageDialog(this, "Device saved");
            getSmartHomeSecurityFrame().replaceFramePanel(new MainPanel());
        }
    }//GEN-LAST:event_saveButtonActionPerformed
    /**
     * Redirects to the smart home security page
     *
     * @param evt
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        getSmartHomeSecurityFrame().replaceFramePanel(new MainPanel());
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void macAddressTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_macAddressTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_macAddressTextfieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField macAddressTextfield;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
