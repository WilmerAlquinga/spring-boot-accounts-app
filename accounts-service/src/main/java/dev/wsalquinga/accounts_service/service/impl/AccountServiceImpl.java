package dev.wsalquinga.accounts_service.service.impl;

import dev.wsalquinga.accounts_service.dto.req.AccountReqDTO;
import dev.wsalquinga.accounts_service.dto.res.AccountResDTO;
import dev.wsalquinga.accounts_service.entity.Account;
import dev.wsalquinga.accounts_service.exception.ResourceNotFoundException;
import dev.wsalquinga.accounts_service.mapper.AccountMapper;
import dev.wsalquinga.accounts_service.repository.AccountRepository;
import dev.wsalquinga.accounts_service.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wsalquinga on 28/10/2023
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public Account getAccountById(Long id) {
        log.info("Find account by id: {}", id);
        Account account = this.accountRepository.findValidById(id).orElseThrow(
                () -> new ResourceNotFoundException("No se encontró la Cuenta con el id: " + id)
        );
        log.info("Account retrieved: {}", account);
        return account;
    }

    @Override
    public AccountResDTO getById(Long id) {
        // TODO retrieve client information
        return this.accountMapper.toAccountResDTO(this.getAccountById(id));
    }

    @Override
    public List<AccountResDTO> getAll() {
        log.info("Find all accounts");
        List<Account> accounts = this.accountRepository.findAllValid();
        // TODO retrieve client information
        log.info("Accounts retrieved: {}", accounts.size());
        return this.accountMapper.toAccountResDTO(accounts);
    }

    @Override
    public AccountResDTO create(AccountReqDTO accountReqDTO) {
        log.info("Create account: {}", accountReqDTO.getAccountNumber());
        Account account = this.accountMapper.toAccountEntity(accountReqDTO);
        // TODO add client exists validation
        account = this.accountRepository.save(account);
        log.info("Account created: {}", account);
        return this.accountMapper.toAccountResDTO(account);
    }

    @Override
    public AccountResDTO update(AccountReqDTO accountReqDTO, Long id) {
        Account account = this.getAccountById(id);
        account.setAccountNumber(accountReqDTO.getAccountNumber());
        account.setAccountType(accountReqDTO.getAccountType());
        account.setStatus(accountReqDTO.getStatus());
        account = this.accountRepository.save(account);
        log.info("Account updated: {}", account);
        return this.accountMapper.toAccountResDTO(account);
    }

    @Override
    public void delete(Long id) {
        Account account = this.getAccountById(id);
        account.setDeletedAt(LocalDateTime.now());
        this.accountRepository.save(account);
        log.info("Account with id: {} successfully deleted", id);
    }
}
