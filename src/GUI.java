
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
	private JTextArea TextArea = new JTextArea();
	private JTextField textfield = new JTextField();
	private JLabel Label = new JLabel("What would you like to do");
	private JButton buttons = new JButton("Execute");
	private GridLayout Layout = new GridLayout(3, 1);
	private JPanel Panel = new JPanel(Layout);

	public GUI() {
		buttons.addActionListener(this);
		buildWindow();

	}

	public void appendtext(String S) {
		TextArea.append(S.toString() + "\n");
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String s = textfield.getText();
		Game.processCommand(s);

	}

	private void buildWindow() {
		Panel.add(Label);
		Panel.add(textfield);
		Panel.add(buttons);
		setTitle("Tic-Tac-Toe");
		setLayout(new BorderLayout()); // Specifies 3x3 grid layout
		add(TextArea,BorderLayout.CENTER);
		add(Panel,BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null); // Center window
		setVisible(true); // Make window appear
	}
}
