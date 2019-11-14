package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.DisplayLcdController;
import models.DisplayLcd;
import utils.Utils;

public class Main {

	public static void main(String[] args) {

		String entrada;
        List<DisplayLcd> listaDisplayLcd = new ArrayList<>();
		do {

			entrada = JOptionPane.showInputDialog("Ingrese un numero." + "\nPara finalizar digite 0,0");

			System.out.println("entrada : " + entrada);

			if (entrada.contains(",")) {
				String[] partes = entrada.split(",");				
				if (partes.length != 2) {
					throw new IllegalArgumentException("La entrada solo permite separar una vez por coma");
				}

				if (!Utils.isStringInt(partes[0])) {
					throw new IllegalArgumentException("El tamaño " + partes[0] + " no es un número");
				}

				if (!Utils.isStringInt(partes[1])) {
					throw new IllegalArgumentException("La entrada " + partes[1] + " no es un número");
				}
				
				int size = Integer.parseInt(partes[0]);	
				int numeros = Integer.parseInt(partes[1]);
				if (size == 0 && numeros != 0) {
					throw new IllegalArgumentException("El tamanio " + size + " debe estar dentro del rango del 1 al 10.");
				}
				if (size != 0) {
					if (size < 1 || size > 10) {
						throw new IllegalArgumentException("El tamanio " + size + " debe estar dentro del rango del 1 al 10.");
					}	
					
					
					DisplayLcd lcd = new DisplayLcd(size,numeros);
					listaDisplayLcd.add(lcd);
				}

			} else {
				throw new IllegalArgumentException("La entrada " + entrada + " no contiene (,)");
			}

		} while (!entrada.equals("0,0"));
		
		DisplayLcdController controller = new DisplayLcdController();
		
		for(DisplayLcd displayLcd : listaDisplayLcd) {
			controller.setDisplay(displayLcd);
			controller.iniciarProceso();
			System.out.println();
		}

	}

}
