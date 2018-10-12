package main;

import processing.core.PApplet;

public class Logica {

	Conexion conexion;
	PApplet app;

	public Logica(PApplet app) {
		this.app = app;
		conexion = new Conexion();
		new Thread(conexion).start();
	}
}
