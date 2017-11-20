package jp.co.internous.lab.Application.Form;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class MTestForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	public String sample1;

	@NotEmpty
	public String sample2;

	@NotEmpty
	public String sample3;

	MTestForm() {
		this.setSample1("sample1");
		this.setSample2("sample2");
		this.setSample3("sample3");
	}
}
