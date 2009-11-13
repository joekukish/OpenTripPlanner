package org.opentripplanner.routing.core;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.onebusaway.gtfs.model.AgencyAndId;
import org.onebusaway.gtfs.services.calendar.CalendarService;
import org.opentripplanner.gtfs.GtfsContext;

public class TraverseOptions {
    public double speed; // in meters/second

    public TraverseMode mode;

    public double transferPenalty = 600;

    private GtfsContext _context;

    public Calendar calendar;

    private CalendarService calendarService;

    private Map<AgencyAndId, Set<Date>> serviceDatesByServiceId;
    
    public TraverseOptions() {
        // http://en.wikipedia.org/wiki/Walking
        speed = 1.33; // 1.33 m/s ~ 3mph, avg. human speed
        mode = TraverseMode.WALK;
        calendar = Calendar.getInstance();
    }
    
    public TraverseOptions(TraverseMode mode) {
        this();
        this.mode = mode;
    }

    public TraverseOptions(GtfsContext context) {
        this();
        _context = context;
        calendarService = context.getCalendarService();
        serviceDatesByServiceId = new HashMap<AgencyAndId, Set<Date>>();
    }

    public GtfsContext getGtfsContext() {
        return _context;
    }

    public void setGtfsContext(GtfsContext context) {
        _context = context;
        calendarService = context.getCalendarService();
        serviceDatesByServiceId = new HashMap<AgencyAndId, Set<Date>>();
    }

    public boolean serviceOn(AgencyAndId serviceId, Date serviceDate) {
        Set<Date> dates = serviceDatesByServiceId.get(serviceId);
        if (dates == null) {
            dates = calendarService.getServiceDatesForServiceId(serviceId);
            serviceDatesByServiceId.put(serviceId, dates);
        }
        return dates.contains(serviceDate);
    }
}