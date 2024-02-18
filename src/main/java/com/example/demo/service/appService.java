package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.student;
import com.example.demo.repository.userRepository;

@Component
public class appService {
	
	@Autowired
	private userRepository repo;
	
	public void saves(String name,String address) {
		student st=new student();
		st.setName(name);
		st.setAddress(address);
		repo.save(st);
	}
	
	public List<student> list(){
		 List<student>l= repo.findAll();
		 return l;
		
	}
	public Optional<student> update(int id){
		Optional<student> li=repo.findById(id);
		return li;
	}
	
	public void update_save( int id,String name,String address) {
		student st=new student();
		st.setAddress(address);
		st.setId(id);
		st.setName(name);
		repo.save(st);
	}
	public void delete(int id) {
		repo.deleteById(id);
	}
	public student search(Integer id){
		Optional<student> s=repo.findById(id);
		return s.orElse(null);
		
	}

}
