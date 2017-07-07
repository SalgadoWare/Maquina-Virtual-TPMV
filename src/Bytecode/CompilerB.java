package Bytecode;

import Excepciones.ArrayException;
import Instrucciones.Instruction;
import Instrucciones.ParsedProgram;
import Principal.SourceProgram;

public class CompilerB {
	private ByteCodeProgram bcProgram;
	private String[] varTable;
	private int numVars;

	public CompilerB(ByteCodeProgram p) {
		this.bcProgram = p;
		this.numVars = 0;
		this.varTable = new String[SourceProgram.MAX_PROGRAM];
	}

	/**
	 * Llama sucesivamente al m�todo compile de cada instruccion
	 * 
	 * @param pProgram
	 * @throws ArrayException
	 */
	public void compile(ParsedProgram pProgram) throws ArrayException {
		int i = 0;

		while (i < pProgram.getNumeroInstrucciones()) {
			Instruction inst = pProgram.getInstruction(i);
			inst.compile(this);
			i++;
		}
	}

	public void addByteCode(ByteCode b) throws ArrayException {
		this.bcProgram.add(b);

	}

	/**
	 * Devuelve el �ndice de la variable varName en la tabla varTable, adem�s si
	 * no lo encuentra, lo a�ada al final de la tabla
	 * 
	 * @param varName
	 * @return posicion en la tabla varTable
	 */
	public int getIndex(String varName) {

		int i = 0;
		boolean found = false;

		while (i < this.numVars && !found) {
			found = (varName.equalsIgnoreCase(this.varTable[i]));
			if (!found)
				++i;
		}

		if (!found) {
			this.varTable[i] = varName;
			++this.numVars;
		}

		return i;
	}

	public int getProgramCounter() {
		return this.bcProgram.getContador();
	}
}
