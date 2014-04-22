package controller.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import controller.form.AcceptConfirmFormControllerImpl;
import controller.form.AcceptFormControllerImpl;
import controller.form.AcceptPostFormControllerImpl;
import controller.form.CompanyFormControllerImpl;
import controller.form.DataFilterControllerImpl;
import controller.form.DepartFormControllerImpl;
import controller.form.IFormController;
import controller.form.InvSummaryFormControllerImpl;
import controller.form.MatSummaryFormControllerImpl;
import controller.form.ObjectFormControllerImpl;
import controller.form.ProgramAuthFormControllerImpl;
import controller.form.PurOrderFormControllerImpl;
import controller.form.PurOrderPostFormControllerImpl;
import controller.form.RequisitionFormControllerImpl;
import controller.form.RequisitionPostFormControllerImpl;
import controller.form.SysOptionFormControllerImpl;
import controller.form.UserFormControllerImpl;
import controller.form.UserSearchFormControllerImpl;

public class CreateFormAction extends AbstractAction {
	IFormController form;
	boolean enabled=false;
	public CreateFormAction(String text, ImageIcon icon, String desc,
			Integer mnemonic) {
		super(text, icon);
		putValue(SHORT_DESCRIPTION, desc);
		putValue(MNEMONIC_KEY, mnemonic);		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		form=getFormController(e.getActionCommand());
		form.createView();
		form.getView().show();
	}

	private IFormController getFormController(String actionCommand) {
		if (actionCommand == "使用者維護") {
			return UserFormControllerImpl.getInstance();
		}
		else if(actionCommand == "程式權限維護") {
			return ProgramAuthFormControllerImpl.getInstance();
		}
		else if(actionCommand == "部門維護") {
			return DepartFormControllerImpl.getInstance();
		}
		else if(actionCommand == "公司別維護") {
			return CompanyFormControllerImpl.getInstance();
		}
		else if(actionCommand == "對象編號維護") {
			return ObjectFormControllerImpl.getInstance();
		}
		else if(actionCommand == "各項代號維護") {
			return SysOptionFormControllerImpl.getInstance();
		}
		else if(actionCommand == "原料庫存維護") {
			return InvSummaryFormControllerImpl.getInstance();
		}
		else if(actionCommand == "物料庫存維護") {
			return MatSummaryFormControllerImpl.getInstance();
		}
		else if(actionCommand == "驗收單維護") {
			return AcceptFormControllerImpl.getInstance();
		}
		else if(actionCommand == "採購單維護") {
			return PurOrderFormControllerImpl.getInstance();
		}
		else if(actionCommand == "請購單維護") {
			return RequisitionFormControllerImpl.getInstance();
		}
		else if(actionCommand == "驗收單審核") {
			return AcceptConfirmFormControllerImpl.getInstance();
		}
		else if(actionCommand == "驗收單過帳") {
			return AcceptPostFormControllerImpl.getInstance();
		}
		else if(actionCommand == "採購單審核") {
			return PurOrderPostFormControllerImpl.getInstance();
		}
		else if(actionCommand == "請購單審核") {
			return RequisitionPostFormControllerImpl.getInstance();
		}
		else if(actionCommand == "使用者查詢") {
			return UserSearchFormControllerImpl.getInstance();
		}
		else if(actionCommand == "資料篩選") {
			return DataFilterControllerImpl.getInstance();
		}
		
		
					
		return null;
	}
	@Override
	public boolean isEnabled() {
		return enabled;
	}


	@Override
	public void setEnabled(boolean b) {
		enabled=b;

	}

}
