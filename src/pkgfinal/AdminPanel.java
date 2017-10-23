/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static javax.management.Query.value;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author vanta
 */
public class AdminPanel extends javax.swing.JFrame {

    /**
     * Creates new form AdminPanel2
     */
    public AdminPanel() {
        initComponents();
        Show();
        Show2();
        initialize();
    }
    
    
    public AdminPanel(String z,String y){         
        initComponents();               
       jLabel4.setText(z);
       jLabel5.setText(y);
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
    
    public ArrayList<UserHandler> getUsersList()
    {
        ArrayList<UserHandler> productList=new ArrayList<UserHandler>();
        Connection connection=getConnection();
        String query="SELECT * FROM company.users;";
        Statement st;
        ResultSet rs;
        try{
            st=connection.createStatement();
            rs=st.executeQuery(query);
            UserHandler user;
            while(rs.next())
            {
               
                user= new UserHandler(rs.getInt("Id"),rs.getString("Username"),rs.getString("Password"),rs.getString("Status"),rs.getString("First_Last_Name"),rs.getString("ContactPhone"),rs.getString("Email"));
                productList.add(user);
            }
            
            
            
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
        
    }
    public void Show()
    {
        
        ArrayList<UserHandler> list= getUsersList();
        DefaultTableModel model=(DefaultTableModel)jTable_users.getModel();
        Object[] row=new Object[7];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getId();
            row[1]=list.get(i).getUsername();
            row[2]=list.get(i).getPassword();
            row[3]=list.get(i).getStatus();
            row[4]=list.get(i).getFirst_Last_Name();
            row[5]=list.get(i).getContactPhone();
            row[6]=list.get(i).getEmail();
            
            //model.setRowCount(0);
            model.addRow(row);
            
        }
    }
    //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasearchaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
    
    public ArrayList<UserHandler> getSearchList(String valuex)
    {
        String value=(String)jComboBox1.getSelectedItem();
        ArrayList<UserHandler> userList=new ArrayList<UserHandler>();
        Connection connection=getConnection();
        String query="SELECT * FROM company.users WHERE "+value+"='"+jTextField_search.getText()+"'";
        
        Statement st;
        ResultSet rs;
        try{
            st=connection.createStatement();
            rs=st.executeQuery(query);
            UserHandler user;
            while(rs.next())
            {
                user= new UserHandler(rs.getInt("Id"),rs.getString("Username"),rs.getString("Password"),rs.getString("Status"),rs.getString("First_Last_Name"),rs.getString("ContactPhone"),rs.getString("Email"));
                userList.add(user);
            }
            
            
            
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return userList;
        
    }
    
    public void getSearchedValue()
    {
        //String value=(String)jComboBox1.getSelectedItem();
        
        
        ArrayList<UserHandler> list= getSearchList(jTextField_search.getText());
        DefaultTableModel model2=(DefaultTableModel)jTable_users.getModel();
        model2.setRowCount(0);//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        Object[] row=new Object[7];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getId();
            row[1]=list.get(i).getUsername();
            row[2]=list.get(i).getPassword();
            row[3]=list.get(i).getStatus();
            row[4]=list.get(i).getFirst_Last_Name();
            row[5]=list.get(i).getContactPhone();
            row[6]=list.get(i).getEmail();
                
           
            
            model2.addRow(row);
            
        }
        
    }
    
    
    //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasearchaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
    public void executeSQLQuery(String query,String message)
    {
        Connection con=getConnection();
        Statement st;
        try{
            st=con.createStatement();
            if(st.executeUpdate(query)==1){
                
                
                DefaultTableModel model=(DefaultTableModel)jTable_users.getModel();
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
    
    
     public ArrayList<LogFileHandler> getLogList()
    {
       // String value=(String)jComboBox1.getSelectedItem();
        ArrayList<LogFileHandler> userList=new ArrayList<LogFileHandler>();
        Connection connection=getConnection();
        String query="SELECT * FROM logfile ";
        //System.out.print(query);
        Statement st;
        ResultSet rs;
        
        try{
            st=connection.createStatement();
            rs=st.executeQuery(query);
            LogFileHandler user;
            while(rs.next())
            {
                user= new LogFileHandler(rs.getInt("Id"),rs.getString("Date_Time"),rs.getString("ChangedBy"),rs.getString("Action"),rs.getString("Value"),rs.getString("InWhat"));
                userList.add(user);
                
                String id = rs.getString("id");
                String date = rs.getString("Date_Time");
                String cBy= rs.getString("ChangedBy");
                String aC= rs.getString("Action");
                String vA= rs.getString("Value");
                String iW=rs.getString("InWhat");
                
                //System.out.print(vA+"eeeee");
                
                
                //jTextArea1.append("This is a test "+id+" with username= "+aC+"\n");
               if(" ".equals(vA)) { 
                   jTextArea1.append(date+" --------------------------------------------------------------------------------------------------------------------| "+cBy+" "+aC+"|--------------------------------------------------------------------------------------------------------------------"+"\n");
                 
                  

               } else {
                   jTextArea1.append("Date/Time: |"+date+"|>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+cBy+" "+aC+" "+iW+" With Name: "+vA+"\n");
                   
                }

                    //jTextArea1.append(cBy+" "+aC+" "+"\n");
                   // continue;
               //}else if(!"Logged In".equals(aC)||!"Logged Out".equals(aC)) 
               // jTextArea1.append("ID:"+id+"----------Date/Time: |"+date+"|>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+cBy+" "+aC+" "+iW+" With Value: "+vA+"\n");
               
                
            }
            
            
            
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return userList;
        
    }
    
     public void Show2()
    {
        
        ArrayList<LogFileHandler> list= getLogList();
        DefaultTableModel model=(DefaultTableModel)jTable_logfile.getModel();
        Object[] row=new Object[6];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getId();
            row[1]=list.get(i).getDate_time();
            row[2]=list.get(i).getChangedBy();
            row[3]=list.get(i).getAction();
            row[4]=list.get(i).getValue();
            row[5]=list.get(i).getInWhat();
            
            
            //model.setRowCount(0);
            model.addRow(row);
            
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
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton_addUser = new javax.swing.JButton();
        jButton_deleteUser = new javax.swing.JButton();
        jButton_refresh = new javax.swing.JButton();
        jButton_editUser = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField_search = new javax.swing.JTextField();
        jButton_search = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton_logout = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField_id = new javax.swing.JTextField();
        jTextField_username = new javax.swing.JTextField();
        jTextField_pass = new javax.swing.JTextField();
        jTextField_email = new javax.swing.JTextField();
        jTextField_phone = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField_flname = new javax.swing.JTextField();
        jTabbedPane_log = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_users = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_logfile = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Back.png"))); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("Admin Panel");

        jButton_addUser.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton_addUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add.png"))); // NOI18N
        jButton_addUser.setText("Add User");
        jButton_addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addUserActionPerformed(evt);
            }
        });

        jButton_deleteUser.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton_deleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png"))); // NOI18N
        jButton_deleteUser.setText("Delete User");
        jButton_deleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteUserActionPerformed(evt);
            }
        });

        jButton_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refresh.png"))); // NOI18N
        jButton_refresh.setText("Refresh");
        jButton_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_refreshActionPerformed(evt);
            }
        });

        jButton_editUser.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton_editUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/if_write_126582.png"))); // NOI18N
        jButton_editUser.setText("Edit User");
        jButton_editUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_editUserActionPerformed(evt);
            }
        });

        jLabel2.setText("Search With:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Username", "Status" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        jButton_search.setText("Search");
        jButton_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_searchActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Current User:");

        jButton_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logout.png"))); // NOI18N
        jButton_logout.setText("Logout");
        jButton_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_logoutActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel5.setText("jLabel5");

        jLabel6.setText("Username:");

        jLabel7.setText("Password:");

        jLabel8.setText("Status:");

        jLabel9.setText("Phone:");

        jLabel10.setText("Email:");

        jLabel11.setText("Id:");

        jTextField_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_idMouseClicked(evt);
            }
        });

        jTextField_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_usernameActionPerformed(evt);
            }
        });

        jTextField_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_passActionPerformed(evt);
            }
        });

        jTextField_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_phoneActionPerformed(evt);
            }
        });

        jLabel12.setText("First/Last Name:");

        jTable_users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Username", "Password", "Status", "First/Last Name", "Contact Phone", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_usersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_users);

        jTabbedPane_log.addTab("Users", jScrollPane1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);
        jTextArea1.setEditable(false);

        jTabbedPane_log.addTab("Log File", jScrollPane2);

        jTable_logfile.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Date & Time", "Changed By", "Action", "Value", "In What"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable_logfile);

        jTabbedPane_log.addTab("Log File(At length)", jScrollPane3);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Admin.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton_addUser, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_deleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jButton_editUser, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(559, 559, 559)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_search)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton_search, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton_refresh))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTabbedPane_log, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jButton_logout))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(790, 790, 790)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_flname, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton_logout)
                                        .addComponent(jLabel5))
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_addUser, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_deleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel11)
                        .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_refresh)
                            .addComponent(jButton_search)
                            .addComponent(jTextField_flname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton_editUser, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane_log, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTextField_id.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jButton_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_logoutActionPerformed
        // TODO add your handling code here:
        dispose();
        String name= jLabel4.getText();
        String statval=jLabel5.getText();
        logoutAnswer cfs = new logoutAnswer(name,statval);
        cfs.setVisible(true);
    }//GEN-LAST:event_jButton_logoutActionPerformed

    private void jButton_addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addUserActionPerformed
        // TODO add your handling code here:
        String pname=jLabel4.getText();
        AddUser cfs = new AddUser(pname);          //<<<<<<<<<<<<<
        cfs.setVisible(true);
        
        
        
        
    }//GEN-LAST:event_jButton_addUserActionPerformed

    private void jButton_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_searchActionPerformed
        // TODO add your handling code here:
       getSearchedValue();
    }//GEN-LAST:event_jButton_searchActionPerformed

    private void jButton_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_refreshActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model=(DefaultTableModel)jTable_users.getModel();
        model.setRowCount(0);
        Show();
    }//GEN-LAST:event_jButton_refreshActionPerformed

    private void jTextField_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_passActionPerformed

    private void jTextField_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_phoneActionPerformed

    private void jTextField_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_idMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_idMouseClicked

    private void jTable_usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_usersMouseClicked
        // TODO add your handling code here:
        int i =jTable_users.getSelectedRow();
        TableModel model=jTable_users.getModel();
        jTextField_id.setText(model.getValueAt(i,0).toString());
        jTextField_username.setText(model.getValueAt(i,1).toString());
        jTextField_pass.setText(model.getValueAt(i,2).toString());
       // jTextField_status.setText(model.getValueAt(i,3).toString());
        
        jTextField_flname.setText(model.getValueAt(i,4).toString());
        jTextField_phone.setText(model.getValueAt(i,5).toString());
        jTextField_email.setText(model.getValueAt(i,6).toString());
        
        
         //String valuess=(String)jComboBox2.getSelectedItem();
         //System.out.print(model.getValueAt(i,3).toString());
         
        String valuess=model.getValueAt(i,3).toString();
        if("Admin".equals(valuess))
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {valuess,"User"}));
        if("User".equals(valuess))
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {valuess,"Admin"}));
    }//GEN-LAST:event_jTable_usersMouseClicked

    private void jButton_editUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_editUserActionPerformed
        // TODO add your handling code here:
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
         
        LocalDateTime now = LocalDateTime.now();
        String Date=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(now);
        String status=(String)jComboBox2.getSelectedItem();
        String query2= " INSERT INTO logfile(Date_Time,ChangedBy,Action,Value,InWhat) VALUES('"+Date+"','"+jLabel4.getText()+"','"+"Updated a user in ','"+jTextField_username.getText()+"','Users'"+ ")";
        //System.out.print(query2);
        executeSQLQuery2(query2,"");
        try{
        st.executeUpdate(query2);
        }
        catch(Exception ex){
            
        }
        
        String query= "UPDATE users SET Username='"+jTextField_username.getText()+"',Password='"+jTextField_pass.getText()+"',Status='"+status+"',ContactPhone='"+jTextField_phone.getText()+"',Email='"+jTextField_email.getText()+"'WHERE Id="+jTextField_id.getText();
        
        executeSQLQuery(query," Updated ");
    }//GEN-LAST:event_jButton_editUserActionPerformed

    private void jButton_deleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteUserActionPerformed
        // TODO add your handling code here:
        
        String query="DELETE FROM users WHERE Id="+jTextField_id.getText();
        executeSQLQuery(query," Deleted ");
        
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String Date=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(now);
        
        String query2= " INSERT INTO logfile(Date_Time,ChangedBy,Action,Value,InWhat) VALUES('"+Date+"','"+jLabel4.getText()+"','"+"Deleted a user in ','"+jTextField_username.getText()+"','Users'"+ ")";
        //System.out.print(query2);
        executeSQLQuery2(query2,"");
        try{
        st.executeUpdate(query2);
        }
        catch(Exception ex){
            
        }
        
    }//GEN-LAST:event_jButton_deleteUserActionPerformed

    private void jTextField_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_usernameActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPanel().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton_addUser;
    private javax.swing.JButton jButton_deleteUser;
    private javax.swing.JButton jButton_editUser;
    private javax.swing.JButton jButton_logout;
    private javax.swing.JButton jButton_refresh;
    private javax.swing.JButton jButton_search;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane_log;
    private javax.swing.JTable jTable_logfile;
    private javax.swing.JTable jTable_users;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_flname;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_pass;
    private javax.swing.JTextField jTextField_phone;
    private javax.swing.JTextField jTextField_search;
    private javax.swing.JTextField jTextField_username;
    // End of variables declaration//GEN-END:variables
}
