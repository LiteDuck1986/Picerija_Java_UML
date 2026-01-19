import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;



public class Picerija {
	
	static String ievade;
	
	public static Pasutitajs pasutitajs = null;
	
	static Random rand = new Random();
	
	// Frame
	static JFrame frame;
	static CardLayout cardLayout;
	static JPanel galvenaisPanel;
	
	// JTextField
    static JTextField PasutijumaCENA, PVards, talrunis, adrese, IDField, picasNosaukums;
    
    // JTextArea
    static JTextArea aktivsArea, pabeigtsArea;
    
    //JScrollPanel
    static JScrollPane aktivieScroll, pabeigtieScroll;
    
    // JCheckBox
    static JCheckBox S, M, XL, senes, ananas, pepperoni, merce, UzVietasJA, UzVietasNE, sinepes, kecups, majoneze, kola, sprite, udens,
    Mmaize, nageti, cipsi;
    
    // labels
    static JLabel izmersLabel, piedevasLabel, UzVietasLabel, vardsLabel, nosaukumsLabel, adreseLabel, cenaLabel, talrunisLabel, IDLabel,
    mercesLabel, uzkodasLabel, dzerieniLabel;
    
    static ArrayList<Pasutitajs> Pasutitaji = new ArrayList<>();
    static ArrayList<Pasutitajs> pabeigtiePasutijumi = new ArrayList<>();
    
    // picas static mainīgie ko izmantoja priekš pasūtijuma izveides
    static int PicasIzmers = 10;
    static String PicasPiedevas = "";
    static String PicasMerce = "";
    static String dzerieni = "";
    static String uzkodas = "";
    static boolean UzVietas = true;
    static double PicasCena;
    static int ID = rand.nextInt(9000) + 1000;
    
    // Krāsas izveide priekš programmas fona
    public final static Color sarkansTums = new Color(160, 5, 0);
	
	

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		// UIManager nozagu no Gustāvs Lācis 2PT, lai mana programma izskatītos skaistāka!
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

		frame = new JFrame("Picerijas pasūtījuma sistēma");
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
        SakumaPoga.setBorderPainted(false);
        SakumaPoga.setHorizontalAlignment(SwingConstants.LEFT);
        SakumaPoga.setIconTextGap(10);
        sakumsPanel.add(SakumaPoga);

        
        JButton PasutijumaPoga = new JButton("Pievienot");
        PasutijumaPoga.setIcon(setIkona("/ikonas/pievienot.png", 24));
        PasutijumaPoga.setBounds(10, 150, 160, 50);
        PasutijumaPoga.setBackground(Color.RED);
        PasutijumaPoga.setForeground(Color.WHITE);
        PasutijumaPoga.setFocusPainted(false);
        PasutijumaPoga.setBorderPainted(false);
        PasutijumaPoga.setHorizontalAlignment(SwingConstants.LEFT);
        PasutijumaPoga.setIconTextGap(10);
        sakumsPanel.add(PasutijumaPoga);

        
        
        JButton RedigetPasutijumuPoga = new JButton("Rediģēt");
        RedigetPasutijumuPoga.setIcon(setIkona("/ikonas/rediget.png", 24));
        RedigetPasutijumuPoga.setBounds(10, 225, 160, 50);
        RedigetPasutijumuPoga.setBackground(Color.RED);
        RedigetPasutijumuPoga.setForeground(Color.WHITE);
        RedigetPasutijumuPoga.setFocusPainted(false);
        RedigetPasutijumuPoga.setBorderPainted(false);
        RedigetPasutijumuPoga.setHorizontalAlignment(SwingConstants.LEFT);
        RedigetPasutijumuPoga.setIconTextGap(10);
        sakumsPanel.add(RedigetPasutijumuPoga);

        
        JButton PasutijumiPoga = new JButton("Pasūtījumi");
        PasutijumiPoga.setIcon(setIkona("/ikonas/pasutijumi.png", 24));
        PasutijumiPoga.setBounds(10, 300, 160, 50);
        PasutijumiPoga.setBackground(Color.RED);
        PasutijumiPoga.setForeground(Color.WHITE);
        PasutijumiPoga.setFocusPainted(false);
        PasutijumiPoga.setBorderPainted(false);
        PasutijumiPoga.setHorizontalAlignment(SwingConstants.LEFT);
        PasutijumiPoga.setIconTextGap(10);
        sakumsPanel.add(PasutijumiPoga);

        
        
