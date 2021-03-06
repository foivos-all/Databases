package project_db;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Publisher_SetChiefEditor extends javax.swing.JFrame {

    /**
     * Creates new form Publisher_SetChiefEditor
     */
    public Publisher_SetChiefEditor() {
        initComponents();
        this.setLocationRelativeTo(null); //Setting the frame in the center
        show_journalists(); //Calling the show_journalists method upon opening
    }
    
    public ArrayList<Journalist> journalistList(){
        ArrayList<Journalist> journalistList = new ArrayList<>(); //Creating an ArrayList of the objects of the Journalist class 
        try{
            Class.forName("com.mysql.jdbc.Driver"); //Specifying the Driver that will be used to connect
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project_db","root",""); //Connecting to the database
            String query = "{CALL  get_journalists(?)}"; //Calling the SQL Stored Procedure
            PreparedStatement pstmt = con.prepareCall(query); //Creating a PreparedStatement for the query
            pstmt.setString(1, Login.user); //Setting the variable of the query
            ResultSet rs = pstmt.executeQuery(); //and then executing it and saving the result to a ResultSet
            Journalist journalist; //Creating a new PaperSales Object
            while(rs.next()){
                journalist = new Journalist(rs.getString("email"), rs.getString("name"), rs.getString("lastname"), rs.getString("date_hired"), rs.getString("newspaper_name"), rs.getString("post").charAt(0)); //Initiliazing our newly created object with the Journalist Constructor
                journalistList.add(journalist); //Adding the Object to our list
            }
            con.close(); //Closing the connection
        }catch(Exception e){System.out.println(e);}
        return journalistList;
    }
    
    public void show_journalists(){
        ArrayList<Journalist> list = journalistList(); //Calling the journalistList method
        DefaultTableModel model = (DefaultTableModel)jTable_Display_Journalists.getModel(); //Creating a new model Object of our Table
        Object[] row = new Object[6]; //Creating a row with six columns
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getemail(); //Inserting each row with the appropriate values
            row[1] = list.get(i).getname();
            row[2] = list.get(i).getlastname();
            row[3] = list.get(i).getdate_hired();
            row[4] = list.get(i).getnewspaper_name();
            row[5] = list.get(i).getpost();
            model.addRow(row); //Adding our row to the table
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Journalists = new javax.swing.JTable();
        NewspaperNameLabel = new javax.swing.JLabel();
        JournalistEmailLabel = new javax.swing.JLabel();
        ChangeButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        JournalistComboBox = new javax.swing.JComboBox<>();
        NewspaperNameComboBox = new javax.swing.JComboBox<>();
        ArticlesLabel = new javax.swing.JLabel();
        LogoLabel = new javax.swing.JLabel();
        CloseLabel = new javax.swing.JLabel();
        MinimizeLabel = new javax.swing.JLabel();
        UsernamePublisherSetChiefEditor = new javax.swing.JLabel();
        BackLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(155, 89, 182));

        jPanel3.setBackground(new java.awt.Color(52, 73, 94));

        jTable_Display_Journalists.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Journalist Email", "Name", "Lastname", "Date Hired", "Newspaper Name", "Post"
            }
        ));
        jScrollPane1.setViewportView(jTable_Display_Journalists);

        NewspaperNameLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        NewspaperNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        NewspaperNameLabel.setText("Newspaper Name:");

        JournalistEmailLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        JournalistEmailLabel.setForeground(new java.awt.Color(255, 255, 255));
        JournalistEmailLabel.setText("Journalist Email:");

        ChangeButton.setBackground(new java.awt.Color(52, 152, 219));
        ChangeButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ChangeButton.setForeground(new java.awt.Color(255, 255, 255));
        ChangeButton.setText("Change");
        ChangeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChangeButtonMouseClicked(evt);
            }
        });

        CancelButton.setBackground(new java.awt.Color(231, 76, 60));
        CancelButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        CancelButton.setForeground(new java.awt.Color(255, 255, 255));
        CancelButton.setText("Cancel");
        CancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelButtonMouseClicked(evt);
            }
        });

        JournalistComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        NewspaperNameComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(239, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ChangeButton)
                        .addGap(256, 256, 256))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NewspaperNameLabel)
                            .addComponent(JournalistEmailLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JournalistComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NewspaperNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(251, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewspaperNameLabel)
                    .addComponent(NewspaperNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JournalistEmailLabel)
                    .addComponent(JournalistComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        ArticlesLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        ArticlesLabel.setForeground(new java.awt.Color(255, 255, 255));
        ArticlesLabel.setText("Journalists of newspapers owned by");

        LogoLabel.setFont(new java.awt.Font("Rage Italic", 1, 60)); // NOI18N
        LogoLabel.setForeground(new java.awt.Color(255, 255, 255));
        LogoLabel.setText("P");

        CloseLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CloseLabel.setForeground(new java.awt.Color(255, 255, 255));
        CloseLabel.setText("X");
        CloseLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CloseLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CloseLabelMouseExited(evt);
            }
        });

        MinimizeLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        MinimizeLabel.setForeground(new java.awt.Color(255, 255, 255));
        MinimizeLabel.setText("-");
        MinimizeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizeLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MinimizeLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MinimizeLabelMouseExited(evt);
            }
        });

        UsernamePublisherSetChiefEditor.setBackground(new java.awt.Color(155, 89, 182));
        UsernamePublisherSetChiefEditor.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        UsernamePublisherSetChiefEditor.setForeground(new java.awt.Color(255, 255, 255));

        BackLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        BackLabel.setForeground(new java.awt.Color(255, 255, 255));
        BackLabel.setText("<");
        BackLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(BackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ArticlesLabel)
                .addGap(18, 18, 18)
                .addComponent(UsernamePublisherSetChiefEditor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
                .addComponent(LogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MinimizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CloseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ArticlesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UsernamePublisherSetChiefEditor))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CloseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MinimizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ChangeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangeButtonMouseClicked
        try{
            String former_chief_editor = null; //Initializing a null String query
            String newspaper_name = NewspaperNameComboBox.getSelectedItem().toString(); //Getting the selected item from the NewspaperNameComboBox
            String email = JournalistComboBox.getSelectedItem().toString(); //Getting the selected item from the JournalistComboBox
            Class.forName("com.mysql.jdbc.Driver"); //Specifying the Driver that will be used to connect
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project_db","root",""); //Connecting to the database
            String query1 = "{CALL  get_chief_editor(?)}"; //Calling the SQL Stored Procedure
            PreparedStatement pstmt1 = con.prepareCall(query1); //Creating a PreparedStatement for the query
            pstmt1.setString(1, Login.user); //Setting the variables of the query
            ResultSet rs = pstmt1.executeQuery(); //and then executing it and saving the result to a ResultSet
            while(rs.next()){
                former_chief_editor = rs.getString("email"); //Getting the email of the now former chief editor
            }
            String query2 = "UPDATE worker SET post = 'C' WHERE email = ? AND newspaper_name = ?"; //Writing the SQL Query
            PreparedStatement pstmt2 = con.prepareCall(query2); //Creating a PreparedStatement for the query
            pstmt2.setString(1, email); //Setting the variables of the query
            pstmt2.setString(2, newspaper_name);
            pstmt2.executeUpdate(); //and then executing it
            String query3 = "UPDATE worker SET post = 'J' WHERE email = ? AND newspaper_name = ?"; //we also do the same thing for the next query
            PreparedStatement pstmt3 = con.prepareCall(query3);
            pstmt3.setString(1, former_chief_editor);
            pstmt3.setString(2, newspaper_name);
            pstmt3.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update successful!"); //Displaying a success message when the execution is over 
            con.close(); //Closing the connection
        }catch(Exception e){System.out.println(e);}
    }//GEN-LAST:event_ChangeButtonMouseClicked

    private void CancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMouseClicked
        NewspaperNameComboBox.setSelectedItem(""); //Clearing everything we chose or wrote
        JournalistComboBox.setSelectedItem("");
    }//GEN-LAST:event_CancelButtonMouseClicked

    private void CloseLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseLabelMouseClicked
        System.exit(0); //Exit the system when the Close Label is clicked
    }//GEN-LAST:event_CloseLabelMouseClicked

    private void MinimizeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeLabelMouseClicked
        this.setState(JFrame.ICONIFIED); //Minimize the JFrame when the Minimize Label is clicked
    }//GEN-LAST:event_MinimizeLabelMouseClicked

    private void BackLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackLabelMouseClicked
        PublisherForm pf = new PublisherForm(); //Creating a new JFrame object to the Frame that we will be transfered
        pf.setVisible(true); //Making it visible
        pf.pack(); //Make the size of the JFrame appropriate to fit all the contents
        pf.setLocationRelativeTo(null); //Setting the frame in the center
        pf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Specifying that the close button, when pressed, should exit the application
        PublisherForm.UsernamePublisherFormLabel.setText(Login.user); //Setting the text of the Username Label to the user that logged in
        this.dispose(); //Closing this frame
    }//GEN-LAST:event_BackLabelMouseClicked

    private void BackLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackLabelMouseEntered
        BackLabel.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_BackLabelMouseEntered

    private void BackLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackLabelMouseExited
        BackLabel.setForeground(Color.white);
    }//GEN-LAST:event_BackLabelMouseExited

    private void MinimizeLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeLabelMouseEntered
        MinimizeLabel.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_MinimizeLabelMouseEntered

    private void MinimizeLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeLabelMouseExited
        MinimizeLabel.setForeground(Color.white);
    }//GEN-LAST:event_MinimizeLabelMouseExited

    private void CloseLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseLabelMouseEntered
        CloseLabel.setForeground(Color.red);
    }//GEN-LAST:event_CloseLabelMouseEntered

    private void CloseLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseLabelMouseExited
        CloseLabel.setForeground(Color.white);
    }//GEN-LAST:event_CloseLabelMouseExited

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
            java.util.logging.Logger.getLogger(Publisher_SetChiefEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Publisher_SetChiefEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Publisher_SetChiefEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Publisher_SetChiefEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Publisher_SetChiefEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ArticlesLabel;
    private javax.swing.JLabel BackLabel;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton ChangeButton;
    private javax.swing.JLabel CloseLabel;
    public javax.swing.JComboBox<String> JournalistComboBox;
    private javax.swing.JLabel JournalistEmailLabel;
    private javax.swing.JLabel LogoLabel;
    private javax.swing.JLabel MinimizeLabel;
    public javax.swing.JComboBox<String> NewspaperNameComboBox;
    private javax.swing.JLabel NewspaperNameLabel;
    public javax.swing.JLabel UsernamePublisherSetChiefEditor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display_Journalists;
    // End of variables declaration//GEN-END:variables
}
