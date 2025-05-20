[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=19588469)
# Instructions  

1. Create a class _Student_ which takes a name, age and student number.</br>
	 Implement the Comparable interface.</br>
	 Create getters and setters as well as override the toString method with the format "N:_name_ A:_age_ SN:_studentNumber_"</br>
   Override the compareTo method with your own that uses the student number.</br>
	 </br>

2. Create a Card class with a name, suit.</br>
		Implement the Comparable interface.</br>
		Create getters and setters as well as override the toString method with the format "_name_ of _suit_"</br>
		Override the compareTo method with your own.  compareTo should return a negative number if the card is earlier in new deck order (Ace->King, Hearts->Clubs->Diamonds->Spades), 0 if they are the same and a positive number if they are later in new deck order.
