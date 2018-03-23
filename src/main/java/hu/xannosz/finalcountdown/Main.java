package hu.xannosz.finalcountdown;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JWindow;

public class Main extends JWindow {

	private static final long serialVersionUID = -7718123547252332352L;
	private Date time;
	private JLabel panel = new JLabel();
	private SimpleDateFormat sdf;

	private Main(String str) throws ParseException, InterruptedException {

		sdf = new SimpleDateFormat("MM/dd/yyyy");
		time = sdf.parse(str);

		setVisible(true);
		setAlwaysOnTop(true);
		setSize(new Dimension(100, 40));
		setLayout(new GridLayout(1, 1));

		panel.setForeground(Color.GREEN);
		getContentPane().setBackground(Color.BLACK);

		setLocation(0, 730);

		add(panel);

		while (true) {
			refresh();
			Thread.sleep(5L);
		}
	}

	public static void main(String[] args) {
		try {
			new Main("04/30/2018");
		} catch (Exception e) {
		}
	}

	private void refresh() throws ParseException {
		long now = Instant.now().toEpochMilli();

		long diffInMillies = Math.abs(now - time.getTime());

		panel.setText("    " + diffInMillies);
		setVisible(true);
	}
}