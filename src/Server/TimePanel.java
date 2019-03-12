package Server;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

public class TimePanel extends JPanel implements Runnable{

	private JLabel timeLabel;
	private Calendar time;
	private SimpleDateFormat formatter;
	
	public TimePanel() {
		timeLabel = new JLabel();
		add(timeLabel);
		Thread t = new Thread(this);
				t.start();
	}
	
	@Override
	public void run() {
		
		formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		while(this.isVisible()) {
			time = Calendar.getInstance();
			timeLabel.setText(formatter.format(time.getTime()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			
		}
	}

}
