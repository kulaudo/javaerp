package controller.form;

import java.util.ArrayList;
import java.util.Iterator;

import common.State;
import view.IStateObservable;
import view.IStateObserver;

public class StateObservable implements IStateObservable {
	State state;
	ArrayList<IStateObserver> observers= new ArrayList<IStateObserver>();
	
	@Override
	public State getState() {		
		return state;
	}

	@Override
	public void setState(State state) {
		this.state=state;
		notifyObserver();
	}

	@Override
	public void registerStateObserver(IStateObserver s) {
		observers.add(s);

	}

	@Override
	public void removeStateObserver(IStateObserver s) {
		observers.remove(s);

	}

	@Override
	public void notifyObserver() {
		for (Iterator<IStateObserver> iterator = observers.iterator(); iterator.hasNext();) {
			IStateObserver o = (IStateObserver) iterator.next();
			o.update(state);
			
		}

	}

}
