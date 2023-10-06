package com.ordertaking.demo.order.model;

import java.time.LocalDateTime;
import java.util.List;

public record InstallationDateTime(List<LocalDateTime> availableTimeSlots) {
}
