package Instrucciones;

import Bytecode.CompilerB;
import Bytecode.Store;
import Excepciones.ArrayException;
import Excepciones.LexicalAnalysisException;
import Instrucciones.Term.Term;
import Instrucciones.Term.TermParser;
import Instrucciones.Term.Variable;

public class SimpleAssignment implements Instruction {

	private String varName;
	private Term rhs;

	public SimpleAssignment(String v, Term term) {

		this.rhs = term;
		this.varName = v;
	}

	public SimpleAssignment() {
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException {
		if (words.length != 3 || !words[1].equalsIgnoreCase("="))
			return null;
		else {
			if (Variable.compruebaNombre(words[0])) {
				String v = words[0];

				Term term = TermParser.parse(words[2]);
				if (term == null)
					return null;
				lexParser.increaseProgramCounter();
				return new SimpleAssignment(v.toString(), term);

			} else {
				throw new LexicalAnalysisException();
			}

		}
	}

	@Override
	public void compile(CompilerB compiler) throws ArrayException {
		compiler.addByteCode(this.rhs.compile(compiler));
		compiler.addByteCode(new Store(compiler.getIndex(this.varName)));
	}

}
