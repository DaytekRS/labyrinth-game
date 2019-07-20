package Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public abstract class Character implements ActionListener{
	protected int frame=0;
	protected int x;
	protected int y;
	
	public abstract Image getFrame();
	
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
}