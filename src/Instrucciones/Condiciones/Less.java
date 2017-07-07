package Instrucciones.Condiciones;

import Bytecode.ConditionalJumps;
import Bytecode.Ifle;
import Instrucciones.LexicalParser;
import Instrucciones.Term.Term;

public class Less extends Condition {

	public Less(Term t1, ConditionalJumps condition, Term t2) {
		super(t1, condition, t2);
	}

	public Less() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Condition parseAux(Term te1, String op, Term te2, LexicalParser parser) {
		if (op.equalsIgnoreCase("<")) {
			parser.increaseProgramCounter();
			return new Less(te1, new Ifle(), te2);
		} else
			return null;
	}


}
