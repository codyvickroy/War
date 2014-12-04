/**
 *  Cody Vickroy
 *  Java 110 | UVM
 *  December 3rd, 2014
 * 
 *  War's GUI
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardGameGUI extends JFrame{
    
    private	CardGame game;
    private JPanel topPanel,gamePanel;
    private JButton draw;
    private JLabel status;
    private JLabel title;

    public CardGameGUI(){
    	setLayout(new GridLayout(2,1));
    	game = new CardGame();
    	topPanel = new JPanel();
    	draw = new JButton("Draw");
    	topPanel.setBackground(Color.green);

    	title = new JLabel("War");											//create our title
    	title.setFont(new Font("HELVETICA",Font.ITALIC,36));
    	topPanel.add(title);

   		status = new JLabel(" - Playing");									//keeps tally
	    status.setFont(new Font("ARIAL",Font.BOLD,24));
	    topPanel.add(status);

	    add(topPanel);
      	add(gamePanel);

    }//end default constructor
    
    public class ButtonListner implements ActionListner{
    	public void actionPreformed(ActionEvent e){
    		JButton draw = (JButton)(e.getSource());

    		//sets the cards
    		if(game.draw(0)){
    			ImageIcon background = new ImageIcon(game.getUCard()+".jpg");
				JLabel label = new JLabel();
				label.setBounds(100, 100, x, y);
				label.setIcon(background);

				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.add(label);
    		}else if(game.draw(1)){
    			ImageIcon background = new ImageIcon(game.getCCard()+".jpg");
				JLabel label = new JLabel();
				label.setBounds(255, 100, x, y);
				label.setIcon(background);

				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.add(label);
    		}//end if

			//changes the label
			if(game.setStatus()){
				status = new JLabel(game.setStatus());
			    status.setFont(new Font("ARIAL",Font.BOLD,24));
			    topPanel.add(status);
			}





    	}//ends actionPreformes
    }//ends ButtonListner
    
    
}
