package com.law.springdata.tutorials.idgenerators;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class CustomRandomIDGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
//        Random random = null;
//        random = new Random();
//        int id = random.nextInt(1000000);
//        return new Long(id);
//        return UUID.randomUUID().toString();
        return getUUID();
    }

    private String getUUID() {
        MessageDigest salt = null;
        try {
            salt = MessageDigest.getInstance("SHA-256");
            salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
            return UUID.nameUUIDFromBytes(salt.digest()).toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "UUID.randomUUID().toString()";
    }
}
