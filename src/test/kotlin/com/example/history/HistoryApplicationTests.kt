package com.example.history

import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class HistoryApplicationTests {
}

/**
 * @link {https://withhamit.tistory.com/138}
 */
fun <T> any(): T {
    Mockito.any<T>()
    return null as T
}
