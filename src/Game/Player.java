package Game;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class Player extends Character {
    Timer timer = new Timer(150, this);
	boolean [] keys=new boolean[512];
	Image [] frame_player=new Image[26];
	boolean left;
	boolean rest;
	boolean up;
	Map map;
	Enemy [] enemy;
	boolean live;
	boolean game;
	
	public Player(Map temp,Enemy [] temp2){
		live=true;
		enemy=temp2;
		game=false;
		map=temp;
		x=164;
		y=428;
		up=false;
		rest=true;
		left=true;
		timer.start();
		//------------------------------------------------------------
		//отдых лево
		frame_player[0]=new ImageIcon("img/player/1_l.png").getImage();
		frame_player[1]=new ImageIcon("img/player/2_l.png").getImage();
		frame_player[2]=new ImageIcon("img/player/3_l.png").getImage();
		frame_player[3]=new ImageIcon("img/player/4_l.png").getImage();
		frame_player[4]=frame_player[2];
		frame_player[5]=frame_player[1];
		//----------------------------------------------------------------
		//отдых право
		frame_player[6]=new ImageIcon("img/player/1_r.png").getImage();
		frame_player[7]=new ImageIcon("img/player/2_r.png").getImage();
		frame_player[8]=new ImageIcon("img/player/3_r.png").getImage();
		frame_player[9]=new ImageIcon("img/player/4_r.png").getImage();
		frame_player[10]=frame_player[8];
		frame_player[11]=frame_player[7];
		//----------------------------------------------------------------
		//ходьба лево
		frame_player[12]=new ImageIcon("img/player/5_l.png").getImage();
		frame_player[13]=new ImageIcon("img/player/6_l.png").getImage();
		frame_player[14]=new ImageIcon("img/player/7_l.png").getImage();
		frame_player[15]=new ImageIcon("img/player/8_l.png").getImage();
		frame_player[16]=new ImageIcon("img/player/9_l.png").getImage();
		frame_player[17]=new ImageIcon("img/player/10_l.png").getImage();
		frame_player[18]=new ImageIcon("img/player/11_l.png").getImage();
		//----------------------------------------------------------------
		//ходьба право
		frame_player[19]=new ImageIcon("img/player/5_r.png").getImage();
		frame_player[20]=new ImageIcon("img/player/6_r.png").getImage();
		frame_player[21]=new ImageIcon("img/player/7_r.png").getImage();
		frame_player[22]=new ImageIcon("img/player/8_r.png").getImage();
		frame_player[23]=new ImageIcon("img/player/9_r.png").getImage();
		frame_player[24]=new ImageIcon("img/player/10_r.png").getImage();
		frame_player[25]=new ImageIcon("img/player/11_r.png").getImage();
		//----------------------------------------------------------------
	}
	
	boolean check_enemy(int new_x,int new_y){
		for (int i=0;i<3;i++){
			if (((new_x<=enemy[i].getX()+50)&&(new_x>=enemy[i].getX()))||((new_x+44<=enemy[i].getX()+50)&&(new_x+44>=enemy[i].getX()))) {
				if ((new_y>=enemy[i].getY())&&(new_y<=enemy[i].getY()+36)) return true;
				if ((new_y+44>=enemy[i].getY())&&(new_y+44<=enemy[i].getY()+36)) return true;
				if ((new_y<=enemy[i].getY())&&(new_y+44>=enemy[i].getY()+36)) return true;
			}
			
			
			if (((new_y<=enemy[i].getY()+36)&&(new_y>=enemy[i].getY()))||((new_y+44<=enemy[i].getY()+36)&&(new_y+44>=enemy[i].getY()))){
				if ((new_x>=enemy[i].getX())&&(new_x<=enemy[i].getX()+50)) return true;
				if ((new_x+44>=enemy[i].getX())&&(new_x+44<=enemy[i].getX()+50)) return true;
				if ((new_x<=enemy[i].getX())&&(new_x+44>=enemy[i].getX()+50)) return true;
			}
		}
		return false;
	}
	boolean check_box(int new_x,int new_y){
		for (int i=0;i<map.getNumberBox();i++){
			if (((new_x<=map.box_coord[i].x+26)&&(new_x>=map.box_coord[i].x))||((new_x+44<=map.box_coord[i].x+26)&&(new_x+44>=map.box_coord[i].x))) {
				if ((new_y>=map.box_coord[i].y)&&(new_y<=map.box_coord[i].y+26)) return true;
				if ((new_y+44>=map.box_coord[i].y)&&(new_y+44<=map.box_coord[i].y+26)) return true;
				if ((new_y<=map.box_coord[i].y)&&(new_y+44>=map.box_coord[i].y+26)) return true;
			}
			
			
			if (((new_y<=map.box_coord[i].y+26)&&(new_y>=map.box_coord[i].y))||((new_y+44<=map.box_coord[i].y+26)&&(new_y+44>=map.box_coord[i].y))){
				if ((new_x>=map.box_coord[i].x)&&(new_x<=map.box_coord[i].x+26)) return true;
				if ((new_x+44>=map.box_coord[i].x)&&(new_x+44<=map.box_coord[i].x+26)) return true;
				if ((new_x<=map.box_coord[i].x)&&(new_x+44>=map.box_coord[i].x+26)) return true;
			}
			
		}
		return false;
	}
	
	boolean check (int new_x,int new_y){
		
     
		if ((new_x>=map.box_coord[194].x)&&(new_x<=map.box_coord[194].x+52)&&(new_y<map.box_coord[194].y)){
			game=true;
			return true;
		}
		if (check_box(new_x,new_y)==true) return true;
		return false;
	}
	
	public void setKeys(){
		if ((keys[87]==true)&&(keys[65]==true)) return;
		if ((keys[87]==true)&&(keys[68]==true)) return;
		if ((keys[83]==true)&&(keys[65]==true)) return;
		if ((keys[83]==true)&&(keys[68]==true)) return;
		
		if (keys[87]==true) {
			if (y<30){
				if (map.getY()!=0){
					if (check(x,y-2)==false) map.incY();
				}
				else 
					if (y!=0) 
						if (check(x,y-2)==false) y=y-2;
			}
			else 
				if (check(x,y-2)==false) y=y-2;
			
			if (rest==true){
				if (left==true) frame=12;
				else frame=19;	
			}
		
			up=true;
			rest=false;
		}
		if (keys[83]==true) {
			if (y>400) {
				if (map.getY()!=-500){
					if (check(x,y+2)==false) map.decY();
				}
				else 
					if (y!=430) 
						if (check(x,y+2)==false) y=y+2;
			}
			else 
				if (check(x,y+2)==false) y=y+2;
			if (rest==true){
				if (left==true) frame=12;
				else frame=19;	
			}
			rest=false;
			up=true;
		}
		if (keys[65]==true) {
			
			if (x<24) {
				if (map.getX()!=0) {
					if (check(x-2,y)==false) map.incX();
				}
				else 
					if (x!=6) 
						if (check(x-2,y)==false) x=x-2;
			}
			else 
				if (check(x-2,y)==false) x=x-2;

			if (rest==true) frame=12;
			if (left==false) frame=12;
			if (up==true) {
				frame=12;
				up=false;
			}
			
			rest=false;
			left=true;
		}
		if (keys[68]==true) {
			if (x>330) {
				if (map.getX()!=-200){
					if (check(x+2,y)==false) map.decX();
				}
				else 
					if (x!=350) 
						if (check(x+2,y)==false) x=x+2;
			}
			else 
				if (check(x+2,y)==false) x=x+2;
			
			if (rest==true) frame=19;
			if (left==true) frame=19;	
			if (up==true) {
				frame=19;
				up=false;
			}
			rest=false;
			left=false;
		}
		if ((keys[87]==false)&&(keys[83]==false)&&(keys[65]==false)&&(keys[68]==false)) {
			if ((left==true)&&(rest==false)) frame=0;
			else  if (rest==false) frame=6;
			rest=true;
			
		}
	}
//--------------------------------------------------------------------------
//Отслеживание нажатия клавиш
	public void keyPressed(KeyEvent e){
		if ((game==false)&&(live==true)){
			int key = e.getKeyCode();
			keys[key]=true;
		}else System.exit(1);
		
	}
	public void keyReleased(KeyEvent e){
		if ((game==false)&&(live==true)){
			int key = e.getKeyCode();
			keys[key]=false;
		}
	}
//---------------------------------------------------------------------------
//геттеры	
	public Image getFrame(){
		return frame_player[frame];
	}
	public boolean getLive(){
		return live;
	}
	public boolean endGame(){
		return game;
	}
//--------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e) {
		if (check_enemy(x,y)==true) live=false;
			frame++;
		if (rest==true){
			if ((frame==6)&&(left==true)) frame=0;
			else if (frame==12) frame=6;
		}
		else {
			if ((frame==19)&&(left==true)) frame=12;
			else if (frame==26) frame=19;
		}
	}
}