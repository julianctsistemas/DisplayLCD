package controller;

import java.util.ArrayList;
import java.util.List;

import constants.Constants;
import models.DisplayLcd;

public class DisplayLcdController {
	
	private String[][] matrizSegmentosTotal;
	int columnasTotal;
	private int[] puntoInicioIzquierdo; 
	private int[] puntoInicioDerecho; 
	private int[] puntoMedioIzquierdo; 
	private int[] puntoMedioDerecho; 
	private int[] puntoFinalIzquierdo; 
	
	private DisplayLcd display;
	
	public DisplayLcdController() {
		this.display = new DisplayLcd();
		this.puntoInicioIzquierdo = new int[2];
		this.puntoInicioDerecho = new int[2];
		this.puntoMedioIzquierdo = new int[2];
		this.puntoMedioDerecho = new int[2];
		this.puntoFinalIzquierdo = new int[2];
		
	}
	
	public DisplayLcd getDisplay() {
		return display;
	}

	public void setDisplay(DisplayLcd display) {
		this.display = display;
	}

	/**
	 * Metodo que inicializa el proceso para imprimir una
	 * entrada tipo display
	 */
	public void iniciarProceso() {
        String numerosDisplay = Integer.toString(getDisplay().getNumeros()); 
        char[] numeros;
        numeros =  numerosDisplay.toCharArray();
        columnasTotal = (getDisplay().getColumnas() * numeros.length) + numeros.length;
		matrizSegmentosTotal = new String[getDisplay().getFilas()][columnasTotal];  
		inicializarMatriz();
		inicializarPuntosSegmentos(numeros);
		imprimirResultadoMatriz();
	}
	
	private void inicializarMatriz() {
		for (int x=0; x <matrizSegmentosTotal.length; x++) {
			for (int y=0; y <matrizSegmentosTotal[x].length; y++) {
				matrizSegmentosTotal[x][y]= " ";
			}
		}
	}

	/**
	 * Metodo encargado de recorrer los numeros e inicializar
	 * los puntos de interseccion por cada segmento
	 * @param numeros numeros a imprimir en pantalla
	 */
	private void inicializarPuntosSegmentos(char[] numeros) {
        int acumuladorPosicion = 0;
        for (char numero : numeros) {
        	int numeroSegmento = Integer.parseInt(String.valueOf(numero));
        	puntoInicioIzquierdo[0] = 0;
        	puntoInicioIzquierdo[1] = acumuladorPosicion;
        	puntoMedioIzquierdo[0] = (display.getFilas() / 2);
        	puntoMedioIzquierdo[1] = acumuladorPosicion;
        	puntoFinalIzquierdo[0] = (display.getFilas() - 1);
        	puntoFinalIzquierdo[1] = acumuladorPosicion;
        	
        	puntoInicioDerecho[0] = 0;
        	puntoInicioDerecho[1] = (display.getColumnas() - 1) + acumuladorPosicion;
        	puntoMedioDerecho[0] = (display.getColumnas() - 1);
        	puntoMedioDerecho[1] = (display.getFilas() / 2) + acumuladorPosicion;
        	acumuladorPosicion = acumuladorPosicion + (display.getColumnas()+ 1);

        	formarNumeroSegmento(numeroSegmento);
        }
    }
	

