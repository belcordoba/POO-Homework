package Exercise;

import java.util.Scanner;

public class Exercises {
    public void buildPyramid() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número: ");
        String s = sc.nextLine();
        int num = Integer.parseInt(s);
        for (int i = 1; i <= num; i++) {
            System.out.print(".");
            for (int o = i; o < num; o++) {
                System.out.print(" ");
            }
            for (int a = num; a > num - i; a--) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }

    public void checkIfPangram() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una cadena de texto: ");
        String cadena = sc.nextLine();
        cadena = cadena.toLowerCase();
        boolean esPangrama = true;
        boolean letraEncontrada = false;
        char[] abecedario = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (char c : abecedario){
            for (int i = 0 ; i != cadena.length() ; i++){
                letraEncontrada = false;
                char l = cadena.charAt(i);
                if (l == c) {
                    letraEncontrada = true;
                    break;
                }
            }
            if (!letraEncontrada){
                esPangrama = false;
                break;
            }
        }

        if (esPangrama) {
            System.out.println("La cadena ingresada es un pangrama.");
        } else {
            System.out.println("La cadena ingresada NO es un pangrama.");
        }
    }
}