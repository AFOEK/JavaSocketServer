package javaserver;

import java.awt.Color;
import java.io.BufferedReader;
import java.net.Socket;
import java.io.IOException;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class MainFrm extends javax.swing.JFrame {

    private int port;
    private String ip;
    private ServerSocket svr;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    ButtonGroup butt_grup;
    private String msg, s, END_CHAT_SESSION;
    
    public void print(){
        System.out.println("TEST_ONLY_DELETE_THIS_LINE");
    }
    
    public MainFrm() {
        initComponents();
        lbl_stat.setText("Disconnected"); //INIT
        butt_grup = new ButtonGroup(); //SETUP RadioButtonGroup
        butt_grup.add(rad_server); //Add RadioButton to RadioButtonGroup
        butt_grup.add(rad_client);
        rad_server.setActionCommand("Server"); //Set String Action
        rad_client.setActionCommand("Client");
        txt_msg.setEnabled(false); //Fancy UX Flow
        txtmulti_out.setEnabled(false);
        butt_send.setEnabled(false);
        butt_dc.setEnabled(false);
        rad_server.setSelected(true);
        rad_client.setSelected(false);
        END_CHAT_SESSION = String.valueOf(0);
        s = null;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_ip = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_port = new javax.swing.JTextField();
        butt_connect = new javax.swing.JButton();
        butt_dc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtmulti_out = new javax.swing.JTextArea();
        txt_msg = new javax.swing.JTextField();
        butt_send = new javax.swing.JButton();
        lbl_stat = new javax.swing.JLabel();
        rad_server = new javax.swing.JRadioButton();
        rad_client = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setText("IP:");
        jLabel1.setToolTipText("");

        txt_ip.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        txt_ip.setName("txt_ip"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("Port: ");

        txt_port.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        txt_port.setAutoscrolls(false);
        txt_port.setName("txt_port"); // NOI18N

        butt_connect.setIcon(new javax.swing.ImageIcon("/home/afoek/Documents/Java/JavaServer/Assets/icons8-connected-48.png")); // NOI18N
        butt_connect.setName("butt_connect"); // NOI18N
        butt_connect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butt_connectMouseClicked(evt);
            }
        });

        butt_dc.setIcon(new javax.swing.ImageIcon("/home/afoek/Documents/Java/JavaServer/Assets/icons8-disconnected-48.png")); // NOI18N
        butt_dc.setName("butt_dc"); // NOI18N
        butt_dc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butt_dcMouseClicked(evt);
            }
        });

        txtmulti_out.setEditable(false);
        txtmulti_out.setColumns(20);
        txtmulti_out.setLineWrap(true);
        txtmulti_out.setRows(1);
        txtmulti_out.setFocusable(false);
        txtmulti_out.setName("txtmulti_out"); // NOI18N
        jScrollPane1.setViewportView(txtmulti_out);

        txt_msg.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txt_msg.setName("txt_pesan"); // NOI18N

        butt_send.setText("Send");
        butt_send.setName("butt_send"); // NOI18N
        butt_send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butt_sendMouseClicked(evt);
            }
        });

        lbl_stat.setName("lbl_stat"); // NOI18N

        rad_server.setText("Server");
        rad_server.setName("rad_server"); // NOI18N

        rad_client.setText("Client");
        rad_client.setName("rad_client"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txt_msg, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(butt_send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rad_server, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rad_client, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(79, 79, 79))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(39, 39, 39)
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_port, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(butt_connect, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)))
                            .addComponent(butt_dc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_stat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butt_dc)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_port)
                        .addComponent(txt_ip)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(butt_connect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rad_client, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rad_server, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_msg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butt_send))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_stat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butt_connectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butt_connectMouseClicked
        try{
            port = Integer.parseInt(txt_port.getText()); //Get da port value (PARSED)
            ip = txt_ip.getText(); //Get IP Value
            
            if(butt_grup.getSelection().getActionCommand() == "Server"){ //Check if RadioButton is selected Server
                if(txt_port.getText().isBlank()){ //check if port text box is empty
                    port = 8000; //set port to default 8000
                }
                svr = new ServerSocket(port);
                svr.accept();
                if(in.ready()){
                    try{
                        s = in.readLine();
                        if(s.isBlank()){
                            if(s.equals(END_CHAT_SESSION)){
                                try{
                                    in.close();
                                    out.close();
                                    txt_msg.setText("");
                                    txtmulti_out.setText("");
                                    txt_msg.setEnabled(false);
                                    txtmulti_out.setEnabled(false);
                                    butt_send.setEnabled(false);
                                    butt_dc.setEnabled(false);
                                    butt_connect.setEnabled(true);
                                    in = null;
                                    out = null;
                                    socket = null;
                                    svr = null;
                                    s = null;
                                    lbl_stat.setText("Disconnected");
                                    lbl_stat.setForeground(Color.RED);
                                }catch(Exception e){
                                    lbl_stat.setText("Error to disconnect w/ error" + e.toString());
                                    lbl_stat.setForeground(Color.RED);
                                }
                            }else{
                                txtmulti_out.append(s);
                            }
                        }
                    }catch(IOException ex){
                        lbl_stat.setText("Can't retrive data w/ error" + ex);
                        lbl_stat.setForeground(Color.RED);
                    }
                }
            }else if(butt_grup.getSelection().getActionCommand() == "Client"){ //Check if RadioButton is selected Client
                if(txt_port.getText().isBlank()){
                    port = 8000;
                }
                if(txt_ip.getText().isBlank()){ //check if IP is empty
                    ip = "localhost"; //set to localhost
                }
                socket = new Socket(ip,port);
                if(in.ready()){
                    try{
                        s = in.readLine();
                        if(s.isBlank()){
                            if(s.equals(END_CHAT_SESSION)){
                                try{
                                    in.close();
                                    out.close();
                                    txt_msg.setText("");
                                    txtmulti_out.setText("");
                                    txt_msg.setEnabled(false);
                                    txtmulti_out.setEnabled(false);
                                    butt_send.setEnabled(false);
                                    butt_dc.setEnabled(false);
                                    butt_connect.setEnabled(true);
                                    in = null;
                                    out = null;
                                    socket = null;
                                    svr = null;
                                    s = null;
                                    lbl_stat.setText("Disconnected");
                                    lbl_stat.setForeground(Color.RED);
                                }catch(Exception e){
                                    lbl_stat.setText("Error to disconnect w/ error" + e.toString());
                                    lbl_stat.setForeground(Color.RED);
                                }
                            }else{
                                txtmulti_out.append(s);
                            }
                        }
                    }catch(IOException ex){
                        lbl_stat.setText("Can't retrive data w/ error" + ex);
                        lbl_stat.setForeground(Color.RED);
                    }
                }
            }else{
                lbl_stat.setText("Wrong IP/Port Value");
                lbl_stat.setForeground(Color.RED);
            }
            
            out = new PrintWriter(socket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            lbl_stat.setText("Connected");
            lbl_stat.setForeground(Color.GREEN);
            txt_msg.setEnabled(true);
            txtmulti_out.setEnabled(true);
            butt_send.setEnabled(true);
            butt_dc.setEnabled(true);
            butt_connect.setEnabled(false);
            txt_msg.grabFocus();
        }catch(IOException e){
            lbl_stat.setText("Error to connect w/ error" + e.toString());
            lbl_stat.setForeground(Color.RED);
        }
    }//GEN-LAST:event_butt_connectMouseClicked

    private void butt_dcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butt_dcMouseClicked
        try{
            in.close();
            out.close();
            txt_msg.setText("");
            txtmulti_out.setText("");
            txt_msg.setEnabled(false);
            txtmulti_out.setEnabled(false);
            butt_send.setEnabled(false);
            butt_dc.setEnabled(false);
            butt_connect.setEnabled(true);
            in = null;
            out = null;
            socket = null;
            svr = null;
            lbl_stat.setText("Disconnected");
            lbl_stat.setForeground(Color.RED);
        }catch(IOException e){
            lbl_stat.setText("Error to disconnect w/ error" + e.toString());
            lbl_stat.setForeground(Color.RED);
        }
    }//GEN-LAST:event_butt_dcMouseClicked

    private void butt_sendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butt_sendMouseClicked
       try{
           if(butt_grup.getSelection().getActionCommand() == "Client" && txt_msg.getText() != ""){
               msg = txt_msg.getText();
               out.print(msg);
               out.flush();
               txt_msg.setText("");
               msg = "";
           }else{
               JOptionPane.showMessageDialog(this, "Message empty", "Error", JOptionPane.ERROR_MESSAGE);
               txt_msg.grabFocus();
           }
       }catch(Exception e){
           lbl_stat.setText("Error to send data w/ error" + e.toString());
       }
    }//GEN-LAST:event_butt_sendMouseClicked

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butt_connect;
    private javax.swing.JButton butt_dc;
    private javax.swing.JButton butt_send;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_stat;
    private javax.swing.JRadioButton rad_client;
    private javax.swing.JRadioButton rad_server;
    private javax.swing.JTextField txt_ip;
    private javax.swing.JTextField txt_msg;
    private javax.swing.JTextField txt_port;
    private javax.swing.JTextArea txtmulti_out;
    // End of variables declaration//GEN-END:variables
}
