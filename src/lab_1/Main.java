package lab_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Main extends JFrame {

    private JTextField redField, greenField, blueField;
    private JTextField cField, mField, yField, kField;
    private JTextField hField, sField, vField;
    private JPanel colorDisplayPanel;
    private Color chosenColor = Color.WHITE;
    private JSlider redSlider, greenSlider, blueSlider;


    private DecimalFormat decimalFormat;

    public Main() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        decimalFormat = new DecimalFormat("#.##", symbols);

        setTitle("Дружелюбный и удобный интерфейс");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Red (0-255):"), gbc);
        redField = new JTextField();
        gbc.gridx = 1;
        add(redField, gbc);

        redSlider = new JSlider(0, 255);
        redSlider.setValue(255);
        redSlider.addChangeListener(e -> updateColorFromSliders());
        gbc.gridx = 2;
        add(redSlider, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Green (0-255):"), gbc);
        greenField = new JTextField();
        gbc.gridx = 1;
        add(greenField, gbc);

        greenSlider = new JSlider(0, 255);
        greenSlider.setValue(255);
        greenSlider.addChangeListener(e -> updateColorFromSliders());
        gbc.gridx = 2;
        add(greenSlider, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Blue (0-255):"), gbc);
        blueField = new JTextField();
        gbc.gridx = 1;
        add(blueField, gbc);

        blueSlider = new JSlider(0, 255);
        blueSlider.setValue(255);
        blueSlider.addChangeListener(e -> updateColorFromSliders());
        gbc.gridx = 2;
        add(blueSlider, gbc);


        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Red (0-255):"), gbc);
        redField = new JTextField();
        gbc.gridx = 1;
        add(redField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Green (0-255):"), gbc);
        greenField = new JTextField();
        gbc.gridx = 1;
        add(greenField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Blue (0-255):"), gbc);
        blueField = new JTextField();
        gbc.gridx = 1;
        add(blueField, gbc);

        JButton rgbToOthersButton = new JButton("Convert RGB");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(rgbToOthersButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("C (0-1):"), gbc);
        cField = new JTextField();
        gbc.gridx = 1;
        add(cField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("M (0-1):"), gbc);
        mField = new JTextField();
        gbc.gridx = 1;
        add(mField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("Y (0-1):"), gbc);
        yField = new JTextField();
        gbc.gridx = 1;
        add(yField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(new JLabel("K (0-1):"), gbc);
        kField = new JTextField();
        gbc.gridx = 1;
        add(kField, gbc);

        JButton cmykToOthersButton = new JButton("Convert CMYK");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        add(cmykToOthersButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        add(new JLabel("Hue (0-360):"), gbc);
        hField = new JTextField();
        gbc.gridx = 1;
        add(hField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        add(new JLabel("Saturation (0-1):"), gbc);
        sField = new JTextField();
        gbc.gridx = 1;
        add(sField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        add(new JLabel("Value (0-1):"), gbc);
        vField = new JTextField();
        gbc.gridx = 1;
        add(vField, gbc);

        JButton hsvToOthersButton = new JButton("Convert HSV");
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        add(hsvToOthersButton, gbc);

        JButton chooseColorButton = new JButton("  Color Chooser  ");
        gbc.gridy = 13;
        add(chooseColorButton, gbc);

        colorDisplayPanel = new JPanel();
        colorDisplayPanel.setPreferredSize(new Dimension(100, 100));
        colorDisplayPanel.setBackground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(new JLabel("Color Display:"), gbc);
        gbc.gridy = 15;
        add(colorDisplayPanel, gbc);

        rgbToOthersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertRGBtoOthers();
            }
        });

        cmykToOthersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCMYKtoOthers();
            }
        });

        hsvToOthersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertHSVtoOthers();
            }
        });

        chooseColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseColorFromPalette();
            }
        });
    }

    private void convertRGBtoOthers() {
        try {
            int r = Integer.parseInt(redField.getText());
            int g = Integer.parseInt(greenField.getText());
            int b = Integer.parseInt(blueField.getText());

            if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
                JOptionPane.showMessageDialog(this, "Please enter values between 0 and 255 for RGB.");
                return;
            }

            convertRGBtoCMYK(r, g, b);
            convertRGBtoHSV(r, g, b);

            chosenColor = new Color(r, g, b);
            colorDisplayPanel.setBackground(chosenColor);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid integers.");
        }
    }

    private void convertRGBtoCMYK(int r, int g, int b) {
        double c = 1 - ((1.0) * r / 255.0);
        double m = 1 - ((1.0) * g / 255.0);
        double y = 1 - ((1.0) * b / 255.0);
        double k = Math.min(c, Math.min(m, y));

        if (k < 1) {
            c = (c - k) / (1 - k);
            m = (m - k) / (1 - k);
            y = (y - k) / (1 - k);
        } else {
            c = 0;
            m = 0;
            y = 0;
        }

        cField.setText(decimalFormat.format(c));
        mField.setText(decimalFormat.format(m));
        yField.setText(decimalFormat.format(y));
        kField.setText(decimalFormat.format(k));
    }

    private void convertRGBtoHSV(int r, int g, int b) {
        float rNorm = r / 255.0f;
        float gNorm = g / 255.0f;
        float bNorm = b / 255.0f;

        float max = Math.max(rNorm, Math.max(gNorm, bNorm));
        float min = Math.min(rNorm, Math.min(gNorm, bNorm));
        float delta = max - min;


        float v = max;


        float s;
        if (max == 0) {
            s = 0;
        } else {
            s = delta / max;
        }

        float h;
        if (delta == 0) {
            h = 0;
        } else if (max == rNorm) {
            h = 60 * (((gNorm - bNorm) / delta) % 6);
        } else if (max == gNorm) {
            h = 60 * (((bNorm - rNorm) / delta) + 2);
        } else {
            h = 60 * (((rNorm - gNorm) / delta) + 4);
        }

        if (h < 0) {
            h += 360;
        }

        hField.setText(decimalFormat.format(h));
        sField.setText(decimalFormat.format(s));
        vField.setText(decimalFormat.format(v));
    }
    private void updateColorFromSliders() {
        int r = redSlider.getValue();
        int g = greenSlider.getValue();
        int b = blueSlider.getValue();

        redField.setText(String.valueOf(r));
        greenField.setText(String.valueOf(g));
        blueField.setText(String.valueOf(b));

        chosenColor = new Color(r, g, b);
        colorDisplayPanel.setBackground(chosenColor);
        convertRGBtoOthers();
    }

    private void convertCMYKtoOthers() {
        try {
            double c = Double.parseDouble(cField.getText());
            double m = Double.parseDouble(mField.getText());
            double y = Double.parseDouble(yField.getText());
            double k = Double.parseDouble(kField.getText());

            if (c < 0 || c > 1 || m < 0 || m > 1 || y < 0 || y > 1 || k < 0 || k > 1) {
                JOptionPane.showMessageDialog(this, "Please enter values between 0 and 1 for CMYK.");
                return;
            }

            int r = (int) ((1 - c) * (1 - k) * 255);
            int g = (int) ((1 - m) * (1 - k) * 255);
            int b = (int) ((1 - y) * (1 - k) * 255);

            redField.setText(String.valueOf(r));
            greenField.setText(String.valueOf(g));
            blueField.setText(String.valueOf(b));

            convertRGBtoHSV(r, g, b);

            chosenColor = new Color(r, g, b);
            colorDisplayPanel.setBackground(chosenColor);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid values.");
        }
    }

    private void convertHSVtoOthers() {
        try {
            float h = Float.parseFloat(hField.getText());
            float s = Float.parseFloat(sField.getText());
            float v = Float.parseFloat(vField.getText());

            if (h < 0 || h > 360 || s < 0 || s > 1 || v < 0 || v > 1) {
                JOptionPane.showMessageDialog(this, "Please enter valid values for HSV.");
                return;
            }
            h = h % 360;

            float hPrime = h / 60.0f;
            int sector = (int) Math.floor(hPrime);
            float f = hPrime - sector;

            float p = v * (1 - s);
            float q = v * (1 - s * f);
            float t = v * (1 - s * (1 - f));

            float rNorm = 0, gNorm = 0, bNorm = 0;

            switch (sector) {
                case 0:
                    rNorm = v;
                    gNorm = t;
                    bNorm = p;
                    break;
                case 1:
                    rNorm = q;
                    gNorm = v;
                    bNorm = p;
                    break;
                case 2:
                    rNorm = p;
                    gNorm = v;
                    bNorm = t;
                    break;
                case 3:
                    rNorm = p;
                    gNorm = q;
                    bNorm = v;
                    break;
                case 4:
                    rNorm = t;
                    gNorm = p;
                    bNorm = v;
                    break;
                case 5:
                default:
                    rNorm = v;
                    gNorm = p;
                    bNorm = q;
                    break;
            }

            int r = Math.round(rNorm * 255);
            int g = Math.round(gNorm * 255);
            int b = Math.round(bNorm * 255);


            redField.setText(String.valueOf(r));
            greenField.setText(String.valueOf(g));
            blueField.setText(String.valueOf(b));

            convertRGBtoCMYK(r, g, b);

            chosenColor = new Color(r, g, b);
            colorDisplayPanel.setBackground(chosenColor);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid values.");
        }
    }

    private void chooseColorFromPalette() {
        chosenColor = JColorChooser.showDialog(this, "Choose Color", chosenColor);
        if (chosenColor != null) {
            int r = chosenColor.getRed();
            int g = chosenColor.getGreen();
            int b = chosenColor.getBlue();

            redField.setText(String.valueOf(r));
            greenField.setText(String.valueOf(g));
            blueField.setText(String.valueOf(b));

            convertRGBtoOthers();

            colorDisplayPanel.setBackground(chosenColor);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
    }
}
