package jp.co.internous.lab.Application.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.lab.Application.Constants.UrlConstats;
import jp.co.internous.lab.Application.Form.MTestForm;
import jp.co.internous.lab.Application.Form.MUserForm;
import jp.co.internous.lab.Application.Util.SerializableDataUtil;

@Controller
@RequestMapping("/internous/lab/")
public class TestController {

	@Autowired
	HttpSession httpSession;

	MUserForm mUserForm;

	@ModelAttribute("mUserForm")
	MUserForm mUserForm() {
		System.out.println("Create MUserForm");
		return new MUserForm();
	}

	@Autowired
	MTestForm mTestForm;

	@Autowired
	SerializableDataUtil<MTestForm> serializableDataUtil;

	@RequestMapping("test/")
	public String doPost(@ModelAttribute("mUserForm") MUserForm mUserForm, BindingResult bindingResult, Model model) {

		mUserForm.setLoginId("12345");
		mUserForm.setPassword("ABC");
		mUserForm.setUserName("Test");

		// Session変数を代入
		this.mUserForm = mUserForm;

		// HttpSessionを利用
		httpSession.setAttribute("mUserForm", mUserForm);


		serializableDataUtil.setSerializableData(UrlConstats.ContextPath.SERIALIZABlE_PATH+UrlConstats.ContextPath.SERIALIZABlE_FILENAME , mTestForm);

		return UrlConstats.URL_TEST;
	}
}
