/* Versio 0.9
 * Janne Vanhatapio
 * Lapin AMK 2019
 * 
 * Muodostaa vasemman lohkon Swing Guista ja handlerit seuraavat nappien ja
 * teksikenttien toimintaa
 * 
 * Lisänä käytetään calculations.class luokkaa matemaattisiin toimintoihin
 * 
 * Ei ehkä kaunein, mutta toimii ja paljon on opittavaa vielä
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


	private class TekstiHandler implements ActionListener
	{
			public void actionPerformed(ActionEvent tapahtuma) {
			    Object aiheuttaja = tapahtuma.getSource();
			    if (aiheuttaja == answerField) {
			calculations.setAnswer(Integer.parseInt(answerField.getText()));
	//		nameLabel.setText(String.valueOf(controller.CheckAnswer()));
		//	nameLabel.setText(String.valueOf(calculations.getanswer()));
		//	System.out.println(calculations.getanswer());
			calculations.setkertolaskufinal();
			controller.CheckAnswer(calculations.getanswer(),calculations.getkertolaskufinal());
		}
		
	} 
	}
	private class NappiHandler implements ActionListener
	{
		  public void actionPerformed(ActionEvent tapahtuma) {
			    Object aiheuttaja = tapahtuma.getSource();
			    if (aiheuttaja == TarkistaBtn) {
		    	if (RaiseFlag) {
			    		calculations.addkierros();
			    		calculations.SetRndNumbers();
			    		nameLabel.setText("Paljonko on " + calculations.getluku1() + " * "+ calculations.getluku2());
			    	}
			    	else {
			    		nameLabel.setText("Paljonko on " + calculations.getluku1() + " * "+ calculations.getluku2());
			    	}
			    }
			    if (aiheuttaja == AlustaBtn) {
				    calculations.Reset();
			    	calculations.SetRndNumbers();
			    	nameLabel.setText("Paljonko on " + calculations.getluku1() + " * "+ calculations.getluku2());
			    }
			  			  
		  }
	}
	// Käytetään tekstin "lähettämiseen" RightPaneliin Textfieldiin
	public void setStringListener(StringListener listener) {
		this.textListener = listener;
	}
}
