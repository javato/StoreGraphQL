package org.jroldan.store.dao.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface Dao<T, ID> extends JpaRepository<T, ID> {
	// shared methods
}
