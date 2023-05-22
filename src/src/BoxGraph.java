
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
//Box Graph

public class BoxGraph extends JPanel {

    private ArrayList<Double> monthlyData;
    private final int barSpacing = 1;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        g2.drawLine(30, h - 30, w - 30, h - 30);
        g2.drawLine(30, h - 30, 30, 30);

        int barWidth = 40;
        double maxValue = getMaxValue(monthlyData);
        int chartHeight = getHeight() - 60;
        int x = 50;
        int y = getHeight() - 30;

        for (int i = 0; i < monthlyData.size(); i++) {
            double value = monthlyData.get(i);
            int barHeight = (int) (value / maxValue * chartHeight);
            g.setColor(Color.BLUE);
            g.fillRect(x, y - barHeight, barWidth, barHeight);

            g.setColor(Color.BLACK);
            g.drawString(Double.toString(value), x, y - barHeight - 5); //show money
            x += barWidth + 10;

            String monthLabel = getMonthLabel(i);
            int labelWidth = g2.getFontMetrics().stringWidth(monthLabel);
            g.drawString(monthLabel, x - 55, y + 20);
            x += barWidth + 10;
        }
    }

    private String getMonthLabel(int monthIndex) {
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return months[monthIndex];
    }

    public ArrayList<Double> getMonthlyData() {
        return monthlyData;
    }

    public void setMonth() {
        monthlyData = new ArrayList<>();
        // Add your data for 12 months to the monthlyData ArrayList

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

    private static double getMaxValue(ArrayList<Double> data) {
        double maxValue = Double.MIN_VALUE;
        for (double value : data) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

}
