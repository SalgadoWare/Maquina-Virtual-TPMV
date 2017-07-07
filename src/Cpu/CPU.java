package Cpu;

import Bytecode.ByteCode;
import Bytecode.ByteCodeProgram;
import Excepciones.ArrayException;
import Excepciones.ExecutionError;

public class CPU {

	private Memory memoria;
	private OperandStack pila;
	private ByteCodeProgram program;
	private boolean halt;
	private int programCounter;

	/**
	 * Constructura de la cpu
	 */
	public CPU(ByteCodeProgram program) {
		this.memoria = new Memory();
		this.pila = new OperandStack();
		this.halt = false;
		this.program = program;
		this.programCounter = 0;
	}

	/**
	 * Resetea la cpu
	 */
	public void resetCPU() {
		this.memoria.resetMemory();
		this.pila.resetPila();
		this.halt = false;
	}

	/**
	 * @return Un string con todos los datos de la cpu, pila y memoria
	 */
	public String toString() {
		return "Estado CPU:" + System.getProperty("line.separator") + this.memoria
				+ System.getProperty("line.separator") + this.pila;
	}

	/**
	 * 
	 * @return true; la cpu se ha bloqueado, false; viceversa
	 */
	public boolean isHalted() {
		return this.halt;
	}

	/**
	 * Recorremos el bytecodeProgram, cada bytecode ejecuta su funcíon y
	 * modifica el contador de programa
	 */
	public void run() throws ExecutionError, ArrayException {
		if (this.program.getContador() > 0) {
			this.resetCPU();
			this.programCounter = 0;
			this.halt = false;

			while (this.programCounter < this.program.getContador() && !this.isHalted()) {
				ByteCode b = this.program.devuelveBC(this.programCounter);
				b.execute(this);
			}
		} else
			throw new ExecutionError("ExecutionError: No existe programa bytecode, debes compilar primero");
	}

	/**
	 * función pop de la pila (OperandStack)
	 */
	public Integer pop() throws ArrayException {
		try {
			return this.pila.pop();
		} catch (ArrayException a) {
			throw new ArrayException(a.getMessage() + " linea " + this.programCounter);
		}
	}

	/**
	 * función push de la pila (OperandStack)
	 */
	public void push(int i) throws ArrayException {
		try {
			this.pila.push(i);
		} catch (ArrayException a) {
			throw new ArrayException(a.getMessage() + " linea " + this.programCounter);
		}

	}

	/**
	 * Bloqueo de la cpu
	 */
	public boolean halt() {
		this.halt = true;
		return true;
	}

	/**
	 * función read de memoria
	 * 
	 * @throws ArrayException
	 */
	public Integer readMem(int n) throws ArrayException {
		if (n < 0)
			throw new ArrayException(
					"Estas intentando leer de memoria en una posicion negativa, linea " + this.programCounter);
		else
			return this.memoria.read(n);
	}

	/**
	 * función write de memoria
	 * 
	 * @throws ArrayException
	 */
	public boolean writeInMem(int m, int n) throws ArrayException {
		if (m < 0)
			throw new ArrayException(
					"Estas intentando escribir en memoria en una posicion negativa, linea " + this.programCounter);
		else
			return this.memoria.write(m, n);
	}

	/**
	 * Devuelve el contador de la pila
	 */
	public int getSizeStack() {
		return this.pila.getContador();
	}

	public void increaseProgramCounter() {
		++this.programCounter;
	}

	public void setProgramCounter(int param) {
		this.programCounter = param;
	}

	/**
	 * Devuelve el contador del bytecodeProgram
	 */
	public int getSizeProgram() {
		return this.program.getContador();
	}
}
