package org.thisdote.innerjoinus.studygroupservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.thisdote.innerjoinus.studygroupservice.entity.StudyGroupEntity;

public interface StudyGroupRepository extends JpaRepository<StudyGroupEntity, Integer> {
}
