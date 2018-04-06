package main.PH01252018;

public class Singleton {
	private static Singleton INSTANCE = new Singleton();

	private Singleton() {}

	public static Singleton getInstance() {
		return INSTANCE;
	}
}

class SingletonLazy {
	private static volatile SingletonLazy instance;
	private SingletonLazy() {}

	public static SingletonLazy getInstance() {
		if (instance == null) {
			synchronized(Singleton.class) {
				if (instance == null) {
					return new SingletonLazy();
				}
			}
		}
		return instance;
	}
}