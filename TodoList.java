import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoList extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> todoList;
    private JTextField inputField;
    private JButton addButton;
    private JButton removeButton;

    public TodoList() {
        super("To-Do List");

        // Create the list model and list
        listModel = new DefaultListModel<>();
        todoList = new JList<>(listModel);

        // Create the input field
        inputField = new JTextField(20);

        // Create the buttons
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");

        // Set up the layout
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(todoList), BorderLayout.CENTER);
        add(removeButton, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String item = inputField.getText();
                if (!item.isEmpty()) {
                    listModel.addElement(item);
                    inputField.setText("");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = todoList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });

        // Set up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TodoList();
            }
        });
    }
}