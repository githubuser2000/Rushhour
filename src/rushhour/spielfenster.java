package rushhour;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

import rushhour.backtracker.*;

public class spielfenster extends Frame implements MouseListener {

	private boolean spielfeldAendern=false;
	public static byte spielfeldgroesse;
	private byte a2,a3,z;
	private AutoList merkeAutos=null;
	Backtrack bt=null;
	Panel a = new Panel();
	/**
	 * @param args	
	 */
	Button b1=new Button("Anzahl NonCar Felder");
	Button b2=new Button("Zufall");
	Button b3=new Button("Loesung anezeigen");
	Button b4=new Button("Spiel beenden");
	Button b5=new Button("Backtrack");
	Button button_max=new Button("max");
	Button button_min=new Button("min");
	Button button_ziel=new Button("im Ziel");
	private BitmapComponent bitmap;
	//public Auto [] Autos;
	private Spielfeld spielfeld;
	
	private Image img;
	public void mousePressed(MouseEvent e) {
		  
	  }
	public void mouseEntered(MouseEvent e) {
		  
	  }
	public void mouseClicked(MouseEvent e) {		
		if (e.getSource() ==  b4) {
			  beenden beenden= new beenden();
			  beenden.setVisible(true);			 
		} else if (e.getSource() ==  b3) {
			Loesung Loesung= new Loesung(spielfeld);
			Loesung.setVisible(true);
		} else if (e.getSource() ==  b2) {
			//Spielfeld.zufall((byte)3,(byte)3,(byte)1);
			spielfeld=new Spielfeld(a2,a3,z,spielfeld.spielfeldgroesse);
			a.remove(bitmap);
			bitmap=new BitmapComponent(spielfeldgroesse);
			a.add(bitmap);
			this.pack();
		} else if (e.getSource() ==  b5) {
			 bt=new rushhour.backtracker.Backtrack(spielfeld);
			 merkeAutos=spielfeld.getAutos().clone();
			 if (bt.getMinMaxWays()!=null)
			     spielfeld.setAutos(bt.getMinMaxWays()[0].situationAutoList);
			 else
			     JOptionPane.showMessageDialog(null, "Ursprung nicht erreichbar!");
			 /*
             int anz=rushhour.backtracker.Backtrack.countNonCars(Spielfeld);
             JOptionPane.showMessageDialog(null, "Anzahl: "+anz);
             Spielfeld.getAutos().getAutoPos();
             anz=rushhour.backtracker.Backtrack.countNonCars(bt.getMinMaxWays()[1].situation.get(0).getSpielfeld());
             JOptionPane.showMessageDialog(null, "Anzahl: "+anz);
             */
			  //a.remove(bitmap);
			 a.remove(bitmap);
			 bitmap=new BitmapComponent(spielfeldgroesse);
			  //bitmap.Autos = Spielfeld.getAutos.clone();
			  //Spielfeld.setAutos(bitmap.Autos);
			  
			  //bitmap=new BitmapComponent(Spielfeld.Autos_Sicherung);
			  //a.add(bitmap);
			  a.add(bitmap);
			  this.pack();
		  } else if (e.getSource() ==  button_max) {
		      //System.out.println("set");
              if (bt!=null) {
                  if (bt.getMinMaxWays()!=null) {
                      spielfeld.setAutos(bt.getMinMaxWays()[1].situationAutoList);
                      
                  } else
                      JOptionPane.showMessageDialog(null, "Ursprung nicht erreichbar!");
                  a.remove(bitmap);
                  bitmap=new BitmapComponent(spielfeldgroesse);
                  a.add(bitmap);
                  this.pack();
                }
         } else if (e.getSource() ==  button_min) {
             if (bt!=null) {
                 if (bt.getMinMaxWays()!=null)
                     spielfeld.setAutos(bt.getMinMaxWays()[0].situationAutoList);
                 else
                     JOptionPane.showMessageDialog(null, "Ursprung nicht erreichbar!");
                 a.remove(bitmap);
                 bitmap=new BitmapComponent(spielfeldgroesse);
                 a.add(bitmap);
                 this.pack();
               }
        }else if (e.getSource() ==  button_ziel) {
            if (bt!=null) {
                spielfeld.setAutos(merkeAutos);
                a.remove(bitmap);
                bitmap=new BitmapComponent(spielfeldgroesse);
                a.add(bitmap);
                this.pack();
              }
       } else {
			  if (e.getSource() == b1) {
			      //int anz=rushhour.backtracker.Backtrack.countNonCars(Spielfeld.getAutos());
			      //JOptionPane.showMessageDialog(null, "Anzahl: "+anz);
			      //Spielfeld.getAutos().getAutoPos();
				  //Spielfeld.setAutos(bt.getMinMaxWays()[1].situation);
				  //bitmap=new BitmapComponent();
				  //bitmap.Autos = Spielfeld.getAutos.clone();
				  //Spielfeld.setAutos(bitmap.Autos);
				  
				  //bitmap=new BitmapComponent(Spielfeld.Autos_Sicherung);
				  //bitmap.repaint();
			  }
		  }
			  
	  }
	
