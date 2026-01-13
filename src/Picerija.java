import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Picerija {
	
	static String ievade;
	
	public static Pasutitajs pasutitajs = null;
	
	// Frame
	static JFrame frame;
	static CardLayout cardLayout;
	static JPanel galvenaisPanel;
	
	// JTextField
    static JTextField t, PVards, talrunis, adrese;
    
    // JCheckBox
    static JCheckBox S, M, XL, senes, ananas, pepperoni, merce, UzVietas;
    
    // labels
    static JLabel izmersLabel, piedevasLabel;
    
    
    
    // picas static mainīgie ko izmantoja priekš pasūtijuma izveides
    static int PicasIzmers = 10;
    static String PicasPiedevas = "";
    
    // Krāsas izveide priekš programmas fona
    public final static Color sarkansTums = new Color(160, 5, 0);
	
	

	public static void main(String[] args) {

		frame = new JFrame("Picerijas pasūtijuma programma");
        frame.setSize(800, 600);
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
        

        // ============= PANEĻU SAVIENOJUMS ==============
        galvenaisPanel.add(sakumsPanel, "sākums");
        galvenaisPanel.add(PasutijumaIzveidePanel, "pica");
        galvenaisPanel.add(RedigetPanel, "rediģēt");
        
     
        
        // Pogas izveide (SADAĻAS)
        JButton SakumaPoga = new JButton("Sākums");
        SakumaPoga.setBounds(10, 75, 160, 50);
        SakumaPoga.setBackground(Color.RED);
        SakumaPoga.setForeground(Color.WHITE);
        SakumaPoga.setBorderPainted(true);
        SakumaPoga.setFocusPainted(false);
        sakumsPanel.add(SakumaPoga);
        
        JButton PasutijumaPoga = new JButton("Pievienot pasūtijumu");
        PasutijumaPoga.setBounds(10, 150, 160, 50);
        PasutijumaPoga.setBackground(Color.RED);
        PasutijumaPoga.setForeground(Color.WHITE);
        PasutijumaPoga.setBorderPainted(true);
        PasutijumaPoga.setFocusPainted(false);
        sakumsPanel.add(PasutijumaPoga);
        
        
        JButton RedigetPasutijumuPoga = new JButton("Rediģēt pasūtijumus");
        RedigetPasutijumuPoga.setBounds(10, 225, 160, 50);
        RedigetPasutijumuPoga.setBackground(Color.RED);
        RedigetPasutijumuPoga.setForeground(Color.WHITE);
        RedigetPasutijumuPoga.setBorderPainted(true);
        RedigetPasutijumuPoga.setFocusPainted(false);
        sakumsPanel.add(RedigetPasutijumuPoga);
        
        
        JButton PievienotPasutijumu = new JButton("Pievienot");
        PievienotPasutijumu.setBounds(300, 400, 160, 20);
        
        // JTextFieldsss
        t = new JTextField("67", 16);
        t.setBounds(300, 350, 160, 20);
        
        PVards = new JTextField("Jānis", 16);
        PVards.setBounds(300, 325, 160, 20);
        
        // JCheckBox (Picas izmērs)
        S = new JCheckBox("10");
        S.setBounds(250, 275, 40, 20);
        S.setForeground(Color.WHITE);
        S.setOpaque(false);
        
        M = new JCheckBox("15");
        M.setBounds(300, 275, 40, 20);
        M.setForeground(Color.WHITE);
        M.setOpaque(false);
        
        XL = new JCheckBox("20");
        XL.setBounds(350, 275, 40, 20);
        XL.setForeground(Color.WHITE);
        XL.setOpaque(false);
        
        // Labels
        izmersLabel = new JLabel("Picas izmērs:");
        izmersLabel.setBounds(250, 250, 160, 20);
        izmersLabel.setForeground(Color.WHITE);
        
        
        // Picas piedevas
        senes = new JCheckBox("Sēnes");
        senes.setBounds(250, 150, 65, 20);
        senes.setForeground(Color.WHITE);
        senes.setOpaque(false);
        
        pepperoni = new JCheckBox("Pepperoni");
        pepperoni.setBounds(315, 150, 90, 20);
        pepperoni.setForeground(Color.WHITE);
        pepperoni.setOpaque(false);
        
        ananas = new JCheckBox("Ananāss");
        ananas.setBounds(410, 150, 80, 20);
        ananas.setForeground(Color.WHITE);
        ananas.setOpaque(false);
        
        // labels
        piedevasLabel = new JLabel("Picas piedevas:");
        piedevasLabel.setBounds(250, 125, 160, 20);
        piedevasLabel.setForeground(Color.WHITE);
        
        
        PasutijumaIzveidePanel.add(t);
        PasutijumaIzveidePanel.add(PievienotPasutijumu);
        PasutijumaIzveidePanel.add(izmersLabel);
        PasutijumaIzveidePanel.add(piedevasLabel);
        PasutijumaIzveidePanel.add(S);
        PasutijumaIzveidePanel.add(M);
        PasutijumaIzveidePanel.add(XL);
        PasutijumaIzveidePanel.add(senes);
        PasutijumaIzveidePanel.add(pepperoni);
        PasutijumaIzveidePanel.add(ananas);
        
        frame.add(galvenaisPanel);
        frame.setVisible(true);
        
        
        
        
        ArrayList<Pasutitajs> Pasutitaji = new ArrayList<>();
        
        
        
        
        // ActionListeners  =================================================================================================
        PievienotPasutijumu.addActionListener(e -> {

        	int izmers = PicasIzmers;
        	
        	String piedeva = PicasPiedevas;
        	
        	Pasutitajs pasutijums = new Pasutitajs(izmers, 1, 1.00, true, "yes", "yes", "yes", piedeva, "yes");
        	Pasutitaji.add(pasutijums);
        	
            izmersLabel.setText(t.getText());

            t.setText(t.getText());
        	
        });
        
        SakumaPoga.addActionListener(e -> {
        	sakumsPanel.add(PasutijumaPoga);
        	sakumsPanel.add(RedigetPasutijumuPoga);
        	sakumsPanel.add(SakumaPoga);
        	cardLayout.show(galvenaisPanel, "sākums");
        });
        
        PasutijumaPoga.addActionListener(e -> {
        	PasutijumaIzveidePanel.add(PasutijumaPoga);
        	PasutijumaIzveidePanel.add(RedigetPasutijumuPoga);
        	PasutijumaIzveidePanel.add(SakumaPoga);
        	cardLayout.show(galvenaisPanel, "pica");
        });
        
        RedigetPasutijumuPoga.addActionListener(e -> {
        	RedigetPanel.add(RedigetPasutijumuPoga);
        	RedigetPanel.add(PasutijumaPoga);
        	RedigetPanel.add(SakumaPoga);
        	cardLayout.show(galvenaisPanel, "rediģēt");
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

            // Ja lietotājs visu ir uncheckojis tad Picas piedevums būs...
            if (!senes.isSelected() && !pepperoni.isSelected() && !ananas.isSelected()) {
            	PicasPiedevas = "Pepperoni";
            }
            
            
            // Debug prints
            System.out.println("Picas izmērs: " + PicasIzmers);
            System.out.println("Picas piedeva: " + PicasPiedevas);
        };

        S.addActionListener(klausitajs);
        M.addActionListener(klausitajs);
        XL.addActionListener(klausitajs);
        
        senes.addActionListener(klausitajs);
        pepperoni.addActionListener(klausitajs);
        ananas.addActionListener(klausitajs);
        
	}

	

}
