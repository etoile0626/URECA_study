package m2swing.level2;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.SwingPropertyChangeSupport;
import javax.swing.JTextField;

public class CalcActionEventProcessor implements ActionListener{
	private JTextField tf;
	private int firstNum, secondNum;
	private String giho = "+";

	public CalcActionEventProcessor() {}
	public CalcActionEventProcessor(JTextField tf) {
		this.tf = tf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("CLS")) {
			tf.setText("");
		} else if(command.equals("=")) {						//등호가 들어오면 계산
			secondNum = Integer.parseInt( tf.getText() );
			switch( giho ){
			case "+" : tf.setText( (firstNum + secondNum) + "" ); break;
			case "-" : tf.setText( (firstNum - secondNum) + "" ); break;
			case "*" : tf.setText( (firstNum * secondNum) + "" ); break;
			case "/" : tf.setText( (firstNum / secondNum) + "" ); break;
			}
		} else if( command.equals("+") || command.equals("-")
				|| command.equals("*") || command.equals("/") ) {
			firstNum = Integer.parseInt( tf.getText() );		//연산이 들어오면 해당 연산과 수를 저장
			giho = command;
			tf.setText("");
		} else { // 숫자키
			tf.setText( tf.getText() + command );				
		}
	}
}
