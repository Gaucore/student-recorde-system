package ui.chart;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JPanel;

public class PieChartPanel extends JPanel {

    private Map<String, Integer> chartData = new LinkedHashMap<>();

    public PieChartPanel() {

        setBackground(Color.WHITE);
        // setPreferredSize(new Dimension(500, 300));

    }

    public void setChartData(Map<String, Integer> data) {

        chartData.clear();
        chartData.putAll(data);

        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setFont(new Font("Segoe UI", Font.BOLD, 20));
        g2.drawString("Student Gender", 20, 30);

        if (chartData.isEmpty()) {

            g2.drawString("No Data Available", 150, 150);
            return;

        }

        int total = chartData.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        int startAngle = 0;

        Color[] colors = {

                new Color(33, 150, 243),
                new Color(233, 30, 99),
                new Color(255, 193, 7)

        };

        int i = 0;

        int legendY = 60;

        for (Map.Entry<String, Integer> entry : chartData.entrySet()) {

            int angle = (int) Math.round(
                    (entry.getValue() * 360.0) / total);

            g2.setColor(colors[i % colors.length]);

            g2.fillArc(

                    50,

                    50,

                    220,

                    220,

                    startAngle,

                    angle);

            startAngle += angle;

            // Legend

            g2.fillRect(300, legendY, 15, 15);

            g2.setColor(Color.BLACK);

            g2.drawString(

                    entry.getKey() + " : " + entry.getValue(),

                    325,

                    legendY + 13);

            legendY += 30;

            i++;

        }

    }

}