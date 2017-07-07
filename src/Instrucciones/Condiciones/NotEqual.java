package Instrucciones.Condiciones;

import Bytecode.ConditionalJumps;
import Bytecode.Ifneq;
import Instrucciones.LexicalParser;
import Instrucciones.Term.Term;

public class NotEqual extends Condition {

	public NotEqual(Term t1, ConditionalJumps condition, Term t2) {
		super(t1, condition, t2);
	}

	public NotEqual() {
	}

	@Override
	public Condition parseAux(Term te1, String op, Term te2, LexicalParser parser) {
		if (op.equalsIgnoreCase("!=")) {
			parser.increaseProgramCounter();
			return new NotEqual(te1, new Ifneq(), te2);
		} else
			return null;
	}

}
