package controller.action;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import common.HibernateUtil;

public class RefreshRecordAction implements Action {
	boolean enabled=false;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		HibernateUtil.getSessionFactory().getCurrentSession().flush();		
		HibernateUtil.shutdown();
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {		
		return enabled;
	}

	@Override
	public void putValue(String arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled(boolean b) {
		enabled=b;

	}

}
