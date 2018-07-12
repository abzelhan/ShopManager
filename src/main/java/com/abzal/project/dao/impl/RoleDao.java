package com.abzal.project.dao.impl;

import com.abzal.project.dao.AbstractDao;
import com.abzal.project.model.Role;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDao")
public class RoleDao extends AbstractDao<Integer,Role> {

    public List<Role> findAllRoles() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Role> roles = (List<Role>) criteria.list();

        return roles;
    }

    public Role findById(int id) {
        Role role = getByKey(id);
        return role;
    }

}
