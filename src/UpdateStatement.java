
import java.sql.Statement;
import java.time.Month;

public class UpdateStatement {
    private String month, year, pay, unit, bill, outstand;

    public UpdateStatement(String month, String year, String pay, String unit, String bill, String outstand) {
        this.month = month;
        this.year = year;
        this.pay = pay;
        this.unit = unit;
        this.bill = bill;
        this.outstand = outstand;
        
        if(this.year.equals("2565")){
            try{
            Statement s = Connector.mycon().createStatement();
            s.executeUpdate("UPDATE updatestatement65 SET pay ='" + pay + "' ,unit ='" + unit 
                    + "' ,bill ='" + bill + "' ,outstand ='" + outstand + "' WHERE month = '" + month + "' ");
        }catch(NullPointerException ex){
            ex.printStackTrace();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        }
        else if(this.year.equals("2566")){
            try{
            Statement s = Connector.mycon().createStatement();
            s.executeUpdate("UPDATE updatestatement66 SET pay ='" + pay + "' ,unit ='" + unit 
                    + "' ,bill ='" + bill + "' ,outstand ='" + outstand + "' WHERE month = '" + month + "' ");
        }catch(NullPointerException ex){
            ex.printStackTrace();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        }
        
    }
    
//    public UpdateStatement(){
////        SerchStatement sr = new SerchStatement();
////        sr.Serch_Statement();
////        sr.checkMonth(sr.getMonth());
////        sr.check(sr.getMonth(), sr.getYear(), sr.getPay(), sr.getUnit(), sr.getBill(), sr.getOutstand());
//        this.month = sr.getMonth();
//        this.pay = sr.getPay();
//        this.unit = sr.getUnit();
//        this.bill = sr.getBill();
//        this.outstand = sr.getOutstand();
//        System.out.println(month);
//        try{
//            Statement s = Connector.mycon().createStatement();
//            s.executeUpdate("UPDATE updatestatement SET pay ='" + pay + "' ,unit ='" + unit 
//                    + "' ,bill ='" + bill + "' ,outstand ='" + outstand + "' WHERE month = '" + month + "' ");
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//    }

    public String getMonth() {
        return month;
    }

    public String getPay() {
        return pay;
    }

    public String getUnit() {
        return unit;
    }

    public String getBill() {
        return bill;
    }

    public String getOutstand() {
        return outstand;
    }
    
    public static void main(String[] args) {
//        UpdateStatement us = new UpdateStatement();
        
    }
}
