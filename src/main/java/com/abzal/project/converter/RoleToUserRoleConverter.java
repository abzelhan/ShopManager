package com.abzal.project.converter;

import com.abzal.project.model.Role;
import com.abzal.project.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleToUserRoleConverter implements Converter<Object, Role>{


	@Autowired
	RoleService roleService;

	/**
	 * Gets UserProfile by Id
	 * @see Converter#convert(Object)
	 */
	public Role convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		Role profile= roleService.findById(id);
		return profile;
	}
	
}