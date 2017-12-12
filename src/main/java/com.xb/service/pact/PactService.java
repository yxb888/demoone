package com.xb.service.pact;

import com.xb.domain.Emps;
import com.xb.domain.OrganizationTree;
import com.xb.domain.Pact;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


public interface PactService {

	Map<String, Object> queryPact(int page, int rows, Pact pact);

	String deletePact(String pactid);

	List<OrganizationTree> queryPactTree();

	Map<String, Object> queryOrgsPage(int page, int rows, Emps emps);

	String addPact(Pact pact) ;

	void deleteAll(String[] pactid);

	Map<String, Object> queryPactType(int page, int rows);

	String deletePactType(String pacttypeid);

	void deletePactTypeAll(String[] pacttypeid);

	Pact queryById(Pact pact);

	void updatePactType(Pact pact);

	List<Pact> queryPacts(HttpServletResponse response, Pact pact);

}
