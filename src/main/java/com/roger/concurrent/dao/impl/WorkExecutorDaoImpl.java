package com.roger.concurrent.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.roger.concurrent.dao.WorkExecutorDao;
import com.roger.concurrent.dto.WorkExecutorDto;

public class WorkExecutorDaoImpl implements WorkExecutorDao {

	@Override
	public List<WorkExecutorDto> findAll() {
		List<WorkExecutorDto> workExecutorDtos = new ArrayList<>();
		WorkExecutorDto workExecutorDto = new WorkExecutorDto();
		
		workExecutorDto.setCorePoolSize(10);
		workExecutorDto.setMaximumPoolSize(14);
		workExecutorDto.setKeepAliveTime(20L);
		workExecutorDto.setSystemName("ph-shop");
		workExecutorDto.setWorkExecutorName("handleUser");
		
		workExecutorDtos.add(workExecutorDto);
		return workExecutorDtos;
	}

}
