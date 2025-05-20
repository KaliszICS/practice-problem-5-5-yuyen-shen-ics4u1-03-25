import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class StudentTest {

    @Test
    public void testStudentClassExists() {
        try {
            Class<?> studentClass = Class.forName("Student");
            assertTrue(true, "Student class exists");
        } catch (ClassNotFoundException e) {
            fail("Student class does not exist");
        }
    }

    @Test
    public void testStudentImplementsComparable() {
        try {
            Class<?> studentClass = Class.forName("Student");
            boolean implementsComparable = Arrays.stream(studentClass.getInterfaces())
                    .anyMatch(iface -> iface.equals(Comparable.class));
            assertTrue(implementsComparable, "Student class implements Comparable");
        } catch (ClassNotFoundException e) {
            fail("Student class does not exist");
        }
    }

    @Test
    public void testStudentConstructor() {
        try {
            Class<?> studentClass = Class.forName("Student");
            Constructor<?> constructor = studentClass.getDeclaredConstructor(String.class, int.class, String.class);
            assertNotNull(constructor, "Student has constructor with name, age, and student number parameters");
        } catch (ClassNotFoundException e) {
            fail("Student class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Student class does not have required constructor with name, age, and student number parameters");
        }
    }

    @Test
    public void testStudentGettersAndSetters() {
        try {
            Class<?> studentClass = Class.forName("Student");
            
            // Test name getter and setter
            Method getNameMethod = studentClass.getDeclaredMethod("getName");
            Method setNameMethod = studentClass.getDeclaredMethod("setName", String.class);
            assertEquals(String.class, getNameMethod.getReturnType(), "getName should return String");
            assertEquals(void.class, setNameMethod.getReturnType(), "setName should return void");
            
            // Test age getter and setter
            Method getAgeMethod = studentClass.getDeclaredMethod("getAge");
            Method setAgeMethod = studentClass.getDeclaredMethod("setAge", int.class);
            assertEquals(int.class, getAgeMethod.getReturnType(), "getAge should return int");
            assertEquals(void.class, setAgeMethod.getReturnType(), "setAge should return void");
            
            // Test student number getter and setter
            Method getStudentNumberMethod = studentClass.getDeclaredMethod("getStudentNumber");
            Method setStudentNumberMethod = studentClass.getDeclaredMethod("setStudentNumber", String.class);
            assertEquals(String.class, getStudentNumberMethod.getReturnType(), "getStudentNumber should return String");
            assertEquals(void.class, setStudentNumberMethod.getReturnType(), "setStudentNumber should return void");
            
        } catch (ClassNotFoundException e) {
            fail("Student class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Student class is missing one or more getter or setter methods");
        }
    }

    @Test
    public void testStudentToString() {
        try {
            Class<?> studentClass = Class.forName("Student");
            
            // Test toString method exists and is overridden
            Method toStringMethod = studentClass.getDeclaredMethod("toString");
            assertEquals(String.class, toStringMethod.getReturnType(), "toString should return String");
            
            // Create a student instance using reflection
            Constructor<?> constructor = studentClass.getDeclaredConstructor(String.class, int.class, String.class);
            Object studentInstance = constructor.newInstance("John", 20, "12345");
            
            // Call toString and verify format
            String result = toStringMethod.invoke(studentInstance).toString();
            assertTrue(result.contains("N:John"), "toString should contain name in format 'N:name'");
            assertTrue(result.contains("A:20"), "toString should contain age in format 'A:age'");
            assertTrue(result.contains("SN:12345"), "toString should contain student number in format 'SN:studentNumber'");
            
        } catch (ClassNotFoundException e) {
            fail("Student class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Student class does not have toString method");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testStudentCompareTo() {
        try {
            Class<?> studentClass = Class.forName("Student");
            
            // Test compareTo method exists
            Method compareToMethod = studentClass.getDeclaredMethod("compareTo", Object.class);
            assertEquals(int.class, compareToMethod.getReturnType(), "compareTo should return int");
            
            // Create student instances using reflection
            Constructor<?> constructor = studentClass.getDeclaredConstructor(String.class, int.class, String.class);
            Object student1 = constructor.newInstance("John", 20, "12345");
            Object student2 = constructor.newInstance("Jane", 22, "12346");
            Object student3 = constructor.newInstance("Bob", 19, "12345");
            
            // Test comparison logic
            int result1 = (int) compareToMethod.invoke(student1, student2);
            int result2 = (int) compareToMethod.invoke(student2, student1);
            int result3 = (int) compareToMethod.invoke(student1, student3);
            
            assertTrue(result1 < 0, "Student with lower student number should come before");
            assertTrue(result2 > 0, "Student with higher student number should come after");
            assertEquals(0, result3, "Students with same student number should be equal");
            
        } catch (ClassNotFoundException e) {
            fail("Student class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Student class does not have compareTo method");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testStudentFunctionality() {
        try {
            Class<?> studentClass = Class.forName("Student");
            Constructor<?> constructor = studentClass.getDeclaredConstructor(String.class, int.class, String.class);
            
            // Create student instance
            Object student = constructor.newInstance("Alice", 21, "54321");
            
            // Test getters return expected values
            Method getNameMethod = studentClass.getDeclaredMethod("getName");
            Method getAgeMethod = studentClass.getDeclaredMethod("getAge");
            Method getStudentNumberMethod = studentClass.getDeclaredMethod("getStudentNumber");
            
            assertEquals("Alice", getNameMethod.invoke(student), "getName should return the name");
            assertEquals(21, getAgeMethod.invoke(student), "getAge should return the age");
            assertEquals("54321", getStudentNumberMethod.invoke(student), "getStudentNumber should return the student number");
            
            // Test setters update values
            Method setNameMethod = studentClass.getDeclaredMethod("setName", String.class);
            Method setAgeMethod = studentClass.getDeclaredMethod("setAge", int.class);
            Method setStudentNumberMethod = studentClass.getDeclaredMethod("setStudentNumber", String.class);
            
            setNameMethod.invoke(student, "Bob");
            setAgeMethod.invoke(student, 22);
            setStudentNumberMethod.invoke(student, "98765");
            
            assertEquals("Bob", getNameMethod.invoke(student), "Name should be updated after setName");
            assertEquals(22, getAgeMethod.invoke(student), "Age should be updated after setAge");
            assertEquals("98765", getStudentNumberMethod.invoke(student), "Student number should be updated after setStudentNumber");
            
        } catch (ClassNotFoundException e) {
            fail("Student class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Student class is missing required methods");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
