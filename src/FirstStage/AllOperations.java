package FirstStage;

// الكلاس الأساسي يحتوي على كل العمليات الخاصة بالتعديل على النص
public class AllOperations extends StringUpdate {

    // المتغير الرئيسي لتخزين النص وتعديله
    private StringBuilder builder = new StringBuilder();

    // دالة لإضافة نص في نهاية النص الحالي
    public String insertLast(String element) {
        builder.append(element); // نضيف النص مباشرة في النهاية
        return builder.toString(); // نرجع النص النهائي بعد التعديل
    }

    // دالة لإضافة نص قبل آخر كلمة في النص الحالي
    public String insertBeforeLast(String element) {
        if (builder.length() == 0) {
            // إذا النص فاضي نرجع تنبيه للمستخدم
            return "The text is empty. Add text first using insert last.";
        }

        // تنظيف الفراغات من البداية والنهاية
        String cleaned = builder.toString().trim();
        builder = new StringBuilder(cleaned); // إعادة بناء النص بدون الفراغات الخارجية

        // نحصل على موقع آخر فراغ (قبل الكلمة الأخيرة)
        int lastSpaceIndex = builder.lastIndexOf(" ");
        if (lastSpaceIndex == -1) {
            // إذا فيه كلمة وحدة فقط، نضيف الكلمة في البداية
            builder.insert(0, element + " ");
        } else {
            // نضيف الكلمة قبل آخر كلمة
            builder.insert(lastSpaceIndex, element + " ");
        }

        return builder.toString(); // نرجع النص المعدل
    }

    // دالة لإضافة كلمة قبل وآخرى بعد آخر كلمة في النص الحالي
    public String insertBeforeAndAfterLast(String element) {
        if (builder.length() == 0) {
            return "The text is empty. Add text first using insert last.";
        }

        // تنظيف النص من الفراغات الزائدة من الأطراف
        String cleaned = builder.toString().trim();
        builder = new StringBuilder(cleaned);

        // تقسيم الإدخال على الفاصلة (يدعم وجود فراغات حول الفاصلة)
        String[] parts = element.split("\\s*,\\s*");

        String before;
        String after;

        if (parts.length == 1) {
            // لو دخل كلمة وحدة فقط، نستخدمها قبل وبعد
            before = parts[0].trim();
            after = parts[0].trim();
        } else if (parts.length == 2) {
            // لو دخل كلمتين، الأولى قبل، والثانية بعد
            before = parts[0].trim();
            after = parts[1].trim();
        } else {
            // لو دخل أكثر من كلمتين أو بشكل غير صحيح
            return "Please enter either a single word or two words separated by a comma, e.g., cool or cool,again.";
        }

        // نحصل على موقع آخر فراغ (قبل الكلمة الأخيرة)
        int lastSpaceIndex = builder.lastIndexOf(" ");

        if (lastSpaceIndex == -1) {
            // إذا فيه كلمة وحدة فقط
            builder.insert(0, before + " ");
            builder.append(" " + after);
        } else {
            // نضيف الكلمة قبل وبعد الكلمة الأخيرة
            builder.insert(lastSpaceIndex, before + " ");
            builder.append(" " + after);
        }

        return builder.toString(); // نرجع النص النهائي
    }

    // دالة لإضافة كلمة في بداية النص الحالي
    public String insertFirst(String element) {
        // تنظيف النص من الفراغات الزائدة من البداية والنهاية
        String cleaned = builder.toString().trim();

        // نعيد بناء النص من جديد
        builder = new StringBuilder();

        // نضيف الكلمة الجديدة في البداية ثم النص السابق
        builder.append(element).append(" ").append(cleaned);

        return builder.toString(); // نرجع النص المعدل
    }
}
