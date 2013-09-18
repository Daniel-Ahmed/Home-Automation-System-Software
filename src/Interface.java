import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * TODO Alarm System
 */
public class Interface extends JFrame implements ActionListener, ChangeListener {

	private static final long serialVersionUID = 1L;

	private House house = new House();
	private Shopping shopping = new Shopping();
	private List<Door> d = house.getDoor();
	private List<Garage> g = house.getGarage();
	private List<Light> l = house.getLight();

	// Timer
	private Timer timerOn[] = new Timer[l.size()], timerOff[] = new Timer[l
			.size()];

	// UI Looks and Design
	private DecimalFormat DF = new DecimalFormat("0.00");
	private Font f = new Font("Arial", Font.PLAIN, 12);
	private ImageIcon ICON_TIMED = createImageIcon("images/Icon_Timed.png");

	// Components;
	private JTabbedPane TABPANE;
	private JPanel MASTERPANEL, DOORPANEL, LIGHTPANEL, SHOPPINGPANEL;

	// Door
	private JLabel LBL_DOOR_NAME[] = new JLabel[d.size()],
			LBL_DOORSTATUS[] = new JLabel[d.size()];
	private JButton BTN_OPEN[] = new JButton[d.size()],
			BTN_CLOSE[] = new JButton[d.size()];
	private JRadioButton RB_LOCK[] = new JRadioButton[d.size()],
			RB_UNLOCK[] = new JRadioButton[d.size()];

	// Garage
	private JLabel LBL_GARAGE_NAME[] = new JLabel[g.size()],
			LBL_GARAGESTATUS[] = new JLabel[g.size()];
	private JButton BTN_GARAGE_LOCK[] = new JButton[g.size()],
			BTN_GARAGE_UNLOCK[] = new JButton[g.size()];

	// Light
	private JLabel LBL_LIGHT[] = new JLabel[l.size()],
			LBL_DIMSETTINGS[] = new JLabel[l.size()],
			LBL_LIGHTSTATUS[] = new JLabel[l.size()];
	private JRadioButton RB_ON[] = new JRadioButton[l.size()],
			RB_OFF[] = new JRadioButton[l.size()];
	private JSlider S_DIM[] = new JSlider[l.size()];
	private JButton BTN_TIMERON[] = new JButton[l.size()],
			BTN_TIMEROFF[] = new JButton[l.size()];

	// Shopping
	private JButton BTN_ADD, BTN_VIEWLIST, BTN_DELETE, BTN_ORDER;
	private JTextField JTF_PRODUCT, JTF_PRICE;
	private ImageIcon ICON_PRICE;
	private JLabel LBL_COST;
	private DefaultListModel<Item> items = new DefaultListModel<Item>();
	private JList<Item> itemList = new JList<Item>(items);

	// Master
	private JLabel M_LBL_DOOR[] = new JLabel[d.size()],
			M_LBL_GARAGE_DOOR[] = new JLabel[g.size()],
			M_LBL_LIGHT[] = new JLabel[l.size()];
	private JButton M_BTN_OPEN, M_BTN_CLOSE, M_BTN_LOCK, M_BTN_UNLOCK,
			M_BTN_ON, M_BTN_OFF, M_BTN_TIMERON, M_BTN_TIMEROFF;
	private JSlider M_DIMSLIDER;

	public Interface() {
		setTitle("Daniel Ahmed - Home Automation System");
		setSize(600, 500);
		setLocation(100, 100);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Instantiate Components
		TABPANE = new JTabbedPane();
		MASTERPANEL = new JPanel(null);
		DOORPANEL = new JPanel(null);
		LIGHTPANEL = new JPanel(null);
		SHOPPINGPANEL = new JPanel(null);

		// Create Tab Panel
		add(TABPANE);

		// Create GUI
		masterGUI();
		doorGUI();
		lightGUI();
		shoppingGUI();

		// Create Tabs
		TABPANE.add("Master Controls", MASTERPANEL);
		TABPANE.addTab("Doors", DOORPANEL);
		TABPANE.add("Lights", LIGHTPANEL);
		TABPANE.addTab("Shopping", SHOPPINGPANEL);
	}

