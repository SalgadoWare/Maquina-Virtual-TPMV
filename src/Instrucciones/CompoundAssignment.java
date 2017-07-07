package Instrucciones;

import Bytecode.Add;
import Excepciones.ArrayException;
import Instrucciones.Term.Term;
import Instrucciones.Term.TermParser;
import Instrucciones.Term.Variable;
import Bytecode.CompilerB;
import Bytecode.Div;
import Bytecode.Mul;
import Bytecode.Store;
import Bytecode.Sub;

public class CompoundAssignment implements Instruction {

	private String varName;
	private String operator;
	private Term t1;
	private Term t2;

	public CompoundAssignment(String var, String operator, Term t1, Term t2) {
		this.varName = var;
		this.operator = operator;
		this.t1 = t1;
		this.t2 = t2;
	}

	public CompoundAssignment() {
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length == 5 && words[1].equalsIgnoreCase("=")) {

			Term v = TermParser.parse(words[0]);
			if (v == null || !Variable.compruebaNombre(v.toString()))
				return null;
			else {
				Term term1 = TermParser.parse(words[2]);
				if (term1 == null)
					return null;
				else {
					Term term2 = TermParser.parse(words[4]);
					if (term2 == null)
						return null;
					else {
						if (words[3].equalsIgnoreCase("+") || words[3].equalsIgnoreCase("-")
								|| words[3].equalsIgnoreCase("/") || words[3].equalsIgnoreCase("*")) {
							lexParser.increaseProgramCounter();
							return new CompoundAssignment(v.toString(), words[3], term1, term2);
						} else
							return null;
					}
				}
			}
		} else {
			return null;
		}
	}

	@Override
	public void compile(CompilerB compiler) throws ArrayException {
		compiler.addByteCode(this.t1.compile(compiler));
		compiler.addByteCode(this.t2.compile(compiler));
		switch (this.operator) {
		case "+":
			compiler.addByteCode(new Add());
			break;
		case "-":
			compiler.addByteCode(new Sub());
			break;
		case "*":
			compiler.addByteCode(new Mul());
			break;
		case "/":
			compiler.addByteCode(new Div());
			break;
		}
		compiler.addByteCode(new Store(compiler.getIndex(this.varName)));
	}

}
