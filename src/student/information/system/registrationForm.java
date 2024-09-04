package student.information.system;

import java.sql.*;
import javax.swing.JOptionPane;


public class registrationForm extends javax.swing.JFrame {
    
    Statement st;
    ResultSet rs;
    Connection conn;
    
    public static String name, username, password, email, phone;
    
    public registrationForm() {
        initComponents();
        connectionEstablishment();        
    }
    
    private void connectionEstablishment(){
        try{
            String url = "jdbc:mysql://localhost:3306/student";
            conn = DriverManager.getConnection(url, "root", "root@123");
            st = conn.createStatement();
            System.out.println("Connection Successfull !");
        }catch(Exception e){
            System.err.println("Error is connecting Database !");
            System.err.println(e.getMessage());
        }    
    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        userNameLabel = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registration Form");
        setMinimumSize(new java.awt.Dimension(500, 600));
        setPreferredSize(new java.awt.Dimension(500, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Registration Form");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        phoneLabel.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        phoneLabel.setForeground(new java.awt.Color(255, 255, 255));
        phoneLabel.setText("Phone : ");
        getContentPane().add(phoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        phoneField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(phoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 260, 30));

        nameLabel.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setText("Name : ");
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        nameField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 260, 30));

        userNameLabel.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        userNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        userNameLabel.setText("Username :");
        getContentPane().add(userNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 20));

        userNameField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(userNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 260, 30));

        passwordLabel.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password :");
        getContentPane().add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        emailLabel.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("Email : ");
        getContentPane().add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        emailField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 260, 30));

        submitButton.setText("Submit");
        submitButton.setBorder(null);
        submitButton.setBorderPainted(false);
        submitButton.setFocusable(false);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 100, 30));

        passwordField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 260, 30));

        loginButton.setText("Login");
        loginButton.setFocusable(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 100, 30));

        bg.setIcon(new javax.swing.ImageIcon("C:\\Users\\edwin\\OneDrive\\Pictures\\wallpaperflare.com_wallpaper.jpg")); // NOI18N
        bg.setText("jLabel1");
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1250, -920, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        name = nameField.getText();
        username = userNameField.getText();
        password = passwordField.getText();
        email = emailField.getText();
        phone = phoneField.getText();
        
        if(!name.isEmpty() && !username.isEmpty() && !password.isEmpty() && !email.isEmpty()){
            try
            {
                String query = "SELECT * from register where username = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, username);
                rs = ps.executeQuery();
                
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(this, "Username already exists..");
                    nameField.setText("");
                    userNameField.setText("");
                    passwordField.setText("");
                    phoneField.setText("");
                    emailField.setText("");
                }
                else
                {
                    query = "INSERT INTO register (username, name, password, phonenumber, email) VALUES (?,?,?,?,?)";
                    ps = conn.prepareStatement(query);
                    ps.setString(1, username);
                    ps.setString(2, name);
                    ps.setString(3, password);
                    ps.setString(4, phone);
                    ps.setString(5, email);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Registration Successfull !");
                    nameField.setText("");
                    userNameField.setText("");
                    passwordField.setText("");
                    phoneField.setText("");
                    emailField.setText("");
                }
            }catch(SQLException e)
            {
                    JOptionPane.showMessageDialog(this, "Error ! : " + e.getMessage());
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "All fields are required !");
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        dispose();
        loginForm lf = new loginForm();
        lf.show();
    }//GEN-LAST:event_loginButtonActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new registrationForm().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel title;
    private javax.swing.JTextField userNameField;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}