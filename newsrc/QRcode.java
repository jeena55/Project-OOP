import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class QRcode{
        public QRcode(){
        JFrame frame = new JFrame("QRcode");
        JPanel p = new JPanel();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        // Create a JLabel for preview
        JLabel previewLabel = new JLabel();
        previewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        previewLabel.setVerticalAlignment(SwingConstants.CENTER);

        // Load the image and create an ImageIcon
        ImageIcon imageIcon = new ImageIcon("C:\\Project\\src\\qrcode.png");

        // Set the ImageIcon as the icon of the preview label
        previewLabel.setIcon(imageIcon);

        // Add the preview label to the JFrame
        frame.setLayout(new BorderLayout());
        frame.add(previewLabel, BorderLayout.NORTH);
        frame.add(p, BorderLayout.CENTER);

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
    }