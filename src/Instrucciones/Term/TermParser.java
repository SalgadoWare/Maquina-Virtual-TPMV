package Instrucciones.Term;

public class TermParser {

	private static Term[] terminos = { new Number(), new Variable() };

	public static Term parse(String string) {
		int i = 0;
		Term t = null;
		while (i < terminos.length && t == null) {
			t = terminos[i].parse(string);
			++i;
		}
		return t;
	}

}
