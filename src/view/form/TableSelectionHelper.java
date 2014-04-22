package view.form;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class TableSelectionHelper implements ListSelectionListener, TableModelListener {
    private Object selectedValue;
	private JTable table;
	private DefaultTableModel defaultTableModel;
	private int rowIndex;
	private int colIndex;

    public TableSelectionHelper(JTable table,
			DefaultTableModel defaultTableModel,int column) {
		super();
		this.table = table;
		this.defaultTableModel = defaultTableModel;
		this.colIndex=column;
		
	}

	@Override
    public void valueChanged(ListSelectionEvent event) {
        if (!event.getValueIsAdjusting()) return;
        int selectedIndex = table.getSelectedRow();
        if (selectedIndex >= 0) {
        	selectedValue = defaultTableModel.getValueAt(selectedIndex, colIndex);
            
        } else {
            selectedValue = null;
        }
    }

    @Override
    public void tableChanged(TableModelEvent event) {
        if (selectedValue == null) return;
        int selectedIndex = defaultTableModel.getDataVector().indexOf(selectedValue);
        table.getSelectionModel().setSelectionInterval(selectedIndex, selectedIndex);
    }

	public Object getSelectedValue() {
		return selectedValue;
	}
    
    
}