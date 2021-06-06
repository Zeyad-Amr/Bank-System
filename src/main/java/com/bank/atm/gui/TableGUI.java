package com.bank.atm.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.bank.atm.dao.ProcessDao;
import com.bank.atm.model.Account;
import com.bank.atm.model.CashProcess;

import java.util.List;

public class TableGUI extends JFrame {
	JTable table;
	JFrame frame;

	public TableGUI(Account account) {
		frame = new JFrame();

		String[] column = { "Id", "Process", "Amount", "Balance", " Credit balance", "Date", "Description" };

		List<CashProcess> processes = ProcessDao.findAllByNationalId(account.getNationalId());
		DefaultTableModel model = new DefaultTableModel(column, 0);

		Object[][] data = new Object[processes.size()][7];

		for (int i = 0; i < processes.size(); i++) {
			data[i][0] = i + 1;
			data[i][1] = processes.get(i).getProcess();
			data[i][2] = processes.get(i).getAmount();
			data[i][3] = processes.get(i).getBalance();
			data[i][4] = processes.get(i).getCreditBalance();
			data[i][5] = processes.get(i).getDate();
			data[i][6] = processes.get(i).getDescription();
		}
		for (int i = 0; i < data.length; i++) {

			model.addRow(data[i]);
		}
		table = new JTable(data, column) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		resizeColumnWidth(table);

		table.setPreferredScrollableViewportSize(new Dimension(700, 350));
		table.setFillsViewportHeight(true);
		table.setBackground(new java.awt.Color(34, 45, 65));
		table.setForeground(Color.WHITE);

		JScrollPane sp = new JScrollPane(table);
		table.setRowSelectionAllowed(false);

		frame.add(sp);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(750, 450);
		frame.setTitle("Account Summary");

	}

	public void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 15; // Min width
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			if (width > 300)
				width = 300;
			columnModel.getColumn(column).setPreferredWidth(width);
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			table.getColumnModel().getColumn(column).setCellRenderer(centerRenderer);

		}
	}

}