package stringupdatepackage;
import java.util.ArrayList;

public class AllOperations extends StringUpdate {
    private StringBuilder text;
    public AllOperations(){

    }

    public AllOperations(String initial) {
        this.text = new StringBuilder(initial);
    }

    public void setText(String s) {
        text = new StringBuilder(s);
    }

    public String getText() {
        return text.toString();
    } 
    
    public String insertLast(String insert) {
        text.append(insert);
        return text.toString().trim();
    }

    public String insertBeforeLast(String insert) {
        String[] words = text.toString().trim().split("\\s+");
        if (words.length == 0) return insert;

        int lastIndex = text.lastIndexOf(words[words.length - 1]);
        text.insert(lastIndex, insert );
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
        text.insert(0, insert );
        return text.toString().trim();
    }

    public String insertAfterFirst(String insert) {
        String[] words = text.toString().trim().split("\\s+");
        if (words.length == 0) return insert;

        int index = text.indexOf(words[0]) + words[0].length();
        text.insert(index,insert);
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
            text.insert(index + element.length(), insert);
        }
        return text.toString().trim();
    }

    public String insertAfterAllElement(String element, String insert) {
        int index = 0;
        while ((index = text.indexOf(element, index)) != -1) {
            index += element.length();
            text.insert(index, insert);
            index += insert.length() + 1;
        }
        return text.toString().trim();
    }

    public String insertBeforeElement(String element, String insert) {
        int index = text.indexOf(element);
        if (index != -1) {
            text.insert(index, insert);
        }
        return text.toString().trim();
    }

    public String insertBeforeAllElement(String element, String insert) {
        int index = 0;
        while ((index = text.indexOf(element, index)) != -1) {
            text.insert(index, insert);
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
    
    public String deleteBeforeAndAfterElement(String element){
    	int index = text.indexOf(element);
        if (index != -1) {
        	return text.substring(index, index + element.length()).trim();
        }
        return "Element not found";
    }
   
    public String deleteBeforeAndAfterAllElement(String element){ 
    	if (element == null || element.isEmpty() || text == null) {
            return "Something went wrong";
        }
    	
    	ArrayList<String> foundElements = new ArrayList<>();
        int index = 0;
        while ((index = text.indexOf(element, index)) != -1) {
            foundElements.add(text.substring(index, index + element.length()));
            index += element.length(); // Move past the found element to avoid infinite loops
        }

        StringBuilder result = new StringBuilder(); //prints all the elemets saved in the array
        for (int i = 0; i < foundElements.size(); i++) {
        	result.append(foundElements.get(i));
            if (i < foundElements.size() - 1) {
            	result.append(" "); // adds a space after each element
            }
        }

        return result.toString().trim();
    }
    
    public String DeleteCharWithStartingFirstIndex(int index){
    	return text.deleteCharAt(0).toString();
    }
    
    
    public String  deleteCharWithLastIndex(int index){   	
    	text.reverse();
    	text.deleteCharAt(0);
    	text.reverse();
    	return text.toString();
    }
    
    public String  deleteCharWithAnyIndex(int index){
    	if (index <= text.length() && index > 0) {
            return text.deleteCharAt(index-1).toString();
        }
    	return "Index out of bounds";
    }
    
    public String deleteStartsIndexToLast(int start, int end){
    	
    	if (start > end) {
            return "The first number must be smaller than the second number.."; // To make sure the first index is smaller than the second one
        }
    	if (start <= text.length() && start > 0 && end <= text.length() && end > 0) {
            return text.delete(start-1, end).toString();
        }
    	
    	return "Index out of bounds";
    }
    
    
    public String deleteStartsCharToChar(char c1, char c2){
    	//converts char to String to use ".indexOF()" method
    	String start = String.valueOf(c1);
        String end = String.valueOf(c2);
        
        //takes the index of the starting and ending char
    	int startIndex = text.indexOf(start);
        int endIndex = text.indexOf(end);
        //Checks if both chars exist
        if (startIndex == -1 && endIndex == -1) {
            return "The two chars doesn't exist";
        } else if (startIndex == -1) {
            return "The first char doesn't exist";
        } else if (endIndex == -1) {
            return "The second char doesn't exist";
        }
        //makes sure that the first char is before the second char
        if (startIndex > endIndex) {
            return "The first char must be before the second one"; 
        }
        return text.delete(startIndex, endIndex+1).toString();
        
    }
    
    public String deleteAllDigits(){
    	StringBuilder lettersOnly = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i); //checks every character in the sentence
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') { // Checks if the character is a letter
            	lettersOnly.append(c); //adds the letters only
            }
        }
        return lettersOnly.toString();
    }
    
    public String deleteAllLetters(){
        StringBuilder digitsOnly = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i); //checks every character in the sentence
            if (c >= '0' && c <= '9') { // Checks if the character is a number
                digitsOnly.append(c); //adds the numbers only
            }
        }
        return digitsOnly.toString();
    }
    
    
    public String  deleteAllCharExceptDigitsAndLetters(){
    	StringBuilder lettersAndNumbers = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i); //checks every character in the sentence
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') { // Checks if the character is a letter or a number
            	lettersAndNumbers.append(c); //adds the numbers and letters
            }
        }
        return lettersAndNumbers.toString();
    }
    
    public String deleteAll(){
    	return text.delete(0, text.length()).toString();
    }

    public String deleteFirstChar() {
        if (text == null || text.toString().trim().isEmpty()){
            return "text is empty";
        }
        else{
            return text.toString().trim().substring(1);
        }  
    }

    public String deleteAfterFirstChar(){
        if (text == null || text.toString().trim().isEmpty()){
            return "text is empty";
        }
        else{
            StringBuilder textEdit = new StringBuilder(text.toString().trim());
                return textEdit.deleteCharAt(1).toString();
        }
    }
    public String deleteAllAfterFirstChar(){
        if (text == null || text.toString().trim().isEmpty()){
            return "text is empty";
        }
        else{
            StringBuilder textEdit = new StringBuilder(text.toString().trim());
            return textEdit.delete(1, textEdit.length()).toString();
        }
    }
    public String deleteLastChar(){
        if (text == null || text.toString().trim().isEmpty()){
            return "text is empty";
        }
        else{
            StringBuilder textEdit = new StringBuilder(text.toString().trim());
            return textEdit.deleteCharAt(textEdit.length() ).toString();
        }
    }

    public String deleteBeforeLastChar(){
        if (text == null || text.toString().trim().isEmpty()){//OBAI 4 ,3
            return "text is empty";
        }
        else if(text.toString().trim().length() == 1){
            return "text have only one letter";
        }
        else{
            StringBuilder textEdit = new StringBuilder(text.toString().trim());
            return textEdit.deleteCharAt(textEdit.length() -2).toString();
        }
    }
    public String deleteAllBeforeLastChar(){
        if (text == null || text.toString().trim().isEmpty()){
            return "text is empty";
        }
        else if(text.toString().trim().length() == 1){
            return "text have only one letter";
        }
        else{
            StringBuilder textEdit = new StringBuilder(text.toString().trim());
            return textEdit.delete(0,textEdit.length() - 1).toString();
        }
    }

    public String deleteElement(String element) {
        if (text == null || text.toString().trim().isEmpty()) {
            return "text is empty";
        }
    
        String originalText = text.toString();
        String lowerText = originalText.toLowerCase();
        String lowerElement = element.toLowerCase();
    
        int index = lowerText.indexOf(lowerElement);
    
        if (index != -1) {
            text.delete(index, index + element.length());
            return text.toString();
        } else {
            return "The item you want to delete is not available in the text";
        }
    }

    public String deleteAllElement(String element) {
        if (text == null || text.toString().trim().isEmpty()) {
            return "text is empty";
        }
    
        String lowerElement = element.toLowerCase();
        String lowerText = text.toString().toLowerCase();
    
        // تحقق إذا الكلمة غير موجودة
        if (!lowerText.contains(lowerElement)) {
            return "The item you want to delete is not available in the text";
        }
    
        // حذف جميع التطابقات
        while (true) {
            lowerText = text.toString().toLowerCase();  // تحديث بعد كل حذف
            int index = lowerText.indexOf(lowerElement);
    
            if (index == -1) {
                break;
            }
    
            text.delete(index, index + element.length());
        }
    
        return text.toString().trim();
    }
    
    public String deleteAfterElement(String element) {
        if (text == null || text.toString().trim().isEmpty()) {
            return "text is empty";
        }
    
        String originalText = text.toString();
        String lowerText = originalText.toLowerCase();
        String lowerElement = element.toLowerCase();
    
        int index = lowerText.indexOf(lowerElement);
    
        if (index != -1) {
            int deleteStart = index + element.length();
            text.delete(deleteStart, deleteStart + 1);
            return text.toString();
        } else {
            return "The item you want to delete is not available in the text";
        }
    }

    public String deleteAfterAllElement(String element) {
        if (text == null || text.toString().trim().isEmpty()) {
            return "text is empty";
        }
    
        if (element == null || element.isEmpty()) {
            return "Invalid input element";
        }
    
        boolean found = false;
        int i = 0;
    
        while (i <= text.length() - element.length()) {
            String currentSub = text.substring(i, i + element.length());
    
            if (currentSub.equalsIgnoreCase(element)) {
                int deleteIndex = i + element.length();
                if (deleteIndex < text.length()) {
                    text.deleteCharAt(deleteIndex);  // نحذف الحرف الذي يلي العنصر
                }
                found = true;
                i += element.length();  // ننتقل بعد الكلمة (بدون الرجوع للخلف)
            } else {
                i++;
            }
        }
    
        return found ? text.toString() : "The item you want to delete is not available in the text";
    }

    public String deleteAllAfterElement(String element) {
        if (text == null || text.toString().trim().isEmpty()) {
            return "text is empty";
        }
    
        if (element == null || element.isEmpty()) {
            return "Invalid input element";
        }
    
        String lowerText = text.toString().toLowerCase();
        String lowerElement = element.toLowerCase();
    
        int index = lowerText.indexOf(lowerElement);
    
        if (index != -1) {
            int deleteStart = index + element.length();
            text.delete(deleteStart, text.length());  // حذف كل ما بعد العنصر
            return text.toString();
        } else {
            return "The item you want to delete is not available in the text";
        }
    }
    public String deleteBeforeElement(String element) {
        if (text == null || text.toString().trim().isEmpty()) {
            return "text is empty";
        }

        String lowerText = text.toString().toLowerCase();
        String lowerElement = element.toLowerCase();
        int index = lowerText.indexOf(lowerElement);

        if (index != -1) {
            int deleteIndex = index - 1;
            if (deleteIndex >= 0) {
                text.deleteCharAt(deleteIndex);
            }
            return text.toString();
        } else {
            return "The item you want to delete is not available in the text";
        }
    }

    public String deleteBeforeAllElement(String element) {
        if (text == null || text.toString().trim().isEmpty()) {
            return "text is empty";
        }

        if (element == null || element.isEmpty()) {
            return "Invalid input element";
        }

        boolean found = false;
        int i = 0;

        while (i <= text.length() - element.length()) {
            String currentSub = text.substring(i, i + element.length());

            if (currentSub.equalsIgnoreCase(element)) {
                int deleteIndex = i - 1;
                if (deleteIndex >= 0 && deleteIndex < text.length()) {
                    text.deleteCharAt(deleteIndex);
                    i -= 1; // Adjust because we deleted a char before
                }
                found = true;
                i += element.length();
            } else {
                i++;
            }
        }

        return found ? text.toString() : "The item you want to delete is not available in the text";
    }

    public String deleteAllBeforeElement(String element) {
        if (text == null || text.toString().trim().isEmpty()) {
            return "text is empty";
        }

        if (element == null || element.isEmpty()) {
            return "Invalid input element";
        }

        String lowerText = text.toString().toLowerCase();
        String lowerElement = element.toLowerCase();

        int index = lowerText.indexOf(lowerElement);

        if (index != -1) {
            text.delete(0, index);
            return text.toString();
        } else {
            return "The item you want to delete is not available in the text";
        }
    }

    public String[] convertWordsToArray() {
        return text.toString().trim().split("\\s+");
    }

    // 2. Convert letters to array
    public char[] convertLettersToArray() {
        return text.toString().toCharArray();
    }

    // 3. Shuffle words
    public String shuffleWords() {
        String[] words = convertWordsToArray();
        java.util.List<String> list = new java.util.ArrayList<>();
        for (String w : words) list.add(w);
        java.util.Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (String w : list) sb.append(w).append(' ');
        return sb.toString().trim();
    }

    // 4. Shuffle letters
    public String shuffleLetters() {
        char[] chars = convertLettersToArray();
        java.util.List<Character> list = new java.util.ArrayList<>();
        for (char c : chars) list.add(c);
        java.util.Collections.shuffle(list);
        StringBuilder sb = new StringBuilder(list.size());
        for (char c : list) sb.append(c);
        return sb.toString();
    }

    // 5. Reverse content
    public String reverse() {
        return text.reverse().toString();
    }

    // 6. Sort letters ascending
    public String sortLettersAsc() {
        char[] arr = convertLettersToArray();
        java.util.Arrays.sort(arr);
        return new String(arr);
    }

    // 7. Sort letters descending
    public String sortLettersDesc() {
        char[] arr = convertLettersToArray();
        Character[] boxed = new Character[arr.length];
        for (int i = 0; i < arr.length; i++) boxed[i] = arr[i];
        java.util.Arrays.sort(boxed, java.util.Collections.reverseOrder());
        StringBuilder sb = new StringBuilder(boxed.length);
        for (char c : boxed) sb.append(c);
        return sb.toString();
    }

    // 8. Search substring
    public boolean search(String element) {
        return text.indexOf(element) != -1;
    }

    // 9. Update by index range
    public void updateByIndex(int start, int end, String element) {
        if (start < 0 || end > text.length() || start > end) {
            throw new StringIndexOutOfBoundsException("Invalid indices");
        }
        text.replace(start, end, element);
    }

    // 10. Update first occurrence
    public boolean updateFirst(String oldValue, String newValue) {
        int idx = text.indexOf(oldValue);
        if (idx < 0) return false;
        text.replace(idx, idx + oldValue.length(), newValue);
        return true;
    }

    // 11. Update all occurrences
    public void updateAll(String oldValue, String newValue) {
        StringBuilder result = new StringBuilder();
        String s = text.toString();
        int i = 0;
        while (i < s.length()) {
            int idx = s.indexOf(oldValue, i);
            if (idx < 0) {
                result.append(s.substring(i));
                break;
            }
            result.append(s, i, idx);
            result.append(newValue);
            i = idx + oldValue.length();
        }
        text = result;
    }

    // 12. Sum two Numbers with overflow check
    public Number sum(Number n1, Number n2) {
        if (n1 instanceof Byte && n2 instanceof Byte) {
            int r = n1.byteValue() + n2.byteValue();
            if (r > Byte.MAX_VALUE || r < Byte.MIN_VALUE)
                throw new ArithmeticException("You can't sum more than Max Value for Byte.");
            return (byte) r;
        } else if (n1 instanceof Short && n2 instanceof Short) {
            int r = n1.shortValue() + n2.shortValue();
            if (r > Short.MAX_VALUE || r < Short.MIN_VALUE)
                throw new ArithmeticException("You can't sum more than Max Value for Short.");
            return (short) r;
        } else if (n1 instanceof Integer && n2 instanceof Integer) {
            long r = (long) n1.intValue() + n2.intValue();
            if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE)
                throw new ArithmeticException("You can't sum more than Max Value for Integer.");
            return (int) r;
        } else if (n1 instanceof Long && n2 instanceof Long) {
            long r = n1.longValue() + n2.longValue();
            if ((n2.longValue() > 0 && r < n1.longValue()) ||
                (n2.longValue() < 0 && r > n1.longValue()))
                throw new ArithmeticException("You can't sum more than Max Value for Long.");
            return r;
        } else if (n1 instanceof Float && n2 instanceof Float) {
            float r = n1.floatValue() + n2.floatValue();
            if (Float.isInfinite(r))
                throw new ArithmeticException("You can't sum more than Max Value for Float.");
            return r;
        } else if (n1 instanceof Double && n2 instanceof Double) {
            double r = n1.doubleValue() + n2.doubleValue();
            if (Double.isInfinite(r))
                throw new ArithmeticException("You can't sum more than Max Value for Double.");
            return r;
        } else {
            // fallback
            return n1.doubleValue() + n2.doubleValue();
        }
    }

    // 13. Print first letter
    public char printFirstLetter() {
        return text.length() > 0 ? text.charAt(0) : '\0';
    }

    // 14. Print first word
    public String printFirstWord() {
        String[] w = convertWordsToArray();
        return w.length > 0 ? w[0] : "";
    }

    // 15. Print first sentence
    public String printFirstSentence() {
        String s = text.toString();
        int end = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.' || c == '!' || c == '?') { end = i; break; }
        }
        return end >= 0 ? s.substring(0, end+1).trim() : s.trim();
    }

    // 16. Print last letter
    public char printLastLetter() {
        return text.length() > 0 ? text.charAt(text.length()-1) : '\0';
    }

    // 17. Print last word
    public String printLastWord() {
        String[] w = convertWordsToArray();
        return w.length > 0 ? w[w.length-1] : "";
    }

    // 18. Print last sentence
    public String printLastSentence() {
        String s = text.toString();
        int start = -1;
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '.' || c == '!' || c == '?') { start = i; break; }
        }
        return start >= 0 && start < s.length()-1 ? s.substring(start+1).trim() : s.trim();
    }

    // 19. Print size
    public int printSize() {
        return text.length();
    }

    // 20. Print capacity
    public int printCapacity() {
        return text.capacity();
    }

    public char printChar(int idx) {
        return (idx >= 0 && idx < text.length()) ? text.charAt(idx) : '\0';
    }

    public String PrintElement(int startIndex, int endIndex) {
    
    if (text.length() == 0) {
        return "Text is empty";
    }

    if (startIndex < 0 || endIndex > text.length() || startIndex >= endIndex) {
        return "Invalid index range";
    }

    String result = text.substring(startIndex, endIndex);

    return result;
}


    // 22. Index of first occurrence
    public int printIndexOfFirstElement(String element) {
        return text.indexOf(element);
    }

    // 23. Index of last occurrence
    public int printIndexOfLastElement(String element) {
        return text.lastIndexOf(element);
    }

    // 24. Index of all occurrences
    public int[] printIndexOfAllElement(String element) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        String s = text.toString();
        int i = 0;
        while (i <= s.length() - element.length()) {
            int idx = s.indexOf(element, i);
            if (idx < 0) break;
            list.add(idx);
            i = idx + element.length();
        }
        int[] res = new int[list.size()];
        for (int j = 0; j < list.size(); j++) res[j] = list.get(j);
        return res;
    }
}
    
