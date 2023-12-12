package com.xwrokz.repositpry.impl;

import com.xwrokz.dto.UserDTO;
import com.xwrokz.entityManagerFactory.EntityManagerFactorySingleton;
import com.xwrokz.repositpry.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserRepositoryImpl implements UserRepository {
    public void addUserInfo(UserDTO dto) {

        EntityManager entityManager = EntityManagerFactorySingleton.getFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(dto);
        transaction.commit();
    }
}
