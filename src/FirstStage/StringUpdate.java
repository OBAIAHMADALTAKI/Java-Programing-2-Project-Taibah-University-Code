package FirstStage;

public class StringUpdate {
    private int Choose = 0;
    private long CapacitySize = 10;
    
    public StringUpdate(){}
    
    public StringUpdate(long CapacitySize){
        this.CapacitySize = CapacitySize;
    }
    public void setChoose(int Choose){
        this.Choose = Choose;
    }
    public int getChoose(){
        return Choose;
    }
    public void setCapacitySize(long CapacitySize){
        this.CapacitySize = CapacitySize;
    }
    public long getCapacitySize(){
        return CapacitySize;
    }
    public void PrintList(){
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
    }
    
}
