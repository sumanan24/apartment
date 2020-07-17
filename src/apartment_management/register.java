/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartment_management;

import static apartment_management.bill.jTable2;
import static apartment_management.bill.total;
import apartment_management.menu;
import java.awt.Color;
import com.mysql.cj.xdevapi.Statement;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Admin
 */
public class register extends javax.swing.JFrame {

//    private int to;
//    private int bal;
    public String F;
    public String A;
    public String org;
    public String fl;
    String na = null;
    Statement st;
    Connection conn = null;
    PreparedStatement PST = null;
    ResultSet RS = null;
    JFileChooser fileChooser = null;
    FileNameExtensionFilter filter = null;
    ByteArrayOutputStream img;
    BufferedImage im;
    String filename = null;
    byte[] person_image;
    DefaultListModel Model = new DefaultListModel();

    /**
     * Creates new form register
     */
    public register() {
        initComponents();
        this.setDefaultCloseOperation(register.DISPOSE_ON_CLOSE);
        delete.setVisible(false);
        update.setVisible(false);
        jList1.setVisible(false);
        jScrollPane2.setVisible(false);
        showdate();
        jComboBox2.setEnabled(false);
        jComboBox3.setEnabled(false);
        visible();
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
        comloadtype();
        //comloadowner();
        showdepth();
        new Thread() {

            @Override
            public void run() {
                while (true) {
                    Date dNow = new Date();

                    SimpleDateFormat bn = new SimpleDateFormat("E hh:mm:ss a");
                    String time1 = "" + bn.format(dNow);

                    jLabel6.setText(time1);
                }
            }

        }.start();
    }

// all details show table.....
    public ArrayList<ownertable> userlist() {
        ArrayList<ownertable> userlist = new ArrayList<>();
        try {
            conn = dbconnection.getConnetion();
            String query1 = ("SELECT * FROM flatowner");
            java.sql.Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(query1);
            ownertable ownertable;
            while (RS.next()) {
                ownertable = new ownertable(RS.getString("name"), RS.getString("ownerid"), RS.getString("vechiletype"), RS.getString("vechile_model"), RS.getString("no_of_vechile"), RS.getString("gender"), RS.getString("phone"), RS.getString("email"), RS.getString("Vechile_no"), RS.getString("Nic"));
                userlist.add(ownertable);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return userlist;
    }

    //ownerid search....
    public ArrayList<ownertable> userlist1() {
        ArrayList<ownertable> userlist1 = new ArrayList<>();
        try {
            conn = dbconnection.getConnetion();
            String s1 = ow.getText().trim();
            String query1 = ("SELECT * FROM flatowner where ownerid like '" + s1 + "%' or name like '" + s1 + "%'or vechiletype like '" + s1 + "%' or vechile_model like '" + s1 + "%' or no_of_vechile like '" + s1 + "%' or gender like '" + s1 + "%' or phone like '" + s1 + "%' or email like '" + s1 + "%' or Vechile_no like '" + s1 + "%' or NIC like '" + s1 + "%'");
            java.sql.Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(query1);
            ownertable ownertable;
            while (RS.next()) {
                ownertable = new ownertable(RS.getString("name"), RS.getString("ownerid"), RS.getString("vechiletype"), RS.getString("vechile_model"), RS.getString("no_of_vechile"), RS.getString("gender"), RS.getString("phone"), RS.getString("email"), RS.getString("Vechile_no"), RS.getString("Nic"));
                userlist1.add(ownertable);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return userlist1;
    }

    //owner name search
//    public ArrayList<ownertable> userlistname() {
//        ArrayList<ownertable> userlistname = new ArrayList<>();
//        try {
//            conn = dbconnection.getConnetion();
//            String s1 = jTextField8.getText().trim();
//            String query1 = ("SELECT * FROM flatowner where name like '" + s1 + "%'");
//            java.sql.Statement st = conn.createStatement();
//            ResultSet RS = st.executeQuery(query1);
//            ownertable ownertable;
//            while (RS.next()) {
//                ownertable = new ownertable(RS.getString("name"), RS.getString("ownerid"), RS.getString("vechiletype"), RS.getString("vechile_model"), RS.getString("no_of_vechile"), RS.getString("gender"), RS.getString("phone"), RS.getString("email"), RS.getString("Vechile_no"), RS.getString("Nic"));
//                userlistname.add(ownertable);
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//        return userlistname;
//    }
    public ArrayList<billtable> userlistbill() {
        ArrayList<billtable> userlist = new ArrayList<>();
        try {
            register r = new register();
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement("select * from bill where billno=?");
            PST.setString(1, fl);

            RS = PST.executeQuery();
            billtable billtable;
            while (RS.next()) {
                billtable = new billtable(RS.getString("details"), RS.getString("amount"));
                userlist.add(billtable);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return userlist;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        mail1 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jTextField9 = new javax.swing.JTextField();
        nic = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        oi = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        mob = new javax.swing.JTextField();
        male = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        female = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jTextField12 = new javax.swing.JTextField();
        VechileNO = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jTextField13 = new javax.swing.JTextField();
        noofvechile = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jTextField14 = new javax.swing.JTextField();
        vechiletype = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jTextField11 = new javax.swing.JTextField();
        vechilemodel = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        regisaddmin = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        ow = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setLayout(null);

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(255, 255, 255));
        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(204, 204, 204));
        jTextField6.setText("    Email");
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField6MouseMoved(evt);
            }
        });
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });
        jPanel9.add(jTextField6);
        jTextField6.setBounds(0, 0, 269, 40);

