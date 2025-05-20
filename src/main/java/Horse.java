class Horse extends Animal implements Moveable {

	public Horse() {
		
	}

	@Override
	public void talk() {
		System.out.println("Neigh");
	}

	@Override
	public void move() {
		System.out.println("Horse Gallops.");
	}
	
}