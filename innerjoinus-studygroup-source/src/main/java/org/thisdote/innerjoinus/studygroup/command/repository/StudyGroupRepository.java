package org.thisdote.innerjoinus.studygroup.command.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.thisdote.innerjoinus.studygroup.command.entity.StudyGroupEntity;

public interface StudyGroupRepository extends JpaRepository<StudyGroupEntity, Integer> {
}
