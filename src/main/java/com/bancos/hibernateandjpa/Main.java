/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.bancos.hibernateandjpa;

import com.bancos.hibernateandjpa.DAO.PessoaDAO;
import com.bancos.hibernateandjpa.entity.Pessoa;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

/**
 *
 * @author Jackson
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("RUN - Hibernate and JPA!");
        
        /*EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("com.bancos_hibernateandjpa_jar_1.0-SNAPSHOTPU");
            System.out.println("EntityManagerFactory created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (emf != null) {
                emf.close();
            }
        }*/
                
        PessoaDAO pessoaDAO = new PessoaDAO();

        // Criando uma nova pessoa
        
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome("Jackson Neves");
        novaPessoa.setCpf("001.456.789-00");
        novaPessoa.setIdade(33);
        novaPessoa.setProfissao("Engenheiro da Computação");
        
        // Salvando no banco
        pessoaDAO.salvar(novaPessoa);

        // Buscando por ID
        Pessoa pessoa = pessoaDAO.buscarPorId(1);
        System.out.println("Pessoa encontrada: " + pessoa.getNome());

        // Atualizando dados
        pessoa.setProfissao("Arquiteto de Software");
        pessoaDAO.atualizar(pessoa);

        // Listando todas as pessoas
        List<Pessoa> pessoas = pessoaDAO.buscarTodas();
        System.out.println("Lista de pessoas:");
        for (Pessoa p : pessoas) {
            System.out.println(p.getNome() + " - " + p.getProfissao());
        }

        // Deletando uma pessoa
        pessoaDAO.deletar(1);
        //Quando executar na segunda vez, vai apresentar erro por não char o id = 1, pois sera incrementado na segunda vez com id = 2
    }
}