        mail1.setBorder(javax.swing.BorderFactory.createTitledBorder("username"));
        mail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mail1ActionPerformed(evt);
            }
        });
        jPanel9.add(mail1);
        mail1.setBounds(0, 0, 270, 40);

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register form");
        setResizable(false);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(5, 74, 117));

        jPanel5.setBackground(new java.awt.Color(5, 74, 117));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Vani", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(5, 74, 117));
        jPanel6.setLayout(null);

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(102, 102, 102));
        jTextField3.setText("    Full name");
        jTextField3.setBorder(null);
        jTextField3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField3MouseMoved(evt);
            }
        });
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
        });
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextField3MouseReleased(evt);
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
        jPanel6.add(jTextField3);
        jTextField3.setBounds(0, 0, 290, 40);

        name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        name.setBorder(javax.swing.BorderFactory.createTitledBorder("Fullname"));
        name.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                nameMouseMoved(evt);
            }
        });
        name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameFocusGained(evt);
            }
        });
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nameMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nameMouseReleased(evt);
            }
        });
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKeyTyped(evt);
            }
        });
        jPanel6.add(name);
        name.setBounds(0, 0, 290, 40);

        jPanel8.setBackground(new java.awt.Color(5, 74, 117));
        jPanel8.setLayout(null);

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(102, 102, 102));
        jTextField5.setText("    Email");
        jTextField5.setBorder(null);
        jTextField5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField5MouseMoved(evt);
            }
        });
        jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField5FocusGained(evt);
            }
        });
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        jPanel8.add(jTextField5);
        jTextField5.setBounds(0, 0, 290, 40);

        mail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mail.setBorder(javax.swing.BorderFactory.createTitledBorder("Email"));
        mail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mailFocusGained(evt);
            }
        });
        mail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mailMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mailMouseReleased(evt);
            }
        });
        mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailActionPerformed(evt);
            }
        });
        mail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mailKeyTyped(evt);
            }
        });
        jPanel8.add(mail);
        mail.setBounds(0, 0, 290, 40);

        jPanel12.setBackground(new java.awt.Color(5, 74, 117));
        jPanel12.setLayout(null);

        jTextField9.setEditable(false);
        jTextField9.setBackground(new java.awt.Color(255, 255, 255));
        jTextField9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(102, 102, 102));
        jTextField9.setText("     NIC");
        jTextField9.setToolTipText("Type like000000000V");
        jTextField9.setBorder(null);
        jTextField9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField9MouseMoved(evt);
            }
        });
        jTextField9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField9MouseClicked(evt);
            }
        });
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });
        jPanel12.add(jTextField9);
        jTextField9.setBounds(0, 0, 290, 40);

        nic.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nic.setBorder(javax.swing.BorderFactory.createTitledBorder("NIC"));
        nic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nicMouseExited(evt);
            }
        });
        nic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicActionPerformed(evt);
            }
        });
        nic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nicKeyTyped(evt);
            }
        });
        jPanel12.add(nic);
        nic.setBounds(0, 0, 290, 40);

        jPanel7.setBackground(new java.awt.Color(5, 74, 117));
        jPanel7.setLayout(null);

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(102, 102, 102));
        jTextField4.setText("    Owner ID");
        jTextField4.setBorder(null);
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
        jPanel7.add(jTextField4);
        jTextField4.setBounds(0, 0, 290, 40);

        oi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oi.setBorder(javax.swing.BorderFactory.createTitledBorder("Owner ID"));
        oi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                oiMouseExited(evt);
            }
        });
        oi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oiActionPerformed(evt);
            }
        });
        oi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                oiKeyTyped(evt);
            }
        });
        jPanel7.add(oi);
        oi.setBounds(0, 0, 290, 40);

        jPanel10.setBackground(new java.awt.Color(5, 74, 117));
        jPanel10.setLayout(null);

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(255, 255, 255));
        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(102, 102, 102));
        jTextField7.setText("     Phone NO");
        jTextField7.setToolTipText("Type only numbers");
        jTextField7.setBorder(null);
        jTextField7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField7MouseMoved(evt);
            }
        });
        jTextField7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField7MouseClicked(evt);
            }
        });
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        jPanel10.add(jTextField7);
        jTextField7.setBounds(0, 0, 290, 40);

        mob.setEditable(false);
        mob.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mob.setBorder(javax.swing.BorderFactory.createTitledBorder("Phone NO"));
        mob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mobMouseExited(evt);
            }
        });
        mob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobActionPerformed(evt);
            }
        });
        mob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobKeyTyped(evt);
            }
        });
        jPanel10.add(mob);
        mob.setBounds(0, 0, 290, 40);

        male.setBackground(new java.awt.Color(5, 74, 117));
        buttonGroup1.add(male);
        male.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        male.setForeground(new java.awt.Color(255, 255, 255));
        male.setText("Male");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gender");

        female.setBackground(new java.awt.Color(5, 74, 117));
        buttonGroup1.add(female);
        female.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        female.setForeground(new java.awt.Color(255, 255, 255));
        female.setText("Fe male");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(11, 11, 11)
                        .addComponent(male)
                        .addGap(26, 26, 26)
                        .addComponent(female, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(male)
                    .addComponent(female))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(5, 74, 117));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parking Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Vani", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel15.setBackground(new java.awt.Color(5, 74, 117));
        jPanel15.setLayout(null);

        jTextField12.setEditable(false);
        jTextField12.setBackground(new java.awt.Color(255, 255, 255));
        jTextField12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(102, 102, 102));
        jTextField12.setText("     Vechile NO");
        jTextField12.setBorder(null);
        jTextField12.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField12MouseMoved(evt);
            }
        });
        jTextField12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField12MouseClicked(evt);
            }
        });
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField12KeyTyped(evt);
            }
        });
        jPanel15.add(jTextField12);
        jTextField12.setBounds(0, 0, 270, 40);

        VechileNO.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        VechileNO.setBorder(javax.swing.BorderFactory.createTitledBorder("Vechile NO"));
        VechileNO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VechileNOMouseExited(evt);
            }
        });
        VechileNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VechileNOActionPerformed(evt);
            }
        });
        VechileNO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                VechileNOKeyTyped(evt);
            }
        });
        jPanel15.add(VechileNO);
        VechileNO.setBounds(0, 0, 270, 40);

        jPanel16.setBackground(new java.awt.Color(5, 74, 117));
        jPanel16.setLayout(null);

        jTextField13.setEditable(false);
        jTextField13.setBackground(new java.awt.Color(255, 255, 255));
        jTextField13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(102, 102, 102));
        jTextField13.setText("    No Of  Vechile");
        jTextField13.setBorder(null);
        jTextField13.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField13MouseMoved(evt);
            }
        });
        jTextField13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField13MouseClicked(evt);
            }
        });
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField13KeyTyped(evt);
            }
        });
        jPanel16.add(jTextField13);
        jTextField13.setBounds(0, 0, 270, 40);

        noofvechile.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        noofvechile.setBorder(javax.swing.BorderFactory.createTitledBorder("No Of Vechile"));
        noofvechile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                noofvechileMouseExited(evt);
            }
        });
        noofvechile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noofvechileActionPerformed(evt);
            }
        });
        noofvechile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                noofvechileKeyTyped(evt);
            }
        });
        jPanel16.add(noofvechile);
        noofvechile.setBounds(0, 0, 270, 40);

        jPanel18.setBackground(new java.awt.Color(5, 74, 117));
        jPanel18.setLayout(null);

        jTextField14.setEditable(false);
        jTextField14.setBackground(new java.awt.Color(255, 255, 255));
        jTextField14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(102, 102, 102));
        jTextField14.setText("     Vechile type");
        jTextField14.setBorder(null);
        jTextField14.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField14MouseMoved(evt);
            }
        });
        jTextField14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField14MouseClicked(evt);
            }
        });
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField14KeyTyped(evt);
            }
        });
        jPanel18.add(jTextField14);
        jTextField14.setBounds(0, 0, 290, 40);

        vechiletype.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vechiletype.setBorder(javax.swing.BorderFactory.createTitledBorder("Vechile type"));
        vechiletype.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                vechiletypeFocusGained(evt);
            }
        });
        vechiletype.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vechiletypeMouseExited(evt);
            }
        });
        vechiletype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vechiletypeActionPerformed(evt);
            }
        });
        vechiletype.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                vechiletypeKeyTyped(evt);
            }
        });
        jPanel18.add(vechiletype);
        vechiletype.setBounds(0, 0, 290, 40);

        jPanel14.setBackground(new java.awt.Color(5, 74, 117));
        jPanel14.setLayout(null);

        jTextField11.setEditable(false);
        jTextField11.setBackground(new java.awt.Color(255, 255, 255));
        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(102, 102, 102));
        jTextField11.setText("     Vechile model");
        jTextField11.setBorder(null);
        jTextField11.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField11MouseMoved(evt);
            }
        });
        jTextField11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField11MouseClicked(evt);
            }
        });
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField11KeyTyped(evt);
            }
        });
        jPanel14.add(jTextField11);
        jTextField11.setBounds(0, 0, 290, 40);

        vechilemodel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vechilemodel.setBorder(javax.swing.BorderFactory.createTitledBorder("Vechile model"));
        vechilemodel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                vechilemodelFocusGained(evt);
            }
        });
        vechilemodel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vechilemodelMouseExited(evt);
            }
        });
        vechilemodel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vechilemodelActionPerformed(evt);
            }
        });
        vechilemodel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                vechilemodelKeyTyped(evt);
            }
        });
        jPanel14.add(vechilemodel);
        vechilemodel.setBounds(0, 0, 290, 40);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(5, 74, 117));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Flat Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Vani", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jComboBox2.setEditable(true);
        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Floor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jComboBox2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setEditable(true);
        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Flat no", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBox4.setEditable(true);
        jComboBox4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Flat Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jComboBox4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Owner book one more flat");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(5, 74, 117));
        jTextField1.setForeground(new java.awt.Color(5, 74, 117));
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        regisaddmin.setBackground(new java.awt.Color(5, 74, 117));
        regisaddmin.setForeground(new java.awt.Color(255, 255, 255));
        regisaddmin.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(131, 131, 131))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(regisaddmin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(regisaddmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));

        jPanel19.setBackground(new java.awt.Color(5, 74, 117));
        jPanel19.setLayout(null);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        jPanel19.add(jTextField2);
        jTextField2.setBounds(0, 0, 260, 30);

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jPanel19.add(jScrollPane2);
        jScrollPane2.setBounds(0, 30, 260, 90);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apartment_management/img/clear1234.png"))); // NOI18N
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 255, 255));
        delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apartment_management/img/delete1234.png"))); // NOI18N
        delete.setText("Delete");
        delete.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                deleteMouseMoved(evt);
            }
        });
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteMouseExited(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apartment_management/img/update1234.png"))); // NOI18N
        update.setText("Update");
        update.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                updateMouseMoved(evt);
            }
        });
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateMouseExited(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon("D:\\sumanan\\level5\\project\\Apartment_management\\img\\Previous1234.png")); // NOI18N
        jButton7.setText("Back");
        jButton7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton7MouseMoved(evt);
            }
        });
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apartment_management/img/save1234.png"))); // NOI18N
        jButton2.setText("Register");
        jButton2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton2MouseMoved(evt);
            }
        });
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(null);
        jPanel13.add(jLabel4);
        jLabel4.setBounds(0, 0, 270, 280);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Image");
        jPanel13.add(jLabel5);
        jLabel5.setBounds(70, 110, 110, 29);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Browse");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("use webcam");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Register", jPanel4);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Owner ID", "Email", "Phone", "NIC", "Gender", "Vechile Type", "Vechile model", "no_of_vechile", "Vechile_no"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel11.setBackground(new java.awt.Color(5, 74, 117));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        ow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                owActionPerformed(evt);
            }
        });
        ow.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                owKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Search any one");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ow, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(ow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("View details", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6MouseMoved

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyTyped

    private void mail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mail1ActionPerformed

    private void noofvechileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noofvechileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noofvechileActionPerformed

    private void jTextField13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13KeyTyped

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jTextField13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField13MouseClicked
        noofvechile.setText("");
        jTextField13.setBorder(new LineBorder(Color.white, 1));
        jTextField13.setVisible(false);
        noofvechile.setVisible(true);
        noofvechile.requestFocus();
    }//GEN-LAST:event_jTextField13MouseClicked

    private void jTextField13MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField13MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13MouseMoved

    private void VechileNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VechileNOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VechileNOActionPerformed

    private void jTextField12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyTyped

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField12MouseClicked
        VechileNO.setText("");
        jTextField12.setBorder(new LineBorder(Color.white, 1));
        jTextField12.setVisible(false);
        VechileNO.setVisible(true);
        VechileNO.requestFocus();
    }//GEN-LAST:event_jTextField12MouseClicked

    private void jTextField12MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField12MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12MouseMoved

    private void vechilemodelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vechilemodelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vechilemodelActionPerformed

    private void vechilemodelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vechilemodelFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_vechilemodelFocusGained

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyTyped

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField11MouseClicked
        jTextField11.setBorder(new LineBorder(Color.white, 1));
        jTextField11.setVisible(false);
        vechilemodel.setVisible(true);
        vechilemodel.requestFocus();
    }//GEN-LAST:event_jTextField11MouseClicked

    private void jTextField11MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField11MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11MouseMoved

    private void nicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nicActionPerformed

    private void nicMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nicMouseExited
        if (nic.getText().equals("")) {
            jTextField9.setVisible(true);
            nic.setVisible(false);
        } else {
            jTextField9.setVisible(false);
            nic.setVisible(true);
        }
    }//GEN-LAST:event_nicMouseExited

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField9MouseClicked
        nic.setText("");
        jTextField9.setBorder(new LineBorder(Color.white, 1));
        jTextField9.setVisible(false);
        nic.setVisible(true);
        nic.requestFocus();
    }//GEN-LAST:event_jTextField9MouseClicked

    private void jTextField9MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField9MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9MouseMoved

    private void mobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobActionPerformed

    private void mobMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mobMouseExited
        if (mob.getText().equals("")) {
            jTextField7.setVisible(true);
            mob.setVisible(false);
        } else {
            jTextField7.setVisible(false);
            mob.setVisible(true);
        }
    }//GEN-LAST:event_mobMouseExited

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
        mob.setText("");
        jTextField7.setBorder(new LineBorder(Color.white, 1));
        jTextField7.setVisible(false);
        mob.setVisible(true);
        mob.requestFocus();
    }//GEN-LAST:event_jTextField7MouseClicked

    private void jTextField7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7MouseMoved

    private void mailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mailKeyTyped
        if (mail.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_mailKeyTyped

    private void mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailActionPerformed

    private void mailMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mailMouseReleased

    }//GEN-LAST:event_mailMouseReleased

    private void mailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mailMouseExited
        if (mail.getText().equals("")) {
            jTextField5.setVisible(true);
            mail.setVisible(false);
        } else {
            jTextField5.setVisible(false);
            mail.setVisible(true);
        }
    }//GEN-LAST:event_mailMouseExited

    private void mailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mailFocusGained

    }//GEN-LAST:event_mailFocusGained

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        mail.setText("");
        jTextField5.setBorder(new LineBorder(Color.white, 1));
        jTextField5.setVisible(false);
        mail.setVisible(true);
        mail.requestFocus();

    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusGained

    }//GEN-LAST:event_jTextField5FocusGained

    private void jTextField5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5MouseMoved

    private void oiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oiActionPerformed

    private void oiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oiMouseExited
        if (oi.getText().equals("")) {
            jTextField4.setVisible(true);
            oi.setVisible(false);
        } else {
            jTextField4.setVisible(false);
            oi.setVisible(true);
        }
    }//GEN-LAST:event_oiMouseExited

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        jTextField4.setBorder(new LineBorder(Color.white, 1));
        jTextField4.setVisible(false);
        oi.setVisible(true);
        oi.requestFocus();
        if (oi.getText().equals("")) {
            jTextField4.setVisible(false);
            oi.setVisible(true);
            try {
                conn = dbconnection.getConnetion();
                PST = conn.prepareStatement("select detail from number where no=\"1\"");
                RS = PST.executeQuery();
                while (RS.next()) {
                    String did = RS.getString("detail");
                    String s = did;
                    String va=  s.substring(1, 5);
                    int no = Integer.parseInt(va);
                    int no1 = no + 1;
                    String org = Integer.toString(no1);
                    oi.setText("W" + org);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        } else {
        }
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseMoved

    }//GEN-LAST:event_jTextField4MouseMoved

    private void nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyTyped
        if (name.getText().length() >= 40) {
            evt.consume();
        }
    }//GEN-LAST:event_nameKeyTyped

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void nameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseReleased

    }//GEN-LAST:event_nameMouseReleased

    private void nameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseExited
        if (name.getText().equals("")) {
            jTextField3.setVisible(true);
            name.setVisible(false);
        } else {
            jTextField3.setVisible(false);
            name.setVisible(true);
        }
    }//GEN-LAST:event_nameMouseExited

    private void nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFocusGained

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed

    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseReleased

    }//GEN-LAST:event_jTextField3MouseReleased

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        name.setText("");
        jTextField3.setBorder(new LineBorder(Color.white, 1));
        jTextField3.setVisible(false);
        name.setVisible(true);
        name.requestFocus();

    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained

    }//GEN-LAST:event_jTextField3FocusGained

    private void jTextField3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseMoved

    }//GEN-LAST:event_jTextField3MouseMoved

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        try {
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement("update flatowner set name=?,Vechiletype=?,vechile_model=?,no_of_vechile=?,gender=?,phone=?,email=?,vechile_no=?,Nic=? where ownerid=? ");
            PST.setString(1, name.getText());
            PST.setString(2, vechiletype.getText());
            PST.setString(3, vechilemodel.getText());
            PST.setString(4, noofvechile.getText());
            String gender = null;
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            }
            PST.setString(5, gender);
            PST.setString(6, mob.getText());
            PST.setString(7, mail.getText());
            PST.setString(8, VechileNO.getText());
            PST.setString(9, nic.getText());
            PST.setString(10, oi.getText());

            PST.executeUpdate();
            JOptionPane.showMessageDialog(null, "update sucessfully!!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        //cb1.removeAllItems();
        oi.setText("");
        oi.setVisible(false);
        name.setText("");
        name.setVisible(false);
        mail.setText("");
        mail.setVisible(false);
        mob.setText("");
        mob.setVisible(false);
        nic.setText("");
        nic.setVisible(false);
        VechileNO.setText("");
        VechileNO.setVisible(false);
        vechilemodel.setText("");
        vechilemodel.setVisible(false);
        vechiletype.setText("");
        vechiletype.setVisible(false);
        noofvechile.setText("");
        noofvechile.setVisible(false);
        jTextField2.setText("");
        jComboBox4.removeAllItems();
        comloadtype();
        jComboBox2.removeAllItems();
        jComboBox3.removeAllItems();
        jTextField3.setVisible(true);
        jTextField4.setVisible(true);
        jTextField5.setVisible(true);
        jTextField7.setVisible(true);
        jTextField9.setVisible(true);
        jTextField11.setVisible(true);
        jTextField12.setVisible(true);
        jTextField13.setVisible(true);
        jTextField14.setVisible(true);
        jLabel4.setVisible(false);
        jLabel5.setVisible(true);
        jComboBox2.setEnabled(false);
        jComboBox3.setEnabled(false);
        jButton2.setVisible(true);
        delete.setVisible(false);
        jComboBox2.setEnabled(false);
        jComboBox3.setEnabled(false);
        update.setVisible(false);
    }//GEN-LAST:event_updateActionPerformed

    private void vechilemodelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vechilemodelMouseExited
        if (vechilemodel.getText().equals("")) {
            jTextField11.setVisible(true);
            vechilemodel.setVisible(false);
        } else {
            jTextField11.setVisible(false);
            vechilemodel.setVisible(true);
        }
    }//GEN-LAST:event_vechilemodelMouseExited

    private void VechileNOMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VechileNOMouseExited
        if (VechileNO.getText().equals("")) {
            jTextField12.setVisible(true);
            VechileNO.setVisible(false);
        } else {
            jTextField12.setVisible(false);
            VechileNO.setVisible(true);
        }
    }//GEN-LAST:event_VechileNOMouseExited

    private void noofvechileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noofvechileMouseExited
        if (noofvechile.getText().equals("")) {
            jTextField13.setVisible(true);
            noofvechile.setVisible(false);
        } else {
            jTextField13.setVisible(false);
            noofvechile.setVisible(true);
        }
    }//GEN-LAST:event_noofvechileMouseExited

    private void jButton2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseMoved
        jButton2.setBackground(new Color(0, 255, 0));
    }//GEN-LAST:event_jButton2MouseMoved

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        jButton2.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        jButton2.setBackground(new Color(7, 110, 32));
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        this.dispose();
//        menu m = new menu();
//        m.setVisible(true);
//        m.jLabel5.setText(regisaddmin.getText());
//        m.jLabel7.setText(jTextField1.getText());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (name.getText().equals("")) {
            jTextField3.setBorder(new LineBorder(Color.red, 1));
            JOptionPane.showMessageDialog(null, "<html><b> <font color=\"red\" size=\"4\">What is your Name?</font> </b></html>");
        } else if (mail.getText().equals("")) {
            jTextField5.setBorder(new LineBorder(Color.red, 1));
            JOptionPane.showMessageDialog(null, "<html><b> <font color=\"red\" size=\"4\">What is your Email?</font> </b></html>");
        } else if (nic.getText().equals("")) {
            jTextField9.setBorder(new LineBorder(Color.red, 1));
            JOptionPane.showMessageDialog(null, "<html><b> <font color=\"red\" size=\"4\">What is your NIC number?</font> </b></html>");
        } else if (oi.getText().equals("")) {
            jTextField4.setBorder(new LineBorder(Color.red, 1));
            JOptionPane.showMessageDialog(null, "<html><b> <font color=\"red\" size=\"4\">What is your Owner ID?</font> </b></html>");
        } else if (mob.getText().equals("")) {
            jTextField7.setBorder(new LineBorder(Color.red, 1));
            JOptionPane.showMessageDialog(null, "<html><b> <font color=\"red\" size=\"4\">What is your phone number?</font> </b></html>");
        } else {
            String owner = null;
            try {
                conn = dbconnection.getConnetion();
                PST = conn.prepareStatement("select ownerid from flatowner where ownerid=?");
                PST.setString(1, oi.getText());
                RS = PST.executeQuery();
                while (RS.next()) {
                    owner = RS.getString("ownerid");
                }
                if (oi.getText().equals(owner)) {
                    try {
                        conn = dbconnection.getConnetion();
                        PST = conn.prepareStatement("update flat set position=?, ownerid=? where type=? and floor=? and flatno=?");
                        PST.setString(1, "Not Available");
                        PST.setString(2, oi.getText());
                        PST.setString(3, jComboBox4.getSelectedItem().toString());
                        PST.setString(4, jComboBox2.getSelectedItem().toString());
                        PST.setString(5, jComboBox3.getSelectedItem().toString());
                        PST.executeUpdate();

                        JOptionPane.showMessageDialog(null, "update sucessfully!!");
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }

                    bill b = new bill();
//                    b.jTextField10.setText(regisaddmin.getText());
//                    b.jTextField41.setText(jTextField1.getText());
                    b.onno.setText("1");
                    b.jTextField2.setVisible(false);
                    b.Billno.setVisible(true);
                    b.Billno.requestFocus();
                    try {
                        conn = dbconnection.getConnetion();
                        PST = conn.prepareStatement("select detail from number where no=\"3\"");
                        RS = PST.executeQuery();
                        while (RS.next()) {
                            String did = RS.getString("detail");
                            String s = did;
                            String va=  s.substring(1, 5);
                            int no = Integer.parseInt(va);
                            int no1 = no + 1;
                            String w = Integer.toString(no1);
                            fl = "B" + w;
                            b.Billno.setText(fl);
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                    b.jTextField5.setVisible(false);
                    b.oiwner.setVisible(true);
                    b.oiwner.setText(owner);
                    //bill alacate
                    b.jTextField6.setVisible(false);
                    b.Name.setVisible(true);
                    b.Name.setText(name.getText());
                    // auto name alacate..... 
//                        try {
//                            conn = dbconnection.getConnetion();
//                            PST = conn.prepareStatement(" select name from  flatowner where ownerid=?");
//                            PST.setString(1, oi.getText());
//                            RS = PST.executeQuery();
//                            if (RS.next()) {
//                                b.Name.setText(RS.getString("name"));
//                            }
//                        } catch (SQLException ex) {
//                            JOptionPane.showMessageDialog(null, ex);
//                        }

                    // auto amount detail set....
                    try {
                        conn = dbconnection.getConnetion();
                        PST = conn.prepareStatement("select * from flat where flatno=?");
                        PST.setString(1, jComboBox3.getSelectedItem().toString());
                        RS = PST.executeQuery();
                        if (RS.next()) {

                            F = (RS.getString("flatno"));
                            A = (RS.getString("amount"));
                        }
                    } catch (SQLException ex) {
                        //JOptionPane.showMessageDialog(null, ex);
                    }
                    try {
                        String query = "INSERT INTO bill(billno,date,amount,details)values(?,?,?,?)";
                        conn = dbconnection.getConnetion();
                        PST = conn.prepareStatement(query);
                        PST.setString(1, fl);
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = new Date(System.currentTimeMillis());
                        String day = (formatter.format(date));
                        PST.setString(2, day);
                        PST.setString(3, A);
                        PST.setString(4, F + "flatsold");
                        PST.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Insert Successfully");
                    } catch (SQLException ex) {
                        System.err.println(ex);
                        JOptionPane.showMessageDialog(null, "Duplicated Entry");
                    }
////                b.jLabel2.setText(F);
                    showbill();
                    int sum = 0;
                    for (int i = 0; i < jTable2.getRowCount(); i++) {
                        sum = sum + Integer.parseInt(jTable2.getValueAt(i, 1).toString());
                    }
                    total.setVisible(true);
                    total.setText(Integer.toString(sum));
                    oi.setText("");
                    oi.setVisible(false);
                    name.setText("");
                    name.setVisible(false);
                    mail.setText("");
                    mail.setVisible(false);
                    mob.setText("");
                    mob.setVisible(false);
                    nic.setText("");
                    nic.setVisible(false);
                    VechileNO.setText("");
                    VechileNO.setVisible(false);
                    vechilemodel.setText("");
                    vechilemodel.setVisible(false);
                    vechiletype.setText("");
                    vechiletype.setVisible(false);
                    noofvechile.setText("");
                    noofvechile.setVisible(false);
                    jTextField2.setText("");
                    jComboBox4.removeAllItems();
                    comloadtype();
                    jComboBox2.removeAllItems();
                    jComboBox3.removeAllItems();
                    jTextField3.setVisible(true);
                    jTextField4.setVisible(true);
                    jTextField5.setVisible(true);
                    jTextField7.setVisible(true);
                    jTextField9.setVisible(true);
                    jTextField11.setVisible(true);
                    jTextField12.setVisible(true);
                    jTextField13.setVisible(true);
                    jTextField14.setVisible(true);
                    jLabel4.setVisible(false);
                    jLabel5.setVisible(true);
                    jComboBox2.setEnabled(false);
                    jComboBox3.setEnabled(false);
                    jButton2.setVisible(true);
                    delete.setVisible(false);
                    jComboBox2.setEnabled(false);
                    jComboBox3.setEnabled(false);
                    update.setVisible(false);
                    b.setVisible(true);

                } else {
                    try {
                        String query = "INSERT INTO flatowner(name,ownerid,vechiletype,vechile_model,no_of_vechile,gender,phone,email,Date,vechile_no,nic,image)values(?,?,?,?,?,?,?,?,?,?,?,?)";
                        conn = dbconnection.getConnetion();
                        PST = conn.prepareStatement(query);
                        PST.setString(1, name.getText());
                        PST.setString(2, oi.getText());
                        na = oi.getText();

                        if (vechiletype.getText().equals("")) {
                            PST.setString(3, "empty");
                            PST.setString(4, "empty");
                            PST.setString(5, "empty");
                        } else {
                            PST.setString(3, vechiletype.getText());
                            PST.setString(4, vechilemodel.getText());
                            PST.setString(5, noofvechile.getText());
                        }
                        String gender = null;
                        if (male.isSelected()) {
                            gender = "Male";
                        } else if (female.isSelected()) {
                            gender = "Female";
                        }
                        PST.setString(6, gender);
                        PST.setString(7, mob.getText());
                        PST.setString(8, mail.getText());
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = new Date(System.currentTimeMillis());
                        String day = (formatter.format(date));
                        PST.setString(9, day);
                        if (vechiletype.getText().equals("")) {
                            PST.setString(10, "empty");
                        } else {
                            PST.setString(10, VechileNO.getText());
                        }
                        PST.setString(11, nic.getText());
//                            PST.setString(12, jComboBox3.getSelectedItem().toString());
                        PST.setBytes(12, person_image);
                        PST.executeUpdate();
                        JOptionPane.showMessageDialog(null, "<html><b>Register success</b></html>");

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }

                    try {
                        conn = dbconnection.getConnetion();
                        PST = conn.prepareStatement("update flat set position=?, ownerid=? where type=? and floor=? and flatno=?");
                        PST.setString(1, "Not Available");
                        PST.setString(2, oi.getText());
                        PST.setString(3, jComboBox4.getSelectedItem().toString());
                        PST.setString(4, jComboBox2.getSelectedItem().toString());
                        PST.setString(5, jComboBox3.getSelectedItem().toString());
                        PST.executeUpdate();

                        JOptionPane.showMessageDialog(null, "update sucessfully!!");
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                    try {
                        conn = dbconnection.getConnetion();
                        PST = conn.prepareStatement("update number set detail=? where no=\"1\"");
                        PST.setString(1, oi.getText());
                        PST.executeUpdate();
                        JOptionPane.showMessageDialog(null, "update sucessfully!!");
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                    bill b = new bill();
                    b.onno.setText("1");
                    b.jTextField2.setVisible(false);

                    b.Billno.setVisible(true);
                    b.Billno.requestFocus();
                    try {
                        conn = dbconnection.getConnetion();
                        PST = conn.prepareStatement("select detail from number where no=\"3\"");
                        RS = PST.executeQuery();
                        while (RS.next()) {
                            String did = RS.getString("detail");
                            String s = did;
                            String va=  s.substring(1, 5);
                            int no = Integer.parseInt(va);
                            int no1 = no + 1;
                            String w = Integer.toString(no1);
                            fl = "B" + w;
                            b.Billno.setText(fl);
                        }
                    } catch (SQLException ex) {
                        // JOptionPane.showMessageDialog(null, ex);
                    }
                    b.jTextField5.setVisible(false);
                    b.oiwner.setVisible(true);
                    b.oiwner.setText(na);
                    //bill alacate
                    b.jTextField6.setVisible(false);
                    b.Name.setVisible(true);
                    b.Name.setText(name.getText());
                    // auto name alacate..... 
//                        try {
//                            conn = dbconnection.getConnetion();
//                            PST = conn.prepareStatement(" select name from  flatowner where ownerid=?");
//                            PST.setString(1, oi.getText());
//                            RS = PST.executeQuery();
//                            if (RS.next()) {
//                                b.Name.setText(RS.getString("name"));
//                            }
//                        } catch (SQLException ex) {
//                            JOptionPane.showMessageDialog(null, ex);
//                        }

                    // auto amount detail set....
                    try {
                        conn = dbconnection.getConnetion();
                        PST = conn.prepareStatement("select * from flat where flatno=?");
                        PST.setString(1, jComboBox3.getSelectedItem().toString());
                        RS = PST.executeQuery();
                        if (RS.next()) {

                            F = (RS.getString("flatno"));
                            A = (RS.getString("amount"));
                        }
                    } catch (SQLException ex) {
                        // JOptionPane.showMessageDialog(null, ex);
                    }
                    try {
                        String query = "INSERT INTO bill(billno,date,amount,details)values(?,?,?,?)";
                        conn = dbconnection.getConnetion();
                        PST = conn.prepareStatement(query);
                        PST.setString(1, fl);
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = new Date(System.currentTimeMillis());
                        String day = (formatter.format(date));
                        PST.setString(2, day);
                        PST.setString(3, A);
                        PST.setString(4, F + "flatsold");
                        PST.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Insert Successfully");
                    } catch (SQLException ex) {
                        System.err.println(ex);
                        JOptionPane.showMessageDialog(null, "Duplicated Entry");
                    }
////                b.jLabel2.setText(F);
                    showbill();
                    int sum = 0;
                    for (int i = 0; i < jTable2.getRowCount(); i++) {
                        sum = sum + Integer.parseInt(jTable2.getValueAt(i, 1).toString());
                    }
                    total.setVisible(true);
                    total.setText(Integer.toString(sum));
                    oi.setText("");
                    oi.setVisible(false);
                    name.setText("");
                    name.setVisible(false);
                    mail.setText("");
                    mail.setVisible(false);
                    mob.setText("");
                    mob.setVisible(false);
                    nic.setText("");
                    nic.setVisible(false);
                    VechileNO.setText("");
                    VechileNO.setVisible(false);
                    vechilemodel.setText("");
                    vechilemodel.setVisible(false);
                    vechiletype.setText("");
                    vechiletype.setVisible(false);
                    noofvechile.setText("");
                    noofvechile.setVisible(false);
                    jTextField2.setText("");
                    jComboBox4.removeAllItems();
                    comloadtype();
                    jComboBox2.removeAllItems();
                    jComboBox3.removeAllItems();
                    jTextField3.setVisible(true);
                    jTextField4.setVisible(true);
                    jTextField5.setVisible(true);
                    jTextField7.setVisible(true);
                    jTextField9.setVisible(true);
                    jTextField11.setVisible(true);
                    jTextField12.setVisible(true);
                    jTextField13.setVisible(true);
                    jTextField14.setVisible(true);
                    jLabel4.setVisible(false);
                    jLabel5.setVisible(true);
                    jComboBox2.setEnabled(false);
                    jComboBox3.setEnabled(false);
                    jButton2.setVisible(true);
                    delete.setVisible(false);
                    jComboBox2.setEnabled(false);
                    jComboBox3.setEnabled(false);
                    update.setVisible(false);
                    Model.removeAllElements();
                    comloadowner();
                    b.setVisible(true);

                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox4PopupMenuWillBecomeInvisible
        jComboBox2.setEnabled(true);
        try {
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement("select floor from flat where position=\"Avaliable\" and type=? group by floor");
            PST.setString(1, jComboBox4.getSelectedItem().toString());
            RS = PST.executeQuery();
            while (RS.next()) {
                String did = RS.getString("floor");
                jComboBox2.addItem(did);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
    }//GEN-LAST:event_jComboBox4PopupMenuWillBecomeInvisible

    private void jComboBox2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox2PopupMenuWillBecomeInvisible
        jComboBox3.setEnabled(true);
        try {
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement(" select flatno from flat where position=\"Avaliable\" and type=? and floor=?");
            PST.setString(1, jComboBox4.getSelectedItem().toString());
            PST.setString(2, jComboBox2.getSelectedItem().toString());
            RS = PST.executeQuery();
            while (RS.next()) {
                String did = RS.getString("flatno");
                jComboBox3.addItem(did);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
    }//GEN-LAST:event_jComboBox2PopupMenuWillBecomeInvisible

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int count = 0;
        int obj = JOptionPane.showConfirmDialog(null, "Are you sure delete this one?", "Delete", JOptionPane.YES_NO_OPTION);
        if (obj == 0) {
            try {
                conn = dbconnection.getConnetion();
                PST = conn.prepareStatement("SELECT count(ownerid) FROM flat where ownerid=?");
                PST.setString(1, oi.getText());
                RS = PST.executeQuery();
                if (RS.next());
                {
                    count = RS.getInt("count(ownerid)");
                }

                if (count == 1) {
                    try {
                        conn = dbconnection.getConnetion();
                        PST = conn.prepareStatement("delete from flatowner where ownerid=? ");
                        PST.setString(1, oi.getText());
//                        PST.setString(2, jComboBox3.getSelectedItem().toString());
                        PST.executeUpdate();

                        JOptionPane.showMessageDialog(null, "delete success fully");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);

                    }
                    try {
                        conn = dbconnection.getConnetion();
                        PST = conn.prepareStatement("update flat set position=?,ownerid=? where flatno=?");
                        PST.setString(1, "Avaliable");
                        PST.setString(2, "");
                        PST.setString(3, jComboBox3.getSelectedItem().toString());
                        PST.executeUpdate();

                        JOptionPane.showMessageDialog(null, "update sucessfully!!");
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                    jComboBox4.removeAllItems();
                    Model.removeAllElements();
                    comloadowner();
                    comloadtype();
                    oi.setText("");
                    oi.setVisible(false);
                    name.setText("");
                    name.setVisible(false);
                    mail.setText("");
                    mail.setVisible(false);
                    mob.setText("");
                    mob.setVisible(false);
                    nic.setText("");
                    nic.setVisible(false);
                    VechileNO.setText("");
                    VechileNO.setVisible(false);
                    vechilemodel.setText("");
                    vechilemodel.setVisible(false);
                    vechiletype.setText("");
                    vechiletype.setVisible(false);
                    noofvechile.setText("");
                    noofvechile.setVisible(false);
                    jTextField2.setText("");
                    jComboBox4.removeAllItems();
                    comloadtype();
                    jComboBox2.removeAllItems();
                    jComboBox3.removeAllItems();
                    jTextField3.setVisible(true);
                    jTextField4.setVisible(true);
                    jTextField5.setVisible(true);
                    jTextField7.setVisible(true);
                    jTextField9.setVisible(true);
                    jTextField11.setVisible(true);
                    jTextField12.setVisible(true);
                    jTextField13.setVisible(true);
                    jTextField14.setVisible(true);
                    jLabel4.setVisible(false);
                    jLabel5.setVisible(true);
                    jComboBox2.setEnabled(false);
                    jComboBox3.setEnabled(false);
                    jButton2.setVisible(true);
                    delete.setVisible(false);
                    jComboBox2.setEnabled(false);
                    jComboBox3.setEnabled(false);
                    update.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "suman");
                    try {
                        conn = dbconnection.getConnetion();
                        PST = conn.prepareStatement("update flat set position=?,ownerid=? where flatno=?");
                        PST.setString(1, "Avaliable");
                        PST.setString(2, "");
                        PST.setString(3, jComboBox3.getSelectedItem().toString());
                        PST.executeUpdate();

                        JOptionPane.showMessageDialog(null, "update sucessfully!!");
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                    jComboBox4.removeAllItems();
                    Model.removeAllElements();
                    comloadowner();
                    comloadtype();
                    oi.setText("");
                    oi.setVisible(false);
                    name.setText("");
                    name.setVisible(false);
                    mail.setText("");
                    mail.setVisible(false);
                    mob.setText("");
                    mob.setVisible(false);
                    nic.setText("");
                    nic.setVisible(false);
                    VechileNO.setText("");
                    VechileNO.setVisible(false);
                    vechilemodel.setText("");
                    vechilemodel.setVisible(false);
                    vechiletype.setText("");
                    vechiletype.setVisible(false);
                    noofvechile.setText("");
                    noofvechile.setVisible(false);
                    jTextField2.setText("");
                    jComboBox4.removeAllItems();
                    comloadtype();
                    jComboBox2.removeAllItems();
                    jComboBox3.removeAllItems();
                    jTextField3.setVisible(true);
                    jTextField4.setVisible(true);
                    jTextField5.setVisible(true);
                    jTextField7.setVisible(true);
                    jTextField9.setVisible(true);
                    jTextField11.setVisible(true);
                    jTextField12.setVisible(true);
                    jTextField13.setVisible(true);
                    jTextField14.setVisible(true);
                    jLabel4.setVisible(false);
                    jLabel5.setVisible(true);
                    jComboBox2.setEnabled(false);
                    jComboBox3.setEnabled(false);
                    jButton2.setVisible(true);
                    delete.setVisible(false);
                    jComboBox2.setEnabled(false);
                    jComboBox3.setEnabled(false);
                    update.setVisible(false);

                }
            } catch (SQLException ex) {
                //  Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);

            }

        }
    }//GEN-LAST:event_deleteActionPerformed

    private void jTextField14MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField14MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14MouseMoved

    private void jTextField14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField14MouseClicked
        vechiletype.setText("");
        jTextField14.setVisible(false);
        vechiletype.setVisible(true);
        vechiletype.requestFocus();
    }//GEN-LAST:event_jTextField14MouseClicked

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14KeyTyped

    private void vechiletypeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vechiletypeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_vechiletypeFocusGained

    private void vechiletypeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vechiletypeMouseExited
        if (vechiletype.getText().equals("")) {
            jTextField14.setVisible(true);
            vechiletype.setVisible(false);
        } else {
            jTextField14.setVisible(false);
            vechiletype.setVisible(true);
        }
    }//GEN-LAST:event_vechiletypeMouseExited

    private void vechiletypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vechiletypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vechiletypeActionPerformed

    private void nameMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseMoved

    }//GEN-LAST:event_nameMouseMoved

    private void nicKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nicKeyTyped
        String phone = nic.getText();
        int length = phone.length();
        char c = evt.getKeyChar();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (length < 12) {
                nic.setEditable(true);
            } else {
                nic.setEditable(false);
            }
        } else {
            if ((Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) || c == KeyEvent.VK_V) {
                nic.setEditable(true);

            } else {
                nic.setEditable(false);
            }
        }
    }//GEN-LAST:event_nicKeyTyped

    private void oiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oiKeyTyped
        if (oi.getText().length() >= 15) {
            evt.consume();
        }
    }//GEN-LAST:event_oiKeyTyped

    private void mobKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobKeyTyped
        String phone = mob.getText();
        int length = phone.length();
        char c = evt.getKeyChar();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (length < 10) {

                mob.setEditable(true);
            } else {
                mob.setEditable(false);
            }
        } else {
            if ((Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                mob.setEditable(true);

            } else {
                mob.setEditable(false);
            }
        }
    }//GEN-LAST:event_mobKeyTyped

    private void vechiletypeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vechiletypeKeyTyped
        if (vechiletype.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_vechiletypeKeyTyped

    private void vechilemodelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vechilemodelKeyTyped
        if (vechilemodel.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_vechilemodelKeyTyped

    private void VechileNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VechileNOKeyTyped
        if (VechileNO.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_VechileNOKeyTyped

    private void noofvechileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noofvechileKeyTyped
        String phone = noofvechile.getText();
        int length = phone.length();
        char c = evt.getKeyChar();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (length < 3) {
                noofvechile.setEditable(true);
            } else {
                noofvechile.setEditable(false);
            }
        } else {
            if ((Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                noofvechile.setEditable(true);

            } else {
                noofvechile.setEditable(false);
            }
        }
    }//GEN-LAST:event_noofvechileKeyTyped

    private void deleteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseMoved
        delete.setBackground(new Color(255, 0, 0));
    }//GEN-LAST:event_deleteMouseMoved

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
        delete.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_deleteMouseExited

    private void updateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseMoved
        update.setBackground(new Color(0, 0, 255));
    }//GEN-LAST:event_updateMouseMoved

    private void updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseExited
        update.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_updateMouseExited

    private void owKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_owKeyReleased
        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
        showdepthowneridlike();
    }//GEN-LAST:event_owKeyReleased

    private void owActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_owActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_owActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
