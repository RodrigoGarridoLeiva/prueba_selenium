package com.puentedigital.multiposting.dao.repositories;

import com.puentedigital.multiposting.dao.entities.RoleEntity;
import com.puentedigital.multiposting.dao.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

	Optional<RoleEntity> findByName(ERole name);
}
