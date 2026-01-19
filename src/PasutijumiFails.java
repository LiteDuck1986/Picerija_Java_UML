import java.io.*;
import java.util.ArrayList;

public class PasutijumiFails {

	    private static final String faila_nosaukums = "pasutijumi.txt";

	    // Saglabāt metode
	    public static void saglabaPasutijumus(ArrayList<Pasutitajs> Pasutitaji, ArrayList<Pasutitajs> pabeigtiePasutijumi) {

	        try (PrintWriter raksta = new PrintWriter(new FileWriter(faila_nosaukums))) {

	            // Saglabā aktīvos pasūtījumus
	            for (Pasutitajs p : Pasutitaji) {
	            	raksta.println("AKTĪVS");
	            	raksta.println(p.getPasutijumaID());
	            	raksta.println(p.getPLielums());
	            	raksta.println(p.getPiedevas());
	            	raksta.println(p.getMerce());
	            	raksta.println(p.getUzkoda());
	            	raksta.println(p.getDzeriens());
	            	raksta.println(p.getUzVietas());
	            	raksta.println(p.getCena());
	            	raksta.println(p.getNosaukums());
	            	raksta.println(p.getVards());
	            	raksta.println(p.getAdrese());
	            	raksta.println(p.getTalrunis());
	            	raksta.println(p.getStatuss());
	            	raksta.println("--------------------");
	            }

	            // Save finished orders
	            for (Pasutitajs p : pabeigtiePasutijumi) {
	            	raksta.println("PABEIGTS");
	            	raksta.println(p.getPasutijumaID());
	            	raksta.println(p.getPLielums());
	            	raksta.println(p.getPiedevas());
	            	raksta.println(p.getMerce());
	            	raksta.println(p.getUzkoda());
	            	raksta.println(p.getDzeriens());
	            	raksta.println(p.getUzVietas());
	            	raksta.println(p.getCena());
	            	raksta.println(p.getNosaukums());
	            	raksta.println(p.getVards());
	            	raksta.println(p.getAdrese());
	            	raksta.println(p.getTalrunis());
	            	raksta.println(p.getStatuss());
	            	raksta.println("--------------------");
	            }

	        } catch (IOException e) {
	            System.out.println("Kļūda glabājot pasūtījumus!");
	        }
	    }

	    // Nolasīt metode
	    public static void nolasaPasutijumus(ArrayList<Pasutitajs> Pasutitaji, ArrayList<Pasutitajs> pabeigtiePasutijumi) {

	        File fails = new File(faila_nosaukums);
	        if (!fails.exists()) return;

	        try (BufferedReader br = new BufferedReader(new FileReader(fails))) {

	            String linija;
	            while ((linija = br.readLine()) != null) {

	                String statuss = linija;

	                int id = Integer.parseInt(br.readLine());
	                int izmers = Integer.parseInt(br.readLine());
	                String piedevas = br.readLine();
	                String merce = br.readLine();
	                String uzkoda = br.readLine();
	                String dzeriens = br.readLine();
	                boolean uzVietas = Boolean.parseBoolean(br.readLine());
	                double cena = Double.parseDouble(br.readLine());
	                String nosaukums = br.readLine();
	                String vards = br.readLine();
	                String adrese = br.readLine();
	                String talrunis = br.readLine();
	                boolean status = Boolean.parseBoolean(br.readLine());
	                
	                br.readLine(); // izlaiž -------

	                Pasutitajs p = new Pasutitajs(izmers, id, cena, uzVietas, status, vards, adrese, talrunis, piedevas, nosaukums, merce, uzkoda, dzeriens);

	                if (statuss.equals("AKTĪVS")) {
	                	Pasutitaji.add(p);
	                } else {
	                	pabeigtiePasutijumi.add(p);
	                }
	            }

	        } catch (Exception e) {
	            System.out.println("Kļūda nolasot pasūtījumus!");
	        }
	    }
	
}
