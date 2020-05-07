package com.it.contrader.web.rest;

import com.it.contrader.ProductManagerApp;

import com.it.contrader.domain.Progress;
import com.it.contrader.repository.ProgressRepository;
import com.it.contrader.service.ProgressService;
import com.it.contrader.service.dto.ProgressDTO;
import com.it.contrader.service.mapper.ProgressMapper;
import com.it.contrader.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;


import static com.it.contrader.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the ProgressResource REST controller.
 *
 * @see ProgressResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductManagerApp.class)
public class ProgressResourceIntTest {

    private static final Float DEFAULT_CASH = 1F;
    private static final Float UPDATED_CASH = 2F;

    private static final LocalDate DEFAULT_DATA = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATA = LocalDate.now(ZoneId.systemDefault());

    private static final Double DEFAULT_EXPECTATION = 1D;
    private static final Double UPDATED_EXPECTATION = 2D;

    private static final Double DEFAULT_TIME = 1D;
    private static final Double UPDATED_TIME = 2D;

    @Autowired
    private ProgressRepository progressRepository;


    @Autowired
    private ProgressMapper progressMapper;
    

    @Autowired
    private ProgressService progressService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restProgressMockMvc;

    private Progress progress;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ProgressResource progressResource = new ProgressResource(progressService);
        this.restProgressMockMvc = MockMvcBuilders.standaloneSetup(progressResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Progress createEntity(EntityManager em) {
        Progress progress = new Progress()
            .cash(DEFAULT_CASH)
            .data(DEFAULT_DATA)
            .expectation(DEFAULT_EXPECTATION)
            .time(DEFAULT_TIME);
        return progress;
    }

    @Before
    public void initTest() {
        progress = createEntity(em);
    }

    @Test
    @Transactional
    public void createProgress() throws Exception {
        int databaseSizeBeforeCreate = progressRepository.findAll().size();

        // Create the Progress
        ProgressDTO progressDTO = progressMapper.toDto(progress);
        restProgressMockMvc.perform(post("/api/progresses")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(progressDTO)))
            .andExpect(status().isCreated());

        // Validate the Progress in the database
        List<Progress> progressList = progressRepository.findAll();
        assertThat(progressList).hasSize(databaseSizeBeforeCreate + 1);
        Progress testProgress = progressList.get(progressList.size() - 1);
        assertThat(testProgress.getCash()).isEqualTo(DEFAULT_CASH);
        assertThat(testProgress.getData()).isEqualTo(DEFAULT_DATA);
        assertThat(testProgress.getExpectation()).isEqualTo(DEFAULT_EXPECTATION);
        assertThat(testProgress.getTime()).isEqualTo(DEFAULT_TIME);
    }

    @Test
    @Transactional
    public void createProgressWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = progressRepository.findAll().size();

        // Create the Progress with an existing ID
        progress.setId(1L);
        ProgressDTO progressDTO = progressMapper.toDto(progress);

