
package com.kenhome.service;

import java.util.Map;

import com.kenhome.model.Acl;


public interface AclService extends BaseService<Acl> {

	// 获得根资源（包含下级资源）
	Map<String,Object> selectRootAndChildAcl();

	// 获得子资源（包含下级资源）
	Map<String,Object> selectChildAcls(Long aclNo);

}
