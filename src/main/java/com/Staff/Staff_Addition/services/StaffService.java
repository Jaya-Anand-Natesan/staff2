package com.Staff.Staff_Addition.services;

// StaffService.java
import com.Staff.Staff_Addition.entity.Staff;
import com.Staff.Staff_Addition.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public Staff updateStaff(int id, Staff updatedStaff) {
        Optional<Staff> existingStaffOptional = staffRepository.findById(id);

        if (existingStaffOptional.isPresent()) {
            Staff existingStaff = existingStaffOptional.get();

            // Update properties based on your requirements
            existingStaff.setName(updatedStaff.getName());
            existingStaff.setDepartment(updatedStaff.getDepartment());
            existingStaff.setPosition(updatedStaff.getPosition());

            return staffRepository.save(existingStaff);
        } else {
            return null; // Staff not found
        }
    }

    public boolean deleteStaff(int id) {
        if (staffRepository.existsById(id)) {
            staffRepository.deleteById(id);
            return true; // Staff deleted successfully
        } else {
            return false; // Staff not found
        }
    }
}

