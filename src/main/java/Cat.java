class Cat extends Animal implements Moveable {

	public Cat() {
		
	}

	@Override
	public void talk() {
		System.out.println("Meow");
	}

	@Override
	public void move() {
		System.out.println("Cat pounces.");
	}
	
}