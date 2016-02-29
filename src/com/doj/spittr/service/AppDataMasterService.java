/**
 * 
 */
package com.doj.spittr.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.doj.spittr.entities.DAppMaster;

/**
 * @author Abhishek
 *
 * 
 */
@Service
@Component
public interface AppDataMasterService {
	public List<DAppMaster> getMasterData(String groupName);
}
