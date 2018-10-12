package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class Usuario extends Observable implements Runnable {

	private Socket s;
	private Observer controler;
	private Ciudad myCity;

	public Usuario(Socket s, Observer controler) {
		this.s = s;
		this.controler = controler;
		myCity = null;
		new Thread(this).start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			recibir();
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void enviar(Object o) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void recibir() {
		try {
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			Object objetoRecibido = ois.readObject();

			if (objetoRecibido instanceof Ciudad) {
				myCity = (Ciudad) objetoRecibido;
			}
			controler.update(this, objetoRecibido);
			notifyObservers(controler);
			setChanged();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
