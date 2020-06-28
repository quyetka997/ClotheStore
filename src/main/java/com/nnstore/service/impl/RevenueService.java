package com.nnstore.service.impl;

import com.nnstore.dto.RevenueDTO;
import com.nnstore.service.IRevenue;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class RevenueService implements IRevenue {

    @Autowired
    EntityManager em;

    @Override
    public Double revenueMonthAndYear(int month, int year) {
        Query query = em.createNativeQuery("SELECT SUM(ORDERS.amount) FROM ORDERS where MONTH(createdDate) = ? AND YEAR(createdDate) = ?");
        query.setParameter(1, month);
        query.setParameter(2, year);
        Object result = query.getResultList();
        return (Double) result;
    }

    @Override
    public Double revenueYear(int year) {
        Query query = em.createNativeQuery("SELECT SUM(ORDERS.amount) FROM ORDERS where YEAR(createdDate) = ?");
        query.setParameter(1, year);
        Object result = query.getResultList();
        return (Double) result;
    }

    @Override
    public List<RevenueDTO> revenueYearFollowMonth(int year) {
        Query query = em.createNativeQuery("SELECT MONTH(createdDate),SUM(ORDERS.amount) FROM ORDERS " +
                                                    "WHERE YEAR(createdDate) = ?" +
                                                    "GROUP BY MONTH (createdDate)");
        query.setParameter(1, year);
        List<Object[]> results= query.getResultList();
        List<RevenueDTO> revenueDTOs = new ArrayList<>();
        for (Object[] record: results) {
            revenueDTOs.add(new RevenueDTO((Integer) record[0], (Double) record[1]));
        }
        return revenueDTOs;
    }
}
