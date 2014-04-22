package model;

import database.Purchaseorder;
import database.RequisitionDetails;
import view.IObservable;
import view.IObserver;

public class PurchaseOrderModel implements IDataSet, IModel, IObservable {
	private BaseDAO<Purchaseorder>  dao= new BaseDAO<Purchaseorder>();
	@Override
	public void update(Object o) {
		dao.update((Purchaseorder) o);

	}

	@Override
	public void insert(Object o) {
		dao.create((Purchaseorder) o);
	}

	@Override
	public void delete(Object o) {
		dao.delete((Purchaseorder) o);

	}

	@Override
	public void registerObserver(IObserver o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteObserver(IObserver o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		
	}

}