        // Paneļa pogas
        JButton PievienotPasutijumu = new JButton("Pievienot");
        PievienotPasutijumu.setBackground(Color.RED);
        PievienotPasutijumu.setForeground(Color.WHITE);
        PievienotPasutijumu.setBorderPainted(true);
        PievienotPasutijumu.setFocusPainted(false);
        PievienotPasutijumu.setBounds(300, 550, 125, 30);
        
        JButton AtjaunotPoga = new JButton("Atjaunot");
        AtjaunotPoga.setBackground(Color.RED);
        AtjaunotPoga.setForeground(Color.WHITE);
        AtjaunotPoga.setBorderPainted(true);
        AtjaunotPoga.setFocusPainted(false);
        AtjaunotPoga.setBounds(450, 550, 125, 30);
        
        JButton atiestatitPoga = new JButton("Atiestatīt");
        atiestatitPoga.setBackground(Color.RED);
        atiestatitPoga.setForeground(Color.WHITE);
        atiestatitPoga.setBorderPainted(true);
        atiestatitPoga.setFocusPainted(false);
        atiestatitPoga.setBounds(600, 550, 135, 30);
        
        // Rediģēt pasūtījumu paneļa pogas
        JButton dzestPoga = new JButton("Dzēst");
        dzestPoga.setBackground(Color.RED);
        dzestPoga.setForeground(Color.WHITE);
        dzestPoga.setBorderPainted(true);
        dzestPoga.setFocusPainted(false);
        dzestPoga.setBounds(475, 600, 150, 30);
        
        JButton pabeigtPoga = new JButton("Pabeigt pasūtījumu");
        pabeigtPoga.setBackground(Color.RED);
        pabeigtPoga.setForeground(Color.WHITE);
        pabeigtPoga.setBorderPainted(true);
        pabeigtPoga.setFocusPainted(false);
        pabeigtPoga.setBounds(550, 600, 200, 30);
        
        // Pasūtijumi paneļa pogas
        JButton saglabatPoga = new JButton("Saglabāt failā");
        saglabatPoga.setBackground(Color.RED);
        saglabatPoga.setForeground(Color.WHITE);
        saglabatPoga.setBorderPainted(true);
        saglabatPoga.setFocusPainted(false);
        saglabatPoga.setBounds(550, 550, 200, 30);
        
        JButton nolasitPoga = new JButton("nolasīt no faila");
        nolasitPoga.setBackground(Color.RED);
        nolasitPoga.setForeground(Color.WHITE);
        nolasitPoga.setBorderPainted(true);
        nolasitPoga.setFocusPainted(false);
        nolasitPoga.setBounds(625, 550, 200, 30);
        
        // JTextFieldsss
        PasutijumaCENA = new JTextField("0.00€", 16);
        PasutijumaCENA.setBounds(300, 500, 125, 30);
        
        PVards = new JTextField("Jānis", 16);
        PVards.setBounds(300, 100, 220, 30);
        
        adrese = new JTextField("Liepāja, Ventpils iela 51, LV-6769", 16);
        adrese.setBounds(300, 220, 220, 30);
        
        talrunis = new JTextField("+371 23 676 676", 16);
        talrunis.setBounds(300, 160, 220, 30);
        
        IDField = new JTextField(""+ID);
        IDField.setBounds(300, 280, 220, 30);
        
