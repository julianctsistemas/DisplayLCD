package models;

public class DisplayLcd {

	private int size;
	private int numero;
	private int columnas;
	private int filas;
	
	public DisplayLcd(int size, int numero) {
		this.size = size;
		this.numero = numero;
		setColumnas();
		setFilas();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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
