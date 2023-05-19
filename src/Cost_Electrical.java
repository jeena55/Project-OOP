
import java.text.DecimalFormat;

public class Cost_Electrical extends Cost_Elec_Abstract{

    private String name;
    private String id;
    private String time;
    private String elecUsed;
    private String elecRate;
    private double total = 0.0;

    public Cost_Electrical() {
        this("", "", "", "", "");
    }

    public Cost_Electrical(String name, String id, String time, String used, String rate) {
        this.name = name;
        this.id = id;
        this.time = time;
        this.elecUsed = used;
        this.elecRate = rate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public void setElecUsed(String used) {
        this.elecUsed = used;
    }

    @Override
    public void setElecRate(String rate) {
        this.elecRate = rate;
    }

    @Override
    public String getCost() {
        double dou_elecUsed = Double.parseDouble(elecUsed);
        double dou_elecRate = Double.parseDouble(elecRate);
        double dou_time = Double.parseDouble(time);
        double num = (dou_elecUsed * (dou_elecRate / 1000) * dou_time) * 30;

        DecimalFormat total = new DecimalFormat("#.##");
        String cost = total.format(num);
        return String.valueOf(cost);
    }

    @Override
    public void setTotal(double cost) {
        total += cost;
    }

    @Override
    public double getTotal() {
        return total;
    }

}
