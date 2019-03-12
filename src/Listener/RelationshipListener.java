package Listener;

import java.awt.event.*;
import javax.swing.JTextArea;
import Server.*;

public class RelationshipListener implements ActionListener{
	
	String previousText = "我的";
	JTextArea rta;
	RelationshipPanel rp;
	
	public RelationshipListener(){}
	
	public RelationshipListener(RelationshipPanel rp) {
		this.rta = rp.rta;
		this.rp = rp;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String value = e.getActionCommand();
		
		if(value.equals("←")) {
			
			if(rp.rsl.previousText.length()>2)
			rp.rsl.previousText = rp.rsl.previousText.substring(0, rp.rsl.previousText.length()-2);
			if(rp.rsl.previousText.length()>2)
				rta.setText(judge(rp.rsl.previousText));
			else {
				rta.setText("我的");
				rp.rsl.previousText = "我的";
				rp.pressed = false;
			}
		}
		
		else if(value.equals("C") && rta.getText().length()>0) {
			rta.setText("我的");
			rp.rsl.previousText = "我的";
			rp.pressed = false;
		}
		
		else
			if(rp.pressed) {
				rp.rsl.previousText += ("的" + value);
				rta.setText(judge(rp.rsl.previousText));
			}
			else {
				rp.rsl.previousText += value;
				rta.setText(judge(rp.rsl.previousText));
				rp.pressed = true;
			}	
	}
	
	private String judge(String text) {
	
		if(text.subSequence(0, 3).equals("我的夫"))
			return judge1(text);
		
		if(text.substring(0, 3).equals("我的妻"))
			return judge2(text);
		
		if(text.substring(0, 3).equals("我的父"))
			return judge3(text);
		
		if(text.substring(0, 3).equals("我的母"))
			return judge4(text);
	
		if(text.substring(0, 3).equals("我的兄"))
			return judge5(text);
		
		if(text.substring(0, 3).equals("我的弟"))
			return judge6(text);
		
		if(text.substring(0, 3).equals("我的姐"))
			return judge7(text);
		
		if(text.substring(0, 3).equals("我的妹"))
			return judge8(text);
			
		if(text.substring(0, 3).equals("我的子"))
			return judge9(text);
		
		return judge10(text);
	} 
	
	private String judge1(String text) {
		
		if(text.equals("我的夫"))
			return "我的丈夫\n老公";
		
		if(text.equals("我的夫的父"))
			return "我的丈夫的老豆\n公公";
		
		if(text.equals("我的夫的父的妻"))
			return "我的丈夫的老豆的妻子\n婆婆";
		
		if(text.equals("我的夫的父的父"))
			return "我的丈夫的老豆的老豆\n祖翁";
		
		if(text.equals("我的夫的父的父的妻"))
			return "我的丈夫的老豆的老豆的妻子\n祖婆";
		
		if(text.equals("我的夫的母"))
			return "我的丈夫的妈咪\n婆婆";
		
		if(text.equals("我的夫的母的夫"))
			return "我的丈夫的妈咪的丈夫\n公公";
		
		if(text.equals("我的夫的母的父"))
			return "我的丈夫的妈咪的丈夫\n外公";
		
		if(text.equals("我的夫的母的父的妻"))
			return "我的丈夫的妈咪的丈夫的妻子\n外婆";
		
		if(text.equals("我的夫的母的母"))
			return "我的丈夫的妈咪的妈咪\n外婆";
		
		if(text.equals("我的夫的母的母的夫"))
			return "我的丈夫的妈咪的妈咪的丈夫\n外公";
		
		if(text.equals("我的夫的兄"))
			return "我的丈夫的哥哥\n大伯";
		
		if(text.equals("我的夫的兄的妻"))
			return "我的丈夫的哥哥的妻子\n大婶";
		
		if(text.equals("我的夫的弟"))
			return "我的丈夫的弟弟\n叔子";
		
		if(text.equals("我的夫的兄的妻"))
			return "我的丈夫的弟弟的妻子\n小嫂";
		
		if(text.equals("我的夫的姐"))
			return "我的丈夫的姐姐\n大姑";
		
		if(text.equals("我的夫的姐的夫"))
			return "我的丈夫的姐姐\n大姑夫";
		
		if(text.equals("我的夫的妹"))
			return "我的丈夫的妹妹\n小姑";
		
		if(text.equals("我的夫的姐的夫"))
			return "我的丈夫的妹妹\n小姑夫";
		
		else
			return "不可以调皮哦";
	}
	
