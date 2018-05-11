package smart.home.security.view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import smart.home.security.model.Device;
import smart.home.security.model.Devices;
import smart.home.security.utilities.DeviceSocketManager;
import smart.home.security.utilities.DeviceTableModel;

/**
 * The view that shows all the devices that can be removed.
 * @author archana
 */
public class RemoveDevicePanel extends javax.swing.JPanel {

    /**
     * Create the remove device panel view.
     */
    public RemoveDevicePanel() {
        // Initialize the components of the remove device panel.
        initComponents();
        // Get the list of all the devices.
        List<Device> devices = Devices.getInstance().getDevices();
        // Create the table model with the list of devices.
        DefaultTableModel model = DeviceTableModel.defaultTableModel(devices);
        // Update the table with the devices model.
        removeDeviceTable.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        removeButton = new javax.swing.JButton();
        cancelRemoveButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        removeDeviceTable = new javax.swing.JTable();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Remove Device", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 12))); // NOI18N
        setPreferredSize(new java.awt.Dimension(408, 309));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        removeButton.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        removeButton.setText("Remove");
        removeButton.setToolTipText("Are you sure");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        add(removeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 80, -1));

        cancelRemoveButton.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        cancelRemoveButton.setText("Cancel");
        cancelRemoveButton.setToolTipText("");
        cancelRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelRemoveButtonActionPerformed(evt);
            }
        });
        add(cancelRemoveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 80, -1));

        removeDeviceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Address"
            }
        ));
        jScrollPane3.setViewportView(removeDeviceTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 380, 240));
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Helper to get the smart home security frame. 
     * @return the SmartHomeSecurityFrame of this component.
     */
    private SmartHomeSecurityFrame getSmartHomeSecurityFrame() {
        return (SmartHomeSecurityFrame) SwingUtilities.getWindowAncestor(this);
    }
    
    /**
     * Redirects to the smart home security page when cancel button is pressed.
     * @param evt - The button click action event.
     */
    private void cancelRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelRemoveButtonActionPerformed
        // Navigate back to the main panel when cancel is pressed.
        getSmartHomeSecurityFrame().replaceFramePanel(new MainPanel());
    }//GEN-LAST:event_cancelRemoveButtonActionPerformed

    /**
     * The remove button action. 
     * @param evt - The button click action event. 
     */
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // Get the selected index in the table view.
        int selectedIndex = removeDeviceTable.getSelectedRow();
        
        // Validate the selected index.
        if (selectedIndex >= 0) {
            // Get the device at the selected index.
            Device device = Devices.getInstance().getDevices().get(selectedIndex);
            // Remove the device from the list of devices.
            Devices.getInstance().removeDevice(device);
            // Disconnect the device connection.
            DeviceSocketManager.getInstance().disconnectDevice(device);            
            // Notify the user that the device has been successfully removed.
            JOptionPane.showMessageDialog(this, "Device removed");
            // Navigate to the main view panel.
            getSmartHomeSecurityFrame().replaceFramePanel(new MainPanel());
        }
    }//GEN-LAST:event_removeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelRemoveButton;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton removeButton;
    private javax.swing.JTable removeDeviceTable;
    // End of variables declaration//GEN-END:variables
}
