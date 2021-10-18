package com.noriteo.delinori_front.repository;

import com.noriteo.delinori_front.entity.Member;
import com.noriteo.delinori_front.repository.search.MemberSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String>, MemberSearch {


}
