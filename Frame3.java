package Color_Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.sql.*;

public class Frame3 extends javax.swing.JFrame {

	public Connection CN = null;
	public PreparedStatement ST1 = null;
	public PreparedStatement ST2 = null;
	public ResultSet RS = null;
	public ResultSet RMX = null;
	String name;
	int Score;
	int HSc;
	
	public Frame3() {
		initialize();
		initComponents();
	}

	private void initialize(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			CN = DriverManager.getConnection("jdbc:mysql://localhost:3306/color chasing game?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
			
			String stat1 = "select * from data";
			ST1 =CN.prepareStatement(stat1);
			RS =ST1.executeQuery();

			while (RS.next()) {
				name = RS.getString("Name");
				Score = RS.getInt("Score");
			}
			
			String stat2 = "select Max(Score) from data";
			ST2 = CN.prepareStatement(stat2);
			RMX = ST2.executeQuery();
			if (RMX.next()==true)
			{
				HSc = RMX.getInt(1);
			}
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(ST1!=null || ST2!=null)
					CN.close();
			}catch(SQLException se){
			
			}
			try{
				if(CN!=null)
					CN.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

                jLabel1 = new JLabel();
                score = new JLabel();
                Hscore = new JLabel();
                Play = new JButton();
                Exit = new JButton();
                PlayNew = new JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(204, 0, 51));
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setText("Game Over!");

                score.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                score.setText(name+", Your Score is "+Score);

                Hscore.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                Hscore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                Hscore.setText("Highest Score: "+HSc);

                Play.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                Play.setText("Play Again!");
                Play.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                PlayActionPerformed(evt);
                        }
                });

                Exit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                Exit.setText("EXIT");
                Exit.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                ExitActionPerformed(evt);
                        }
                });

                PlayNew.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                PlayNew.setText("Play as A new Player");
                PlayNew.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                PlayNewActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(score, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Hscore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(Play, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PlayNew, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(105, 105, 105))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(score, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Hscore, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Play, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                        .addComponent(PlayNew, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                .addGap(17, 17, 17))
                );

                pack();
        }// </editor-fold>                        

        private void PlayActionPerformed(java.awt.event.ActionEvent evt) {                                     
                Frame2 fr = new Frame2();
		fr.show();
		dispose();
		Play.removeActionListener((ActionListener) fr);
        }                                    

        private void ExitActionPerformed(java.awt.event.ActionEvent evt) {                                     
                System.exit(0);
        }                                    

        private void PlayNewActionPerformed(java.awt.event.ActionEvent evt) {                                        
                Frame1 fr = new Frame1();
		fr.show();
		dispose();
		PlayNew.removeActionListener((ActionListener) fr);
        }                                       

	public static void main(String args[]) {
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Frame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Frame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Frame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Frame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Frame3().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify                     
        private JButton Exit;
        private JLabel Hscore;
        private JButton Play;
        private JButton PlayNew;
        private JLabel jLabel1;
        private JLabel score;
        // End of variables declaration                   
}
