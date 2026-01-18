
import java.util.ArrayList;
import java.util.List;

public class Pasutitajs {

	// 		================ ATRIBŪTI ================
	
			private String PasutitajaVards, adrese, talrunis, piedevas, nosaukums;
			private boolean UzVietas, statuss;
			private double cena;
			private int PLielums, PasutijumaID;
			
			
			// ========== KONSTRUKTORS ==========
			
			public Pasutitajs(int PLielums, int PasutijumaID, double cena, boolean UzVietas, boolean statuss, String PasutitajaVards, String adrese, String talrunis,
					String piedevas, String nosaukums) {
				this.PLielums = PLielums;
				this.PasutijumaID = PasutijumaID;
				this.cena = cena;
				this.UzVietas = UzVietas;
				this.statuss = statuss;
				this.PasutitajaVards = PasutitajaVards;
				this.adrese = adrese;
				this.talrunis = talrunis;
				this.piedevas = piedevas;
				this.nosaukums = nosaukums;
			}
			
			
			public String izvadit() {
				return "Pasūtitāja vārds: "+getVards()+
						"\nPicas cena: "+getCena()+" €"
						+ "\nStatuss: " + (statuss ? "Pabeigts" : "Aktīvs");
			}
			
			//=============== GETTER METODES ==================
			
			public int getPLielums() {
				return PLielums;
			}
			
			public int getPasutijumaID() {
				return PasutijumaID;
			}
			
			public double getCena() {
				return cena;
			}
			
			public boolean getUzVietas() {
				return UzVietas;
			}
			
			public boolean getStatuss() {
				return statuss;
			}
			
			public String getVards() {
				return PasutitajaVards;
			}
			
			public String getAdrese() {
				return adrese;
			}
			
			public String getTalrunis() {
				return talrunis;
			}
			
			public String getPiedevas() {
				return piedevas;
			}
			
			public String getNosaukums() {
				return nosaukums;
			}
			
			
			
			//=============== SETTER METODES ==================
			
			public void setPLielums(int PLielums) {
				this.PLielums = PLielums;
			}
			
			public void setPasutijumaID(int PasutijumaID) {
				this.PasutijumaID = PasutijumaID;
			}
			
			public void setCena(double cena) {
				this.cena = cena;
			}
			
			public void setUzVietas(boolean UzVietas) {
				this.UzVietas = UzVietas;
			}
			
			public void setStatuss(boolean statuss) {
				this.statuss = statuss;
			}
			
			public void setPasutitajaVards(String PasutitajaVards) {
				this.PasutitajaVards = PasutitajaVards;
			}
			
			public void setAdrese(String adrese) {
				this.adrese = adrese;
			}
			
			public void setTalrunis(String talrunis) {
				this.talrunis = talrunis;
			}
			
			public void setPiedevas(String piedevas) {
				this.piedevas = piedevas;
			}
			
			public void setNosaukums(String nosaukums) {
				this.nosaukums = nosaukums;
			}
}
