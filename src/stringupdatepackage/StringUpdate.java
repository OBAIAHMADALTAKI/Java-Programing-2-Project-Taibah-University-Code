package stringupdatepackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public abstract class StringUpdate implements SaveFile {
    private int choose = 0;
    private long capacitysize = 10;
    private Date dateCreated;

   
    protected StringUpdate() {
        this.dateCreated = new Date();
    }

    protected StringUpdate(long capacitysize) {
        this.capacitysize = capacitysize;
    }

    public void setChoose(int choose) { this.choose = choose; }
    public int getChoose() { return choose; }

    public void setCapacitySize(long capacitysize) { this.capacitysize = capacitysize; }
    public long getCapacitySize() { return capacitysize; }

    @Override
    public void writeFile(File file){
        try {
            PrintWriter input = new PrintWriter(file);
            input.write(dateCreated.toString() + "\n");

            GregorianCalendar cal = new GregorianCalendar();

            String[] monthNames = {"January", "February", "March", "April", "May", "June", "July",
                                   "August", "September", "October", "November", "December"};
            String[] dayNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

            input.write("YEAR: " + cal.get(Calendar.YEAR) + "\n");
            input.write("MONTH: " + cal.get(Calendar.MONTH) + "\n");
            input.write("NameOfMONTH: " + monthNames[cal.get(Calendar.MONTH)] + "\n");
            input.write("DAY_OF_MONTH: " + cal.get(Calendar.DAY_OF_MONTH) + "\n");
            input.write("DAY_OF_WEEK: " + cal.get(Calendar.DAY_OF_WEEK) + "\n");
            input.write("NameOfDay: " + dayNames[cal.get(Calendar.DAY_OF_WEEK) - 1] + "\n");
            input.write("DAY_OF_WEEK_IN_MONTH: " + cal.get(Calendar.DAY_OF_WEEK_IN_MONTH) + "\n");
            input.write("DAY_OF_YEAR: " + cal.get(Calendar.DAY_OF_YEAR) + "\n");
            input.write("WEEK_OF_MONTH: " + cal.get(Calendar.WEEK_OF_MONTH) + "\n");
            input.write("WEEK_OF_YEAR: " + cal.get(Calendar.WEEK_OF_YEAR) + "\n");
            input.write("HOUR: " + cal.get(Calendar.HOUR) + "\n");
            input.write("HOUR_OF_DAY: " + cal.get(Calendar.HOUR_OF_DAY) + "\n");
            input.write("MINUTE: " + cal.get(Calendar.MINUTE) + "\n");
            input.write("SECOND: " + cal.get(Calendar.SECOND) + "\n");
            input.write("MILLISECOND: " + cal.get(Calendar.MILLISECOND) + "\n");
            input.write("AM_PM: " + (cal.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM") + "\n");

            input.close();
            System.out.println("Date written to WriteTheDate.");
            
        } catch (IOException e) {
            System.out.println("Error writing date: " + e.getMessage());
        }

    }
    public void WriteStatistics(File file) {
        Scanner input = new Scanner(System.in);
        List<Number> list = new ArrayList<>();
    
        System.out.println("Enter numbers to be added and averaged.");
        System.out.println("Write 'stop' to finish.");
    
        while (true) {
            String line = input.nextLine();
    
            if (line.equalsIgnoreCase("stop")) {
                break;
            }
    
            try {
                double number = Double.parseDouble(line);
                list.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    
        double sum = 0, max = Double.MIN_VALUE, min = Double.MAX_VALUE;
        for (Number n : list) {
            double val = n.doubleValue();
            sum += val;
            max = Math.max(max, val);
            min = Math.min(min, val);
        }
        double average = list.isEmpty() ? 0 : sum / list.size();
    
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println("List: " + list);
            writer.println("Max: " + max);
            writer.println("Min: " + min);
            writer.println("Size: " + list.size());
            writer.println("Capacity: " + list.size());
            writer.println("Sum: " + sum);
            writer.println("Average: " + average);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        System.out.println("Statistics saved to " + file.getName());
    }
         @Override
    public void readFile(File file) {
    if (!file.exists()) {
        System.out.println("The file does not exist.");
        return;
    }

    try (Scanner scanner = new Scanner(file)) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred while reading the file.");
        e.printStackTrace();
    }
}

 

    public void PrintList() {
        System.out.println("Choose an insertion operation:");
        System.out.println(" 1. Insert Last ");
        System.out.println(" 2. Insert Before Last");
        System.out.println(" 3. Insert Before & After Last");
        System.out.println(" 4. Insert First");
        System.out.println(" 5. Insert After First");
        System.out.println(" 6. Insert Before & After First");
        System.out.println(" 7. Insert After Element");
        System.out.println(" 8. Insert After All Element");
        System.out.println(" 9. Insert Before Element");
        System.out.println("10. Insert Before All Element");
        System.out.println("11. Insert Before & After Element");
        System.out.println("12. Insert Before & After All Element");
        System.out.println("13. Insert Element With String Frist Index");
        System.out.println("14. Insert Element With Starting Last Index");
        System.out.println("0. Back to operations menu");
        System.out.println("Your choice: ");
    }
}
