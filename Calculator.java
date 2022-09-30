import java.util.ArrayList;
import java.util.Scanner;
import Girover.Color;

public class Calculator {

    static Scanner scanner = new Scanner(System.in);
    static double number1;
    static double number2;
    static String operator;
    static ArrayList<String> history = new ArrayList<String>();
    static int longestRow = 0;

    public static void main(String[] args) {

        scanner.useDelimiter(System.lineSeparator());
        start();
        do {
            number1 = getNumber("first"); // Get the first number typed by the user
            number2 = getNumber("second"); // Get the second number typed by the user
            getOperator(); // Get typed operator by the user.
            calculate();   // Start calculating the result

            System.out.println("\nType 'x' or 'X' to exit the program. Type any key to continue.");
            
            String input = scanner.next();

            if (input.equals("x") || input.equals("X")) {
                exit();
            }

        } while(true);
    }

    /**
     * This method shows welcome message
     * And shows which operations are allowed
     */
    static void start() {
        System.out.println("-".repeat(50));
        System.out.printf(Color.YELLOW+"%10s Welcome To Calculator Program%n"+Color.RESET, "");
        System.out.println("-".repeat(50));
        System.out.printf("%10s%n", "Available Operators");
        // System.out.println("-".repeat(50));
        System.out.printf(Color.BLUE+"   %d "+Color.RED+"+ "+Color.GREEN+"sum of two numbers%n"+Color.RESET,1);
        System.out.printf(Color.BLUE+"   %d "+Color.RED+"- "+Color.GREEN+"sub of two numbers%n"+Color.RESET,2);
        System.out.printf(Color.BLUE+"   %d "+Color.RED+"* "+Color.GREEN+"mul of two numbers%n"+Color.RESET,3);
        System.out.printf(Color.BLUE+"   %d "+Color.RED+"/ "+Color.GREEN+"div of two numbers%n"+Color.RESET,4);
        System.out.printf(Color.BLUE+"   %d "+Color.RED+"%% "+Color.GREEN+"mod of two numbers%n"+Color.RESET,5);
        System.out.printf(Color.BLUE+"   %d "+Color.RED+"^ "+Color.GREEN+"pow of two numbers%n"+Color.RESET,6);
        System.out.println("-".repeat(50));
    }

    /**
     * This method takes 2 double numbers 
     * and returns the summation of the two numbers.
     * @param double number1
     * @param double number2
     * @return double
     */
    static double sum(double number1, double number2){
        return number1 + number2;
    }

    /**
     * This method takes 2 double numbers 
     * and returns the subtraction of the two numbers.
     * @param double number1
     * @param double number2
     * @return double
     */
    static double sub(double number1, double number2){
        return number1 - number2;
    }

    /**
     * This method takes 2 double numbers 
     * and returns the multiplication of the two numbers.
     * @param double number1
     * @param double number2
     * @return double
     */
    static double mul(double number1, double number2){
        return number1 * number2;
    }

    /**
     * This method takes 2 double numbers 
     * and returns the division of the two numbers.
     * @param double number1
     * @param double number2
     * @return double
     */
    static double div(double number1, double number2) {
        
        return number1 / number2;
    }

    /**
     * This method takes 2 double numbers 
     * and returns the mod of the two numbers.
     * @param double number1
     * @param double number2
     * @return double
     */
    static double mod(double number1, double number2) {
        
        return number1 % number2;
    }

    /**
     * This method takes 2 double numbers 
     * and returns the power of number.
     * @param double number1
     * @param double number2
     * @return double
     */
    static double pow(double number1, double number2) {
        
        return Math.pow(number1, number2);
    }

    /**
     * This method gets the number that is typed by the user.
     * The user will be forced to type a valid double number, 
     * otherwise the while loop will not stop.
     * @param order
     * @return
     */
    static double getNumber(String order) {
        
        System.out.printf("Please type the"+Color.YELLOW+" %s "+Color.RESET+"number:%n", order);
        // The loop will not stop until the user type the first valid double number
        // When 'x' or 'X' is typed the program will terminate.
        while (true) {
            String inputNumber = scanner.next();
            try {
                Double number = Double.parseDouble(inputNumber);
                return number;
            } catch (Exception e) {

                if(inputNumber.equals("x")||inputNumber.equals("X")){
                    exit();
                }

                System.out.println("please type a valid double number\n");
            } 
        }
    }

    /**
     * This method assigns the operator that is typed by the user to the class field 'operator'.
     * The user will be forced to type a valid operator or 'x' or 'X', 
     *  otherwise the while loop will not stop.
     */
    static void getOperator(){
        // The loop will not stop until the user type a valid operator or [x or X] is typed
        do {
            System.out.println("Please type a valid "+Color.YELLOW+"operator\n "+Color.RESET+"Or type "+Color.RED+"X"+Color.RESET+" to exit the program");
            operator = scanner.next();
            if(operator.equals("x") || operator.equals("X")){
                break;
            }
        } while (!isValidOperator());
    }

    /**
     * This method validate the operator typed by the user.
     * @return boolean
     */
    static boolean isValidOperator() {
        switch (operator) {
            case "+", "-", "*", "/", "%", "^":
                return true;
        
            default:
                return false;
        }
    }

    /**
     * This method terminate the program
     */
    static void exit() {
        if (history.size() > 0) {
            printHistory();
        }
        System.out.println(Color.GREEN_BACKGROUND+" Thanks For Using "+Color.RED_BACKGROUND+" Calculator. "+Color.YELLOW_BACKGROUND+" Good Bay "+Color.RESET);
        System.exit(0);
    }


    /**
     * This method prints the result depending on the typed numbers and operator.
     * If 'x' or 'X' typed as operator the program exits without calculating.
     */
    static void calculate() {
        switch (operator) {
            case "+":
                print(sum(number1, number2));
                break;
            case "-":
                print(sub(number1, number2));
                break;
            case "*":
                print(mul(number1, number2));
                break;
                case "/":
                if(number2 == 0){
                    System.out.println("Ops. Cannot divide by zero");
                }
                print(div(number1, number2));
                break;
            case "%":
                print(mod(number1, number2));
                break;
            case "^":
                print(pow(number1, number2));
                break;
            default:
                exit();

        }
    }

    /**
     * This method prints the result
     * @param result
     */
    static void print(double result) {

        String format = String.format(Color.YELLOW+"   %.1f %s "+Color.YELLOW+"%.1f = "+Color.PURPLE+" %.1f%n"+Color.RESET, number1, operator, number2, result);
        history.add(format);
        longestRow = format.length()>longestRow ? format.length() : longestRow;

        System.out.println(Color.RED+"-".repeat(format.length())+Color.RESET);
        System.out.print(format);
        System.out.println(Color.RED+"-".repeat(format.length())+Color.RESET);
    }

    /**
     * This method prints all operations during a session of Calculator.
     */
    static void printHistory() {
        System.out.printf(Color.CYAN+"%-"+(longestRow/2-5)+"sHistory%-"+(longestRow/2-5)+"s%n"+Color.RESET, "","");
        System.out.println(Color.RED+"-".repeat(longestRow)+Color.RESET);
        int counter = 1;
        for (String format : history) {
            System.out.print(Color.BLUE+counter+Color.RESET+"  "+format);
            System.out.println(Color.RED+"-".repeat(longestRow)+Color.RESET);
            ++counter;
        }
    }

}
