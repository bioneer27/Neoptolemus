package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Kabasuji.Level;
import Kabasuji.LightningLevelView;
import Kabasuji.PieceType;
import Kabasuji.PuzzleLevelView;
import Kabasuji.ReleaseLevelView;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Insets;

public class LevelView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Level model;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelView frame = new LevelView(new Level(1, PieceType.LIGHTNING));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public LevelView(Level model) {
		this.model = model;
	}
	
	public void initialize(JPanel contentPane, JPanel panel){
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		
		JButton btnScrollDown = new JButton("Scroll Down");
		btnScrollDown.setBackground(Color.PINK);
		
		JButton btnScrollUp = new JButton("Scroll Up");
		btnScrollUp.setBackground(Color.PINK);
		
		JPanel panel_2 = new JPanel();
		panel_2.setAlignmentX(0.0f);
		panel_2.setAlignmentY(0.0f);
		//Lightning color 100, 149, 237
		//Puzzle color 240, 128, 128
		//Release color 244, 164, 96
		if(model.getType() == PieceType.LIGHTNING)
			panel_2.setBackground(new Color(100, 149, 237));
		else if(model.getType() == PieceType.PUZZLE)
			panel_2.setBackground(new Color(240, 128, 128));
		else if(model.getType() == PieceType.RELEASE)
			panel_2.setBackground(new Color(244, 164, 96));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnScrollDown)
						.addComponent(btnScrollUp, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(793, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
						.addGap(704)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(btnScrollUp)
					.addGap(398)
					.addComponent(btnScrollDown)
					.addGap(160))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(90)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(50, Short.MAX_VALUE))
		);
		
		JButton btnNewButton_14 = new JButton("");
		//set button listener depending on the level type
				if(model.getType() == PieceType.LIGHTNING){
					btnNewButton_14.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							LightningLevelView window = new LightningLevelView();
							window.getFrame().setVisible(true);
							dispose();
						}
					});
				}
				else if(model.getType() == PieceType.PUZZLE){
					btnNewButton_14.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							PuzzleLevelView window = new PuzzleLevelView();
							window.getFrame().setVisible(true);
							dispose();
						}
					});
				}
				else if(model.getType() == PieceType.RELEASE){
					btnNewButton_14.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							ReleaseLevelView window = new ReleaseLevelView();
							window.getFrame().setVisible(true);
							dispose();
						}
					});
				}
		btnNewButton_14.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton_14.setAlignmentY(0.0f);
		btnNewButton_14.setBackground(new Color(65, 105, 225));
		btnNewButton_14.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_14.setIcon(new ImageIcon(LevelView.class.getResource("/Images/BackIcon.png")));
		
		JLabel lblLevel = new JLabel("LEVEL " + model.getNumber());
		lblLevel.setForeground(new Color(255, 250, 205));
		lblLevel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		
		JLabel lblNewLabel = new JLabel("Star 1");
		lblNewLabel.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
		
		JLabel label = new JLabel("Star 1");
		label.setIcon(new ImageIcon(LevelView.class.getResource("/Images/StarIcon.png")));
		
		JLabel label_1 = new JLabel("Star 1");
		label_1.setIcon(new ImageIcon(LevelView.class.getResource("/Images/NotStarIcon.png")));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(11)
					.addComponent(btnNewButton_14, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(298)
					.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(44))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
								.addComponent(btnNewButton_14, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
}