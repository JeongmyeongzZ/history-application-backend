package com.example.history.application.history

import application.history.history.presentation.interfaces.api.GetAllHistoriesController
import javax.transaction.Transactional

@SpringBootTest(classes = [GetAllHistoriesController::class])
@AutoConfigureMockMvc
@Transactional
open class IntegrationTest {
    @Autowired
    protected var mvc: MockMvc? = null

    @Autowired
    protected var objectMapper: ObjectMapper? = null
}
