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

public class ChiefEditor_CheckArticles extends javax.swing.JFrame {
    /**
     * Creates new form ChiefEditor_CheckArticles
     */
    public ChiefEditor_CheckArticles() {
        initComponents();
        this.setLocationRelativeTo(null); //Setting the frame in the center
        show_articles(); //Calling the show_expencesPerWorker method upon opening
    }
    
    public ArrayList<Article> articleList(){
        ArrayList<Article> articleList = new ArrayList<>(); //Creating an ArrayList of the objects of the Article class    
        try{
            Class.forName("com.mysql.jdbc.Driver"); //Specifying the Driver that will be used to connect
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project_db","root",""); //Connecting to the database
            String query = "{CALL show_articles(?)}"; //Calling the SQL Stored Procedure
            PreparedStatement pstmt = con.prepareCall(query); //Creating a PreparedStatement for the query
            pstmt.setString(1, Login.user); //Setting the variable of the query
            ResultSet rs = pstmt.executeQuery(); //and then executing it and saving the result to a ResultSet
            Article article; //Creating a new Article Object
            while(rs.next()){ //While there is a next row
                article = new Article(rs.getString("path"), rs.getInt("paper_number"), rs.getString("title"), rs.getString("summary"), rs.getString("state"), rs.getInt("priority"), rs.getInt("starting_page"), rs.getInt("ending_page"), rs.getInt("category_id"), rs.getString("chief_editor_email"), rs.getDate("date_approved"), rs.getString("comments"), rs.getString("author")); //Initiliazing our newly created object with the Article Constructor
                articleList.add(article); //Adding the Object to our list
            }
            con.close(); //Closing the connection
        }catch(Exception e){System.out.println(e);}
        return articleList;
    }
    
