package com.hcl.commerce.service.testimony;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.commerce.dto.testimony.TestimonyCreateDTO;
import com.hcl.commerce.dto.testimony.TestimonyUpdateDTO;
import com.hcl.commerce.entity.Testimony;
import com.hcl.commerce.repository.TestimonyRepository;

@Service
public class TestimonyService {

	@Autowired
	TestimonyRepository testimonyRepository;

	public Testimony createTestimony(TestimonyCreateDTO dto) {
		Testimony testimony = new Testimony();
		BeanUtils.copyProperties(dto, testimony);
		if(testimony.getRating() > 5 || testimony.getRating() < 1) {
			testimony.setRating(5);
		}
		return testimonyRepository.save(testimony);
	}

	public Testimony getTestimony(Long testimonyId) {
		Optional<Testimony> testimony = testimonyRepository.findById(testimonyId);
		if(testimony.isPresent()) {
			return testimony.get();
		}
		return null;
	}

	public Testimony deleteTestimony(Long testimonyId) {
		Testimony testimony = getTestimony(testimonyId);
		if(testimony != null) {
			testimonyRepository.delete(testimony);
			return testimony;
		}
		return null;
	}

	public Testimony updateTestimony(TestimonyUpdateDTO dto) {
		Testimony testimony = getTestimony(dto.getTestimonyId());
		if(testimony != null) {
			BeanUtils.copyProperties(dto, testimony);
			return testimonyRepository.save(testimony);
		}
		return null;
	}

	public List<Testimony> getTestimonyAll() {
		return testimonyRepository.findAll();
	}

	
	
}
