package model;

import java.util.ArrayList;


public interface IDetailsModel extends IModel, IDataSet{


	ArrayList<IMasterModel> getMasterList();
}
