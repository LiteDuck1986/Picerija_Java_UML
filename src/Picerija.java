import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Picerija extends JFrame implements ActionListener{
	
	static String ievade;
	
	// Frame
	static JFrame frame;
	static CardLayout cardLayout;
	static JPanel galvenaisPanel;
	
	// JTextField
    static JTextField t;
    
 // label to display text
    static JLabel l;
    
 // default constructor
    Picerija()
    {
    }
	
	

	public static void main(String[] args) {

		frame = new JFrame("Picerija");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // ============= CardLayout ==============
        cardLayout = new CardLayout();
        galvenaisPanel = new JPanel(cardLayout);
        

        // ============= Paneļi ==============
        JPanel sakumsPanel = new JPanel(null);
        sakumsPanel.setBackground(Color.white);

        JPanel picasIzveidePanel = new JPanel(null);
        picasIzveidePanel.setBackground(Color.black);
        

        // ============= PANEĻU SAVIENOJUMS ==============
        galvenaisPanel.add(sakumsPanel, "sakums");
        galvenaisPanel.add(picasIzveidePanel, "pica");
        
     // create a label to display text
        l = new JLabel("nothing entered");
        l.setBounds(300, 260, 160, 20);
        
        // Pogas izveide (SADAĻAS)
        JButton PicasPoga = new JButton("Pica");
        PicasPoga.setBounds(10, 225, 160, 50);
        PicasPoga.setBackground(Color.BLACK);
        PicasPoga.setForeground(Color.WHITE);
        PicasPoga.setBorderPainted(true);
        PicasPoga.setFocusPainted(false);
        sakumsPanel.add(PicasPoga);
        
        JButton B = new JButton("Update");
        B.setBounds(300, 400, 160, 20);
        
        Picerija text = new Picerija();
        
        B.addActionListener(text);
        
        t = new JTextField("enter the text", 16);
        t.setBounds(300, 225, 160, 20);
        
        sakumsPanel.add(t);
        sakumsPanel.add(B);
        sakumsPanel.add(l);
        
        frame.add(galvenaisPanel);
        frame.setVisible(true);
        
        
        
        
//        PicasPoga.addActionListener(e -> {
//        	nokertBilde.setVisible(false);
//        	NokertPoga.setVisible(true);
//        	nokerts.setVisible(false);
//        	OkPoga.setVisible(false);
//        	mysteryPokemons.setVisible(true);
//        	
//        });
        
	}
        public void actionPerformed(ActionEvent e)
        {
            String s = e.getActionCommand();
            if (s.equals("Update")) {
                // set the text of the label to the text of the field
                l.setText(t.getText());

                // set the text of field to blank
                t.setText(t.getText());
            }

	}

}
