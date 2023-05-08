public class Cost_Electrical {
    private double time;
    private double elecUsed;
    private double elecRate;
    private double elecBill = 0.0;
    
    public Cost_Electrical(){
        this(0.0, 0.0, 0.0);
    }
    
    public Cost_Electrical(double time, double used, double rate){
        this.time = time;
        this.elecUsed = used;
        this.elecRate = rate;
    }
    
    public void setTime(double time){
        this.time = time;
    }
    
    public void setElecUsed(double used){
        this.elecUsed = used;
    }
    
    public void setElecRate(double rate){
        this.elecRate = rate;
    }
    
    public double cost(){
        double cost = (elecUsed * elecRate * time) / 1000;
        return cost;
    }
    
    public double bill(){
       elecBill += cost();
       return elecBill;
    }
    
    public void reset(){
        elecBill = 0.0;
    }
    
    public static void main(String[] args) {
        Cost_Electrical television =new Cost_Electrical(2.0, 1200, 4);
        System.out.println(television.cost());
}
    
}