    public void show_articles(){
        ArrayList<Article> list = articleList(); //Calling the articleList method
        DefaultTableModel model = (DefaultTableModel)jTable_Display_Articles.getModel(); //Creating a new model Object of our Table
        Object[] row = new Object[13]; //Creating a row with thirteen columns
        for(int i = 0; i < list.size(); i++){ 
            row[0] = list.get(i).getpath(); //Inserting each row with the appropriate values
            row[1] = list.get(i).getpaper();
            row[2] = list.get(i).gettitle();
            row[3] = list.get(i).getsummary();
            row[4] = list.get(i).getstate();
            row[5] = list.get(i).getpriority();
            row[6] = list.get(i).getstart();
            row[7] = list.get(i).getend();
            row[8] = list.get(i).getcategory();
            row[9] = list.get(i).getchiefeditoremail();
            row[10] = list.get(i).getdate();
            row[11] = list.get(i).getcomments();
            row[12] = list.get(i).getauthors();
            model.addRow(row); //Adding the row to the table
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Articles = new javax.swing.JTable();
        PathLabel = new javax.swing.JLabel();
        CommentsTextField = new javax.swing.JTextField();
        StateLabel = new javax.swing.JLabel();
        StateComboBox = new javax.swing.JComboBox<>();
        CommentsLabel = new javax.swing.JLabel();
        InsertButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        PathComboBox = new javax.swing.JComboBox<>();
        ArticlesLabel = new javax.swing.JLabel();
        LogoLabel = new javax.swing.JLabel();
        CloseLabel = new javax.swing.JLabel();
        MinimizeLabel = new javax.swing.JLabel();
        BackLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(155, 89, 182));

        jPanel3.setBackground(new java.awt.Color(52, 73, 94));

        jTable_Display_Articles.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jTable_Display_Articles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Path", "Paper", "Title", "Summary", "State", "Priority", "First Page", "Last Page", "Category", "Chief Editor", "Date Approved", "Comments", "Authors"
            }
        ));
        jScrollPane1.setViewportView(jTable_Display_Articles);

        PathLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        PathLabel.setForeground(new java.awt.Color(255, 255, 255));
        PathLabel.setText("Path:");

        CommentsTextField.setBackground(new java.awt.Color(127, 140, 141));
        CommentsTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        StateLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        StateLabel.setForeground(new java.awt.Color(255, 255, 255));
        StateLabel.setText("State:");

        StateComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        StateComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Accepted", "To Be Revised", "Rejected" }));
        StateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StateComboBoxActionPerformed(evt);
            }
        });

        CommentsLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        CommentsLabel.setForeground(new java.awt.Color(255, 255, 255));
        CommentsLabel.setText("Comments:");

        InsertButton.setBackground(new java.awt.Color(52, 152, 219));
        InsertButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        InsertButton.setForeground(new java.awt.Color(255, 255, 255));
        InsertButton.setText("Set");
        InsertButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InsertButtonMouseClicked(evt);
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

        PathComboBox.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(InsertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CommentsLabel)
                            .addComponent(StateLabel)
                            .addComponent(PathLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CommentsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PathComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PathLabel)
                    .addComponent(PathComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StateLabel)
                    .addComponent(StateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CommentsLabel)
                    .addComponent(CommentsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InsertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        ArticlesLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        ArticlesLabel.setForeground(new java.awt.Color(255, 255, 255));
        ArticlesLabel.setText("Articles");

        LogoLabel.setFont(new java.awt.Font("Rage Italic", 1, 60)); // NOI18N
        LogoLabel.setForeground(new java.awt.Color(255, 255, 255));
        LogoLabel.setText("C");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ArticlesLabel)
                .addGap(276, 276, 276)
                .addComponent(LogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                            .addComponent(LogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseLabelMouseClicked
        System.exit(0); //Exit the system when the Close Label is clicked
    }//GEN-LAST:event_CloseLabelMouseClicked

    private void MinimizeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeLabelMouseClicked
        this.setState(JFrame.ICONIFIED); //Minimize the JFrame when the Minimize Label is clicked
    }//GEN-LAST:event_MinimizeLabelMouseClicked

    private void BackLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackLabelMouseClicked
        ChiefEditor_Form cef = new ChiefEditor_Form(); //Creating a new JFrame object to the Frame that we will be transfered
        cef.setVisible(true); //Making it visible
        cef.pack(); //Make the size of the JFrame appropriate to fit all the contents
        cef.setLocationRelativeTo(null); //Setting the frame in the center
        cef.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Specifying that the close button, when pressed, should exit the application
        cef.UsernameChiefEditorFormLabel.setText(Login.user); //Setting the text of the Username Label to the user that logged in
        this.dispose(); //Closing this frame
    }//GEN-LAST:event_BackLabelMouseClicked

    private void StateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StateComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StateComboBoxActionPerformed

    private void InsertButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InsertButtonMouseClicked
        try{
            String query = null; //Initializing a null String query
            String path = PathComboBox.getSelectedItem().toString(); //Getting the selected item from the PathComboBox
            String comments = CommentsTextField.getText(); //Getting the text written from the CommentsTextField
            String state = StateComboBox.getSelectedItem().toString(); //Getting the selected item from the StateComboBox
            Class.forName("com.mysql.jdbc.Driver"); //Specifying the Driver that will be used to connect
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project_db","root",""); //Connecting to the database
            if (state.equals("Accepted")){ //If the state is Accepted
                query = "UPDATE article SET state = ? WHERE path = ?"; //Writing the SQL Query
                PreparedStatement pstmt = con.prepareStatement(query); //Creating a PreparedStatement for the query
                pstmt.setString(1, "accepted"); //Setting the variables of the query
                pstmt.setString(2, path);
                pstmt.executeUpdate(); //and then executing it
            }
            else if(state.equals("To Be Revised")){ //If the state is To Be Revised
                query = "UPDATE article SET state = ?, comments = ? WHERE path = ?"; //Writing the SQL Query
                PreparedStatement pstmt = con.prepareStatement(query); //Creating a PreparedStatement for the query
                pstmt.setString(1, "to_be_revised"); //Setting the variables of the query
                pstmt.setString(2, comments);
                pstmt.setString(3, path);
                pstmt.executeUpdate(); //and then executing it
            }
            else if(state.equals("Rejected")){ //If the state is Rejected
                query = "UPDATE article SET state = ? WHERE path = ?"; //Writing the SQL Query
                PreparedStatement pstmt = con.prepareStatement(query); //Creating a PreparedStatement for the query
                pstmt.setString(1, "rejected"); //Setting the variables of the query
                pstmt.setString(2, path);
                pstmt.executeUpdate(); //and then executing it
            }
            JOptionPane.showMessageDialog(null, "Update successful!"); //Displaying a success message when the execution is over
            con.close(); //Closing the connection
        }catch(Exception e){System.out.println(e);}
    }//GEN-LAST:event_InsertButtonMouseClicked

    private void CancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMouseClicked
        PathComboBox.setSelectedItem(""); //Clearing everything we chose or wrote
        StateComboBox.setSelectedItem("");
        CommentsTextField.setText("");
    }//GEN-LAST:event_CancelButtonMouseClicked

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
            java.util.logging.Logger.getLogger(ChiefEditor_CheckArticles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiefEditor_CheckArticles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiefEditor_CheckArticles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiefEditor_CheckArticles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiefEditor_CheckArticles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ArticlesLabel;
    private javax.swing.JLabel BackLabel;
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel CloseLabel;
    private javax.swing.JLabel CommentsLabel;
    private javax.swing.JTextField CommentsTextField;
    private javax.swing.JButton InsertButton;
    private javax.swing.JLabel LogoLabel;
    private javax.swing.JLabel MinimizeLabel;
    public javax.swing.JComboBox<String> PathComboBox;
    private javax.swing.JLabel PathLabel;
    public javax.swing.JComboBox<String> StateComboBox;
    private javax.swing.JLabel StateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display_Articles;
    // End of variables declaration//GEN-END:variables
}
