import java.sql.*;
import java.util.Arrays;

public class SerchStatement {
    private String month="", year="", pay="", unit="", bill="", outstand="";
    private String[] jan;
    private String[] feb;
    private String[] mar;
    private String[] apl;
    private String[] may;
    private String[] june;
    private String[] july;
    private String[] aug;
    private String[] sep;
    private String[] oct;
    private String[] nov;
    private String[] dec;
    

//    public SerchStatement(String month, String year, String pay, String unit, String bill, String outstand) {
//        this.month = month;
//        this.year = year;
//        this.pay = pay;
//        this.unit = unit;
//        this.bill = bill;
//        this.outstand = outstand;

    
    


//    }
    public void Serch_Statement() {
        try{
            Statement statement = Connector.mycon().createStatement();
            String query = "SELECT month, year, pay, unit, bill, outstand FROM statement2 ORDER BY pay DESC LIMIT 1";
            ResultSet resultSet = statement.executeQuery(query);
            
            if (resultSet.next()) {
                month= resultSet.getString("month");
                year  = resultSet.getString("year");
                pay = resultSet.getString("pay");
                unit = resultSet.getString("unit");
                bill = resultSet.getString("bill");
                outstand = resultSet.getString("outstand");
                

                resultSet.close();
                statement.close();
            }
            
        } catch (SQLException e) {
            System.out.println("Failed to retrieve data from the database.");
            e.printStackTrace();
        }
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
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
//   , String year, String pay, String unit, String bill, String outstand
    public void checkYear(String year) {
        switch (year){
            case "65" -> {
                this.year = "2565";
            }
            case "66" -> {
                this.year = "2566";
            }
        }
    }
        
     public void checkMonth(String month) {
        switch (month){
            case "01" -> {
                this.month = "January";
            }
            case "02" -> {
                this.month = "February";
            }
            case "03" -> {
                this.month = "March";
            }
            case "04" -> {
                this.month = "April";
            }
            case "05" -> {
                this.month = "May";
            }
            case "06" -> {
                this.month = "June";
            }
            case "07" -> {
                this.month = "July";
            }
            case "08" -> {
                this.month = "August";
            }
            case "09" -> {
                this.month = "September";
            }
            case "10" -> {
                this.month = "October";
            }
            case "11" -> {
                this.month = "November";
            }
            case "12" -> {
                this.month = "December";
            }  
        }
        }
//    public void check(String month) {
//        switch (month){
//                case "01" -> {
//                    jan = new String[6];
//                    jan[0] = month;
//                    jan[1] = year;
//                    jan[2] = pay;
//                    jan[3] = unit;
//                    jan[4] = bill;
//                    jan[5] = outstand;  
//            }
//                case "02" -> {
//                    feb = new String[6];
//                    feb[0] = month;
//                    feb[1] = year;
//                    feb[2] = pay;
//                    feb[3] = unit;
//                    feb[4] = bill;
//                    feb[5] = outstand;  
//            }
//                case "03" -> {
//                    mar = new String[6];
//                    mar[0] = month;
//                    mar[1] = year;
//                    mar[2] = pay;
//                    mar[3] = unit;
//                    mar[4] = bill;
//                    mar[5] = outstand;
//            }
//                case "04" -> {
//                    apl = new String[6];
//                    apl[0] = month;
//                    apl[1] = year;
//                    apl[2] = pay;
//                    apl[3] = unit;
//                    apl[4] = bill;
//                    apl[5] = outstand;
//            }
//                case "05" -> {
//                    may = new String[6];
//                    may[0] = month;
//                    may[1] = year;
//                    may[2] = pay;
//                    may[3] = unit;
//                    may[4] = bill;
//                    may[5] = outstand;
//            }
//                case "06" -> {
//                    june = new String[6];
//                    june[0] = month;
//                    june[1] = year;
//                    june[2] = pay;
//                    june[3] = unit;
//                    june[4] = bill;
//                    june[5] = outstand;
//            }
//                case "07" -> {
//                    july = new String[6];
//                    july[0] = month;
//                    july[1] = year;
//                    july[2] = pay;
//                    july[3] = unit;
//                    july[4] = bill;
//                    july[5] = outstand;
//            }
//                case "08" -> {
//                    aug = new String[6];
//                    aug[0] = month;
//                    aug[1] = year;
//                    aug[2] = pay;
//                    aug[3] = unit;
//                    aug[4] = bill;
//                    aug[5] = outstand;
//            }
//                case "09" -> {
//                    sep = new String[6];
//                    sep[0] = month;
//                    sep[1] = year;
//                    sep[2] = pay;
//                    sep[3] = unit;
//                    sep[4] = bill;
//                    sep[5] = outstand;
//            }
//                case "10" -> {
//                    oct = new String[6];
//                    oct[0] = month;
//                    oct[1] = year;
//                    oct[2] = pay;
//                    oct[3] = unit;
//                    oct[4] = bill;
//                    oct[5] = outstand;
//            }
//                case "11" -> {
//                    nov = new String[6];
//                    nov[0] = month;
//                    nov[1] = year;
//                    nov[2] = pay;
//                    nov[3] = unit;
//                    nov[4] = bill;
//                    nov[5] = outstand;
//            }
//                case "12" -> {
//                    dec = new String[6];
//                    dec[0] = month;
//                    dec[1] = year;
//                    dec[2] = pay;
//                    dec[3] = unit;
//                    dec[4] = bill;
//                    dec[5] = outstand;
//            }
//        }
//    }
    public String[] getJan(){
        return jan;
    }

    public String[] getFeb() {
        return feb;
    }

    public String[] getMar() {
        return mar;
    }

    public String[] getApl() {
        return apl;
    }

    public String[] getMay() {
        return may;
    }

    public String[] getJune() {
        return june;
    }

    public String[] getJuly() {
        return july;
    }

    public String[] getAug() {
        return aug;
    }

    public String[] getSep() {
        return sep;
    }

    public String[] getOct() {
        return oct;
    }

    public String[] getNov() {
        return nov;
    }

    public String[] getDec() {
        return dec;
    }
    
    public static void main(String[] args) {
        SerchStatement sr = new SerchStatement();
        sr.Serch_Statement();
        System.out.println("month: " + sr.getMonth());
        System.out.println("year: " + sr.getYear());
        System.out.println("pay: " + sr.getPay());
        System.out.println("unit: " + sr.getUnit());
        System.out.println("bill: " + sr.getBill());
        System.out.println("outstand: " + sr.getOutstand());
        
        sr.checkMonth(sr.getMonth());
        System.out.println("month: " + sr.getMonth());
        sr.checkYear(sr.getYear());
        System.out.println("month: " + sr.getYear());
//        sr.check(sr.getMonth(), sr.getYear(), sr.getPay(), sr.getUnit(), sr.getBill(), sr.getOutstand());
//        String[] mayData = sr.getMay();
//        System.out.println("Month: " + mayData[0]);
        
    }
}
