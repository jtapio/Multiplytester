/* Versio 0.9
 * Janne Vanhatapio
 * Lapin AMK 2019
 * 
 * Muodostaa vasemman lohkon Swing Guista ja handlerit seuraavat nappien ja
 * teksikenttien toimintaa
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LeftPanel extends JPanel {
	

	
	private JTextField nameLabel;
	private JTextField answerField;
	private JTextField questionField;

	private JButton TarkistaBtn;
	private JButton AlustaBtn;
	
	private String apu;
	
	private StringListener textListener;
	private PanelListener eventListener;

	boolean RaiseFlag;
	
	public LeftPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 150;
		setPreferredSize(dim);
		
		nameLabel = new JTextField(10);
		answerField = new JTextField(10);

		questionField = new JTextField(10);
		TarkistaBtn = new JButton("Tarkista");
		AlustaBtn = new JButton("Reset");
		
				
		add(nameLabel, BorderLayout.NORTH);
		add(questionField, BorderLayout.NORTH);
		add(answerField, BorderLayout.NORTH);
		add(TarkistaBtn, BorderLayout.NORTH);
		add(AlustaBtn, BorderLayout.NORTH);

		
		NappiHandler nappihandler = new NappiHandler();
		TarkistaBtn.addActionListener(nappihandler);
		AlustaBtn.addActionListener(nappihandler);
		
		TekstiHandler tekstihandler = new TekstiHandler();
		answerField.addActionListener(tekstihandler);

	}

	public void setnameLabel(String kentta)  {
		nameLabel.setText(String.valueOf(kentta));		
		
	}
	
	public JTextField getnameLabel()  {
		return nameLabel;		
		
	}
	public void setquestionField(String kentta)  {
		questionField.setText(String.valueOf(kentta));		
		
	}
	
	public JTextField getquestionField()  {
		return questionField;		
		
	}
	public void setanswerField(String kentta)  {
		answerField.setText(String.valueOf(kentta));		
		
	}
	
	public String getanswerField()  {
		return String.valueOf(answerField.getText());		
		
	}

//Seuraa tekstikentän ruutua ja kun sinne syötetään PanelEvent vie tiedon PanelListenerin kautta MainFrameen
	private class TekstiHandler implements ActionListener
	{
			public void actionPerformed(ActionEvent tapahtuma) {
			    Object aiheuttaja = tapahtuma.getSource();
			    if (aiheuttaja == answerField) {
			    	PanelEvent PE = new PanelEvent(this,getanswerField());
			    	eventListener.PanelEventOccured(PE);
		}
		
	} 
	}
	private class NappiHandler implements ActionListener
	{
		  public void actionPerformed(ActionEvent tapahtuma) {
			    Object aiheuttaja = tapahtuma.getSource();
			    if (aiheuttaja == TarkistaBtn) {
			    	
			    	//Tämä tekee eventin joka siirtää tietoa interfacen kautta MainFrameen "Vastaustieto"
			    	PanelEvent PE = new PanelEvent(this,getanswerField());
			    	
			    		if (eventListener != null) {
			       			eventListener.PanelEventOccured(PE);
			       		}

			    	}
			  
			    //Tämä tekee eventin joka siirtää tietoa interfacen kautta MainFrameen "RestartButton"
			    if (aiheuttaja == AlustaBtn) {
			    	PanelEvent PE = new PanelEvent(this,getanswerField());
			    	
			       	if (eventListener != null) {
			       		eventListener.RestartEventOccured(PE);
			       		
			       	}
			       	
			    }
			  			  
		  }
	}
	
	// Käytetään tekstin Välittämiseen RightPanelin Textfieldiin Interface > MainFramen kautta
	public void setStringListener(StringListener listener) {
		this.textListener = listener;
	}
	//Eventhandlerin osa
	public void setPanelListener(PanelListener listener) {
		this.eventListener = listener;
		
	}
	}