	private String judge2(String text) {
		
		if(text.equals("我的妻"))
			return "我的妻子\n老婆";
		
		if(text.equals("我的妻的夫"))
			return "我的妻子的丈夫\n自己";
		
		else if(text.equals("我的妻的父"))
			return "我的妻子的老豆\n岳父";
		
		else if(text.equals("我的妻的父的妻"))
			return "我的妻子的老豆的妻子\n岳母";
		
		else if(text.equals("我的妻的父的父"))
			return "我的妻子的老豆的老豆\n太岳父";
		
		else if(text.equals("我的妻的父的父的妻"))
			return "我的妻子的老豆的老豆的妻子\n太岳母";
		
		else if(text.equals("我的妻的母"))
			return "我的妻子的妈咪\n岳母";
		
		else if(text.equals("我的妻的母的夫"))
			return "我的妻子的妈咪的丈夫\n岳父";
		
		else if(text.equals("我的妻的母的母"))
			return "我的妻子的妈咪的妈咪\n外太岳母";
		
		else if(text.equals("我的妻的母的母的夫"))
			return "我的妻子的妈咪的妈咪的丈夫\n外太岳父";
		
		else if(text.equals("我的妻的兄"))
			return "我的妻子的哥哥\n大舅子";
		
		else if(text.equals("我的妻的兄的妻"))
			return "我的妻子的哥哥的妻子\n舅嫂";
		
		else if(text.equals("我的妻的弟"))
			return "我的妻子的弟弟\n小舅子";
		
		else if(text.equals("我的妻的弟的妻"))
			return "我的妻子的弟弟的妻子\n舅婶";
		
		else if(text.equals("我的妻的姐"))
			return "我的妻子的姐姐\n大姨子";
		
		else if(text.equals("我的妻的姐的夫"))
			return "我的妻子的姐姐的丈夫\n大姨夫";
		
		else if(text.equals("我的妻的姐的子"))
			return "我的妻子的姐姐的儿子\n内甥";
		
		else if(text.equals("我的妻的姐的女"))
			return "我的妻子的姐姐的女儿\n姨甥女";
		
		else if(text.equals("我的妻的妹"))
			return "我的妻子的妹妹\n小姨子";
		
		else if(text.equals("我的妻的姐的夫"))
			return "我的妻子的姐姐的丈夫\n小姨夫";
		
		else if(text.equals("我的妻的妹的子"))
			return "我的妻子的妹妹的儿子\n内甥";
		
		else if(text.equals("我的妻的妹的女"))
			return "我的妻子的妹妹的女儿\n姨甥女";
	    
		else 
			return "再玩就玩坏啦";
	}
	
