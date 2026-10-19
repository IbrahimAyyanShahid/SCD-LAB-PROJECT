package smarttimetableapp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

    // Palette Colors
    private final Color PRIMARY_COLOR = new Color(30, 41, 59);    // Slate Dark
    private final Color ACCENT_COLOR  = new Color(37, 99, 235);   // Royal Blue
    private final Color BG_LIGHT      = new Color(248, 250, 252);  // Clean Off-White
    private final Color BORDER_COLOR  = new Color(203, 213, 225);  // Subtle Gray

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel statusLabel;

    public LoginFrame() {
        setTitle("Smart Timetable Scheduler - Login");
        setSize(450, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        initUI();
    }

    private void initUI() {
        JPanel backgroundPanel = new JPanel(new GridBagLayout());
        backgroundPanel.setBackground(BG_LIGHT);

        // Center Login Card
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_COLOR, 1, true),
                new EmptyBorder(30, 35, 30, 35)
        ));

        // Header Title
        JLabel title = new JLabel("Smart Timetable");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(PRIMARY_COLOR);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Department Coordinator Portal");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        subtitle.setForeground(Color.GRAY);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Username Field
        JLabel userLabel = new JLabel("Username / Email");
        userLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        userLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        usernameField = new JTextField("coordinator", 20);
        usernameField.setMaximumSize(new Dimension(320, 35));
        usernameField.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Password Field
        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        passLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        passwordField = new JPasswordField(20);
        passwordField.setText("admin123");
        passwordField.setMaximumSize(new Dimension(320, 35));
        passwordField.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Status / Error message
        statusLabel = new JLabel(" ");
        statusLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        statusLabel.setForeground(new Color(225, 29, 72));
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Sign In Button
        JButton loginButton = new JButton("Sign In");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        loginButton.setBackground(ACCENT_COLOR);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setMaximumSize(new Dimension(320, 38));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginButton.addActionListener(this::handleLogin);

        // Assembly
        card.add(title);
        card.add(Box.createVerticalStrut(4));
        card.add(subtitle);
        card.add(Box.createVerticalStrut(25));
        card.add(userLabel);
        card.add(Box.createVerticalStrut(6));
        card.add(usernameField);
        card.add(Box.createVerticalStrut(15));
        card.add(passLabel);
        card.add(Box.createVerticalStrut(6));
        card.add(passwordField);
        card.add(Box.createVerticalStrut(10));
        card.add(statusLabel);
        card.add(Box.createVerticalStrut(15));
        card.add(loginButton);

        backgroundPanel.add(card);
        add(backgroundPanel);
    }

    private void handleLogin(ActionEvent e) {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Please enter both username and password.");
            return;
        }

        // Mock verification (replace with Database query)
        if (username.equals("coordinator") && password.equals("admin123")) {
            statusLabel.setForeground(new Color(22, 101, 52));
            statusLabel.setText("Login successful! Loading dashboard...");

            // Launch main app window here:
            // new SmartSchedulerUI().setVisible(true);
            // this.dispose();
        } else {
            statusLabel.setForeground(new Color(225, 29, 72));
            statusLabel.setText("Invalid credentials. Try again.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}