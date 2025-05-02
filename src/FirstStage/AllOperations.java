package A;
import java.util.ArrayList;

public class AllOperations extends StringUpdate {
    private StringBuilder text = new StringBuilder(""); //Fill it if you want to test
    
    public String insertLast(String insert) {
        text.append(insert).append(" ");
        return text.toString().trim();
    }

    public String insertBeforeLast(String insert) {
        String[] words = text.toString().trim().split("\\s+");
        if (words.length == 0) return insert;

        int lastIndex = text.lastIndexOf(words[words.length - 1]);
        text.insert(lastIndex, insert + " ");
        return text.toString().trim();
    }

    public String insertBeforeAndAfterLast(String insert) {
        String[] words = text.toString().trim().split("\\s+");
        if (words.length == 0) return insert + insert;

        String lastWord = words[words.length - 1];
        int startIndex = text.lastIndexOf(lastWord);
        int endIndex = startIndex + lastWord.length();

        StringBuilder updated = new StringBuilder();
        updated.append(text.substring(0, startIndex));
        updated.append(insert).append(lastWord).append(insert);
        if (endIndex < text.length()) updated.append(text.substring(endIndex));

        text = updated;
        return text.toString().trim();
    }

    public String insertFirst(String insert) {
        text.insert(0, insert + " ");
        return text.toString().trim();
    }

    public String insertAfterFirst(String insert) {
        String[] words = text.toString().trim().split("\\s+");
        if (words.length == 0) return insert;

        int index = text.indexOf(words[0]) + words[0].length();
        text.insert(index, " " + insert);
        return text.toString().trim();
    }

    public String insertBeforeAndAfterFirst(String insert) {
        if (text.length() == 0) return "";

        String[] words = text.toString().trim().split("\\s+");
        if (words.length == 0) return text.toString();

        int firstWordStart = text.indexOf(words[0]);
        int firstWordEnd = firstWordStart + words[0].length();

        StringBuilder updated = new StringBuilder();
        updated.append(text.substring(0, firstWordStart));
        updated.append(insert).append(words[0]).append(insert);
        updated.append(text.substring(firstWordEnd));

        text = updated;
        return text.toString().trim();
    }

    public String insertAfterElement(String element, String insert) {
        int index = text.indexOf(element);
        if (index != -1) {
            text.insert(index + element.length(), " " + insert);
        }
        return text.toString().trim();
    }

    public String insertAfterAllElement(String element, String insert) {
        int index = 0;
        while ((index = text.indexOf(element, index)) != -1) {
            index += element.length();
            text.insert(index, " " + insert);
            index += insert.length() + 1;
        }
        return text.toString().trim();
    }

    public String insertBeforeElement(String element, String insert) {
        int index = text.indexOf(element);
        if (index != -1) {
            text.insert(index, insert + " ");
        }
        return text.toString().trim();
    }

    public String insertBeforeAllElement(String element, String insert) {
        int index = 0;
        while ((index = text.indexOf(element, index)) != -1) {
            text.insert(index, insert + " ");
            index += insert.length() + element.length() + 1;
        }
        return text.toString().trim();
    }

    public String insertBeforeAndAfterElement(String element, String insert) {
        int index = text.indexOf(element);
        if (index != -1) {
            int endIndex = index + element.length();
            text.replace(index, endIndex, insert + element + insert);
        }
        return text.toString().trim();
    }

    public String insertBeforeAndAfterAllElement(String element, String insert) {
        int index = 0;
        while ((index = text.indexOf(element, index)) != -1) {
            int endIndex = index + element.length();
            text.replace(index, endIndex, insert + element + insert);
            index += (2 * insert.length() + element.length());
        }
        return text.toString().trim();
    }

    public String insertElementWithStartingFirstIndex(int index, String insert) {
        if (index < 0 || index > text.length()) return text.toString();
        text.insert(index, insert);
        return text.toString().trim();
    }

    public String insertElementWithStartingLastIndex(int index, String insert) {
        int position = text.length() - index;
        if (position < 0 || position > text.length()) return text.toString();
        text.insert(position, insert);
        return text.toString().trim();
    }
   
    /*****************************************************************************************/
    //the start of delete methods
    
    public String DeleteBeforeAndAfterElement(String element){
    	int index = text.indexOf(element);
        if (index != -1) {
        	return text.substring(index, index + element.length()).trim();
        }
        return "Element not found";
    }
   
    public String DeleteBeforeAndAfterAllElement(String element){ 
    	if (element == null || element.isEmpty() || text == null) {
            return "Something went wrong";
        }

    	ArrayList<String> foundElements = new ArrayList<>();
        int index = 0;
        while ((index = text.indexOf(element, index)) != -1) {
            foundElements.add(text.substring(index, index + element.length()));
            index += element.length(); // Move past the found element to avoid infinite loops
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < foundElements.size(); i++) {
        	result.append(foundElements.get(i));
            if (i < foundElements.size() - 1) {
            	result.append(" ");
            }
        }

        return result.toString().trim();
    }
    
    public String DeleteCharWithStartingFirstIndex(int index){
    	return text.deleteCharAt(0).toString();
    }
    
    
    public String  DeleteCharWithLastIndex(int index){   	
    	text.reverse();
    	text.deleteCharAt(0);
    	text.reverse();
    	return text.toString();
    }
    
    public String  DeleteCharWithAnyIndex(int index){
    	if (index <= text.length() && index > 0) {
            return text.deleteCharAt(index-1).toString();
        }
    	return "Index out of bounds";
    }
    
    public String DeleteStartsIndexToLast(int start, int end){
    	
    	if (start > end) {
            return "The first number must be smaller than the second number.."; // Handle invalid range: startChar appears after endChar
        }
    	if (start <= text.length() && start > 0 && end <= text.length() && end > 0) {
            return text.delete(start-1, end).toString();
        }
    	
    	return "Index out of bounds";
    }
    
    
    public String DeleteStartsCharToChar(char c1, char c2){
    	
    	String start = String.valueOf(c1);
        String end = String.valueOf(c2);
        
    	int startIndex = text.indexOf(start);
        int endIndex = text.indexOf(end);

        if (startIndex == -1 && endIndex == -1) {
            return "The two chars doesn't exist";
        } else if (startIndex == -1) {
            return "The first char doesn't exist";
        } else if (endIndex == -1) {
            return "The second char doesn't exist";
        }
        if (startIndex > endIndex) {
            return "The first char must be before the second one"; 
        }
        return text.delete(startIndex, endIndex+1).toString();
        
    }
    
    public String DeleteAllDigits(){
    	StringBuilder lettersOnly = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') { // Checks if the character is a letter
            	lettersOnly.append(c);
            }
        }
        return lettersOnly.toString();
    }
    
    public String DeleteAllLetters(){
        StringBuilder digitsOnly = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= '0' && c <= '9') { // Checks if the character is a number
                digitsOnly.append(c);
            }
        }
        return digitsOnly.toString();
    }
    
    
    public String  DeleteAllCharExceptDigitsAndLetters(){
    	StringBuilder lettersAndNumbers = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') { // Checks if the character is a letter
            	lettersAndNumbers.append(c);
            }
        }
        return lettersAndNumbers.toString();
    }
    
    
    public String DeleteAll(){
    	return text.delete(0, text.length()).toString();
    }

}