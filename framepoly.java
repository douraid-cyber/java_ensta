import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class framepoly extends JFrame{
	
	private static int mouseX =0;
	private static int mouseY =0;
	
	public framepoly()
	{
		setSize(400, 200);
		setUndecorated(true);
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
		
		
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e)
			{
				int x = e.getXOnScreen()- mouseX;
				int y = e.getYOnScreen()- mouseY;
				setLocation(x,y);
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e)
			{
				mouseX=e.getX();
				mouseY=e.getY();
			}
		});
		
		
		JButton butExit = new JButton("X");
		butExit.setBounds(300, 150, 40, 40);
		butExit.setBackground(Color.red);
		//butExit.setBackground(new Color(255, 0, 0));
		butExit.setBorderPainted(false);
		butExit.setFocusPainted(false);
		butExit.setForeground(Color.white);
		butExit.setMargin(new Insets(0,0,0,0));
		
		
		
		
		butExit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				butExit.setBackground(Color.red);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				butExit.setBackground(Color.DARK_GRAY);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		add(butExit);
		
		
		JButton newFrame = new JButton("O");
		newFrame.setBounds(70, 150, 40, 40);
		newFrame.setBackground(Color.green);
		newFrame.setBorderPainted(false);
		newFrame.setFocusPainted(false);
		newFrame.setForeground(Color.black);
		newFrame.setMargin(new Insets(0,0,0,0));
		
		newFrame.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				newFrame.setBackground(Color.green);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				newFrame.setBackground(Color.DARK_GRAY);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				/*JFrame fra = new JFrame();
				fra.setSize(300,150);
				fra.setVisible(true);*/
				
				polyv2 plv2 = new polyv2();
				plv2.setVisible(true);
				
				
				
			}
		});
		
		
		add(newFrame);
		
		

	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		//quality
		/*g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		*/
		//perf
		/*g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
		*/
		

		
		
		//int w = getWidth();
		//int h = getHeight();
		
		
		int[] xpoints = {200,350,350,200, 50, 50};
		int[] ypoints =	{ 50,150,200,200,200,150};	
		Polygon poly = new Polygon(xpoints, ypoints, ypoints.length);
		
		g2d.setColor(Color.blue);
		
		GradientPaint gradient = new GradientPaint(0, 0, Color.red, 300,150,Color.blue);
		g2d.setPaint(gradient);
		
		g2d.fill(poly);
		setShape(poly);
		
		
		
		
		
		
		

	}


}
