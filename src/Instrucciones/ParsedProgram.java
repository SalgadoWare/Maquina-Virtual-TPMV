package Instrucciones;

import Principal.SourceProgram;

public class ParsedProgram {
	private Instruction[] pProgram;
	private int contador;

	public ParsedProgram() {
		this.contador = 0;
		this.pProgram = new Instruction[SourceProgram.MAX_PROGRAM];
	}

	public ParsedProgram(int i) {
		this.pProgram = new Instruction[i];
		this.contador = 0;
	}

	public Instruction getInstruction(int i) {
		return this.pProgram[i];
	}

	public int getNumeroInstrucciones() {
		return this.contador;
	}

	public void addIns(Instruction i) {
		this.pProgram[this.contador] = i;
		++this.contador;
		
		//al utilizar la misma constante de número máximo de elementos del array de instrucciones
		//y lineas de codigo fuente, esta función nunca dará un ArrayIndexOutOfTheBoundsException
	}

	public void reset() {
		this.contador = 0;
	}
}
