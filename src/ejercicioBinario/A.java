package ejercicioBinario;

import java.util.ArrayList;

public class A {
	ArrayList<Integer> b;
	ArrayList<Integer> c;
	String nombre;
	
	
	public ArrayList<Integer> getB() {
		return b;
	}

	public void setB(ArrayList<Integer> b) {
		this.b = b;
	}

	public ArrayList<Integer> getC() {
		return c;
	}

	public void setC(ArrayList<Integer> c) {
		this.c = c;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public A(ArrayList<Integer> b, ArrayList<Integer> c, String nombre) {
		this.b = b;
		this.c = c;
		this.nombre = nombre;
	}
}
