package Principal;

import Excepciones.ArrayException;

public class SourceProgram {
	private String[] sProgram;
	private int contador;

	/**
	 * Esta es la constante principal del sistema, marca la dimension de los
	 * arrays de código fuente, de instrucciones, y de la tabla de variables
	 */
	public static int MAX_PROGRAM = 150;

	public SourceProgram() {
		this.contador = 0;
		this.sProgram = new String[SourceProgram.MAX_PROGRAM];
	}

	public int getNumeroInstrucciones() {
		return this.contador;
	}

	public String getInstruction(int programCounter) {
		return sProgram[programCounter];
	}

	public void addLine(String linea) throws ArrayException {
		if (this.contador == SourceProgram.MAX_PROGRAM) {
			throw new ArrayException("ArrayException: Se ha sobrepasado el limite " + SourceProgram.MAX_PROGRAM
					+ " de lineas de codigo fuente");
		} else {
			this.sProgram[this.contador] = linea;
			++this.contador;
		}
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < this.contador; ++i) {
			s += "[" + i + "]: " + this.sProgram[i] + System.getProperty("line.separator");
		}
		return s;
	}

	public void reset() {
		this.contador = 0;

	}
}
