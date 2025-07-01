package main.java.uy.edu.ucu.aed;

import java.util.Random;

public class TClasificador {
	public static final int METODO_CLASIFICACION_INSERCION = 1;
	public static final int METODO_CLASIFICACION_SHELL = 2;
	public static final int METODO_CLASIFICACION_BURBUJA = 3;
	public static final int METODO_CLASIFICACION_QUICKSORT = 4;

	/**
	 * Punto de entrada al clasificador
	 * 
	 * @param metodoClasificacion
	 * @param orden
	 * @param tamanioVector
	 * @return Un vector del tam. solicitado, ordenado por el algoritmo solicitado
	 */
	public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
		switch (metodoClasificacion) {
			case METODO_CLASIFICACION_INSERCION:
				return ordenarPorInsercion(datosParaClasificar);
			case METODO_CLASIFICACION_SHELL:
				return ordenarPorShell(datosParaClasificar);
			case METODO_CLASIFICACION_BURBUJA:
				return ordenarPorBurbuja(datosParaClasificar);
			case METODO_CLASIFICACION_QUICKSORT:
				return ordenarPorQuickSort(datosParaClasificar);
			default:
				System.err.println("Este codigo no deberia haberse ejecutado");
				break;
		}
		return datosParaClasificar;
	}

	private void intercambiar(int[] vector, int pos1, int pos2) {
		int temp = vector[pos2];
		vector[pos2] = vector[pos1];
		vector[pos1] = temp;
	}

	/**
	 * @param datosParaClasificar
	 * @return
	 */
	private int[] ordenarPorShell(int[] datosParaClasificar) {
		int j, inc;
		int[] incrementos = new int[] { 3223, 358, 51, 10, 3, 1 };

		//for (int posIncrementoActual = 1; posIncrementoActual < incrementos.length; posIncrementoActual++) {
		for (int posIncrementoActual = 0; posIncrementoActual < incrementos.length; posIncrementoActual++) {
			inc = incrementos[posIncrementoActual];
			if (inc < (datosParaClasificar.length / 2)) {
				for (int i = inc; i < datosParaClasificar.length; i++) {
					j = i - inc;
					while (j >= 0) {
						if (datosParaClasificar[j] > datosParaClasificar[j + inc]) {
							intercambiar(datosParaClasificar, j, j + inc);
							//j = j--;
						}
							j -= inc;
						//}
					}
				}
			}
		}
		return datosParaClasificar;
	}

	/**
	 * @param datosParaClasificar
	 * @return
	 */
	protected int[] ordenarPorInsercion(int[] datosParaClasificar) {
		if (datosParaClasificar != null) {
			//for (int i = 2; i < datosParaClasificar.length; i++) {
			for (int i = 1; i < datosParaClasificar.length; i++) {
				int j = i - 1;
				//while ((j >= 0) && (datosParaClasificar[j + 1] > datosParaClasificar[j])) {
				while ((j >= 0) && (datosParaClasificar[j + 1] < datosParaClasificar[j])) {
					intercambiar(datosParaClasificar, j, j + 1);
					j--;
				}
			}
			return datosParaClasificar;
		}
		return null;
	}

	private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
		//datosParaClasificar = null;
		int n = datosParaClasificar.length - 1;
		for (int i = 0; i <= n; i++) {
			for (int j = n; j >= (i + 1); j--) {
				if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
					intercambiar(datosParaClasificar, j - 1, j);
				}
			}
		}
		return datosParaClasificar;
	}

	protected int[] ordenarPorQuickSort(int[] datosParaClasificar) {
		quicksort(datosParaClasificar, 0, datosParaClasificar.length -1, 0);
		return datosParaClasificar;
	}
	
	private void quicksort(int[] entrada, int i, int j, int contador) {
		int izquierda = i;
		int derecha = j;

		int posicionPivote = encuentraPivote(izquierda, derecha, entrada); 
		if (posicionPivote >= 0){
			int pivote = entrada[posicionPivote];  
			while (izquierda <= derecha) {
				while ((entrada[izquierda] < pivote) && (izquierda < j)) {
					izquierda++; 
				}

				while ((pivote < entrada[derecha]) && (derecha > i)) {
					derecha--; 
				}

				if (izquierda <= derecha) {
					intercambiar(entrada, derecha, izquierda); 
					izquierda++;
					derecha--;
				}
			}

			if (i > derecha)
				quicksort(entrada, i, izquierda, contador++); 
			if (izquierda < j)
				quicksort(entrada, derecha, j, contador++); 
		}
	}

	private int encuentraPivote(int izquierda, int derecha, int[] entrada) {
		Random rnd = new Random();
		if (entrada != null && entrada.length > 0) {
			int pivote = rnd.nextInt(entrada.length);
			return pivote;
		}
		return 0;
	}

	public static boolean estaOrdenado(int[] vector, boolean orden, boolean estricto) {
		boolean res = false;
		for (int i = 0; i < vector.length - 1; i++) {
			if (orden == true && estricto == true) {
				if (vector[i] < vector[i + 1]) {
					res = true;
				} else {
					return false;
				}
			} else if (orden == true && estricto == false) {
				if (vector[i] <= vector[i + 1]) {
					res = true;
				} else {
					return false;
				}
			} else if (orden == false && estricto == true) {
				if (vector[i] > vector[i + 1]) {
					res = true;
				} else {
					return false;
				}
			} else if (orden == false && estricto == false) {
				if (vector[i] >= vector[i + 1]) {
					res = true;
				} else {
					return false;
				}
			}
		}
		return res;
	}

	public static void main(String args[]) {
		TClasificador clasif = new TClasificador();
		GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
		int[] vectorAleatorio = gdg.generarDatosAleatorios();
		int[] vectorAleatorio2 = gdg.generarDatosAleatorios();
		int[] vectorAleatorio3 = gdg.generarDatosAleatorios();
		int[] vectorAleatorio4 = gdg.generarDatosAleatorios();

		int[] resAleatorio = clasif.clasificar(vectorAleatorio,METODO_CLASIFICACION_INSERCION);
		for (int i = 0; i < resAleatorio.length; i++) {
			System.out.print(resAleatorio[i] + " ");
		}
		System.out.println(estaOrdenado(resAleatorio, true, true));
		System.out.println("\n");
		//------

		int[] resAleatorio2 = clasif.clasificar(vectorAleatorio2,METODO_CLASIFICACION_SHELL);
		for (int j = 0; j < resAleatorio2.length; j++) {
			System.out.print(resAleatorio2[j] + " ");
		}
		System.out.println(estaOrdenado(resAleatorio2, true, true));
		System.out.println("\n");
		//------

		int[] resAleatorio3 = clasif.clasificar(vectorAleatorio3,METODO_CLASIFICACION_BURBUJA);
		for (int k = 0; k < resAleatorio3.length; k++) {
			System.out.print(resAleatorio3[k] + " ");
		}
		System.out.println(estaOrdenado(resAleatorio3, true, true));
		System.out.println("\n");
		//------

		int[] resAleatorio4 = clasif.clasificar(vectorAleatorio4, METODO_CLASIFICACION_QUICKSORT);
		for (int l = 0; l < resAleatorio4.length; l++) {
			System.out.print(resAleatorio4[l] + " ");
		}
		System.out.println(estaOrdenado(resAleatorio4, true, true));
		System.out.println("\n");
	}

}
