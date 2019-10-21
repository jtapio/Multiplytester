/* Versio 0.9
 * Janne Vanhatapio
 * Lapin AMK 2019
 * 
 * Muodostaa Swing Guin rungon luomalla oliot ja kontrolloi päänäkymää
 * 
 * Ei ehkä kaunein, mutta toimii ja paljon on opittavaa vielä
 */

import java.awt.BorderLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame  extends JFrame{
	
	private RightPanel rightpanel;
	private JButton btn;
	private LeftPanel leftpanel;
	private Calculations calculations;
	
	boolean RaiseFlag = false;
	
	public MainFrame() {
		super("Kertolaskutesteri v0.1");
		
		setLayout(new BorderLayout());
		
		rightpanel = new RightPanel();
		leftpanel = new LeftPanel();
		calculations = new Calculations();
		
		leftpanel.setStringListener(new StringListener() {
			public void textEmitted(String text) {
			//	rightpanel.appendText(text);
				}
			});
		
		//PanelEvent
		leftpanel.setPanelListener(new PanelListener() {
			public void PanelEventOccured(PanelEvent e) {
				String apu = e.getVastaus();
				calculations.setAnswer(Integer.parseInt(apu));			//Viedään calculations oliolle vastattu luku
				rightpanel.appendText(apu);
				rightpanel.appendText(String.valueOf(calculations.getkertolaskufinal()));

				TeeKierros();
			}
			public void RestartEventOccured(PanelEvent Pe) {
				Alusta();
			}
		});
		

		add(leftpanel, BorderLayout.WEST);
		add(rightpanel, BorderLayout.CENTER);
			
		
	setSize(600, 500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);	
	}
	
	public void Alusta() {
		calculations.Alusta();
		leftpanel.setnameLabel("");
		leftpanel.setquestionField("Paljonko on "+ calculations.getluku1() + " * " + calculations.getluku2() + "\n");
	}
	
	public void TeeKierros () {

		if (calculations.AnswerEquals()) {
			leftpanel.setnameLabel("Vastasit oikein!");
//			Lippua käytetään tarkastukseen oliko oikein, muuten kysytään samaa edelleen
			RaiseFlag = true;
			}
	  	else {
	  		leftpanel.setnameLabel("Kokeileppa uudelleen");
	  		}
		if (RaiseFlag) {
			calculations.addkierros();
			RaiseFlag=false;
			leftpanel.setquestionField("Paljonkohan on "+ calculations.getluku1() + " * " + calculations.getluku2() + "\n");
		}
		
	}
	


}		
		
	

