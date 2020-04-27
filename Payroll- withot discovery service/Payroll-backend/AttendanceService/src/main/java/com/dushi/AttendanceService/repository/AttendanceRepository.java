package com.dushi.AttendanceService.repository;

import com.dushi.AttendanceService.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    List<Attendance> findByEmpId(Integer empId);

    Optional<Attendance> findById(Integer id);

}
