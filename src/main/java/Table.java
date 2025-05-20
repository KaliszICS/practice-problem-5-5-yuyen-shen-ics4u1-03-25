class Table implements Comparable<Table> { //implement comparable which gives the compareTo method to be overridden.
	//specify the Object in the <> so that comparable's compareTo method uses your class instead of the Object class


	/*
		The Comparable interface contains the method compareTo to decide the order of the elements.
		Override the compareTo method in the Table class.
		Create an array of Table and populate the array.
		Use the Arrays.sort() function to sort the array.
	*/

	int length;
	int width;
	int height;

	public Table(int length, int width, int height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}	

	public Table() {
		this.length = 1;
		this.width = 1;
		this.height = 1;
	}

	public int volume() {
		return this.length * this.width * this.height;
	}

	public int topSurfaceArea() {
		return this.length * this.width;
	}

	public String toString() {
		return "Table: L:" + this.length + " W:" + this.width + " H:" + this.height + " V:" + this.volume();
	}
	
	@Override 
	public int compareTo(Table table)
	{
		//positive when this.volume() is greater than table.volume()
		//zero when this.volume() is the same as table.volume()
		//negative when this.volume() is less than table.volume()
		return this.volume() - table.volume();
	}
}