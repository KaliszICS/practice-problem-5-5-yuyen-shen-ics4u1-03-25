class Dog extends Animal implements Moveable {

	public Dog() {
		
	}

	@Override
	public void talk() {
		System.out.println("Bark");
	}

	@Override
	public void move() {
		System.out.println("Dog Chases.");
	}
	
}