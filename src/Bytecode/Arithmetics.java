package Bytecode;

import Cpu.CPU;
import Excepciones.ArrayException;
import Excepciones.DivisionByZero;
import Excepciones.StackException;

/**
 * 
 * La clase abstracta Arithmetics hereda de ByteCode implementando unos métodos
 * abstractos y definiendo otros
 *
 */
public abstract class Arithmetics implements ByteCode {

	@Override
	public void execute(CPU cpu) throws ArrayException, DivisionByZero, StackException {

		if (cpu.getSizeStack() >= 2) {
			int cima = cpu.pop();
			int subcima = cpu.pop();
			this.opera(cpu, subcima, cima);
			cpu.increaseProgramCounter();
		}
		else
			throw new StackException("Error de ejecucion en el bytecode: " + this.toString() + ": tamanio de pila insuficiente");
	}

	abstract protected void opera(CPU cpu, int n1, int n2) throws ArrayException, DivisionByZero;

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 1)
			return this.parseAux(s[0]);
		else
			return null;
	}

	abstract protected ByteCode parseAux(String s);

}
