package jug.zg.java8.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class NashornExample0 {
	private static final String ENGINE_NAME = "nashorn";

	public static void main(String[] args) throws Exception {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName(ENGINE_NAME);
		scriptEngine.eval("print('Hello World!');");
	}
}
