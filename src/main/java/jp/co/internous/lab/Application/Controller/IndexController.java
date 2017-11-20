package jp.co.internous.lab.Application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.lab.Application.Entity.MUser;
import jp.co.internous.lab.Application.Form.MUserForm;
import jp.co.internous.lab.Application.Repository.MUserRepository;
import jp.co.internous.lab.Application.Service.MUserServiceInterface;
import jp.co.internous.lab.Application.Util.LoggerFactoryUtil;

@Controller
@RequestMapping("internous")
public class IndexController extends LoggerFactoryUtil {

	protected IndexController() {
		super(IndexController.class);
	}

	@Autowired
	MUserRepository mUserRepository;

	@Autowired
	MUserServiceInterface<MUser> mUserServiceInterface;

	@RequestMapping("lab")
	public String doGet(Model model) throws Exception {

//		System.out.println(mUserRepository.findAll().get(0).getId());
//		System.out.println(mUserRepository.findAll().get(0).getUserName());
		// 設定しないとError
		/*
		try {
			mUserServiceInterface.test();
		} catch(Exception e) {
			super.writeException(e);
		}
		*/
		model.addAttribute("MUserForm", new MUserForm());
		return "login";
	}
}
