package view;

import common.State;


public interface IStateObservable {
	State getState();
	void setState(State state);
	void registerStateObserver(IStateObserver s);
	void removeStateObserver(IStateObserver s);
	void notifyObserver();
	
}
