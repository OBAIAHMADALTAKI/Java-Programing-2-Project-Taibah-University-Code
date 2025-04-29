package FirstStage;

// الكلاس الأساسي يحتوي على كل العمليات الخاصة بالتعديل على النص
public class AllOperations extends StringUpdate {

    private StringBuilder builder = new StringBuilder();

    // 1. إضافة نص في نهاية النص الحالي
    public String insertLast(String element) {
        builder.append(element);
        return builder.toString();
    }

    // 2. إضافة نص قبل آخر كلمة في النص الحالي
    public String insertBeforeLast(String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insertFirst or insertLast.";
        }
        String cleaned = builder.toString().trim();
        builder = new StringBuilder(cleaned);
        int lastSpaceIndex = builder.lastIndexOf(" ");
        if (lastSpaceIndex == -1) {
            builder.insert(0, element + " ");
        } else {
            builder.insert(lastSpaceIndex, element + " ");
        }
        return builder.toString();
    }

    // 3. إضافة كلمة قبل وآخر كلمة في النص
    public String insertBeforeAndAfterLast(String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insertFirst or insertLast.";
        }
        String cleaned = builder.toString().trim();
        builder = new StringBuilder(cleaned);
        int lastSpaceIndex = builder.lastIndexOf(" ");
        if (lastSpaceIndex == -1) {
            builder.insert(0, element + " ");
            builder.append(" " + element);
        } else {
            builder.insert(lastSpaceIndex, element);
            builder.append(" " + element);
        }
        return builder.toString();
    }

    // 4. إضافة كلمة في بداية النص الحالي
    public String insertFirst(String element) {
        String cleaned = builder.toString().trim();
        builder = new StringBuilder();
        builder.append(element).append(" ").append(cleaned);
        return builder.toString();
    }

    // 5. إضافة كلمة بعد أول كلمة
    public String insertAfterFirst(String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insertFirst or insertLast.";
        }
        String cleaned = builder.toString().trim();
        builder = new StringBuilder(cleaned);
        int firstSpaceIndex = builder.indexOf(" ");
        if (firstSpaceIndex == -1) {
            builder.append(" ").append(element);
        } else {
            builder.insert(firstSpaceIndex + 1, element + " ");
        }
        return builder.toString();
    }

    // 6. إضافة كلمة قبل وبعد أول كلمة
    public String insertBeforeAndAfterFirst(String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insertFirst or insertLast.";
        }
        String cleaned = builder.toString().trim();
        builder = new StringBuilder(cleaned);
        String[] parts = element.split("\\s*,\\s*");
        String before = parts[0].trim();
        String after = (parts.length == 2) ? parts[1].trim() : before;
        int firstSpaceIndex = builder.indexOf(" ");
        if (firstSpaceIndex == -1) {
            builder.insert(0, before + " ");
            builder.append(" " + after);
        } else {
            builder.insert(0, before + " ");
            firstSpaceIndex = builder.indexOf(" ", before.length() + 1);
            builder.insert(firstSpaceIndex + 1, after + " ");
        }
        return builder.toString();
    }

    // 7. إضافة عنصر بعد أول ظهور لقيمة معينة
    public String insertAfterElement(String value, String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insertFirst or insertLast.";
        }
        String content = builder.toString();
        int index = content.indexOf(value);
        if (index == -1) {
            return content;
        }
        builder = new StringBuilder();
        builder.append(content, 0, index + value.length());
        builder.append(element);
        builder.append(content.substring(index + value.length()));
        return builder.toString();
    }

    // 8. إضافة عنصر بعد كل ظهور لقيمة معينة
    public String insertAfterAllElement(String value, String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insertFirst or insertLast.";
        }
        return builder.toString().replace(value, value + element);
    }

    // 9. إضافة عنصر قبل أول ظهور لقيمة معينة
    public String insertBeforeElement(String value, String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insertFirst or insertLast.";
        }
        int index = builder.indexOf(value);
        if (index != -1) {
            builder.insert(index, element);
        }
        return builder.toString();
    }

    // 10. إضافة عنصر قبل كل ظهور لقيمة معينة
    public String insertBeforeAllElement(String value, String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insertFirst or insertLast.";
        }
        return builder.toString().replace(value, element + value);
    }

    // 11. إضافة عنصر قبل وبعد أول ظهور لقيمة معينة
    public String insertBeforeAndAfterElement(String value, String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insertFirst or insertLast.";
        }
        int index = builder.indexOf(value);
        if (index != -1) {
            builder.insert(index, element);
            builder.insert(index + element.length() + value.length(), element);
        }
        return builder.toString();
    }

    // 12. إضافة عنصر قبل وبعد كل ظهور لقيمة معينة
    public String insertBeforeAndAfterAllElement(String value, String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insertFirst or insertLast.";
        }
        return builder.toString().replace(value, element + value + element);
    }

    // 13. إدراج عنصر في موقع معين من البداية
    public String insertElementWithStartingFirstIndex(int index, String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insertFirst or insertLast.";
        }
        if (index < 0 || index > builder.length()) {
            return "Invalid index.";
        }
        builder.insert(index, element);
        return builder.toString();
    }

    // 14. إدراج عنصر في موقع معين من النهاية
    public String insertElementWithStartingLastIndex(int index, String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insertFirst or insertLast.";
        }
        int position = builder.length() - index;
        if (position < 0 || position > builder.length()) {
            return "Invalid index.";
        }
        builder.insert(position, element);
        return builder.toString();
    }
}
