/*
 * 
 */
package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import builderModel.LBModel;
import builderView.AllLevelsView;
import builderView.LevelBuilderView;

/**
 * The Class AllLevelsController.
 */
public class AllLevelsController implements ActionListener{

	/** The model. */
	LBModel model;
	
/** The lvl view. */
//	Views that this view can get to
	LevelBuilderView lvlView;
	
/** The all view. */
//	Personal copy of the boundary to dispose
	AllLevelsView allView;
	
	/**
	 * Instantiates a new all levels controller.
	 *
	 * @param allView
	 *            the all view
	 * @param model
	 *            the model
	 */
	public AllLevelsController(AllLevelsView allView, LBModel model){
		this.lvlView = allView.getLevelView();
		this.allView = allView;
		this.model = model;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		
		//open level 1
		if(source.getName().equals("level1")){
			lvlView = new LevelBuilderView(model, model.getLevel(allView.getLevelType(), 1));
			lvlView.setVisible(true);
		}
		
		//open level 2
		if(source.getName().equals("level2")){
			lvlView = new LevelBuilderView(model, model.getLevel(allView.getLevelType(), 2));
			lvlView.setVisible(true);
		}

		//open level 3
		if(source.getName().equals("level3")){
			lvlView = new LevelBuilderView(model, model.getLevel(allView.getLevelType(), 3));
			lvlView.setVisible(true);
		}

		//open level 4
		if(source.getName().equals("level4")){
			lvlView = new LevelBuilderView(model, model.getLevel(allView.getLevelType(), 4));
			lvlView.setVisible(true);
		}

		//open level 5
		if(source.getName().equals("level5")){
			lvlView = new LevelBuilderView(model, model.getLevel(allView.getLevelType(), 5));
			lvlView.setVisible(true);
		}
		
		//close current screen
		allView.dispose();
	}

}