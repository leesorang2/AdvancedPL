package assignment01;

import java.util.LinkedHashMap;
import java.util.WeakHashMap;

public class ServiceProvider {
	public static LinkedHashMap<KeyPair<String, String>, String> classMap = new LinkedHashMap<>();
//	public WeakHashMap<String, WeakReference<Class<?>>> cache = new WeakHashMap<>();
	public static WeakHashMap<String, Class<?>> cache = new WeakHashMap<>();

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
//			Class<?> klass = cache.get(classPath).get();
			Class<?> klass = cache.get(classPath);
			try {
				a = klass.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				Class<?> klass = Class.forName(classPath);
//				cache.put(classPath, new WeakReference<Class<?>>(klass));
				cache.put(classPath, klass);
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
		}
		return a;
	}
}