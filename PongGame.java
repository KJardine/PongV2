import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class PongGame implements ActionListener, KeyListener, MouseMotionListener{
	//Properties
	JFrame theFrame = new JFrame("Pong Game");
	PongPanel thePanel = new PongPanel();
	Timer theTimer = new Timer(1000/60, this);
	
	
	//Methods
	public void mouseMoved(MouseEvent evt){	
	}
	public void mouseDragged(MouseEvent evt){
	}
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == theTimer){
			thePanel.repaint();
		}
	}
	public void keyReleased(KeyEvent evt){
		//p1
		if(evt.getKeyChar() == 'w'){
			thePanel.intP1Def = 0;
		}else if(evt.getKeyChar() == 's'){
			thePanel.intP1Def = 0;
		}
		//p2
		if(evt.getKeyCode()==38){
			thePanel.intP2Def = 0;
		}else if(evt.getKeyCode()==40){
			thePanel.intP2Def = 0;
		}
	}
	public void keyPressed(KeyEvent evt){
		//p1
		if(evt.getKeyChar() == 'w' && thePanel.intP1Y >= 0){
			thePanel.intP1Def = -3;
		}else if(evt.getKeyChar() == 'w' && thePanel.intP1Y <= 0){
			thePanel.intP1Def = 0;
		}else if(evt.getKeyChar() == 's' && thePanel.intP1Y <= 500){
			thePanel.intP1Def = 3;
		}else if(evt.getKeyChar() == 's' && thePanel.intP1Y >= 500){
			thePanel.intP1Def = 0;
		}
		//p2
		if(evt.getKeyCode() == 38 && thePanel.intP2Y >= 0){
			thePanel.intP2Def = -3;
		}else if(evt.getKeyCode() == 38 && thePanel.intP2Y <= 0){
			thePanel.intP2Def = 0;
		}else if(evt.getKeyCode() == 40 && thePanel.intP2Y <= 500){
			thePanel.intP2Def = 3;
		}else if(evt.getKeyCode() == 40 && thePanel.intP2Y >= 500){
			thePanel.intP2Def = 0;
		}
		//serve
		if(evt.getKeyCode()==32 && thePanel.intServe == 0){
			thePanel.intBallDefX = 3;
			thePanel.intBallDefY = 3;
			thePanel.intServe = 1;
		}
	}
	public void keyTyped(KeyEvent evt){
	}
	
	//Constructor
	public PongGame(){
		thePanel.setPreferredSize(new Dimension(800, 600));
		thePanel.addMouseMotionListener(this);
		theFrame.setContentPane(thePanel);
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.pack();
		theFrame.setVisible(true);
		theFrame.setResizable(false);
		theFrame.addKeyListener(this);
		theTimer.start();
		
		
	}
	
	//main method
	public static void main(String[] args){
		new PongGame(); 
	}
}
