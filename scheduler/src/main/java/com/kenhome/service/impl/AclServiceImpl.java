
package com.kenhome.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kenhome.mapper.AclMapper;
import com.kenhome.model.Acl;
import com.kenhome.service.AclService;

@Service("aclService")
public class AclServiceImpl extends BaseServiceImpl<Acl> implements AclService {

	@Autowired
	private AclMapper aclMapper;

	@Autowired
	public void setMapper() {
		super.setMapper(aclMapper);
	}

	@Override
	// 获得根资源（包含下级资源）
	public Map<String, Object> selectRootAndChildAcl() {

		Map<String, Object> map = new HashMap<>();

		Acl rootAcl = aclMapper.selectRootAndChildAcl();

		map.put("rootAcl", rootAcl);

		return map;
	}

	@Override
	// 获得子资源（包含下级资源）
	public Map<String, Object> selectChildAcls(Long aclNo) {
		
		Map<String, Object> map = new HashMap<>();

		List<Acl> childAcls = aclMapper.selectChildAcls(aclNo);

		map.put("childAcls", childAcls);

		return map;
	}

}