//        jTabbedPane1.setSelectedIndex(0);
//        jTextField3.setVisible(false);
//        jTextField4.setVisible(false);
//        jTextField5.setVisible(false);
//        jTextField7.setVisible(false);
//        jTextField9.setVisible(false);
//        jTextField11.setVisible(false);
//        jTextField12.setVisible(false);
//        jTextField13.setVisible(false);
//        jTextField14.setVisible(false);
//        name.setVisible(true);
//        oi.setVisible(true);
//        mail.setVisible(true);
//        nic.setVisible(true);
//        mob.setVisible(true);
//        VechileNO.setVisible(true);
//        noofvechile.setVisible(true);
//        vechiletype.setVisible(true);
//        vechilemodel.setVisible(true);
//
//        try {
//            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//            int selectedRowIndex = jTable1.getSelectedRow();
//            name.setText(model.getValueAt(selectedRowIndex, 0).toString());
//            oi.setText(model.getValueAt(selectedRowIndex, 1).toString());
//            mail.setText(model.getValueAt(selectedRowIndex, 2).toString());
//            mob.setText(model.getValueAt(selectedRowIndex, 3).toString());
//            String Gender = (model.getValueAt(selectedRowIndex, 4).toString());
//            if (Gender.equals("male")) {
//                male.setSelected(true);
//            } else {
//                female.setSelected(true);
//            }
//            nic.setText(model.getValueAt(selectedRowIndex, 5).toString());
//            vechiletype.setText(model.getValueAt(selectedRowIndex, 6).toString());
//            vechilemodel.setText(model.getValueAt(selectedRowIndex, 7).toString());
//            noofvechile.setText(model.getValueAt(selectedRowIndex, 8).toString());
//            VechileNO.setText(model.getValueAt(selectedRowIndex, 9).toString());
////            jComboBox1.setSelectedItem(model.getValueAt(selectedRowIndex, 0).toString());
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//
//        try {
//            conn = dbconnection.getConnetion();
//            PST = conn.prepareStatement("SELECT * FROM flatowner,flat Where flatowner.ownerid=flat.ownerid and flat.ownerid=?");
//            PST.setString(1, oi.getText());
//            RS = PST.executeQuery();
//            if (RS.next());
//            {
//                jComboBox4.addItem(RS.getString("type"));
//                jComboBox2.addItem(RS.getString("floor"));
//                jComboBox3.addItem(RS.getString("flatno"));
//            }
//        } catch (SQLException ex) {
//            //  Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, ex);
//
//        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseMoved
        jButton7.setBackground(new Color(18, 196, 202));
    }//GEN-LAST:event_jButton7MouseMoved

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        jButton7.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JComboBox optionList = new JComboBox();
        Object[] message
                = {"<html><font size=\"4\" color=\"blue\">What is your owner id</font></html>",
                    "Owner ID", optionList,};

        try {
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement("select distinct ownerid from flatowner");
            RS = PST.executeQuery();
            while (RS.next()) {
                String did = RS.getString("ownerid");
                optionList.addItem(did);
            }
        } catch (SQLException ex) {
            //  Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);

        }
        JOptionPane.showMessageDialog(null, message, "Owner id verification verification", JOptionPane.QUESTION_MESSAGE);
        String r = optionList.getSelectedItem().toString();
        jTextField3.setVisible(false);
        jTextField4.setVisible(false);
        jTextField5.setVisible(false);
        jTextField7.setVisible(false);
        jTextField9.setVisible(false);
        jTextField11.setVisible(false);
        jTextField12.setVisible(false);
        jTextField13.setVisible(false);
        jTextField14.setVisible(false);
        name.setVisible(true);
        oi.setVisible(true);
        mail.setVisible(true);
        nic.setVisible(true);
        mob.setVisible(true);
        vechiletype.setVisible(true);
        noofvechile.setVisible(true);
        VechileNO.setVisible(true);
        vechilemodel.setVisible(true);
        jLabel4.setVisible(true);

        try {
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement("SELECT * FROM flatowner,flat Where flatowner.ownerid=flat.ownerid and flat.ownerid=?");
            PST.setString(1, optionList.getSelectedItem().toString());
            RS = PST.executeQuery();
            if (RS.next());
            {
                name.setText(RS.getString("name"));
                oi.setText(RS.getString("ownerid"));
                vechiletype.setText(RS.getString("vechiletype"));
                vechilemodel.setText(RS.getString("vechile_model"));
                noofvechile.setText(RS.getString("no_of_vechile"));
                String gender = RS.getString("gender");
                if (gender.equals("Male")) {
                    male.setSelected(true);
                } else if (gender.equals("Female")) {
                    female.setSelected(true);
                }
                mob.setText(RS.getString("phone"));
                mail.setText(RS.getString("email"));

                VechileNO.setText(RS.getString("vechile_no"));
                nic.setText(RS.getString("Nic"));
                jLabel4.setIcon(ResizeImage(null, RS.getBytes("image")));
            }
        } catch (SQLException ex) {
            //  Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        oi.setText("");
        oi.setVisible(false);
        name.setText("");
        name.setVisible(false);
        mail.setText("");
        mail.setVisible(false);
        mob.setText("");
        mob.setVisible(false);
        nic.setText("");
        nic.setVisible(false);
        VechileNO.setText("");
        VechileNO.setVisible(false);
        vechilemodel.setText("");
        vechilemodel.setVisible(false);
        vechiletype.setText("");
        vechiletype.setVisible(false);
        noofvechile.setText("");
        noofvechile.setVisible(false);
        jTextField2.setText("");
        jComboBox4.removeAllItems();
        comloadtype();
        jComboBox2.removeAllItems();
        jComboBox3.removeAllItems();
        jTextField3.setVisible(true);
        jTextField4.setVisible(true);
        jTextField5.setVisible(true);
        jTextField7.setVisible(true);
        jTextField9.setVisible(true);
        jTextField11.setVisible(true);
        jTextField12.setVisible(true);
        jTextField13.setVisible(true);
        jTextField14.setVisible(true);
        jLabel4.setVisible(false);
        jLabel5.setVisible(true);
        jComboBox2.setEnabled(false);
        jComboBox3.setEnabled(false);
        jButton2.setVisible(true);
        delete.setVisible(false);
        jComboBox2.setEnabled(false);
        jComboBox3.setEnabled(false);
        update.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new NewJFrame2().setVisible(true);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jLabel5.setVisible(false);

//..............................................................................
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        ImageIcon imageicon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), Image.SCALE_SMOOTH));
        jLabel4.setIcon(imageicon);
        try {
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readnum; (readnum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readnum);
            }
            person_image = bos.toByteArray();
            jLabel4.setVisible(true);
        } catch (Exception e) {
        }

