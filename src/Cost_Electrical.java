
import java.text.DecimalFormat;

public class Cost_Electrical {
    private String name;
    private String id;
    private String time;
    private String elecUsed;
    private String elecRate;
    private double elecBill = 0.0;
    
    public Cost_Electrical(){
        this("", "", "", "", "");
    }
    
    public Cost_Electrical(String name, String id, String time, String used, String rate){
        this.name = name;
        this.id = id;
        this.time = time;
        this.elecUsed = used;
        this.elecRate = rate;
    }
    
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void setTime(String time){
        this.time = time;
    }
    
    public void setElecUsed(String used){
        this.elecUsed = used;
    }
    
    public void setElecRate(String rate){
        this.elecRate = rate;
    }
    
    public String getCost(){
        double dou_elecUsed = Double.parseDouble(elecUsed);
        double dou_elecRate = Double.parseDouble(elecRate);
        double dou_time = Double.parseDouble(time);
        double num = (dou_elecUsed * (dou_elecRate/ 1000) * dou_time) * 30 ;
        
        DecimalFormat total = new DecimalFormat("#.##");
        String cost = total.format(num);
        return String.valueOf(cost);
    }
    
    public String bill(){
       elecBill += Double.parseDouble(getCost());
       return String.valueOf(elecBill);
    }
    
    public void reset(){
        elecBill = 0.0;
    }
//    
//    public static void main(String[] args) {
//        Cost_Electrical television =new Cost_Electrical("television", "65070"", 2.0, 1200, 4);
//        System.out.println(television.cost());
//}
    
}
