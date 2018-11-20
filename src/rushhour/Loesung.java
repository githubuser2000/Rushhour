package rushhour;
import java.awt.*;
import java.awt.event.*;

public class Loesung  extends Frame implements MouseListener {

	/**
	 * @param args
	 */
	private Button ok = new Button("ok");
	public void mousePressed(MouseEvent e) {
		  
	  }
	public void mouseEntered(MouseEvent e) {
		  
	  }
	public void mouseClicked(MouseEvent e) {		
			  if (e.getSource() ==  ok) {
				this.dispose();  
			  }
	  }
	public void mouseExited(MouseEvent e) {
		  
	  }
	public void mouseReleased(MouseEvent e) {
		  
	  }
	public Loesung(Spielfeld sf) {
		super("Loesung");		
		addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent evt) {
		           System.exit(0);
		      }
		} );
		
		setLayout(new FlowLayout());/*
		sf.AutoFeld(sf.LAutos, (byte)0, (byte)2).setVor();
		sf.AutoFeld(sf.LAutos, (byte)1, (byte)2).setVor();/*
		sf.AutoFeld(sf.LAutos, (byte)2, (byte)2).setVor();
		sf.AutoFeld(sf.LAutos, (byte)3, (byte)2).setVor();*/
		//add(new BitmapComponent(sf.LAutos));
		add(ok);
		setSize(350,450);
		ok.addMouseListener(this);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Loesung Loesung= new Loesung();
		//Loesung.setVisible(true);
	}
	/*
	private Loesungsschritt__ _schritte;
	spiel.Rushhourspiel ;
	Spielfenster _tipp_geben;
	Loesungsfenster _unnamed_Loesungsfenster_;

	public spiel.Loesungsschritt__ getSchritte() {
		throw new UnsupportedOperationException();
	}
	*/

}
