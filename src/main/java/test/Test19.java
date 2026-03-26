package test;

import java.awt.*;
import java.awt.event.*;

public class Test19 {
    public static void main(String[] args) {
        // 创建一个 Frame（窗口）
        Frame frame = new Frame("AWT 简单示例");

        // 创建一个按钮
        Button button = new Button("点击我");

        // 添加按钮的事件监听器
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 按钮点击时弹出消息框
                System.out.println("按钮被点击了!");
            }
        });

        // 设置按钮的位置和大小
        button.setBounds(100, 100, 200, 50);

        // 添加按钮到 Frame
        frame.add(button);

        // 设置窗口的布局
        frame.setLayout(null);  // 使用绝对布局

        // 设置窗口的大小
        frame.setSize(800, 800);

        // 显示窗口
        frame.setVisible(true);

        // 监听窗口关闭事件
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}
