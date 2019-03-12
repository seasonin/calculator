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
		//new JLabel实例
		add(timeLabel);
		Thread t = new Thread(this);
				t.start();
				//启动线程
	}
	
	@Override
	public void run() {
		
		formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		//设置时间输出格式
		while(this.isVisible()) {
			//在本面板可见的时候循环
			time = Calendar.getInstance();
			timeLabel.setText(formatter.format(time.getTime()));
			//设置timeLabel的内容为系统时间
			try {
				Thread.sleep(1000);
				//线程停止一秒钟
			} catch (InterruptedException e) {}
			
		}
	}

}
