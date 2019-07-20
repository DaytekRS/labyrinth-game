package Game;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import Game.*;

public class Map extends JPanel{
	private int x,y;
	
	
	public Box [] box_coord=new Box[256];
	
	private Image map=new ImageIcon("img/map/map.png").getImage();
	public Image box=new ImageIcon("img/map/box.png").getImage();
	Enemy [] enemy;
	
	public int number_box;
	void setBox(){
	for (int i=0;i<195;i++){
		box_coord[i]=new Box();
	}	
//-------------------------------------------
//1 lvl		
		for (int i=0;i<10;i++){
			box_coord[i].x=-100+i*26;
			box_coord[i].y=450;
		}
		for (int i=10;i<21;i++){
			box_coord[i].x=212+(i-10)*26;
			box_coord[i].y=450;
		}
//-------------------------------------------	
//2 lvl	
		box_coord[21].x=-100;
		box_coord[21].y=424;
		box_coord[22].x=-22;
		box_coord[22].y=424;
		box_coord[23].x=134;
		box_coord[23].y=424;
		box_coord[24].x=472;
		box_coord[24].y=424;
//---------------------------------------------
//3 lvl
		box_coord[25].x=-100;
		box_coord[25].y=398;
		box_coord[26].x=-22;
		box_coord[26].y=398;
		box_coord[27].x=134;
		box_coord[27].y=398;
		box_coord[28].x=472;
		box_coord[28].y=398;
//---------------------------------------------
//grani
		for(int i=0;i<21;i++){
			box_coord[28+i].x=-100;
			box_coord[28+i].y=450-(26*(i+2));
			box_coord[49+i].x=472;
			box_coord[49+i].y=450-(26*(i+2));
		}
		for(int i=0;i<24;i++){
			int z=i;
			if (i>=7) z=i+2;
			box_coord[70+i].x=-100+z*26;
			box_coord[70+i].y=-148;
		}
//----------------------------------------------
//4 lvl
	for(int i=0;i<14;i++){
		box_coord[94+i].x=-100+(i+6)*26;
		box_coord[94+i].y=372;
	}
//---------------------------------------------
		box_coord[108].x=342;
		box_coord[108].y=346;
		box_coord[109].x=342;
		box_coord[109].y=320;
		box_coord[110].x=342;
		box_coord[110].y=294;
		
		
		box_coord[111].x=30;
		box_coord[111].y=294;
		box_coord[112].x=30;
		box_coord[112].y=268;
		
		for (int i=0;i<5;i++){
			box_coord[113+i].x=-74+i*26;
			box_coord[113+i].y=242;
			
			box_coord[124+i].x=264;
			box_coord[124+i].y=268-i*26;
			
			box_coord[146+i].x=-22+i*26;
			box_coord[146+i].y=164;
			
			box_coord[165+i].x=394;
			box_coord[165+i].y=60-i*26;
		}
		
		for (int i=0;i<6;i++){
			box_coord[118+i].x=108;
			box_coord[118+i].y=294-i*26;
			
			box_coord[129+i].x=290+i*26;
			box_coord[129+i].y=216;
			
			box_coord[176+i].x=212;
			box_coord[176+i].y=8-i*26;
			
			box_coord[182+i].x=4;
			box_coord[182+i].y=8-i*26;
		}
		box_coord[135].x=420;
		box_coord[135].y=242;
		box_coord[136].x=420;
		box_coord[136].y=268;
		box_coord[137].x=446;
		box_coord[137].y=268;
		
		box_coord[138].x=134;
		box_coord[138].y=242;
		box_coord[139].x=160;
		box_coord[139].y=242;
		
		box_coord[154].x=-74;
		box_coord[154].y=86;
		box_coord[155].x=-48;
		box_coord[155].y=86;
		
		box_coord[191].x=-22;
		box_coord[191].y=-44;
		box_coord[192].x=108;
		box_coord[192].y=8;
		box_coord[193].x=186;
		box_coord[193].y=8;
		
		for (int i=0;i<3;i++){
			box_coord[140+i].x=212;
			box_coord[140+i].y=138-i*26;
			box_coord[143+i].x=238;
			box_coord[143+i].y=138-i*26;
			box_coord[151+i].x=-22;
			box_coord[151+i].y=138-i*26;
			box_coord[156+i].x=82+i*26;
			box_coord[156+i].y=86;
			box_coord[159+i].x=56;
			box_coord[159+i].y=86-i*26;
			
			box_coord[162+i].x=342+i*26;
			box_coord[162+i].y=86;
			
			box_coord[170+i].x=290;
			box_coord[170+i].y=8-i*26;
			
			box_coord[173+i].x=316+i*26;
			box_coord[173+i].y=-44;
			
			box_coord[188+i].x=30+i*26;
			box_coord[188+i].y=8;
		}
		number_box=194;
		box_coord[194].x=82;
		box_coord[194].y=-148;
	}
	public Map(Enemy [] temp){
		x=-100;
		y=-500;
		setBox();
		enemy=temp;
	}
//--------------------------------------------------------
//Геттеры	
	public Image getMap(){
		return map;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getNumberBox(){
		return number_box;
	}
//--------------------------------------------------------
	public void incY(){
		y=y+2;
		for (int i=0;i<number_box+1;i++)
			box_coord[i].y=box_coord[i].y+2;
		enemy[0].incY();
		enemy[1].incY();
		enemy[2].incY();
	}
	public void decY(){
		y=y-2;
		for (int i=0;i<number_box+1;i++)
			box_coord[i].y=box_coord[i].y-2;
		enemy[0].decY();
		enemy[1].decY();
		enemy[2].decY();
	}
	public void incX(){
		x=x+2;
		for (int i=0;i<number_box+1;i++)
			box_coord[i].x=box_coord[i].x+2;
		enemy[0].incX();
		enemy[1].incX();
		enemy[2].incX();
	}
	public void decX(){
		x=x-2;
		for (int i=0;i<number_box+1;i++)
			box_coord[i].x=box_coord[i].x-2;
		enemy[0].decX();
		enemy[1].decX();
		enemy[2].decX();
	}
	
}