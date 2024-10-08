package org.devjeans.sid.domain.siderCard.repository;

import org.devjeans.sid.domain.siderCard.entity.Career;
import org.devjeans.sid.domain.siderCard.entity.SiderCard;
import org.devjeans.sid.domain.siderCard.entity.SiderCardTechStack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SiderCardTechStackRepository extends JpaRepository<SiderCardTechStack, Long> {
    Optional<SiderCardTechStack> deleteSiderCardTechStackBySiderCard(SiderCard siderCard);
}
