package com.bank.atm.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableGUI extends JFrame {
	JTable table;
	JFrame frame;

	public TableGUI() {
		frame = new JFrame();
		String[] colname = { "Process", "Amount", "Balance", " Credit balance", "Date", "Description" };
		Object[][] data = { { "deposit", 3000, 56000, "30/5/2021", "Description" },
				{ "withdraw", 5000, 51000, "30/5/2022", "description" },
				{ "withdraw", 5000, 51000, "30/5/2022", "description" },
				{ "withdraw", 5000, 51000, "30/5/2022", "description" },
				{ "withdraw", 5000, 51000, "30/5/2022", "description" },
				{ "deposit", 3000, 56000, "30/5/2021", "Description" },
				{ "deposit", 3000, 56000, "30/5/2021", "Description" },
				{ "deposit", 3000, 56000, "30/5/2021", "Description" },
				{ "deposit", 3000, 56000, "30/5/2021", "Description" } };
		DefaultTableModel model = new DefaultTableModel(colname, 0);
		table = new JTable(model);
		for (int i = 0; i < data.length; i++) {
			model.addRow(data[i]);
		}
		table.setPreferredScrollableViewportSize(new Dimension(600, 290));
		table.setFillsViewportHeight(true);
		JScrollPane sp = new JScrollPane(table);
		frame.add(sp);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(700, 400);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Last Processes");

	}
}