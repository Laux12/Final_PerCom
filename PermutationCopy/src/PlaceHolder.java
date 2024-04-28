import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class PlaceHolder implements FocusListener {
	JTextField textField;
	String text;

	PlaceHolder(JTextField textField, String text) {
		this.textField = textField;
		this.text = text;
		textField.setForeground(Color.GRAY);
		textField.setText(text);
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (textField.getText().equals(text)) {
			textField.setText("");
			textField.setForeground(Color.BLACK);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (textField.getText().isEmpty()) {
			textField.setForeground(Color.GRAY);
			textField.setText(text);
		}
	}
}
