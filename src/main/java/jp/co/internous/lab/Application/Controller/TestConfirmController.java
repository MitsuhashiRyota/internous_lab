package jp.co.internous.lab.Application.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
@RequestMapping("/internous/lab")
public class TestConfirmController {

	@Autowired
	HttpSession httpSession;

	@Autowired
	SerializableDataUtil<MTestForm> serializableDatautil;

	@RequestMapping("test/confirm/")
	public String doPost(@Valid @ModelAttribute("mUserForm") MUserForm mUserForm, BindingResult bindingResult, Model model) throws ClassNotFoundException {

		mUserForm = (MUserForm) httpSession.getAttribute("mUserForm");

		System.out.println("Session確認");

		System.out.println(mUserForm.getLoginId());
		System.out.println(mUserForm.getPassword());
		System.out.println(mUserForm.getUserName());

		System.out.println("デシリアライズ確認");
		MTestForm mTestForm = serializableDatautil.getSerializableDataObject(UrlConstats.ContextPath.SERIALIZABlE_PATH+UrlConstats.ContextPath.SERIALIZABlE_FILENAME);
		System.out.println(mTestForm.getSample1());
		System.out.println(mTestForm.getSample2());
		System.out.println(mTestForm.getSample3());
		return UrlConstats.URL_TEST;
	}

}
