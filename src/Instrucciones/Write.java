package Instrucciones;

import Bytecode.Load;
import Bytecode.CompilerB;
import Bytecode.Out;
import Excepciones.ArrayException;
import Instrucciones.Term.Term;
import Instrucciones.Term.TermParser;

public class Write implements Instruction {

	private String varName;

	public Write(String string) {
		this.varName = string;
	}

	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length != 2 || !words[0].equalsIgnoreCase("WRITE"))
			return null;
		else {
			Term v = TermParser.parse(words[1]);
			if (v == null || v.getClass() == Number.class)
				return null;
			else {
				lexParser.increaseProgramCounter();
				return new Write(v.toString());
			}
		}
	}

	public void compile(CompilerB compiler) throws ArrayException {

		int index = compiler.getIndex(this.varName);
		compiler.addByteCode(new Load(index));
		compiler.addByteCode(new Out());

	}

}