	public void mouseExited(MouseEvent e) {
		  
	  }
	public void mouseReleased(MouseEvent e) {
		  
	  }
	
	@SuppressWarnings("static-access")
	public spielfenster(byte a2,byte a3,byte z,byte spielfeldgroesse) {		
		
		super("Rushhour");
		this.a2=a2;
		this.a3=a3;
		this.z=z;
		this.spielfeldgroesse=spielfeldgroesse;
		/*
		Canvas Canvas1 = new Canvas();		
		Image Image1;
		add(Canvas1);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image1 = toolkit.getImage("C:\\Users\\Admin\\Documents\\workspace\\img.gif");
		setSize(300,300);
		*/
		addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent evt) {
		           System.exit(0);
		      }
		} );
		
		setLayout(new FlowLayout());
		
		Panel b = new Panel();
		b.setLayout(new FlowLayout());
		b.setLayout(new GridLayout(6,3));
		
		/*
		img = getToolkit().getImage("C:\\Users\\Admin\\Documents\\workspace\\img.gif");
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(img, 0);
		try {
			mt.waitForAll();			
		} catch (InterruptedException e) {
			
		}
		repaint();
		*/
		

		spielfeld=new Spielfeld(a2,a3,z,spielfeldgroesse);
		
		if (spielfeldAendern) {
			//for (Auto auto : Spielfeld.getAutos()) {
				//System.out.println(auto.Eigenschaften());
			//}
			Backtrack bt=new Backtrack(spielfeld);
			//Spielfeld.setAutos(bt.getMinMaxWays()[1].situation);
			/*
			for (Auto auto : Spielfeld.getAutos()) {
				System.out.println(auto.Eigenschaften());
			}
			*/
			//Spielfeld.verschiebeautos((byte)1);			
		}
		bitmap=new BitmapComponent(spielfeldgroesse);
		
		a.add(bitmap);
		//Spielfeld.Loesungsweg();
		pack();		
		b.add(b1);		
		b.add(b2);
		b.add(b3);
		b.add(b4);
		b.add(b5);
		b.add(button_max);
		b.add(button_min);
		b.add(button_ziel);
		add(a);
		add(b);
		setSize(600,600);
		b1.addMouseListener(this);
		b2.addMouseListener(this);
		b3.addMouseListener(this);
		b4.addMouseListener(this);
		b5.addMouseListener(this);
		button_max.addMouseListener(this);
		button_min.addMouseListener(this);
		button_ziel.addMouseListener(this);
	}
	

	public void paint(Graphics g) {
		//if (img!=null) {
	
			g.drawImage(img, 40, 40, this);
		//}
	}
	
	public static void main(String[] args) {
		
		spielfenster spiel= new spielfenster((byte)3,(byte)3,(byte)1,(byte) 6);
		spiel.setVisible(true);
	}

}
