//
// Created by ozrenkosi on 25.04.2017..
//

import java.util.*;

public class Parser {

    private static List<String> inputString = new ArrayList<>();
    private static boolean parserOK;

    public static void main(String[] args) {

        dataInput();

        parseString_S();

        checkDefinition();

    }

    private static void dataInput() {
        String[] temporaryInput;

        Scanner reader = new Scanner(System.in);

        temporaryInput = reader.nextLine().split("");

        inputString.addAll(Arrays.asList(temporaryInput));

        reader.close();
    }

    private static void parseString_S() {
        parserOK = false;
        System.out.print("S");

        if (!inputString.isEmpty() && inputString.get(0).equals("b")) {
            inputString.remove(0);
            parseString_B();
            if (parserOK) {
                parseString_A();
            }
        }
        else if (!inputString.isEmpty() && inputString.get(0).equals("a")) {
            inputString.remove(0);
            parseString_A();
            if (parserOK) {
                parseString_B();
            }
        }
        else {
            parserOK = false;
        }
    }

    private static void parseString_A() {
        parserOK = false;
        System.out.print("A");

        if (!inputString.isEmpty() && inputString.get(0).equals("b")) {
            inputString.remove(0);
            parseString_C();
        }
        else if (!inputString.isEmpty() && inputString.get(0).equals("a")) {
            inputString.remove(0);
            parserOK = true;
        }
        else {
            parserOK = false;
        }
    }

    private static void parseString_B() {
        parserOK = false;
        System.out.print("B");

        if (inputString.isEmpty()) {
            parserOK = true;
        }
        else {
            parserOK = false;
            if (inputString.get(0).equals("c")) {
                inputString.remove(0);
                if (!inputString.isEmpty() && inputString.get(0).equals("c")) {
                    inputString.remove(0);
                    parseString_S();
                    if (parserOK && !inputString.isEmpty() && inputString.get(0).equals("b")) {
                        inputString.remove(0);
                        if (!inputString.isEmpty() && inputString.get(0).equals("c")) {
                            inputString.remove(0);
                            parserOK = true;
                        }
                        else {
                            parserOK = false;
                        }
                    }
                    else {
                        parserOK = false;
                    }
                }
                else {
                    parserOK = false;
                }
            }
            else {
                parserOK = true;
            }
        }
    }

    private static void parseString_C() {
        parserOK = false;
        System.out.print("C");

        parseString_A();
        if (parserOK) {
            parseString_A();
        }
    }

    private static void checkDefinition() {
        System.out.println();

        if (parserOK && inputString.isEmpty()) {
            System.out.println("DA");
        }
        else {
            System.out.println("NE");
        }
    }

}