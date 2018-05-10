package com.roger.concurrent.factory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roger.concurrent.dao.WorkExecutorDao;
import com.roger.concurrent.dto.WorkExecutorDto;
import com.roger.concurrent.repository.WorkExecutorRepository;

@Component
public class WorkExecutorFactory {

	@Autowired
	private WorkExecutorDao dao;
	
	private WorkExecutorRepository repository = WorkExecutorRepository.getInstance();
	
	@PostConstruct
	private void initThreadPoolExecutors() {
		List<WorkExecutorDto> dtos = dao.findAll();
		
		dtos.forEach((dto)->{
			ThreadPoolExecutor threadPoolExecutor = initThreadPoolExecutor(dto);
			repository.bind(dto.getWorkExecutorName(), threadPoolExecutor);
		});
	}

	private ThreadPoolExecutor initThreadPoolExecutor(WorkExecutorDto dto) {
		return new ThreadPoolExecutor(dto.getCorePoolSize(), dto.getMaximumPoolSize(), 
				dto.getKeepAliveTime(), TimeUnit.SECONDS, new SynchronousQueue<>());
	}
	
	public ExecutorService getExecutorService(String workExecutorName) {
		return repository.lookup(workExecutorName);
	}
}