        picasNosaukums = new JTextField("Pepperoni pica (15)", 16);
        picasNosaukums.setBounds(600, 350, 220, 30);
        
        // JCheckBox (Picas izmērs)
        S = new JCheckBox("10");
        S.setBounds(600, 100, 40, 20);
        S.setForeground(Color.WHITE);
        S.setOpaque(false);
        
        M = new JCheckBox("15");
        M.setBounds(650, 100, 40, 20);
        M.setForeground(Color.WHITE);
        M.setOpaque(false);
        
        XL = new JCheckBox("20");
        XL.setBounds(700, 100, 40, 20);
        XL.setForeground(Color.WHITE);
        XL.setOpaque(false);
        
        // Labels
        izmersLabel = new JLabel("Picas izmērs:");
        izmersLabel.setBounds(600, 75, 160, 20);
        izmersLabel.setForeground(Color.WHITE);
        
        vardsLabel = new JLabel("Pasūtitāja vārds:");
        vardsLabel.setBounds(300, 75, 160, 20);
        vardsLabel.setForeground(Color.WHITE);
        
        cenaLabel = new JLabel("Pasūtījuma cena:");
        cenaLabel.setBounds(300, 475, 160, 20);
        cenaLabel.setForeground(Color.WHITE);
        
        adreseLabel = new JLabel("Pasūtītāja adrese:");
        adreseLabel.setBounds(300, 195, 160, 20);
        adreseLabel.setForeground(Color.WHITE);
        
        talrunisLabel = new JLabel("Pasūtītāja talrunis:");
        talrunisLabel.setBounds(300, 135, 160, 20);
        talrunisLabel.setForeground(Color.WHITE);
        
        IDLabel = new JLabel("Pasūtījuma ID:");
        IDLabel.setBounds(300, 255, 160, 20);
        IDLabel.setForeground(Color.WHITE);
        
        nosaukumsLabel = new JLabel("Picas nosaukums:");
        nosaukumsLabel.setBounds(600, 325, 160, 20);
        nosaukumsLabel.setForeground(Color.WHITE);
        
        
        // Picas piedevas
        senes = new JCheckBox("Sēnes");
        senes.setBounds(600, 150, 65, 20);
        senes.setForeground(Color.WHITE);
        senes.setOpaque(false);
        
        pepperoni = new JCheckBox("Pepperoni");
        pepperoni.setBounds(668, 150, 90, 20);
        pepperoni.setForeground(Color.WHITE);
        pepperoni.setOpaque(false);
        
        ananas = new JCheckBox("Ananāss");
        ananas.setBounds(760, 150, 80, 20);
        ananas.setForeground(Color.WHITE);
        ananas.setOpaque(false);
        
        // labels piedavas
        piedevasLabel = new JLabel("Picas piedevas:");
        piedevasLabel.setBounds(600, 125, 160, 20);
        piedevasLabel.setForeground(Color.WHITE);
        
        
        // picas Mērces
        sinepes = new JCheckBox("Sinepes");
        sinepes.setBounds(600, 200, 77, 20);
        sinepes.setForeground(Color.WHITE);
        sinepes.setOpaque(false);
        
        kecups = new JCheckBox("Kečups");
        kecups.setBounds(675, 200, 66, 20);
        kecups.setForeground(Color.WHITE);
        kecups.setOpaque(false);
        
        majoneze = new JCheckBox("Majonēze");
        majoneze.setBounds(750, 200, 85, 20);
        majoneze.setForeground(Color.WHITE);
        majoneze.setOpaque(false);
        
        // labels merces
        mercesLabel = new JLabel("Picas mērce:");
        mercesLabel.setBounds(600, 175, 160, 20);
        mercesLabel.setForeground(Color.WHITE);
        
        
        // uzkodas CheckBox
        nageti = new JCheckBox("Nageti");
        nageti.setBounds(600, 250, 70, 20);
        nageti.setForeground(Color.WHITE);
        nageti.setOpaque(false);
        
