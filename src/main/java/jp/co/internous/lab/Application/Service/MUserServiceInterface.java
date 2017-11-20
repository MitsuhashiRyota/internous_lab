package jp.co.internous.lab.Application.Service;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import jp.co.internous.lab.Application.Entity.MUser;
import jp.co.internous.lab.Application.Form.MUserForm;

public interface MUserServiceInterface<E> {

	public MUser setRequest(MUserForm mUserForm) throws ParseException;

	public MUser insertData(MUser mUser) throws NoSuchAlgorithmException;

	public boolean validateInsertData(MUserForm mUserForm) throws NullPointerException;

	public boolean checkUserData(String loginId);

	public void test() throws Exception;

}
