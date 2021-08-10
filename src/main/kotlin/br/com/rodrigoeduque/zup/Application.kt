package br.com.rodrigoeduque.zup

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.com.rodrigoeduque.zup")
		.start()
}

