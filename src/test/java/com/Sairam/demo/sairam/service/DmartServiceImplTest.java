package com.Sairam.demo.sairam.service;

import com.Sairam.demo.sairam.entity.Dmart;
import com.Sairam.demo.sairam.repo.DmartRepo;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@Data
@ExtendWith(MockitoExtension.class)
class DmartServiceImplTest {

    @Mock
    private DmartRepo dmartRepo;

    @InjectMocks
    private DmartServiceImpl dmartService;

    private Dmart dmart;

    @BeforeEach
    void setUp() {
        dmart = new Dmart();
        dmart.setId(1);
        dmart.setItemName("Rice");
    }

    // ===================== saveDmart() =====================

    // ✅ Positive Test Case
    @Test
    void saveDmart_success() {
        when(dmartRepo.save(dmart)).thenReturn(dmart);

        Dmart result = dmartService.saveDmart(dmart);

        assertNotNull(result);
        assertEquals("Rice", result.getItemName());
        verify(dmartRepo, times(1)).save(dmart);
    }

    // ❌ Negative Test Case
    @Test
    void saveDmart_nullObject() {
        when(dmartRepo.save(null)).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> {
            dmartService.saveDmart(null);
        });

        verify(dmartRepo, times(1)).save(null);
    }

    // ===================== findAllDmart() =====================

    // ✅ Positive Test Case
    @Test
    void findAllDmart_success() {
        List<Dmart> list = Arrays.asList(dmart);
        when(dmartRepo.findAll()).thenReturn(list);

        List<Dmart> result = dmartService.findAllDmart();

        assertEquals(1, result.size());
        verify(dmartRepo, times(1)).findAll();
    }

    // ⚠️ Edge Case – Empty List
    @Test
    void findAllDmart_emptyList() {
        when(dmartRepo.findAll()).thenReturn(Collections.emptyList());

        List<Dmart> result = dmartService.findAllDmart();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(dmartRepo, times(1)).findAll();
    }

    // ===================== getDmartFindById() =====================

    // ✅ Positive Test Case
    @Test
    void getDmartFindById_success() {
        when(dmartRepo.findById(1)).thenReturn(Optional.of(dmart));

        Dmart result = dmartService.getDmartFindById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(dmartRepo, times(1)).findById(1);
    }

    // ❌ Negative Test Case – ID not found
    @Test
    void getDmartFindById_notFound() {
        when(dmartRepo.findById(2)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            dmartService.getDmartFindById(2);
        });

        verify(dmartRepo, times(1)).findById(2);
    }
}