	public void doorGUI() {
		int currentHeight = 25;

		/*
		 * DOOR UI
		 */

		for (int i = 0; i < d.size(); i++) {
			Door door = d.get(i);

			LBL_DOOR_NAME[i] = new JLabel(door.toString());
			LBL_DOOR_NAME[i].setBounds(25, currentHeight, 90, 15);
			LBL_DOOR_NAME[i].setFont(f);

			BTN_OPEN[i] = new JButton("Open");
			BTN_OPEN[i].setBounds(100, currentHeight, 75, 20);
			BTN_OPEN[i].setFont(f);
			BTN_OPEN[i].addActionListener(this);

			BTN_CLOSE[i] = new JButton("Close");
			BTN_CLOSE[i].setBounds(180, currentHeight, 75, 20);
			BTN_CLOSE[i].setFont(f);
			BTN_CLOSE[i].addActionListener(this);

			RB_LOCK[i] = new JRadioButton("Locked");
			RB_LOCK[i].setBounds(260, currentHeight, 70, 20);
			RB_LOCK[i].setSelected(true);
			RB_LOCK[i].setFont(f);
			RB_LOCK[i].addActionListener(this);

			RB_UNLOCK[i] = new JRadioButton("Unlocked");
			RB_UNLOCK[i].setBounds(330, currentHeight, 80, 20);
			RB_UNLOCK[i].setFont(f);
			RB_UNLOCK[i].addActionListener(this);

			LBL_DOORSTATUS[i] = new JLabel("Status: " + door.status());
			LBL_DOORSTATUS[i].setBounds(430, currentHeight, 150, 15);
			LBL_DOORSTATUS[i].setFont(f);

			currentHeight += 30;

			DOORPANEL.add(LBL_DOOR_NAME[i]);
			DOORPANEL.add(BTN_OPEN[i]);
			DOORPANEL.add(BTN_CLOSE[i]);
			DOORPANEL.add(RB_LOCK[i]);
			DOORPANEL.add(RB_UNLOCK[i]);
			DOORPANEL.add(LBL_DOORSTATUS[i]);
		}

		/*
		 * GARAGE UI
		 */

		for (int i = 0; i < g.size(); i++) {
			Garage garage = g.get(i);

			LBL_GARAGE_NAME[i] = new JLabel(garage.toString());
			LBL_GARAGE_NAME[i].setBounds(25, currentHeight, 90, 15);
			LBL_GARAGE_NAME[i].setFont(f);

			BTN_GARAGE_UNLOCK[i] = new JButton("Open");
			BTN_GARAGE_UNLOCK[i].setBounds(100, currentHeight, 75, 20);
			BTN_GARAGE_UNLOCK[i].setFont(f);
			BTN_GARAGE_UNLOCK[i].addActionListener(this);

			BTN_GARAGE_LOCK[i] = new JButton("Close");
			BTN_GARAGE_LOCK[i].setBounds(180, currentHeight, 75, 20);
			BTN_GARAGE_LOCK[i].setFont(f);
			BTN_GARAGE_LOCK[i].addActionListener(this);

			LBL_GARAGESTATUS[i] = new JLabel("Status: " + garage.status());
			LBL_GARAGESTATUS[i].setBounds(430, currentHeight, 150, 15);
			LBL_GARAGESTATUS[i].setFont(f);

			currentHeight += 30;

			DOORPANEL.add(LBL_GARAGE_NAME[i]);
			DOORPANEL.add(BTN_GARAGE_LOCK[i]);
			DOORPANEL.add(BTN_GARAGE_UNLOCK[i]);
			DOORPANEL.add(LBL_GARAGESTATUS[i]);
		}
	}

