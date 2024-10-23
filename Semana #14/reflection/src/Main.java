import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give the name of a class and the method you want to use within the class, as well as the parameters.");
        System.out.println("Class.method parameters | Example: Cat.meow / Dog.feed chicken");
        System.out.println("Now enter your own command: ");
        String command = sc.nextLine();
        String[] data1 = command.split("\\.");
        String[] data2 = data1[1].split(" ");
        String className = data1[0];
        String methodName = data1[1].split(" ")[0];
        String parameter = null;
        if (data2.length != 1) {
            parameter = data2[1];
        }

        Class<?> newClass = Class.forName("models." + className);
        Constructor<?> constructor = newClass.getDeclaredConstructor();
        Object newObject = constructor.newInstance();
        Method[] newObjectMethods = newObject.getClass().getDeclaredMethods();
        for (Method newObjectMethod : newObjectMethods) {
            if (newObjectMethod.getName().equals(methodName)) {
                if (newObjectMethod.getParameterCount() != 0) {
                    if (parameter == null) {
                        System.out.println("This function needs a parameter.");
                    } else if (newObjectMethod.getParameterTypes()[0] == int.class) {
                        if (!isInt(parameter)) {
                            System.out.println("This function needs an integer parameter.");
                        } else {
                            int intParameter = Integer.parseInt(parameter);
                            Method newMethod = newObject.getClass().getDeclaredMethod(methodName, int.class);
                            newMethod.setAccessible(true);
                            newMethod.invoke(newObject, intParameter);
                        }
                    } else if (newObjectMethod.getParameterTypes()[0] == String.class) {
                        Method newMethod = newObject.getClass().getDeclaredMethod(methodName, String.class);
                        newMethod.setAccessible(true);
                        newMethod.invoke(newObject, parameter);
                    }
                }
                else {
                    Method newMethod = newObject.getClass().getDeclaredMethod(methodName);
                    newMethod.setAccessible(true);
                    newMethod.invoke(newObject);
                }
            }
        }
    }

    public static boolean isInt(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     Class <?> PersonClass = Class.forName("models.Person");
     Constructor<?> constructor1 = PersonClass.getDeclaredConstructor();
     Constructor<?> constructor2 = PersonClass.getDeclaredConstructor(String.class, int.class);
     Object myPerson = constructor2.newInstance("Belén", 18);
     System.out.println(myPerson);
     Method greet = PersonClass.getDeclaredMethod("greetOtherPerson", String.class);
     greet.setAccessible(true);
     greet.invoke(null, "Andres");
     **/


    public static void getFieldsAndMethods() {
        /***
         Person myPerson = new Person("Belén", 18);
         Field[] myPersonFields = myPerson.getClass().getDeclaredFields();
         for (Field myPersonField : myPersonFields) {
         System.out.println(myPersonField.getName());
         if (myPersonField.getName().equals("age")) {
         myPersonField.setAccessible(true);
         System.out.println(myPersonField.get(myPerson));
            }
         }

         Method[] myPersonMethods = myPerson.getClass().getDeclaredMethods();
         for (Method myPersonMethod : myPersonMethods) {
             if (myPersonMethod.getName().equals("greet")) {
                 System.out.println(myPersonMethod.getName());
                 myPersonMethod.setAccessible(true);
                 myPersonMethod.invoke(myPerson);
            }
         }
         Method greetOtherPersonMethod = myPerson.getClass().getDeclaredMethod("greetOtherPerson", String.class);
         greetOtherPersonMethod.setAccessible(true);
         greetOtherPersonMethod.invoke(null, "Jonathan");
         ***/

    }
}