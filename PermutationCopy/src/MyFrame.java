import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	// components
	JPanel historyPanel, containerPanel, inputPanel, textAreaContainer, historyButtonsPanel, sidePanel;
	static JTextArea textArea;
	JTextField textField1, textField2;
	JButton clearButton, submitButton, themeContainer;
	JScrollPane scrollPane, scrollPaneH;
	String selections[] = { "C", "P" };
	JComboBox<String> selection;
	ArrayList<Button> history;
	// current theme 1 = light mode 0 = dark mode
	public int currentTheme = 1;

	// colors
	static Color lightPrimaryColor = new Color(172, 177, 248);
	static Color lightSecondaryColor = new Color(150, 155, 231);
	static Color darkPrimaryColor = new Color(16, 20, 73);
	static Color darkSecondaryColor = new Color(255, 209, 41);
	static Color darkTertiaryColor = new Color(12, 2, 45);

	// icons dark and light theme
	ImageIcon lightTrashIcon = new ImageIcon("trash3.png");
	ImageIcon lightSubmitIcon = new ImageIcon("cursor.png");
	ImageIcon darkTrashIcon = new ImageIcon("trash3dark.png");
	ImageIcon darkSubmitIcon = new ImageIcon("cursordark.png");
	ImageIcon sunIcon = new ImageIcon("sun-fill.png");
	ImageIcon moonIcon = new ImageIcon("moon-fill.png");
	Processes process = new Processes();
	PlaceHolder placeHolder1, placeHolder2;
	HistoryController hController = new HistoryController();
	AnswerHistory aHistory = new AnswerHistory();

	// constructor
	MyFrame() {
		// frame

		this.setSize(900, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Combination and Permutation");
		this.setResizable(false);

		// container
		containerPanel = new JPanel();
		containerPanel.setBounds(0, 0, 900, 700);
		containerPanel.setBackground(lightPrimaryColor);
		containerPanel.setLayout(null);

		sidePanel = new JPanel();
		sidePanel.setBounds(0, 0, 200, 700);
		sidePanel.setBackground(Color.white);

		// history container
		historyPanel = new JPanel();
		historyPanel.setBounds(0, 0, 200, 600);

		historyPanel.setLayout(new BoxLayout(historyPanel, BoxLayout.Y_AXIS));
		historyPanel.setBackground(Color.white);

		// Create a panel for history buttons with BoxLayout for vertical stacking
		historyButtonsPanel = new JPanel();
		historyButtonsPanel.setBackground(Color.white);
		historyButtonsPanel.setLayout(new BoxLayout(historyButtonsPanel, BoxLayout.Y_AXIS));

		// button to clear history

		clearButton = new JButton(" Clear history", lightTrashIcon);

		clearButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, clearButton.getMinimumSize().height));
		clearButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		clearButton.setBackground(lightSecondaryColor);
		clearButton.setForeground(Color.white);
		clearButton.setFont(new Font("Inter", Font.PLAIN, 15));
		clearButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		clearButton.addActionListener(this);

		// Wrap the historyButtonsPanel in a JScrollPane for scrollability
		scrollPaneH = new JScrollPane(historyButtonsPanel);
		scrollPaneH.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPaneH.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneH.setPreferredSize(new Dimension(historyPanel.getWidth(), historyPanel.getHeight()));
		scrollPaneH.setBorder(null);
		// Add the scrollPane to the center and the clearButton to the south of
		// historyPanel
		clearButton.setFocusable(false);
		clearButton.setBackground(lightSecondaryColor);
		clearButton.setForeground(Color.white);
		clearButton.setFont(new Font("Inter", Font.PLAIN, 18));
		clearButton.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
		clearButton.addActionListener(this);
		clearButton.setBounds(25, 625, 50, 150);
		// label with sun icon
		themeContainer = new JButton();
		themeContainer.setIcon(sunIcon);
		themeContainer.setBounds(820, 20, 30, 30);
		themeContainer.setBackground(null);
		themeContainer.setBorder(null);
		themeContainer.setFocusable(false);
		themeContainer.addActionListener(this);

		textAreaContainer = new JPanel();
		textAreaContainer.setBounds(233, 150, 620, 300);
		textAreaContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		textAreaContainer.setBorder(null);
		// text area where the answer will dispay
		textArea = new JTextArea("Answer here...");

		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setLayout(new FlowLayout());
		textArea.setFont(new Font("Inter", Font.PLAIN, 17));
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setFocusable(false);

		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setPreferredSize(new Dimension(620, 300));

		// container for the textfield and submit button
		inputPanel = new JPanel();
		inputPanel.setLayout(null);
		inputPanel.setBackground(null);
		inputPanel.setBounds(233, 596, 620, 44);

		selection = new JComboBox<String>(selections);
		selection.setBounds(0, 0, 65, 44);
		selection.setFocusable(false);
		selection.setFont(new Font("Inter", Font.PLAIN, 15));
		selection.setToolTipText("Select mode");

		// textfield where user inputs
		textField1 = new JTextField();
		textField1.setBounds(65, 0, 249, 44);
		textField1.setForeground(Color.black);
		textField1.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		textField1.setFont(new Font("Inter", Font.PLAIN, 18));
		textField1.setToolTipText("Enter the characters");
		textField1.addFocusListener(new PlaceHolder(textField1, "Enter the characters"));

		textField2 = new JTextField();
		textField2.setBounds(315, 0, 250, 44);
		textField2.setForeground(Color.black);
		textField2.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		textField2.setFont(new Font("Inter", Font.PLAIN, 18));
		textField2.addFocusListener(new PlaceHolder(textField2, "Enter the (r)"));
		textField2.setToolTipText("Enter the (r)");
		// submit button with icon
		submitButton = new JButton(lightSubmitIcon);
		submitButton.setBounds(565, 0, 55, 44);
		submitButton.setBackground(lightSecondaryColor);
		submitButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		submitButton.setFocusable(false);
		submitButton.addActionListener(this);
		this.getRootPane().setDefaultButton(submitButton);
		textAreaContainer.add(scrollPane);
		// adding all the components

		inputPanel.add(selection);
		inputPanel.add(textField1);
		inputPanel.add(textField2);
		inputPanel.add(submitButton);

		historyPanel.add(scrollPaneH, BorderLayout.CENTER);
		sidePanel.add(historyPanel);
		sidePanel.add(clearButton);
		containerPanel.add(themeContainer);
		containerPanel.add(sidePanel);
		containerPanel.add(inputPanel);
		containerPanel.add(textAreaContainer);
		this.add(containerPanel);

		try {

			aHistory = hController.loadHistory();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (aHistory.historyList.size() >= 1) {
			for (int i = 0; i < aHistory.historyList.size(); i++) {
				HistoryButton hButton = aHistory.historyList.get(i);
				hButton.setText("Mode: " + hButton.mode + "-" + hButton.character);
				hButton.setFont(new Font("Inter", Font.PLAIN, 15));
				historyButtonsPanel.add(hButton);
				if (currentTheme == 0) {
					hButton.setBackground(darkSecondaryColor);
					hButton.setForeground(Color.black);
				} else {
					hButton.setBackground(lightSecondaryColor);
					hButton.setForeground(Color.white);
				}
			}
		}

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == themeContainer) {
			if (currentTheme == 1) {
				// Set the background color and icons for history buttons

				containerPanel.setBackground(darkPrimaryColor);
				submitButton.setBackground(darkSecondaryColor);
				submitButton.setIcon(darkSubmitIcon);
				clearButton.setBackground(darkSecondaryColor);
				clearButton.setIcon(darkTrashIcon);
				clearButton.setForeground(Color.black);
				themeContainer.setIcon(moonIcon);
				historyButtonsPanel.setBackground(darkTertiaryColor);
				sidePanel.setBackground(darkTertiaryColor);
				textArea.setBackground(darkTertiaryColor);
				textArea.setForeground(Color.white);
				if (aHistory.historyList.size() >= 1) {
					for (int i = 0; i < aHistory.historyList.size(); i++) {
						aHistory.historyList.get(i).setBackground(darkSecondaryColor);
						aHistory.historyList.get(i).setForeground(Color.black);
					}
				}
				currentTheme = 0;
			} else {

				containerPanel.setBackground(lightPrimaryColor);
				submitButton.setBackground(lightSecondaryColor);
				submitButton.setIcon(lightSubmitIcon);
				clearButton.setBackground(lightSecondaryColor);
				clearButton.setIcon(lightTrashIcon);
				clearButton.setForeground(Color.white);
				themeContainer.setIcon(sunIcon);
				sidePanel.setBackground(Color.white);
				historyButtonsPanel.setBackground(Color.white);
				textArea.setBackground(Color.white);
				textArea.setForeground(Color.black);
				if (aHistory.historyList.size() >= 1) {
					for (int i = 0; i < aHistory.historyList.size(); i++) {
						aHistory.historyList.get(i).setBackground(lightSecondaryColor);
						aHistory.historyList.get(i).setForeground(Color.white);
					}
				}

				currentTheme = 1;
			}
		}
		if (e.getSource() == clearButton) {
			historyButtonsPanel.removeAll();
			historyButtonsPanel.revalidate();
			historyButtonsPanel.repaint();
			aHistory.clearHistory();
			try {
				hController.saveHistory(aHistory);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource() == submitButton) {

			String combi = textField1.getText().replaceAll("\\s+", "");
			char mode;
			try {
				int r = Integer.parseInt(textField2.getText().replaceAll("\\s+", ""));
				if (r > combi.length() && !combi.isEmpty()) {
					process.typingText("Failed to Combine, your R is greater than the length of your string", textArea,
							submitButton);
				} else {
					if (combi.isEmpty()) {
						process.typingText("Please input Something!", textArea, submitButton);
					} else {
						String convertedResult;
						if (selection.getSelectedItem().equals("C")) {
							ArrayList<String> result = process.Combinations(combi, r);
							convertedResult = "Number of possible Combinations of n =  " + combi + " with an r = " + r
									+ " is " + result.size() + "\n" + "The possible combinations are:"
									+ result.toString();
							mode = 'C';

						} else {
							ArrayList<String> result = process.Permutations(combi, r);
							convertedResult = "Number of possible permutations of n =  " + combi + "(" + combi.length()
									+ ") with an r = " + r + " is " + result.size() + "\n"
									+ "The possible combinations are:" + result.toString();
							mode = 'P';
						}
						process.typingText(convertedResult, textArea, submitButton);
						HistoryButton newHistory = new HistoryButton(mode, combi, r, convertedResult);
						aHistory.addHistory(newHistory);
						try {
							hController.saveHistory(aHistory);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						newHistory.setText("Mode: " + mode + "-" + combi);
						if (currentTheme == 0) {
							newHistory.setBackground(darkSecondaryColor);
							newHistory.setForeground(Color.black);
						} else {
							newHistory.setBackground(lightSecondaryColor);
							newHistory.setForeground(Color.white);
						}

						newHistory.setFont(new Font("Inter", Font.PLAIN, 15));
						historyButtonsPanel.add(newHistory);
						historyButtonsPanel.revalidate();
						historyButtonsPanel.repaint();

					}
				}
			} catch (NumberFormatException e1) {
				process.typingText("Wrong format, Please Try Again!", textArea, submitButton);

			}
		}
		textField1.setText("");
		textField2.setText("");

	}

}
