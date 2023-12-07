package Learning;

public class LearningJava {

	public static void main(String[] args) {

		int a = 5;
		char b = 'i';
		long c = 400;
		double d = 3.2;
		
		String name = "Susan";
		System.out.println(name.toLowerCase() );
		
		addExclamationPoint("hot dogs");
		
		Animal e = new Animal();
		String dog = e.iAmDog();
		System.out.println(dog);
		e.doStuff();
		
	}
	
	public static void addExclamationPoint(String s) {
		
		System.out.println(s + "!");
	}

}
