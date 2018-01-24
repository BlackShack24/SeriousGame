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
	int niveau;

	public DragListener(ArrayList jl, int niveau) {
		this.niveau = niveau;
		for(int i=0 ; i<jl.size() ; i++) {
			if(niveau==1) tab.add(new Piece((JLabel) jl.get(i), 256, 133, 103, 11, 103, 114));
			else if (niveau == 2) {
				if(i != 1 && i != 4 && i != 8) tab.add(new Piece((JLabel) jl.get(i), 130, 51, 51, 5, 51, 58));
				else if(i == 8) tab.add(new Piece((JLabel) jl.get(i), 198, 124, 51, 5, 51, 115));
				else tab.add(new Piece((JLabel) jl.get(i), 322, 172, 51, 5, 51, 164));
			}
		}    	
	}

	public void mousePressed(MouseEvent me)
	{
		pressed = me;
	}

	public void mouseDragged(MouseEvent me) {
		Component component = me.getComponent();
		location = component.getLocation(location);
		int numPiece = findPiece(component);

		if(!ht.contains(numPiece) && !ht.containsKey(numPiece)) {
			int x = location.x - pressed.getX() + me.getX();
			int y = location.y - pressed.getY() + me.getY();
			component.setLocation(x, y);
		}

	}

	public void mouseReleased(MouseEvent me) {
		Component component = me.getComponent();
		location = component.getLocation(location);
		int numPiece = findPiece(component);
		int depX=0, depY=0;

		if(!ht.contains(numPiece) && !ht.containsKey(numPiece)) {
			if(niveau==1) {
				depX=200; depY=200;
			}
			else if(niveau==2) {
				depX=250; depY=30;
			}	

			for(int i=0 ; i<tab.size() ; i++) {	
				
				if(isTouched(numPiece, i)) {
					if(!first) {
						((Piece) tab.get(i)).getJl().setLocation(depX, depY);
						first = true;
					}	
					component.setLocation(
							(int)((Piece) tab.get(i)).getJl().getLocation().getX()+(((Piece) tab.get(i)).getCbX()-((Piece) tab.get(numPiece)).getChX()), 
							(int)((Piece) tab.get(i)).getJl().getLocation().getY()+(((Piece) tab.get(i)).getCbY()-((Piece) tab.get(numPiece)).getChY())
					);
					if(i!=numPiece) {
						if(ht.containsKey(numPiece))
							if((int)ht.get(numPiece) == i) ht.remove(numPiece);
						ht.put(i, numPiece);
					}
				}
				
				else if(isTouched(i, numPiece)) {
					if(!first) {
						((Piece) tab.get(i)).getJl().setLocation(depX, depY);
						first = true;
					}

					component.setLocation(
							(int)((Piece) tab.get(i)).getJl().getLocation().getX()+(((Piece) tab.get(i)).getChX()-((Piece) tab.get(numPiece)).getCbX()), 
							(int)((Piece) tab.get(i)).getJl().getLocation().getY()+(((Piece) tab.get(i)).getChY()-((Piece) tab.get(numPiece)).getCbY())
					);		
					if(i!=numPiece) {
						if(ht.containsKey(i))
							if((int)ht.get(i) == numPiece) ht.remove(i);
						ht.put(numPiece, i);
					}
				}
				
				else if(isTouched2(i, numPiece)) {
					if(!first) {
						((Piece) tab.get(i)).getJl().setLocation(depX, depY);
						first = true;
					}
					component.setLocation(
						(int)((Piece) tab.get(i)).getJl().getLocation().getX()+(149-((Piece) tab.get(numPiece)).getChX()), 
						(int)((Piece) tab.get(i)).getJl().getLocation().getY()+(39-((Piece) tab.get(numPiece)).getChY())
					);			
					if(i!=numPiece) {
						if(ht.containsKey(i))
							if((int)ht.get(i) == numPiece) ht.remove(i);
						ht.put(i,numPiece);
					}
				}
				
				else if(isTouched3(i, numPiece)) {
					if(!first) {
						((Piece) tab.get(i)).getJl().setLocation(depX, depY);
						first = true;
					}
					component.setLocation(
						(int)((Piece) tab.get(i)).getJl().getLocation().getX()+(246-((Piece) tab.get(numPiece)).getChX()), 
						(int)((Piece) tab.get(i)).getJl().getLocation().getY()+(93-((Piece) tab.get(numPiece)).getChY())
					);			
					if(i!=numPiece) {
						if(ht.containsKey(i))
							if((int)ht.get(i) == numPiece) ht.remove(i);
						ht.put(i,numPiece);
					}
				}
				
				else if(isTouched4(i, numPiece)) {
					if(!first) {
						((Piece) tab.get(i)).getJl().setLocation(depX, depY);
						first = true;
					}
					component.setLocation(
						(int)((Piece) tab.get(i)).getJl().getLocation().getX()+(147-((Piece) tab.get(numPiece)).getChX()), 
						(int)((Piece) tab.get(i)).getJl().getLocation().getY()+(40-((Piece) tab.get(numPiece)).getChY())
					);			
					if(i!=numPiece) {
						if(ht.containsKey(i))
							if((int)ht.get(i) == numPiece) ht.remove(i);
						ht.put(i,numPiece);
					}
				}
			}
		}

		Enumeration k = ht.keys();
		while(k.hasMoreElements()) {
			int var = (int) k.nextElement();
			System.out.println(var+" - "+ht.get(var));
		}
	}


	public void newGame() {
		this.first = false;
		this.ht.clear();
	}

	public boolean isTouched(int j1, int j2) {
		Piece p = ((Piece) tab.get(j1));
		Piece p2 = ((Piece) tab.get(j2));
		if(p.getJl().getX()+p.getChX() >= p2.getJl().getX()+p2.getCbX()-15
			&& p.getJl().getX()+p.getChX() <= p2.getJl().getX()+p2.getCbX()+15
			&& p.getJl().getY()+p.getChY() >= p2.getJl().getY()+p2.getCbY()-15
			&& p.getJl().getY()+p.getChY() <= p2.getJl().getY()+p2.getCbY()+15)
			return true;
		return false;
	}
	
	public boolean isTouched2(int j1, int j2) {
		Piece p = ((Piece) tab.get(j1));
		Piece p2 = ((Piece) tab.get(j2));
		if((j1 == 1 || j1 == 4) && (j2 == 2 || j2 == 5)) { // 149 39
			if(p.getJl().getX()+149 >= p2.getJl().getX()+p2.getChX()-15
				&& p.getJl().getX()+149 <= p2.getJl().getX()+p2.getChX()+15
				&& p.getJl().getY()+39 >= p2.getJl().getY()+p2.getChY()-15
				&& p.getJl().getY()+39 <= p2.getJl().getY()+p2.getChY()+15)
					return true;
		}
		return false;
	}
	
	public boolean isTouched3(int j1, int j2) {
		Piece p = ((Piece) tab.get(j1));
		Piece p2 = ((Piece) tab.get(j2));
		if((j1 == 1 || j1 == 4) && j2 != 1 && j2 != 4 && j2 != 8) { // 246 93
			if(p.getJl().getX()+246 >= p2.getJl().getX()+p2.getChX()-15
				&& p.getJl().getX()+246 <= p2.getJl().getX()+p2.getChX()+15
				&& p.getJl().getY()+93 >= p2.getJl().getY()+p2.getChY()-15
				&& p.getJl().getY()+93 <= p2.getJl().getY()+p2.getChY()+15)
					return true;
		}
		return false;
	}
	
	public boolean isTouched4(int j1, int j2) {
		Piece p = ((Piece) tab.get(j1));
		Piece p2 = ((Piece) tab.get(j2));
		if(j1 == 8 && j2 != 1 && j2 != 4 && j2 != 8) { // 147 40
			if(p.getJl().getX()+147 >= p2.getJl().getX()+p2.getChX()-15
				&& p.getJl().getX()+147 <= p2.getJl().getX()+p2.getChX()+15
				&& p.getJl().getY()+40 >= p2.getJl().getY()+p2.getChY()-15
				&& p.getJl().getY()+40 <= p2.getJl().getY()+p2.getChY()+15)
					return true;
		}
		return false;
	}
	
	

	public Hashtable getHt() {
		return ht;
	}

	public int findPiece(Component component) {
		for(int i=0 ; i<tab.size() ; i++) {
			if((component.getX() == (int) (((Piece) tab.get(i)).getJl().getX())) 
			&& (component.getY() == (int) (((Piece) tab.get(i)).getJl().getY()))) {
				return i;
			}
		}
		return 0;
	}

}
