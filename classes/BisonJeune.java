public class BisonJeune implements BisonTypes{

	private int JoursABison;
	private int py;
	private int px;
	private static int Ajoute = 3;
	public BisonJeune(int JoursABison, int py, int px){
		this.JoursABison = JoursABison;
		this.py = py;
		this.px = px;
	}
	public int getJoursABison(){
		return JoursABison;
			
	}
	
	public void reduireJoursABison(){
		JoursABison-=1;	
	}
	public int getX(){

		return px;

	}

	public int getY(){
		return py;
	}
	public static int getAjoute(){
		return Ajoute;
	}

}
