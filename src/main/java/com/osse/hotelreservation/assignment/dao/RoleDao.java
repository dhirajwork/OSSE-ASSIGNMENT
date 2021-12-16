package com.osse.hotelreservation.assignment.dao;

import com.osse.hotelreservation.assignment.entity.Role;

//DAO Pattern for Role
public interface RoleDao {

	public Role findRoleByName(String roleName);

}
