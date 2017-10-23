/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;

/**
 *
 * @author vanta
 */
public class Orders extends javax.swing.JFrame {

    /**
     * Creates new form Orders
     */
    public Orders() {
        initComponents();
        Show();
        Show2();
        initialize();
    }
      public Orders(String z,String y) {     
        initComponents();           
        jLabel5.setText(z); 
        jLabel4.setText(y);
        Show();
        Show2();
     initialize();
    }
    private void initialize(){
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/packing.png")));
    }
      Connection con;
      Statement st;
       public Connection getConnection(){
        
        
        try{
            //con=DriverManager.getConnection("jdbc:mysql:///userdb.userdb2","root","zoot");
           // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb?useUnicode=true&characterEncoding=UTF-8", "root", "zoot");
           // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb2?useUnicode=true&characterEncoding=UTF-8", "root", "zoot");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false","root","zoot");
            return con;
        }catch (Exception e){
        e.printStackTrace();
        return null;
        }
    }
       
       public ArrayList<OrderHandler> getUsersList()
    {
        ArrayList<OrderHandler> productList=new ArrayList<OrderHandler>();
        Connection connection=getConnection();
        String query="SELECT * FROM company.orders;";
        Statement st;
        ResultSet rs;
        try{
            st=connection.createStatement();
            rs=st.executeQuery(query);
            OrderHandler user;
            while(rs.next())
            {
                 user= new OrderHandler(rs.getInt("OrderId"),rs.getString("ProductName"),rs.getString("Quantity"),rs.getString("Supplier"),rs.getString("Employee"),rs.getString("OrderDate"),rs.getString("DateShipping"),rs.getString("DatePromised"),rs.getString("ShippingMethod"),rs.getString("Status"));
                productList.add(user);
            }
            }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
        
    }
       
