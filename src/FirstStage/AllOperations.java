package FirstStage;

// الكلاس الأساسي يحتوي على كل العمليات الخاصة بالتعديل على النص
public class AllOperations extends StringUpdate {

    // المتغير الرئيسي لتخزين النص وتعديله
    private StringBuilder builder = new StringBuilder();

    // 1. إضافة نص في نهاية النص الحالي
    public String insertLast(String element) {
        builder.append(element);
        return builder.toString();
    }

    // 2. إضافة نص قبل آخر كلمة في النص الحالي
    public String insertBeforeLast(String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insert last.";
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

    // 3. إضافة كلمة قبل أول كلمة وآخرى بعد آخر كلمة
    public String insertBeforeFirstAndAfterLast(String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insert last.";
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
            builder.append(" " + after);
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
            return "The text is empty. Add text first using insert last.";
        }
        String cleaned = builder.toString().trim();
        builder = new StringBuilder(cleaned);
        String cleanedE = element.trim();
        int firstSpaceIndex = builder.indexOf(" ");
        if (firstSpaceIndex == -1) {
            builder.append(" " + cleanedE);
        } else {
            builder.insert(firstSpaceIndex + 1, cleanedE + " ");
        }
        return builder.toString();
    }

    // 6. إضافة كلمة قبل وبعد أول كلمة
    public String insertBeforeAndAfterFirst(String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insert last.";
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
            return "The text is empty. Add text first using insert last.";
        }
        String content = builder.toString();
        int index = content.indexOf(value);
        if (index == -1) {
            return content;
        }
        StringBuilder result = new StringBuilder();
        result.append(content.substring(0, index + value.length()));
        result.append(element);
        result.append(content.substring(index + value.length()));
        builder = result;
        return builder.toString();
    }

    // 8. إضافة عنصر بعد كل ظهور لقيمة معينة
    public String insertAfterAllElement(String value, String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insert last.";
        }
        String content = builder.toString();
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < content.length()) {
            if (i + value.length() <= content.length() && content.substring(i, i + value.length()).equals(value)) {
                result.append(value).append(element);
                i += value.length();
            } else {
                result.append(content.charAt(i));
                i++;
            }
        }
        builder = result;
        return builder.toString();
    }

    // 9. إضافة عنصر قبل كل ظهور لقيمة معينة
    public String insertBeforeAllElement(String value, String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insert last.";
        }
        String content = builder.toString();
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < content.length()) {
            if (i + value.length() <= content.length() && content.substring(i, i + value.length()).equals(value)) {
                result.append(element).append(value);
                i += value.length();
            } else {
                result.append(content.charAt(i));
                i++;
            }
        }
        builder = result;
        return builder.toString();
    }

    // 10. إضافة عنصر قبل وبعد كل ظهور لقيمة معينة
    public String insertBeforeAndAfterAllElement(String value, String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insert last.";
        }
        String content = builder.toString();
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < content.length()) {
            if (i + value.length() <= content.length() && content.substring(i, i + value.length()).equals(value)) {
                result.append(element).append(value).append(element);
                i += value.length();
            } else {
                result.append(content.charAt(i));
                i++;
            }
        }
        builder = result;
        return builder.toString();
    }
}