        cipsi = new JCheckBox("Čipši");
        cipsi.setBounds(670, 250, 60, 20);
        cipsi.setForeground(Color.WHITE);
        cipsi.setOpaque(false);
        
        Mmaize = new JCheckBox("Mini maize");
        Mmaize.setBounds(735, 250, 100, 20);
        Mmaize.setForeground(Color.WHITE);
        Mmaize.setOpaque(false);
        
        // labels uzkodas
        uzkodasLabel = new JLabel("Uzkodas:");
        uzkodasLabel.setBounds(600, 225, 160, 20);
        uzkodasLabel.setForeground(Color.WHITE);
        
        
        // Dzērieni CheckBox
        kola = new JCheckBox("Kola -0.5L");
        kola.setBounds(600, 300, 100, 20);
        kola.setForeground(Color.WHITE);
        kola.setOpaque(false);
        
        sprite = new JCheckBox("Sprite -0.5L");
        sprite.setBounds(700, 300, 100, 20);
        sprite.setForeground(Color.WHITE);
        sprite.setOpaque(false);
        
        udens = new JCheckBox("Ūdens -0.5L");
        udens.setBounds(800, 300, 100, 20);
        udens.setForeground(Color.WHITE);
        udens.setOpaque(false);
        
        // labels dzerieni
        dzerieniLabel = new JLabel("Dzērieni:");
        dzerieniLabel.setBounds(600, 275, 160, 20);
        dzerieniLabel.setForeground(Color.WHITE);
        
        
        // Uz vietas check box
        UzVietasJA = new JCheckBox("Uz vietas");
        UzVietasJA.setBounds(300, 345, 76, 20);
        UzVietasJA.setForeground(Color.WHITE);
        UzVietasJA.setOpaque(false);
        
        UzVietasNE = new JCheckBox("Piegāde");
        UzVietasNE.setBounds(380, 345, 70, 20);
        UzVietasNE.setForeground(Color.WHITE);
        UzVietasNE.setOpaque(false);
        
        // labels
        UzVietasLabel = new JLabel("Pasūtijumu savāks uz vietas?:");
        UzVietasLabel.setBounds(300, 320, 160, 20);
        UzVietasLabel.setForeground(Color.WHITE);
        
        
        aktivsArea = new JTextArea();
    	aktivsArea.setEditable(false);
    	aktivsArea.setLineWrap(true);

        pabeigtsArea = new JTextArea();
        pabeigtsArea.setEditable(false);
        pabeigtsArea.setLineWrap(true);

        aktivieScroll = new JScrollPane(aktivsArea);
        aktivieScroll.setBounds(300, 100, 350, 300);

        pabeigtieScroll = new JScrollPane(pabeigtsArea);
        pabeigtieScroll.setBounds(700, 100, 350, 300);
        
        
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
        PasutijumaIzveidePanel.add(sinepes);
        PasutijumaIzveidePanel.add(kecups);
        PasutijumaIzveidePanel.add(majoneze);
        PasutijumaIzveidePanel.add(nageti);
        PasutijumaIzveidePanel.add(cipsi);
        PasutijumaIzveidePanel.add(Mmaize);
        PasutijumaIzveidePanel.add(kola);
        PasutijumaIzveidePanel.add(sprite);
        PasutijumaIzveidePanel.add(udens);
        PasutijumaIzveidePanel.add(mercesLabel);
        PasutijumaIzveidePanel.add(uzkodasLabel);
        PasutijumaIzveidePanel.add(dzerieniLabel);
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
        
        
        
        // JTable priekš pasūtijuma rediģēšanas.
        String[] columns = { "ID", "Pasūtītājs", "Izmērs", "Cena", "Uz vietas", "Piedevas" };

