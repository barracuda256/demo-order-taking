package com.ordertaking.demo.order.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static com.ordertaking.demo.order.OrderServiceTestConstants.TIMESLOT_1;
import static com.ordertaking.demo.order.OrderServiceTestConstants.TIMESLOT_2;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InstallationDateTimeDtoTest extends AbstractDtoTest {
    @Test
    public void validatorPassesIfInstallationDateTimeDtoIsValid() {
        List<LocalDateTime> timeSlots = List.of(TIMESLOT_1, TIMESLOT_2);
        InstallationDateTimeDto installationDateTimeDto = new InstallationDateTimeDto(timeSlots);
        Set<ConstraintViolation<InstallationDateTimeDto>> violations = validator.validate(installationDateTimeDto);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfTimeSlotsIsNull() {
        InstallationDateTimeDto installationDateTimeDto = new InstallationDateTimeDto(null);
        Set<ConstraintViolation<InstallationDateTimeDto>> violations = validator.validate(installationDateTimeDto);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfTimeSlotsIsEmpty() {
        @NotNull List<LocalDateTime> timeSlots = List.of();
        InstallationDateTimeDto installationDateTimeDto = new InstallationDateTimeDto(timeSlots);
        Set<ConstraintViolation<InstallationDateTimeDto>> violations = validator.validate(installationDateTimeDto);
        assertFalse(violations.isEmpty());
    }
}
