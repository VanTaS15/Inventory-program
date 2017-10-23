/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author vanta
 */
public class SuplierList extends javax.swing.JFrame {

    /**
     * Creates new form SuplierList
     */
    public SuplierList() {
        initComponents();
        Show();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    initialize();
    }
    
    public SuplierList(String z) {
        initComponents();
        jLabel11.setText(z); 
        Show();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    
    public ArrayList<SupplierHandler> getUsersList()
    {
        ArrayList<SupplierHandler> productList=new ArrayList<SupplierHandler>();
        Connection connection=getConnection();
        String query="SELECT * FROM company.suppliers;";
        Statement st;
        ResultSet rs;
        try{
            st=connection.createStatement();
            rs=st.executeQuery(query);
            SupplierHandler user;
            while(rs.next())
            {
                 user= new SupplierHandler(rs.getInt("Id"),rs.getString("SupplierName"),rs.getString("Address"),rs.getString("City"),rs.getString("PostalCode"),rs.getString("Country"),rs.getString("Phone"),rs.getString("Email"));
                productList.add(user);
            }
            }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
        
    }
    
    public void Show()
    {
        
        ArrayList<SupplierHandler> list= getUsersList();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        Object[] row=new Object[8];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getSId();
            row[1]=list.get(i).getSName();
            row[2]=list.get(i).getSAddress();
            row[3]=list.get(i).getSCity();
            row[4]=list.get(i).getsPostalcode();
            row[5]=list.get(i).getSCountry();
            row[6]=list.get(i).getSPhone();
            row[7]=list.get(i).getSEmail();
            //model.setRowCount(0);
            model.addRow(row);
            
        }
    }
    
