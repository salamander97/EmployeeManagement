package nexus.employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JFrame {
    private JProgressBar progressBar;
    private JLabel lblStatus;
    private Timer timer;

    public Welcome() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocation(300, 200);
        setLayout(new BorderLayout());
        setUndecorated(true);

        // Tạo một bảng điều khiển để chứa hình nền, nhãn trạng thái và tiến trình
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        // Tạo hình nền
        JLabel background = new JLabel(new ImageIcon("src/nexus/employee/images/welcome.png"));
        contentPane.add(background, BorderLayout.CENTER);

        // Tạo panel cho tiến trình và nhãn trạng thái
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setOpaque(false); // Cho phép nền của statusPanel hiển thị hình nền của background

        // Tạo nhãn trạng thái
        lblStatus = new JLabel("   アプリケーションを起動しています...");
        lblStatus.setFont(new Font("Arial", Font.PLAIN, 13));
        lblStatus.setPreferredSize(new Dimension(900, 28));                // Đặt kích thước cho lblStatus
        lblStatus.setOpaque(true);                                                      // Cho phép lblStatus hiển thị màu nền
        lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(lblStatus, BorderLayout.NORTH);

        // Progress bar　とは　
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);                                              // Cho phép hiển thị tiến trình
        progressBar.setPreferredSize(new Dimension(900, 30));               // Đặt kích thước cho progressBar
        progressBar.setBackground(new Color(148, 255, 178));                    // Đặt màu nền cho progressBar là #CDFFD8
        progressBar.setForeground(new Color(82, 113, 255));                     // Đặt màu chữ cho progressBar là #5271FF
        progressBar.setOpaque(true);
        statusPanel.add(progressBar, BorderLayout.SOUTH);

        contentPane.add(statusPanel, BorderLayout.SOUTH);

        // Thêm bảng điều khiển vào JFrame
        setContentPane(contentPane);

        // Tạo timer
        timer = new Timer(50, new ActionListener() {
            int i = -1;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (i < 100) {
                    i++;
                    progressBar.setValue(i);
                    if (i == 20) {
                        lblStatus.setText("   モジュールの初期化中。。。");
                    }
                    if (i == 40) {
                        lblStatus.setText("   データベースに接続中。。。");
                    }
                    if (i == 60) {
                        lblStatus.setText("   インターフェースを初期化中。。。");
                    }
                    if (i == 80) {
                        lblStatus.setText("   プログラムに進行中。。。");
                    }
                } else {
                    lblStatus.setText("読み込み完了");
                    timer.stop();
                    MainUI mainUI = new MainUI();
                    mainUI.setVisible(true);
                    dispose();
                    contentPane.setVisible(false);
                }
            }
        });

        // Start the timer
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {                  // Tạo một luồng xử lý giao diện
            Welcome progressDialog = new Welcome();
            progressDialog.setVisible(true);
        });
    }
}
