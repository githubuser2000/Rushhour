package rushhour;
import java.awt.*;
import java.util.LinkedList;
import java.awt.image.ImageObserver;
import java.awt.event.*;

class BitmapComponent
extends Canvas
implements MouseListener
{
	private Image img;
	private Image[] iautos;	
	private Integer autox=1;	
	private Integer autoy=1;
	public void mousePressed(MouseEvent e) {
		  
	  }
	public void mouseEntered(MouseEvent e) {
		  
	  }
	public void mouseClicked(MouseEvent e) {
		  autox=e.getX()/50;
		  autoy=e.getY()/50;
		  for (Auto auto : Spielfeld.getAutos()) {
			 auto.clicked(autox.byteValue(), autoy.byteValue());
		  }
		  Spielfeld.AutoFeld(Spielfeld.getAutos(), autox.byteValue(), autoy.byteValue());
		  System.out.println(Spielfeld.AutoFeld(Spielfeld.getAutos(), autox.byteValue(), autoy.byteValue()));
		  System.out.println("Autos2: "+Spielfeld.getAutos().getCompareNumber());
		  
		  
		  this.repaint();
	  }
	public void mouseExited(MouseEvent e) {
		  
	  }
	public void mouseReleased(MouseEvent e) {
		  
	  }
  //public AutoList Autos;	

  public BitmapComponent(byte spielfeldgroesse)
  {
	switch(spielfeldgroesse) {
	    case 3:
	        img = getToolkit().getImage("spielfeld3.gif");
	        break;
        case 4:
            img = getToolkit().getImage("spielfeld4.gif");
            break;
        case 5:
            img = getToolkit().getImage("spielfeld5.gif");
            break;
        default:
            img = getToolkit().getImage("spielfeld.gif");
            break;
	}
		
	byte i=0;
	iautos = new Image[Spielfeld.getAutos().size()];
	for (Auto auto : Spielfeld.getAutos()) {
	    if (auto!=null)
	        if (auto.laenge()==2&&auto.ausrichtung()==hochkantORLaengs.laengs) {
	            iautos[i]=getToolkit().getImage("car22.gif");
	        }else if (auto.laenge()==2&&auto.ausrichtung()==hochkantORLaengs.hochkant) {
	            iautos[i]=getToolkit().getImage("car2.gif");
	        }else if (auto.laenge()==3&&auto.ausrichtung()==hochkantORLaengs.laengs) {
	            iautos[i]=getToolkit().getImage("car12.gif");
	        }else if (auto.laenge()==3&&auto.ausrichtung()==hochkantORLaengs.hochkant) {
	            iautos[i]=getToolkit().getImage("car1.gif");
	        }
	        if (auto.istEiswagen()) {
	            iautos[i]=getToolkit().getImage("car32.gif");
	        }
	        i++;
	}
	//this.Autos=Autos;
	
	//auto1 = getToolkit().getImage("auto3w.gif");
	//auto2 = getToolkit().getImage("auto3w.gif");
	/*
	MediaTracker mt = new MediaTracker(this);
	MediaTracker mt2 = new MediaTracker(this);
	mt.addImage(img, 0);
	mt2.addImage(auto1, 0);
    try {
        //Warten, bis das Image vollst�ndig geladen ist,
        //damit getWidth() und getHeight() funktionieren
        mt.waitForAll();
      } catch (InterruptedException e) {
        //nothing
      }
    try {
        //Warten, bis das Image vollst�ndig geladen ist,
        //damit getWidth() und getHeight() funktionieren
        mt2.waitForAll();
     } catch (InterruptedException e) {
       //nothing
     }*/
     addMouseListener(this);
  }

  public void paint(Graphics g)
  {
	
	byte k=0;
    g.drawImage(img,1,1,this);
    
    for (Auto auto : Spielfeld.getAutos()) {
        	if (iautos[k]!=null&&auto!=null)
    		g.drawImage(iautos[k], auto.getX()*50+1, auto.getY()*50+1, Color.black, this);
        	k++;
    }   
    
  }

  public Dimension getPreferredSize()
  {
    return new Dimension(
      img.getWidth(this),
      img.getHeight(this)
    );
  }

  public Dimension getMinimumSize()
  {
    return new Dimension(
      img.getWidth(this),
      img.getHeight(this)
    );
  }
}