import java.util.ArrayList;
//KAAN DISLI 2113004
public class Simulation{
	private Terrain t;
	private Human tabHuman[];

	private Legumes tabLegumes[];
	private int tabHumanResource[][];
	private BisonJeune tabBisonJeune[];
	private Bison tabBison[];
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_GREEN =  "\033[0;32m";
	public static final String ANSI_RED = "\033[0;31m";
	public static final String ANSI_PURPLE = "\033[0;35m";
	public static final String ANSI_CYAN = "\033[0;36m";




	public Simulation(int n, int m, int ligne, int colonne){
		int s=0;
		int s2=0;
		tabHumanResource = new int[ligne][colonne];
	
		for(s=0;s<ligne;s++){
			for(s=0;s<colonne;s++){
			tabHumanResource[s][s2]=0;
			}
		}
		Terrain t = new Terrain(ligne,colonne);
		
		int QUANTITE = 1;
		int i = 0;
		int i2 = 0;
		int i3 = 0;
		int i4 = 0;
		int x= 0;
		int x2= 0;
		int x3 = 0;
		int x4 = 0;
		int h;
		int f;
		int ay;
		int ax;
		int by;
		int bx;
		
		tabHuman = new Human[n];
		tabLegumes = new Legumes[m];
		tabBisonJeune = new BisonJeune[m];
		tabBison = new Bison[m];
		Human human_original = new Human(7,"Human",0,0);
		
		//CREATION DE TERRAIN
		// Terrain initial : il est vide
		System.out.println("Informations sur le terrain:\n"+t);	
		t.affiche(13);
		while (i<m){
		
	
			 h = (int)(Math.random() *ligne);
			 f = (int)(Math.random() *colonne);
		// On créé des ressources
		
			if (tabHumanResource[h][f] ==1 || tabHumanResource[h][f] ==2 || tabHumanResource[h][f] ==3){
				continue;
			}else{
				tabHumanResource[h][f] = 2;
				t.setCase(h,f,new Ressource("Legumes",QUANTITE));
				tabLegumes[i] = new Legumes();
				System.out.println(ANSI_GREEN + "Ajout de " +"LEGUME"+" valide !\n" + ANSI_RESET);
				System.out.println(t.getCase(h,f));
			}
			
		
			i++;
		}
		while (i2<n){
		
			h = (int)(Math.random() *ligne);
			f = (int)(Math.random() *colonne);

			if (tabHumanResource[h][f] ==1 || tabHumanResource[h][f] ==2 || tabHumanResource[h][f] ==3){
				continue;
		
			
			}else{ 
	
				tabHuman[i2]  = human_original.clone(h,f);
				tabHumanResource[h][f] = 1;
				t.setCase(h,f,new Ressource("( ͡° ͜ʖ ͡°)",QUANTITE));
				
				System.out.println(ANSI_GREEN + "Ajout de " +"HUMAN"+" valide !\n" + ANSI_RESET);
				System.out.println(t.getCase(h,f));
			}
			i2++;
		}
		while (i3<n){
	
			h = (int)(Math.random() *ligne);
			f = (int)(Math.random() *colonne);

			if (tabHumanResource[h][f] ==1 || tabHumanResource[h][f] ==2 || tabHumanResource[h][f] ==3){
				continue;
		
			
			}else{ 
				tabHumanResource[h][f] = 3;
				t.setCase(h,f,new Ressource("BisonJeune",QUANTITE));
				tabBisonJeune[i3]  = new BisonJeune(7,h,f);
				System.out.println( ANSI_GREEN + "Ajout de " +"BisonJeune"+" valide !\n" +ANSI_RESET);
				System.out.println(t.getCase(h,f));
			}
			i3++;
		}
		System.out.println("Liste de toutes les ressources présentes actuellement:\n");
		ArrayList<Ressource> liste = t.lesRessources();
		for (Ressource r : liste) {
			System.out.println(r);
		}
		System.out.println(ANSI_YELLOW + "-------------------------LE TERRAIN-------------------------"+ ANSI_RESET);
		t.affiche(11);

		for (x=0;x<16;x++){
		System.out.println(ANSI_YELLOW + "-------------------------ETAPE: " + x+ "-------------------------\n"+ ANSI_RESET); 
		   for(x2 = 0;x2<n;x2++){
			
		  	
		   if (tabHuman[x2] != null){	
			   ay = tabHuman[x2].getY();
			   ax = tabHuman[x2].getX();
		   }
		   else{continue;}
		
		   if (tabHuman[x2].getjoursRestants() > 0){
				tabHuman[x2].reduirejoursRestants();
			}
		   if (tabHuman[x2].getjoursRestants() == 0){
			
				t.videCase(ay,ax);
				tabHumanResource[ay][ax] = 0;
				tabHuman[x2] = null;
				System.out.println(ANSI_RED + "Human meurs\n" +ANSI_RESET);	
			}
		
		
	
			if (tabHuman[x2] != null){
				int num = (int)(Math.random()*2);
				int num2;
				if (num == 1){
					num2=0;
				}else{
					num2=1;
					}
			
				if (tabHuman[x2].seDeplacer((ay+num) %ligne, (ax +num2) % colonne) == true){
					tabHumanResource[ay][ax] =0;
					t.videCase(ay,ax); 
					if (tabHumanResource[(ay+num)%ligne][(ax +num2)%colonne] ==2 ){
						tabHuman[x2].ajoutejoursRestants(5);
						tabHumanResource[(ay+num)%ligne][(ax +num2)%colonne] =1;
						
						t.setCase((ay+num)%ligne,(ax+num2)%colonne,new Ressource("( ͡° ͜ʖ ͡°)",QUANTITE));
						System.out.println(ANSI_GREEN + "Human a mange le Legume +5\n" + ANSI_RESET);
				}
					if (tabHumanResource[(ay+num)%ligne][(ax +num2)%colonne] == 3){
						tabHuman[x2].ajoutejoursRestants(BisonJeune.getAjoute());
						tabHumanResource[(ay+num)%ligne][(ax +num2)%colonne] =1;
						//t.videCase(ay,ax);
						t.setCase((ay+num)%ligne,(ax+num2)%colonne,new Ressource("( ͡° ͜ʖ ͡°)",QUANTITE));
						System.out.println(ANSI_GREEN + "Human a mange le BisonJeune +3\n"+ ANSI_RESET);
						
						int cc = 0;
						for(cc=0;cc<m;cc++){	
							if (tabBisonJeune[cc] != null){
							
								if(tabBisonJeune[cc].getY()==(ay+num)%ligne && tabBisonJeune[cc].getX()==(ax+num2)%colonne){
								
								
								tabBisonJeune[cc] = null;
								
							
							  }
							}
						}
				}

					if (tabHumanResource[(ay+num)%ligne][(ax +num2)%colonne] ==4){
						tabHuman[x2].ajoutejoursRestants(Bison.getAjoute());
						tabHumanResource[(ay+num)%ligne][(ax +num2)%colonne] =1;
						
						t.setCase((ay+num)%ligne,(ax+num2)%colonne,new Ressource("( ͡° ͜ʖ ͡°)",QUANTITE));
						System.out.println(ANSI_GREEN + "Human a mange le Bison +7\n" + ANSI_RESET);
						
				}



					if (tabHumanResource[(ay+num)%ligne][(ax +num2)%colonne] ==0){
						tabHumanResource[(ay+num)%ligne][(ax +num2)%colonne] =1;
					
						t.setCase((ay+num)%ligne,(ax+num2)%colonne,new Ressource("( ͡° ͜ʖ ͡°)",QUANTITE));
					
					}
				
				}
			}
			  
		   
		}
		for(x3 = 0;x3<m;x3++){
				
				 if (tabBisonJeune[x3] != null){
					
			   		by = tabBisonJeune[x3].getY();
			   		bx = tabBisonJeune[x3].getX();
				
		   		  }
			
				  else{ continue;}
				if (tabBisonJeune[x3].getJoursABison() > 0) {
					tabBisonJeune[x3].reduireJoursABison();
				
				} 
				if (tabBisonJeune[x3].getJoursABison() == 0) {
				
					tabBisonJeune[x3].reduireJoursABison();
					tabHumanResource[by][bx] = 4;
					tabBison[x3] = new Bison(6,by,bx);	
					t.setCase(by,bx,new Ressource("Bison",QUANTITE));
					System.out.println(ANSI_PURPLE +"Le Bison a grandi\n" + ANSI_RESET );
								
				}	

			}
			for(x4 = 0;x4<m;x4++){
	
				 if (tabBison[x4] != null){
				
			   		by = tabBison[x4].getY();
			   		bx = tabBison[x4].getX();
				
		   		  }
			
				  else{ continue;}
				if (tabBison[x4].getjoursRestants() > 0) {
					tabBison[x4].reduirejoursRestants();
				
				} 
				if (tabBison[x4].getjoursRestants() == 0) {
				
					tabBison[x4].reduirejoursRestants();
					tabHumanResource[by][bx] = 0;
					t.videCase(by,bx);	
				
					System.out.println(ANSI_RED + "Le Bison meurt\n"+ ANSI_RESET);
								
				}	

			}
	
		t.affiche(11);
		  }

	}

}

