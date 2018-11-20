package rushhour;
import java.awt.*;
import java.awt.event.*;

public class beenden extends Frame implements MouseListener {
	
	public void mousePressed(MouseEvent e) {
		  
	  }
	public void mouseEntered(MouseEvent e) {
		  
	  }
	public void mouseClicked(MouseEvent e) {
		
		if (e.getSource() ==  b1) {
				System.exit(0);	
			
		} else if (e.getSource() ==  b2) {
			this.dispose();
		}
  
	  }
	public void mouseExited(MouseEvent e) {
		  
	  }
	public void mouseReleased(MouseEvent e) {
		  
	  }
	private Button b1=new Button("Ja");	
	private Button b2=new Button("Nein");
	
	public beenden() {
		
		super("Spiel beenden?");
		addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent evt) {
		           System.exit(0);
		      }
		} );		
		setLayout(new FlowLayout());
		add(new Label("Wollen Sie das Spiel wirklich beenden?"));
		add(b1);
		add(b2);
		b1.addMouseListener(this);
		b2.addMouseListener(this);
		
		setSize(250,100);
	}

	
	public static void main(String[] args){
		
		// TODO Auto-generated method stub
		beenden beenden= new beenden();
		beenden.setVisible(true);
	}

}
