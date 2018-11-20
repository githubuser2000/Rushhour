package rushhour;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;

import javax.swing.JOptionPane;

public class startfenster extends Frame implements MouseListener  {

	/**
	 * @param args
	 */
	private Button b1=new Button("Beenden");
	private Button b2=new Button("Spiel starten");
	private TextField t1=new TextField("3");
	private TextField t2=new TextField("3");
	private TextField t3=new TextField("1");
	private TextField t4=new TextField("6");
	
	public void mousePressed(MouseEvent e) {	  
	  }
	public void mouseEntered(MouseEvent e) {
		  
	  }
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() ==  b1) {
			beenden beenden= new beenden();
			beenden.setVisible(true);
		}else  if (e.getSource() ==  b2) {	
		    if ((new Byte(t4.getText()))>6)
		        t4.setText("6");
		    if ((new Byte(t4.getText()))<3)
                t4.setText("3");
			spielfenster spiel= new spielfenster(new Byte(t1.getText()),new Byte(t2.getText()),new Byte(t3.getText()),new Byte(t4.getText()));
			//spiel.Autos=new Auto[new Integer(t1.getText())+new Integer(t2.getText())];
			/*
			for (int i=0;i<new Integer(t1.getText());i++) {
				spiel.Autos[i]=new Auto(true,2,1,1);
			}
			for (int i=new Integer(t1.getText());i<new Integer(t1.getText())+new Integer(t2.getText());i++) {
				spiel.Autos[i]=new Auto(true,3,1,1);
			}*/
			spiel.setVisible(true);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			  
			
	  }
	public void mouseExited(MouseEvent e) {
		  
	  }
	public void mouseReleased(MouseEvent e) {
		  
	  }
	 
	public startfenster() {
		super("Rushhour");
		addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent evt) {
		           System.exit(0);
		      }
		} );
		setLayout(new FlowLayout(FlowLayout.LEFT));
		Panel labelPanel = new Panel();
		labelPanel.setLayout(new GridLayout(5,1));
		labelPanel.add(new Label("Anzahl der 2er-Fahrzeuge",Label.LEFT));
		labelPanel.add(t1);
		labelPanel.add(new Label("Anzahl der 3er-Fahrzeuge",Label.LEFT));
		labelPanel.add(t2);
		labelPanel.add(new Label("Anzahl der Spielzuege",Label.LEFT));
		labelPanel.add(t3);
        labelPanel.add(new Label("Groesse des Feldes",Label.LEFT));
        labelPanel.add(t4);
		labelPanel.add(b1);
		labelPanel.add(b2);
		b1.addMouseListener(this);
		b2.addMouseListener(this);
		
		/*
		Panel editPanel = new Panel();
		editPanel.setLayout(new GridLayout(3,1));
		TextField tf=new TextField("Zahl eingeben",20);		
		editPanel.add(tf);
		TextField tf2=new TextField("Zahl eingeben",20);
		TextField tf3=new TextField("Zahl eingeben",20);
		editPanel.add(tf2);
		editPanel.add(tf3);*/
		add(labelPanel);
		//add(editPanel);
		setSize(350,170);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			startfenster start=new startfenster();
			
			start.setVisible(true);
			
	}

}
