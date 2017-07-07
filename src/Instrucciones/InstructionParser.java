package Instrucciones;

import Excepciones.LexicalAnalysisException;

public class InstructionParser {

	private static Instruction[] ins = { new CompoundAssignment(), new SimpleAssignment(), new Write(null), new Return(),
			new While(), new IfThen() };

	public static Instruction parse(String[] linea, LexicalParser lexicalParser) throws LexicalAnalysisException {
		int i = 0;
		Instruction instr = null;
		while (i < ins.length && instr == null) {
			instr = ins[i].lexParse(linea, lexicalParser);
			++i;
		}
		return instr;
	}

}