	public void lightGUI() {

		int y = 25;

		for (int i = 0; i < l.size(); i++) {
			Light light = l.get(i);

			LBL_LIGHT[i] = new JLabel(light.toString());
			LBL_LIGHT[i].setBounds(25, y, 90, 15);
			LBL_LIGHT[i].setFont(f);

			RB_ON[i] = new JRadioButton("On");
			RB_ON[i].setBounds(100, y, 50, 20);
			RB_ON[i].setSelected(false);
			RB_ON[i].setFont(f);
			RB_ON[i].addActionListener(this);

			RB_OFF[i] = new JRadioButton("Off");
			RB_OFF[i].setBounds(150, y, 50, 20);
			RB_OFF[i].setSelected(true);
			RB_OFF[i].setFont(f);
			RB_OFF[i].addActionListener(this);

			LBL_LIGHTSTATUS[i] = new JLabel("Status: " + light.status());
			LBL_LIGHTSTATUS[i].setBounds(225, y, 85, 20);
			LBL_LIGHTSTATUS[i].setFont(f);

			BTN_TIMERON[i] = new JButton("Timed On", ICON_TIMED);
			BTN_TIMERON[i].setBounds(320, y, 120, 30);
			BTN_TIMERON[i].setFont(f);
			BTN_TIMERON[i].addActionListener(this);

			BTN_TIMEROFF[i] = new JButton("Timed Off", ICON_TIMED);
			BTN_TIMEROFF[i].setBounds(450, y, 120, 30);
			BTN_TIMEROFF[i].setFont(f);
			BTN_TIMEROFF[i].addActionListener(this);

			y += 35;

			LBL_DIMSETTINGS[i] = new JLabel("Dim Settings: ");
			LBL_DIMSETTINGS[i].setBounds(25, y, 90, 15);
			LBL_DIMSETTINGS[i].setFont(f);

			S_DIM[i] = new JSlider();
			S_DIM[i].setBounds(150, y, 150, 40);
			// Set Maximum and Minimum Value on slider
			S_DIM[i].setMaximum(100);
			S_DIM[i].setMinimum(0);
			// Set Value to 0 (Dim is off)
			S_DIM[i].setValue(0);
			// Set Spacing values
			S_DIM[i].setMajorTickSpacing(25);
			S_DIM[i].setMinorTickSpacing(5);
			// Make Paint Visible
			S_DIM[i].setPaintTicks(true);
			S_DIM[i].setPaintLabels(true);
			S_DIM[i].setFont(f);
			S_DIM[i].addChangeListener(this);

			y += 50;

			LIGHTPANEL.add(LBL_LIGHT[i]);
			LIGHTPANEL.add(RB_ON[i]);
			LIGHTPANEL.add(RB_OFF[i]);
			LIGHTPANEL.add(LBL_DIMSETTINGS[i]);
			LIGHTPANEL.add(S_DIM[i]);
			LIGHTPANEL.add(LBL_LIGHTSTATUS[i]);
			LIGHTPANEL.add(BTN_TIMERON[i]);
			LIGHTPANEL.add(BTN_TIMEROFF[i]);
		}

	}