     //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/search/aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
    public ArrayList<SupplierHandler> getSearchList(String value)
    {
        ArrayList<SupplierHandler> productList=new ArrayList<SupplierHandler>();
        Connection connection=getConnection();
        String query="SELECT * FROM company.suppliers WHERE "+value+"='"+jTextField1.getText()+"'";
        Statement st;
        ResultSet rs;
        try{
            st=connection.createStatement();
            rs=st.executeQuery(query);
            SupplierHandler user;
            while(rs.next())
            {
               user= new SupplierHandler(rs.getInt("Id"),rs.getString("SupplierName"),rs.getString("Address"),rs.getString("City"),rs.getString("PostalCode"),rs.getString("Country"),rs.getString("Phone"),rs.getString("Email"));
                productList.add(user);
            }
            
            
            
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
        
    }
    
    
    public void getSearchedValue()
    {
        String value=(String)jComboBox1.getSelectedItem();
        
        ArrayList<SupplierHandler> searchedlist= getSearchList(value);
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        Object[] row=new Object[8];
        for(int i=0;i<searchedlist.size();i++){
            row[0]=searchedlist.get(i).getSId();
            row[1]=searchedlist.get(i).getSName();
            row[2]=searchedlist.get(i).getSAddress();
            row[3]=searchedlist.get(i).getSCity();
            row[4]=searchedlist.get(i).getsPostalcode();
            row[5]=searchedlist.get(i).getSCountry();
            row[6]=searchedlist.get(i).getSPhone();
            row[7]=searchedlist.get(i).getSEmail();
            
            
            model.setRowCount(0);
            model.addRow(row);
            
        }
    }
    
    
    
    
    
    
    
    //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/search/aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
    
    
    public void executeSQLQuery(String query,String message)
    {
        Connection con=getConnection();
        Statement st;
        try{
            st=con.createStatement();
            if(st.executeUpdate(query)==1){
                
                
                DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
                model.setRowCount(0);
                Show();
                
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField_sname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_saddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_scity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_spcode = new javax.swing.JTextField();
        jTextField_sphone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_scountry = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField_semail = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField_sid = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        jLabel1.setText("Supplier List");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Supplier Name", "Address", "City", "Postal Code", "Country", "Phone", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add.png"))); // NOI18N
        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png"))); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Update.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel2.setText("Supplier Name:");

        jLabel3.setText("Address:");

        jLabel4.setText("City:");

        jLabel5.setText("Country:");

        jLabel6.setText("Postal Code:");

        jLabel7.setText("Phone:");

        jLabel8.setText("E-mail:");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refresh.png"))); // NOI18N
        jButton4.setText("Refresh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setText("Search with:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "SupplierName", "Address", "City", "PostalCode", "Country", "Phone", "E-mail" }));

        jButton5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel10.setText("Id:");

        jLabel11.setText("jLabel9");

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel12.setText("Current User:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_scity, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_saddress, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_sname, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_sid, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_spcode)
                            .addComponent(jTextField_sphone)
                            .addComponent(jTextField_scountry)
                            .addComponent(jTextField_semail))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_spcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jTextField_sid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_scountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_sname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_sphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_saddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField_semail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_scity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        jTextField_sid.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String query= "UPDATE suppliers SET SupplierName='"+jTextField_sname.getText()+"',Address='"+jTextField_saddress.getText()+"',City='"+jTextField_scity.getText()+"',PostalCode='"+jTextField_spcode.getText()+"',Country='"+jTextField_scountry.getText()+"',Phone='"+jTextField_sphone.getText()+"',Employee='"+jLabel11.getText()+"'WHERE Id="+jTextField_sid.getText();
        System.out.print(query);
        executeSQLQuery(query," Updated ");
        
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String Date=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(now);
        String query2= " INSERT INTO logfile(Date_Time,ChangedBy,Action,Value,InWhat) VALUES('"+Date+"','"+jLabel11.getText()+"','"+"Updated the supplier List in ',' " +jTextField_sname.getText()+"','Suppliers List'"+ ")";
        //System.out.print(query2);
        executeSQLQuery2(query2,"");
        try{
        st.executeUpdate(query2);
        }
        catch(Exception ex){
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int i =jTable1.getSelectedRow();
        TableModel model=jTable1.getModel();
        jTextField_sid.setText(model.getValueAt(i,0).toString());
        jTextField_sname.setText(model.getValueAt(i,1).toString());
        jTextField_saddress.setText(model.getValueAt(i,2).toString());
        jTextField_scity.setText(model.getValueAt(i,3).toString());
        jTextField_spcode.setText(model.getValueAt(i,4).toString());
        jTextField_scountry.setText(model.getValueAt(i,5).toString());
        jTextField_sphone.setText(model.getValueAt(i,6).toString());
        jTextField_semail.setText(model.getValueAt(i,7).toString());
        
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
        Show();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        getSearchedValue();
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String Date=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(now);
        String query2= " INSERT INTO logfile(Date_Time,ChangedBy,Action,Value,InWhat) VALUES('"+Date+"','"+jLabel11.getText()+"','"+"Inserted A supplier in ',' " +jTextField_sname.getText()+"','Suppliers List'"+ ")";
        //System.out.print(query2);
        executeSQLQuery2(query2,"");
        try{
        st.executeUpdate(query2);
        }
        catch(Exception ex){
            
        }
        
        
        
        String query= " INSERT INTO suppliers(SupplierName,Address,City,PostalCode,Country,Phone,Email,Employee) VALUES('"+jTextField_sname.getText()+"','"+jTextField_saddress.getText()+"','"+jTextField_scity.getText()+"','"+jTextField_spcode.getText()+"','"+jTextField_scountry.getText()+"','"+jTextField_sphone.getText()+"','"+jTextField_semail.getText()+"','"+jLabel11.getText()+"' )";
        executeSQLQuery(query," Inserted ");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String query="DELETE FROM suppliers WHERE Id="+jTextField_sid.getText();
        executeSQLQuery(query," Deleted ");
        
        
       //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String Date=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(now);
        String query2= " INSERT INTO logfile(Date_Time,ChangedBy,Action,Value,InWhat) VALUES('"+Date+"','"+jLabel11.getText()+"','"+"Deleted A supplier in ',' " +jTextField_sname.getText()+"','Suppliers List'"+ ")";
        //System.out.print(query2);
        executeSQLQuery2(query2,"");
        try{
        st.executeUpdate(query2);
        }
        catch(Exception ex){
            
        }
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(SuplierList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuplierList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuplierList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuplierList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuplierList().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField_saddress;
    private javax.swing.JTextField jTextField_scity;
    private javax.swing.JTextField jTextField_scountry;
    private javax.swing.JTextField jTextField_semail;
    private javax.swing.JTextField jTextField_sid;
    private javax.swing.JTextField jTextField_sname;
    private javax.swing.JTextField jTextField_spcode;
    private javax.swing.JTextField jTextField_sphone;
    // End of variables declaration//GEN-END:variables
}