        DefaultTableModel DTableModelis = new DefaultTableModel(columns, 0);
        JTable table = new JTable(DTableModelis);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(180, 150, 600, 300);

        RedigetPanel.add(scroll);
        RedigetPanel.add(pabeigtPoga);
        RedigetPanel.add(dzestPoga);
        
        
        
        // ActionListeners  =================================================================================================
        PievienotPasutijumu.addActionListener(e -> {
        	
        	String IDTeksts = IDField.getText().trim();

        	if (!IDTeksts.matches("\\d{4}")) {
        	    JOptionPane.showMessageDialog(null,
        	        "ID jābūt 4 cipariem!", "Kļūda", JOptionPane.ERROR_MESSAGE);
        	    return;
        	}

        	int PasutijumaID = Integer.parseInt(IDTeksts);
        	
        	String vards = PVards.getText();
        	String Padrese = adrese.getText();
        	String talr = talrunis.getText();
        	
        	// Pārbaudes
        	if (!vards.matches("^[A-Za-zĀ-ž]+$")) {
                JOptionPane.showMessageDialog(null, "Ievadi vārdu!");
                return;
            }

            if (Padrese.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ievadi adresi!");
                return;
            }

            if (!talr.matches("^\\+371 \\d{2} \\d{3} \\d{3}$")) {
                JOptionPane.showMessageDialog(null, "Tālruņa formāts nav pareizs!\nPiemērs: +371 22 064 856");
                return;
            }

            if (!S.isSelected() && !M.isSelected() && !XL.isSelected()) {
                JOptionPane.showMessageDialog(null, "Izvēlies picas izmēru!");
                return;
            }


            if (!UzVietasJA.isSelected() && !UzVietasNE.isSelected()) {
                JOptionPane.showMessageDialog(null, "Izvēlies vai uz vietas vai piegāde!");
                return;
            }
        	
        	
            String merce = PicasMerce;
            String uzkoda = uzkodas;
            String dzeriens = dzerieni;
        	int izmers = PicasIzmers;
        	boolean uzVietas = UzVietas;
        	String piedeva = PicasPiedevas;
        	String nosaukums = piedeva+" Pica ("+izmers+")";
        	double cena = picasCena(izmers, UzVietas, piedeva, nosaukums, nosaukums, nosaukums);
        	
        	Pasutitajs pasutijums = new Pasutitajs(izmers, PasutijumaID, cena, uzVietas, false, vards, Padrese, talr, piedeva,
        			nosaukums, merce, uzkoda, dzeriens);
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
            System.out.println("Picas kopēja cena: " + cena+"€");
            System.out.println("\n=====================================\n\n\n");
        	

            PasutijumaCENA.setText(String.format("%.2f €", cena));
            
            JOptionPane.showMessageDialog(PasutijumaIzveidePanel, "Ir izveidots jauns pasūtījums ar "+PasutijumaID+" pasūtījuma ID!", "Brīdinājums",
					JOptionPane.WARNING_MESSAGE);
        	
        });
        
        AtjaunotPoga.addActionListener(e -> {
        	int pasutijumaID = 1000 + new Random().nextInt(9000);
        	
        	picasNosaukums.setText(PicasPiedevas+" Pica ("+PicasIzmers+")");
        	double cena = picasCena(PicasIzmers, UzVietas, PicasPiedevas, PicasMerce, uzkodas, dzerieni);
        	PasutijumaCENA.setText(String.format("%.2f €", cena));
        	IDField.setText(pasutijumaID+"");
        });
        
