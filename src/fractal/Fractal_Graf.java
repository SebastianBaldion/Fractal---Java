package fractal;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 *
 * @author Sebastian Baldion
 */
public class Fractal_Graf extends JApplet{
    
    private static final long serialVersionUID = 1L;
	
	
	private final int ca_lenght = 400; 
	private final int screen_size = 800; 
	private final int delay_time = 250; 

	public void init() 
    {
        setSize(screen_size, screen_size); 
		setBackground(Color.white); 
    }

    public void paint(Graphics g) 
    {
        
    	Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
 
        int x = 0;
        int y = 0;
        
        int square_size = screen_size / ca_lenght;
 
        
       MatrixGenerator cellular_automata = new MatrixGenerator();

        while(true)
        {
        	int[][] matrix = cellular_automata.generate(ca_lenght); 
        	y = 0;
        	
        	for(int i = 0; i < ca_lenght; i++)
        	{
        		x = 0;
        		for(int j = 0; j < ca_lenght; j++)
        		{
	    		   if(matrix[i][j] == 0)
	    		   {
	    			   g2.setPaint(Color.blue);
	    		   } else {
	    			   g2.setPaint(Color.green);
	    		   }
	    		   g2.fill(new Rectangle2D.Double(x, y, square_size, square_size));
	    		   
	    		   x += square_size;
	    		}
        		y += square_size; 
        	} try {
        		Thread.sleep( delay_time );
        	} catch 
                        (InterruptedException e) 
        	{
        		e.printStackTrace();
        	}
       }
    }

    public static void main (String args[])
    {
    	JFrame frame = new JFrame("CellularAutomata");

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });

        JApplet applet = new Fractal_Graf();
        frame.getContentPane().add("Center", applet);

        applet.init();
        frame.pack();
        frame.setSize(new Dimension(800,800));
        frame.setVisible(true);
    }
}