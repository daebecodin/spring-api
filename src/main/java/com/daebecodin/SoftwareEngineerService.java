package com.daebecodin;


import org.springframework.stereotype.Service;

import java.util.List;

@Service //this annotation allows the class to be used by other classes. more instances
public class SoftwareEngineerService {


    private final SoftwareEngineerRepository softwareEngineerRepository;

    SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + "not found"));
    }

    public void deleteSoftwareEngineerById(Integer id) {
       boolean exists = softwareEngineerRepository.existsById(id);

       if (!exists) {
           throw new IllegalStateException(
                   id + "not found"
           );
       }
       softwareEngineerRepository.deleteById(id);
    }

    public void updateSoftwareEngineerById(Integer id, SoftwareEngineer update) {
        SoftwareEngineer softwareEngineer = softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + "not found"));
        softwareEngineer.setName(update.getName());
        softwareEngineer.setTechStack(update.getTechStack());
        softwareEngineerRepository.save(softwareEngineer);
    }
}
