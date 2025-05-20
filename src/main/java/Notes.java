
class Notes {
	public static void main(String[] args) {

		Table[] tables = new Table[5];

		tables[0] = new Table(1, 5, 3);
		tables[1] = new Table(5, 2, 2);
		tables[2] = new Table(4, 5, 3);
		tables[3] = new Table(2, 1, 4);
		tables[4] = new Table(3, 2, 1);

		//unsorted table array
		for (int i = 0; i < tables.length; i++) {
			System.out.println(tables[i]);
		}

		System.out.println("----------------------------------------------");
		Arrays.sort(tables);

		//sorted by comparable table array
		for (int i = 0; i < tables.length; i++) {
			System.out.println(tables[i]);
		}
		
		Animal a = new Dog();
		Animal b = new Cat();
		Animal c = new Horse();

		a.talk();
		b.talk();
		c.talk();

		Cat cat = new Cat();
		Dog dog = new Dog();
		Horse horse = new Horse();

		a = cat;
		b = dog;
		c = horse;

		a.talk();
		b.talk();
		c.talk();

		animalTalk(cat);
		animalTalk(a);
		animalTalk(dog);
		animalTalk(b);
		animalTalk(horse);
		animalTalk(c);

		// moveAnimal(a);
		moveAnimal(cat);
		// moveAnimal(b);
		moveAnimal(dog);
		// moveAnimal(c);
		moveAnimal(horse);


		//instanceof
		//returns a boolean if the first object is the same as the second object.  Or if the second object is a subclass of the first object.


		System.out.println(a instanceof Animal); //true
		System.out.println(a instanceof Dog); //false
		System.out.println(a instanceof Cat); //true
		System.out.println(a instanceof Moveable); //true
	}

	public static void animalTalk(Animal a) {
		a.talk();
	}

	public static void moveAnimal(Moveable m) {
		m.move();
	}
}
