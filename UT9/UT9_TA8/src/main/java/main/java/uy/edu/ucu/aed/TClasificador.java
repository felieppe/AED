package main.java.uy.edu.ucu.aed;

import java.util.Random;

public class TClasificador {
	public static final int METODO_CLASIFICACION_INSERCION = 1;
	public static final int METODO_CLASIFICACION_SHELL = 2;
	public static final int METODO_CLASIFICACION_BURBUJA = 3;
	public static final int METODO_CLASIFICACION_QUICKSORT = 4;
	public static final int METODO_CLASIFICACION_HEAPSORT = 5;
	public static final int METODO_CLASIFICACION_SELECCION = 6;

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
			case METODO_CLASIFICACION_HEAPSORT:
				return ordenarPorHeapSort(datosParaClasificar);
			case METODO_CLASIFICACION_SELECCION:
				return ordenarPorSeleccion(datosParaClasificar);
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
		if (posicionPivote >= 0) {
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
	
			if (i < derecha) {
				quicksort(entrada, i, derecha, ++contador); 
			}
			if (izquierda < j) {
				quicksort(entrada, izquierda, j, ++contador); 
			}
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

	protected int[] ordenarPorHeapSort(int[] datosParaClasificar) {
		for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
			armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
		}
		for (int i = datosParaClasificar.length - 1; i >= 1; i--) { //!!!! > por >=
			intercambiar(datosParaClasificar,0,i);
			armaHeap(datosParaClasificar, 0, i-1);
		}
		return datosParaClasificar;
	}

	private void armaHeap(int[] datosParaClasificar, int primero, int ultimo) {
		if (primero < ultimo) {
			int r = primero;
			while (r <= ultimo / 2){
				if (ultimo == 2*r) {				 //r tiene un hijo solo
						//if (datosParaClasificar[r] < datosParaClasificar[r*2]){
						if (datosParaClasificar[r] > datosParaClasificar[r*2]){
							intercambiar(datosParaClasificar, r, 2 * r);
							// r = 2;
						}
						r = ultimo;
				} else { 							 //r tiene 2 hijos
					int posicionIntercambio = 0;
					if (datosParaClasificar[2*r] > datosParaClasificar[2*r + 1]) {
						posicionIntercambio = 2 * r + 1;
					} else {
						posicionIntercambio = 2 * r;
					}
					if (datosParaClasificar[r] > datosParaClasificar[posicionIntercambio]) {
						intercambiar(datosParaClasificar, r, posicionIntercambio);
						r = posicionIntercambio;
					} else {
						r = ultimo;
					}
				}
			}			
		}
	}

	private int[] ordenarPorSeleccion(int[] datosParaClasificar) {
        for (int i = 0; i < datosParaClasificar.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < datosParaClasificar.length; j++) {
                if (datosParaClasificar[j] < datosParaClasificar[minIndex]) {
                    minIndex = j;
                }
            }
            intercambiar(datosParaClasificar, minIndex, i);
        }
        return datosParaClasificar;
    }
	

	public static void main(String[] args) {
        TClasificador clasificador = new TClasificador();
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();

        int[] tamanios = {300, 3000, 30000};
        int[] metodos = {METODO_CLASIFICACION_INSERCION, METODO_CLASIFICACION_SHELL, METODO_CLASIFICACION_BURBUJA, METODO_CLASIFICACION_QUICKSORT, METODO_CLASIFICACION_HEAPSORT, METODO_CLASIFICACION_SELECCION};
        String[] descripciones = {"Insercion", "Shell", "Burbuja", "Quicksort", "Heapsort", "Seleccion"};

        for (int tamanio : tamanios) {
            for (int metodo : metodos) {
                int[] datosAscendente = gdg.generarDatosAscendentes(tamanio);
                int[] datosDescendente = gdg.generarDatosDescendentes(tamanio);
                int[] datosAleatorio = gdg.generarDatosAleatorios(tamanio);

                long inicio, fin;

                // Datos ascendentes
                inicio = System.nanoTime();
                clasificador.clasificar(datosAscendente.clone(), metodo);
                fin = System.nanoTime();
                System.out.println("Tiempo " + descripciones[metodo - 1] + " - Ascendente (" + tamanio + "): " + (fin - inicio) + " ns");

                // Datos descendentes
                inicio = System.nanoTime();
                clasificador.clasificar(datosDescendente.clone(), metodo);
                fin = System.nanoTime();
                System.out.println("Tiempo " + descripciones[metodo - 1] + " - Descendente (" + tamanio + "): " + (fin - inicio) + " ns");

                // Datos aleatorios
                inicio = System.nanoTime();
                clasificador.clasificar(datosAleatorio.clone(), metodo);
                fin = System.nanoTime();
                System.out.println("Tiempo " + descripciones[metodo - 1] + " - Aleatorio (" + tamanio + "): " + (fin - inicio) + " ns");
            }
        }
    }
/*


	public static void main(String args[]) {
		TClasificador clasif = new TClasificador();
		GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
		int[] vectorAleatorio = gdg.generarDatosAleatorios(10);
		int[] vectorAleatorio2 = gdg.generarDatosAleatorios(10);
		int[] vectorAleatorio3 = gdg.generarDatosAleatorios(10);
		int[] vectorAleatorio4 = gdg.generarDatosAleatorios(10);
		int[] vectorAleatorio5 = gdg.generarDatosAleatorios(300);
		int[] vectorAleatorio6 = gdg.generarDatosAleatorios(10000);
		

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

		int[] resAleatorio5 = clasif.clasificar(vectorAleatorio5, METODO_CLASIFICACION_HEAPSORT);
		for (int t = 0; t < resAleatorio5.length; t++) {
			System.out.print(resAleatorio5[t] + " ");
		}
		System.out.println(estaOrdenado(resAleatorio5, false, true));
		System.out.println("\n");

		int[] resAleatorio6 = clasif.clasificar(vectorAleatorio6, METODO_CLASIFICACION_HEAPSORT);
		for (int t = 0; t < resAleatorio6.length; t++) {
			System.out.print(resAleatorio6[t] + " ");
		}
		System.out.println(estaOrdenado(resAleatorio6, false, true));
		System.out.println("\n");
*/
	}
