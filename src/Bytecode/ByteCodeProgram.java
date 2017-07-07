package Bytecode;

import Excepciones.ArrayException;

public class ByteCodeProgram {

	private ByteCode[] program;
	public final static int MAX_BYTES_CODES = 100;
	private int contador;

	/**
	 * Constructor de ByteCodeProgram, su array de bytecodes y contador
	 */
	public ByteCodeProgram() {
		this.program = new ByteCode[MAX_BYTES_CODES];
		this.contador = 0;
	}

	/**
	 * Dado un bytecode, lo añade al final del array e incrementa el contador
	 * 
	 * @param bc
	 *            (bytecode)
	 *
	 * @throws ArrayException -
	 */
	public void add(ByteCode bc) throws ArrayException {
		if (this.contador < ByteCodeProgram.MAX_BYTES_CODES) {
			this.program[contador] = bc;
			contador++;
		} else {
			throw new ArrayException("No se pueden aniadir tantos bytecodes, maximo " + MAX_BYTES_CODES);
		}
	}

	/**
	 * Reescribimos en pos el bytecode bc
	 * 
	 * @param bc
	 * @param pos
	 * @throws ArrayException
	 */
	public void overwrite(ByteCode bc, int pos) throws ArrayException {

		if (pos < 0 || pos >= this.contador) {
			throw new ArrayException("ArrayException: No se puede reemplazar un bytecode en la posicion " + pos
					+ " exiten " + this.contador + " almacenados");
		} else {
			this.program[pos] = bc;
		}

	}

	/**
	 * @return String de todos los bytecodes del programa actual y sus
	 *         parámetros separados con "\n"
	 */
	public String toString() {
		String programa = "Programa almacenado" + System.getProperty("line.separator");

		for (int i = 0; i < this.contador; ++i) {
			programa += (i + ": " + this.program[i]);
			programa += System.getProperty("line.separator");
		}

		return programa;
	}

	/**
	 * Reseteamos el ByteCodeProgram igualando el contador de su array a 0, esto
	 * quiere decir que no se borran totalmente los bytecode del array, si no
	 * que se van sobreescribiendo
	 */
	public void reset() {
		this.contador = 0;
	}

	/**
	 * 
	 * @return Contador del array de bytecodes
	 */
	public int getContador() {
		return this.contador;
	}

	/**
	 * Dado un numero natural n, devolvemos el bytecode en la posición n del
	 * array
	 * 
	 * @param n
	 * @return Bytecode
	 */
	public ByteCode devuelveBC(int n) {
		return this.program[n];
	}
}
