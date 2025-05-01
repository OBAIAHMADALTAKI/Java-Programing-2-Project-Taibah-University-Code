package FirstStage;

public class AllOperations extends StringUpdate {
    private StringBuilder text = new StringBuilder();

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
}