//JFileChooser file= new JFileChooser();
//file.setCurrentDirectory(new File(System.getProperty("user.home")));
//        
//        FileNameExtensionFilter filter=new FileNameExtensionFilter("*.Images","jpg","gif","png");    
//        file.addChoosableFileFilter(filter);
//        int result=file.showSaveDialog(null);
//        if(result==JFileChooser.APPROVE_OPTION)
//        {
//            File SelectFile=file.getSelectedFile();
//            String path=SelectFile.getAbsolutePath();
//            jLabel4.setIcon(ResizeImage(path,null));
//            filename=path;
//            jLabel4.setVisible(true);
//        }
//        else if(result == JFileChooser.CANCEL_OPTION)
//        {
//            JOptionPane.showMessageDialog(null,"file not select");
//        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        if (jTextField2.getText().equals("")) {
            jList1.setVisible(false);
            jScrollPane2.setVisible(false);
            oi.setText("");
            oi.setVisible(false);
            name.setText("");
            name.setVisible(false);
            mail.setText("");
            mail.setVisible(false);
            mob.setText("");
            mob.setVisible(false);
            nic.setText("");
            nic.setVisible(false);
            VechileNO.setText("");
            VechileNO.setVisible(false);
            vechilemodel.setText("");
            vechilemodel.setVisible(false);
            vechiletype.setText("");
            vechiletype.setVisible(false);
            noofvechile.setText("");
            noofvechile.setVisible(false);
            jTextField2.setText("");
            jComboBox4.removeAllItems();
            comloadtype();
            jComboBox2.removeAllItems();
            jComboBox3.removeAllItems();
            jTextField3.setVisible(true);
            jTextField4.setVisible(true);
            jTextField5.setVisible(true);
            jTextField7.setVisible(true);
            jTextField9.setVisible(true);
            jTextField11.setVisible(true);
            jTextField12.setVisible(true);
            jTextField13.setVisible(true);
            jTextField14.setVisible(true);
            jLabel4.setVisible(false);
            jLabel5.setVisible(true);
            jComboBox2.setEnabled(false);
            jComboBox3.setEnabled(false);
            jButton2.setVisible(true);
            delete.setVisible(false);
            update.setVisible(false);
            jButton2.setVisible(true);
            jComboBox2.setEnabled(false);
            jComboBox3.setEnabled(false);
        } else {
            jList1.setVisible(true);
            jScrollPane2.setVisible(true);
            DefaultListModel model = new DefaultListModel();
            model.clear();
            jList1.setModel(model);
            comloadowner();
            update.setVisible(false);
            delete.setVisible(false);
//            jButton2.setVisible(false);
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        String s = jList1.getSelectedValue();
        jTextField2.setText(s);
        int count = 0;
        try {
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement("SELECT COUNT(ownerid) from flat where ownerid=?");
            PST.setString(1, jList1.getSelectedValue());
            RS = PST.executeQuery();

            while (RS.next()) {
                int num = RS.getInt(1);
//                JOptionPane.showMessageDialog(null, num);
                count = num;
            }

            if (count <= 1) {
                jTextField3.setVisible(false);
                jTextField4.setVisible(false);
                jTextField5.setVisible(false);
                jTextField7.setVisible(false);
                jTextField9.setVisible(false);
                jTextField11.setVisible(false);
                jTextField12.setVisible(false);
                jTextField13.setVisible(false);
                jTextField14.setVisible(false);
                name.setVisible(true);
                oi.setVisible(true);
                mail.setVisible(true);
                nic.setVisible(true);
                mob.setVisible(true);
                vechiletype.setVisible(true);
                noofvechile.setVisible(true);
                VechileNO.setVisible(true);
                vechilemodel.setVisible(true);
                jLabel4.setVisible(true);

                try {
                    conn = dbconnection.getConnetion();
                    PST = conn.prepareStatement("SELECT * FROM flatowner,flat Where flatowner.ownerid=flat.ownerid and flat.ownerid=?");
                    PST.setString(1, jList1.getSelectedValue());
                    RS = PST.executeQuery();
                    if (RS.next());
                    {
                        name.setText(RS.getString("name"));
                        oi.setText(RS.getString("ownerid"));
                        vechiletype.setText(RS.getString("vechiletype"));
                        vechilemodel.setText(RS.getString("vechile_model"));
                        noofvechile.setText(RS.getString("no_of_vechile"));
                        String gender = RS.getString("gender");
                        if (gender.equals("Male")) {
                            male.setSelected(true);
                        } else if (gender.equals("Female")) {
                            female.setSelected(true);
                        }
                        mob.setText(RS.getString("phone"));
                        mail.setText(RS.getString("email"));

                        VechileNO.setText(RS.getString("vechile_no"));
                        nic.setText(RS.getString("Nic"));
                        jComboBox4.addItem(RS.getString("type"));
                        jComboBox2.addItem(RS.getString("floor"));
                        jComboBox3.addItem(RS.getString("flatno"));
                        jLabel4.setIcon(ResizeImage(null, RS.getBytes("image")));
                    }
                } catch (SQLException ex) {
                    //  Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, ex);

                }

            } else {
                JComboBox optionList = new JComboBox();
                Object[] message
                        = {"<html><font size=\"5\" color=\"blue\">You have so many flats" + "<br>" + " You select which flat details see now</font></html>",
                            "flaatnumber", optionList,};

                try {
                    conn = dbconnection.getConnetion();
                    PST = conn.prepareStatement("select flatno from flat where ownerid='" + s + "'");
                    RS = PST.executeQuery();
                    while (RS.next()) {
                        String did = RS.getString("flatno");
                        optionList.addItem(did);
                    }
                    JOptionPane.showMessageDialog(null, message, "Flat number verification", JOptionPane.QUESTION_MESSAGE);
                    String r = optionList.getSelectedItem().toString();
                    jTextField3.setVisible(false);
                    jTextField4.setVisible(false);
                    jTextField5.setVisible(false);
                    jTextField7.setVisible(false);
                    jTextField9.setVisible(false);
                    jTextField11.setVisible(false);
                    jTextField12.setVisible(false);
                    jTextField13.setVisible(false);
                    jTextField14.setVisible(false);
                    name.setVisible(true);
                    oi.setVisible(true);
                    mail.setVisible(true);
                    nic.setVisible(true);
                    mob.setVisible(true);
                    vechiletype.setVisible(true);
                    noofvechile.setVisible(true);
                    VechileNO.setVisible(true);
                    vechilemodel.setVisible(true);
                    jLabel4.setVisible(true);
                    try {
                        conn = dbconnection.getConnetion();
                        PST = conn.prepareStatement("SELECT * FROM flatowner Where ownerid=?");
                        PST.setString(1, jList1.getSelectedValue());
                        RS = PST.executeQuery();
                        if (RS.next());
                        {
                            name.setText(RS.getString("name"));
                            oi.setText(RS.getString("ownerid"));
                            vechiletype.setText(RS.getString("vechiletype"));
                            vechilemodel.setText(RS.getString("vechile_model"));
                            noofvechile.setText(RS.getString("no_of_vechile"));
                            String gender = RS.getString("gender");
                            if (gender.equals("Male")) {
                                male.setSelected(true);
                            } else if (gender.equals("Female")) {
                                female.setSelected(true);
                            }
                            mob.setText(RS.getString("phone"));
                            mail.setText(RS.getString("email"));

                            VechileNO.setText(RS.getString("vechile_no"));
                            nic.setText(RS.getString("Nic"));
                            jLabel4.setIcon(ResizeImage(null, RS.getBytes("image")));
                        }
                    } catch (SQLException ex) {
                        //  Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, ex);

                    }

                    try {
                        conn = dbconnection.getConnetion();
                        PST = conn.prepareStatement("SELECT * FROM flat Where flatno=?");
                        PST.setString(1, r);
                        RS = PST.executeQuery();
                        if (RS.next());
                        {
                            jComboBox4.addItem(RS.getString("type"));
                            jComboBox2.addItem(RS.getString("floor"));
                            jComboBox3.addItem(RS.getString("flatno"));
                        }
                    } catch (SQLException ex) {
                        //  Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, ex);

                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);

                }

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        jList1.setVisible(false);
        jScrollPane2.setVisible(false);
        update.setVisible(true);
        delete.setVisible(true);
    }//GEN-LAST:event_jList1MouseClicked

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
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField VechileNO;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton delete;
    private javax.swing.JRadioButton female;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField mail1;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField mob;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nic;
    private javax.swing.JTextField noofvechile;
    public static javax.swing.JTextField oi;
    private javax.swing.JTextField ow;
    public static javax.swing.JTextField regisaddmin;
    private javax.swing.JButton update;
    private javax.swing.JTextField vechilemodel;
    private javax.swing.JTextField vechiletype;
    // End of variables declaration//GEN-END:variables

    private void showdate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String day = (formatter.format(date));
        jLabel2.setText(day);
    }

    private void visible() {
        name.setVisible(false);
        oi.setVisible(false);
        mail.setVisible(false);
        mob.setVisible(false);
        nic.setVisible(false);
        vechilemodel.setVisible(false);
        VechileNO.setVisible(false);
        noofvechile.setVisible(false);
        vechiletype.setVisible(false);

    }

    private void comloadowner() {

        jList1.setModel(Model);

        try {
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement("select distinct ownerid from flatowner where ownerid like '" + jTextField2.getText() + "%' ");
            RS = PST.executeQuery();
            while (RS.next()) {
                String did = RS.getString("ownerid");
                Model.addElement(did);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
    }

    private void comloadtype() {
        try {
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement(" select type from flat where position=\"Avaliable\" group by type");
            RS = PST.executeQuery();
            while (RS.next()) {
                String did = RS.getString("type");
                jComboBox4.addItem(did);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
    }

    private void showdepth() {
        ArrayList<ownertable> list = userlist();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[11];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getownerd();
            row[2] = list.get(i).getemail();
            row[3] = list.get(i).getphone();
            row[4] = list.get(i).getNic();
            row[5] = list.get(i).getgender();
            row[6] = list.get(i).getvechiletype();
            row[7] = list.get(i).getvechile_model();
            row[8] = list.get(i).getno_of_vechile();
            row[9] = list.get(i).getVechile_no();

            model.addRow(row);
        }
    }

    private void showdepthowneridlike() {
        ArrayList<ownertable> list = userlist1();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[11];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getownerd();
            row[2] = list.get(i).getemail();
            row[3] = list.get(i).getphone();
            row[4] = list.get(i).getNic();
            row[5] = list.get(i).getgender();
            row[6] = list.get(i).getvechiletype();
            row[7] = list.get(i).getvechile_model();
            row[8] = list.get(i).getno_of_vechile();
            row[9] = list.get(i).getVechile_no();

            model.addRow(row);
        }

    }

    private void showdepthownername() {
        ArrayList<ownertable> list = userlist1();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[11];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getownerd();
            row[2] = list.get(i).getemail();
            row[3] = list.get(i).getphone();
            row[4] = list.get(i).getNic();
            row[5] = list.get(i).getgender();
            row[6] = list.get(i).getvechiletype();
            row[7] = list.get(i).getvechile_model();
            row[8] = list.get(i).getno_of_vechile();
            row[9] = list.get(i).getVechile_no();

            model.addRow(row);
        }
    }

    private void showbill() {
        ArrayList<billtable> list = userlistbill();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        Object[] row = new Object[2];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getDetail();
            row[1] = list.get(i).getAmount();
            model.addRow(row);
        }
    }

    private Icon ResizeImage(String Imagepath, byte[] pic) {
        ImageIcon MyImage = null;
        if (Imagepath != null) {
            MyImage = new ImageIcon(Imagepath);
        } else {
            MyImage = new ImageIcon(pic);
        }
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;

    }
    String Imagepath;

}
