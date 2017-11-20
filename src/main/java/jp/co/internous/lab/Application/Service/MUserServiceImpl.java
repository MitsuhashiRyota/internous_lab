package jp.co.internous.lab.Application.Service;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.internous.lab.Application.Constants.Constants;
import jp.co.internous.lab.Application.Entity.MUser;
import jp.co.internous.lab.Application.Form.MUserForm;
import jp.co.internous.lab.Application.Repository.MUserRepository;
import jp.co.internous.lab.Application.Util.DateUtil;
import jp.co.internous.lab.Application.Util.HashUtil;
import jp.co.internous.lab.Application.Util.SerialUUIDUtil;
import jp.co.internous.lab.Application.Util.ValidateUtil;

@Service
@ComponentScan("jp.co.internous.lab.Application.Entity")
public class MUserServiceImpl<E> implements MUserServiceInterface<E> {

	@Autowired
	private SerialUUIDUtil seriaUUIDutil;

	@Autowired
	private MUser mUser;

	@Autowired
	private MUserRepository mUserRepository;

	private boolean checkBoolean = false;

	@Override
	public MUser setRequest(MUserForm mUserForm) throws ParseException {
		mUser.setId(seriaUUIDutil.getSerialUUID().toString());
		mUser.setLoginId(mUserForm.getLoginId());
		mUser.setPassword(mUserForm.getPassword());
		mUser.setUserName(mUserForm.getUserName());
		mUser.setInsertDate(DateUtil.getDateWrapper(DateUtil.getDate()));
		mUser.setUpdateDate(DateUtil.getDateWrapper(DateUtil.getDate()));
		return mUser;
	}

	@Override
	@Transactional
	public MUser insertData(MUser mUser) throws NoSuchAlgorithmException {
		mUser.setPassword( HashUtil.createHash(mUser.getPassword()));

		return mUserRepository.save(mUser);
	}

	@Override
	public boolean checkUserData(String loginId) {
		MUser checkMUser = mUserRepository.findLoginId(loginId);
		if(checkMUser != null) {
			// エラーメッセージを入れる。
			System.out.println("IDが重複している。");
		} else {
			checkBoolean = true;
		}

		return checkBoolean;
	}

	@Override
	public boolean validateInsertData(MUserForm mUserForm) {
		if(mUserForm.getLoginId().equals(mUserForm.getPassword())) {
			// エラーメッセージ
			System.out.println("IDとパスワードが同じ");
		} else {

			if((ValidateUtil.checklength(mUserForm.getLoginId(), 5, 16))
					&& (ValidateUtil.checklength(mUserForm.getPassword(), 5, 16))
					&& (ValidateUtil.checklength(mUserForm.getUserName(), 5, 16))
					) {
				checkBoolean = true;
			} else {
				// エラーメッセージ
				System.out.println("桁数がおかしい");
			}

		}
		return checkBoolean;
	}

	@Override
	public void test() throws Exception {
		throw new Exception(Constants.ExceptionMessage.EXCEPTION);
	}
}