	private String judge3(String text) {
		
		if(text.equals("我的父"))
			return "我的老豆\n爸爸";
		
		if(text.equals("我的父的妻"))
			return "我的老豆的妻子\n妈妈";
		
		if(text.equals("我的父的父"))
			return "我的老豆的老豆\n爷爷";
		
		if(text.equals("我的父的父的妻"))
			return "我的老豆的老豆的妻子\n奶奶";
		
		if(text.equals("我的父的母"))
			return "我的老豆的妈咪\n奶奶";
		
		if(text.equals("我的父的母的夫"))
			return "我的老豆的妈咪的丈夫\n爷爷";
		
		if(text.equals("我的父的妻的兄"))
			return "我的老豆的妻子的哥哥\n大舅";
		
		if(text.equals("我的父的妻的兄的妻"))
			return "我的老豆的妻子的哥哥的妻\n大舅母";
		
		if(text.equals("我的父的妻的弟"))
			return "我的老豆的妻子的弟弟\n小舅";
		
		if(text.equals("我的父的妻的弟的妻"))
			return "我的老豆的妻子的弟弟的妻子\n小舅母";
		
		if(text.equals("我的父的姐"))
			return "我的老豆的姐姐\n姑姑";
		
		if(text.equals("我的父的姐的夫"))
			return "我的老豆的姐姐的丈夫\n姑爷";
		
		if(text.equals("我的父的姐的子"))
			return "我的老豆的姐姐的儿子\n表哥、表弟";
		
		if(text.equals("我的父的姐的女"))
			return "我的老豆的姐姐的女儿\n表姐、表妹";
		
		if(text.equals("我的父的兄"))
			return "我的老豆的哥哥\n伯伯";
		
		if(text.equals("我的父的兄的妻"))
			return "我的老豆的哥哥的妻子\n伯母";
		
		if(text.equals("我的父的兄的子"))
			return "我的老豆的哥哥的儿子\n堂哥、堂弟";
		
		if(text.equals("我的父的兄的女"))
			return "我的老豆的哥哥的女儿\n堂姐、堂妹";
		
		if(text.equals("我的父的弟"))
			return "我的老豆的弟弟\n叔叔";
		
		if(text.equals("我的父的弟的妻"))
			return "我的老豆的弟弟的妻子\n婶婶";
		
		if(text.equals("我的父的第的子"))
			return "我的老豆的弟弟的儿子\n堂哥、堂弟";
		
		if(text.equals("我的父的弟的女"))
			return "我的老豆的弟弟的女儿\n堂姐、堂妹";
		
		if(text.equals("我的父的姐"))
			return "我的老豆的姐姐\n姑姑";
		
		if(text.equals("我的父的姐的夫"))
			return "我的老豆的姐姐的丈夫\n姑爷";
		
		if(text.equals("我的父的姐的子"))
			return "我的老豆的姐姐的儿子\n表哥、表弟";
		
		if(text.equals("我的父的姐的女"))
			return "我的老豆的姐姐的女儿\n表姐、表妹";
		
		if(text.equals("我的父的妹"))
			return "我的老豆的妹妹\n小姑";
		
		if(text.equals("我的父的妹的夫"))
			return "我的老豆的妹妹的丈夫\n姑爷";
		
		if(text.equals("我的父的妹的子"))
			return "我的老豆的妹妹的儿子\n表哥、表弟";
		
		if(text.equals("我的父的妹的女"))
			return "我的老豆的妹妹的女儿\n表姐、表妹";
		
		else
			return "同龄的叫名字称呼吧~长辈叫叔叔阿姨~";
	}

	private String judge4(String text) {
		
		if(text.equals("我的母"))
			return "我的妈咪\n妈妈";
		
		if(text.equals("我的母的夫"))
			return "我的妈咪的丈夫\n爸爸";
		
		if(text.equals("我的母的夫的父"))
			return "我的妈咪的丈夫的老豆\n爷爷";
		
		if(text.equals("我的母的夫的父的妻"))
			return "我的妈咪的丈夫的老豆的妻子\n奶奶";
		
		if(text.equals("我的母的父"))
			return "我的妈咪的爸爸\n外公";
		
		if(text.equals("我的母的父的妻"))
			return "我的妈咪的老豆的妻子\n外婆";
		
		if(text.equals("我的母的母"))
			return "我的妈咪的妈咪\n外婆";
		
		if(text.equals("我的母的母的夫"))
			return "我的吗妈咪的妈咪的丈夫\n外公";
		
		if(text.equals("我的母的兄"))
			return "我的妈咪的哥哥\n大舅";
		
		if(text.equals("我的母的兄的妻"))
			return "我的妈咪的哥哥的妻\n大舅母";
		
		if(text.equals("我的母的弟"))
			return "我的妈咪的弟弟\n小舅";
		
		if(text.equals("我的母的弟的妻"))
			return "我的妈咪的弟弟的妻子\n小舅母";
		
		if(text.equals("我的母的姐"))
			return "我的妈妈的姐姐\n大姨";
		
		if(text.equals("我的母的姐的夫"))
			return "我的妈妈的姐姐的丈夫\n大姨夫";
		
		if(text.equals("我的母的姐的子"))
			return "我的妈妈的姐姐的儿子\n姨表哥、姨表弟";
		
		if(text.equals("我的母的姐的女"))
			return "我的妈妈的姐姐的女儿\n姨表姐、姨表妹";
		
		if(text.equals("我的母的妹"))
			return "我的妈吗的妹妹\n小姨";
		
		if(text.equals("我的母的妹的夫"))
			return "我的妈妈的妹妹的丈夫\n小姨夫";
		
		if(text.equals("我的母的妹的子"))
			return "我的妈妈的妹妹的儿子\n姨表哥、姨表弟";
		
		if(text.equals("我的母的妹的女"))
			return "我的妈妈的妹妹的女儿\n姨表姐、姨表妹";
		
		else
			return "同龄的叫名字称呼吧~长辈叫叔叔阿姨~";
	}
	
