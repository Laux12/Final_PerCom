import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class HistoryButton extends JButton implements ActionListener, Serializable {
	private static final long serialVersionUID = 1L;
	char mode;
	int r;
	String answer, character;
	JTextArea textArea;

	HistoryButton(char mode, String character, int r, String answer) {
		this.mode = mode;
		this.r = r;
		this.answer = answer;

		this.character = character;
		this.setFont(new Font("Inter", Font.PLAIN, 15));
		this.setMaximumSize(new Dimension(200, this.getMinimumSize().height + 20));
		this.setFocusable(false);
		this.setBackground(MyFrame.lightSecondaryColor);
		this.setForeground(Color.white);

		this.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyFrame.textArea.setText(answer);

	}
}
