package event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 使用Swing来创建一个窗口，并监听窗口内按钮的点击情况
 */
public class ClickButtonEvent {

    /**
     * 启动程序
     * @param args
     */
    public static void main(String[] args) {
        new ClickButtonEvent();
    }

    /**
     * 主窗口，整体框架
     */
    private JFrame mainFrame;
    /**
     * 顶部标签，展示标题
     */
    private JLabel headerLabel;
    /**
     * 底部标签，用于展示交互内容
     */
    private JLabel statusLabel;
    /**
     * 主控制面板，用于存放按钮的集合
     */
    private JPanel controlPanel;

    public ClickButtonEvent() {
        prepareGUI();
        clickButtonEvent();
    }

    private void prepareGUI() {
        // 设置主窗口
        mainFrame = new JFrame("Click Button Event");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));

        // 设置顶部标签
        headerLabel = new JLabel("", JLabel.CENTER);

        // 设置底部标签
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        // 主窗口添加窗口监听器，监听关闭操作用于结束程序（实测不添加监听的话，关闭窗口之后程序还在运行）
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // 设置控制面板和布局（水平布局）
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        // 主窗口添加控件（实测需要从上到下按顺序添加）
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    /**
     * 点击按钮事件
     */
    private void clickButtonEvent() {
        headerLabel.setText("Control in action: Button");

        // 创建按钮
        JButton ok = new JButton("OK");
        JButton submit = new JButton("Submit");
        JButton cancel = new JButton("Cancel");

        // 设置触发指令
        ok.setActionCommand("OK");
        submit.setActionCommand("Submit");
        cancel.setActionCommand("Cancel");

        // 为按钮添加监听器（自定义）
        ok.addActionListener(new ButtonClickListener());
        submit.addActionListener(new ButtonClickListener());
        cancel.addActionListener(new ButtonClickListener());

        // 控制面板集成按钮
        controlPanel.add(ok);
        controlPanel.add(submit);
        controlPanel.add(cancel);
        mainFrame.setVisible(true);
    }

    /**
     * 事件监听器
     */
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            statusLabel.setText(command + " Button clicked!");
        }
    }
}
