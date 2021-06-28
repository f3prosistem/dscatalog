package com.f3pro.dscatolog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f3pro.dscatolog.entities.Role;
import com.f3pro.dscatolog.entities.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
