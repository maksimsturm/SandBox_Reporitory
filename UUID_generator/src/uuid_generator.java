import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import javax.swing.*;
import java.util.UUID;

public class uuid_generator {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }
    public static void createGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("UUID Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //Панель с эелементами
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel test111 = new JLabel();
        test111.setSize(200, 30);
        test111.setLocation(20, 300);
        panel.add(test111);
        UUID id = UUID.randomUUID();
        String base = "";
        base.valueOf(id);
        test111.setText(base);
        //Запуск
        JButton Run = new JButton("Создать");
        Run.setSize(200, 30);
        Run.setLocation(20, 260);
        panel.add(Run);
        //Область контента
        frame.setContentPane(panel);
        frame.setSize(400, 200);
    }


}
