package main;
import processing.core.PApplet;


public class Main extends PApplet{

	Conexion conexion;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("main.Main");
	}
	
	public void settings() {
		
	}
	
	public void setup() {
		conexion = new Conexion();
		new Thread(conexion).start();
	}
	
	public void draw() {
		
	}

}