	private String judge5(String text) {
		
		if(text.equals("我的兄"))
			return "我的哥哥\n哥哥";
		
		if(text.equals("我的兄的妻"))
			return "我的哥哥的妻子\n嫂子";
		
		if(text.equals("我的兄的父"))
			return "我的哥哥的爸爸\n爸爸";
		
		if(text.equals("我的兄的父的妻"))
			return "我的哥哥的老豆的妻子\n妈妈";
		
		if(text.equals("我的兄的母"))
			return "我的哥哥的妈咪\n妈妈";
		
		if(text.equals("我的兄的母的夫"))
			return "我的哥哥的妈咪的丈夫\n爸爸";
		
		if(text.equals("我的兄的子"))
			return "我的哥哥的儿子\n侄子";
		
		if(text.equals("我的兄的子的妻"))
			return "我的哥哥的儿子的妻子\n侄媳";
		
		if(text.equals("我的兄的子的姐"))
			return "我的哥哥的儿子的姐姐\n侄女";
		
		if(text.equals("我的兄的子的兄"))
			return "我的哥哥的儿子的哥哥\n侄子";
		
		if(text.equals("我的兄的子的弟"))
			return "我的哥哥的儿子的弟弟\n侄子";
		
		if(text.equals("我的兄的女"))
			return "我的哥哥的女儿\n侄女";
		
		if(text.equals("我的兄的子的子"))
			return "我的哥哥的儿子的儿子\n侄孙";
		
		if(text.equals("我的兄的子的女"))
			return "我的哥哥的儿子的女儿\n侄孙女";
		
		if(text.equals("我的兄的弟"))
			return "我的哥哥的弟弟\n哥哥/自己/弟弟";
		
		if(text.equals("我的兄的兄"))
			return "我的哥哥的哥哥\n哥哥";
		
		if(text.equals("我的兄的姐"))
			return "我的哥哥的姐姐\n姐姐";
		
		if(text.equals("我的兄的妹"))
			return "我的哥哥的妹妹\n姐姐/妹妹";
		
		else
			return "小计暂时无法回答您的问题~请与管理员联系";
	}
	
	private String judge6(String text) {
		
		if(text.equals("我的弟"))
			return "我的弟弟\n弟弟";
		
		if(text.equals("我的弟的妻"))
			return "我的弟弟的妻子\n弟媳";
		
		if(text.equals("我的弟的父"))
			return "我的弟弟的爸爸\n爸爸";
		
		if(text.equals("我的弟的父的妻"))
			return "我的弟弟的老豆的妻子\n妈妈";
		
		if(text.equals("我的弟的母"))
			return "我的弟弟的妈咪\n妈妈";
		
		if(text.equals("我的弟的母的夫"))
			return "我的弟弟的妈咪的丈夫\n爸爸";
		
		if(text.equals("我的弟的子"))
			return "我的弟弟的儿子\n侄子";
		
		if(text.equals("我的弟的子的妻"))
			return "我的弟弟的儿子的妻子\n侄媳";
		
		if(text.equals("我的弟的子的姐"))
			return "我的弟弟的儿子的姐姐\n侄女";
		
		if(text.equals("我的弟的子的兄"))
			return "我的弟弟的儿子的哥哥\n侄子";
		
		if(text.equals("我的弟的子的弟"))
			return "我的弟弟的儿子的弟弟\n侄子";
		
		if(text.equals("我的弟的女"))
			return "我的弟弟的女儿\n侄女";
		
		if(text.equals("我的弟的子的子"))
			return "我的哥哥的儿子的儿子\n侄孙";
		
		if(text.equals("我的弟的子的女"))
			return "我的弟弟的儿子的女儿\n侄孙女";
		
		if(text.equals("我的弟的弟"))
			return "我的弟弟的弟弟\n弟弟";
		
		if(text.equals("我的弟的兄"))
			return "我的弟弟的哥哥\n哥哥/自己/弟弟";
		
		if(text.equals("我的弟的姐"))
			return "我的弟弟的姐姐\n姐姐/妹妹";
		
		if(text.equals("我的弟的妹"))
			return "我的弟弟的妹妹\n妹妹";
		
		else
			return "小计暂时无法回答您的问题~请与管理员联系";
	}
	
