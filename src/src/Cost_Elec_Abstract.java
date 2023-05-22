
import java.text.DecimalFormat;

public abstract class Cost_Elec_Abstract {

    private String time;
    private String elecUsed;
    private String elecRate;

    public abstract String getName();

    public abstract String getId();

    public abstract void setName(String name);

    public abstract void setId(String id);

    public void setTime(String time) { this.time = time;}

    public void setElecUsed(String used) { this.elecUsed = used;}

    public void setElecRate(String rate) {this.elecRate = rate;}
    public String getCost() {
        double dou_elecUsed = Double.parseDouble(elecUsed);
        double dou_elecRate = Double.parseDouble(elecRate);
        double dou_time = Double.parseDouble(time);
        double num = (dou_elecUsed * (dou_elecRate / 1000) * dou_time) * 30;

        DecimalFormat total = new DecimalFormat("#.##");
        String cost = total.format(num);
        return String.valueOf(cost);
    }

    public abstract void setTotal(double cost);

    public abstract double getTotal();
}

