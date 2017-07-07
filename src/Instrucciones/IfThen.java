package Instrucciones;

import Excepciones.ArrayException;
import Excepciones.LexicalAnalysisException;
import Instrucciones.Condiciones.Condition;
import Instrucciones.Condiciones.ConditionParser;
import Bytecode.CompilerB;

public class IfThen implements Instruction {

	private Condition condition;
	private ParsedProgram ifBody;

	public IfThen(ParsedProgram ifBody, Condition condition) {
		this.ifBody = ifBody;
		this.condition = condition;
	}

	public IfThen() {
	}

	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length == 4 && words[0].equalsIgnoreCase("IF")) {
			Condition con = ConditionParser.parse(words[1], words[2], words[3], lexParser);
			if (con != null) {
				ParsedProgram ifBody = new ParsedProgram(While.MAX_DIM_WHILE);
				try {
					lexParser.lexicalParser(ifBody, "ENDIF");
					lexParser.increaseProgramCounter();
					return new IfThen(ifBody, con);
				} catch (LexicalAnalysisException e) {
					return null;
				}
			} else
				return null;
		} else
			return null;

	}

	public void compile(CompilerB compilerB) throws ArrayException {

		this.condition.compile(compilerB);
		compilerB.compile(this.ifBody);
		this.condition.setJump(compilerB.getProgramCounter());
	}

}
