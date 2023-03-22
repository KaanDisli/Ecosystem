public class Agents extends AgentManager{
	private int py;
	private int px;
	private String name;
	
	
	public Agents(String name, int y, int x){
		py = y;
		px = x;
		this.name = name;
		
	}

	public double distance(int y, int x){
		return (double)Math.sqrt(Math.pow((px - x),2) + Math.pow((py-y),2));
		
	
	}

	public boolean seDeplacer(int ynew, int xnew){
		
		if (checkAgent(ynew,xnew)== true) {
			removeAgent(py,px);
			py = ynew;
			px = xnew;
			
			return true;
		}
		else{return false;}

	}
	public int getX(){

		return px;

	}

	public int getY(){
		return py;
	}
	

}
