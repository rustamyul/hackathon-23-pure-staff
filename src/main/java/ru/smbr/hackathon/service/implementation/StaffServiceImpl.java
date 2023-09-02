package ru.smbr.hackathon.service.implementation;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smbr.hackathon.api.dto.request.StaffReqDTO;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.StaffRespDTO;
import ru.smbr.hackathon.model.StaffEntity;
import ru.smbr.hackathon.repository.StaffRepository;
import ru.smbr.hackathon.service.StaffService;
import ru.smbr.hackathon.util.mapper.StaffMapper;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;

    @Override
    public StaffRespDTO create(StaffReqDTO staffRequest) {

        StaffEntity newStaff = staffMapper.toStaffEntity(staffRequest);
        staffRepository.save(newStaff);
        return staffMapper.toStaffRespDTO(newStaff);
    }

    @Override
    public StaffRespDTO getById(UUID id) {

        StaffEntity staff = staffRepository
                .findById(id)
                .orElseThrow();

        return staffMapper.toStaffRespDTO(staff);
    }

    @Override
    public List<StaffRespDTO> getAll(int page, int size) {

        List<StaffEntity> staff = staffRepository.findAll();
        return staffMapper.toStaffResponses(staff);
    }

    @Override
    public StaffRespDTO update(StaffReqDTO staffRequest, UUID id) {

        StaffEntity staffToUpdate = staffRepository
                .findById(id)
                .get();
        staffMapper.updateStaffEntity(staffToUpdate, staffRequest);
        return staffMapper.toStaffRespDTO(staffToUpdate);
    }

    @Override
    public DeleteResponse delete(UUID id) {

        StaffEntity staffToDelete = staffRepository
                .findById(id)
                .orElseThrow();

        staffRepository.delete(staffToDelete);
        return new DeleteResponse();
    }
}
