package Instrucciones;

import Excepciones.ArrayException;
import Bytecode.CompilerB;
import Bytecode.Goto;
import Excepciones.LexicalAnalysisException;
import Instrucciones.Condiciones.Condition;
import Instrucciones.Condiciones.ConditionParser;

public class While implements Instruction {

	private Condition condition;
	private ParsedProgram whileBody;
	public static int MAX_DIM_WHILE = 15;

	public While(ParsedProgram wBody, Condition con) {
		this.whileBody = wBody;
		this.condition = con;
	}

	public While() {
	}

	public Instruction lexParse(String[] words, LexicalParser lexParser) {

		if (words.length == 4 && words[0].equalsIgnoreCase("WHILE")) {
			Condition con = ConditionParser.parse(words[1], words[2], words[3], lexParser);
			if (con != null) {
				ParsedProgram wBody = new ParsedProgram(MAX_DIM_WHILE);
				try {
					lexParser.lexicalParser(wBody, "ENDWHILE");
					lexParser.increaseProgramCounter();
					return new While(wBody, con);
				} catch (LexicalAnalysisException e) {
					return null;
				}
			} else
				return null;
		} else
			return null;

	}

	public void compile(CompilerB compilerB) throws ArrayException {
		int n = compilerB.getProgramCounter();
		this.condition.compile(compilerB);
		compilerB.compile(this.whileBody);
		compilerB.addByteCode(new Goto(n));
		this.condition.setJump(compilerB.getProgramCounter());
		
	}

}
