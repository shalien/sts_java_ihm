import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame implements ActionListener, ItemListener, AdjustmentListener {

    final JPanel panel = new JPanel();

    final JPanel titlePanel = new JPanel();
    final JButton onButton = new JButton("Marche");
    final JButton offButton = new JButton("Arret");

    final JLabel titleLabel = new JLabel("Formation STS - La Chataigneraie", SwingConstants.CENTER);
    final JTextField titleTextField = new JTextField("Java");

    final JTextArea textArea = new JTextArea(10, 20);

    final JPanel subPanel = new JPanel();

   final GridLayout gridLayout = new GridLayout(3, 2);

   final JPanel radioCheckPanel = new JPanel();

   final JCheckBox[] kebab = new JCheckBox[]{new JCheckBox("Salade"), new JCheckBox("Tomates"), new JCheckBox("Ognions")};
   final ButtonGroup kebabButtonGroup = new ButtonGroup();
   final JPanel kebabPanel = new JPanel();
   final JLabel kebakLabel = new JLabel("Menu : ");
   final JRadioButton[] cities = new JRadioButton[]{ new JRadioButton("Rouen", true), new JRadioButton("Lille"), new JRadioButton("Element")};
   final ButtonGroup citiesButtonGroup = new ButtonGroup();

   // Combo
    final JPanel comboPanel = new JPanel();
    final JLabel genreLabel = new JLabel("Genre :");
    final JComboBox<String> comboBox = new JComboBox<>();


    public MainFrame() {
        this.setBounds(100,200,800,600);
        this.setTitle("UTC503 - Cours d'interface graphique");
        this.setLocationRelativeTo(null);

        panel.setLayout(gridLayout);
        onButton.addActionListener(this);
        titlePanel.add(onButton);
        offButton.addActionListener(this);
        titlePanel.add(offButton);

        subPanel.add(titleLabel);
        subPanel.add(titleTextField);

        // Radio
        for (JRadioButton radioButton: cities) {
            radioButton.addItemListener(this);
            citiesButtonGroup.add(radioButton);
            radioCheckPanel.add(radioButton);
        }

        // Kebab
        kebabPanel.add(kebakLabel);
        for(JCheckBox checkBox : kebab) {
            checkBox.addItemListener(this);
            kebabButtonGroup.add(checkBox);
            kebabPanel.add(checkBox);
        }

        // Genre Combo
        comboPanel.add(genreLabel);
        final List<String> genres = new ArrayList<>(List.of(new String[]{"Homme", "Femme", "JVM"}));
        for(String genre : genres) {
            comboBox.addItem(genre);
        }
        comboBox.addItemListener(this);
        comboPanel.add(comboBox);

        final JScrollBar scrollbar = new JScrollBar();
        scrollbar.setBlockIncrement(1);
        scrollbar.setMaximum(69);
        scrollbar.setMinimum(0);
        scrollbar.addAdjustmentListener(this);

        // G
        panel.add(titlePanel);
        // D
        panel.add(kebabPanel);
        // G
        panel.add(subPanel);
        // D
        panel.add(radioCheckPanel);
        // G
        panel.add(textArea);
        // D
        panel.add(comboPanel);

        //G
        panel.add(scrollbar);

        this.setContentPane(panel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog();
        dialog.setBounds(100, 100, 600, 200);
        dialog.setLocationRelativeTo(null);
        dialog.setTitle("Action performed");

        JPanel dialogPanel = new JPanel();
        JTextArea dialogTextArea = new JTextArea();
        dialogTextArea.setEditable(false);
        dialogTextArea.setText(((JButton) e.getSource()).getText());

        dialogPanel.add(dialogTextArea);

        dialog.setContentPane(dialogPanel);
        dialog.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JDialog dialog = new JDialog();
        dialog.setBounds(100, 100, 600, 200);
        dialog.setLocationRelativeTo(null);
        dialog.setTitle("Item state changed");

        JPanel dialogPanel = new JPanel();
        JTextArea dialogTextArea = new JTextArea();
        dialogTextArea.setEditable(false);
        dialogTextArea.setText(e.getItem().toString());

        dialogPanel.add(dialogTextArea);

        dialog.setContentPane(dialogPanel);
        dialog.setVisible(true);
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        JDialog dialog = new JDialog();
        dialog.setBounds(100, 100, 600, 200);
        dialog.setLocationRelativeTo(null);
        dialog.setTitle("value adjusted changed");

        JPanel dialogPanel = new JPanel();
        JTextArea dialogTextArea = new JTextArea();
        dialogTextArea.setEditable(false);
        dialogTextArea.setText(String.valueOf(e.getValue()));

        dialogPanel.add(dialogTextArea);

        dialog.setContentPane(dialogPanel);
        dialog.setVisible(true);
    }
}
