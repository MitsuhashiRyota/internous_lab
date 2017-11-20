package jp.co.internous.lab.Application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.lab.Application.Entity.MUser;
import jp.co.internous.lab.Application.Form.MUserForm;
import jp.co.internous.lab.Application.Service.MUserServiceInterface;
import jp.co.internous.lab.Application.Util.LoggerFactoryUtil;

@Controller
@RequestMapping("/internous/lab/create/")
public class CreateUserController extends LoggerFactoryUtil {

	protected CreateUserController() {
		super(CreateUserController.class);
	}

	@Autowired
	MUserServiceInterface<MUser> mUserServiceInterface;

	@Autowired
	MUser mUser;

	@RequestMapping("user/")
	public String doPost(@Validated @ModelAttribute MUserForm mUserForm, BindingResult result, Model model) throws Exception {

		model.addAttribute("MUserForm", mUserForm);
		/*
		try {
			if(mUserServiceInterface.validateInsertData(mUserForm)) {

				if(mUserServiceInterface.checkUserData(mUserForm.getLoginId())) {
					mUserServiceInterface.insertData(mUserServiceInterface.setRequest(mUserForm));
				}

			}
		} catch(NullPointerException e) {
			super.writeException(e);
		} catch(ParseException e) {
			super.writeException(e);
		}
		*/
		return "createUser";
	}
}
