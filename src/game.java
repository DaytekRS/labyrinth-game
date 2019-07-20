import javax.swing.*;
import java.awt.*;
import Game.*;
import java.awt.event.*;

class DrawPanel extends JPanel implements ActionListener{
	JFrame frame;
	Timer timer = new Timer(1, this);
	Map map;
	Enemy [] enemy=new Enemy[3];
	
	Player player;
	Image win,lose;
//---------------------------------------------------------------------
//Conteiner
	public DrawPanel(JFrame frame){
		enemy[0]=new Enemy();
	    enemy[1]=new Enemy();
		enemy[2]=new Enemy();
		enemy[0].setDir(true,-74,290,326);
		enemy[1].setDir(false,-122,40,136);
		enemy[2].setDir(false,170,326,216);
		map=new Map(enemy);
		player=new Player(map,enemy);
		timer.start();
		this.frame = frame;
		win=new ImageIcon("img/game/win.png").getImage();
		lose=new ImageIcon("img/game/lose.png").getImage();
		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				player.keyPressed(e);
			}
			public void keyReleased(KeyEvent e) {
				player.keyReleased(e);
			}
			
		});
	}
//------------------------------------------------------------------	
//Draw box
	public void drawBox(Graphics g){
		for (int i=0;i<map.number_box;i++){
			g.drawImage(map.box,map.box_coord[i].x,map.box_coord[i].y,26,26,this);
		}
	}
//---------------------------------------------------------------------
//Draw frame
	public void paintComponent(Graphics g){
		if ((player.endGame()==false)&&(player.getLive()==true)){
			g.drawImage(map.getMap(),map.getX(),map.getY(),this);
			g.setColor(Color.GREEN);
			g.drawImage(player.getFrame(),player.getX(),player.getY(),44,44,this);
			g.drawImage(enemy[0].getFrame(),enemy[0].getX(),enemy[0].getY(),50,36,this);
			g.drawImage(enemy[1].getFrame(),enemy[1].getX(),enemy[1].getY(),50,36,this);
			g.drawImage(enemy[2].getFrame(),enemy[2].getX(),enemy[2].getY(),50,36,this);
			drawBox(g);
		}else{
			if (player.endGame()==true) g.drawImage(win,0,-50,this);
			else g.drawImage(lose,0,-100,this);
		}
	}
//---------------------------------------------------------------------
//Reload frame
	public void actionPerformed(ActionEvent e) {
		player.setKeys();
		frame.repaint();
	}
	
}



class Game{
	public static void main(String [] args){
		JFrame frame=new JFrame("Labyrinth");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		DrawPanel draw = new DrawPanel(frame);
		draw.setBackground(Color.ORANGE);
		frame.add(draw);
		
		
		
		frame.setSize(new Dimension (400 , 500));
		frame.setVisible(true);
	
		
	}
}