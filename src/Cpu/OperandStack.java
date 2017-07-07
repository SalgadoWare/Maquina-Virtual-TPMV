package Cpu;

import Excepciones.ArrayException;

public class OperandStack {

	public final static int MAX_OPERANDOS = 150;
	private int contador;
	private int[] stack;

	/**
	 * Constructor de la pila
	 */
	public OperandStack() {
		this.contador = 0;
		this.stack = new int[MAX_OPERANDOS];
	}

	/**
	 * Convierte en un string a toda la pila
	 */
	public String toString() {

		String pila = "	Pila:  ";

		if (this.contador == 0)
			pila += "<vacia>";
		else
			for (int i = 0; i < this.contador; ++i)
				pila += (this.stack[i] + " ");

		pila += System.getProperty("line.separator");
		return pila;
	}

	/**
	 * Método pop, se devuelve el último entero de la pila y se decrementa el
	 * contador de esta
	 * 
	 * @return El último entero de la pila o null si no existen valores
	 * @throws ArrayException 
	 */
	public Integer pop() throws ArrayException {

		if (this.contador != 0) {
			return this.stack[--this.contador];
		} else
			throw new ArrayException("ArrayException: Se intenta hacer un pop en una pila vacia");
	}

	/**
	 * Dado un entero (i) lo colocamos en la cima de la pila si hay espacio
	 * 
	 * @param i
	 * @throws ArrayException
	 */
	public void push(int i) throws ArrayException {
		if (this.contador < OperandStack.MAX_OPERANDOS) {
			this.stack[this.contador] = i;
			this.contador++;
		} else {
			throw new ArrayException("ArrayException: Se intenta un push en una pila llena de "
					+ OperandStack.MAX_OPERANDOS + " operandos");
		}
	}

	/**
	 * Resetemos la pila igualando su contador a 0, esto quiere decir que sus
	 * elementos no se borran totalmente, si no que se van reescribiendo
	 */
	public void resetPila() {
		this.contador = 0;
	}

	public int getContador() {
		return this.contador;
	}

}