	public void masterGUI() {

		/*
		 * DOOR + GARAGE
		 */
		int x = 75;
		int y = 75;

		for (int i = 0; i < d.size(); i++) {
			Door door = d.get(i);
			M_LBL_DOOR[i] = new JLabel(door.toString() + " " + door.status());
			M_LBL_DOOR[i].setBounds(x, y, 110, 15);
			M_LBL_DOOR[i].setFont(f);
			x += 160;

			// 2 Column Layout
			if (x > 320) {
				x = 75;
				y += 20;
			}

			MASTERPANEL.add(M_LBL_DOOR[i]);
		}

		for (int i = 0; i < g.size(); i++) {
			Garage garage = g.get(i);
			M_LBL_GARAGE_DOOR[i] = new JLabel(garage.toString() + " "
					+ garage.status());
			M_LBL_GARAGE_DOOR[i].setBounds(75, y, 110, 15);
			M_LBL_GARAGE_DOOR[i].setFont(f);
			x += 160;

			// 2 Column Layout
			if (x > 320) {
				x = 75;
				y += 20;
			}

			MASTERPANEL.add(M_LBL_GARAGE_DOOR[i]);
		}

		ImageIcon ICON_OPEN = createImageIcon("images/Icon_Open.png");
		M_BTN_OPEN = new JButton("Open", ICON_OPEN);
		M_BTN_OPEN.setBounds(75, 25, 100, 30);
		M_BTN_OPEN.setFont(f);
		M_BTN_OPEN.addActionListener(this);

		ImageIcon ICON_CLOSE = createImageIcon("images/Icon_Closed.png");
		M_BTN_CLOSE = new JButton("Close", ICON_CLOSE);
		M_BTN_CLOSE.setBounds(185, 25, 100, 30);
		M_BTN_CLOSE.setFont(f);
		M_BTN_CLOSE.addActionListener(this);

		ImageIcon ICON_LOCKED = createImageIcon("images/Icon_Locked.png");
		M_BTN_LOCK = new JButton("Lock", ICON_LOCKED);
		M_BTN_LOCK.setBounds(295, 25, 100, 30);
		M_BTN_LOCK.setFont(f);
		M_BTN_LOCK.addActionListener(this);

		ImageIcon ICON_UNLOCKED = createImageIcon("images/Icon_Unlocked.png");
		M_BTN_UNLOCK = new JButton("Unlock", ICON_UNLOCKED);
		M_BTN_UNLOCK.setBounds(405, 25, 100, 30);
		M_BTN_UNLOCK.setFont(f);
		M_BTN_UNLOCK.addActionListener(this);

		/*
		 * LIGHTS
		 */

		ImageIcon ICON_ON = createImageIcon("images/Icon_On.png");
		M_BTN_ON = new JButton("On", ICON_ON);
		M_BTN_ON.setBounds(75, 150, 100, 30);
		M_BTN_ON.setFont(f);
		M_BTN_ON.addActionListener(this);

		ImageIcon ICON_OFF = createImageIcon("images/Icon_Off.png");
		M_BTN_OFF = new JButton("Off", ICON_OFF);
		M_BTN_OFF.setBounds(185, 150, 100, 30);
		M_BTN_OFF.setFont(f);
		M_BTN_OFF.addActionListener(this);

		M_DIMSLIDER = new JSlider();
		M_DIMSLIDER.setBounds(295, 150, 200, 40);
		// Minimum + Maximum
		M_DIMSLIDER.setMaximum(100);
		M_DIMSLIDER.setMinimum(0);
		// Default Value
		M_DIMSLIDER.setValue(0);
		// Set Minor and Major ticks
		M_DIMSLIDER.setMinorTickSpacing(5);
		M_DIMSLIDER.setMajorTickSpacing(25);
		// Set Paint True
		M_DIMSLIDER.setPaintTicks(true);
		M_DIMSLIDER.setPaintLabels(true);
		M_DIMSLIDER.addChangeListener(this);

		x = 75;
		y = 200;

		for (int i = 0; i < l.size(); i++) {
			Light light = l.get(i);
			M_LBL_LIGHT[i] = new JLabel(light.toString() + " " + light.status());
			M_LBL_LIGHT[i].setBounds(x, y, 110, 15);
			M_LBL_LIGHT[i].setFont(f);
			x += 110;

			// 2 Column Layout
			if (x > 220) {
				x = 75;
				y += 20;
			}

			MASTERPANEL.add(M_LBL_LIGHT[i]);
		}

		M_BTN_TIMERON = new JButton("Timer On", ICON_TIMED);
		M_BTN_TIMERON.setBounds(75, y + 20, 110, 30);
		M_BTN_TIMERON.setFont(f);
		M_BTN_TIMERON.addActionListener(this);

		M_BTN_TIMEROFF = new JButton("Timer Off", ICON_TIMED);
		M_BTN_TIMEROFF.setBounds(195, y + 20, 110, 30);
		M_BTN_TIMEROFF.setFont(f);
		M_BTN_TIMEROFF.addActionListener(this);

		MASTERPANEL.add(M_BTN_OPEN);
		MASTERPANEL.add(M_BTN_CLOSE);
		MASTERPANEL.add(M_BTN_LOCK);
		MASTERPANEL.add(M_BTN_UNLOCK);
		MASTERPANEL.add(M_BTN_ON);
		MASTERPANEL.add(M_BTN_OFF);
		MASTERPANEL.add(M_DIMSLIDER);
		MASTERPANEL.add(M_BTN_TIMERON);
		MASTERPANEL.add(M_BTN_TIMEROFF);

	}

