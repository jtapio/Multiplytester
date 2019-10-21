
public class Controller {

	private int Kierros, luku, arvaus;
	private int OikeatVastaukset;

	
	final int OIKEIN = 1;
	final int VAARIN = 0;
	private int x = 0;
	

	public void Controller () {
		Kierros = 0;
		OikeatVastaukset = 0;
	}
	
	public void SetKierros(int arvo) {
		Kierros = arvo;
	}
	
	public int GetKierros() {
		return Kierros;
	}

	public boolean CheckAnswer(LeftPanel leftpanel, Calculations calculations ) {
		luku = calculations.getanswer();
		int arvaus = Integer.parseInt(leftpanel.getanswerField());
		if (luku == arvaus){
			return true;
		}
  	else {
  		return false;
  	}
	
}

}

	
