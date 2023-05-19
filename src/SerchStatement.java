
import java.sql.*;
import java.util.Arrays;

public class SerchStatement implements Statement_itf{

    private String month = "", year = "", pay = "", unit = "", bill = "", outstand = "";

    public void Serch_Statement() {
        try {
            Statement statement = Connector.mycon().createStatement();
            String query = "SELECT month, year, pay, unit, bill, outstand FROM statement2 ORDER BY pay DESC LIMIT 1";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                month = resultSet.getString("month");
                year = resultSet.getString("year");
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

    @Override
    public String getMonth() {
        return month;
    }
    @Override
    public String getYear() {
        return year;
    }
    @Override
    public String getPay() {
        return pay;
    }
    @Override
    public String getUnit() {
        return unit;
    }
    @Override
    public String getBill() {
        return bill;
    }
    @Override
    public String getOutstand() {
        return outstand;
    }
//   , String year, String pay, String unit, String bill, String outstand
    @Override
    public void checkYear(String year) {
        switch (year) {
            case "65" -> {
                this.year = "2565";
            }
            case "66" -> {
                this.year = "2566";
            }
        }
    }

    @Override
    public void checkMonth(String month) {
        switch (month) {
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
        System.out.println("year: " + sr.getYear());

    }
}
