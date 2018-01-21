import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.event.MouseInputAdapter;

public class DragListener extends MouseInputAdapter implements MouseListener
{
    Point location;
    MouseEvent pressed;
    JLabel i1, i2, i3;
    JLabel tab[] = new JLabel[3];

    public DragListener(JLabel i1, JLabel i2, JLabel i3) {
    	this.i1 = i1;
    	this.i2 = i2;
    	this.i3 = i3;
    	this.tab[0] = this.i1;
    	this.tab[1] = this.i2;
    	this.tab[2] = this.i3;
    	
    }
    
    public void mousePressed(MouseEvent me)
    {
        pressed = me;
    }

    public void mouseDragged(MouseEvent me)
    {
        Component component = me.getComponent();
        location = component.getLocation(location);
        int x = location.x - pressed.getX() + me.getX();
        int y = location.y - pressed.getY() + me.getY();
        component.setLocation(x, y);
    }
    
    public void mouseReleased(MouseEvent me) {
    	Component component = me.getComponent();
        location = component.getLocation(location);
        for(int i=0 ; i<tab.length ; i++) {
        	if(isTouchedDown(location, tab[i])) {
        		tab[i].setLocation(200, 200);
        		component.setLocation(200, 305);
        		System.out.println("YEAH DOWN");
        	}
        	if(isTouchedUp(location, tab[i])) {
        		tab[i].setLocation(200, 200);
        		component.setLocation(200, 95);
        		System.out.println("YEAH UP");
        	}
        }
    	
    }
    
    public boolean isTouchedDown(Point j1, JLabel j2) {
    	if(j1.getX() >= (j2.getLocation().getX()-20)
    	&& j1.getX() <= (j2.getLocation().getX()+20)
    	&& j1.getY() >= (j2.getLocation().getY()+90)
    	&& j1.getY() <= (j2.getLocation().getY()+120))
    		return true;
    	return false;
    }
    
    public boolean isTouchedUp(Point j1, JLabel j2) {
    	if(j1.getX() >= (j2.getLocation().getX()-20)
    	&& j1.getX() <= (j2.getLocation().getX()+20)
    	&& j1.getY() >= (j2.getLocation().getY()-120)
    	&& j1.getY() <= (j2.getLocation().getY()-90))
    		return true;
    	return false;
    }
    
}
