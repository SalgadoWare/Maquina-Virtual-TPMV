package Bytecode;

import Cpu.CPU;
import Excepciones.ArrayException;
import Excepciones.DivisionByZero;

/**
 * 
 * La clase Div hereda de Atrithmetics implementando todos los métodos
 * abstractos
 *
 */
public class Div extends Arithmetics {

	@Override
	public String toString() {
		return "DIV";
	}

	protected void opera(CPU cpu, int n1, int n2) throws DivisionByZero, ArrayException {
		if (n2 != 0)
			cpu.push(n1 / n2);
		else
			throw new DivisionByZero("DivisionByZero error");
	}

	@Override
	protected ByteCode parseAux(String s) {
		if (s.equalsIgnoreCase("DIV"))
			return new Div();
		else
			return null;
	}
}
