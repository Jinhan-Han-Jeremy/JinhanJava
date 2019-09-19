
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class CalcInt extends JApplet
{
	 JTextField getRate = new JTextField(5);
	 JTextField getBalance = new JTextField(8);
	 JTextField getYears = new JTextField(3);
	 JLabel rate = new JLabel("Rate");
	 JLabel balance = new JLabel("Balance");
	 JLabel years = new JLabel("Years");
	 
	 MyCanvas canvas	= new MyCanvas(); 
	 JPanel p1 = new JPanel();
	 JPanel p2 = new JPanel();
	 JPanel p3 = new JPanel();
	 JPanel p4 = new JPanel();
	 JPanel p = new JPanel();
	 
	 JButton amount	= new JButton("Amount");
	 JButton clear	= new JButton("Clear");
	 String command = " ";
	 String prompt	= "Enter Data and Press Button ";
	 NumberFormat nf;
  
  public void init()
  {
	  Container pane = getContentPane();
	  pane.setLayout(new GridLayout(3,1));
  	  p1.setLayout(new GridLayout(2,1));
	  p1.add(rate);
	  p1.add(getRate);
	  p2.setLayout(new GridLayout(2,1));
	  p2.add(balance);
	  p2.add(getBalance);
	  p3.setLayout(new GridLayout(2,1));
	  p3.add(years);
	  p3.add(getYears);
	  p.setLayout(new FlowLayout());
	  p.add(p1);
 	  p.add(p2);
	  p.add(p3);
	  amount.setMnemonic('A');
	  amount.setToolTipText("Calculate Amount");
	  p4.setLayout(new GridLayout(1,2));
	  p4.add(amount);
	  p4.add(clear);
	  
 	  amount.addActionListener(canvas);
 	  clear.addActionListener(canvas);

 	  pane.add(p);
	  pane.add(canvas);
	  pane.add(p4);
	  
	  canvas.setPreferredSize(new Dimension(100,100));
	  
	  nf = NumberFormat.getCurrencyInstance();  
  }
	
	
	class MyCanvas extends JComponent implements ActionListener
	{
	
		public void actionPerformed(ActionEvent event)
		{
		 	command = event.getActionCommand();
		 	if (command.equals("Amount"))
		  		prompt = "The amount is " + computeGrowth();
			 else
			 {
			 	getRate.setText("");
			 	getBalance.setText("");
			 	getYears.setText("");
		 		prompt	= "Enter Data and Press Button ";
			 }	
		 	repaint();
		 }
	 
		public String computeGrowth()
		{
		 double rate = new Double(getRate.getText()).doubleValue();
		 double balance = new Double(getBalance.getText()).doubleValue();
		 int years = new Integer(getYears.getText()).intValue();
		 for (int i = 1; i <= years; i++)
			balance += balance * rate/100;
		 return nf.format(balance);
		}

	 	public void paintComponent(Graphics g)
 	 	{
    		Font f = new Font("Serif",Font.BOLD,14);
			setFont(f);
			g.drawString(prompt,20,50);
 	 	}
    }
}