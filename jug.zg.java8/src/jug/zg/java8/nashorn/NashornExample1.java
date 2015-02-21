package jug.zg.java8.nashorn;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class NashornExample1 {
	private static final String ENGINE_NAME = "nashorn";
	private static final String JS_FUNCTION = "fun1";
	private static final String JS_SCRIPT = "script.js";

	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName(ENGINE_NAME);
		engine.eval(new FileReader(JS_SCRIPT));
		
		Invocable invocable = (Invocable) engine;
		Object result = invocable.invokeFunction(JS_FUNCTION, "JUG ZG");
		System.out.println(result);
	}
}
