package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import database.Departbasicdata;

public class DepartModel implements IModel {
	private BaseDAO<Departbasicdata> dao=new BaseDAO<Departbasicdata>();
	Object[][] tableModel;
	public Object[][] getTableModel() {
		return tableModel;
	}
	public void setTableModel(Object[][] tableModel) {
		this.tableModel = tableModel;
	}
	public ArrayList<Departbasicdata> departList = new ArrayList<Departbasicdata>();
	public ArrayList<Object[]> rowList=new ArrayList<Object[]>(); 
	public DepartModel() {

		List<Departbasicdata> list=dao.list("select departbasicdata from Departbasicdata as departbasicdata");
		for (Iterator<Departbasicdata> iterator = list.iterator(); iterator.hasNext();) {
			Departbasicdata departbasicdata = (Departbasicdata) iterator.next();
			Object[] row=new Object[]{
				departbasicdata.getDepartId(),departbasicdata.getDepartAlias()
			};
			departList.add( departbasicdata);
			rowList.add(row);
		}
		
		tableModel = rowList.toArray(new Object[rowList.size()][]);

	}
	public Departbasicdata getSelectedDepart(int row){
		return departList.get(row);
	}
}
