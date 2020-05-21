package com.utn.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import com.utn.main.dtos.DTOBase;
import com.utn.main.entities.BaseEntity;

public abstract class BaseService<Entity extends BaseEntity, Dto extends DTOBase> implements IBaseService<Dto> {

	private JpaRepository repository;
	private Class dtoAux;
	private Class entityAux;

	public BaseService() {

	}

	public BaseService(JpaRepository repository, Class dtoAux, Class entityAux) {
		this.repository = repository;
		this.dtoAux = dtoAux;
		this.entityAux = entityAux;
	}

	@Override
	@Transactional
	public List<Dto> findAll() throws Exception {
		List<Entity> entities = repository.findAll();
		List<Dto> output = new ArrayList<Dto>();
		try {
			ModelMapper modelMapper = new ModelMapper();
			for (Entity e : entities) {
				Dto dto =  (Dto) modelMapper.map(e, dtoAux);
				output.add(dto);
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception();
		}
		return output;
	}

	@Override
	@Transactional
	public Dto findById(int id) throws Exception {
		Optional<Entity> element = repository.findById(id);
		try {
			Entity base = element.get();
			ModelMapper modelMapper = new ModelMapper();
			Dto output = (Dto) modelMapper.map(base, dtoAux);
			return output;
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception();
		}
	}

	@Override
	@Transactional
	public Dto save(Dto dto) throws Exception {
		Entity entity;
		try {
			ModelMapper modelMapper = new ModelMapper();
			entity =   (Entity) modelMapper.map(dto, dtoAux);
			entity =    (Entity) repository.save(entity);
			return (Dto) modelMapper.map(entity, dtoAux);
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception();
		}
	}

	@Override
	@Transactional
	public Dto update(int id, Dto dto) throws Exception {
		Optional<Entity> base = repository.findById(id);
		try {
			Entity entity = base.get();
			ModelMapper modelMapper = new ModelMapper();
			entity = (Entity) repository.save(entity);
			Dto output = (Dto) modelMapper.map(entity, dtoAux);
			return output;
			
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception();
		}
	}

	@Override
	@Transactional
	public boolean delete(int id) throws Exception {
		if(repository.existsById(id)) {
			try {
			repository.deleteById(id);
			return true;
			} catch (Exception e) {
			System.out.println(e);
			throw new Exception();
			}
		}else {
			throw new Exception();
		}
	}

}
