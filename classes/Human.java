public class Human extends Agents{

	private int joursRestants;
	public Human(int joursRestants, String name, int y, int x){
		super(name, y, x);
		this.joursRestants = joursRestants;
	}
	public int getjoursRestants(){
		return joursRestants;
			
	}
	public void reduirejoursRestants(){
		joursRestants-=1;
			
	}
	public void ajoutejoursRestants(int n){
		joursRestants+=n;
			
	}
	public Human clone(int h, int f){

		return new Human(7,"Human",h,f);
	}

}
