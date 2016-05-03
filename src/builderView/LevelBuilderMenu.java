/*
 * 
 */
package builderView;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import builderController.LevelBuilderMenuController;
import builderModel.LBModel;

/**
 * @author Jetro
 *
 */
public class LevelBuilderMenu extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The table. */
	private JTable table;
	
	/** The create clicked. */
	private boolean createClicked = false;
	
	public boolean isCreateClicked() {
		return createClicked;
	}

	public void setCreateClicked(boolean createClicked) {
		this.createClicked = createClicked;
	}

	public boolean isEditClicked() {
		return editClicked;
	}

	public void setEditClicked(boolean editClicked) {
		this.editClicked = editClicked;
	}

	public boolean isDeleteClicked() {
		return deleteClicked;
	}

	public void setDeleteClicked(boolean deleteClicked) {
		this.deleteClicked = deleteClicked;
	}

	/** The edit clicked. */
	private boolean editClicked = false;
	
	/** The delete clicked. */
	private boolean deleteClicked = false;
	
//	radio buttons in the view
	private JRadioButton createLevel;
	private JRadioButton editLevel;
	private JRadioButton deleteLevel;
	
//	buttons in the view
	private JButton lightning;
	private JButton puzzle;
	private JButton release;
	
//	The model
	LBModel model;
	
//	Views that this view can get to
	LevelBuilderView view;
	
	AllLevelsView allView;


	/**
	 * Create the application.
	 */
	public LevelBuilderMenu(LBModel model) {
		this.model = model;
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		setup JFrame
		setResizable(false);
		setBackground(new Color(255, 250, 205));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JTable();

//		setup JLabel for create
		JLabel lblCreateLevel = new JLabel("Create Level");
		lblCreateLevel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		
//		setup JLabel for edit
		JLabel lblEditLevel = new JLabel("Edit Level");
		lblEditLevel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		
//		setup JLabel for delete
		JLabel lblDeleteLevel = new JLabel("Delete Level");
		lblDeleteLevel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		
//		setup JLabel for Lightning
		JLabel lblLightning = new JLabel("Lightning");
		lblLightning.setForeground(new Color(100, 149, 237));
		lblLightning.setHorizontalAlignment(SwingConstants.CENTER);
		lblLightning.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		
//		setup JLabel for Puzzle
		JLabel lblPuzzle = new JLabel("Puzzle");
		lblPuzzle.setForeground(new Color(240, 128, 128));
		lblPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuzzle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		
//		setup JLabel for Release
		JLabel lblRelease = new JLabel("Release");
		lblRelease.setForeground(new Color(244, 164, 96));
		lblRelease.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelease.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));

//		setup JRadioButton for create
		setCreateLevel(new JRadioButton("create"));
		getCreateLevel().setName("create");
		getCreateLevel().addActionListener(new LevelBuilderMenuController(this, model));
		
//		setup JRadioButton for edit
		setEditLevel(new JRadioButton("edit"));
		getEditLevel().setName("edit");
		getEditLevel().addActionListener(new LevelBuilderMenuController(this, model));
		
//		setup JRadioButton for delete
		setDeleteLevel(new JRadioButton("delete"));
		getDeleteLevel().setName("delete");
		getDeleteLevel().addActionListener(new LevelBuilderMenuController(this, model));
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(getCreateLevel());
		radioGroup.add(getEditLevel());
		radioGroup.add(getDeleteLevel());
	
//		setup JButton for Lightning
		setLightning(new JButton("lightning"));
		getLightning().setName("Lightning");
		getLightning().setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getLightning().setBackground(new Color(100, 149, 237));
		getLightning().setIcon(new ImageIcon(LevelBuilderMenu.class.getResource("/Images/LightningLevelIcon.png")));
		getLightning().addActionListener(new LevelBuilderMenuController(this, model));
		
//		setup JButton for Puzzle
		setPuzzle(new JButton("puzzle"));
		getPuzzle().setName("Puzzle");
		getPuzzle().setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getPuzzle().setBackground(new Color(240, 128, 128));
		getPuzzle().addActionListener(new LevelBuilderMenuController(this, model));
		getPuzzle().setIconTextGap(0);
		getPuzzle().setIcon(new ImageIcon(LevelBuilderMenu.class.getResource("/Images/PuzzleLevelIcon.png")));
		
//		setup JButton for Release
		setRelease(new JButton("release"));
		getRelease().setName("Release");
		getRelease().setBackground(new Color(244, 164, 96));
		getRelease().setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getRelease().addActionListener(new LevelBuilderMenuController(this, model));
		getRelease().setIcon(new ImageIcon(LevelBuilderMenu.class.getResource("/Images/ReleaseLevelIcon.png")));
		
//		setup JPanel
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 205));
		panel.setBackground(new Color(30, 144, 255));
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(87)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
									.addGap(68)
									.addComponent(getCreateLevel()))
								.addComponent(lblLightning, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(110)
							.addComponent(lblCreateLevel)))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(171)
									.addComponent(lblEditLevel))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(204)
									.addComponent(getEditLevel(), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(148)
							.addComponent(lblPuzzle, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(211)
							.addComponent(getDeleteLevel(), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(170)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDeleteLevel)
								.addComponent(lblRelease, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(78, Short.MAX_VALUE))
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(78)
					.addComponent(getLightning(), GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addGap(134)
					.addComponent(getPuzzle(), GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
					.addComponent(getRelease(), GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addGap(64))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblCreateLevel)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(19)
										.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
									.addComponent(getCreateLevel())))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblEditLevel)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(getEditLevel())))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDeleteLevel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(getDeleteLevel())
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPuzzle)
						.addComponent(lblLightning)
						.addComponent(lblRelease))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(getLightning(), GroupLayout.PREFERRED_SIZE, 195, Short.MAX_VALUE)
						.addComponent(getPuzzle(), GroupLayout.PREFERRED_SIZE, 195, Short.MAX_VALUE)
						.addComponent(getRelease(), GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
					.addContainerGap())
		);
		
//		setup Build Label
		JLabel lblBuild = new JLabel("BUILD");
		lblBuild.setForeground(new Color(255, 250, 205));
		lblBuild.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(440, Short.MAX_VALUE)
					.addComponent(lblBuild)
					.addGap(378))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblBuild)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(groupLayout);
	}
	
	public void setCreateLevel(JRadioButton createLevel){
		this.createLevel = createLevel;
	}
	
	public JRadioButton getCreateLevel(){
		return createLevel;
	}
	
	public void setEditLevel(JRadioButton editLevel){
		this.editLevel = editLevel;
	}
	
	public JRadioButton getEditLevel(){
		return editLevel;
	}
	
	public void setDeleteLevel(JRadioButton deleteLevel){
		this.deleteLevel = deleteLevel;
	}
	
	public JRadioButton getDeleteLevel(){
		return deleteLevel;
	}
	
	public void setLightning(JButton lightning){
		this.lightning = lightning;
	}
	
	public JButton getLightning(){
		return lightning;
	}
	
	public void setPuzzle(JButton puzzle){
		this.puzzle = puzzle;
	}
	
	public JButton getPuzzle(){
		return puzzle;
	}
	
	public void setRelease(JButton release){
		this.release = release;
	}
	
	public JButton getRelease(){
		return release;
	}
	
	public LevelBuilderView getLBView(){
		return this.view;
	}
	
	public void setLBView(LevelBuilderView lbView){
		this.view = lbView;
	}
	
	public AllLevelsView getAllView(){
		return this.allView;
	}
	
	public void setAllView(AllLevelsView allView){
		this.allView = allView;
	}
}