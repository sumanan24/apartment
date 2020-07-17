/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartment_management;

import static apartment_management.register.jTextField1;
import static apartment_management.register.regisaddmin;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.media.util.BufferToImage;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import static mondrian.olap.fun.vba.Vba.date;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class bill extends javax.swing.JFrame {

    private int pay;
    ArrayList name1 = new ArrayList();
    Statement st;
    Connection conn = null;
    PreparedStatement PST = null;
    ResultSet RS = null;
    public String flatno;

    /**
     * Creates new form bill
     */
    public bill() {
        initComponents();
        this.setDefaultCloseOperation(bill.DISPOSE_ON_CLOSE);
        visible();
//        jList1.setVisible(false);
//        jScrollPane1.setVisible(false);
        showdepthinvoice();
        showdepth();
        comloadownerid();

    }
    // full invoice

    public ArrayList<billtableshow> userlist21() {
        ArrayList<billtableshow> userlist21 = new ArrayList<>();
//        try {
//            conn = dbconnection.getConnetion();
//            PST = conn.prepareStatement("SELECT MONTH(CURDATE())-MONTH(date) from invoice");
//            PST.setString(1, jList1.getSelectedValue());
//            RS = PST.executeQuery();
//            
//            while (RS.next()) {
//                int num = RS.getInt(1);
////                JOptionPane.showMessageDialog(null, num);
//                if (num == 0) {
//                    try {
//                        conn = dbconnection.getConnetion();
//                        String query1 = ("SELECT * FROM invoice");
//                        java.sql.Statement st = conn.createStatement();
//                        ResultSet RS = st.executeQuery(query1);
//                        billtableshow billtableshow;
//                        while (RS.next()) {
//                            billtableshow = new billtableshow(RS.getString("billno"), RS.getString("ownerid"), RS.getString("date"), RS.getString("total"), RS.getString("status"));
//                            userlist21.add(billtableshow);
//                        }
//                    } catch (SQLException ex) {
//                        JOptionPane.showMessageDialog(null, ex);
//                    }
//                }
//                
//            }
//            
//        } catch (SQLException e) {
//        }

        try {
            conn = dbconnection.getConnetion();
            String query1 = ("select*from invoice ");
            java.sql.Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(query1);
            billtableshow billtableshow;
            while (RS.next()) {
                billtableshow = new billtableshow(RS.getString("billno"), RS.getString("ownerid"), RS.getString("date"), RS.getString("total"), RS.getString("status"));
                userlist21.add(billtableshow);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return userlist21;
    }

    public ArrayList<billtableshow> userlistbillike() {
        ArrayList<billtableshow> userlistbillike = new ArrayList<>();
        try {
            conn = dbconnection.getConnetion();
            String s1 = jTextField3.getText().trim();
            String query1 = ("SELECT * FROM invoice where billno like '" + s1 + "%'");
            java.sql.Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(query1);
            billtableshow billtableshow;
            while (RS.next()) {
                billtableshow = new billtableshow(RS.getString("billno"), RS.getString("ownerid"), RS.getString("date"), RS.getString("total"), RS.getString("status"));
                userlistbillike.add(billtableshow);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return userlistbillike;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        Billno = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        oiwner = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        Name = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jTextField8 = new javax.swing.JTextField();
        Amount1 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        det = new javax.swing.JTextField();
        detail1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>()
        ;
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        billownerid = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable()
        {
            @Override
            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                switch(columnIndex) {
                    case 0:
                    if(getValueAt(rowIndex, 4).toString().equals("Paid")){
                        componenet.setForeground(Color.GREEN.darker().darker());}else{componenet.setForeground(Color.RED);}
                    break;
                    case 1:
                    if(getValueAt(rowIndex, 4).toString().equals("Paid")){
                        componenet.setForeground(Color.GREEN.darker().darker());}else{componenet.setForeground(Color.RED);}
                    break;
                    case 2:
                    if(getValueAt(rowIndex, 4).toString().equals("Paid")){
                        componenet.setForeground(Color.GREEN.darker().darker());}else{componenet.setForeground(Color.RED);}
                    break;
                    case 3:
                    if(getValueAt(rowIndex, 4).toString().equals("Paid")){
                        componenet.setForeground(Color.GREEN.darker().darker());}else{componenet.setForeground(Color.RED);}
                    break;
                    case 4:
                    if(getValueAt(rowIndex, 4).toString().equals("Paid")){
                        componenet.setForeground(Color.GREEN.darker().darker());}else{componenet.setForeground(Color.RED);}
                    break;
                    default:
                    if(getValueAt(rowIndex, 4).toString().equals("Paid")){
                        componenet.setForeground(Color.BLACK);} else{componenet.setForeground(Color.BLACK);}
                }

                return componenet;
            }
        }

        ;
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        billname = new javax.swing.JTextField();
        onno = new javax.swing.JTextField();
        billname1 = new javax.swing.JTextField();
        billid1 = new javax.swing.JTextField();
        billid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(5, 74, 117));

        jPanel3.setBackground(new java.awt.Color(5, 74, 117));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bill  Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(null);

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(102, 102, 102));
        jTextField2.setText("   Bill No");
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
        jPanel4.add(jTextField2);
        jTextField2.setBounds(0, 0, 290, 40);

        Billno.setEditable(false);
        Billno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Billno.setBorder(javax.swing.BorderFactory.createTitledBorder("Bill No"));
        Billno.setEnabled(false);
        Billno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BillnoMouseExited(evt);
            }
        });
        Billno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillnoActionPerformed(evt);
            }
        });
        jPanel4.add(Billno);
        Billno.setBounds(0, 0, 290, 40);

        jPanel7.setBackground(new java.awt.Color(5, 74, 117));
        jPanel7.setLayout(null);

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(102, 102, 102));
        jTextField5.setText("   Owner ID");
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextField5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField5MouseMoved(evt);
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
        jPanel7.add(jTextField5);
        jTextField5.setBounds(0, 0, 290, 40);

        oiwner.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oiwner.setBorder(javax.swing.BorderFactory.createTitledBorder("Owner ID"));
        oiwner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                oiwnerMouseExited(evt);
            }
        });
        oiwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oiwnerActionPerformed(evt);
            }
        });
        oiwner.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                oiwnerKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                oiwnerKeyTyped(evt);
            }
        });
        jPanel7.add(oiwner);
        oiwner.setBounds(0, 0, 290, 40);

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setLayout(null);

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(255, 255, 255));
        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(102, 102, 102));
        jTextField6.setText("   Owner Name");
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
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
        jPanel8.add(jTextField6);
        jTextField6.setBounds(0, 0, 290, 40);

        Name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Name.setBorder(javax.swing.BorderFactory.createTitledBorder("Owner Name"));
        Name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NameMouseExited(evt);
            }
        });
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        Name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NameKeyTyped(evt);
            }
        });
        jPanel8.add(Name);
        Name.setBounds(0, 0, 290, 40);

        jPanel7.add(jPanel8);
        jPanel8.setBounds(0, 80, 290, 40);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paid", "Not Paid" }));
        jComboBox1.setBorder(null);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setLayout(null);

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(255, 255, 255));
        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(102, 102, 102));
        jTextField7.setText("   Total Amount");
        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
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
        jPanel9.add(jTextField7);
        jTextField7.setBounds(0, 0, 290, 40);

        total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        total.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Amount"));
        total.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                totalMouseExited(evt);
            }
        });
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });
        jPanel9.add(total);
        total.setBounds(0, 0, 290, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apartment_management/img/ic_print1234.png"))); // NOI18N
        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apartment_management/img/Previous1234.png"))); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Details", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel10.setBackground(new java.awt.Color(60, 104, 200));
        jPanel10.setLayout(null);

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(255, 255, 255));
        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(102, 102, 102));
        jTextField8.setText("     Amount");
        jTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextField8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField8MouseMoved(evt);
            }
        });
        jTextField8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField8MouseClicked(evt);
            }
        });
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });
        jPanel10.add(jTextField8);
        jTextField8.setBounds(0, 0, 270, 40);

        Amount1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Amount1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Amount", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        Amount1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Amount1MouseExited(evt);
            }
        });
        Amount1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Amount1ActionPerformed(evt);
            }
        });
        Amount1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Amount1KeyTyped(evt);
            }
        });
        jPanel10.add(Amount1);
        Amount1.setBounds(0, 0, 270, 40);

        jPanel11.setBackground(new java.awt.Color(60, 104, 200));
        jPanel11.setLayout(null);

        det.setEditable(false);
        det.setBackground(new java.awt.Color(255, 255, 255));
        det.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        det.setForeground(new java.awt.Color(102, 102, 102));
        det.setText("     Detail");
        det.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        det.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                detMouseMoved(evt);
            }
        });
        det.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detMouseClicked(evt);
            }
        });
        det.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detActionPerformed(evt);
            }
        });
        det.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                detKeyTyped(evt);
            }
        });
        jPanel11.add(det);
        det.setBounds(0, 0, 270, 40);

        detail1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        detail1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        detail1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                detail1MouseExited(evt);
            }
        });
        detail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detail1ActionPerformed(evt);
            }
        });
        detail1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                detail1KeyTyped(evt);
            }
        });
        jPanel11.add(detail1);
        detail1.setBounds(0, 0, 270, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apartment_management/img/add1234.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(5, 74, 117));
        jLabel2.setForeground(new java.awt.Color(5, 74, 117));
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(56, 56, 56)
                            .addComponent(jButton3))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 293, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jList1.setBackground(new java.awt.Color(3, 53, 84));
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Details");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bill", jPanel5);

        jPanel1.setBackground(new java.awt.Color(5, 74, 117));
        jPanel1.setLayout(null);

        billownerid.setBackground(new java.awt.Color(5, 74, 117));
        billownerid.setForeground(new java.awt.Color(5, 74, 117));
        billownerid.setText("jTextField1");
        billownerid.setBorder(null);
        jPanel1.add(billownerid);
        billownerid.setBounds(300, 70, 55, 14);

        jPanel2.setBackground(new java.awt.Color(5, 74, 117));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(null);

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bill no", "Owner ID", "Date", "amount", "Status"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(10, 120, 870, 360);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Bill no");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(40, 50, 50, 15);

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });
        jPanel2.add(jTextField3);
        jTextField3.setBounds(30, 80, 80, 20);

        billname.setEditable(false);
        billname.setBackground(new java.awt.Color(5, 74, 117));
        billname.setForeground(new java.awt.Color(5, 74, 117));
        billname.setBorder(null);
        jPanel2.add(billname);
        billname.setBounds(630, 20, 100, 14);

        onno.setBackground(new java.awt.Color(5, 74, 117));
        onno.setForeground(new java.awt.Color(5, 74, 117));
        onno.setBorder(null);
        jPanel2.add(onno);
        onno.setBounds(660, 50, 70, 14);

        billname1.setEditable(false);
        billname1.setBackground(new java.awt.Color(5, 74, 117));
        billname1.setForeground(new java.awt.Color(5, 74, 117));
        billname1.setBorder(null);
        jPanel2.add(billname1);
        billname1.setBounds(530, 20, 100, 14);

        billid1.setEditable(false);
        billid1.setBackground(new java.awt.Color(5, 74, 117));
        billid1.setForeground(new java.awt.Color(5, 74, 117));
        billid1.setBorder(null);
        jPanel2.add(billid1);
        billid1.setBounds(200, 20, 100, 10);

        billid.setEditable(false);
        billid.setBackground(new java.awt.Color(5, 74, 117));
        billid.setForeground(new java.awt.Color(5, 74, 117));
        billid.setBorder(null);
        jPanel2.add(billid);
        billid.setBounds(240, 30, 100, 14);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(jLabel1);
        jLabel1.setBounds(740, 20, 130, 30);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Details");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(750, 70, 110, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 10, 900, 500);

        jTabbedPane1.addTab("View", jPanel1);

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

    private void jTextField2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseMoved
        jTextField2.setVisible(false);
        Billno.setVisible(true);
        Billno.requestFocus();

    }//GEN-LAST:event_jTextField2MouseMoved

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        Billno.setText("");
        jTextField2.setVisible(false);
        Billno.setVisible(true);
        Billno.requestFocus();
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyTyped

    private void BillnoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BillnoMouseExited
        if ("".equals(Billno.getText())) {
            Billno.setVisible(false);
            jTextField2.setVisible(true);
        } else {
            Billno.setVisible(true);
            jTextField2.setVisible(false);
        }
    }//GEN-LAST:event_BillnoMouseExited

    private void BillnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BillnoActionPerformed

    private void jTextField5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5MouseMoved

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        oiwner.setText("");
        if (onno.getText().equals("1")) {
            load();
        } else {
            jTextField5.setVisible(false);
            oiwner.setVisible(true);
            oiwner.requestFocus();
        }
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyTyped

    private void oiwnerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oiwnerMouseExited
        if ("".equals(oiwner.getText())) {
            oiwner.setVisible(false);
            jTextField5.setVisible(true);
        } else {
            oiwner.setVisible(true);
            jTextField5.setVisible(false);
        }
    }//GEN-LAST:event_oiwnerMouseExited

    private void oiwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oiwnerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oiwnerActionPerformed

    private void jTextField6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6MouseMoved

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        Name.setText("");
        jTextField6.setVisible(false);
        Name.setVisible(true);
        Name.requestFocus();

        try {
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement("SELECT name FROM flatowner Where ownerid=?");
            PST.setString(1, oiwner.getText());
            RS = PST.executeQuery();

            while (RS.next()) {
                String name = (RS.getString("name"));
                Name.setText(name);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyTyped

    private void NameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameMouseExited
        if ("".equals(Name.getText())) {
            Name.setVisible(false);
            jTextField6.setVisible(true);
        } else {
            Name.setVisible(true);
            jTextField6.setVisible(false);
        }
    }//GEN-LAST:event_NameMouseExited

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void jTextField7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7MouseMoved

    private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
        total.setText("");
        jTextField7.setVisible(false);
        total.setVisible(true);
        total.requestFocus();
    }//GEN-LAST:event_jTextField7MouseClicked

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        showdepth();
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyTyped

    private void totalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalMouseExited
        if ("".equals(total.getText())) {
            total.setVisible(false);
            jTextField7.setVisible(true);
        } else {
            total.setVisible(true);
            jTextField7.setVisible(false);
        }
    }//GEN-LAST:event_totalMouseExited

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // invoice insert   
        //.......................................
        String did = null;
        try {
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement("select * from invoice where billno=?");
            PST.setString(1, Billno.getText());
            RS = PST.executeQuery();
            if (RS.next()) {
                did = (RS.getString("billno"));
            }
        } catch (SQLException ex) {
            // JOptionPane.showMessageDialog(null, ex);
        }
        if (Billno.getText().equals(did)) {
            try {
                JasperDesign jasdi = JRXmlLoader.load("D:\\sumanan\\level5\\project\\Apartment_management\\src\\report\\bill.jrxml");
                String sql = "SELECT amount,details FROM bill WHERE billno='" + Billno.getText() + "'";
                conn = dbconnection.getConnetion();
                JRDesignQuery newQuery = new JRDesignQuery();
                newQuery.setText(sql);

                jasdi.setQuery(newQuery);
                /////////////
                HashMap<String, Object> para = new HashMap<>();
                para.put("Name", Name.getText());
                para.put("ownerid", oiwner.getText());
                para.put("total", total.getText());
                para.put("billno", Billno.getText());
                para.put("date", jLabel2.getText());
                JasperReport js = JasperCompileManager.compileReport(jasdi);
                JasperPrint jp = JasperFillManager.fillReport(js, para, conn);
                // JasperExportManager.exportReportToHtmlFile(jp ,ore);
                JasperViewer.viewReport(jp, false);

            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        } else {
//            try {
//                conn = dbconnection.getConnetion();
//                PST = conn.prepareStatement(" select * from flatowner where flatno=" + flatno + "");
//                RS = PST.executeQuery();
//                while (RS.next()) {
//                    String payment = RS.getString("status");
//
//                    int x = Integer.parseInt(payment);
//                    pay = x / 12;
//                }
//
////                JOptionPane.showMessageDialog(null, "update sucessfully!!");
//            } catch (SQLException e) {
//                //JOptionPane.showMessageDialog(null, e);
//            }

            try {
                String query = "INSERT INTO invoice(billno,ownerid,date,total,status)values(?,?,?,?,?)";
                conn = dbconnection.getConnetion();
                PST = conn.prepareStatement(query);
                PST.setString(1, Billno.getText());
                PST.setString(2, oiwner.getText());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date(System.currentTimeMillis());
                String day = (formatter.format(date));
                PST.setString(3, day);
                PST.setString(4, total.getText());
                PST.setString(5, jComboBox1.getSelectedItem().toString());
                PST.executeUpdate();
                JOptionPane.showMessageDialog(null, "Insert Successfully");
            } catch (SQLException ex) {
                System.err.println(ex);
                JOptionPane.showMessageDialog(null, "Duplicated Entry");
            }

            //////number update.........
            try {
                conn = dbconnection.getConnetion();
                PST = conn.prepareStatement(" update number set detail=? where no=\"3\";");
                PST.setString(1, Billno.getText());

                PST.executeUpdate();

                JOptionPane.showMessageDialog(null, "update sucessfully!!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }

            /// bill input coding
            try {
                JasperDesign jasdi = JRXmlLoader.load("D:\\sumanan\\level5\\project\\Apartment_management\\src\\report\\bill.jrxml");
                String sql = "SELECT amount,details FROM bill WHERE billno='" + Billno.getText() + "'";
                conn = dbconnection.getConnetion();
                JRDesignQuery newQuery = new JRDesignQuery();
                newQuery.setText(sql);

                jasdi.setQuery(newQuery);
                /////////////
                HashMap<String, Object> para = new HashMap<>();
                para.put("Name", Name.getText());
                para.put("ownerid", oiwner.getText());
                para.put("total", total.getText());
                para.put("billno", Billno.getText());
                para.put("date", jLabel1.getText());
                JasperReport js = JasperCompileManager.compileReport(jasdi);
                JasperPrint jp = JasperFillManager.fillReport(js, para, conn);
                // JasperExportManager.exportReportToHtmlFile(jp ,ore);
                JasperViewer.viewReport(jp, false);

            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }

            DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
            while (dm.getRowCount() > 0) {
                dm.removeRow(0);
            }
            showdepthinvoice();
        }
        DefaultTableModel dm = (DefaultTableModel) jTable2.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
        jTextField2.setVisible(true);
        jTextField5.setVisible(true);
        jTextField6.setVisible(true);
        jTextField7.setVisible(true);
        jList1.removeAll();
        comloadownerid();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String query = "INSERT INTO bill(billno,date,amount,details)values(?,?,?,?)";
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement(query);
            PST.setString(1, Billno.getText());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());
            String day = (formatter.format(date));
            PST.setString(2, day);
            PST.setString(3, Amount1.getText());

            PST.setString(4, detail1.getText());
            PST.executeUpdate();
            JOptionPane.showMessageDialog(null, "Insert Successfully");
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Duplicated Entry");
        }

        DefaultTableModel dm = (DefaultTableModel) jTable2.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
        showdepth();
        jTextField7.setVisible(false);
        int sum = 0;
        for (int i = 0; i < jTable2.getRowCount(); i++) {
            sum = sum + Integer.parseInt(jTable2.getValueAt(i, 1).toString());
        }
        total.setVisible(true);
        total.setText(Integer.toString(sum));
//        String n1=Amount1.getText();
//        String n2=total.getText();
//        int m1=Integer.parseInt(n1);
//        int m2=Integer.parseInt(n2);
//        int sum=m1+m2;
//        String tot=Integer.toString(sum);
//        total.setText(tot);

        det.setVisible(true);
        jTextField8.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (onno.getText().equals("1")) {
            this.dispose();  
        } else {
            this.dispose();
            menu m = new menu();
            m.setVisible(true);
            m.jLabel5.setText(billid.getText());
            m.jLabel7.setText(billname.getText());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField8MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8MouseMoved

    private void jTextField8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MouseClicked
        Amount1.setText("");
        jTextField8.setVisible(false);
        Amount1.setVisible(true);
        Amount1.requestFocus();
    }//GEN-LAST:event_jTextField8MouseClicked

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8KeyTyped

    private void Amount1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Amount1MouseExited
        if ("".equals(Amount1.getText())) {
            Amount1.setVisible(false);
            jTextField8.setVisible(true);
        } else {
            Amount1.setVisible(true);
            jTextField8.setVisible(false);
        }
    }//GEN-LAST:event_Amount1MouseExited

    private void Amount1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Amount1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Amount1ActionPerformed

    private void detMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_detMouseMoved

    private void detMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detMouseClicked
        detail1.setText("");
        det.setVisible(false);
        detail1.setVisible(true);
        detail1.requestFocus();
    }//GEN-LAST:event_detMouseClicked

    private void detActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detActionPerformed

    private void detKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_detKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_detKeyTyped

    private void detail1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detail1MouseExited
        if ("".equals(detail1.getText())) {
            detail1.setVisible(false);
            det.setVisible(true);
        } else {
            detail1.setVisible(true);
            det.setVisible(false);
        }
    }//GEN-LAST:event_detail1MouseExited

    private void detail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detail1ActionPerformed

    private void oiwnerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oiwnerKeyTyped

        if (oiwner.getText().length() >= 8) {
            evt.consume();
        }

    }//GEN-LAST:event_oiwnerKeyTyped

    private void oiwnerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oiwnerKeyReleased

    }//GEN-LAST:event_oiwnerKeyReleased

    private void NameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameKeyTyped
        if (Name.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_NameKeyTyped

    private void detail1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_detail1KeyTyped
        if (detail1.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_detail1KeyTyped

    private void Amount1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Amount1KeyTyped
        String phone = Amount1.getText();
        int length = phone.length();
        char c = evt.getKeyChar();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (length < 10) {
                Amount1.setEditable(true);
            } else {
                Amount1.setEditable(false);
            }
        } else {
            if ((Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                Amount1.setEditable(true);

            } else {
                Amount1.setEditable(false);
            }
        }
    }//GEN-LAST:event_Amount1KeyTyped

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
        showbillnolke();
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jTabbedPane1.setSelectedIndex(0);
        jButton4.setVisible(true);
        jTextField2.setVisible(false);
        jTextField5.setVisible(false);
        jTextField7.setVisible(false);
        Billno.setVisible(true);
        oiwner.setVisible(true);
        total.setVisible(true);
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int selectedRowIndex = jTable1.getSelectedRow();
            Billno.setText(model.getValueAt(selectedRowIndex, 0).toString());
            oiwner.setText(model.getValueAt(selectedRowIndex, 1).toString());
            total.setText(model.getValueAt(selectedRowIndex, 3).toString());
            jComboBox1.setSelectedItem(model.getValueAt(selectedRowIndex, 4).toString());
            jLabel2.setText(model.getValueAt(selectedRowIndex, 2).toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement("select name from flatowner where ownerid=?");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int selectedRowIndex = jTable1.getSelectedRow();
            PST.setString(1, model.getValueAt(selectedRowIndex, 1).toString());
//            PST.setString(1, jTextField8.getText());
            RS = PST.executeQuery();
            while (RS.next()) {
                jTextField6.setVisible(false);
                Name.setVisible(true);
                Name.setText(RS.getString("name"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }


    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed

    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        jButton4.setVisible(false);
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        jButton4.setVisible(false);
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        String nameorg = null;
        String org1 = null;
        String genderorg = null;
        String flatorg = null;
        String emailorg = null;
        String nicorg = null;
        int number=0;
        try {

            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement("select count(ownerid) from flat where ownerid=?");
            PST.setString(1, jList1.getSelectedValue());
            RS = PST.executeQuery();
            while (RS.next()) {
                number=RS.getInt("count(ownerid)");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
         flatorg=String.valueOf(number);
        try {

            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement(" select ownerid from invoice where  ownerid=? and month(curdate())-month(date)=0;");
            PST.setString(1, jList1.getSelectedValue());
            RS = PST.executeQuery();
            while (RS.next()) {
                org1 = RS.getString("ownerid");
            }
            if (jList1.getSelectedValue().equals(org1)) {
                JOptionPane.showMessageDialog(null, "This ID this month already paid ");
            } else {
                try {
                    conn = dbconnection.getConnetion();
                    PST = conn.prepareStatement("select * from flatowner where ownerid=?");
                    PST.setString(1, jList1.getSelectedValue());
                    RS = PST.executeQuery();
                    if (RS.next()) {
                        nameorg = (RS.getString("vechiletype"));
//                        genderorg = (RS.getString("vechile_model"));
//                        moborg = (RS.getString("no_of_vechile"));
//                        nicorg = (RS.getString("vechile_no"));
//                BufferedImage im = ImageIO.read(RS.getBinaryStream("Image"));
//                n.setIcon(new ImageIcon(im));
                    }
                    if (nameorg.equals("empty")) {
                        JOptionPane.showMessageDialog(null, "<html><b>This owner has  -:     </font> " + flatorg + "<font style=" + "color:red;" + ">Flats</font><br></b></html>", "Details", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("D:\\sumanan\\level5\\project\\Apartment_management\\src\\apartment_management\\logo.png"));
                        jTextField2.setVisible(false);
                        jTextField5.setVisible(false);
                        jTextField6.setVisible(false);
                        Billno.setVisible(true);
                        oiwner.setVisible(true);
                        Name.setVisible(true);
                        try {

                            conn = dbconnection.getConnetion();
                            PST = conn.prepareStatement("select * from flatowner where ownerid=?");
                            PST.setString(1, jList1.getSelectedValue());
                            RS = PST.executeQuery();
                            while (RS.next()) {
                                oiwner.setText(RS.getString("ownerid"));
                                Name.setText(RS.getString("name"));

                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        }

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
                                String org = Integer.toString(no1);
                                Billno.setText("B" + org);
                            }

                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "<html><b><font style=" + "color:red;" + ">Parking vechile details  -:     </font> " + nameorg + "<br><font style=" + "color:red;" + ">This owner has  -:     </font> " + flatorg + "<font style=" + "color:red;" + ">Flats</font><br></b></html>", "Details", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("D:\\sumanan\\level5\\project\\Apartment_management\\src\\apartment_management\\logo.png"));
                        jTextField2.setVisible(false);
                        jTextField5.setVisible(false);
                        jTextField6.setVisible(false);
                        Billno.setVisible(true);
                        oiwner.setVisible(true);
                        Name.setVisible(true);
                        try {

                            conn = dbconnection.getConnetion();
                            PST = conn.prepareStatement("select * from flatowner where ownerid=?");
                            PST.setString(1, jList1.getSelectedValue());
                            RS = PST.executeQuery();
                            while (RS.next()) {
                                oiwner.setText(RS.getString("ownerid"));
                                Name.setText(RS.getString("name"));

                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        }

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
                                String org = Integer.toString(no1);
                                Billno.setText("B" + org);
                            }

                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }


    }//GEN-LAST:event_jList1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String nameorg = null;
        String oiorg = null;
        String genderorg = null;
        String moborg = null;
        String emailorg = null;
        String nicorg = null;

        try {
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement("select * from flatowner where ownerid=?");
            PST.setString(1, jList1.getSelectedValue());
            RS = PST.executeQuery();

            while (RS.next()) {
                nameorg = (RS.getString("name"));
                genderorg = (RS.getString("gender"));
                moborg = (RS.getString("phone"));
                emailorg = (RS.getString("email"));
                nicorg = (RS.getString("Nic"));
//                BufferedImage im = ImageIO.read(RS.getBinaryStream("Image"));
//                n.setIcon(new ImageIcon(im));

            }
            JOptionPane.showMessageDialog(null, "<html><b><font color=rgb(0, 0, 255) font size=\"4\"font face=\"Times New Roman\">Name    -: " + nameorg + " <br> Gender  -: " + genderorg + "<br>phone   - : " + moborg + "<br>Email   - :" + emailorg + "<br> NIC     -:" + nicorg + "<br> </font></b></html>", "Details", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("D:\\sumanan\\level5\\project\\Apartment_management\\src\\apartment_management\\logo.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
//         catch (IOException ex) {
//            Logger.getLogger(bill.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String nameorg = null;
        String oiorg = null;
        String genderorg = null;
        String moborg = null;
        String emailorg = null;
        String nicorg = null;
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int selectedRowIndex = jTable1.getSelectedRow();
            //            (model.getValueAt(selectedRowIndex, 0).toString());
            oiorg = (model.getValueAt(selectedRowIndex, 1).toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement("select * from flatowner where ownerid=?");
            PST.setString(1, oiorg);
            RS = PST.executeQuery();

            if (RS.next()) {
                nameorg = (RS.getString("name"));
                genderorg = (RS.getString("gender"));
                moborg = (RS.getString("phone"));
                emailorg = (RS.getString("email"));
                nicorg = (RS.getString("Nic"));
            }
            JOptionPane.showMessageDialog(null, "<html><b><font color=rgb(0, 0, 255) font size=\"4\"font face=\"Times New Roman\">Name    -: " + nameorg + "<br> Ownerid -: " + oiorg + " <br> Gender  -: " + genderorg + "<br>phone   - : " + moborg + "<br>Email   - :" + emailorg + "<br> NIC     -:" + nicorg + " </font></b></html>", "Details", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("D:\\sumanan\\level5\\project\\Apartment_management\\src\\apartment_management\\logo.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed
    public ArrayList<billtable> userlist() {
        ArrayList<billtable> userlist = new ArrayList<>();
        try {
            register r = new register();
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement("select * from bill where billno=?");
            PST.setString(1, Billno.getText());

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
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField Amount1;
    public static javax.swing.JTextField Billno;
    public static javax.swing.JTextField Name;
    public static javax.swing.JTextField billid;
    public static javax.swing.JTextField billid1;
    public static javax.swing.JTextField billname;
    public static javax.swing.JTextField billname1;
    public static javax.swing.JTextField billownerid;
    public static javax.swing.JTextField det;
    public static javax.swing.JTextField detail1;
    public static javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTable jTable2;
    public static javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    public static javax.swing.JTextField jTextField5;
    public static javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    public static javax.swing.JTextField jTextField8;
    public static javax.swing.JTextField oiwner;
    public static javax.swing.JTextField onno;
    public static javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables

    private void visible() {
        Billno.setVisible(false);
//        oiw.setVisible(false);
        Name.setVisible(false);
        Amount1.setVisible(false);
        detail1.setVisible(false);
        total.setVisible(false);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String d = (formatter.format(date));
        jLabel1.setText(d);
    }

    private void showdepth() {
        ArrayList<billtable> list = userlist();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        Object[] row = new Object[2];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getDetail();
            row[1] = list.get(i).getAmount();
            model.addRow(row);
        }
    }

    private void load() {

    }

    private void comloadownerid() {
        String did = null;
        DefaultListModel Model = new DefaultListModel();
        jList1.setModel(Model);
        try {
            conn = dbconnection.getConnetion();
            PST = conn.prepareStatement("select distinct ownerid from invoice where month(curdate())-month(date)=1 or year(curdate())-year(date) order by date desc ");
            RS = PST.executeQuery();
            while (RS.next()) {
                did = RS.getString("ownerid");
                Model.addElement(did);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
//        try {
//            conn = dbconnection.getConnetion();
//            PST = conn.prepareStatement("select distinct ownerid from invoice where month(date)-month(curdate())=0 and  year(date)-year(curdate())=0; ");
//            RS = PST.executeQuery();
//            while (RS.next()) {
//               did.setForeground(Color.red);
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//
//        }

    }

    private void showdepthinvoice() {
        ArrayList<billtableshow> list = userlist21();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[5];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getbillno();
            row[1] = list.get(i).getownerid();
            row[2] = list.get(i).getdate();
            row[3] = list.get(i).gettotal();
            row[4] = list.get(i).getstatus();
            model.addRow(row);
        }

    }

    private void showbillnolke() {
        ArrayList<billtableshow> list = userlistbillike();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[5];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getbillno();
            row[1] = list.get(i).getownerid();
            row[2] = list.get(i).getdate();
            row[3] = list.get(i).gettotal();
            row[4] = list.get(i).getstatus();
            model.addRow(row);
        }
    }

}