        atiestatitPoga.addActionListener(e -> {
        	int pasutijumaID = 1000 + new Random().nextInt(9000);
        	picasNosaukums.setText("");
        	PVards.setText("");
        	adrese.setText("");
        	talrunis.setText("");
        	PasutijumaCENA.setText("0.00€");
        	IDField.setText(pasutijumaID+"");
        	
        	S.setSelected(false);
        	M.setSelected(false);
            XL.setSelected(false);
            senes.setSelected(false);
        	pepperoni.setSelected(false);
            ananas.setSelected(false);
            UzVietasNE.setSelected(false);
            UzVietasJA.setSelected(false);
            sinepes.setSelected(false);
        	kecups.setSelected(false);
            majoneze.setSelected(false);
            nageti.setSelected(false);
        	cipsi.setSelected(false);
            Mmaize.setSelected(false);
            kola.setSelected(false);
        	sprite.setSelected(false);
            udens.setSelected(false);
        	
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
                case 4 -> p.setUzVietas(Boolean.parseBoolean(value.toString()));
                case 5 -> p.setPiedevas(value.toString());
            }
          } catch (Exception ex) {
              System.out.println("Nepareizi rediģēti dati!");
          }
        });

        pabeigtPoga.addActionListener(e -> {

            int izveletaRinda = table.getSelectedRow();

            if (izveletaRinda == -1) {
                JOptionPane.showMessageDialog(null, "Izvēlies pasūtījumu!");
                return;
            }

            Pasutitajs p = Pasutitaji.get(izveletaRinda);

            p.setStatuss(true);
            pabeigtiePasutijumi.add(p);
            
            Pasutitaji.remove(izveletaRinda);
            
         // Noņem izveleto rindu no JTable
            DTableModelis.removeRow(izveletaRinda);
            
         // Atjauno tekstu
            AtjaunoTextArea();

            JOptionPane.showMessageDialog(null, "Pasūtījums pabeigts!");
        });
        
        dzestPoga.addActionListener(e -> {

            int izveletaRinda = table.getSelectedRow();

            if (izveletaRinda == -1) {
                JOptionPane.showMessageDialog(null, "Izvēlies pasūtījumu!");
                return;
            }

            // Noņem no arrayList
            Pasutitaji.remove(izveletaRinda);

            // Noņem izvēlēto rindu no JTable
            DTableModelis.removeRow(izveletaRinda);
            

            JOptionPane.showMessageDialog(null, "Pasūtījums dzēsts!");
        });

        
        
        PasutijumiPoga.addActionListener(e -> {
        	
        	// Noņem veco UI
        	PasutijumiPanel.removeAll();
        	
        	PasutijumiPanel.add(aktivieScroll);
            PasutijumiPanel.add(pabeigtieScroll);
        	PasutijumiPanel.add(RedigetPasutijumuPoga);
        	PasutijumiPanel.add(PasutijumaPoga);
        	PasutijumiPanel.add(SakumaPoga);
        	PasutijumiPanel.add(PasutijumiPoga);
        	PasutijumiPanel.add(saglabatPoga);
        	PasutijumiPanel.add(nolasitPoga);
        	
        	AtjaunoTextArea();
        	
        	// Refresho paneli
        	PasutijumiPanel.revalidate();
        	PasutijumiPanel.repaint();
        	
        	cardLayout.show(galvenaisPanel, "pasutijumi");
        });
        
        saglabatPoga.addActionListener(e -> {
        	
        	PasutijumiFails.saglabaPasutijumus(Pasutitaji, pabeigtiePasutijumi);
        	PasutijumiPanel.removeAll();
        	
        	PasutijumiPanel.add(aktivieScroll);
            PasutijumiPanel.add(pabeigtieScroll);
        	PasutijumiPanel.add(RedigetPasutijumuPoga);
        	PasutijumiPanel.add(PasutijumaPoga);
        	PasutijumiPanel.add(SakumaPoga);
        	PasutijumiPanel.add(PasutijumiPoga);
        	PasutijumiPanel.add(saglabatPoga);
        	PasutijumiPanel.add(nolasitPoga);
        	
        	AtjaunoTextArea();
        	PasutijumiPanel.revalidate();
        	PasutijumiPanel.repaint();
        });
        
        nolasitPoga.addActionListener(e -> {
        	
        	Pasutitaji.clear();
            pabeigtiePasutijumi.clear();
        	
        	PasutijumiFails.nolasaPasutijumus(Pasutitaji, pabeigtiePasutijumi);
        	
        	// Iztīra visu JTable
        	DTableModelis.setRowCount(0);  // iztīra visas rindas

        	// pievieno visus aktīvos pasūtījumus
        	for (Pasutitajs pasutijums : Pasutitaji) {
        	    DTableModelis.addRow(new Object[]{
        	        pasutijums.getPasutijumaID(),
        	        pasutijums.getVards(),
        	        pasutijums.getPLielums(),
        	        pasutijums.getCena(),
        	        pasutijums.getUzVietas(),
        	        pasutijums.getPiedevas()
        	    });
        	}
        	
        	PasutijumiPanel.removeAll();
        	
        	PasutijumiPanel.add(aktivieScroll);
            PasutijumiPanel.add(pabeigtieScroll);
        	PasutijumiPanel.add(RedigetPasutijumuPoga);
        	PasutijumiPanel.add(PasutijumaPoga);
        	PasutijumiPanel.add(SakumaPoga);
        	PasutijumiPanel.add(PasutijumiPoga);
        	PasutijumiPanel.add(saglabatPoga);
        	PasutijumiPanel.add(nolasitPoga);
        	
        	AtjaunoTextArea();
        	PasutijumiPanel.revalidate();
        	PasutijumiPanel.repaint();
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

            // Ja lietotājs visu ir uncheckojis tad Picas izmērs būs 10 (Viss mazākais)
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

            // Ja lietotājs visu ir uncheckojis tad Picas piedevums būs null
            if (!senes.isSelected() && !pepperoni.isSelected() && !ananas.isSelected()) {
            	PicasPiedevas = "nav";
            }
            
            
         // Picas merces sadaļa ====================================================
            if (izveletais == sinepes && sinepes.isSelected()) {
                kecups.setSelected(false);
                majoneze.setSelected(false);
                PicasMerce = "Sinepes";
            }
            if (izveletais == kecups && kecups.isSelected()) {
            	majoneze.setSelected(false);
            	sinepes.setSelected(false);
                PicasMerce = "Kečups";
            }
            if (izveletais == majoneze && majoneze.isSelected()) {
            	kecups.setSelected(false);
            	sinepes.setSelected(false);
            	PicasMerce = "Majonēze";
            }

            // Ja lietotājs visu ir uncheckojis tad Picas mērce būs null
            if (!sinepes.isSelected() && !kecups.isSelected() && !majoneze.isSelected()) {
            	PicasMerce = "nav";
            }
            
            
            // uzkodas sadaļa ====================================================
            if (izveletais == nageti && nageti.isSelected()) {
                Mmaize.setSelected(false);
                cipsi.setSelected(false);
                uzkodas = "Nageti";
            }
            if (izveletais == cipsi && cipsi.isSelected()) {
            	Mmaize.setSelected(false);
            	nageti.setSelected(false);
                uzkodas = "Čipši";
            }
            if (izveletais == Mmaize && Mmaize.isSelected()) {
            	nageti.setSelected(false);
            	cipsi.setSelected(false);
            	uzkodas = "Mini maize";
            }

            // Ja lietotājs visu ir uncheckojis tad Picas piedevums būs Pepperoni
            if (!nageti.isSelected() && !cipsi.isSelected() && !Mmaize.isSelected()) {
            	uzkodas = "nav";
            }
            
            
            // dzērieni sadaļa ====================================================
            if (izveletais == kola && kola.isSelected()) {
                sprite.setSelected(false);
                udens.setSelected(false);
                dzerieni = "Kola -0.5L";
            }
            if (izveletais == sprite && sprite.isSelected()) {
            	kola.setSelected(false);
            	udens.setSelected(false);
                dzerieni = "Sprite -0.5L";
            }
            if (izveletais == udens && udens.isSelected()) {
            	sprite.setSelected(false);
            	kola.setSelected(false);
            	dzerieni = "Ūdens -0.5L";
            }

            // Ja lietotājs visu ir uncheckojis tad dzērieni būs null
            if (!kola.isSelected() && !sprite.isSelected() && !udens.isSelected()) {
            	dzerieni = "nav";
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
            
            
        };

        S.addActionListener(klausitajs);
        M.addActionListener(klausitajs);
        XL.addActionListener(klausitajs);
        
        senes.addActionListener(klausitajs);
        pepperoni.addActionListener(klausitajs);
        ananas.addActionListener(klausitajs);
        
        UzVietasJA.addActionListener(klausitajs);
        UzVietasNE.addActionListener(klausitajs);
        
        sinepes.addActionListener(klausitajs);
        kecups.addActionListener(klausitajs);
        majoneze.addActionListener(klausitajs);
        
        nageti.addActionListener(klausitajs);
        cipsi.addActionListener(klausitajs);
        Mmaize.addActionListener(klausitajs);
        
        kola.addActionListener(klausitajs);
        sprite.addActionListener(klausitajs);
        udens.addActionListener(klausitajs);
        
	}

	// metode kas apgriež pasūtijuma cenu!
	public static double picasCena(int izmers, boolean uzVietas, String piedeva, String merce, String uzkoda, String dzeriens) {
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
		
		if (piedeva.equals("nav"))
			PicasCena += 0.00;
		
		
		// merces cena
		if (merce.equals("Sinepes"))
			PicasCena += 2.60;
				
		if (merce.equals("Kečups"))
			PicasCena += 1.60;
				
		if (merce.equals("Majonēze"))
			PicasCena += 1.30;
				
		if (merce.equals("nav"))
			PicasCena += 0.00;
		
		
		// uzkodas cena
		if (uzkoda.equals("Nageti"))
			PicasCena += 3.20;
						
		if (uzkoda.equals("Čipši"))
			PicasCena += 2.00;
						
		if (uzkoda.equals("Mini maize"))
			PicasCena += 1.00;
						
		if (uzkoda.equals("nav"))
			PicasCena += 0.00;
		
		
		// dzērieni cena
		if (dzeriens.equals("Kola -0.5L"))
			PicasCena += 1.50;
								
		if (dzeriens.equals("Sprite -0.5L"))
			PicasCena += 1.50;
								
		if (dzeriens.equals("Ūdens -0.5L"))
			PicasCena += 0.80;
								
		if (dzeriens.equals("nav"))
			PicasCena += 0.00;
		
		
		// Uz vietas cena
		if (uzVietas == true)
			PicasCena += 0.00;
				
		if (!uzVietas)
			PicasCena += 3.20;
				
			
		return PicasCena;
	}
	
	// metode kas seto ikonas
	public static ImageIcon setIkona(String cels, int izmers) {
	    ImageIcon ikona = new ImageIcon(
	        Picerija.class.getResource(cels)
	    );
	    Image img = ikona.getImage().getScaledInstance(izmers, izmers, Image.SCALE_SMOOTH);
	    return new ImageIcon(img);
	}

	public static void AtjaunoTextArea() {
		
		// Iztīra visus TextArea
		aktivsArea.setText("");
		pabeigtsArea.setText("");

	    StringBuilder aktivs = new StringBuilder();
	    StringBuilder pabeigts = new StringBuilder();

	    for (Pasutitajs p : Pasutitaji) {
	        aktivs.append(p.izvadit())
	              .append("\n====================\n");
	    }

	    for (Pasutitajs p : pabeigtiePasutijumi) {
	        pabeigts.append(p.izvadit())
	                .append("\n====================\n");
	    }

	    aktivsArea.setText(aktivs.toString());
	    pabeigtsArea.setText(pabeigts.toString());
	}




}
