package view.form;

import view.IStateObserver;

import common.State;

import controller.IController;

public abstract class AFormStateObserver implements IStateObserver {	
	IController controller;
	@Override
	public void update(State state) {
		updateWidget(state);
	}
	public abstract void updateWidget(State state) ;
	

}
