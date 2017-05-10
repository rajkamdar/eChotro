package com.model.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class ActionFactory {
	private static  HashMap<String, Action> actions;
	public static Action getAction(String path)
	{
		return actions.get(path);
	}
	public static void fillActions() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		Properties prop = new Properties();
		InputStream input = null;
		input = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
		prop.load(input);
	    Set<Object> set= prop.keySet();
		for(Object key:set)
		{

				Action action= (Action) Class.forName(prop.getProperty(key.toString())).newInstance();
				actions.put(key.toString(),action);
		}
	}
	public static void main(String[] args) throws Exception {
		

	
	}
}
