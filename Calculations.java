/* Versio 0.9
 * Janne Vanhatapio
 * Lapin AMK 2019
 * 
 * Muodostaa matemaattisten toimintojen luokan. 
 */import java.util.Random;

public class Calculations {

		private int luku1;
		private int luku2;
		private int kertolaskufinal;
		private int vastaus;
		private int kierros;
		final int OIKEIN = 1;
		final int VAARIN = 0;
		
		//Rakentajametodi
		public Calculations() {
				luku1 = 0;
				luku2 = 0;
				vastaus = 0;
				kierros = 0;
				kertolaskufinal = 0;
		}
		
		public void SetRndNumbers() {
			Random rnd = new Random();
				luku1 = rnd.nextInt(10);
				luku2 = rnd.nextInt(10);
		}
		
		public void setAnswer(int text) {
			vastaus = text;
			
		}
		
		public int getanswer() {
			// TODO Auto-generated method stub
			return vastaus;
		}	
		public int getluku1() {
			return luku1;
			
		}
		public int getluku2() {
			return luku2;
			
		}

		public void addkierros() {
			kierros++;
			SetRndNumbers();
			setkertolaskufinal();
		}

		public int getkertolaskufinal() {
			return kertolaskufinal;
		}
		
		public void setkertolaskufinal() {
			int x = getluku1() * getluku2();
			kertolaskufinal = x;
			
		}
		
		public boolean AnswerEquals() {
			int x = getanswer();

			if (x == getkertolaskufinal()) {
				return true;
			}
			else 
					return false;
			}
		
		public void Alusta() {
			luku1 = 0;
			luku2 = 0;
			vastaus = 0;
			kierros = 0;
			kertolaskufinal = 0;
			SetRndNumbers();
			setkertolaskufinal();
		}

		

}

		
