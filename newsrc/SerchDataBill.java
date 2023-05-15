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
    private String yearCheck;
    private String cname;
    private String address;
    private String district;
    private String pastpayment;
    private String presentpayment;
    private String consumtion;
    private String unitused;
    private boolean check = true;
    

    public SerchDataBill(String date, String yearCheck, String num_Bill){
        this.date = date;
        this.yearCheck = yearCheck;
        this.num_Bill = num_Bill;
    }
    
    public void serch(){
        try  {
        
            
            // สร้าง PreparedStatement โดยใช้คำสั่ง SQL และกำหนดค่าพารามิเตอร์
            String query = "SELECT elecCost, monPay, ftDis, discount, total, vat, finalAmount, unitused, cname, address, district, pastpayment, presentpayment, consumtion FROM databill WHERE dateCheck = ? AND yearCheck = ? AND numBill = ?";
            PreparedStatement preparedStatement = Connector.mycon().prepareStatement(query);
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, yearCheck);
            preparedStatement.setString(3, num_Bill);
            ResultSet resultSet = preparedStatement.executeQuery();

            
            // Check if any row matches the provided ID and numda
            if (resultSet.next()) {
                String elect_database = resultSet.getString("elecCost");
                String mont_database = resultSet.getString("monPay");
                String ftD_database = resultSet.getString("ftDis");
                String discoun_database = resultSet.getString("discount");
                String tot_database = resultSet.getString("total");
                String va_database = resultSet.getString("vat");
                String fin_database = resultSet.getString("finalAmount");
                String cname_database = resultSet.getString("cname");
                String address_database = resultSet.getString("address");
                String district_database = resultSet.getString("district");
                String pastpayment_database  = resultSet.getString("pastpayment");
                String presentpayment_database  = resultSet.getString("presentpayment");
                String consumtion_database  = resultSet.getString("consumtion");
                String unitused_database = resultSet.getString("unitused");
                cname = cname_database;
                address = address_database;
                district = district_database;
                pastpayment = pastpayment_database;
                presentpayment = presentpayment_database;
                consumtion = consumtion_database;
                unitused = unitused_database;
                elec = elect_database;
                mon = mont_database;
                ft = ftD_database;
                disCount = discoun_database;
                to_tal = tot_database;
                vat7 = va_database;
                final_amount = fin_database;
            } else {
                check = false;
            }
            
        } catch (SQLException e) {
            System.out.println("Failed to retrieve data from the database.");
            e.printStackTrace();
        }
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getUnitused() {
        return unitused;
    }

    public void setUnitused(String unitused) {
        this.unitused = unitused;
    }
    
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPastpayment() {
        return pastpayment;
    }

    public void setPastpayment(String pastpayment) {
        this.pastpayment = pastpayment;
    }

    public String getPresentpayment() {
        return presentpayment;
    }

    public void setPresentpayment(String presentpayment) {
        this.presentpayment = presentpayment;
    }

    public String getConsumtion() {
        return consumtion;
    }

    public void setConsumtion(String consumtion) {
        this.consumtion = consumtion;
    }

    public String getYearCheck() {
        return yearCheck;
    }

    public void setYearCheck(String yearCheck) {
        this.yearCheck = yearCheck;
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
//        System.out.println(ya.getVat7());
}

     
    

