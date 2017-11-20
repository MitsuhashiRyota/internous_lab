package jp.co.internous.lab.Application.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Data
@Table(name="m_user")
@Component
@EntityListeners(value = AuditingEntityListener.class)
public class MUser {

	@Id
	private String id;

	@Column(length=16,nullable=false)
	private String loginId;

	@Column(length=16, nullable=false)
	private String password;

	@Column(length=50)
	private String userName;

	@Column(nullable=true)
	private int loginFlg;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date insertDate;


	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

}
