package digitalRestaurant.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="date_time")
public class DateAndTime {
	LocalDateTime localDateTime = LocalDateTime.now();
	
	
	
    @Id
    @Column(name="customer_id")
    private int id;
    
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @Column(name="year")
    private int year;
    
    
    @Column(name="month")
    private int month;
    
    @Column(name="date")
    private int date;
    
    @Column(name="day")
    private String day;
    
    @Column(name="hour")
    private int hour;
    
    @Column(name="minute")
    private int minute;
    
    @Column(name="second")
    private int second;
    
    public DateAndTime() {
		super();
		this.setYear(localDateTime.getYear());
		this.setMonth(localDateTime.getMonthValue());
		this.setDate(localDateTime.getDayOfMonth());
		this.setDay(localDateTime.getDayOfWeek().toString());
		this.setHour(localDateTime.getHour());
		this.setMinute(localDateTime.getMinute());
		this.setSecond(localDateTime.getSecond());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	
    
    
    
}
