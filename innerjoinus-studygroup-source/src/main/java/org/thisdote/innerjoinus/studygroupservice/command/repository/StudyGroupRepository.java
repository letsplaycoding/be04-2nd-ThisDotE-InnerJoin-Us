package org.thisdote.innerjoinus.studygroupservice.command.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.thisdote.innerjoinus.studygroupservice.command.entity.StudyGroupEntity;

public interface StudyGroupRepository extends JpaRepository<StudyGroupEntity, Integer> {
}