        // An entity with an existing ID cannot be created, so this API call must fail
        restProgressMockMvc.perform(post("/api/progresses")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(progressDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Progress in the database
        List<Progress> progressList = progressRepository.findAll();
        assertThat(progressList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkCashIsRequired() throws Exception {
        int databaseSizeBeforeTest = progressRepository.findAll().size();
        // set the field null
        progress.setCash(null);

        // Create the Progress, which fails.
        ProgressDTO progressDTO = progressMapper.toDto(progress);

        restProgressMockMvc.perform(post("/api/progresses")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(progressDTO)))
            .andExpect(status().isBadRequest());

        List<Progress> progressList = progressRepository.findAll();
        assertThat(progressList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDataIsRequired() throws Exception {
        int databaseSizeBeforeTest = progressRepository.findAll().size();
        // set the field null
        progress.setData(null);

        // Create the Progress, which fails.
        ProgressDTO progressDTO = progressMapper.toDto(progress);

        restProgressMockMvc.perform(post("/api/progresses")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(progressDTO)))
            .andExpect(status().isBadRequest());

        List<Progress> progressList = progressRepository.findAll();
        assertThat(progressList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkExpectationIsRequired() throws Exception {
        int databaseSizeBeforeTest = progressRepository.findAll().size();
        // set the field null
        progress.setExpectation(null);

        // Create the Progress, which fails.
        ProgressDTO progressDTO = progressMapper.toDto(progress);

        restProgressMockMvc.perform(post("/api/progresses")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(progressDTO)))
            .andExpect(status().isBadRequest());

        List<Progress> progressList = progressRepository.findAll();
        assertThat(progressList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkTimeIsRequired() throws Exception {
        int databaseSizeBeforeTest = progressRepository.findAll().size();
        // set the field null
        progress.setTime(null);

        // Create the Progress, which fails.
        ProgressDTO progressDTO = progressMapper.toDto(progress);

        restProgressMockMvc.perform(post("/api/progresses")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(progressDTO)))
            .andExpect(status().isBadRequest());

        List<Progress> progressList = progressRepository.findAll();
        assertThat(progressList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllProgresses() throws Exception {
        // Initialize the database
        progressRepository.saveAndFlush(progress);

        // Get all the progressList
        restProgressMockMvc.perform(get("/api/progresses?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(progress.getId().intValue())))
            .andExpect(jsonPath("$.[*].cash").value(hasItem(DEFAULT_CASH.doubleValue())))
            .andExpect(jsonPath("$.[*].data").value(hasItem(DEFAULT_DATA.toString())))
            .andExpect(jsonPath("$.[*].expectation").value(hasItem(DEFAULT_EXPECTATION.doubleValue())))
            .andExpect(jsonPath("$.[*].time").value(hasItem(DEFAULT_TIME.doubleValue())));
    }
    

    @Test
    @Transactional
    public void getProgress() throws Exception {
        // Initialize the database
        progressRepository.saveAndFlush(progress);

        // Get the progress
        restProgressMockMvc.perform(get("/api/progresses/{id}", progress.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(progress.getId().intValue()))
            .andExpect(jsonPath("$.cash").value(DEFAULT_CASH.doubleValue()))
            .andExpect(jsonPath("$.data").value(DEFAULT_DATA.toString()))
            .andExpect(jsonPath("$.expectation").value(DEFAULT_EXPECTATION.doubleValue()))
            .andExpect(jsonPath("$.time").value(DEFAULT_TIME.doubleValue()));
    }
    @Test
    @Transactional
    public void getNonExistingProgress() throws Exception {
        // Get the progress
        restProgressMockMvc.perform(get("/api/progresses/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateProgress() throws Exception {
        // Initialize the database
        progressRepository.saveAndFlush(progress);

        int databaseSizeBeforeUpdate = progressRepository.findAll().size();

        // Update the progress
        Progress updatedProgress = progressRepository.findById(progress.getId()).get();
        // Disconnect from session so that the updates on updatedProgress are not directly saved in db
        em.detach(updatedProgress);
        updatedProgress
            .cash(UPDATED_CASH)
            .data(UPDATED_DATA)
            .expectation(UPDATED_EXPECTATION)
            .time(UPDATED_TIME);
        ProgressDTO progressDTO = progressMapper.toDto(updatedProgress);

        restProgressMockMvc.perform(put("/api/progresses")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(progressDTO)))
            .andExpect(status().isOk());

        // Validate the Progress in the database
        List<Progress> progressList = progressRepository.findAll();
        assertThat(progressList).hasSize(databaseSizeBeforeUpdate);
        Progress testProgress = progressList.get(progressList.size() - 1);
        assertThat(testProgress.getCash()).isEqualTo(UPDATED_CASH);
        assertThat(testProgress.getData()).isEqualTo(UPDATED_DATA);
        assertThat(testProgress.getExpectation()).isEqualTo(UPDATED_EXPECTATION);
        assertThat(testProgress.getTime()).isEqualTo(UPDATED_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingProgress() throws Exception {
        int databaseSizeBeforeUpdate = progressRepository.findAll().size();

        // Create the Progress
        ProgressDTO progressDTO = progressMapper.toDto(progress);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restProgressMockMvc.perform(put("/api/progresses")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(progressDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Progress in the database
        List<Progress> progressList = progressRepository.findAll();
        assertThat(progressList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteProgress() throws Exception {
        // Initialize the database
        progressRepository.saveAndFlush(progress);

        int databaseSizeBeforeDelete = progressRepository.findAll().size();

        // Get the progress
        restProgressMockMvc.perform(delete("/api/progresses/{id}", progress.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Progress> progressList = progressRepository.findAll();
        assertThat(progressList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Progress.class);
        Progress progress1 = new Progress();
        progress1.setId(1L);
        Progress progress2 = new Progress();
        progress2.setId(progress1.getId());
        assertThat(progress1).isEqualTo(progress2);
        progress2.setId(2L);
        assertThat(progress1).isNotEqualTo(progress2);
        progress1.setId(null);
        assertThat(progress1).isNotEqualTo(progress2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProgressDTO.class);
        ProgressDTO progressDTO1 = new ProgressDTO();
        progressDTO1.setId(1L);
        ProgressDTO progressDTO2 = new ProgressDTO();
        assertThat(progressDTO1).isNotEqualTo(progressDTO2);
        progressDTO2.setId(progressDTO1.getId());
        assertThat(progressDTO1).isEqualTo(progressDTO2);
        progressDTO2.setId(2L);
        assertThat(progressDTO1).isNotEqualTo(progressDTO2);
        progressDTO1.setId(null);
        assertThat(progressDTO1).isNotEqualTo(progressDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(progressMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(progressMapper.fromId(null)).isNull();
    }
}
