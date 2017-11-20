package jp.co.internous.lab.Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jp.co.internous.lab.Application.Entity.MUser;

@Repository
public interface MUserRepository extends JpaRepository<MUser, String>{

	@Query("SELECT mu FROM MUser mu WHERE mu.loginId = ?1")
	public MUser findLoginId(String loginId);
}
