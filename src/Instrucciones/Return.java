package Instrucciones;

import Excepciones.ArrayException;
import Bytecode.CompilerB;
import Bytecode.Halt;

public class Return implements Instruction {

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexparser) {
		if (words.length != 1 || !words[0].equalsIgnoreCase("RETURN"))
			return null;
		else {
			lexparser.increaseProgramCounter();
			return new Return();
		}
	}

	@Override
	public void compile(CompilerB compiler) throws ArrayException {
		compiler.addByteCode(new Halt());
	}

}
