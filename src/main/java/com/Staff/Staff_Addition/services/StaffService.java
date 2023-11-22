package com.Staff.Staff_Addition.services;

// StaffService.java
import com.Staff.Staff_Addition.entity.Staff;
import com.Staff.Staff_Addition.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff addStaff(Staff staffentity) {
        return staffRepository.save(staffentity);
    }
}
