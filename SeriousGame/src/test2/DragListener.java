package test2;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.event.MouseInputAdapter;

public class DragListener extends MouseInputAdapter implements MouseListener
{
	Point location;
	MouseEvent pressed;
	//JLabel tab[] = new JLabel[3];
	ArrayList tab = new ArrayList();
	Hashtable ht = new Hashtable();
	boolean first= false;

	public DragListener(ArrayList jl) {
		for(int i=0 ; i<jl.size() ; i++) {
			tab.add(jl.get(i));
		}    	
	}

	public void mousePressed(MouseEvent me)
	{
		pressed = me;
	}

	public void mouseDragged(MouseEvent me)
	{
		Component component = me.getComponent();
		location = component.getLocation(location);
		int numPiece = 0;
		for(int i=0 ; i<tab.size() ; i++) {
			if(component.getX() == (int)((Component) tab.get(i)).getX() && component.getY() == (int)((Component) tab.get(i)).getY()) {
				numPiece = i;
			}
		}
		if(!ht.contains(numPiece) && !ht.containsKey(numPiece)) {
			int x = location.x - pressed.getX() + me.getX();
			int y = location.y - pressed.getY() + me.getY();
			component.setLocation(x, y);
		}

	}

	public void mouseReleased(MouseEvent me) {
//		Component component = me.getComponent();
//		location = component.getLocation(location);
//		int numPiece=0;
//		for(int i=0 ; i<tab.size() ; i++) {
//			if(component.getX() == (int)((Component) tab.get(i)).getX() && component.getY() == (int)((Component) tab.get(i)).getY()) {
//				numPiece = i;
//			}
//		}
//		if(!ht.contains(numPiece) && !ht.containsKey(numPiece)) {
//			for(int i=0 ; i<tab.size() ; i++) {
//				if(isTouchedDown(location, (JLabel) tab.get(i))) {
//					if(!first) {
//						((Component) tab.get(i)).setLocation(200, 200);
//						first = true;
//					}
//					component.setLocation((int)((Component) tab.get(i)).getLocation().getX(), (int)((Component) tab.get(i)).getLocation().getY()+105);
//					if(i!=numPiece) {
//						if(ht.containsKey(numPiece))
//							if((int)ht.get(numPiece) == i) ht.remove(numPiece);
//						ht.put((i), (numPiece));
//					}
//
//				}
//				if(isTouchedUp(location, (JLabel) tab.get(i))) {
//					if(!first) {
//						((Component) tab.get(i)).setLocation(200, 200);
//						first = true;
//					}
//					component.setLocation((int)((Component) tab.get(i)).getLocation().getX(), (int)((Component) tab.get(i)).getLocation().getY()-105);
//					if(i!=numPiece) {
//						if(ht.containsKey(i)) 
//							if((int)ht.get(i) == numPiece) ht.remove(i);
//						ht.put((numPiece), (i));
//					}
//				}
//			}
//		}

//		Enumeration e = ht.elements();
//		Enumeration k = ht.keys();
//		while(k.hasMoreElements())
//			System.out.println(k.nextElement());
//		while(e.hasMoreElements())
//			System.out.println(e.nextElement());
//		System.out.println("----");

	}

	public void newGame() {
		this.first = false;
		this.ht.clear();
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
	
	public Hashtable getHt() {
		return ht;
	}

}
