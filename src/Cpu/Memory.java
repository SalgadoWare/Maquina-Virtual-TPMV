package Cpu;


public class Memory {

	private Integer[] memory;
	private int guardados;
	private final static int MAX_MEM = 1000;

	/**
	 * Constructur de la memoria con todos sus atrivutos (Su tamanio inicial es
	 * Memory.MAX_MEM)
	 */
	public Memory() {

		this.memory = new Integer[Memory.MAX_MEM];
		this.guardados = 0;

		for (int i = 0; i < this.memory.length; ++i) {
			this.memory[i] = null;
		}
	}

	/**
	 * Este método asigna un nuevo array de integer a la memoria más grande que
	 * el anterior, copiando los enteros del anterior array, y de tamanio
	 * 2*new_tamanio. La nueva parte del array se inicializa a null
	 * 
	 * @param new_tamanio
	 */
	private void resize(int new_tamanio) {

		Integer viejaMemoria[] = this.memory;

		this.memory = new Integer[new_tamanio * 2];

		for (Integer i = 0; i < viejaMemoria.length; ++i)
			this.memory[i] = viejaMemoria[i];

		for (Integer i = viejaMemoria.length; i < this.memory.length; ++i)
			this.memory[i] = null;
	}

	/**
	 * Escribe en memory[pos] el entero value Si la posición excede el tamanio
	 * del array, se invoca a la función resize
	 * 
	 * @param pos
	 * @param value
	 * @return true (se considera que la memoria siempre se puede hacer más
	 *         grande)
	 */
	public boolean write(int pos, int value) {

		if (!this.posValida(pos)) {
			if (pos >= 0) // pos exede el rango de memoria actual
				this.resize(pos);
		}

		this.memory[pos] = value;
		this.guardados++;
		return true;
	}

	/**
	 * Lectura de memoria en una posición dada
	 * 
	 * @param pos
	 * @return entero de memory[pos] o null si memory[pos] == null
	 */
	public Integer read(int pos) {
		if (this.posValida(pos)) {
			if (this.memory[pos] == null)
				return null;
			else
				return this.memory[pos];
		} else {
			if (pos >= 0)
				this.resize(pos);
			return null;
		}
	}

	/**
	 * Convierte en string toda la memoria
	 */
	public String toString() {

		String memoria = "	Memoria: ";

		if (this.guardados == 0)
			memoria += "<vacia>";
		else {

			int i = 0;
			int contador = 0;
			while (contador != this.guardados && i < this.memory.length) {
				if (this.memory[i] != null) {
					memoria += ("[" + i + "]: " + this.read(i) + "  ");
					contador++;
				}
				++i;
			}
		}
		return memoria;
	}

	/**
	 * Este método sirve para indicarnos si se está intentado leer de una
	 * posición (pos) de memoria dentro del rahgo de memoria, y en el caso
	 * contrario, utilizar el método resize
	 * 
	 * @param pos
	 * @return true; pos es positivo y dentro del rango del array de memoria
	 *         actual, false; viceversa
	 */
	public boolean posValida(int pos) {
		return pos < this.memory.length && pos >= 0;
	}

	/**
	 * Asigna a null todas las posiciones de memoria (Hemos considerado mantener
	 * la memoria y no crear una nueva, aunque pueda ser que la que se mantiene
	 * sea muy grande si se ha ampliado, pero así evitamos que se creen
	 * numerosos objetos en cada ejecución
	 */
	public void resetMemory() {

		for (int i = 0; i < this.memory.length; ++i)
			this.memory[i] = null;
		this.guardados = 0;
	}
}
