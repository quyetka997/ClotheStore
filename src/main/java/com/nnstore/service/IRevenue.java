package com.nnstore.service;

import com.nnstore.dto.RevenueDTO;

import java.util.List;

public interface IRevenue {
    Double revenueMonthAndYear(int month, int year);

    Double revenueYear(int year);

    List<RevenueDTO> revenueYearFollowMonth(int year);

}
