package ku_rum.backend.domain.user.domain;

import ku_rum.backend.domain.building.domain.Building;
import ku_rum.backend.domain.department.domain.Department;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @DisplayName("유저 생성 시 학과 정보를 넣어준다.")
    @Test
    void registeredUserWithDepartment() {
        //given
        Building building = createBuilding();
        String Deptname = "컴퓨터공학부";
        Department department = Department.of(Deptname, building);

        //when
        User user = User.of("사용자1", "202112322", department);

        //then
        assertThat(user.getName()).isEqualTo("사용자1");
        assertThat(user.getStudentId()).isEqualTo("202112322");
        assertThat(user.getDepartment()).isEqualTo(department);
    }

    private Building createBuilding() {
        BigDecimal latitude = BigDecimal.valueOf(64.3423423);
        BigDecimal longitude = BigDecimal.valueOf(342.2343434);
        return (Building.of("신공학관", "신공", latitude, longitude));
    }
}