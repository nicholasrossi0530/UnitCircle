import java.io.File;
import java.util.Scanner;


public class studydots {
	
	String data;
	int x;
	int y;
	int height;
	int width;
	
	public studydots(){
		super();
	}
	
	public studydots (String data){
		String [] strings= data.split(",");
		this.x=Integer.parseInt(strings[0].trim());
		this.y=Integer.parseInt(strings[1].trim());
		this.height=Integer.parseInt(strings[2].trim());
		this.width=Integer.parseInt(strings[3].trim());
	}
	
	public studydots(int x, int y, int height, int width){
		super();
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
	}
	
	public int[] getDots(String data){
		int[] points=new int[] {x, y, height, width};
		return points;
	}
	
	public int getX(){
		return x;
	}
	
	public void setX(int x){
		this.x=x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int y){
		this.y=y;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setHeight(int height){
		this.height=height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public void setWidth(int width){
		this.width=width;
	}
	
	public String toString() {
		return x+", "+y+", "+height+", "+width;
	}
	
}
