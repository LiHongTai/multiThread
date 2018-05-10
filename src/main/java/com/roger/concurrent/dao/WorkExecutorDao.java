package com.roger.concurrent.dao;

import java.util.List;

import com.roger.concurrent.dto.WorkExecutorDto;

public interface WorkExecutorDao {

	List<WorkExecutorDto> findAll();
}
