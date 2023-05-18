
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Statement;
import java.time.Month;

public class QRcode implements ActionListener {

    private JFrame frame;
    private JPanel p1, p2;
    private JTextField tx;
    private JButton submit;
    private SerchDataBill ya;
    private boolean submit_boo;
    public String month, year, pay, unit, final_amount, outstand;

//        private boolean issubmit = false;
    public QRcode() {
        this("", "", "", "", "", "", "");
    }

    public QRcode(String total, String month, String year, String pay, String unit, String final_amount, String outstand) {
        this.month = month;
        this.year = year;
        this.pay = pay;
        this.unit = unit;
        this.final_amount = final_amount;
        this.outstand = outstand;
        frame = new JFrame("QRcode");
        p1 = new JPanel();
        p2 = new JPanel();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        tx = new JTextField("Total = " + total + " Baht");
        tx.setEditable(false);
        tx.setColumns(10);
        submit = new JButton("Submit");
        submit.addActionListener(this);
        // Create a JLabel for preview
        JLabel previewLabel = new JLabel();
        previewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        previewLabel.setVerticalAlignment(SwingConstants.CENTER);

        // Load the image and create an ImageIcon
        ImageIcon imageIcon = new ImageIcon("C:\\Project\\src\\qrcode.png");

        // Set the ImageIcon as the icon of the preview label
        previewLabel.setIcon(imageIcon);
        p1.setLayout(new FlowLayout());
        p1.add(tx);

        p2.setLayout(new FlowLayout());
        p2.add(submit);
        // Add the preview label to the JFrame
        frame.setLayout(new BorderLayout());
        frame.add(previewLabel, BorderLayout.NORTH);
        frame.add(p1, BorderLayout.CENTER);
        frame.add(p2, BorderLayout.SOUTH);

        // Set JFrame properties
        frame.setSize(650, 650);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        WindowListener windowListener = new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?",
                        "Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    frame.dispose();
                }

            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        };
        frame.addWindowListener(windowListener);
    }

    public boolean isCheckSubmit_boo() {
        return submit_boo;
    }

    public void setSubmit_boo(boolean submit_boo) {
        this.submit_boo = submit_boo;
    }

    public String getMonth() {
        return month;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(submit)) {
            try {
                Statement s = Connector.mycon().createStatement();
                s.executeUpdate("INSERT INTO statement2(month, year, pay, unit, bill, outstand)"
                        + "VALUES ('" + month + "','" + year + "','" + pay + "','" + unit + "','" + final_amount + "','" + outstand + "')");
                s.executeUpdate("INSERT INTO currentstatement(month, year, pay, unit, bill, outstand)"
                        + "VALUES ('" + month + "','" + year + "','" + pay + "','" + unit + "','" + final_amount + "','" + outstand + "')");
                System.out.println("Finish.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JOptionPane.showConfirmDialog(frame, "Processing.", "System", JOptionPane.CLOSED_OPTION);
            frame.dispose();
        }

    }
}
