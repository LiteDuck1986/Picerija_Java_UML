import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;



public class Picerija {
	
	static String ievade;
	
	public static Pasutitajs pasutitajs = null;
	
	// Frame
	static JFrame frame;
	static CardLayout cardLayout;
	static JPanel galvenaisPanel;
	
	// JTextField
    static JTextField PasutijumaCENA, PVards, talrunis, adrese, IDField, picasNosaukums;
    
    
    // JCheckBox
    static JCheckBox S, M, XL, senes, ananas, pepperoni, merce, UzVietasJA, UzVietasNE;
    
    // labels
    static JLabel izmersLabel, piedevasLabel, UzVietasLabel, vardsLabel, nosaukumsLabel, adreseLabel, cenaLabel, talrunisLabel, IDLabel;
    
    
    
    // picas static mainīgie ko izmantoja priekš pasūtijuma izveides
    static int PicasIzmers = 10, n = 0;
    static String PicasPiedevas = "";
    static boolean UzVietas = true;
    static double PicasCena;
    static int ID = 67;
    
    // Krāsas izveide priekš programmas fona
    public final static Color sarkansTums = new Color(160, 5, 0);
	
	

	public static void main(String[] args) {

		frame = new JFrame("Picerijas pasūtijuma programma");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // ============= CardLayout ==============
        cardLayout = new CardLayout();
        galvenaisPanel = new JPanel(cardLayout);
        

        // ============= Paneļi ==============
        JPanel sakumsPanel = new JPanel(null);
        sakumsPanel.setBackground(sarkansTums);

        JPanel PasutijumaIzveidePanel = new JPanel(null);
        PasutijumaIzveidePanel.setBackground(sarkansTums);
        
        JPanel RedigetPanel = new JPanel(null);
        RedigetPanel.setBackground(sarkansTums);
       
        JPanel PasutijumiPanel = new JPanel(null);
        PasutijumiPanel.setBackground(sarkansTums);
        

        // ============= PANEĻU SAVIENOJUMS ==============
        galvenaisPanel.add(sakumsPanel, "sākums");
        galvenaisPanel.add(PasutijumaIzveidePanel, "pica");
        galvenaisPanel.add(RedigetPanel, "rediģēt");
        galvenaisPanel.add(PasutijumiPanel, "pasutijumi");
        
     
        
        // Pogas izveide (SADAĻAS)
        JButton SakumaPoga = new JButton("Sākums");
        SakumaPoga.setIcon(setIkona("/ikonas/sakums.png", 24));
        SakumaPoga.setBounds(10, 75, 160, 50);
        SakumaPoga.setBackground(Color.RED);
        SakumaPoga.setForeground(Color.WHITE);
        SakumaPoga.setFocusPainted(false);
        SakumaPoga.setHorizontalAlignment(SwingConstants.LEFT);
        SakumaPoga.setIconTextGap(10);
        sakumsPanel.add(SakumaPoga);

        
        JButton PasutijumaPoga = new JButton("Pievienot");
        PasutijumaPoga.setIcon(setIkona("/ikonas/pievienot.png", 24));
        PasutijumaPoga.setBounds(10, 150, 160, 50);
        PasutijumaPoga.setBackground(Color.RED);
        PasutijumaPoga.setForeground(Color.WHITE);
        PasutijumaPoga.setFocusPainted(false);
        PasutijumaPoga.setHorizontalAlignment(SwingConstants.LEFT);
        PasutijumaPoga.setIconTextGap(10);
        sakumsPanel.add(PasutijumaPoga);

        
        
        JButton RedigetPasutijumuPoga = new JButton("Rediģēt");
        RedigetPasutijumuPoga.setIcon(setIkona("/ikonas/rediget.png", 24));
        RedigetPasutijumuPoga.setBounds(10, 225, 160, 50);
        RedigetPasutijumuPoga.setBackground(Color.RED);
        RedigetPasutijumuPoga.setForeground(Color.WHITE);
        RedigetPasutijumuPoga.setFocusPainted(false);
        RedigetPasutijumuPoga.setHorizontalAlignment(SwingConstants.LEFT);
        RedigetPasutijumuPoga.setIconTextGap(10);
        sakumsPanel.add(RedigetPasutijumuPoga);

        
        JButton PasutijumiPoga = new JButton("Pasūtījumi");
        PasutijumiPoga.setIcon(setIkona("/ikonas/pasutijumi.png", 24));
        PasutijumiPoga.setBounds(10, 300, 160, 50);
        PasutijumiPoga.setBackground(Color.RED);
        PasutijumiPoga.setForeground(Color.WHITE);
        PasutijumiPoga.setFocusPainted(false);
        PasutijumiPoga.setHorizontalAlignment(SwingConstants.LEFT);
        PasutijumiPoga.setIconTextGap(10);
        sakumsPanel.add(PasutijumiPoga);

        
        
        // Paneļa pogas
        JButton PievienotPasutijumu = new JButton("Pievienot");
        PievienotPasutijumu.setBackground(Color.RED);
        PievienotPasutijumu.setForeground(Color.WHITE);
        PievienotPasutijumu.setBorderPainted(true);
        PievienotPasutijumu.setFocusPainted(false);
        PievienotPasutijumu.setBounds(400, 550, 150, 30);
        
        JButton AtjaunotPoga = new JButton("Atjaunot");
        AtjaunotPoga.setBackground(Color.RED);
        AtjaunotPoga.setForeground(Color.WHITE);
        AtjaunotPoga.setBorderPainted(true);
        AtjaunotPoga.setFocusPainted(false);
        AtjaunotPoga.setBounds(550, 550, 150, 30);
        
        JButton atiestatitPoga = new JButton("Atiestatīt");
        atiestatitPoga.setBackground(Color.RED);
        atiestatitPoga.setForeground(Color.WHITE);
        atiestatitPoga.setBorderPainted(true);
        atiestatitPoga.setFocusPainted(false);
        atiestatitPoga.setBounds(650, 550, 150, 30);
        
        // JTextFieldsss
        PasutijumaCENA = new JTextField("$0", 16);
        PasutijumaCENA.setBounds(400, 500, 160, 20);
        
        PVards = new JTextField("Jānis", 16);
        PVards.setBounds(400, 100, 160, 20);
        
        adrese = new JTextField("Liepāja, Ventpils iela 51, LV-6769", 16);
        adrese.setBounds(400, 200, 220, 20);
        
        talrunis = new JTextField("+371 23 676 676", 16);
        talrunis.setBounds(400, 150, 160, 20);
        
        IDField = new JTextField(""+ID);
        IDField.setBounds(400, 250, 160, 20);
        
        picasNosaukums = new JTextField("Pepperoni pica (15)", 16);
        picasNosaukums.setBounds(400, 400, 160, 20);
        
        // JCheckBox (Picas izmērs)
        S = new JCheckBox("10");
        S.setBounds(400, 350, 40, 20);
        S.setForeground(Color.WHITE);
        S.setOpaque(false);
        
        M = new JCheckBox("15");
        M.setBounds(450, 350, 40, 20);
        M.setForeground(Color.WHITE);
        M.setOpaque(false);
        
        XL = new JCheckBox("20");
        XL.setBounds(500, 350, 40, 20);
        XL.setForeground(Color.WHITE);
        XL.setOpaque(false);
        
        // Labels
        izmersLabel = new JLabel("Picas izmērs:");
        izmersLabel.setBounds(400, 325, 160, 20);
        izmersLabel.setForeground(Color.WHITE);
        
        vardsLabel = new JLabel("Pasūtitāja vārds:");
        vardsLabel.setBounds(400, 75, 160, 20);
        vardsLabel.setForeground(Color.WHITE);
        
        cenaLabel = new JLabel("Picas cena:");
        cenaLabel.setBounds(400, 475, 160, 20);
        cenaLabel.setForeground(Color.WHITE);
        
        adreseLabel = new JLabel("Pasūtītāja adrese:");
        adreseLabel.setBounds(400, 175, 160, 20);
        adreseLabel.setForeground(Color.WHITE);
        
        talrunisLabel = new JLabel("Pasūtītāja talrunis:");
        talrunisLabel.setBounds(400, 125, 160, 20);
        talrunisLabel.setForeground(Color.WHITE);
        
        IDLabel = new JLabel("Pasūtījuma ID:");
        IDLabel.setBounds(400, 225, 160, 20);
        IDLabel.setForeground(Color.WHITE);
        
        nosaukumsLabel = new JLabel("Picas nosaukums:");
        nosaukumsLabel.setBounds(400, 375, 160, 20);
        nosaukumsLabel.setForeground(Color.WHITE);
        
        
        // Picas piedevas
        senes = new JCheckBox("Sēnes");
        senes.setBounds(400, 300, 65, 20);
        senes.setForeground(Color.WHITE);
        senes.setOpaque(false);
        
        pepperoni = new JCheckBox("Pepperoni");
        pepperoni.setBounds(465, 300, 90, 20);
        pepperoni.setForeground(Color.WHITE);
        pepperoni.setOpaque(false);
        
        ananas = new JCheckBox("Ananāss");
        ananas.setBounds(560, 300, 80, 20);
        ananas.setForeground(Color.WHITE);
        ananas.setOpaque(false);
        
        // labels
        piedevasLabel = new JLabel("Picas piedevas:");
        piedevasLabel.setBounds(400, 275, 160, 20);
        piedevasLabel.setForeground(Color.WHITE);
        
        
        
        // Uz vietas check box
        UzVietasJA = new JCheckBox("Jā");
        UzVietasJA.setBounds(400, 450, 65, 20);
        UzVietasJA.setForeground(Color.WHITE);
        UzVietasJA.setOpaque(false);
        
        UzVietasNE = new JCheckBox("Nē");
        UzVietasNE.setBounds(465, 450, 90, 20);
        UzVietasNE.setForeground(Color.WHITE);
        UzVietasNE.setOpaque(false);
        
        // labels
        UzVietasLabel = new JLabel("Pasūtijumu savāks uz vietas?:");
        UzVietasLabel.setBounds(400, 425, 160, 20);
        UzVietasLabel.setForeground(Color.WHITE);
        
        
        PasutijumaIzveidePanel.add(PasutijumaCENA);
        PasutijumaIzveidePanel.add(PVards);
        PasutijumaIzveidePanel.add(adrese);
        PasutijumaIzveidePanel.add(talrunis);
        PasutijumaIzveidePanel.add(PievienotPasutijumu);
        PasutijumaIzveidePanel.add(atiestatitPoga);
        PasutijumaIzveidePanel.add(AtjaunotPoga);
        PasutijumaIzveidePanel.add(izmersLabel);
        PasutijumaIzveidePanel.add(piedevasLabel);
        PasutijumaIzveidePanel.add(UzVietasLabel);
        PasutijumaIzveidePanel.add(S);
        PasutijumaIzveidePanel.add(M);
        PasutijumaIzveidePanel.add(XL);
        PasutijumaIzveidePanel.add(senes);
        PasutijumaIzveidePanel.add(pepperoni);
        PasutijumaIzveidePanel.add(ananas);
        PasutijumaIzveidePanel.add(UzVietasJA);
        PasutijumaIzveidePanel.add(UzVietasNE);
        PasutijumaIzveidePanel.add(vardsLabel);
        PasutijumaIzveidePanel.add(cenaLabel);
        PasutijumaIzveidePanel.add(adreseLabel);
        PasutijumaIzveidePanel.add(talrunisLabel);
        PasutijumaIzveidePanel.add(IDLabel);
        PasutijumaIzveidePanel.add(IDField);
        PasutijumaIzveidePanel.add(nosaukumsLabel);
        PasutijumaIzveidePanel.add(picasNosaukums);
        
        frame.add(galvenaisPanel);
        frame.setVisible(true);
        

        
        ArrayList<Pasutitajs> Pasutitaji = new ArrayList<>();
        
        
        // JTable priekš pasūtijuma rediģēšanas.
        String[] columns = { "ID", "Pasūtītājs", "Izmērs", "Cena", "Uz vietas", "Piedevas" };

        DefaultTableModel DTableModelis = new DefaultTableModel(columns, 0);
        JTable table = new JTable(DTableModelis);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(180, 150, 600, 300);

        RedigetPanel.add(scroll);
        
        
        
        // ActionListeners  =================================================================================================
        PievienotPasutijumu.addActionListener(e -> {
        	
        	// Palielina ID numuru par 1
        	n++;
        	
        	// Pasūtijumi ID sākas ar 67.
        	int PasutijumaID = ID+n;
        	
        	int izmers = PicasIzmers;
        	boolean uzVietas = UzVietas;
        	
        	String piedeva = PicasPiedevas;
        	
        	String nosaukums = piedeva+" Pica ("+izmers+")";
        	
        	String vards = PVards.getText();
        	String Padrese = adrese.getText();
        	String talr = talrunis.getText();
        	
        	
        	double cena = picasCena(izmers, UzVietas, piedeva);
        	
        	
        	Pasutitajs pasutijums = new Pasutitajs(izmers, PasutijumaID, cena, uzVietas, vards, Padrese, talr, piedeva, nosaukums);
        	Pasutitaji.add(pasutijums);
        	
        	DTableModelis.addRow(new Object[]{
                    pasutijums.getPasutijumaID(),
                    pasutijums.getVards(),
                    pasutijums.getPLielums(),
                    pasutijums.getCena(),
                    pasutijums.getUzVietas(),
                    pasutijums.getPiedevas()
            });
        	
        	// Debug prints
            System.out.println("=====================================");
            System.out.println("        Pasūtijuma čeks\n");
            System.out.println("Pasūtijuma numurs: " + PasutijumaID);
            System.out.println("Picas izmērs: " + izmers);
            System.out.println("Picas saņem uz vietas?: " + uzVietas);
            System.out.println("Picas kopēja cena: " + cena);
            System.out.println("\n=====================================\n\n\n");
        	
//            izmersLabel.setText(PasutijumaCENA.getText());

            PasutijumaCENA.setText("$"+cena);
        	
        });
        
        AtjaunotPoga.addActionListener(e -> {
        	picasNosaukums.setText(PicasPiedevas+" Pica ("+PicasIzmers+")");
        	double cena = picasCena(PicasIzmers, UzVietas, PicasPiedevas);
        	PasutijumaCENA.setText("$"+cena);
        	IDField.setText(ID+n+"");
        });
        
        atiestatitPoga.addActionListener(e -> {
        	picasNosaukums.setText("");
        	PVards.setText("");
        	adrese.setText("");
        	talrunis.setText("");
        	PasutijumaCENA.setText("");
        	IDField.setText("");
        	
        	S.setSelected(false);
        	M.setSelected(false);
            XL.setSelected(false);
            senes.setSelected(false);
        	pepperoni.setSelected(false);
            ananas.setSelected(false);
            UzVietasNE.setSelected(false);
            UzVietasJA.setSelected(false);
        	
        });
        
        SakumaPoga.addActionListener(e -> {
        	sakumsPanel.add(PasutijumaPoga);
        	sakumsPanel.add(RedigetPasutijumuPoga);
        	sakumsPanel.add(SakumaPoga);
        	sakumsPanel.add(PasutijumiPoga);
        	cardLayout.show(galvenaisPanel, "sākums");
        });
        
        PasutijumaPoga.addActionListener(e -> {
        	PasutijumaIzveidePanel.add(PasutijumaPoga);
        	PasutijumaIzveidePanel.add(RedigetPasutijumuPoga);
        	PasutijumaIzveidePanel.add(SakumaPoga);
        	PasutijumaIzveidePanel.add(PasutijumiPoga);
        	cardLayout.show(galvenaisPanel, "pica");
        });
        
        RedigetPasutijumuPoga.addActionListener(e -> {
        	RedigetPanel.add(RedigetPasutijumuPoga);
        	RedigetPanel.add(PasutijumaPoga);
        	RedigetPanel.add(SakumaPoga);
        	RedigetPanel.add(PasutijumiPoga);
        	cardLayout.show(galvenaisPanel, "rediģēt");
        });
        
        
        DTableModelis.addTableModelListener(e -> {

            int rinda = e.getFirstRow();
            int kolonna = e.getColumn();

            if (rinda < 0 || kolonna < 0) return;

            Pasutitajs p = Pasutitaji.get(rinda);
            Object value = DTableModelis.getValueAt(rinda, kolonna);

          try {
            switch (kolonna) {
                case 1 -> p.setPLielums(Integer.parseInt(value.toString()));
                case 2 -> p.setPasutitajaVards(value.toString());
                case 3 -> p.setCena(Double.parseDouble(value.toString()));
                case 4 -> p.setUzVietas(value.toString().equalsIgnoreCase("true"));
                case 5 -> p.setPiedevas(value.toString());
            }
          } catch (Exception ex) {
              System.out.println("Nepareizi rediģēti dati!");
          }
        });


        
        
        PasutijumiPoga.addActionListener(e -> {
  	
        	String str = "";
    		
    		for (int i = 0; i < Pasutitaji.size(); i++) {
    		str += ((Pasutitajs) (Pasutitaji.get(i))).izvadit()
    				+"\n============================================\n";
    		}
    		
    		// Text area
    		JTextArea ta = new JTextArea(str.toString());
    		ta.setEditable(false);
    		ta.setLineWrap(true);
    		ta.setWrapStyleWord(true);
    		
    		// Scroll pane
    		JScrollPane sp = new JScrollPane(ta);
    		sp.setBounds(350, 100, 400, 400);
    		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        	
        	ta.setVisible(true);
        	sp.setVisible(true);
        	
        	// Noņem veco UI
        	PasutijumiPanel.removeAll();
        	
        	PasutijumiPanel.add(RedigetPasutijumuPoga);
        	PasutijumiPanel.add(PasutijumaPoga);
        	PasutijumiPanel.add(SakumaPoga);
        	PasutijumiPanel.add(PasutijumiPoga);
        	PasutijumiPanel.add(sp);
        	
        	// Refresho paneli
        	PasutijumiPanel.revalidate();
        	PasutijumiPanel.repaint();
        	
        	cardLayout.show(galvenaisPanel, "pasutijumi");
        });
        
        
        // Action Listener priekš JCheckBox
        ActionListener klausitajs = e -> {
            JCheckBox izveletais = (JCheckBox) e.getSource();

            // Picas izmērs sadaļa ==========================================================
            if (izveletais == S && S.isSelected()) {
                M.setSelected(false);
                XL.setSelected(false);
                PicasIzmers = 10;
            }
            if (izveletais == M && M.isSelected()) {
                S.setSelected(false);
                XL.setSelected(false);
                PicasIzmers = 15;
            }
            if (izveletais == XL && XL.isSelected()) {
                S.setSelected(false);
                M.setSelected(false);
                PicasIzmers = 20;
            }

            // Ja lietotājs visu ir uncheckojis tad Picas izmērs būs 10
            if (!S.isSelected() && !M.isSelected() && !XL.isSelected()) {
            	PicasIzmers = 10;
            }
            
            
            
            // Picas piedevumi sadaļa ====================================================
            if (izveletais == senes && senes.isSelected()) {
                pepperoni.setSelected(false);
                ananas.setSelected(false);
                PicasPiedevas = "Sēnes";
            }
            if (izveletais == pepperoni && pepperoni.isSelected()) {
            	senes.setSelected(false);
                ananas.setSelected(false);
                PicasPiedevas = "Pepperoni";
            }
            if (izveletais == ananas && ananas.isSelected()) {
            	senes.setSelected(false);
            	pepperoni.setSelected(false);
                PicasPiedevas = "Ananāss";
            }

            // Ja lietotājs visu ir uncheckojis tad Picas piedevums būs Pepperoni
            if (!senes.isSelected() && !pepperoni.isSelected() && !ananas.isSelected()) {
            	PicasPiedevas = "Pepperoni";
            }
            
            
            
            // Picas Uz vietas sadaļa ====================================================
            if (izveletais == UzVietasJA && UzVietasJA.isSelected()) {
            	UzVietasNE.setSelected(false);
                UzVietas = true;
            }
            if (izveletais == UzVietasNE && UzVietasNE.isSelected()) {
            	UzVietasJA.setSelected(false);
                UzVietas = false;
            }

            // Ja lietotājs visu ir uncheckojis tad boolean uz vietas būs jā
            if (!UzVietasJA.isSelected() && !UzVietasNE.isSelected()) {
            	UzVietas = true;
            }
            
            
            // Debug prints
            System.out.println("=====================================");
            System.out.println("       Check Box debug logs\n");
            System.out.println("Picas izmērs: " + PicasIzmers);
            System.out.println("Picas piedeva: " + PicasPiedevas);
            System.out.println("Pasūtijumu savāks uz vietas?: " + UzVietas);
            System.out.println("\n=====================================\n\n\n\n");
        };

        S.addActionListener(klausitajs);
        M.addActionListener(klausitajs);
        XL.addActionListener(klausitajs);
        
        senes.addActionListener(klausitajs);
        pepperoni.addActionListener(klausitajs);
        ananas.addActionListener(klausitajs);
        
        UzVietasJA.addActionListener(klausitajs);
        UzVietasNE.addActionListener(klausitajs);
        
	}

	public static double picasCena(int izmers, boolean uzVietas, String piedeva) {
		// Katru reizi kad izsauc šo metodi uzliekam cenu uz 0.00
		PicasCena = 0.00;
		
		// izmēra cena
		if (izmers == 10)
			PicasCena += 3.50;
		
		if (izmers == 15)
			PicasCena += 5.50;
		
		if (izmers == 20)
			PicasCena += 7.00;
			
		
		// piedevas cena
		if (piedeva.equals("Sēnes"))
			PicasCena += 1.80;
		
		if (piedeva.equals("Pepperoni"))
			PicasCena += 2.50;
		
		if (piedeva.equals("Ananāss"))
			PicasCena += 2.00;
		
		
		// Uz vietas cena
		if (uzVietas == true)
			PicasCena += 0.00;
				
		if (!uzVietas)
			PicasCena += 3.20;
				
			
		return PicasCena;
	}
	
	// metode kas seto ikonas
	private static ImageIcon setIkona(String cels, int izmers) {
	    ImageIcon ikona = new ImageIcon(
	        Picerija.class.getResource(cels)
	    );
	    Image img = ikona.getImage().getScaledInstance(izmers, izmers, Image.SCALE_SMOOTH);
	    return new ImageIcon(img);
	}

	

}
