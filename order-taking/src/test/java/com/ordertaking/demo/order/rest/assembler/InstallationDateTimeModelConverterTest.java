package com.ordertaking.demo.order.rest.assembler;

import com.ordertaking.demo.order.dto.InstallationDateTimeDto;
import com.ordertaking.demo.order.model.InstallationDateTime;
import com.ordertaking.demo.order.сonverter.InstallationDateTimeModelConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static com.ordertaking.demo.order.OrderServiceTestConstants.TIMESLOT_1;
import static com.ordertaking.demo.order.OrderServiceTestConstants.TIMESLOT_2;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InstallationDateTimeModelConverterTest {

    private InstallationDateTimeModelConverter installationDateTimeModelConverter;

    @BeforeEach
    public void setup() {
        installationDateTimeModelConverter = new InstallationDateTimeModelConverter();
    }

    @Test
    void installationDateTimeDtoAssembledToInstallationDateTime() {
        List<LocalDateTime> timeSlots = List.of(TIMESLOT_1, TIMESLOT_2);
        InstallationDateTimeDto installationDateTimeDto = new InstallationDateTimeDto(timeSlots);
        InstallationDateTime actualInstallationDateTime = installationDateTimeModelConverter.converter(installationDateTimeDto);
        assertEquals(new InstallationDateTime(timeSlots), actualInstallationDateTime);
    }
}
