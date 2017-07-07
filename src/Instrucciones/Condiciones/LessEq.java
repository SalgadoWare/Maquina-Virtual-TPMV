package Instrucciones.Condiciones;

import Bytecode.ConditionalJumps;
import Bytecode.Ifleq;
import Instrucciones.LexicalParser;
import Instrucciones.Term.Term;

public class LessEq extends Condition {

	public LessEq(Term t1, ConditionalJumps condition, Term t2) {
		super(t1, condition, t2);
	}

	public LessEq() {
	}

	@Override
	public Condition parseAux(Term te1, String op, Term te2, LexicalParser parser) {
		if (op.equalsIgnoreCase("<=")) {
			parser.increaseProgramCounter();
			return new LessEq(te1, new Ifleq(), te2);
		} else
			return null;
	}


}
