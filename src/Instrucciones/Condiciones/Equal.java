package Instrucciones.Condiciones;

import Bytecode.ConditionalJumps;
import Bytecode.Ifeq;
import Instrucciones.LexicalParser;
import Instrucciones.Term.Term;

public class Equal extends Condition {

	public Equal(Term t1, ConditionalJumps condition, Term t2) {
		super(t1, condition, t2);
	}

	public Equal() {
	}

	@Override
	public Condition parseAux(Term te1, String op, Term te2, LexicalParser parser) {
		if (op.equalsIgnoreCase("=")) {
			parser.increaseProgramCounter();
			return new Equal(te1, new Ifeq(), te2);
		} else
			return null;
	}
}