	/**
	 * Metodo encargado de listar los segmentos de cada numero
	 * @param numero
	 */
	private void formarNumeroSegmento(int numero) {
        List<String> listaSegmentos = new ArrayList<>();
        switch (numero) {
            case 1:
            	listaSegmentos.add("b");
            	listaSegmentos.add("c");
                break;
            case 2:
            	listaSegmentos.add("a");
            	listaSegmentos.add("b");
            	listaSegmentos.add("g");
            	listaSegmentos.add("e");
            	listaSegmentos.add("d");
                break;
            case 3:
            	listaSegmentos.add("a");
            	listaSegmentos.add("b");
            	listaSegmentos.add("g");
            	listaSegmentos.add("c");
            	listaSegmentos.add("d");
                break;
            case 4:
            	listaSegmentos.add("f");
            	listaSegmentos.add("g");
            	listaSegmentos.add("b");
            	listaSegmentos.add("c");
                break;
            case 5:
            	listaSegmentos.add("a");
            	listaSegmentos.add("f");
            	listaSegmentos.add("g");
            	listaSegmentos.add("c");
            	listaSegmentos.add("d");
                break;
            case 6:
            	listaSegmentos.add("a");
            	listaSegmentos.add("f");
            	listaSegmentos.add("g");
            	listaSegmentos.add("e");
            	listaSegmentos.add("d");
            	listaSegmentos.add("c");
                break;
            case 7:
            	listaSegmentos.add("a");
            	listaSegmentos.add("b");
            	listaSegmentos.add("c");
                break;
            case 8:
            	listaSegmentos.add("f");
            	listaSegmentos.add("e");
            	listaSegmentos.add("b");
            	listaSegmentos.add("c");
            	listaSegmentos.add("a");
            	listaSegmentos.add("g");
            	listaSegmentos.add("d");
                break;
            case 9:
            	listaSegmentos.add("f");
            	listaSegmentos.add("b");
            	listaSegmentos.add("c");
            	listaSegmentos.add("a");
            	listaSegmentos.add("g");
            	listaSegmentos.add("d");
                break;
            case 0:
            	listaSegmentos.add("f");
            	listaSegmentos.add("b");
            	listaSegmentos.add("e");
            	listaSegmentos.add("c");
            	listaSegmentos.add("a");
            	listaSegmentos.add("d");
                break;
            default:
                break;
        }
        
        recorrerSegmentos(listaSegmentos);
    }
	
	/**
	 * Metodo encargado de recorrer los segmentos de cada numero 
	 * para dibujarlos en la matriz
	 * @param listaSegmentos
	 */
	private void recorrerSegmentos(List<String> listaSegmentos) {
       for (String segmento : listaSegmentos) {
        	dibujarSegmento(segmento);
        }
   	}
	
	private void imprimirResultadoMatriz() {
        for (int i = 0; i < getDisplay().getFilas(); i++) {
            for (int j = 0; j < columnasTotal; j++) {
                System.out.print(matrizSegmentosTotal[i][j]);
            }
            System.out.println();
        }
	}
	
	/**
	 * Metodo encargado de dibujar las lineas de acuerdo al segmento enviado
	 * verticales o horizontales
	 * @param segmento
	 */
	private void dibujarSegmento(String segmento) {
        switch (segmento) {
        case "f": 
        	dibujarLineaVertical(puntoInicioIzquierdo);
        break;
        case "e": 
        	dibujarLineaVertical(puntoMedioIzquierdo);
            break;
        case "b": 
        	dibujarLineaVertical(puntoInicioDerecho);

            break;
        case "c": 
        	dibujarLineaVertical(puntoMedioDerecho);

            break;
        case "a": 
        	dibujarLineaHorizontal(puntoInicioIzquierdo);

            break;
        case "g": 
        	dibujarLineaHorizontal(puntoMedioIzquierdo);

            break;
        case "d": 
        	dibujarLineaHorizontal(puntoFinalIzquierdo);

            break;
        default:
        break;
        }
	}
	
	private void dibujarLineaHorizontal(int[] punto) {
		for (int x = 0; x < getDisplay().getSize(); x++) {
            int columna = punto[1] + (x+1);
           matrizSegmentosTotal[punto[0]][columna] = Constants.HORIZONTAL;
        }
	}
	
	private void dibujarLineaVertical(int[] punto) {
	    for (int y = 0; y < getDisplay().getSize(); y++) {
            int fila = punto[0] + (y+1);
            matrizSegmentosTotal[fila][punto[1]] = Constants.VERTICAL;
        }
	}
	

}
