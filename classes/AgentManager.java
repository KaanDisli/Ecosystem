public class AgentManager{
	public static boolean tab[][] =  new boolean[30][30];
	

	public boolean checkAgent(int i,int k){


		 if (tab[i][k] != true){
				tab[i][k] = true;
				return true;
			}
		 else{

				return false;
			}
			
		}
	public void removeAgent(int i,int k){
		if (tab[i][k] == true){
			tab[i][k] = false;
		}	
	}
}

	

