	public void shoppingGUI() {

		/*
		 * Create Icon Create Label with Icon Set Font Set Bounds
		 */

		ImageIcon ICON_BARCODE = createImageIcon("images/Icon_Barcode.png");
		JLabel LBL_PRODUCT = new JLabel("Product:", ICON_BARCODE, 0);
		LBL_PRODUCT.setFont(f);
		LBL_PRODUCT.setBounds(5, 15, 100, 40);

		/*
		 * Create Text Field Set Bounds
		 */

		JTF_PRODUCT = new JTextField();
		JTF_PRODUCT.setBounds(110, 25, 150, 25);

		ImageIcon ICON_TAG = createImageIcon("images/Icon_Tag.png");
		JLabel LBL_PRICE = new JLabel("Price:", ICON_TAG, 0);
		LBL_PRICE.setFont(f);
		LBL_PRICE.setBounds(5, 70, 80, 40);

		JTF_PRICE = new JTextField();
		JTF_PRICE.setBounds(110, 80, 150, 25);
		JTF_PRICE.setText("0.00");

		ImageIcon ICON_ADD = createImageIcon("images/Icon_Add.png");
		BTN_ADD = new JButton("Add item", ICON_ADD);
		BTN_ADD.setFont(f);
		BTN_ADD.setBounds(5, 130, 120, 40);
		BTN_ADD.addActionListener(this);

		ImageIcon ICON_VIEWLIST = createImageIcon("images/Icon_List.png");
		BTN_VIEWLIST = new JButton("View List", ICON_VIEWLIST);
		BTN_VIEWLIST.setFont(f);
		BTN_VIEWLIST.setBounds(140, 130, 120, 40);
		BTN_VIEWLIST.addActionListener(this);

		ImageIcon ICON_DELETE = createImageIcon("images/Icon_Delete.png");
		BTN_DELETE = new JButton("Delete Item", ICON_DELETE);
		BTN_DELETE.setFont(f);
		BTN_DELETE.setBounds(5, 180, 120, 40);
		BTN_DELETE.addActionListener(this);

		ImageIcon ICON_ORDER = createImageIcon("images/Icon_Order.png");
		BTN_ORDER = new JButton("Order", ICON_ORDER);
		BTN_ORDER.setFont(f);
		BTN_ORDER.setBounds(140, 180, 120, 40);
		BTN_ORDER.addActionListener(this);

		ICON_PRICE = createImageIcon("images/Icon_Price.png");
		LBL_COST = new JLabel("Total Cost: £" + DF.format(shopping.total()),
				ICON_PRICE, 0);
		LBL_COST.setFont(f);
		LBL_COST.setBounds(5, 230, 150, 40);

		itemList.setBounds(300, 15, 275, 400);
		itemList.setVisible(false);

		SHOPPINGPANEL.add(LBL_PRODUCT);
		SHOPPINGPANEL.add(JTF_PRODUCT);
		SHOPPINGPANEL.add(LBL_PRICE);
		SHOPPINGPANEL.add(JTF_PRICE);
		SHOPPINGPANEL.add(BTN_ADD);
		SHOPPINGPANEL.add(BTN_VIEWLIST);
		SHOPPINGPANEL.add(BTN_DELETE);
		SHOPPINGPANEL.add(BTN_ORDER);
		SHOPPINGPANEL.add(LBL_COST);
		SHOPPINGPANEL.add(itemList);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// DOOR LOOP
		for (int i = 0; i < d.size(); i++) {
			Door door = d.get(i);

			// OPEN BUTTON
			if (e.getSource() == BTN_OPEN[i]) {
				if (door.isLocked()) { // If door is locked
					JOptionPane.showMessageDialog(null, door.toString()
							+ " is locked, unlock it!", door.toString()
							+ " is locked.", 2);
				} else {
					door.open();
					LBL_DOORSTATUS[i].setText("Status: " + door.status());
					M_LBL_DOOR[i]
							.setText(door.toString() + " " + door.status());
				}
			}

			// CLOSE BUTTON
			if (e.getSource() == BTN_CLOSE[i]) {
				if (!door.isOpen()) { // If door is not open
					JOptionPane.showMessageDialog(null, door.toString()
							+ " is already closed!", door.toString()
							+ " already closed.", 2);
				} else {
					door.close();
					LBL_DOORSTATUS[i].setText("Status: " + door.status());
					M_LBL_DOOR[i]
							.setText(door.toString() + " " + door.status());
				}
			}

			// LOCK RADIO BUTTON
			if (e.getSource() == RB_LOCK[i]) {
				if (door.isOpen()) { // If door is open
					RB_LOCK[i].setSelected(false);
					RB_UNLOCK[i].setSelected(true);
					JOptionPane.showMessageDialog(null, door.toString()
							+ " is open, close it!", door.toString()
							+ " is opened!", 2);
				} else if (door.isLocked()) { // If door is locked
					RB_LOCK[i].setSelected(true);
					RB_UNLOCK[i].setSelected(false);
					JOptionPane.showMessageDialog(null, door.toString()
							+ " is already locked!", door.toString()
							+ " already locked.", 2);
				} else {
					door.lock();
					RB_LOCK[i].setSelected(true);
					RB_UNLOCK[i].setSelected(false);
					LBL_DOORSTATUS[i].setText("Status: " + door.status());
					M_LBL_DOOR[i]
							.setText(door.toString() + " " + door.status());
				}
			}

			// UNLOCK RADIO BUTTON
			if (e.getSource() == RB_UNLOCK[i]) {
				if (!door.isLocked()) { // If door is not locked
					RB_LOCK[i].setSelected(false);
					RB_UNLOCK[i].setSelected(true);
					JOptionPane.showMessageDialog(null, door.toString()
							+ " is already unlocked!", door.toString()
							+ " already unlocked.", 2);
				} else {
					door.unlock();
					RB_LOCK[i].setSelected(false);
					RB_UNLOCK[i].setSelected(true);
					LBL_DOORSTATUS[i].setText("Status: " + door.status());
					M_LBL_DOOR[i]
							.setText(door.toString() + " " + door.status());
				}
			}

			/*
			 * MASTER CONTROLS FOR DOOR
			 */

			// Open Button
			if (e.getSource() == M_BTN_OPEN) {
				if (door.isLocked()) {
					door.unlock();
					door.open();
					RB_LOCK[i].setSelected(false);
					RB_UNLOCK[i].setSelected(true);
					M_LBL_DOOR[i]
							.setText(door.toString() + " " + door.status());
					LBL_DOORSTATUS[i].setText("Status: " + door.status());
				} else {
					door.open();
					RB_LOCK[i].setSelected(false);
					RB_UNLOCK[i].setSelected(true);
					M_LBL_DOOR[i]
							.setText(door.toString() + " " + door.status());
					LBL_DOORSTATUS[i].setText("Status: " + door.status());
				}
			}

			// Close Button
			if (e.getSource() == M_BTN_CLOSE) {
				if (door.isOpen()) {
					door.close();
					RB_LOCK[i].setSelected(false);
					RB_UNLOCK[i].setSelected(true);
					LBL_DOORSTATUS[i].setText("Status: " + door.status());
					M_LBL_DOOR[i]
							.setText(door.toString() + " " + door.status());
				}
			}

			// Lock Radio Button
			if (e.getSource() == M_BTN_LOCK) {
				if (door.isOpen()) {
					door.close();
					door.lock();
					RB_LOCK[i].setSelected(true);
					RB_UNLOCK[i].setSelected(false);
					LBL_DOORSTATUS[i].setText("Status: " + door.status());
					M_LBL_DOOR[i]
							.setText(door.toString() + " " + door.status());
				} else {
					door.lock();
					RB_LOCK[i].setSelected(true);
					RB_UNLOCK[i].setSelected(false);
					LBL_DOORSTATUS[i].setText("Status: " + door.status());
					M_LBL_DOOR[i]
							.setText(door.toString() + " " + door.status());
				}
			}

			// Unlock Radio Button
			if (e.getSource() == M_BTN_UNLOCK) {
				if (door.isLocked()) {
					door.unlock();
					RB_LOCK[i].setSelected(false);
					RB_UNLOCK[i].setSelected(true);
					LBL_DOORSTATUS[i].setText("Status: " + door.status());
					M_LBL_DOOR[i]
							.setText(door.toString() + " " + door.status());
				}
			}
		}

		// Garage Loop
		for (int i = 0; i < g.size(); i++) {
			Garage garage = g.get(i);

			// GARAGE UNLOCK BUTTON
			if (e.getSource() == BTN_GARAGE_UNLOCK[i]) {
				if (garage.isLocked()) {
					garage.unlock();
					LBL_GARAGESTATUS[i].setText("Status: " + garage.status());
					M_LBL_GARAGE_DOOR[i].setText("Status: " + garage.status());
				} else {
					JOptionPane.showMessageDialog(null,
							"Garage already opened!", "Garage open.", 2);
				}
			}

			// GARAGE LOCK BUTTON
			if (e.getSource() == BTN_GARAGE_LOCK[i]) {
				if (!garage.isLocked()) {
					garage.lock();
					LBL_GARAGESTATUS[i].setText("Status: " + garage.status());
					M_LBL_GARAGE_DOOR[i].setText("Status: " + garage.status());
				} else {
					JOptionPane.showMessageDialog(null,
							"Garage already locked!", "Garage locked.", 2);
				}
			}

			/*
			 * MASTER CONTROLS FOR GARAGE
			 */

			// Garage Unlock
			if (e.getSource() == M_BTN_OPEN) {
				garage.unlock();
				LBL_GARAGESTATUS[i].setText("Status: " + garage.status());
				M_LBL_GARAGE_DOOR[i].setText(garage.toString() + " "
						+ garage.status());
			}

			// Garage Lock
			if (e.getSource() == M_BTN_CLOSE) {
				garage.lock();
				LBL_GARAGESTATUS[i].setText("Status: " + garage.status());
				M_LBL_GARAGE_DOOR[i].setText(garage.toString() + " "
						+ garage.status());
			}
		}

		// Light Loop
		for (int i = 0; i < l.size(); i++) {
			final Light light = l.get(i);

			if (e.getSource() == RB_ON[i]) {
				if (!light.isOn()) {
					light.turnOn();
					RB_ON[i].setSelected(true);
					RB_OFF[i].setSelected(false);
					LBL_LIGHTSTATUS[i].setText("Status: " + light.status());
					M_LBL_LIGHT[i].setText(light.toString() + " "
							+ light.status());
				}
			}

			if (e.getSource() == RB_OFF[i]) {
				if (light.isOn()) {
					light.turnOff();
					RB_ON[i].setSelected(false);
					RB_OFF[i].setSelected(true);
					LBL_LIGHTSTATUS[i].setText("Status: " + light.status());
					M_LBL_LIGHT[i].setText(light.toString() + " "
							+ light.status());
				}
			}

			if (e.getSource() == BTN_TIMERON[i]) {
				timerOn[i] = new Timer(1000, this);
				timerOn[i].start();
			}

			if (e.getSource() == timerOn[i]) {
				light.turnOn();
				timerOn[i].stop();
				RB_ON[i].setSelected(true);
				RB_OFF[i].setSelected(false);
				LBL_LIGHTSTATUS[i].setText("Status: " + light.status());
				M_LBL_LIGHT[i].setText(light.toString() + " " + light.status());
			}

			if (e.getSource() == BTN_TIMEROFF[i]) {
				timerOff[i] = new Timer(1000, this);
				timerOff[i].start();
			}

			if (e.getSource() == timerOff[i]) {
				light.turnOff();
				timerOff[i].stop();
				RB_ON[i].setSelected(false);
				RB_OFF[i].setSelected(true);
				LBL_LIGHTSTATUS[i].setText("Status: " + light.status());
				M_LBL_LIGHT[i].setText(light.toString() + " " + light.status());
			}

			/*
			 * MASTER CONTROL FOR LIGHT
			 */

			if (e.getSource() == M_BTN_ON) {
				light.turnOn();
				RB_ON[i].setSelected(true);
				RB_OFF[i].setSelected(false);
				LBL_LIGHTSTATUS[i].setText(light.toString() + " "
						+ light.status());
				M_LBL_LIGHT[i].setText(light.toString() + " " + light.status());
			}

			if (e.getSource() == M_BTN_OFF) {
				light.turnOff();
				RB_ON[i].setSelected(false);
				RB_OFF[i].setSelected(true);
				LBL_LIGHTSTATUS[i].setText(light.toString() + " "
						+ light.status());
				M_LBL_LIGHT[i].setText(light.toString() + " " + light.status());
			}

			if (e.getSource() == M_BTN_TIMERON) {
				timerOn[i] = new Timer(1000, this);
				timerOn[i].start();
			}

			if (e.getSource() == M_BTN_TIMEROFF) {
				timerOff[i] = new Timer(1000, this);
				timerOff[i].start();
			}
		}

		/*
		 * SHOPPING CONTROLS
		 */

		if (e.getSource() == BTN_ADD) {
			String product = JTF_PRODUCT.getText();
			double price = Double.parseDouble(JTF_PRICE.getText());
			DF.format(price);
			Item i = new Item(product, price);

			shopping.addItem(i);
			items.addElement(i);
			JTF_PRODUCT.setText("");
			JTF_PRICE.setText("");

			LBL_COST.setText("Total Cost: £" + DF.format(shopping.total()));
		}

		if (e.getSource() == BTN_VIEWLIST) {
			if (!itemList.isVisible()) {
				itemList.setVisible(true);
				BTN_VIEWLIST.setText("Hide List");
			} else {
				itemList.setVisible(false);
				BTN_VIEWLIST.setText("View List");
			}
		}

		if (e.getSource() == BTN_DELETE) {

			@SuppressWarnings("deprecation")
			Object[] selectedItems = itemList.getSelectedValues();

			for (int i = 0; i < selectedItems.length; i++) {
				items.removeElement(selectedItems[i]);
				shopping.removeItem((Item) selectedItems[i]);
			}

			LBL_COST.setText("Total Cost: £" + DF.format(shopping.total()));
		}

		if (e.getSource() == BTN_ORDER) {
			if (!items.isEmpty()) {
				shopping.order();
				items.clear();
				JOptionPane.showMessageDialog(null,
						"Items have been ordered! Thank you!",
						"Items Ordered!", JOptionPane.INFORMATION_MESSAGE);
				LBL_COST.setText("Total Cost: £" + DF.format(shopping.total()));
			} else {
				JOptionPane.showMessageDialog(null, "You have no items!",
						"Empty Basket!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	@Override
	public void stateChanged(ChangeEvent c) {
		for (int i = 0; i < l.size(); i++) {
			Light light = l.get(i);

			if (S_DIM[i].getValueIsAdjusting()) {
				light.setDimValue((int) S_DIM[i].getValue());
			}

			if (M_DIMSLIDER.getValueIsAdjusting()) {
				S_DIM[i].setValue(M_DIMSLIDER.getValue());
				light.setDimValue((int) M_DIMSLIDER.getValue());
			}
		}
	}

	/*
	 * Copy pasted from docs.oracle.com
	 */
	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
