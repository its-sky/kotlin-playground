package practice.kopring

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration(proxyBeanMethods = false)
class TestKopringApplication

fun main(args: Array<String>) {
	fromApplication<KopringApplication>().with(TestKopringApplication::class).run(*args)
}
