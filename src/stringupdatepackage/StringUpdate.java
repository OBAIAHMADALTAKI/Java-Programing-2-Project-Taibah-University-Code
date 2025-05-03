package stringupdatepackage;

public abstract class StringUpdate implements SaveFile {
    private int choose = 0;
    private long capacitysize = 10;
    private static int numberofoperations = 0 ;

    protected  StringUpdate(){}
    
    protected StringUpdate(long capacitysize){
        this.capacitysize = capacitysize;
    }
    public void setChoose(int choose){
        this.choose = choose;
    }
    public int getChoose(){
        return choose;
    }
    public void setCapacitySize(long capacitysize){
        this.capacitysize = capacitysize;
    }
    public long getCapacitySize(){
        return capacitysize;
    }
    public static void setNumberOfOperations(int numberofoperations){
        StringUpdate.numberofoperations= numberofoperations;
    }
    public int getNumberOfOperations(){
        return numberofoperations;
    }
    @Override
    public void writeFile(){}

    @Override
    public void readFile(){}

    public void PrintList(){
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
