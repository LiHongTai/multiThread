package com.roger.concurrent.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExecutorDto implements Serializable {
	private static final long serialVersionUID = -7815600940418327960L;
	
	private String workExecutorName;
	private Integer corePoolSize;
	private Integer maximumPoolSize;
	private Long keepAliveTime;
	private String systemName;
}
