package Instrucciones.Condiciones;

import Instrucciones.LexicalParser;

public class ConditionParser {

	private static Condition[] cs = { new Less(), new Equal(), new LessEq(), new NotEqual() };

	public static Condition parse(String t1, String op, String t2, LexicalParser parser) {
		int i = 0;
		Condition c = null;
		while (i < cs.length && c == null) {
			c = cs[i].parse(t1, op, t2, parser);
			++i;
		}
		return c;
	}
}
