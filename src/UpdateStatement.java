
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

        if (this.year.equals("2565")) {
            try {
                Statement s = Connector.mycon().createStatement();
                s.executeUpdate("UPDATE updatestatement65 SET pay ='" + pay + "' ,unit ='" + unit
                        + "' ,bill ='" + bill + "' ,outstand ='" + outstand + "' WHERE month = '" + month + "' ");
            } catch (NullPointerException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (this.year.equals("2566")) {
            try {
                Statement s = Connector.mycon().createStatement();
                s.executeUpdate("UPDATE updatestatement66 SET pay ='" + pay + "' ,unit ='" + unit
                        + "' ,bill ='" + bill + "' ,outstand ='" + outstand + "' WHERE month = '" + month + "' ");

            } catch (NullPointerException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

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

}
