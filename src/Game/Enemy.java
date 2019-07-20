package Game;
import Game.Character;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Enemy extends Character {
	Timer timer = new Timer(125, this);
	Image [] frame_enemy=new Image[6];
	boolean left;
	boolean horizont;
	boolean up;
	int b_x,e_x,b_y,e_y;
	public Enemy(){
		x=0;
		y=0;
		timer.start();
		frame_enemy[0]=new ImageIcon("img/enemy/1.png").getImage();
		frame_enemy[1]=new ImageIcon("img/enemy/2.png").getImage();
		frame_enemy[2]=new ImageIcon("img/enemy/3.png").getImage();
		frame_enemy[3]=new ImageIcon("img/enemy/4.png").getImage();
		frame_enemy[4]=frame_enemy[2];
		frame_enemy[5]=frame_enemy[1];
	}
	
	public void incY(){
		b_y=b_y+2;
		e_y=e_y+2;
		y=y+2;
	}
	public void decY(){
		b_y=b_y-2;
		e_y=e_y-2;
		y=y-2;
	}
	public void incX(){
		b_x=b_x+2;
		e_x=e_x+2;
		x=x+2;
	}
	public void decX(){
		b_x=b_x-2;
		e_x=e_x-2;
		x=x-2;
	}
	
	public void setDir(boolean _horizont,int b,int e,int c){
		horizont=_horizont;
		if (horizont!=true){
			x=c;
			y=b;
			b_y=b;
			e_y=e;
			up=false;
		}else{
			left=false;
			y=c;
			x=b;
			b_x=b;
			e_x=e;
		}
	}
	
	public Image getFrame(){
		return frame_enemy[frame];
	}
	
	public void actionPerformed(ActionEvent e) {
		frame++;
		if (horizont!=true){
		
			if (up==false) {
				y=y+5;
				if (y>e_y) up=true;
			}
			else{
				y=y-5;
				if (y<b_y) up=false;
			}
		}else{
			if (left==false){
				x=x+5;
				if (x>e_x) left=true;
			}else {
				x=x-5;
				if (x<b_x) left=false;
			}
		
			
		}
		if (frame==6) frame=0;
	}
	
}