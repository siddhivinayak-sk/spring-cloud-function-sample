package com.sk;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sk.dtos.DataDTO;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringWebProjApplication {
	
	Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		SpringApplication.run(SpringWebProjApplication.class, args);
	}

	
	@Bean
	public Function<String, String> uppercase() {
		return value -> value.toUpperCase();
	}

	@Bean
	public Function<Flux<String>, Flux<String>> lowercase() {
		return flux -> flux.map(value -> value.toLowerCase());
	}

	@Bean
	public Supplier<String> hello() {
		return () -> "hello";
	}

	@Bean
	public Supplier<Flux<String>> words() {
		return () -> Flux.fromArray(new String[] {"foo", "bar"});
	}

	@Bean
	public Consumer<String> takes() {
		return (t) -> logger.info("Consumed: " + t);
	}

	@Bean
	public Function<DataDTO, Boolean> findsame() {
		return value -> value.getData1().equals(value.getData2()) && value.getData1().equals(value.getData3());
	}
	
	
	
	
//	@Bean
//	public Function<String, String> compiledUppercase(
//		FunctionCompiler<String, String> compiler) {
//		String lambda = "s -> s.toUpperCase()";
//		LambdaCompilingFunction<String, String> function = new LambdaCompilingFunction<>(
//			new ByteArrayResource(lambda.getBytes()), compiler);
//		function.setTypeParameterizations("String", "String");
//		return function;
//	}
//
//	@Bean
//	public Function<Flux<String>, Flux<String>> compiledLowercase(
//		FunctionCompiler<Flux<String>, Flux<String>> compiler) {
//		String lambda = "f->f.map(o->o.toString().toLowerCase())";
//		return new LambdaCompilingFunction<>(new ByteArrayResource(lambda.getBytes()),
//			compiler);
//	}
//
//	@Bean
//	public <T, R> FunctionCompiler<T, R> compiler() {
//		return new FunctionCompiler<>();
//	}
	
	
	
}
