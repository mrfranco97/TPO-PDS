package com.francomartin.find_your_guide.service;

import com.francomartin.find_your_guide.repositories.GuiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuiaService {
    @Autowired
    private GuiaRepository guiaRepository;
}
