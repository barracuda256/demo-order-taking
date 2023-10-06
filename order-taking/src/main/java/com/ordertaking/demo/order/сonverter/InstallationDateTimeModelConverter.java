package com.ordertaking.demo.order.сonverter;

import com.ordertaking.demo.order.dto.InstallationDateTimeDto;
import com.ordertaking.demo.order.model.InstallationDateTime;
import org.springframework.stereotype.Component;

@Component
public class InstallationDateTimeModelConverter implements ModelConverter<InstallationDateTimeDto, InstallationDateTime> {
    @Override
    public InstallationDateTime converter(InstallationDateTimeDto installationDateTimeDto) {
        return new InstallationDateTime(installationDateTimeDto.availableTimeSlots());
    }
}