       public void Show()
    {
        
        ArrayList<OrderHandler> list= getUsersList();
        DefaultTableModel model=(DefaultTableModel)jTable_Orders.getModel();
        Object[] row=new Object[9];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getOid();
            row[1]=list.get(i).getOPName();
            row[2]=list.get(i).getOQuantity();
            row[3]=list.get(i).getOSupplies();
            row[4]=list.get(i).getOEmployee();
            row[5]=list.get(i).getODate();
            row[6]=list.get(i).getODateShipping();
            row[7]=list.get(i).getODatePromised();
            row[8]=list.get(i).getOShippingMethod();
            //model.setRowCount(0);
            model.addRow(row);
           
        }
    }
        public void Show2()
    {
        
        ArrayList<OrderHandler> list= getUsersList();
        DefaultTableModel model2=(DefaultTableModel)jTable_History.getModel();
        Object[] row=new Object[7];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getOid();
            row[1]=list.get(i).getOPName();
            row[2]=list.get(i).getOQuantity();
            row[3]=list.get(i).getODate();
            row[4]=list.get(i).getOEmployee();
            row[5]=list.get(i).getOShippingMethod();
            row[6]=list.get(i).getOStatus();
            
            
            
          // model2.setBackground(Color.red);
            //model.setRowCount(0);
            model2.addRow(row);
            
        }
    }
        
        
        
        
        

        
        
        
        
        
        
      //Statement st;
      public void executeSQLQuery(String query,String message)
    {
        Connection con=getConnection();
        Statement st;
        try{
            st=con.createStatement();
            if(st.executeUpdate(query)==1){
                
                
                DefaultTableModel model2=(DefaultTableModel)jTable_History.getModel();
                model2.setRowCount(0);
                Show2();
                
                JOptionPane.showMessageDialog(null,"Data"+message+"Succesfully");
                
            }else{
                JOptionPane.showMessageDialog(null,"Data Not"+message);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
      
      
      public void executeSQLQuery2(String query,String message)
    {
        Connection con=getConnection();
        Statement st;
        try{
            st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            if(st.executeUpdate(query)==1){
               //JOptionPane.showMessageDialog(null," Data "+message+" Succesfully ");
                //System.out.println("Printed");
           }else{
              //JOptionPane.showMessageDialog(null," Data Not "+message);
          }
       }catch(Exception ex){
           ex.printStackTrace();
        }
    }
      
      
      
      
      
      
      
      
      
      
      
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton_logout2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Orders = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_History = new javax.swing.JTable(){
            //so i can change the color of the Order Status
            //Green for confirmed
            //Red for pending
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                Component cmp = super.prepareRenderer(renderer, row, col);
                Object value = getModel().getValueAt(row, col);
                if (value.equals("Pending..")) {
                    cmp.setBackground(Color.red);
                } else if (value.equals("Confirmed")) {
                    cmp.setBackground(Color.green);
                } else {
                    cmp.setBackground(Color.white);
                }
                return cmp;
            }

        }
        ;
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField_pname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_pid = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jTextField_quant = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("Orders");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/if_Checkmark_1891021.png"))); // NOI18N
        jButton1.setText("Confirm Order");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/New.png"))); // NOI18N
        jButton2.setText("Make a new order..");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Back.png"))); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Current User:");

        jButton_logout2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logout.png"))); // NOI18N
        jButton_logout2.setText("Logout");
        jButton_logout2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_logout2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel4.setText("jLabel4");

        jTable_Orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Product Name", "Quantity", "Supplier", "Employee", "Order Date", "Date Shipping", "Date Promised", "Shipping Method"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Orders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_OrdersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Orders);

        jTabbedPane1.addTab("Orders", jScrollPane2);

        jTable_History.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Product Name", "Quantity", "Date", "Employee", "Shippping Method", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_History.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_HistoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_History);

        jTabbedPane1.addTab("History", jScrollPane1);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/view.png"))); // NOI18N
        jButton4.setText("View Products");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setText("Change Status in order with ID:");

        jTextField_pname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_pnameActionPerformed(evt);
            }
        });

        jLabel7.setText("Product Name:");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refresh.png"))); // NOI18N
        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField_quant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_quantActionPerformed(evt);
            }
        });

        jLabel8.setText("Order Quantity:");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Order.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jButton_logout2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                .addComponent(jSeparator2))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_pid, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_pname, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_quant, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(22, 22, 22))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addGap(13, 13, 13))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton_logout2)
                                        .addComponent(jLabel4))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_pid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_pname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_quant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton1))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jTextField_pname.setEditable(false);
        jTextField_pid.setEditable(false);
        jTextField_pname.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
        String name= jLabel5.getText(); 
        String statval=jLabel4.getText();
        if (statval.equals("Admin")) {
                AdminFFrame cf = new AdminFFrame(name,statval);          //<<<<<<<<<<<<<
                cf.setVisible(true);
                 
             }
        if (!"Admin".equals(statval)) {
            CompanyJF cf = new CompanyJF(name,statval);          //<<<<<<<<<<<<<
            cf.setVisible(true);
             }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton_logout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_logout2ActionPerformed
        // TODO add your handling code here:
     dispose();
     String name= jLabel5.getText();
     String statval=jLabel5.getText();
      logoutAnswer cfs = new logoutAnswer(name,statval);
      cfs.setVisible(true);
    }//GEN-LAST:event_jButton_logout2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int i =jTable_History.getSelectedRow();
        TableModel model=jTable_History.getModel();
        String status= (String) model.getValueAt(i,6);
        //System.out.print(status);
        
      if(!"Confirmed".equals(status)){  
       String query= "UPDATE orders SET Status = 'Confirmed' WHERE OrderId="+Integer.parseInt(jTextField_pid.getText());
       executeSQLQuery(query," Confirmed ");
       //System.out.print("eeeeeeeeeeeeeeeeeeeeeeeeeee");
       String chNameVal=jTextField_pname.getText();
       String chQuantVal=jTextField_quant.getText();
       
       String query3= "UPDATE products SET Quantity = Quantity+"+chQuantVal+" WHERE Name='"+chNameVal+"'";
       executeSQLQuery2(query3," ");
        
       //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String Date=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(now);
        
        String query2= " INSERT INTO logfile(Date_Time,ChangedBy,Action,Value,InWhat) VALUES('"+Date+"','"+jLabel5.getText()+"','"+"Confirmed a new order in ','"+jTextField_pname.getText()+"','Orders'"+ ")";
        //System.out.print(query2);
        executeSQLQuery2(query2,"");
        try{
        st.executeUpdate(query2);
        }
        catch(Exception ex){
            
        }
      }else JOptionPane.showMessageDialog(null,"Order is already Confirmed..");
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String name= jLabel5.getText();
        NewOrder cf = new NewOrder(name);          //<<<<<<<<<<<<<
        cf.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         ViewProducts o = new ViewProducts();    
        o.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField_pnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_pnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_pnameActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         DefaultTableModel model=(DefaultTableModel)jTable_History.getModel();
         DefaultTableModel model2=(DefaultTableModel)jTable_Orders.getModel();
        model.setRowCount(0);
        model2.setRowCount(0);
        Show2();
        Show();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable_HistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_HistoryMouseClicked
        // TODO add your handling code here:
        int i =jTable_History.getSelectedRow();
        TableModel model=jTable_History.getModel();
        jTextField_pname.setText(model.getValueAt(i,1).toString());
        jTextField_pid.setText(model.getValueAt(i,0).toString());
        jTextField_quant.setText(model.getValueAt(i,2).toString());
        
        
        
    }//GEN-LAST:event_jTable_HistoryMouseClicked

    private void jTable_OrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_OrdersMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jTable_OrdersMouseClicked

    private void jTextField_quantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_quantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_quantActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Orders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton_logout2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable_History;
    private javax.swing.JTable jTable_Orders;
    private javax.swing.JTextField jTextField_pid;
    private javax.swing.JTextField jTextField_pname;
    private javax.swing.JTextField jTextField_quant;
    // End of variables declaration//GEN-END:variables
}
