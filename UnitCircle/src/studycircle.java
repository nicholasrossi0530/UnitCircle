
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class studycircle extends JPanel implements MouseListener{
	
	ImageIcon pi2;
	ImageIcon pi6;
	ImageIcon pi4;
	ImageIcon pi3;
	ImageIcon piover2;
	ImageIcon pi23;
	ImageIcon pi34;
	ImageIcon pi56;
	ImageIcon pi;
	ImageIcon pi76;
	ImageIcon pi54;
	ImageIcon pi43;
	ImageIcon pi32;
	ImageIcon pi53;
	ImageIcon pi74;
	ImageIcon pi116;	
	static studydots [] points;

	//http://coolmath.com/precalculus-review-calculus-intro/precalculus-trigonometry/28-the-unit-circle-01.htm
	//Used for the ImageIcons.
	public studycircle() {
		pi2= new ImageIcon("pi2.png");
		pi6= new ImageIcon("pi6.png");
		pi4= new ImageIcon("pi4.png");
		pi3= new ImageIcon("pi3.png");
		piover2= new ImageIcon("piover2.png");
		pi23= new ImageIcon("pi23.png");
		pi34= new ImageIcon("pi34.png");
		pi56= new ImageIcon("pi56.png");
		pi= new ImageIcon("pi.png");
		pi76= new ImageIcon("pi76.png");
		pi54= new ImageIcon("pi54.png");
		pi43= new ImageIcon("pi43.png");
		pi32= new ImageIcon("pi32.png");
		pi53= new ImageIcon("pi53.png");
		pi74= new ImageIcon("pi74.png");
		pi116= new ImageIcon("pi116.png");
	}

	public static void main(String [] args){
		studyCircle("dots.txt");
		JFrame jf= new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("Unit Circle Study Utility");
		jf.setVisible(true);
		
		studycircle unitCircle=new studycircle();
		jf.addMouseListener(unitCircle);
		jf.setPreferredSize(new Dimension(900,900));
		jf.add(unitCircle);
		jf.pack();
		//http://stackoverflow.com/questions/6454887/align-text-to-the-right-in-joptionpane
			//Used StackOverflow for html tags to center text in JOptinoPane.
		String message= "<html><body><div width='370px' align='center'>Please click on a black dot to test your knowledge of the Unit Circle.</div></body></html>\n"
				+"<html><body><div width='370px' align='center'>You will be given options containing possible coordinates for the angle you click on.</div></body></html>\n"
				+"<html><body><div width='370px' align='center'>Good luck and thanks for playing!</div></body></html>";
		JLabel messageLabel= new JLabel(message);
		JOptionPane.showMessageDialog(null, message, "Directions", JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void studyCircle(String s){
		try {
			Scanner fileScanner= new Scanner(new File(s));
			int spots = fileScanner.nextInt();
			points=new studydots[spots];
			String[] items= new String[spots];
			fileScanner.nextLine();
			for(int i=0; i< spots; i++){
				String data= fileScanner.nextLine();
				points[i]= new studydots(data);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics gus){
		Color back= new Color(128, 128, 128);
		gus.setColor(back);
		gus.fillRect(0, 0, 900, 900);
		
		gus.setColor(Color.BLUE);
		gus.drawOval(150, 150, 600, 600);
		
		gus.setColor(Color.BLACK);
		gus.drawLine(450, 0, 450, 900);
		gus.drawLine(0, 450, 900, 450);
		
		gus.setColor(Color.GREEN);
		gus.drawLine(160, 160, 740, 740);
		gus.drawLine(160, 740, 740, 160);
		
		Color pisix= new Color(255, 128, 0);
		gus.setColor(pisix);
		gus.drawLine(95, 655, 805, 245);
		gus.drawLine(95, 245, 805, 655);
		
		Color pithird= new Color(255, 0, 255);
		gus.setColor(pithird);
		gus.drawLine(245, 95, 655, 805);
		gus.drawLine(245, 805, 655, 95);
		
		for(int i=0; i<points.length; i++){
			gus.setColor(Color.BLACK);
			gus.fillOval(points[i].getX(), points[i].getY(), points[i].getHeight(), points[i].getWidth());
		}
	}
	
	//https://docs.oracle.com/javase/tutorial/uiswing/events/mousemotionlistener.html
		//Used Oracle for the Mouse Listener methods.
	public void mouseClicked(MouseEvent e){
		int x=e.getX();
		int y=e.getY();
		for(int i=0; i<points.length; i++){
			String q=("What are the coordinates for this angle:");
			int []xx={points[i].getX()+10, points[i].getX()+20};
			int []yy={points[i].getY()+30, points[i].getY()+40};
			
			//https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
				//Used Oracle for JOptionPane code.
			//http://stackoverflow.com/questions/15255170/how-to-display-pi-symbol-in-java
				//Used StackOverflow to find code to display a pi symbol.
			//http://stackoverflow.com/questions/15672161/print-a-square-root-symbol-%E2%88%9A-in-java
				//Used StackOverflow to find code to display a sqrt symbol.
			
			if(i==0&&(x>=xx[0]&&x<=xx[1])&&(y>=yy[0]&&y<=yy[1])){
				Object[] options={"(0, 1)", "(1/2, 0)", "(0, 1/2)", "(1, 0)"};
				String s= (String)JOptionPane.showInputDialog(null, q+" 0(or 2\u03c0) ?", "Question", JOptionPane.QUESTION_MESSAGE, pi2, options, options[0]);
				if((s!=null)&&(s.equals("(1, 0)"))){
					JOptionPane.showMessageDialog(null, "You are correct!");
				}
				if((s!=null)&&(s!=("(1, 0)"))){
					JOptionPane.showMessageDialog(null, "Sorry you are incorrect.\n"+"Please try again.");
				}
			}
			
			if(i==1&&(x>=xx[0]&&x<=xx[1])&&(y>=yy[0]&&y<=yy[1])){
				Object[] options={"(\u221A3/2, 1/2)", "(1/2, \u221A3/2)", "(\u221A2/2, \u221A2/2)", "\u221A2/2, 1/2"};
				String s= (String)JOptionPane.showInputDialog(null, q+" \u03c0/6 ?", "Question", JOptionPane.QUESTION_MESSAGE, pi6, options, options[0]);
				if((s!=null)&&(s.equals("(\u221A3/2, 1/2)"))){
					JOptionPane.showMessageDialog(null, "You are correct!");
				}
				if((s!=null)&&(s!=("(\u221A3/2, 1/2)"))){
					
					JOptionPane.showMessageDialog(null, "Sorry you are incorrect.\n"+"Please try again.");
				}
			}
			
			if(i==2&&(x>=xx[0]&&x<=xx[1])&&(y>=yy[0]&&y<=yy[1])){
				Object[] options={"(\u221A3/2, 1/2)", "(1/2, \u221A3/2)", "(\u221A2/2, \u221A2/2)", "(\u221A2/2, \u221A3/2"};
				String s= (String)JOptionPane.showInputDialog(null, q+" \u03c0/4 ?", "Question", JOptionPane.QUESTION_MESSAGE, pi4, options, options[0]);
				if((s!=null)&&(s.equals("(\u221A2/2, \u221A2/2)"))){
					JOptionPane.showMessageDialog(null, "You are correct!");
				}
				if((s!=null)&&(s!=("(\u221A2/2, \u221A2/2)"))){
					
					JOptionPane.showMessageDialog(null, "Sorry you are incorrect.\n"+"Please try again.");
				}
			}
			
			if(i==3&&(x>=xx[0]&&x<=xx[1])&&(y>=yy[0]&&y<=yy[1])){
				Object[] options={"(\u221A3/2, 1/2)", "(1/2, \u221A3/2)", "(\u221A2/2, \u221A2/2)", "(\u221A3/2, 1"};
				String s= (String)JOptionPane.showInputDialog(null, q+" \u03c0/3 ?", "Question", JOptionPane.QUESTION_MESSAGE, pi3, options, options[0]);
				if((s!=null)&&(s.equals("(1/2, \u221A3/2)"))){
					JOptionPane.showMessageDialog(null, "You are correct!");
				}
				if((s!=null)&&(s!=("(1/2, \u221A3/2)"))){
					
					JOptionPane.showMessageDialog(null, "Sorry you are incorrect.\n"+"Please try again.");
				}
			}
			
			if(i==4&&(x>=xx[0]&&x<=xx[1])&&(y>=yy[0]&&y<=yy[1])){
				Object[] options={"(1, 0)", "(1/2, 0)", "(0, 1/2)", "(0, 1)"};
				String s= (String)JOptionPane.showInputDialog(null, q+" \u03c0/2 ?", "Question", JOptionPane.QUESTION_MESSAGE, piover2, options, options[0]);
				if((s!=null)&&(s.equals("(0, 1)"))){
					JOptionPane.showMessageDialog(null, "You are correct!");
				}
				if((s!=null)&&(s!=("(0, 1)"))){
					
					JOptionPane.showMessageDialog(null, "Sorry you are incorrect.\n"+"Please try again.");
				}
			}
			
			if(i==5&&(x>=xx[0]&&x<=xx[1])&&(y>=yy[0]&&y<=yy[1])){
				Object[] options={"(-\u221A3/2, 1/2)", "(-1/2, \u221A3/2)", "(-\u221A2/2, \u221A2/2)", "(-1, \u221A3/2)"};
				String s= (String)JOptionPane.showInputDialog(null, q+" 2\u03c0/3 ?", "Question", JOptionPane.QUESTION_MESSAGE, pi23, options, options[0]);
				if((s!=null)&&(s.equals("(-1/2, \u221A3/2)"))){
					JOptionPane.showMessageDialog(null, "You are correct!");
				}
				if((s!=null)&&(s!=("(-1/2, \u221A3/2)"))){
					JOptionPane.showMessageDialog(null, "Sorry you are incorrect.\n"+"Please try again.");
				}
			}
			
			if(i==6&&(x>=xx[0]&&x<=xx[1])&&(y>=yy[0]&&y<=yy[1])){
				Object[] options={"(-\u221A3/2, 1/2)", "(-1/2, \u221A3/2)", "(-\u221A2/2, 1)", "(-\u221A2/2, \u221A2/2)"};
				String s= (String)JOptionPane.showInputDialog(null, q+" 3\u03c0/4 ?", "Question", JOptionPane.QUESTION_MESSAGE, pi34, options, options[0]);
				if((s!=null)&&(s.equals("(-\u221A2/2, \u221A2/2)"))){
					JOptionPane.showMessageDialog(null, "You are correct!");
				}
				if((s!=null)&&(s!=("(-\u221A2/2, \u221A2/2)"))){
					
					JOptionPane.showMessageDialog(null, "Sorry you are incorrect.\n"+"Please try again.");
				}
			}
			
			if(i==7&&(x>=xx[0]&&x<=xx[1])&&(y>=yy[0]&&y<=yy[1])){
				Object[] options={"(-1/2, \u221A3/2)", "(-1/2, 1)", "(-\u221A3/2, 1/2)", "(-\u221A2/2, \u221A2/2)"};
				String s= (String)JOptionPane.showInputDialog(null, q+" 5\u03c0/6 ?", "Question", JOptionPane.QUESTION_MESSAGE, pi56, options, options[0]);
				if((s!=null)&&(s.equals("(-\u221A3/2, 1/2)"))){
					JOptionPane.showMessageDialog(null, "You are correct!");
				}
				if((s!=null)&&(s!=("(-\u221A3/2, 1/2)"))){
					JOptionPane.showMessageDialog(null, "Sorry you are incorrect.\n"+"Please try again.");
				}
			}
			
			if(i==8&&(x>=xx[0]&&x<=xx[1])&&(y>=yy[0]&&y<=yy[1])){
				Object[] options={"(0, -1)", "(-1, 0)", "(-1/2, 0)", "(0, -1/2)"};
				String s= (String)JOptionPane.showInputDialog(null, q+" \u03c0 ?", "Question", JOptionPane.QUESTION_MESSAGE, pi, options, options[0]);
				if((s!=null)&&(s.equals("(-1, 0)"))){
					JOptionPane.showMessageDialog(null, "You are correct!");
				}
				if((s!=null)&&(s!=("(-1, 0)"))){
					JOptionPane.showMessageDialog(null, "Sorry you are incorrect.\n"+"Please try again.");
				}
			}
			
			if(i==9&&(x>=xx[0]&&x<=xx[1])&&(y>=yy[0]&&y<=yy[1])){
				Object[] options={"(-1/2, -\u221A3/2)", "(-1/2, -\u221A2/2)", "(-\u221A3/2, -1/2)", "(-\u221A2/2, -\u221A2/2)"};
				String s= (String)JOptionPane.showInputDialog(null, q+" 7\u03c0/6 ?", "Question", JOptionPane.QUESTION_MESSAGE, pi76, options, options[0]);
				if((s!=null)&&(s.equals("(-\u221A3/2, -1/2)"))){
					JOptionPane.showMessageDialog(null, "You are correct!");
				}
				if((s!=null)&&(s!=("(-\u221A3/2, -1/2)"))){
					JOptionPane.showMessageDialog(null, "Sorry you are incorrect.\n"+"Please try again.");
				}
			}
			
			if(i==10&&(x>=xx[0]&&x<=xx[1])&&(y>=yy[0]&&y<=yy[1])){
				Object[] options={"(-\u221A2/2, -\u221A3/2)", "(-\u221A3/2, -1/2)", "(-1/2, -\u221A3/2)", "(-\u221A2/2, -\u221A2/2)"};
				String s= (String)JOptionPane.showInputDialog(null, q+" 5\u03c0/4 ?", "Question", JOptionPane.QUESTION_MESSAGE, pi54, options, options[0]);
				if((s!=null)&&(s.equals("(-\u221A2/2, -\u221A2/2)"))){
					JOptionPane.showMessageDialog(null, "You are correct!");
				}
				if((s!=null)&&(s!=("(-\u221A2/2, -\u221A2/2)"))){
					JOptionPane.showMessageDialog(null, "Sorry you are incorrect.\n"+"Please try again.");
				}
			}
			
			if(i==11&&(x>=xx[0]&&x<=xx[1])&&(y>=yy[0]&&y<=yy[1])){
				Object[] options={"(-\u221A3/2, -1/2)", "(-1/2, -\u221A3/2)", "(-\u221A3/2, -1)", "(-\u221A2/2, -\u221A2/2)"};
				String s= (String)JOptionPane.showInputDialog(null, q+" 4\u03c0/3 ?", "Question", JOptionPane.QUESTION_MESSAGE, pi43, options, options[0]);
				if((s!=null)&&(s.equals("(-1/2, -\u221A3/2)"))){
					JOptionPane.showMessageDialog(null, "You are correct!");
				}
				if((s!=null)&&(s!=("(-1/2, -\u221A3/2)"))){
					JOptionPane.showMessageDialog(null, "Sorry you are incorrect.\n"+"Please try again.");
				}
			}
			
			if(i==12&&(x>=xx[0]&&x<=xx[1])&&(y>=yy[0]&&y<=yy[1])){
				Object[] options={"(0, -1)", "(-1, 0)", "(-1/2, 0)", "(0, -1/2)"};
				String s= (String)JOptionPane.showInputDialog(null, q+" 3\u03c0/2 ?", "Question", JOptionPane.QUESTION_MESSAGE, pi32, options, options[0]);
				if((s!=null)&&(s.equals("(0, -1)"))){
					JOptionPane.showMessageDialog(null, "You are correct!");
				}
				if((s!=null)&&(s!=("(0, -1)"))){
					JOptionPane.showMessageDialog(null, "Sorry you are incorrect.\n"+"Please try again.");
				}
			}
			
			if(i==13&&(x>=xx[0]&&x<=xx[1])&&(y>=yy[0]&&y<=yy[1])){
				Object[] options={"(\u221A2/2, -\u221A3/2)", "(\u221A3/2, -1/2)", "(1/2, -\u221A3/2)", "(\u221A2/2, -\u221A2/2)"};
				String s= (String)JOptionPane.showInputDialog(null, q+" 5\u03c0/3 ?", "Question", JOptionPane.QUESTION_MESSAGE, pi53, options, options[0]);
				if((s!=null)&&(s.equals("(1/2, -\u221A3/2)"))){
					JOptionPane.showMessageDialog(null, "You are correct!");
				}
				if((s!=null)&&(s!=("(1/2, -\u221A3/2)"))){
					JOptionPane.showMessageDialog(null, "Sorry you are incorrect.\n"+"Please try again.");
				}
			}
			
			if(i==14&&(x>=xx[0]&&x<=xx[1])&&(y>=yy[0]&&y<=yy[1])){
				Object[] options={"(\u221A3/2, -1/2)", "(1/2, -\u221A2/2)", "(1/2, -\u221A3/2)", "(\u221A2/2, -\u221A2/2)"};
				String s= (String)JOptionPane.showInputDialog(null, q+" 7\u03c0/4 ?", "Question", JOptionPane.QUESTION_MESSAGE, pi74, options, options[0]);
				if((s!=null)&&(s.equals("(\u221A2/2, -\u221A2/2)"))){
					JOptionPane.showMessageDialog(null, "You are correct!");
				}
				if((s!=null)&&(s!=("(\u221A2/2, -\u221A2/2)"))){
					JOptionPane.showMessageDialog(null, "Sorry you are incorrect.\n"+"Please try again.");
				}
			}
			
			if(i==15&&(x>=xx[0]&&x<=xx[1])&&(y>=yy[0]&&y<=yy[1])){
				Object[] options={"(1, -\u221A3/2)", "(\u221A3/2, -1/2)", "(1/2, -\u221A3/2)", "(\u221A2/2, -\u221A2/2)"};
				String s= (String)JOptionPane.showInputDialog(null, q+" 11\u03c0/6 ?", "Question", JOptionPane.QUESTION_MESSAGE, pi116, options, options[0]);
				if((s!=null)&&(s.equals("(\u221A3/2, -1/2)"))){
					JOptionPane.showMessageDialog(null, "You are correct!");
				}
				if((s!=null)&&(s!=("(\u221A3/2, -1/2)"))){
					JOptionPane.showMessageDialog(null, "Sorry you are incorrect.\n"+"Please try again.");
				}
			}
		}
	}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mousePressed(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) {}
	
}