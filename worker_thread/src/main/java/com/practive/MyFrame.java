package com.practive;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MyFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 5003633103106248326L;

	private final JLabel label = new JLabel("Event Dispatching Thread Sample");
	private final JButton button = new JButton("countUp");

	public MyFrame() {
		super("MyFrame");
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(label);
		getContentPane().add(button);
		button.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			countUp();
		}
	}

	private void countUp() {
		System.out.println(Thread.currentThread().getName() + ": countUp: BEGIN");

		new InvokerThread("invokerThread").start();

		System.out.println(Thread.currentThread().getName() + ": countUp: END");
	}

	class InvokerThread extends Thread {

		InvokerThread(String name) {
			super(name);
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + ": invokerThread: BEGIN");

			for (int i=0; i<10; i++) {
				final String number_label = String.valueOf(i);
				// it looks working by calling setText(..) directly here, but it's wrong!
				Runnable executor = new Runnable() {
						@Override
						public void run() {
							label.setText(number_label);
						}
					};
				SwingUtilities.invokeLater(executor);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println(Thread.currentThread().getName() + ": invokerThread: END");
		}
	}

}
