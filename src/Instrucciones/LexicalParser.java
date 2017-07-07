package Instrucciones;

import Excepciones.LexicalAnalysisException;
import Principal.SourceProgram;

public class LexicalParser {

	private SourceProgram sProgram;
	private int programCounter;

	public LexicalParser(SourceProgram source) {
		this.sProgram = source;
		this.programCounter = 0;
	}

	public void lexicalParser(ParsedProgram pProgram, String stopKey) throws LexicalAnalysisException {

		boolean stop = false;
		while (this.programCounter < sProgram.getNumeroInstrucciones() && !stop) {
			String instr = sProgram.getInstruction(this.programCounter);
			String[] a_instr = instr.split(" +");
			if (instr.equalsIgnoreCase(stopKey)) {
				stop = true;
			} else {
				Instruction instruction = InstructionParser.parse(a_instr, this);
				if (instruction == null)
					throw new LexicalAnalysisException();
				else
					pProgram.addIns(instruction);
			}
		}
	}

	public void increaseProgramCounter() {
		this.programCounter++;
	}

	public int getContador() {
		return this.programCounter;
	}
}
