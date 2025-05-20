import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CardTest {

    @Test
    public void testCardClassExists() {
        try {
            Class<?> cardClass = Class.forName("Card");
            assertTrue(true, "Card class exists");
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        }
    }

    @Test
    public void testCardImplementsComparable() {
        try {
            Class<?> cardClass = Class.forName("Card");
            boolean implementsComparable = Arrays.stream(cardClass.getInterfaces())
                    .anyMatch(iface -> iface.equals(Comparable.class));
            assertTrue(implementsComparable, "Card class implements Comparable");
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        }
    }

    @Test
    public void testCardConstructor() {
        try {
            Class<?> cardClass = Class.forName("Card");
            Constructor<?> constructor = cardClass.getDeclaredConstructor(String.class, String.class);
            assertNotNull(constructor, "Card has constructor with name and suit parameters");
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Card class does not have required constructor with name and suit parameters");
        }
    }

    @Test
    public void testCardGettersAndSetters() {
        try {
            Class<?> cardClass = Class.forName("Card");
            
            // Test name getter and setter
            Method getNameMethod = cardClass.getDeclaredMethod("getName");
            Method setNameMethod = cardClass.getDeclaredMethod("setName", String.class);
            assertEquals(String.class, getNameMethod.getReturnType(), "getName should return String");
            assertEquals(void.class, setNameMethod.getReturnType(), "setName should return void");
            
            // Test suit getter and setter
            Method getSuitMethod = cardClass.getDeclaredMethod("getSuit");
            Method setSuitMethod = cardClass.getDeclaredMethod("setSuit", String.class);
            assertEquals(String.class, getSuitMethod.getReturnType(), "getSuit should return String");
            assertEquals(void.class, setSuitMethod.getReturnType(), "setSuit should return void");
            
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Card class is missing one or more getter or setter methods");
        }
    }

    @Test
    public void testCardToString() {
        try {
            Class<?> cardClass = Class.forName("Card");
            
            // Test toString method exists and is overridden
            Method toStringMethod = cardClass.getDeclaredMethod("toString");
            assertEquals(String.class, toStringMethod.getReturnType(), "toString should return String");
            
            // Create a card instance using reflection
            Constructor<?> constructor = cardClass.getDeclaredConstructor(String.class, String.class);
            Object cardInstance = constructor.newInstance("Ace", "Hearts");
            
            // Call toString and verify format
            String result = toStringMethod.invoke(cardInstance).toString();
            assertEquals("Ace of Hearts", result, "toString should return 'name of suit' format");
            
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Card class does not have toString method");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testCardCompareToSameSuit() {
        try {
            Class<?> cardClass = Class.forName("Card");
            
            // Test compareTo method exists
            Method compareToMethod = cardClass.getDeclaredMethod("compareTo", Object.class);
            assertEquals(int.class, compareToMethod.getReturnType(), "compareTo should return int");
            
            // Create card instances using reflection (same suit, different names)
            Constructor<?> constructor = cardClass.getDeclaredConstructor(String.class, String.class);
            Object aceHearts = constructor.newInstance("Ace", "Hearts");
            Object kingHearts = constructor.newInstance("King", "Hearts");
            
            // Test comparison logic - Ace should come before King
            int result1 = (int) compareToMethod.invoke(aceHearts, kingHearts);
            int result2 = (int) compareToMethod.invoke(kingHearts, aceHearts);
            
            assertTrue(result1 < 0, "Ace should come before King");
            assertTrue(result2 > 0, "King should come after Ace");
            
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Card class does not have compareTo method");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testCardCompareToSameName() {
        try {
            Class<?> cardClass = Class.forName("Card");
            Method compareToMethod = cardClass.getDeclaredMethod("compareTo", Object.class);
            
            // Create card instances using reflection (same name, different suits)
            Constructor<?> constructor = cardClass.getDeclaredConstructor(String.class, String.class);
            Object aceHearts = constructor.newInstance("Ace", "Hearts");
            Object aceClubs = constructor.newInstance("Ace", "Clubs");
            Object aceDiamonds = constructor.newInstance("Ace", "Diamonds");
            Object aceSpades = constructor.newInstance("Ace", "Spades");
            
            // Test comparison logic - Hearts > Clubs > Diamonds > Spades
            int heartsVsClubs = (int) compareToMethod.invoke(aceHearts, aceClubs);
            int heartsVsDiamonds = (int) compareToMethod.invoke(aceHearts, aceDiamonds);
            int heartsVsSpades = (int) compareToMethod.invoke(aceHearts, aceSpades);
            
            int clubsVsDiamonds = (int) compareToMethod.invoke(aceClubs, aceDiamonds);
            int clubsVsSpades = (int) compareToMethod.invoke(aceClubs, aceSpades);
            
            int diamondsVsSpades = (int) compareToMethod.invoke(aceDiamonds, aceSpades);
            
            assertTrue(heartsVsClubs < 0, "Hearts should come before Clubs");
            assertTrue(heartsVsDiamonds < 0, "Hearts should come before Diamonds");
            assertTrue(heartsVsSpades < 0, "Hearts should come before Spades");
            
            assertTrue(clubsVsDiamonds < 0, "Clubs should come before Diamonds");
            assertTrue(clubsVsSpades < 0, "Clubs should come before Spades");
            
            assertTrue(diamondsVsSpades < 0, "Diamonds should come before Spades");
            
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Card class does not have compareTo method");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testCardCompareToEqual() {
        try {
            Class<?> cardClass = Class.forName("Card");
            Method compareToMethod = cardClass.getDeclaredMethod("compareTo", Object.class);
            
            // Create card instances using reflection (same name, same suit)
            Constructor<?> constructor = cardClass.getDeclaredConstructor(String.class, String.class);
            Object kingHearts1 = constructor.newInstance("King", "Hearts");
            Object kingHearts2 = constructor.newInstance("King", "Hearts");
            
            // Test equals comparison
            int result = (int) compareToMethod.invoke(kingHearts1, kingHearts2);
            assertEquals(0, result, "Cards with same name and suit should be equal");
            
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Card class does not have compareTo method");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testCardDifferentNamesAndSuits() {
        try {
            Class<?> cardClass = Class.forName("Card");
            Method compareToMethod = cardClass.getDeclaredMethod("compareTo", Object.class);
            
            // Create card instances using reflection (different names, different suits)
            Constructor<?> constructor = cardClass.getDeclaredConstructor(String.class, String.class);
            Object twoHearts = constructor.newInstance("2", "Hearts");
            Object kingSpades = constructor.newInstance("King", "Spades");
            
            // Test deck order - suit should take precedence over name
            int result = (int) compareToMethod.invoke(twoHearts, kingSpades);
            assertTrue(result < 0, "Hearts should come before Spades regardless of card name");
            
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Card class does not have compareTo method");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testCardFunctionality() {
        try {
            Class<?> cardClass = Class.forName("Card");
            Constructor<?> constructor = cardClass.getDeclaredConstructor(String.class, String.class);
            
            // Create card instance
            Object card = constructor.newInstance("Queen", "Diamonds");
            
            // Test getters return expected values
            Method getNameMethod = cardClass.getDeclaredMethod("getName");
            Method getSuitMethod = cardClass.getDeclaredMethod("getSuit");
            
            assertEquals("Queen", getNameMethod.invoke(card), "getName should return the name");
            assertEquals("Diamonds", getSuitMethod.invoke(card), "getSuit should return the suit");
            
            // Test setters update values
            Method setNameMethod = cardClass.getDeclaredMethod("setName", String.class);
            Method setSuitMethod = cardClass.getDeclaredMethod("setSuit", String.class);
            
            setNameMethod.invoke(card, "Jack");
            setSuitMethod.invoke(card, "Clubs");
            
            assertEquals("Jack", getNameMethod.invoke(card), "Name should be updated after setName");
            assertEquals("Clubs", getSuitMethod.invoke(card), "Suit should be updated after setSuit");
            
            // Test toString after update
            Method toStringMethod = cardClass.getDeclaredMethod("toString");
            assertEquals("Jack of Clubs", toStringMethod.invoke(card), "toString should reflect updated values");
            
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Card class is missing required methods");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
