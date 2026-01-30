package com.bancoweb.banco.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.bancoweb.banco.domain.ClienteFisico;
import com.bancoweb.banco.domain.ClienteJuridico;
import com.bancoweb.banco.domain.Conta;
import com.bancoweb.banco.domain.ContaCorrente;
import com.bancoweb.banco.domain.ContaPoupanca;
import com.bancoweb.banco.domain.Endereco;
import com.bancoweb.banco.repository.ClienteRepository;
import com.bancoweb.banco.repository.ContaRepository;
import com.bancoweb.banco.repository.EnderecoRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private EnderecoRepository enderecoRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private ContaRepository contaRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		enderecoRepo.deleteAll();
		clienteRepo.deleteAll();
		contaRepo.deleteAll();
		
		Endereco end1 = new Endereco("13290001", "Rua José Niero", "Centro", "Louveira", "São Paulo", "19");
		Endereco end2 = new Endereco("87130000", "Rua Arlindo Silva", "Vila das Palmeiras", "Ivatuba", "Parana", "44");
		Endereco end3 = new Endereco("13208056", "Avenida Node de Julho", "Anhangabaú","Jundiaí", "São Paulo", "11");
		
		ClienteFisico cli1 = new ClienteFisico(null, "João da Silva", end1, "60029526431", sdf.parse("21/01/2000"));
		ClienteJuridico cli2 = new ClienteJuridico(null, "Julia Borguette", end3, "00012478210022", "Congelados rápido foods", sdf.parse("13/11/1982"));
		
		enderecoRepo.saveAll(Arrays.asList(end1, end2, end3));
		clienteRepo.saveAll(Arrays.asList(cli1, cli2));
		
		Conta c1 = new ContaCorrente(null, "1234", 200.0, cli2);
		Conta c2 = new ContaPoupanca(null, "1234", 130.0, cli1);
		contaRepo.saveAll(Arrays.asList(c1, c2));
	}

}
