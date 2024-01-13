import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class PongPanel extends JPanel{
	//Properties
	int intP1Y = 250;
	int intP2Y = 250; 
	int intP1Def = 0;
	int intP2Def = 0;
	
	int intBallX = 395;
	int intBallY = 290;
	int intBallDefX = 0;
	int intBallDefY = 0;
	
	int intP1Score = 0;
	int intP2Score = 0;
	
	int intServe = 0;
	
	String strP1 = "0";
	String strP2 = "0";
	
	
	BufferedImage winner;
	BufferedImage ball;
	BufferedImage paddles;
	BufferedImage ez;
	
	//line
	int intlinex1 = 400;
	int intlinex2 = 400;
	int intliney1 = 0;
	int intliney2 = 600;
	Font myFont = new Font("Serif", Font.BOLD, 50);
	
	
	//Methods
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//Background
		if(intP2Score == 2 || intP1Score == 2){
			g.setColor(Color.BLUE);
		}else if(intP2Score == 3 || intP1Score == 3){
			g.setColor(Color.BLUE);
		}else if(intP2Score >= 4 || intP1Score >= 4){
			g.setColor(Color.RED);
		}else{
			g.setColor(Color.BLACK);
		}
		g.fillRect(0, 0, 800, 600);
		//P1 Paddle
		g.setColor(Color.WHITE);
		g.drawImage(paddles, 50, intP1Y, null);
		//P2 Paddle
		g.drawImage(paddles, 740, intP2Y, null);
		//Ball
		g.drawImage(ball, intBallX, intBallY, null);
		
		g.setFont(myFont);
		g.drawString(strP1, 180, 100);
		g.drawString(strP2, 580, 100);
		
		g.drawLine(intlinex1, intliney1, intlinex2, intliney2);
		
		//ball movement 
		intBallX = intBallX + intBallDefX;
		intBallY = intBallY + intBallDefY;
		if(intBallY > 590){
			intBallDefY = -3;
		}
		if(intBallY < 0){
			intBallDefY = 3;
		}
		//goal player 1
		if(intBallX > 790){
			intBallX = 395;
			intBallY = 290;
			intBallDefX = 0;
			intBallDefY = 0;
			intP1Score = intP1Score +1;
			strP1 = String.valueOf(intP1Score);
			intServe = 0;
		}
		//goal player 2
		if(intBallX < 0){
			intBallX = 395;
			intBallY = 290;
			intBallDefX = 0;
			intBallDefY = 0;
			intP2Score = intP2Score +1;
			strP2 = String.valueOf(intP2Score);
			intServe = 0;
		}
		
		//winners
		if(intP1Score == 5 && intP2Score > 0){
			g.drawImage(winner, 100, 100, null);
			System.out.println("player 1 wins");
			intP1Score = 0;
			strP1 = String.valueOf(intP1Score);
			intP2Score = 0;
			strP2 = String.valueOf(intP2Score);
		}
		if(intP2Score == 5 && intP1Score > 0){
			g.drawImage(winner, 420, 100, null);
			System.out.println("player 2 wins");
			intP1Score = 0;
			strP1 = String.valueOf(intP1Score);
			intP2Score = 0;
			strP2 = String.valueOf(intP2Score);
		}
		
		//crushed winners
		
		if(intP1Score == 5 && intP2Score == 0){
			g.drawImage(winner, 100, 100, null);
			System.out.println("player 1 wins");
			//EASTER EGG 
			System.out.println("GG EZ Win");
			g.drawImage(ez, 0, 0, null);
			intP1Score = 0;
			strP1 = String.valueOf(intP1Score);
			intP2Score = 0;
			strP2 = String.valueOf(intP2Score);
		}
		if(intP2Score == 5 && intP1Score == 0){
			g.drawImage(winner, 420, 100, null);
			System.out.println("player 2 wins");
			//EASTER EGG
			System.out.println("GG EZ Win");
			g.drawImage(ez, 0, 0, null);
			intP1Score = 0;
			strP1 = String.valueOf(intP1Score);
			intP2Score = 0;
			strP2 = String.valueOf(intP2Score);
		}
		
		
		//Left paddle collision detection
		if(intBallX <= 60 && intBallX >= 58 && intBallY > intP1Y - 10 && intBallY < intP1Y + 100){
			intBallDefX = 3;
		}
		if(intBallX <= 60 && intBallX >= 58 && intBallY > intP1Y - 10 && intBallY < intP1Y + 100){
			intBallDefX = 3;
		}
		
		//Right paddle collision detection
		if(intBallX >= 730 && intBallX <= 732 && intBallY > intP2Y - 10 && intBallY < intP2Y + 100){
			intBallDefX = -3;
		}
		
		//paddle movement 
		intP1Y = intP1Y + intP1Def;
		if(intP1Y <= 0 || intP1Y >= 500){
			intP1Def = 0;
		}
		intP2Y = intP2Y + intP2Def;
			
		
		
		
	}
	
	
	//Constructor
	public PongPanel(){
		super();
		try{
			ez = ImageIO.read(new File("ez.jpg"));
		}catch(IOException e){
			System.out.println("Invalid Picture");
		}
		try{
			winner = ImageIO.read(new File("trophy.png"));
		}catch(IOException e){
			System.out.println("Invalid Picture");
		}
		try{
			ball = ImageIO.read(new File("ball.png"));
		}catch(IOException e){
			System.out.println("Invalid Picture");
		}
		try{
			paddles = ImageIO.read(new File("paddle.png"));
		}catch(IOException e){
			System.out.println("Invalid Picture");
		}
	}
}
