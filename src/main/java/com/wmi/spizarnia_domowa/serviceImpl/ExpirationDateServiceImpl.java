package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.ExpirationDate;
import com.wmi.spizarnia_domowa.repository.ExpirationDateRepository;
import com.wmi.spizarnia_domowa.service.ExpirationDateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ExpirationDateServiceImpl implements ExpirationDateService {
    private final ExpirationDateRepository expirationDateRepository;

    @Override
    public ExpirationDate save(LocalDate date, int days){
        ExpirationDate expirationDate = new ExpirationDate();
        expirationDate.setDate(date);
        expirationDate.setRemainderDays(days);
        return expirationDateRepository.save(expirationDate);
    }

    @Override
    public void delete(UUID id) {
        expirationDateRepository.deleteById(id);
    }
}
