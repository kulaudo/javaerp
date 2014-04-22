package view;

public interface IObservable {
	void registerObserver(IObserver o);
	void deleteObserver(IObserver o);
	void notifyObserver();
	
	
}
