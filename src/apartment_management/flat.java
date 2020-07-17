/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartment_management;

import apartment_management.dbconnection;
import static apartment_management.menu.jLabel7;
import java.awt.Color;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
//import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Admin
 */
public class flat extends javax.swing.JFrame {

    Statement st;
    Connection conn = null;
    PreparedStatement PST = null;
    ResultSet RS = null;

    /**
     * Creates new form flat
     */
    public flat() {
        initComponents();
        showdepth();
        faltno.setVisible(false);
        floor.setVisible(false);
        type.setVisible(false);
        Amount.setVisible(false);
        jButton3.setVisible(false);
        jButton4.setVisible(false);
        jButton5.setVisible(false);
    }
//select all details......

    public ArrayList<flattable> userlist() {
        ArrayList<flattable> userlist = new ArrayList<>();
        try {
            conn = dbconnection.getConnetion();
            String query1 = ("SELECT * FROM flat");
            java.sql.Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(query1);
            flattable flattable;
            while (RS.next()) {
                flattable = new flattable(RS.getString("flatno"), RS.getString("floor"), RS.getString("type"), RS.getString("position"), RS.getString("ownerid"), RS.getString("amount"));
                userlist.add(flattable);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return userlist;
    }

    //select type or flat or floor
    public ArrayList<flattable> userlistflat() {
        ArrayList<flattable> userlistflat = new ArrayList<>();
        if (jComboBox1.getSelectedItem().equals("Type")) {
            try {
                conn = dbconnection.getConnetion();
                String s1 = jTextField5.getText().trim();
                String query1 = ("SELECT * FROM flat where type like '" + s1 + "%'");
                java.sql.Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(query1);
                flattable flattable;
                while (RS.next()) {
                    flattable = new flattable(RS.getString("flatno"), RS.getString("floor"), RS.getString("type"), RS.getString("position"), RS.getString("ownerid"), RS.getString("amount"));
                    userlistflat.add(flattable);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if (jComboBox1.getSelectedItem().equals("Floor")) {
            try {
                conn = dbconnection.getConnetion();
                String s1 = jTextField5.getText().trim();
                String query1 = ("SELECT * FROM flat where floor like '" + s1 + "%'");
                java.sql.Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(query1);
                flattable flattable;
                while (RS.next()) {
                    flattable = new flattable(RS.getString("flatno"), RS.getString("floor"), RS.getString("type"), RS.getString("position"), RS.getString("ownerid"), RS.getString("amount"));
                    userlistflat.add(flattable);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            try {
                conn = dbconnection.getConnetion();
                String s2 = jTextField5.getText().trim();
                String query1 = ("SELECT * FROM flat where flatno like '" + s2 + "%'");
                java.sql.Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(query1);
                flattable flattable;
                while (RS.next()) {
                    flattable = new flattable(RS.getString("flatno"), RS.getString("floor"), RS.getString("type"), RS.getString("position"), RS.getString("ownerid"), RS.getString("amount"));
                    userlistflat.add(flattable);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        return userlistflat;
    }

    //select flat position 
    public ArrayList<flattable> userlistpost() {
        ArrayList<flattable> userlistpost = new ArrayList<>();
        try {
            conn = dbconnection.getConnetion();
            String s2 = jTextField6.getText().trim();
            String query1 = ("SELECT * FROM flat where position like '" + s2 + "%'");
            java.sql.Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(query1);
            flattable flattable;
            while (RS.next()) {
                flattable = new flattable(RS.getString("flatno"), RS.getString("floor"), RS.getString("type"), RS.getString("position"), RS.getString("ownerid"), RS.getString("amount"));
                userlistpost.add(flattable);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return userlistpost;
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
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        faltno = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        floor = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        type = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        Amount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        flatupdate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(66, 98, 167));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(5, 74, 117));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Flat Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(5, 74, 117));
        jPanel2.setLayout(null);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setText("     Flat NO");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextField1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField1MouseMoved(evt);
            }
        });
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField1MouseExited(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField1);
        jTextField1.setBounds(0, 0, 220, 40);

        faltno.setEditable(false);
        faltno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        faltno.setBorder(javax.swing.BorderFactory.createTitledBorder("Flatno"));
        faltno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                faltnoMouseExited(evt);
            }
        });
        faltno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faltnoActionPerformed(evt);
            }
        });
        jPanel2.add(faltno);
        faltno.setBounds(0, 0, 220, 40);

        jPanel3.setBackground(new java.awt.Color(5, 74, 117));
        jPanel3.setLayout(null);

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(153, 153, 153));
        jTextField2.setText("    Floor");
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextField2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField2MouseMoved(evt);
            }
        });
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        jPanel3.add(jTextField2);
        jTextField2.setBounds(0, 0, 220, 40);

        floor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        floor.setBorder(javax.swing.BorderFactory.createTitledBorder("Floor"));
        floor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                floorMouseExited(evt);
            }
        });
        floor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floorActionPerformed(evt);
            }
        });
        floor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                floorKeyTyped(evt);
            }
        });
        jPanel3.add(floor);
        floor.setBounds(0, 0, 220, 40);

        jPanel4.setBackground(new java.awt.Color(5, 74, 117));
        jPanel4.setLayout(null);

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(153, 153, 153));
        jTextField3.setText("    Flat Type");
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextField3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField3MouseMoved(evt);
            }
        });
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField3);
        jTextField3.setBounds(0, 0, 220, 40);

        type.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        type.setBorder(javax.swing.BorderFactory.createTitledBorder("Flat Type"));
        type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                typeMouseExited(evt);
            }
        });
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });
        type.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                typeKeyTyped(evt);
            }
        });
        jPanel4.add(type);
        type.setBounds(0, 0, 210, 40);

        jPanel5.setBackground(new java.awt.Color(5, 74, 117));
        jPanel5.setLayout(null);

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(153, 153, 153));
        jTextField4.setText("    Amount");
        jTextField4.setToolTipText("Type only Numbers");
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextField4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField4MouseMoved(evt);
            }
        });
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });
        jPanel5.add(jTextField4);
        jTextField4.setBounds(0, 0, 220, 40);

        Amount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Amount.setBorder(javax.swing.BorderFactory.createTitledBorder("Amount"));
        Amount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AmountMouseExited(evt);
            }
        });
        Amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmountActionPerformed(evt);
            }
        });
        Amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AmountKeyTyped(evt);
            }
        });
        jPanel5.add(Amount);
        Amount.setBounds(0, 0, 220, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apartment_management/img/save1234.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apartment_management/img/edit-12345.png"))); // NOI18N
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apartment_management/img/Previous1234.png"))); // NOI18N
        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apartment_management/img/clear1234.png"))); // NOI18N
        jButton7.setText("Clear");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(37, 37, 37)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton7)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(3, 57, 91));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel6.setLayout(null);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apartment_management/img/update1234.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3);
        jButton3.setBounds(70, 30, 110, 29);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apartment_management/img/delete1234.png"))); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4);
        jButton4.setBounds(70, 80, 110, 29);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Finish");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton5);
        jButton5.setBounds(70, 130, 110, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apartment_management/img/GrizzledRemoteHornet-small.gif"))); // NOI18N
        jPanel6.add(jLabel2);
        jLabel2.setBounds(0, -10, 220, 220);

        flatupdate.setBackground(new java.awt.Color(5, 74, 117));
        flatupdate.setForeground(new java.awt.Color(5, 74, 117));
        flatupdate.setBorder(null);
        jPanel6.add(flatupdate);
        flatupdate.setBounds(110, 170, 100, 14);

        jLabel3.setText("jLabel3");
        jPanel6.add(jLabel3);
        jLabel3.setBounds(170, 10, 35, 14);

        jTable1.setBackground(new java.awt.Color(5, 74, 117));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flat no", "Floor", "Flat type", "Position", "Amount", "Ownerid"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel9.setBackground(new java.awt.Color(5, 74, 117));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "position", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField6)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(5, 74, 117));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Flat search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Type", "Floor", "Flat NO" }));
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jTextField5.setToolTipText("Type your select index item");
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseMoved
        jTextField1.setVisible(false);
        faltno.setVisible(true);
        try {
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement("select detail from number where no=\"2\"");
            RS = PST.executeQuery();
            while (RS.next()) {
                String did = RS.getString("detail");
                String s = did;
                String va=  s.substring(1, 5);
                int no = Integer.parseInt(va);
                int no1 = no + 1;
                faltno.setText("f" + no1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
    }//GEN-LAST:event_jTextField1MouseMoved

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        faltno.setText("");
        jTextField1.setVisible(false);
        faltno.setVisible(true);
        faltno.requestFocus();
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField1KeyTyped

    private void faltnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faltnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_faltnoActionPerformed

    private void jTextField2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MouseMoved

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        floor.setText("");
        jTextField2.setVisible(false);
        floor.setVisible(true);
        floor.requestFocus();
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyTyped

    private void floorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_floorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_floorActionPerformed

    private void jTextField3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3MouseMoved

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        type.setText("");
        jTextField3.setVisible(false);
        type.setVisible(true);
        type.requestFocus();
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3KeyTyped

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void jTextField4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4MouseMoved

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        Amount.setText("");
        jTextField4.setVisible(false);
        Amount.setVisible(true);
        Amount.requestFocus();
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyTyped

    private void AmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement("update flat set floor=?,type=?,amount=? where flatno=? and position=\"Avaliable\" ");
            PST.setString(1, floor.getText());
            PST.setString(2, type.getText());
            PST.setString(3, Amount.getText());
            PST.setString(4, faltno.getText());
            PST.executeUpdate();

            JOptionPane.showMessageDialog(null, "update sucessfully!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }

        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
        showdepth();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String f1 = faltno.getText();
        String Fl = floor.getText();
        String ty = type.getText();
        String amount = Amount.getText();
        if (f1.equals("")) {
            jTextField1.setBorder(new LineBorder(Color.red, 2));
            JOptionPane.showMessageDialog(null, "What is your flat no?");
        } else if (Fl.equals("")) {
            jTextField2.setBorder(new LineBorder(Color.red, 2));
            JOptionPane.showMessageDialog(null, "What is Floor your flat?");
        } else if (ty.equals("")) {
            jTextField3.setBorder(new LineBorder(Color.red, 2));
            JOptionPane.showMessageDialog(null, "What is the Type of flat?");
        } else if (Fl.equals("")) {
            jTextField4.setBorder(new LineBorder(Color.red, 2));
            JOptionPane.showMessageDialog(null, "What is the amount of flat");
        } else {
            try {
                String query = "INSERT INTO flat(flatno,floor,type,position,amount)values(?,?,?,?,?)";
                conn = dbconnection.getConnetion();
                PST = conn.prepareStatement(query);
                PST.setString(1, f1);
                PST.setString(2, Fl);
                PST.setString(3, ty);
                PST.setString(4, "Avaliable");
                PST.setString(5, amount);
                PST.executeUpdate();
                JOptionPane.showMessageDialog(null, "Insert Successfully");

                DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
                while (dm.getRowCount() > 0) {
                    dm.removeRow(0);
                }
                showdepth();
                comload();
            } catch (SQLException ex) {
                System.err.println(ex);
                JOptionPane.showMessageDialog(null, ex);
            }

            try {
                conn = dbconnection.getConnetion();
                PST = conn.prepareStatement(" update number set detail=? where no=\"2\";");
                PST.setString(1, faltno.getText());

                PST.executeUpdate();

                JOptionPane.showMessageDialog(null, "update sucessfully!!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            jButton2.requestFocus();
            jTextField4.setVisible(true);
            jTextField1.setVisible(true);
            jTextField2.setVisible(true);
            jTextField3.setVisible(true);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked


    }//GEN-LAST:event_jPanel1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jLabel2.setVisible(false);
        jButton3.setVisible(true);
        jButton4.setVisible(true);
        jButton5.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        jTextField4.setVisible(false);
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        jTextField3.setVisible(false);
        faltno.setVisible(true);
        floor.setVisible(true);
        type.setVisible(true);
        Amount.setVisible(true);
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int selectedRowIndex = jTable1.getSelectedRow();
            faltno.setText(model.getValueAt(selectedRowIndex, 0).toString());
            floor.setText(model.getValueAt(selectedRowIndex, 1).toString());
            type.setText(model.getValueAt(selectedRowIndex, 2).toString());
            Amount.setText(model.getValueAt(selectedRowIndex, 4).toString());
//            jComboBox1.setSelectedItem(model.getValueAt(selectedRowIndex, 0).toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int obj = JOptionPane.showConfirmDialog(null, "Are you sure delete this one?", "Delete", JOptionPane.YES_NO_OPTION);
        if (obj == 0) {
            try {
                conn = dbconnection.getConnetion();
                PST = conn.prepareStatement("select position from flat where flatno=?");
                PST.setString(1, faltno.getText());
                RS = PST.executeQuery();
                if (RS.next()) {
                    String did = RS.getString("position");
                    if (did.equals("Avaliable")) {
                        try {
                            conn = dbconnection.getConnetion();
                            PST = conn.prepareStatement(" delete from flat where flatno=?");
                            PST.setString(1, faltno.getText());

                            PST.executeUpdate();

                            JOptionPane.showMessageDialog(null, "delete success");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex);

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "unable to delete this flat");
                    }
                }

            } catch (SQLException e) {
            }

            DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
            while (dm.getRowCount() > 0) {
                dm.removeRow(0);
            }
            showdepth();
            comload();

            jTextField4.setVisible(true);
            jTextField1.setVisible(true);
            jTextField2.setVisible(true);
            jTextField3.setVisible(true);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseExited

    }//GEN-LAST:event_jTextField1MouseExited

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jLabel2.setVisible(true);
        jButton3.setVisible(false);
        jButton4.setVisible(false);
        jButton5.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void faltnoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faltnoMouseExited
        if (faltno.getText().equals("")) {
            jTextField1.setVisible(true);
            faltno.setVisible(false);
        } else {
            jTextField1.setVisible(false);
            faltno.setVisible(true);
        }
    }//GEN-LAST:event_faltnoMouseExited

    private void typeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_typeMouseExited
        if (type.getText().equals("")) {
            jTextField3.setVisible(true);
            type.setVisible(false);
        } else {
            jTextField3.setVisible(false);
            type.setVisible(true);
        }
    }//GEN-LAST:event_typeMouseExited

    private void floorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_floorMouseExited
        if (floor.getText().equals("")) {
            jTextField2.setVisible(true);
            floor.setVisible(false);
        } else {
            jTextField2.setVisible(false);
            floor.setVisible(true);
        }
    }//GEN-LAST:event_floorMouseExited

    private void AmountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AmountMouseExited
        if (Amount.getText().equals("")) {
            jTextField4.setVisible(true);
            Amount.setVisible(false);
        } else {
            jTextField4.setVisible(false);
            Amount.setVisible(true);
        }
    }//GEN-LAST:event_AmountMouseExited

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
        menu m = new menu();
        m.setVisible(true);
        m.jLabel7.setText(flatupdate.getText());
        m.jLabel5.setText(jLabel3.getText());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void floorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_floorKeyTyped
        String phone = floor.getText();
        int length = phone.length();
        char c = evt.getKeyChar();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (length < 3) {
                floor.setEditable(true);
            } else {
                floor.setEditable(false);
            }
        } else {
            if ((Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_G)) {
                floor.setEditable(true);

            } else {
                floor.setEditable(false);
            }
        }
    }//GEN-LAST:event_floorKeyTyped

    private void typeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_typeKeyTyped
        if (type.getText().length() >= 6) {
            evt.consume();
        }
    }//GEN-LAST:event_typeKeyTyped

    private void AmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmountKeyTyped
        String phone = Amount.getText();
        int length = phone.length();
        char c = evt.getKeyChar();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (length < 20) {
                Amount.setEditable(true);
            } else {
                Amount.setEditable(false);
            }
        } else {
            if ((Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                Amount.setEditable(true);

            } else {
                Amount.setEditable(false);
            }
        }
    }//GEN-LAST:event_AmountKeyTyped

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jButton2.requestFocus();
        jTextField4.setVisible(true);
        jTextField1.setVisible(true);
        jTextField2.setVisible(true);
        jTextField3.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
        showdepthfloor();
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
        showdepthpost();
    }//GEN-LAST:event_jTextField6KeyReleased

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
            java.util.logging.Logger.getLogger(flat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(flat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(flat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(flat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new flat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Amount;
    private javax.swing.JTextField faltno;
    public static javax.swing.JTextField flatupdate;
    private javax.swing.JTextField floor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField type;
    // End of variables declaration//GEN-END:variables

    private void showdepth() {
        ArrayList<flattable> list = userlist();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[6];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getflatno();
            row[1] = list.get(i).getfloor();
            row[2] = list.get(i).getflattype();
            row[3] = list.get(i).getposition();
            row[4] = list.get(i).getamount();
            row[5] = list.get(i).getownerid();

            model.addRow(row);
        }
    }

    private void comload() {
//        try {
//            conn = dbconnection.getConnetion();
//            PST = conn.prepareStatement("select flatno from flat ");
//            RS = PST.executeQuery();
//            while (RS.next()) {
//                String did = RS.getString("flatno");
//                jComboBox1.addItem(did);
//                jComboBox1.setSelectedItem("");
//                // AutoCompleteDecorator.decorate(jComboBox1);
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//
//        }
    }

    private void showdepthfloor() {
        ArrayList<flattable> list = userlistflat();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[6];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getflatno();
            row[1] = list.get(i).getfloor();
            row[2] = list.get(i).getflattype();
            row[3] = list.get(i).getposition();
            row[4] = list.get(i).getamount();
            row[5] = list.get(i).getownerid();

            model.addRow(row);
        }
    }

    private void showdepthpost() {
        ArrayList<flattable> list = userlistpost();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[6];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getflatno();
            row[1] = list.get(i).getfloor();
            row[2] = list.get(i).getflattype();
            row[3] = list.get(i).getposition();
            row[4] = list.get(i).getamount();
            row[5] = list.get(i).getownerid();

            model.addRow(row);
        }
    }
}
