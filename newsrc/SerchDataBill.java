import java.sql.*;

public class SerchDataBill {
    private String date;
    private String num_Bill;
    private String elec;
    private String mon;
    private String ft;
    private String disCount;
    private String to_tal;
    private String vat7;
    private String final_amount;
    

    public SerchDataBill(){
        this("", "", "", "", "", "", "", "", "");
    }
    
    public SerchDataBill(String date, String num_Bill, String elec, String mon, String ft, String disCount, String to_tal, String vat7, String final_amount) {
        this.date = date;
        this.num_Bill = num_Bill;
        this.elec = elec;
        this.mon = mon;
        this.ft = ft;
        this.disCount = disCount;
        this.to_tal = to_tal;
        this.vat7 = vat7;
        this.final_amount = final_amount;
    }
    
    public SerchDataBill(String date, String num_Bill){
        this.date = date;
        this.num_Bill = num_Bill;
    }
    
    public void serch(){
        String date_database= date;
        String numBill_database = num_Bill;
        
        
        try  {
        
            
            // สร้าง PreparedStatement โดยใช้คำสั่ง SQL และกำหนดค่าพารามิเตอร์
            PreparedStatement preparedStatement = Connector.mycon().prepareStatement("SELECT elecCost, monPay, ftDis, discount, total, vat, finalAmount FROM databill WHERE dataCheck = ? AND numBill = ?");
            preparedStatement.setString(1, date_database);
            preparedStatement.setString(2, numBill_database);
            
            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery("SELECT * fROM databill");
            
            // Check if any row matches the provided ID and numda
            if (resultSet.next()) {
                String elect_database = resultSet.getString("elecCost");
                String mont_database = resultSet.getString("monPay");
                String ftD_database = resultSet.getString("ftDis");
                String discoun_database = resultSet.getString("discount");
                String tot_database = resultSet.getString("total");
                String va_database = resultSet.getString("vat");
                String fin_database = resultSet.getString("finalAmount");
                
//                this.elec.setElec(elect_database);
//                this.mon = mont_database;
//                this.ft = ftD_database;
//                this.disCount = discoun_database;
//                this.to_tal = tot_database;
//                this.vat7 = va_database;
//                this.final_amount = fin_database;
                System.out.println("date: " + date_database);
                System.out.println("NumBill: " + numBill_database);
                System.out.println("1: " + elect_database);
                System.out.println("2: " + mont_database);
            } else {
                System.out.println("No user found with ID: " + date_database + " and numda: " + numBill_database);
            }
            
        } catch (SQLException e) {
            System.out.println("Failed to retrieve data from the database.");
            e.printStackTrace();
        }
    }

    public String getElec() {
        return elec;
    }

    public void setElec(String elec) {
        this.elec = elec;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getFt() {
        return ft;
    }

    public void setFt(String ft) {
        this.ft = ft;
    }

    public String getDisCount() {
        return disCount;
    }

    public void setDisCount(String disCount) {
        this.disCount = disCount;
    }

    public String getTo_tal() {
        return to_tal;
    }

    public void setTo_tal(String to_tal) {
        this.to_tal = to_tal;
    }

    public String getVat7() {
        return vat7;
    }

    public void setVat7(String vat7) {
        this.vat7 = vat7;
    }

    public String getFinal_amount() {
        return final_amount;
    }

    public void setFinal_amount(String final_amount) {
        this.final_amount = final_amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNum_Bill() {
        return num_Bill;
    }

    public void setNum_Bill(String num_Bill) {
        this.num_Bill = num_Bill;
    }
    public static void main(String args[]) {
        SerchDataBill ya = new SerchDataBill("10",  "00593840942");
        ya.serch();
//        System.out.println(ya.getVat7());
}
}
     
    

