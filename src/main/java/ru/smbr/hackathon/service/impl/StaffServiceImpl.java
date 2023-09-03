package ru.smbr.hackathon.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.smbr.hackathon.api.dto.request.StaffRequest;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.PageOfListResponse;
import ru.smbr.hackathon.api.dto.response.StaffResponse;
import ru.smbr.hackathon.exception.ApplicationNotFoundException;
import ru.smbr.hackathon.model.StaffEntity;
import ru.smbr.hackathon.repository.StaffRepository;
import ru.smbr.hackathon.service.StaffService;
import ru.smbr.hackathon.util.mapper.StaffMapper;

import java.util.UUID;

@Service
@AllArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;

    @Override
    public StaffResponse create(StaffRequest staffRequest) {

        StaffEntity newStaff = staffMapper.toStaffEntity(staffRequest);
        staffRepository.save(newStaff);
        return staffMapper.toStaffResponse(newStaff);
    }

    @Override
    public StaffResponse getById(UUID id) {

        StaffEntity staff = staffRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("getById",
                        "StaffEntity not found, staff-id - " + id));

        return staffMapper.toStaffResponse(staff);
    }

    @Override
    public PageOfListResponse<StaffResponse> getAll(int page, int size) {

        Page<StaffEntity> pageOfStaffs = staffRepository.findAll(PageRequest.of(page, size));
        return PageOfListResponse.<StaffResponse>builder()
                .elements(staffMapper.toStaffResponseList(pageOfStaffs.getContent()))
                .size(size)
                .totalPage(pageOfStaffs.getTotalPages())
                .build();
    }

    @Override
    public StaffResponse update(StaffRequest staffRequest, UUID id) {

        StaffEntity staffToUpdate = staffRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("update",
                        "StaffEntity not found, staff-id - " + id));

        staffMapper.updateStaffEntity(staffToUpdate, staffRequest);
        return staffMapper.toStaffResponse(staffToUpdate);
    }

    @Override
    public DeleteResponse delete(UUID id) {
        try {
            staffRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ApplicationNotFoundException("delete",
                    "StaffEntity not found, staff-id - " + id);
        }
        return new DeleteResponse();
    }
}
