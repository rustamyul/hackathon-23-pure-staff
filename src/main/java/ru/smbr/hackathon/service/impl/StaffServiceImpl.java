package ru.smbr.hackathon.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Service
@AllArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;

    @Override
    public StaffResponse create(StaffRequest staffRequest) {

        log.info("#create: Create staff, user-name - {}", staffRequest.getName());
        StaffEntity newStaff = staffMapper.toStaffEntity(staffRequest);
        staffRepository.save(newStaff);
        return staffMapper.toStaffResponse(newStaff);
    }

    @Override
    public StaffResponse getById(UUID id) {

        log.info("#getById: Get staff by id, id - {}", id);
        StaffEntity staff = staffRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("getById",
                        "StaffEntity not found, staff-id - " + id));

        return staffMapper.toStaffResponse(staff);
    }

    @Override
    public PageOfListResponse<StaffResponse> getAll(int page, int size) {

        log.info("#getAll: Get all staffs, page - {}, size - {}", page, size);
        Page<StaffEntity> pageOfStaffs = staffRepository.findAll(PageRequest.of(page, size));
        return PageOfListResponse.<StaffResponse>builder()
                .elements(staffMapper.toStaffResponseList(pageOfStaffs.getContent()))
                .size(size)
                .totalPage(pageOfStaffs.getTotalPages())
                .build();
    }

    @Override
    public StaffResponse update(StaffRequest staffRequest, UUID id) {

        log.info("#update: Update staff, id - {}", id);
        StaffEntity staffToUpdate = staffRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("update",
                        "StaffEntity not found, staff-id - " + id));

        staffMapper.updateStaffEntity(staffToUpdate, staffRequest);
        return staffMapper.toStaffResponse(staffToUpdate);
    }

    @Override
    public DeleteResponse delete(UUID id) {

        log.info("#delete: Delete staff by id, id - {}", id);
        try {
            staffRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ApplicationNotFoundException("delete",
                    "StaffEntity not found, staff-id - " + id);
        }
        return new DeleteResponse();
    }
}
