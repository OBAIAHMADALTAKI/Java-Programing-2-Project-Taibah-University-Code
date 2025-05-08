package stringupdatepackage;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AllOperations ops = new AllOperations();
        File WriteTheDate = new File("WriteTheDate.txt");
        File readTheStatistic = new File("ReadTheStatistic.txt");

        try {
            if (!WriteTheDate.exists()) WriteTheDate.createNewFile();
            if (!readTheStatistic.exists()) readTheStatistic.createNewFile();
        } catch (IOException e) {
            System.err.println("Error creating files: " + e.getMessage());
            return; // Exit if files can't be created
        }

        System.out.print("Enter your text: ");
        String input = scanner.nextLine();
        ops.setText(input);

        mainLoop:
        while (true) {
            try {
                System.out.println("\nChoose an operation category:");
                System.out.println("1. Adding Operations");
                System.out.println("2. Deleting Operations");
                System.out.println("3. Printing Operations");
                System.out.println("4. Traversal Operations");
                System.out.println("0. Exit and show file info");
                System.out.print("Your choice: ");
                
                int opCat;
                try {
                    opCat = scanner.nextInt();
                } catch (InputMismatchException e) {
                    scanner.nextLine(); // Clear the invalid input
                    System.err.println("Error: Please enter a valid number.");
                    continue;
                }
                scanner.nextLine(); // Clean buffer

                if (opCat == 0) break mainLoop;

                switch (opCat) {
                    case 1:
                        handleAddingOperations(scanner, ops);
                        break;
                    case 2:
                        handleDeletingOperations(scanner, ops);
                        break;
                    case 3:
                        handlePrintingOperations(scanner, ops);
                        break;
                    case 4:
                        handleTraversalOperations(scanner, ops);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operation category: " + opCat);
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
        
        try {
            displayFileProperties(WriteTheDate);
            displayFileProperties(readTheStatistic);
            System.out.println("");
            ops.writeFile(WriteTheDate);
            System.out.println("");
            ops.readFile(readTheStatistic);
        } catch (IOException e) {
            System.err.println("Error handling files: " + e.getMessage());
        } finally {
            System.out.println("\nClosing resources...");
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner closed successfully.");
            }
            System.out.println("Program terminated.");
        }
    }

    private static void handleAddingOperations(Scanner scanner, AllOperations ops) {
        System.out.println("\nAddition operations:");
        System.out.println("1. insertLast\n2. insertBeforeLast\n3. insertBeforeAndAfterLast\n4. insertFirst\n5. insertAfterFirst\n6. insertBeforeAndAfterFirst\n7. insertAfterElement\n8. insertAfterAllElement\n9. insertBeforeElement\n10. insertBeforeAllElement\n11. insertBeforeAndAfterElement\n12. insertBeforeAndAfterAllElement\n13. insertElementWithStartingFirstIndex\n14. insertElementWithStartingLastIndex");
        System.out.println("0. Back to operation category");
        System.out.print("Your choice: ");
        
        int addOp;
        try {
            addOp = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear the invalid input
            System.err.println("Error: Please enter a valid number.");
            return;
        }
        scanner.nextLine();
        
        if (addOp == 0) return;
        
        System.out.print("Enter text to insert: ");
        String ins = scanner.nextLine();
        
        try {
            switch (addOp) {
                case 1: System.out.println("Result: " + ops.insertLast(ins)); break;
                case 2: System.out.println("Result: " + ops.insertBeforeLast(ins)); break;
                case 3: System.out.println("Result: " + ops.insertBeforeAndAfterLast(ins)); break;
                case 4: System.out.println("Result: " + ops.insertFirst(ins)); break;
                case 5: System.out.println("Result: " + ops.insertAfterFirst(ins)); break;
                case 6: System.out.println("Result: " + ops.insertBeforeAndAfterFirst(ins)); break;
                case 7: 
                    System.out.print("Enter the Element you want to add After first Element: ");
                    String el1 = scanner.nextLine();
                    if (el1.isEmpty()) {
                        throw new IllegalArgumentException("Element cannot be empty");
                    }
                    System.out.println("Result: " + ops.insertAfterElement(el1, ins)); 
                    break;
                case 8:
                    System.out.print("Enter the Element you want to add after all similar Element: ");
                    String el2 = scanner.nextLine();
                    System.out.println("Result: " + ops.insertAfterAllElement(el2, ins)); 
                    break;
                case 9:
                    System.out.print("Enter the Element you want to add before first Element: ");
                    String el3 = scanner.nextLine();
                    System.out.println("Result: " + ops.insertBeforeElement(el3, ins)); 
                    break;
                case 10:
                    System.out.print("Enter the Element you want to add before all similar Element: ");
                    String el4 = scanner.nextLine();
                    System.out.println("Result: " + ops.insertBeforeAllElement(el4, ins)); 
                    break;
                case 11:
                    System.out.print("Enter the Element you want to add before and after similar Element: ");
                    String el5 = scanner.nextLine();
                    System.out.println("Result: " + ops.insertBeforeAndAfterElement(el5, ins)); 
                    break;
                case 12:
                    System.out.print("Enter the Element you want to add before and after All similar Element: ");
                    String el6 = scanner.nextLine();
                    System.out.println("Result: " + ops.insertBeforeAndAfterAllElement(el6, ins)); 
                    break;
                case 13:
                    System.out.print("Enter the Element you want to add with Starting First index: ");
                    int in1;
                    try {
                        in1 = scanner.nextInt();
                        if (in1 < 0) {
                            throw new IndexOutOfBoundsException("Index cannot be negative");
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // Clear the invalid input
                        throw new IllegalArgumentException("Please enter a valid number");
                    }
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Result: " + ops.insertElementWithStartingFirstIndex(in1, ins)); 
                    break;
                case 14:
                    System.out.print("Enter the Element you want to add with Starting Last index: ");
                    int in2;
                    try {
                        in2 = scanner.nextInt();
                        if (in2 < 0) {
                            throw new IndexOutOfBoundsException("Index cannot be negative");
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // Clear the invalid input
                        throw new IllegalArgumentException("Please enter a valid number");
                    }
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Result: " + ops.insertElementWithStartingLastIndex(in2, ins)); 
                    break;
                default: throw new IllegalArgumentException("Invalid addition operation: " + addOp);
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error: Index out of bounds - " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error during addition operation: " + e.getMessage());
        }
    }

    private static void handleDeletingOperations(Scanner scanner, AllOperations ops) {
        System.out.println("\nDeletion operations:");
        System.out.println("1. deleteFirstChar\n2. deleteLastChar\n3. deleteAll\n4. deleteElement");
        System.out.println("5. deleteAfterFirstChar\n6. deleteAllAfterFirstChar\n7. deleteBeforeLastChar");
        System.out.println("8. deleteAllBeforeLastChar\n9. deleteAllElement\n10. deleteAfterElement");
        System.out.println("11. deleteAfterAllElement\n12. deleteAllAfterElement\n13. deleteBeforeElement");
        System.out.println("14. deleteBeforeAllElement\n15. deleteAllBeforeElement\n16. deleteBeforeAndAfterElement");
        System.out.println("17. deleteBeforeAndAfterAllElement\n18. deleteCharWithStartingFirstIndex\n19. deleteCharWithLastIndex");
        System.out.println("20. deleteCharWithAnyIndex\n21. deleteStartsIndexToLast\n22. deleteStartsCharToChar");
        System.out.println("23. deleteAllDigits\n24. deleteAllLetters\n25. deleteAllCharExceptDigitsAndLetters");
        System.out.println("0. Back to operation category");
        System.out.print("Your choice: ");
        
        int delOp;
        try {
            delOp = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear the invalid input
            System.err.println("Error: Please enter a valid number.");
            return;
        }
        scanner.nextLine();
        
        if (delOp == 0) return;
        
        try {
            switch (delOp) {
                case 1: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot delete first character");
                    }
                    System.out.println("Result: " + ops.deleteFirstChar()); 
                    break;
                case 2: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot delete last character");
                    }
                    System.out.println("Result: " + ops.deleteLastChar()); 
                    break;
                case 3: 
                    System.out.println("Result: " + ops.deleteAll()); 
                    break;
                case 4:
                    System.out.print("Enter element to delete: ");
                    String toDel = scanner.nextLine();
                    if (!ops.getText().contains(toDel)) {
                        throw new NoSuchElementException("Element not found in text");
                    }
                    System.out.println("Result: " + ops.deleteElement(toDel));
                    break;
                case 5:
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot delete after first character");
                    }
                    System.out.println("Result: " + ops.deleteAfterFirstChar());
                    break;
                case 6:
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot delete all after first character");
                    }
                    System.out.println("Result: " + ops.deleteAllAfterFirstChar());
                    break;
                case 7:
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot delete before last character");
                    }
                    System.out.println("Result: " + ops.deleteBeforeLastChar());
                    break;
                case 8:
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot delete all before last character");
                    }
                    System.out.println("Result: " + ops.deleteAllBeforeLastChar());
                    break;
                case 9:
                    System.out.print("Enter element to delete all occurrences: ");
                    String toDelAll = scanner.nextLine();
                    System.out.println("Result: " + ops.deleteAllElement(toDelAll));
                    break;
                case 10:
                    System.out.print("Enter element: ");
                    String elem = scanner.nextLine();
                    System.out.println("Result: " + ops.deleteAfterElement(elem));
                    break;
                case 11:
                    System.out.print("Enter element: ");
                    String elemAll = scanner.nextLine();
                    System.out.println("Result: " + ops.deleteAfterAllElement(elemAll));
                    break;
                case 12:
                    System.out.print("Enter element: ");
                    String elemAllAfter = scanner.nextLine();
                    System.out.println("Result: " + ops.deleteAllAfterElement(elemAllAfter));
                    break;
                case 13:
                    System.out.print("Enter element: ");
                    String elemBefore = scanner.nextLine();
                    System.out.println("Result: " + ops.deleteBeforeElement(elemBefore));
                    break;
                case 14:
                    System.out.print("Enter element: ");
                    String elemBeforeAll = scanner.nextLine();
                    System.out.println("Result: " + ops.deleteBeforeAllElement(elemBeforeAll));
                    break;
                case 15:
                    System.out.print("Enter element: ");
                    String elemAllBefore = scanner.nextLine();
                    System.out.println("Result: " + ops.deleteAllBeforeElement(elemAllBefore));
                    break;
                case 16:
                    System.out.print("Enter element: ");
                    String elemBeforeAfter = scanner.nextLine();
                    System.out.println("Result: " + ops.deleteBeforeAndAfterElement(elemBeforeAfter));
                    break;
                case 17:
                    System.out.print("Enter element: ");
                    String elemBeforeAfterAll = scanner.nextLine();
                    System.out.println("Result: " + ops.deleteBeforeAndAfterAllElement(elemBeforeAfterAll));
                    break;
                case 18:
                    System.out.print("Enter index: ");
                    int firstIndex;
                    try {
                        firstIndex = scanner.nextInt();
                        if (firstIndex < 0 || firstIndex >= ops.getText().length()) {
                            throw new IndexOutOfBoundsException("Index out of range: " + firstIndex);
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // Clear the invalid input
                        throw new IllegalArgumentException("Please enter a valid number");
                    }
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Result: " + ops.DeleteCharWithStartingFirstIndex(firstIndex));
                    break;
                case 19:
                    System.out.print("Enter index: ");
                    int lastIndex;
                    try {
                        lastIndex = scanner.nextInt();
                        if (lastIndex < 0 || lastIndex >= ops.getText().length()) {
                            throw new IndexOutOfBoundsException("Index out of range: " + lastIndex);
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // Clear the invalid input
                        throw new IllegalArgumentException("Please enter a valid number");
                    }
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Result: " + ops.deleteCharWithLastIndex(lastIndex));
                    break;
                case 20:
                    System.out.print("Enter index: ");
                    int anyIndex;
                    try {
                        anyIndex = scanner.nextInt();
                        if (anyIndex < 0 || anyIndex >= ops.getText().length()) {
                            throw new IndexOutOfBoundsException("Index out of range: " + anyIndex);
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // Clear the invalid input
                        throw new IllegalArgumentException("Please enter a valid number");
                    }
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Result: " + ops.deleteCharWithAnyIndex(anyIndex));
                    break;
                case 21:
                    System.out.print("Enter start index: ");
                    int startIndex;
                    int endIndex;
                    try {
                        startIndex = scanner.nextInt();
                        System.out.print("Enter end index: ");
                        endIndex = scanner.nextInt();
                        
                        if (startIndex < 0 || startIndex >= ops.getText().length() ||
                            endIndex < 0 || endIndex >= ops.getText().length() ||
                            startIndex > endIndex) {
                            throw new IndexOutOfBoundsException("Invalid index range: " + startIndex + " to " + endIndex);
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // Clear the invalid input
                        throw new IllegalArgumentException("Please enter valid numbers");
                    }
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Result: " + ops.deleteStartsIndexToLast(startIndex, endIndex));
                    break;
                case 22:
                    System.out.print("Enter first character: ");
                    char c1;
                    char c2;
                    try {
                        c1 = scanner.nextLine().charAt(0);
                        System.out.print("Enter second character: ");
                        c2 = scanner.nextLine().charAt(0);
                    } catch (StringIndexOutOfBoundsException e) {
                        throw new IllegalArgumentException("Please enter valid characters");
                    }
                    System.out.println("Result: " + ops.deleteStartsCharToChar(c1, c2));
                    break;
                case 23:
                    System.out.println("Result: " + ops.deleteAllDigits());
                    break;
                case 24:
                    System.out.println("Result: " + ops.deleteAllLetters());
                    break;
                case 25:
                    System.out.println("Result: " + ops.deleteAllCharExceptDigitsAndLetters());
                    break;
                default: 
                    throw new IllegalArgumentException("Invalid deletion operation: " + delOp);
            }
        } catch (NoSuchElementException e) {
            System.err.println("Warning: " + e.getMessage());
        } catch (IllegalStateException | IllegalArgumentException | IndexOutOfBoundsException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error during deletion operation: " + e.getMessage());
        }
    }

    private static void handlePrintingOperations(Scanner scanner, AllOperations ops) {
        System.out.println("\nPrint operations:");
        System.out.println("1. printFirstLetter\n2. printLastLetter\n3. printFirstWord\n4. printLastWord");
        System.out.println("5. printFirstSentence\n6. printLastSentence\n7. printSize\n8. printCapacity");
        System.out.println("9. printChar\n10. printElement");
        System.out.println("11. printIndexOfFirst\n12. printIndexOfLast\n13. printIndexOfAll");
        System.out.println("0. Back to operation category");
        System.out.print("Your choice: ");
        
        int prOp;
        try {
            prOp = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear the invalid input
            System.err.println("Error: Please enter a valid number.");
            return;
        }
        scanner.nextLine();
        
        if (prOp == 0) return;
        
        try {
            switch (prOp) {
                case 1: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot print first letter");
                    }
                    System.out.println("Result: " + ops.printFirstLetter()); 
                    break;
                case 2: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot print last letter");
                    }
                    System.out.println("Result: " + ops.printLastLetter()); 
                    break;
                case 3: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot print first word");
                    }
                    System.out.println("Result: " + ops.printFirstWord()); 
                    break;
                case 4: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot print last word");
                    }
                    System.out.println("Result: " + ops.printLastWord()); 
                    break;
                case 5: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot print first sentence");
                    }
                    System.out.println("Result: " + ops.printFirstSentence()); 
                    break;
                case 6: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot print last sentence");
                    }
                    System.out.println("Result: " + ops.printLastSentence()); 
                    break;
                case 7: System.out.println("Result: " + ops.printSize()); break;
                case 8: System.out.println("Result: " + ops.printCapacity()); break;
                case 9:
                    System.out.print("Enter index: ");
                    int idx;
                    try {
                        idx = scanner.nextInt();
                        if (idx < 0 || idx >= ops.getText().length()) {
                            throw new IndexOutOfBoundsException("Index out of range: " + idx);
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // Clear the invalid input
                        throw new IllegalArgumentException("Please enter a valid number");
                    }
                    scanner.nextLine();
                    System.out.println("Result: " + ops.printChar(idx));
                    break;
                case 10:
                    System.out.print("Enter start index: ");
                    int startIdx;
                    int endIdx;
                    try {
                        startIdx = scanner.nextInt();
                        System.out.print("Enter end index: ");
                        endIdx = scanner.nextInt();
                        
                        if (startIdx < 0 || startIdx >= ops.getText().length() ||
                            endIdx < 0 || endIdx >= ops.getText().length() ||
                            startIdx > endIdx) {
                            throw new IndexOutOfBoundsException("Invalid index range: " + startIdx + " to " + endIdx);
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // Clear the invalid input
                        throw new IllegalArgumentException("Please enter valid numbers");
                    }
                    scanner.nextLine();
                    System.out.println("Result: " + ops.PrintElement(startIdx, endIdx));
                    break;
                case 11:
                    System.out.print("Enter element: ");
                    String e1 = scanner.nextLine();
                    System.out.println("Result: " + ops.printIndexOfFirstElement(e1));
                    break;
                case 12:
                    System.out.print("Enter element: ");
                    String e2 = scanner.nextLine();
                    System.out.println("Result: " + ops.printIndexOfLastElement(e2));
                    break;
                case 13:
                    System.out.print("Enter element: ");
                    String e3 = scanner.nextLine();
                    int[] arr = ops.printIndexOfAllElement(e3);
                    System.out.println("Result: " + Arrays.toString(arr));
                    break;
                default: throw new IllegalArgumentException("Invalid print operation: " + prOp);
            }
        } catch (IllegalStateException | IllegalArgumentException | IndexOutOfBoundsException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error during print operation: " + e.getMessage());
        }
    }

    private static void handleTraversalOperations(Scanner scanner, AllOperations ops) {
        System.out.println("\nTraversal operations:");
        System.out.println("1. convertWordsToArray\n2. convertLettersToArray\n3. shuffleWords\n4. shuffleLetters");
        System.out.println("5. reverse\n6. sortLettersAsc\n7. sortLettersDesc\n8. search");
        System.out.println("9. updateElementWithIndex\n10. updateElementWithNewValue\n11. updateAllElementWithNewValue\n12. Sum");
        System.out.println("0. Back to operation category");
        System.out.print("Your choice: ");
        
        int travOp;
        try {
            travOp = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear the invalid input
            System.err.println("Error: Please enter a valid number.");
            return;
        }
        scanner.nextLine();
        
        if (travOp == 0) return;
        
        try {
            switch (travOp) {
                case 1: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot convert to words array");
                    }
                    String[] words = ops.convertWordsToArray();
                    System.out.println("Result: " + Arrays.toString(words)); 
                    break;
                case 2: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot convert to letters array");
                    }
                    char[] letters = ops.convertLettersToArray();
                    System.out.println("Result: " + Arrays.toString(letters)); 
                    break;
                case 3: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot shuffle words");
                    }
                    System.out.println("Result: " + ops.shuffleWords()); 
                    break;
                case 4: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot shuffle letters");
                    }
                    System.out.println("Result: " + ops.shuffleLetters()); 
                    break;
                case 5: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot reverse");
                    }
                    System.out.println("Result: " + ops.reverse()); 
                    break;
                case 6: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot sort letters");
                    }
                    System.out.println("Result: " + ops.sortLettersAsc()); 
                    break;
                case 7: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot sort letters");
                    }
                    System.out.println("Result: " + ops.sortLettersDesc()); 
                    break;
                case 8:
                    System.out.print("Enter substring to search: ");
                    String sub = scanner.nextLine();
                    System.out.println("Found? " + ops.search(sub));
                    break;
                case 9:
                    System.out.print("Enter start index: ");
                    int start;
                    int end;
                    try {
                        start = scanner.nextInt();
                        System.out.print("Enter end index: ");
                        end = scanner.nextInt();
                        
                        if (start < 0 || start >= ops.getText().length() ||
                            end < 0 || end >= ops.getText().length() ||
                            start > end) {
                            throw new IndexOutOfBoundsException("Invalid index range: " + start + " to " + end);
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // Clear the invalid input
                        throw new IllegalArgumentException("Please enter valid numbers");
                    }
                    scanner.nextLine(); // Clear buffer
                    
                    System.out.print("Enter new element: ");
                    String newElement = scanner.nextLine();
                    
                    try {
                        ops.updateByIndex(start, end, newElement);
                        System.out.println("Updated successfully.");
                    } catch (Exception e) {
                        throw new RuntimeException("Update failed: " + e.getMessage());
                    }
                    break;
                case 10:
                    System.out.print("Enter old value: ");
                    String oldValue = scanner.nextLine();
                    System.out.print("Enter new value: ");
                    String newValue = scanner.nextLine();
                    boolean success = ops.updateFirst(oldValue, newValue);
                    if (success) {
                        System.out.println("First occurrence updated successfully.");
                    } else {
                        throw new NoSuchElementException("Value '" + oldValue + "' not found in text");
                    }
                    break;
                case 11:
                    System.out.print("Enter old value: ");
                    String oldVal = scanner.nextLine();
                    System.out.print("Enter new value: ");
                    String newVal = scanner.nextLine();
                   ops.updateAll(oldVal, newVal);
                    break;
                case 12:
                    System.out.print("Enter the First Number: ");
                    String input1 = scanner.nextLine();
                    
                    System.out.print("Enter the Second Number: ");
                    String input2 = scanner.nextLine();
                    
                    Number n1 = null;
                    Number n2 = null;
                    
                    try {
                        n1 = parseDynamicNumber(input1);
                        n2 = parseDynamicNumber(input2);
                        
                        if (n1 == null || n2 == null) {
                            throw new IllegalArgumentException("One of the inputs is not a valid number");
                        }
                        
                        Number result = ops.sum(n1, n2);
                        System.out.println("Result: " + result);
                    } catch (ArithmeticException e) {
                        System.err.println("Arithmetic error: " + e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.err.println("Input error: " + e.getMessage());
                    }
                    break;
                default: 
                    throw new IllegalArgumentException("Invalid traversal operation: " + travOp);
            }
        } catch (IllegalStateException | IllegalArgumentException | IndexOutOfBoundsException | NoSuchElementException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error during traversal operation: " + e.getMessage());
        }
    }

    private static void displayFileProperties(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        
        System.out.println("\n==== File Properties for " + file.getName() + " ====");
        System.out.println("- exists: " + file.exists());
        System.out.println("- canRead: " + file.canRead());
        System.out.println("- canWrite: " + file.canWrite());
        System.out.println("- isDirectory: " + file.isDirectory());
        System.out.println("- isFile: " + file.isFile());
        System.out.println("- isAbsolute: " + file.isAbsolute());
        System.out.println("- isHidden: " + file.isHidden());
        
        try {
            System.out.println("- getAbsolutePath: " + file.getAbsolutePath());
            System.out.println("- getCanonicalPath: " + file.getCanonicalPath());
        } catch (IOException e) {
            throw new IOException("Error getting canonical path: " + e.getMessage());
        }
        
        System.out.println("- getName: " + file.getName());
        System.out.println("- getPath: " + file.getPath());
        System.out.println("- getParent: " + (file.getParent() != null ? file.getParent() : "null"));
        
        Date lastModified = new Date(file.lastModified());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("- lastModified: " + sdf.format(lastModified));
        System.out.println("- length: " + file.length() + " bytes");
    }
    
    public static Number parseDynamicNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        
        try {
            if (input.contains(".")) {
                double d = Double.parseDouble(input);
                if (d <= Float.MAX_VALUE && d >= -Float.MAX_VALUE) {
                    return (float) d;
                } else {
                    return d;
                }
            } else {
                long l = Long.parseLong(input);
                if (l <= Byte.MAX_VALUE && l >= Byte.MIN_VALUE) {
                    return (byte) l;
                } else if (l <= Short.MAX_VALUE && l >= Short.MIN_VALUE) {
                    return (short) l;
                } else if (l <= Integer.MAX_VALUE && l >= Integer.MIN_VALUE) {
                    return (int) l;
                } else {
                    return l;
                }
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }
}