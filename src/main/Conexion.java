package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Conexion extends Observable implements Runnable, Observer {

	private static final int PORT = 5000;
	private ServerSocket ss;
	private boolean alive = true;
	private ArrayList<Usuario> usuarios;

	public Conexion() {
		usuarios = new ArrayList<>();

		try {
			ss = new ServerSocket(PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (alive) {
			try {
				System.out.println("Esperando conexión...");
				usuarios.add(new Usuario(ss.accept(), this));
				System.out.println("Usuario #" + usuarios.size() + " conectado...");
				Thread.sleep(100);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}