public class Bison implements BisonTypes{

	private int joursRestants;
	private int py;
	private int px;
	private static int Ajoute = 5;
	public Bison(int joursRestants,int py,int px){
		this.joursRestants = joursRestants;
		this.py =py;
		this.px=px;
	}
	public int getjoursRestants(){
		return joursRestants;
			
	}
	public void reduirejoursRestants(){
		joursRestants -= 1;
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
