
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
//Linear Graph

public class LinearGraph extends JPanel {

    private ArrayList<Double> monthlyData;

    public LinearGraph() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        int x = 40;
        int y = h - 30;
        g2.drawLine(30, h - 30, w - 30, h - 30);
        g2.drawLine(30, h - 30, 30, 30);
        if (monthlyData != null && !monthlyData.isEmpty()) {
            int barWidth = (w - 60) / monthlyData.size();
            double maxValue = getMaxValue(monthlyData);

            g2.setColor(Color.BLACK);
            int labelX = x + (barWidth / 2);
            int labelY = h - 10;
            for (int i = 0; i < monthlyData.size(); i++) {
                String monthLabel = getMonthLabel(i);
                int labelWidth = g2.getFontMetrics().stringWidth(monthLabel);
                g2.drawString(monthLabel, labelX - (labelWidth / 2), labelY);
                labelX += barWidth;
            }

            for (int i = 0; i < monthlyData.size(); i++) {
                int xi = x + (i * barWidth) + (barWidth / 2);
                int yi = (int) (y - (monthlyData.get(i) * (h - 60) / maxValue));
                g2.setColor(Color.BLUE);
                g2.fillOval(xi - 4, yi - 3, 6, 6);

                g2.setColor(Color.BLACK);
                String money = String.valueOf(monthlyData.get(i));
                int labelWidth = g2.getFontMetrics().stringWidth(money);
                g2.drawString(money, xi - (labelWidth / 2), yi - 6);

                if (i > 0) {
                    int xiprev = x + ((i - 1) * barWidth) + (barWidth / 2);
                    int yiprev = (int) (y - (monthlyData.get(i - 1) * (h - 60) / maxValue));
                    g2.drawLine(xiprev, yiprev, xi, yi);
                }
            }
        }
    }

    private String getMonthLabel(int monthIndex) {
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return months[monthIndex];
    }

    private double getMaxValue(ArrayList<Double> data) {
        double maxValue = Double.MIN_VALUE;
        for (double value : data) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public ArrayList<Double> getMonthlyData() {
        return monthlyData;
    }

    public void setMonth() {
        monthlyData = new ArrayList<>();
        try {
            Statement s = Connector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT bill fROM updatestatement66");
            for (int i = 0; i <= 11; i++) {
                if (rs.next()) {
                    String money = rs.getString("bill");
                    if (money.equals("")) {
                        money = "0";
                    }
                    monthlyData.add(Double.parseDouble(money));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
