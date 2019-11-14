package models;

public class DisplayLcd {

	private int size;
	private int numeros;
	private int columnas;
	private int filas;
	
	public DisplayLcd() {
	   this.size = 0;
	   this.numeros = 0;
	}

	public DisplayLcd(int size, int numeros) {
		this.size = size;
		this.numeros = numeros;
		setColumnas();
		setFilas();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNumeros() {
		return numeros;
	}

	public void setNumeros(int numeros) {
		this.numeros = numeros;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas() {
		this.columnas = size + 2;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas() {
		this.filas = (2* size) + 3;
	}
	
	
	
}
