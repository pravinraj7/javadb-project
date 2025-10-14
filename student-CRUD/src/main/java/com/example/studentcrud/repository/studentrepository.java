package com.example.studentcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentcrud.entity.student;

public interface studentrepository extends JpaRepository<student, Long>{

}
