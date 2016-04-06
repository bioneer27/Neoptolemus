package Kabasuji;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PlayMenuView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayMenuView frame = new PlayMenuView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlayMenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 250, 205));
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(123, 104, 238));
		btnNewButton.setIcon(new ImageIcon(PlayMenuView.class.getResource("/Images/LightningLevelIcon.png")));
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 26));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnPuzzle = new JButton("");
		btnPuzzle.setIcon(new ImageIcon(PlayMenuView.class.getResource("/Images/PuzzleLevelIcon.png")));
		btnPuzzle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 26));
		
		JButton btnRelease = new JButton("");
		btnRelease.setIcon(new ImageIcon(PlayMenuView.class.getResource("/Images/ReleaseLevelIcon.png")));
		btnRelease.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 26));
		
		JLabel lblNewLabel = new JLabel("Lightning");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 26));
		
		JLabel lblPuzzle = new JLabel("Puzzle");
		lblPuzzle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 26));
		
		JLabel lblRelease = new JLabel("Release");
		lblRelease.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 26));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 205, 50));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(89)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addGap(74)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnPuzzle, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(27))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPuzzle)
							.addGap(70)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(110)
							.addComponent(btnRelease, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(157)
							.addComponent(lblRelease)))
					.addGap(191))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 979, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPuzzle)
						.addComponent(lblRelease)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRelease, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPuzzle, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
					.addGap(108))
		);
		
		JLabel lblNewLabel_1 = new JLabel("PLAY");
		lblNewLabel_1.setForeground(new Color(255, 250, 205));
		lblNewLabel_1.setBackground(new Color(255, 250, 205));
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 60));
		panel.add(lblNewLabel_1);
		contentPane.setLayout(gl_contentPane);
	}
}
