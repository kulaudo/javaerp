package controller.action;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import model.BaseDAO;

public class InsertAction<T> implements Action {
	boolean isEnabled = false;
	BaseDAO<T> dao;
	T object;
	public InsertAction(BaseDAO<T> dao) {
		this.dao = dao;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		insert(object);
	}

	private void insert(T target) {
		dao.create(target);
		
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {

	}

	@Override
	public Object getValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {

		return isEnabled;
	}

	@Override
	public void putValue(String arg0, Object arg1) {
		if (arg0=="target"){
			object= (T) arg1;
		}

	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled(boolean arg0) {
		isEnabled = arg0;

	}

}
