package rushhour;
import java.awt.*;
import java.awt.event.*;
// veraltete Klasse
public class zuruecksetzen extends Frame {
	 // veraltete Klasse
		public zuruecksetzen() {
			
			super("Spiel zuruecksetzen?");		
			addWindowListener(new WindowAdapter() {
			      public void windowClosing(WindowEvent evt) {
			           System.exit(0);
			      }
			} );		
			setLayout(new FlowLayout());
			add(new Label("Wollen Sie das Spiel wirklich zuruecksetzen?"));
			add(new Button("Ja"));
			add(new Button("Nein"));
			setSize(250,100);
		}

		
		public static void main(String[] args){
			
			// TODO Auto-generated method stub
			zuruecksetzen zuruecksetzen= new zuruecksetzen();
			zuruecksetzen.setVisible(true);
		}

}
