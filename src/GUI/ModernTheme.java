package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import javax.swing.text.JTextComponent;

public final class ModernTheme {

    private static final Color BG = new Color(245, 248, 252);
    private static final Color SURFACE = new Color(255, 255, 255);
    private static final Color SURFACE_MUTED = new Color(236, 242, 249);
    private static final Color TEXT = new Color(35, 43, 58);
    private static final Color SUBTLE_TEXT = new Color(92, 102, 121);
    private static final Color ACCENT = new Color(18, 126, 173);
    private static final Color ACCENT_DARK = new Color(14, 98, 136);
    private static final Color BORDER = new Color(204, 215, 230);

    private static final Font BASE_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    private static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 20);

    private static boolean installed;

    private ModernTheme() {
    }

    public static void install() {
        if (installed) {
            return;
        }

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
            // Keep default look and feel if system LAF cannot be loaded.
        }

        UIManager.put("OptionPane.messageFont", BASE_FONT);
        UIManager.put("OptionPane.buttonFont", BASE_FONT);
        UIManager.put("OptionPane.background", SURFACE);
        UIManager.put("Panel.background", BG);

        installed = true;
    }

    public static void decorateFrame(JFrame frame) {
        frame.getContentPane().setBackground(BG);
        styleContainer(frame.getContentPane());
    }

    private static void styleContainer(Container container) {
        for (Component component : container.getComponents()) {
            if (component instanceof JPanel) {
                stylePanel((JPanel) component);
                styleContainer((JPanel) component);
            } else if (component instanceof JLabel) {
                styleLabel((JLabel) component);
            } else if (component instanceof JButton) {
                styleButton((JButton) component);
            } else if (component instanceof JRadioButton) {
                styleRadio((JRadioButton) component);
            } else if (component instanceof JTextComponent) {
                styleTextInput((JTextComponent) component);
            } else if (component instanceof JTable) {
                styleTable((JTable) component);
            } else if (component instanceof JScrollPane) {
                styleScrollPane((JScrollPane) component);
            }

            if (component instanceof Container) {
                styleContainer((Container) component);
            }
        }
    }

    private static void stylePanel(JPanel panel) {
        panel.setBackground(BG);
    }

    private static void styleLabel(JLabel label) {
        String text = label.getText();
        boolean titleLike = label.getFont() != null && label.getFont().getSize() >= 16;
        if (!titleLike && text != null && text.equals(text.toUpperCase()) && text.length() > 4) {
            titleLike = true;
        }

        label.setForeground(titleLike ? TEXT : SUBTLE_TEXT);
        label.setFont(titleLike ? TITLE_FONT : BASE_FONT);
    }

    private static void styleButton(JButton button) {
        button.setFont(BASE_FONT);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.setBorder(new CompoundBorder(new LineBorder(ACCENT_DARK, 1, true), new EmptyBorder(4, 10, 4, 10)));

        if ("<".equals(button.getText())) {
            button.setBackground(SURFACE_MUTED);
            button.setForeground(TEXT);
            button.setBorder(new CompoundBorder(new LineBorder(BORDER, 1, true), new EmptyBorder(2, 5, 2, 5)));
        } else {
            button.setBackground(new Color(207, 231, 243));
            button.setForeground(TEXT);
        }
    }

    private static void styleRadio(JRadioButton radioButton) {
        radioButton.setFont(BASE_FONT);
        radioButton.setForeground(SUBTLE_TEXT);
        radioButton.setBackground(BG);
        radioButton.setOpaque(true);
    }

    private static void styleTextInput(JTextComponent textComponent) {
        textComponent.setFont(BASE_FONT);
        textComponent.setBackground(SURFACE);
        textComponent.setForeground(TEXT);
        Border inputBorder = new CompoundBorder(new LineBorder(BORDER, 1, true), new EmptyBorder(4, 8, 4, 8));
        textComponent.setBorder(inputBorder);
        textComponent.setCaretColor(TEXT);
    }

    private static void styleTable(JTable table) {
        table.setFont(BASE_FONT);
        table.setRowHeight(34);
        table.setBackground(SURFACE);
        table.setForeground(TEXT);
        table.setGridColor(BORDER);
        table.setSelectionBackground(new Color(214, 235, 245));
        table.setSelectionForeground(TEXT);

        JTableHeader header = table.getTableHeader();
        if (header != null) {
            header.setFont(new Font("Segoe UI", Font.BOLD, 13));
            header.setBackground(SURFACE_MUTED);
            header.setForeground(TEXT);
            header.setBorder(new LineBorder(BORDER));
        }
    }

    private static void styleScrollPane(JScrollPane scrollPane) {
        scrollPane.setBorder(new LineBorder(BORDER, 1, true));
        scrollPane.getViewport().setBackground(SURFACE);
    }
}