	private String judge7(String text) {
		
		if(text.equals("我的姐"))
			return "我的姐姐\n姐姐";
		
		if(text.equals("我的姐的夫"))
			return "我的姐姐的丈夫\n姐夫";
		
		if(text.equals("我的姐的父"))
			return "我的姐姐的爸爸\n爸爸";
		
		if(text.equals("我的姐的父的妻"))
			return "我的姐姐的老豆的妻子\n妈妈";
		
		if(text.equals("我的姐的母"))
			return "我的姐姐的妈咪\n妈妈";
		
		if(text.equals("我的姐的母的夫"))
			return "我的姐姐的妈咪的丈夫\n爸爸";
		
		if(text.equals("我的姐的子"))
			return "我的姐姐的儿子\n外甥";
		
		if(text.equals("我的姐的子的妻"))
			return "我的姐姐的儿子的妻子\n外甥媳";
		
		if(text.equals("我的姐的子的姐"))
			return "我的姐姐的儿子的姐姐\n外甥女";
		
		if(text.equals("我的姐的子的兄"))
			return "我的姐姐的儿子的哥哥\n外甥";
		
		if(text.equals("我的姐的子的弟"))
			return "我的姐姐的儿子的弟弟\n外甥";
		
		if(text.equals("我的姐的女"))
			return "我的姐姐的女儿\n外甥女";
		
		if(text.equals("我的姐的姐"))
			return "我的姐姐的姐姐\n姐姐";
		
		if(text.equals("我的姐的兄"))
			return "我的姐姐的哥哥\n哥哥";
		
		if(text.equals("我的姐的弟"))
			return "我的姐姐的弟弟\n哥哥/自己/弟弟";
		
		if(text.equals("我的姐的妹"))
			return "我的姐姐的妹妹\n姐姐/妹妹";
		
		else
			return "或者可以亲近的喊名字";
	}
	
	private String judge8(String text) {
		
		if(text.equals("我的妹"))
			return "我的妹妹\n妹妹";
		
		if(text.equals("我的妹的夫"))
			return "我的妹妹的丈夫\n妹夫";
		
		if(text.equals("我的妹的父"))
			return "我的妹妹的爸爸\n爸爸";
		
		if(text.equals("我的妹的父的妻"))
			return "我的妹妹的老豆的妻子\n妈妈";
		
		if(text.equals("我的妹的母"))
			return "我的妹妹的妈咪\n妈妈";
		
		if(text.equals("我的妹的母的夫"))
			return "我的妹妹的妈咪的丈夫\n爸爸";
		
		if(text.equals("我的妹的子"))
			return "我的妹妹的儿子\n外甥";
		
		if(text.equals("我的妹的子的妻"))
			return "我的妹妹的儿子的妻子\n外甥媳";
		
		if(text.equals("我的妹的子的姐"))
			return "我的妹妹的儿子的姐姐\n外甥女";
		
		if(text.equals("我的妹的子的兄"))
			return "我的妹妹的儿子的哥哥\n外甥";
		
		if(text.equals("我的妹的子的弟"))
			return "我的妹妹的儿子的弟弟\n外甥";
		
		if(text.equals("我的妹的女"))
			return "我的妹妹的女儿\n外甥女";
		
		if(text.equals("我的妹的姐"))
			return "我的妹妹的姐姐\n姐姐/妹妹";
		
		if(text.equals("我的妹的兄"))
			return "我的妹妹的哥哥\n哥哥/自己/弟弟";
		
		if(text.equals("我的妹的弟"))
			return "我的妹妹的弟弟\n弟弟";
		
		if(text.equals("我的妹的妹"))
			return "我的妹妹的妹妹\n妹妹";
		
		else
			return "亲近的喊名字吧~";
	}
	
