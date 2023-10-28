package dev.wsalquinga.accounts_service.service.impl;

import dev.wsalquinga.accounts_service.dto.req.MovementReqDTO;
import dev.wsalquinga.accounts_service.dto.res.MovementResDTO;
import dev.wsalquinga.accounts_service.entity.Movement;
import dev.wsalquinga.accounts_service.mapper.MovementMapper;
import dev.wsalquinga.accounts_service.repository.MovementRepository;
import dev.wsalquinga.accounts_service.service.MovementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wsalquinga on 28/10/2023
 */
@Service
@Slf4j
public class MovementServiceImpl implements MovementService {
    private final MovementRepository movementRepository;
    private final MovementMapper movementMapper;

    public MovementServiceImpl(MovementRepository movementRepository, MovementMapper movementMapper) {
        this.movementRepository = movementRepository;
        this.movementMapper = movementMapper;
    }

    @Override
    public Movement getMovementById(Long id) {
        return null;
    }

    @Override
    public MovementResDTO getById(Long id) {
        return null;
    }

    @Override
    public List<MovementResDTO> getAll() {
        return null;
    }

    @Override
    public MovementResDTO create(MovementReqDTO movementReqDTO) {
        return null;
    }

    @Override
    public MovementResDTO update(MovementReqDTO movementReqDTO, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
