package Instrucciones.Condiciones;

import Bytecode.CompilerB;
import Bytecode.ConditionalJumps;
import Excepciones.ArrayException;
import Instrucciones.LexicalParser;
import Instrucciones.Term.Term;
import Instrucciones.Term.TermParser;

public abstract class Condition {

	private Term t1;
	private Term t2;
	private ConditionalJumps condition;

	public Condition(Term t1, ConditionalJumps condition, Term t2) {
		this.t1 = t1;
		this.condition = condition;
		this.t2 = t2;
	}

	public Condition() {
	};

	public Condition parse(String t1, String op, String t2, LexicalParser parser) {

		Term te1 = TermParser.parse(t1);
		Term te2 = TermParser.parse(t2);
		if (te1 != null && te2 != null) {
			return parseAux(te1, op, te2,parser);
		} else
			return null;

	}

	public void compile(CompilerB compilerB) throws ArrayException {
		compilerB.addByteCode(this.t1.compile(compilerB));
		compilerB.addByteCode(this.t2.compile(compilerB));
		compilerB.addByteCode(this.condition);
	}

	abstract public Condition parseAux(Term te1, String op, Term te2, LexicalParser parser);

	public void setJump(int programCounter) {
		this.condition.setJump(programCounter);
	}
}
