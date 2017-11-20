package jp.co.internous.lab.Application.Form;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import jp.co.internous.lab.Application.Constants.ErrorMessageConstants;
import lombok.Data;

@Data
public class MUserForm implements Serializable {

	private static final long serialVersionUID = -1L;

	@NotEmpty(message = "・ログインID" + ErrorMessageConstants.ErrorMessage.NULL_MESSAGE)
	@Size(min = 6, max = 16, message= "・ログインID" + ErrorMessageConstants.ErrorMessage.LENGTH_ORVER_MESSAGE)
	@Pattern(regexp="^[0-9a-zA-Z]+$", message="・ログインID"+ ErrorMessageConstants.ErrorMessage.PATTERN_HANKAKU_ENGLISH_NUMBER + ErrorMessageConstants.ErrorMessage.PATTERN)
	private String loginId;

	@NotEmpty(message = "・パスワード" + ErrorMessageConstants.ErrorMessage.NULL_MESSAGE)
	@Size(min = 8, max = 16, message= "・パスワード" + ErrorMessageConstants.ErrorMessage.LENGTH_ORVER_MESSAGE)
	@Pattern(regexp="^[0-9a-zA-Z]+$", message="・パスワード"+ ErrorMessageConstants.ErrorMessage.PATTERN_HANKAKU_ENGLISH_NUMBER + ErrorMessageConstants.ErrorMessage.PATTERN)
	private String password;

	@NotEmpty(message = "・ユーザー名" + ErrorMessageConstants.ErrorMessage.NULL_MESSAGE)
	@Size(min = 4, max = 25, message= "・ユーザー名" + ErrorMessageConstants.ErrorMessage.LENGTH_ORVER_MESSAGE)
	@Pattern(regexp="^[a-zA-Zぁ-んァ-ヶ亜-熙]+$", message="・ユーザー名"+ ErrorMessageConstants.ErrorMessage.PATTERN_HANKAKU_ENGLISH + ErrorMessageConstants.ErrorMessage.PATTERN_JAPAN + ErrorMessageConstants.ErrorMessage.PATTERN)
	private String userName;

}
