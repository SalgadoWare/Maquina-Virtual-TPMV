package Bytecode;

import Cpu.CPU;
import Excepciones.ArrayException;
import Excepciones.DivisionByZero;
import Excepciones.StackException;

public interface ByteCode{
	
	abstract public void execute(CPU cpu) throws ArrayException, DivisionByZero, StackException;
	abstract public ByteCode parse(String[ ] s);
	abstract public String toString();
}