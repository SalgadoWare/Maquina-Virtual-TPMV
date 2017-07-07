package Instrucciones.Term;

import Bytecode.ByteCode;
import Bytecode.CompilerB;
import Bytecode.Load;

public class Variable implements Term {

	private String varName;

	public Variable(String term) {
		this.varName = term;
	}

	public Variable() {
	}

	@Override
	public Term parse(String term) {
		if (Variable.compruebaNombre(term))
			return new Variable(term);
		else
			return null;
	}

	@Override
	public ByteCode compile(CompilerB compiler) {
		return new Load(compiler.getIndex(this.varName));
	}

	public String toString() {
		return this.varName;
	}

	/**
	 * Esta función estática es necesaria para poder distinguir entre números y variables sin utilizar el .getClass
	 * Comprueba que el término sea una variable, precisamente un letra entre la 'a' y la 'z'
	 * @param term
	 * @return
	 */
	public static boolean compruebaNombre(String term) {
		if (term.length() != 1)
			return false;
		else {
			char name = term.charAt(0);
			return ('a' <= name && name <= 'z');
		}
	}

}
