package model;

public class CalendrierAnnuel {
	private Mois[] tabMois;

	
	public CalendrierAnnuel() {
		
		this.tabMois = new Mois[12];
		
		
		tabMois[0] = new Mois("Janvier",31);
		tabMois[1] = new Mois("Février",28);
		tabMois[2] = new Mois("Mars",31);
		tabMois[3] = new Mois("Avril",30);
		tabMois[4] = new Mois("Mai",31);
		tabMois[5] = new Mois("Juin",30);
		tabMois[6] = new Mois("Juillet",31);
		tabMois[7] = new Mois("Août ",31);
		tabMois[8] = new Mois("Septembre",30);
		tabMois[9] = new Mois("Octobre",31);
		tabMois[10] = new Mois("Novembre",30);
		tabMois[11] = new Mois("Décembre",31);
		
	
	
	}
	
	
	public boolean estLibre(int jour, int mois) {
		return tabMois[mois-1].estLibre(jour-1);
	}
	
	public boolean reserver(int jour, int mois) {
		
		if (estLibre(jour, mois) == false) {
			return false;
		} else {
			tabMois[mois-1].reserver(jour-1);
			return true;
		}
	}
	
	
	
	public class Mois{
		private String nom;
		private boolean[] jours;
		
		public Mois(String nom, int nbJours) {
			this.nom = nom;
			this.jours = new boolean[nbJours];
		}
		
		
		public boolean estLibre(int jour) {
				if (jours[jour] == false ) {
					return true;
				}
				return false;
			}
		
		public void reserver(int jour) {
			
			if (estLibre(jour) == false) {
				throw new IllegalStateException("jour déjà reservé");
				}
			else {
				jours[jour] = true;
				}
			}
		
		}
}
