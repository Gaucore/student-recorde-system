package ui.chart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JPanel;

public class BarChartPanel extends JPanel {
        private Map<String, Double> chartData = new LinkedHashMap<>();

        public BarChartPanel() {
                setBackground(Color.WHITE);
        }

        public void setChartData(Map<String, Double> data) {
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
                g2.drawString("Course Fee Chart", 20, 30);

                if (chartData.isEmpty()) {
                        g2.drawString("No Data Available", 230, 160);
                        return;
                }

                int width = getWidth();
                int height = getHeight();

                int left = 60;
                int bottom = height - 100;
                int top = 60;

                g2.drawLine(left, bottom, width - 20, bottom);
                g2.drawLine(left, top, left, bottom);
                double max = chartData.values()
                                .stream()
                                .mapToDouble(Double::doubleValue)
                                .max()
                                .orElse(1);

                int barWidth = 60;
                int gap = 30;

                int x = left + 30;

                Color[] colors = {

                                new Color(33, 150, 243),
                                new Color(76, 175, 80),
                                new Color(255, 193, 7),
                                new Color(244, 67, 54),
                                new Color(156, 39, 176)

                };

                int index = 0;
                for (Map.Entry<String, Double> entry : chartData.entrySet()) {

                        int barHeight = (int) ((entry.getValue() / max) * (bottom - top - 20));

                        g2.setColor(colors[index % colors.length]);

                        g2.fillRoundRect(
                                        x,
                                        bottom - barHeight,
                                        barWidth,
                                        barHeight,
                                        15,
                                        15);

                        g2.setColor(Color.BLACK);
                        g2.setFont(new Font("Segoe UI", Font.BOLD, 14));

                        g2.drawString(
                                        "₹" + entry.getValue(),
                                        x,
                                        bottom - barHeight - 10);

                        g2.rotate(
                                        -Math.PI / 4,
                                        x + 20,
                                        bottom + 20);

                        g2.setFont(new Font("Segoe UI", Font.PLAIN, 12));

                        g2.drawString(
                                        entry.getKey(),
                                        x,
                                        bottom + 20);

                        g2.rotate(
                                        Math.PI / 4,
                                        x + 20,
                                        bottom + 20);

                        x += barWidth + gap;

                        index++;
                }

        }

}