	private String judge9(String text) {
		
		if(text.equals("我的子"))
			return "我的儿子\n儿子";
		
		if(text.equals("我的子的妻"))
			return "我的儿子的妻子\n儿媳妇";
		
		if(text.equals("我的子的父"))
			return "我的儿子的爸爸\n自己";
		
		if(text.equals("我的子的父的父"))
			return "我的儿子的爸爸的爸爸\n爸爸";
		
		if(text.equals("我的子的母"))
			return "我的儿子的妈咪\n老婆";
		
		if(text.equals("我的子的母的母"))
			return "我的儿子的妈咪的妈咪\n妈妈";
		
		if(text.equals("我的子的父的妻"))
			return "我的儿子的老豆的妻子\n老婆";
		
		if(text.equals("我的子的母"))
			return "我的儿子的妈咪\n老婆";
		
		if(text.equals("我的子的母的夫"))
			return "我的儿子的妈咪的丈夫\n自己";
		
		if(text.equals("我的子的子"))
			return "我的儿子的儿子\n孙子";
		
		if(text.equals("我的子的子的妻"))
			return "我的儿子的儿子的妻子\n孙媳妇";
		
		if(text.equals("我的子的子的姐"))
			return "我的儿子的儿子的姐姐\n孙女";
		
		if(text.equals("我的子的子的兄"))
			return "我的儿子的儿子的哥哥\n孙子";
		
		if(text.equals("我的子的子的弟"))
			return "我的儿子的儿子的弟弟\n孙子";
		
		if(text.equals("我的子的女"))
			return "我的儿子的女儿\n孙女";
		
		if(text.equals("我的子的姐"))
			return "我的儿子的姐姐\n女儿";
		
		if(text.equals("我的子的兄"))
			return "我的儿子的哥哥\n儿子";
		
		if(text.equals("我的子的弟"))
			return "我的妹妹的弟弟\n儿子";
		
		if(text.equals("我的子的妹"))
			return "我的儿子的妹妹\n女儿";
		
		else
			return "换种方式查询吧~";
	}
	
	private String judge10(String text) {
		
		if(text.equals("我的女"))
			return "我的女儿\n女儿";
		
		if(text.equals("我的女的夫"))
			return "我的女儿的丈夫\n女婿";
		
		if(text.equals("我的女的父"))
			return "我的女儿的爸爸\n自己";
		
		if(text.equals("我的女的父的父"))
			return "我的女儿的爸爸的爸爸\n爸爸";
		
		if(text.equals("我的女的母"))
			return "我的女儿的妈咪\n老婆";
		
		if(text.equals("我的女的母的母"))
			return "我的女儿的妈咪的妈咪\n妈妈";
		
		if(text.equals("我的女的父的妻"))
			return "我的女儿的老豆的妻子\n老婆";
		
		if(text.equals("我的女的母的夫"))
			return "我的女儿的妈咪的丈夫\n自己";
		
		if(text.equals("我的女的子"))
			return "我的女儿的儿子\n外孙";
		
		if(text.equals("我的女的子的妻"))
			return "我的女儿的儿子的妻子\n外孙媳";
		
		if(text.equals("我的女的子的姐"))
			return "我的女儿的儿子的姐姐\n外孙女";
		
		if(text.equals("我的女的子的兄"))
			return "我的女儿的儿子的哥哥\n外孙";
		
		if(text.equals("我的女的子的弟"))
			return "我的女儿的儿子的弟弟\n外孙";
		
		if(text.equals("我的女的女"))
			return "我的女儿的女儿\n外孙女";
		
		if(text.equals("我的女的姐"))
			return "我的女儿的姐姐\n女儿";
		
		if(text.equals("我的女的兄"))
			return "我的女儿的哥哥\n儿子";
		
		if(text.equals("我的女的弟"))
			return "我的女儿的弟弟\n儿子";
		
		if(text.equals("我的女的妹"))
			return "我的女儿的妹妹\n女儿";
		
		else
			return "换种方式查询吧~";
	}
}
