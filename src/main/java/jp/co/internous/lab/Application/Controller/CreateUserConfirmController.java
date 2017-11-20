package jp.co.internous.lab.Application.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.internous.lab.Application.Entity.MUser;
import jp.co.internous.lab.Application.Form.MUserForm;
import jp.co.internous.lab.Application.Service.MUserServiceInterface;
import jp.co.internous.lab.Application.Util.LoggerFactoryUtil;

@Controller
@SessionAttributes(value="mUserForm")
@RequestMapping("/internous/lab/create/user")
public class CreateUserConfirmController extends LoggerFactoryUtil {

	protected CreateUserConfirmController() {
		super(CreateUserConfirmController.class);
	}

	@Autowired
	MUserServiceInterface<MUser> mUserServiceInterface;

	@Autowired
	MUser mUser;

	MUserForm mUserFrom;

	@ModelAttribute("mUserForm")
	MUserForm mUserForm() {
        System.out.println("create Session");
        return new MUserForm();
    }

	@RequestMapping(value="/confirm/" , method = RequestMethod.POST)
	public String doPost(@Valid @ModelAttribute("mUserForm") MUserForm mUserForm, BindingResult bindingResult, Model model) throws Exception {
		this.mUserFrom = mUserForm;
		model.addAttribute("MUserForm", this.mUserFrom);

		if (bindingResult.hasErrors()) {
			model.addAttribute("loginId", bindingResult.getFieldErrors("loginId"));
			model.addAttribute("password", bindingResult.getFieldErrors("password"));
			model.addAttribute("userName", bindingResult.getFieldErrors("userName"));
		    return "createUser";
		}

		if(mUserServiceInterface.checkUserData(mUserForm.getLoginId())) {
			mUserServiceInterface.insertData(mUserServiceInterface.setRequest(mUserForm));
			model.addAttribute("createMessage", "ユーザー登録完了");
		} else {
			model.addAttribute("loginIdAndPass", "・そのIDは既に登録されてます。");
		}
		return "login";
	}

	@RequestMapping(value="/confirm/" , method = RequestMethod.GET)
	public String doGet(@ModelAttribute("mUserForm") MUserForm mUserForm, BindingResult bindingResult, Model model) {
		this.mUserFrom = mUserForm;
		model.addAttribute("MUserForm", this.mUserFrom);
		return "createUser";
	}
}
