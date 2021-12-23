package project_db;

import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ChiefEditor_Insert extends javax.swing.JFrame {

    /**
     * Creates new form ChiefEditor_Insert
     */
    public ChiefEditor_Insert() {
        initComponents();
        this.setLocationRelativeTo(null); //Setting the frame in the center
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
        CancelButton = new javax.swing.JButton();
        InsertButton = new javax.swing.JButton();
        PathLabel = new javax.swing.JLabel();
        PaperNumberLabel = new javax.swing.JLabel();
        PriorityLabel = new javax.swing.JLabel();
        TitleLabel = new javax.swing.JLabel();
        CategoryLabel = new javax.swing.JLabel();
        StartingPageLabel = new javax.swing.JLabel();
        EndingPageLabel = new javax.swing.JLabel();
        AuthorsLabel = new javax.swing.JLabel();
        PaperNumberTextField = new javax.swing.JTextField();
        PathTextField = new javax.swing.JTextField();
        PriorityTextField = new javax.swing.JTextField();
        CategoryTextField = new javax.swing.JTextField();
        TitleTextField = new javax.swing.JTextField();
        EndingPageTextField = new javax.swing.JTextField();
        StartingPageTextField = new javax.swing.JTextField();
        SummaryTextField = new javax.swing.JTextField();
        SummaryLabel = new javax.swing.JLabel();
        KeywordsTextField = new javax.swing.JTextField();
        ImagesLabel = new javax.swing.JLabel();
        KeywordsLabel = new javax.swing.JLabel();
        ChiefEditorEmailTextField = new javax.swing.JTextField();
        ImagesTextField = new javax.swing.JTextField();
        AuthorsLabel1 = new javax.swing.JLabel();
        AuthorsTextField = new javax.swing.JTextField();
        CloseLabel = new javax.swing.JLabel();
        InsertFormLabel = new javax.swing.JLabel();
        MinimizeLabel = new javax.swing.JLabel();
        BackLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(155, 89, 182));

        jPanel2.setBackground(new java.awt.Color(52, 73, 94));

        CancelButton.setBackground(new java.awt.Color(231, 76, 60));
        CancelButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        CancelButton.setForeground(new java.awt.Color(255, 255, 255));
        CancelButton.setText("Cancel");
        CancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelButtonMouseClicked(evt);
            }
        });

        InsertButton.setBackground(new java.awt.Color(52, 152, 219));
        InsertButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        InsertButton.setForeground(new java.awt.Color(255, 255, 255));
        InsertButton.setText("Insert");
        InsertButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InsertButtonMouseClicked(evt);
            }
        });

        PathLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PathLabel.setForeground(new java.awt.Color(255, 255, 255));
        PathLabel.setText("Path:");

        PaperNumberLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PaperNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        PaperNumberLabel.setText("Paper Number:");

        PriorityLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PriorityLabel.setForeground(new java.awt.Color(255, 255, 255));
        PriorityLabel.setText("Priority");

        TitleLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        TitleLabel.setText("Title:");

        CategoryLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        CategoryLabel.setForeground(new java.awt.Color(255, 255, 255));
        CategoryLabel.setText("Category:");

        StartingPageLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        StartingPageLabel.setForeground(new java.awt.Color(255, 255, 255));
        StartingPageLabel.setText("Starting page:");

        EndingPageLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        EndingPageLabel.setForeground(new java.awt.Color(255, 255, 255));
        EndingPageLabel.setText("Ending page:");

        AuthorsLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        AuthorsLabel.setForeground(new java.awt.Color(255, 255, 255));
        AuthorsLabel.setText("Authors:");

        PaperNumberTextField.setBackground(new java.awt.Color(127, 140, 141));
        PaperNumberTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        PathTextField.setBackground(new java.awt.Color(127, 140, 141));
        PathTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        PriorityTextField.setBackground(new java.awt.Color(127, 140, 141));
        PriorityTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        CategoryTextField.setBackground(new java.awt.Color(127, 140, 141));
        CategoryTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        TitleTextField.setBackground(new java.awt.Color(127, 140, 141));
        TitleTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        EndingPageTextField.setBackground(new java.awt.Color(127, 140, 141));
        EndingPageTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        StartingPageTextField.setBackground(new java.awt.Color(127, 140, 141));
        StartingPageTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        SummaryTextField.setBackground(new java.awt.Color(127, 140, 141));
        SummaryTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        SummaryLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SummaryLabel.setForeground(new java.awt.Color(255, 255, 255));
        SummaryLabel.setText("Summary:");

        KeywordsTextField.setBackground(new java.awt.Color(127, 140, 141));
        KeywordsTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        ImagesLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ImagesLabel.setForeground(new java.awt.Color(255, 255, 255));
        ImagesLabel.setText("Images:");

        KeywordsLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        KeywordsLabel.setForeground(new java.awt.Color(255, 255, 255));
        KeywordsLabel.setText("Keywords:");

        ChiefEditorEmailTextField.setBackground(new java.awt.Color(127, 140, 141));
        ChiefEditorEmailTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        ImagesTextField.setBackground(new java.awt.Color(127, 140, 141));
        ImagesTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        AuthorsLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        AuthorsLabel1.setForeground(new java.awt.Color(255, 255, 255));
        AuthorsLabel1.setText("Chief Editor Email:");

        AuthorsTextField.setBackground(new java.awt.Color(127, 140, 141));
        AuthorsTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PathLabel)
                            .addComponent(PaperNumberLabel)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PriorityLabel)
                                    .addComponent(TitleLabel))
                                .addGap(112, 112, 112)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PaperNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(PriorityTextField)
                                        .addGap(602, 602, 602))))
                            .addComponent(StartingPageLabel)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(641, 641, 641)
                                    .addComponent(InsertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(EndingPageLabel)
                                        .addComponent(CategoryLabel))
                                    .addGap(60, 60, 60)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(KeywordsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ChiefEditorEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(CategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(EndingPageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(StartingPageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(ImagesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SummaryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AuthorsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SummaryLabel)
                            .addComponent(KeywordsLabel)
                            .addComponent(ImagesLabel)
                            .addComponent(AuthorsLabel)
                            .addComponent(AuthorsLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PathLabel)
                    .addComponent(PathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PaperNumberLabel)
                    .addComponent(PaperNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TitleLabel)
                    .addComponent(TitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PriorityLabel)
                    .addComponent(PriorityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartingPageLabel)
                    .addComponent(StartingPageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EndingPageLabel)
                    .addComponent(EndingPageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CategoryLabel)
                    .addComponent(CategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AuthorsLabel1)
                    .addComponent(ChiefEditorEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AuthorsLabel)
                    .addComponent(AuthorsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImagesLabel)
                    .addComponent(ImagesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KeywordsLabel)
                    .addComponent(KeywordsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SummaryLabel)
                    .addComponent(SummaryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InsertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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

        InsertFormLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        InsertFormLabel.setForeground(new java.awt.Color(255, 255, 255));
        InsertFormLabel.setText("Insert Form");

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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(BackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(InsertFormLabel)
                .addGap(286, 286, 286)
                .addComponent(MinimizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CloseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InsertFormLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CloseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MinimizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMouseClicked
        PathTextField.setText(""); //Clearing everything we wrote
        PaperNumberTextField.setText("");
        TitleTextField.setText("");
        PriorityTextField.setText("");
        StartingPageTextField.setText("");
        EndingPageTextField.setText("");
        CategoryTextField.setText("");
        ChiefEditorEmailTextField.setText("");
        AuthorsTextField.setText("");
        ImagesTextField.setText("");
        KeywordsTextField.setText("");
        SummaryTextField.setText("");
    }//GEN-LAST:event_CancelButtonMouseClicked

    private void InsertButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InsertButtonMouseClicked
        try{
            DateFormat df = new SimpleDateFormat("yy/MM/dd"); //Making a new Date Object to get the current Date
            java.util.Date d = new java.util.Date(); //Getting the current date
            String path = PathTextField.getText(); //Getting the texts written in every TextField
            int paper_number = Integer.parseInt(PaperNumberTextField.getText());
            String title = TitleTextField.getText();
            int priority = Integer.parseInt(PriorityTextField.getText());
            int start = Integer.parseInt(StartingPageTextField.getText());
            int end = Integer.parseInt(EndingPageTextField.getText());
            int category = Integer.parseInt(CategoryTextField.getText());
            String chief_editor_email = ChiefEditorEmailTextField.getText();
            String authors = ChiefEditorEmailTextField.getText();
            String keywords = KeywordsTextField.getText();
            String images = ImagesTextField.getText();
            String summary = SummaryTextField.getText();
            Class.forName("com.mysql.jdbc.Driver"); //Specifying the Driver that will be used to connect
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project_db","root",""); //Connecting to the database
            String query1 = "INSERT INTO article(path, paper_number, title, summary, state, priority, starting_page, ending_page, category_id, chief_editor_email) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; //Writing the SQL Querys
            String query2 = "INSERT INTO authors VALUES(?, ?)";
            String query3 = "INSERT INTO keywords VALUES(?, ?)";
            String query4 = "INSERT INTO images VALUES(?, ?)";
            String query5 = "INSERT INTO submits VALUES(?, ?, ?)";
            PreparedStatement pstmt1 = con.prepareStatement(query1); //Creating a PreparedStatement for each query
            pstmt1.setString(1, path); //Setting the variables of each query
            pstmt1.setInt(2, paper_number);
            pstmt1.setString(3, title);
            pstmt1.setString(4, summary);
            pstmt1.setString(5, "accepted");
            pstmt1.setInt(6, priority);
            pstmt1.setInt(7, start);
            pstmt1.setInt(8, end);
            pstmt1.setInt(9, category);
            pstmt1.setString(10, chief_editor_email);
            pstmt1.executeUpdate(); //and then executing each one
            PreparedStatement pstmt2 = con.prepareStatement(query2);
            pstmt2.setString(1, path);
            pstmt2.setString(2, Login.user);
            pstmt2.executeUpdate();
            PreparedStatement pstmt3 = con.prepareStatement(query3);
            pstmt3.setString(1, path);
            pstmt3.setString(2, keywords);
            pstmt3.executeUpdate();
            PreparedStatement pstmt4 = con.prepareStatement(query4);
            pstmt4.setString(1, path);
            pstmt4.setString(2, images);
            pstmt4.executeUpdate();
            PreparedStatement pstmt5 = con.prepareStatement(query5);
            pstmt5.setString(1, chief_editor_email);
            pstmt5.setString(2, path);
            pstmt5.setString(3, df.format(d));
            pstmt5.executeUpdate();
            JOptionPane.showMessageDialog(null, "Insertion successful!"); //Displaying a success message when the execution is over
            con.close(); //Closing the connection
        }catch(Exception e){System.out.println(e);}
    }//GEN-LAST:event_InsertButtonMouseClicked

    private void CloseLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseLabelMouseClicked
        System.exit(0); //Exit the system when the Close Label is clicked
    }//GEN-LAST:event_CloseLabelMouseClicked

    private void MinimizeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeLabelMouseClicked
        this.setState(JFrame.ICONIFIED); //Minimize the JFrame when the Minimize Label is clicked
    }//GEN-LAST:event_MinimizeLabelMouseClicked

    private void BackLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackLabelMouseClicked
        ChiefEditor_Form cf = new ChiefEditor_Form(); //Creating a new JFrame object to the Frame that we will be transfered
        cf.setVisible(true); //Making it visible
        cf.pack(); //Make the size of the JFrame appropriate to fit all the contents
        cf.setLocationRelativeTo(null); //Setting the frame in the center
        cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Specifying that the close button, when pressed, should exit the application
        cf.UsernameChiefEditorFormLabel.setText(Login.user); //Setting the text of the Username Label to the user that logged in
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
            java.util.logging.Logger.getLogger(ChiefEditor_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiefEditor_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiefEditor_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiefEditor_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiefEditor_Insert().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AuthorsLabel;
    private javax.swing.JLabel AuthorsLabel1;
    private javax.swing.JTextField AuthorsTextField;
    private javax.swing.JLabel BackLabel;
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel CategoryLabel;
    private javax.swing.JTextField CategoryTextField;
    private javax.swing.JTextField ChiefEditorEmailTextField;
    private javax.swing.JLabel CloseLabel;
    private javax.swing.JLabel EndingPageLabel;
    private javax.swing.JTextField EndingPageTextField;
    private javax.swing.JLabel ImagesLabel;
    private javax.swing.JTextField ImagesTextField;
    private javax.swing.JButton InsertButton;
    private javax.swing.JLabel InsertFormLabel;
    private javax.swing.JLabel KeywordsLabel;
    private javax.swing.JTextField KeywordsTextField;
    private javax.swing.JLabel MinimizeLabel;
    private javax.swing.JLabel PaperNumberLabel;
    private javax.swing.JTextField PaperNumberTextField;
    private javax.swing.JLabel PathLabel;
    private javax.swing.JTextField PathTextField;
    private javax.swing.JLabel PriorityLabel;
    private javax.swing.JTextField PriorityTextField;
    private javax.swing.JLabel StartingPageLabel;
    private javax.swing.JTextField StartingPageTextField;
    private javax.swing.JLabel SummaryLabel;
    private javax.swing.JTextField SummaryTextField;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JTextField TitleTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
