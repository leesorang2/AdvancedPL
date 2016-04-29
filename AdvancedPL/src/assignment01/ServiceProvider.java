package assignment01;

import java.util.LinkedHashMap;

public class ServiceProvider {
	public LinkedHashMap<KeyPair<String, String>, String> classMap = new LinkedHashMap<>();
	public LinkedHashMap<String, Class<?>> cache = new LinkedHashMap<>();
	
	public void registClass(String creator, String nick, String classPath) {
		KeyPair<String, String> key = new KeyPair<>(creator, nick);
		
		if(!classMap.containsKey(key))
			classMap.put(key, classPath);
		System.out.println(key.hashCode());
	}
	
	public Object loadClass(String creator, String nick) {
		KeyPair<String, String> key = new KeyPair<>(creator, nick);
		Object a = null;
		
		System.out.println(key.hashCode());
		
		if(!classMap.containsKey(key))
			return a;
		
		String classPath = classMap.get(key);
		try {
			Class<?> klass = Class.forName(classPath);
			 a = klass.newInstance();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
}