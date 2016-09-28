package ch11.exam09;

public class NewInstanceExample {
	public static void main(String[] args) throws Exception{
		Class clazz = Class.forName("ch11.exam09." + args[0]);
		Action action = (Action)clazz.newInstance();
		//Object obj = clazz.newInstance();
		//Action action = (Action) obj;
		action.execute();
	}
}
