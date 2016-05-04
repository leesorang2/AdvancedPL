package assignment01;

import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;

public class ServiceProvider {
	public static LinkedHashMap<KeyPair<String, String>, String> classMap = new LinkedHashMap<>();
	public static LinkedHashMap<String, WeakReference<Class<?>>> cache = new LinkedHashMap<>();
	
	public static void registClass(String creator, String nick, String classPath) {
		KeyPair<String, String> key = new KeyPair<>(creator, nick);

		if (!classMap.containsKey(key))
			classMap.put(key, classPath);
	}

	public static Object loadClass(String creator, String nick) {
		KeyPair<String, String> key = new KeyPair<>(creator, nick);
		String classPath = classMap.get(key);

		Object a = null;

		if (!classMap.containsKey(key))
			return a;
		else if (cache.containsKey(classPath)) {
			Class<?> klass = cache.get(classPath).get();
			try {
				a = klass.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Class<?> klass = Class.forName(classPath);
				cache.put(classPath, new WeakReference<Class<?>>(klass));
				a = klass.newInstance();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return a;
	}
}