package project_db;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class Administrator_TotalExpencesPerWorker extends javax.swing.JFrame {

    /**
     * Creates new form Administrator_TotalExpencesPerWorker
     */
    public Administrator_TotalExpencesPerWorker() {
        initComponents();
        this.setLocationRelativeTo(null); //Setting the frame in the center
        show_expencesPerWorker(); //Calling the show_expencesPerWorker method upon opening
    }

    public ArrayList<ExpencesPerWorker> expencesPerWorkerList(){
        ArrayList<ExpencesPerWorker> expencesPerWorkerList = new ArrayList<>(); //Creating an ArrayList of the objects of the ExpencesPerWorker class
        try{
            Class.forName("com.mysql.jdbc.Driver"); //Specifying the Driver that will be used to connect
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project_db","root",""); //Connecting to the database
            String query = "{CALL get_paygrade(?, ?, ?)}"; //Calling the SQL Stored Procedure
            PreparedStatement pstmt = con.prepareCall(query); //Creating a PreparedStatement for the query
            pstmt.setInt(1, Integer.parseInt(Administrator_Form.Months2TextField.getText())); //Setting the variables of the query
            pstmt.setInt(2, 2); 
            pstmt.setString(3, Login.user);
            ResultSet rs = pstmt.executeQuery(); //and then executing it and saving the result to a ResultSet
            ExpencesPerWorker expencesPerWorker; //Creating a new ExpencePerWorker Object
            while(rs.next()){ //While there is a next row
                expencesPerWorker = new ExpencesPerWorker(rs.getString("newspaper_name"), rs.getString("name"), rs.getString("lastname"), rs.getFloat("salary_per_month"), rs.getFloat("total_salaries")); //Initiliazing our newly created object with the ExpencesPerWorker Constructor
                expencesPerWorkerList.add(expencesPerWorker); //Adding the Object to our list
            }
            con.close(); //Closing the connection
        }catch(Exception e){System.out.println(e);}
        return expencesPerWorkerList;
    }
    
    public void show_expencesPerWorker(){
        ArrayList<ExpencesPerWorker> list = expencesPerWorkerList(); //Calling the expencesPerWorkerList method
        DefaultTableModel model = (DefaultTableModel)jTable_Display_Expences_Per_Worker.getModel(); //Creating a new model Object of our Table
        Object[] row = new Object[5]; //Creating a row with five columns
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getnewspaper_name(); //Inserting each row with the appropriate value
            row[1] = list.get(i).getname();
            row[2] = list.get(i).getlastname();
            row[3] = list.get(i).getsalarypermonth();
            row[4] = list.get(i).gettotalsalaries();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Expences_Per_Worker = new javax.swing.JTable();
        ArticlesLabel = new javax.swing.JLabel();
        LogoLabel = new javax.swing.JLabel();
        CloseLabel = new javax.swing.JLabel();
        MinimizeLabel = new javax.swing.JLabel();
        BackLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(155, 89, 182));

        jPanel3.setBackground(new java.awt.Color(52, 73, 94));

        jTable_Display_Expences_Per_Worker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Newspaper", "Name", "Lastname", "Monthly Salary", "Total Salaries"
            }
        ));
        jScrollPane1.setViewportView(jTable_Display_Expences_Per_Worker);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
        );

        ArticlesLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        ArticlesLabel.setForeground(new java.awt.Color(255, 255, 255));
        ArticlesLabel.setText("Total Expences Per Worker");

        LogoLabel.setFont(new java.awt.Font("Rage Italic", 1, 60)); // NOI18N
        LogoLabel.setForeground(new java.awt.Color(255, 255, 255));
        LogoLabel.setText("A");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(ArticlesLabel)
                .addGap(18, 18, 18)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        Administrator_Form af = new Administrator_Form(); //Creating a new JFrame object to the Frame that we will be transfered
        af.setVisible(true); //Making it visible
        af.pack(); //Make the size of the JFrame appropriate to fit all the contents
        af.setLocationRelativeTo(null); //Setting the frame in the center
        af.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Specifying that the close button, when pressed, should exit the application
        af.UsernameAdministratorFormLabel.setText(Login.user); //Setting the text of the Username Label to the user that logged in
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
            java.util.logging.Logger.getLogger(Administrator_TotalExpencesPerWorker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrator_TotalExpencesPerWorker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrator_TotalExpencesPerWorker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrator_TotalExpencesPerWorker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrator_TotalExpencesPerWorker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ArticlesLabel;
    private javax.swing.JLabel BackLabel;
    private javax.swing.JLabel CloseLabel;
    private javax.swing.JLabel LogoLabel;
    private javax.swing.JLabel MinimizeLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display_Expences_Per_Worker;
    // End of variables declaration//GEN-END:variables
}
