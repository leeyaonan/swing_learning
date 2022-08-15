import javax.swing.*;

/**
 * 使用Swing来创建一个窗口，并在窗口内输出Hello World!
 * @link https://www.runoob.com/w3cnote/java-swing-demo-intro.html
 */
public class HelloWorldBySwing {

    public static void main(String[] args) {
        // 开启线程打开GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                helloWorldGUI();
            }
        });
    }

    /**
     * 1. 创建一个窗口
     * 2. 添加Hello World标签
     * 3. 显示窗口
     */
    private static void helloWorldGUI() {

        // 确保一个漂亮的外观风格（windows实测可有可无，只是改了个窗口的风格）
        JFrame.setDefaultLookAndFeelDecorated(true);

        // 创建一个窗口，并设置关闭效果（实测默认就是点击×关闭）
        JFrame frame = new JFrame("HelloWorldBySwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个标签
        JLabel label = new JLabel("Hello World!");
        frame.getContentPane().add(label);

        // 组装使窗口自适应标签（实测不设置这个打开的时候窗口只有标题）
        frame.pack();

        // 设置窗口可见
        frame.setVisible(true);
    }
}
