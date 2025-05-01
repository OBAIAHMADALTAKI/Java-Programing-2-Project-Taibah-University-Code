package FirstStage;

import java.math.*;
import java.util.Scanner;

public class Test  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AllOperations ops = new AllOperations();

        while (true) {
            System.out.println("Choose a data type:");
            System.out.println("1. Byte\n2. Short\n3. Integer\n4. Long\n5. Float\n6. Double");
            System.out.println("7. BigInteger\n8. BigDecimal\n9. Character\n10. String");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            int typeChoice = scanner.nextInt();
            scanner.nextLine();

            if (typeChoice == 0) {
                System.out.println("Program terminated.");
                break;
            }

            while (true) {
                System.out.println("\nChoose an operation:");
                System.out.println("1. Insert\n2. Delete (under development)\n3. Traverse (under development)\n0. Back to type selection");
                System.out.print("Your choice: ");
                int opChoice = scanner.nextInt();
                scanner.nextLine();

                if (opChoice == 0) break;

                if (opChoice == 1) {
                    while (true) {
                        ops.PrintList();
                        int insertChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (insertChoice == 0) break;

                        String result = "";
                        String value;
                        switch (insertChoice) {
                            case 1:
                                System.out.print("Enter value to insert at the end: ");
                                value = scanner.nextLine();
                                result = ops.insertLast(value);
                                break;
                            case 2:
                                System.out.print("Enter value to insert before the last: ");
                                value = scanner.nextLine();
                                result = ops.insertBeforeLast(value);
                                break;
                            case 3:
                                System.out.print("Enter value to surround the last word: ");
                                value = scanner.nextLine();
                                result = ops.insertBeforeAndAfterLast(value);
                                break;
                            case 4:
                                System.out.print("Enter value to insert at the beginning: ");
                                value = scanner.nextLine();
                                result = ops.insertFirst(value);
                                break;
                            case 5:
                                System.out.print("Enter value to insert after the first: ");
                                value = scanner.nextLine();
                                result = ops.insertAfterFirst(value);
                                break;
                            case 6:
                                System.out.print("Enter value to surround the first word: ");
                                value = scanner.nextLine();
                                result = ops.insertBeforeAndAfterFirst(value);
                                break;
                            case 7:
                                System.out.print("Enter the target element: ");
                                String target7 = scanner.nextLine();
                                System.out.print("Enter value to insert after it: ");
                                value = scanner.nextLine();
                                result = ops.insertAfterElement(target7, value);
                                break;
                            case 8:
                                System.out.print("Enter the target element (all occurrences): ");
                                String target8 = scanner.nextLine();
                                System.out.print("Enter value to insert after it: ");
                                value = scanner.nextLine();
                                result = ops.insertAfterAllElement(target8, value);
                                break;
                            case 9:
                                System.out.print("Enter the target element: ");
                                String target9 = scanner.nextLine();
                                System.out.print("Enter value to insert before it: ");
                                value = scanner.nextLine();
                                result = ops.insertBeforeElement(target9, value);
                                break;
                            case 10:
                                System.out.print("Enter the target element (all occurrences): ");
                                String target10 = scanner.nextLine();
                                System.out.print("Enter value to insert before it: ");
                                value = scanner.nextLine();
                                result = ops.insertBeforeAllElement(target10, value);
                                break;
                            case 11:
                                System.out.print("Enter the element to surround (first occurrence): ");
                                String target11 = scanner.nextLine();
                                System.out.print("Enter value to surround with: ");
                                value = scanner.nextLine();
                                result = ops.insertBeforeAndAfterElement(target11, value);
                                break;
                            case 12:
                                System.out.print("Enter the element to surround (all occurrences): ");
                                String target12 = scanner.nextLine();
                                System.out.print("Enter value to surround with: ");
                                value = scanner.nextLine();
                                result = ops.insertBeforeAndAfterAllElement(target12, value);
                                break;
                            case 13:
                                System.out.print("Enter index from the start: ");
                                int index13 = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Enter value to insert: ");
                                value = scanner.nextLine();
                                result = ops.insertElementWithStartingFirstIndex(index13, value);
                                break;
                            case 14:
                                System.out.print("Enter index from the end: ");
                                int index14 = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Enter value to insert: ");
                                value = scanner.nextLine();
                                result = ops.insertElementWithStartingLastIndex(index14, value);
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                continue;
                        }

                        System.out.println("Current text: " + result);
                    }
                } else {
                    System.out.println("These operations are not implemented yet.");
                }
            }
        }

        scanner.close();
    }

    public static Object getValueByTypeChoice(int choice, Scanner scanner) {
        try {
            switch (choice) {
                case 1: System.out.print("Enter a Byte value: "); return Byte.valueOf(scanner.nextLine());
                case 2: System.out.print("Enter a Short value: "); return Short.valueOf(scanner.nextLine());
                case 3: System.out.print("Enter an Integer value: "); return Integer.valueOf(scanner.nextLine());
                case 4: System.out.print("Enter a Long value: "); return Long.valueOf(scanner.nextLine());
                case 5: System.out.print("Enter a Float value: "); return Float.valueOf(scanner.nextLine());
                case 6: System.out.print("Enter a Double value: "); return Double.valueOf(scanner.nextLine());
                case 7: System.out.print("Enter a BigInteger value: "); return new BigInteger(scanner.nextLine());
                case 8: System.out.print("Enter a BigDecimal value: "); return new BigDecimal(scanner.nextLine());
                case 9: System.out.print("Enter a single character: "); return scanner.nextLine().charAt(0);
                case 10: System.out.print("Enter a String: "); return scanner.nextLine();
                default: System.out.println("Invalid choice."); return null;
            }
        } catch (Exception e) {
            System.out.println("Input error: " + e.getMessage());
            return null;
        }
    }
}
