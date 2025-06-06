from datetime import datetime, timedelta

input = "%d/%m/%Y"
output = "%d %B, %Y"

def get_next_cycle_date(date, cycle_days):
	next = datetime.strptime(date, input).date() + timedelta(days=cycle_days)
	return next

def get_ovulation_date(date, cycle_days):
	od = get_next_cycle_date(date, cycle_days) - timedelta(days=14)
	return od

def get_fertile_window(date, cycle_days):
	fwb = get_ovulation_date(date, cycle_days) - timedelta(days=5)
	fwa = get_ovulation_date(date, cycle_days) + timedelta(days=1)
	return [fwb,fwa]

def get_safe_period(date, cycle_days):
	last_cycle = datetime.strptime(date, input)
	safe_period = get_fertile_window(date, cycle_days)
	next_cycle = get_next_cycle_date(date, cycle_days)
	return [[last_cycle, safe_period[0] - timedelta(days=1)],[safe_period[1] + timedelta(days=1), next_cycle]]
	
	
	
	
'''lcd = datetime.strptime("25/05/2025", input)
fertile_window = get_fertile_window("25/05/2025", 28)
safe_period = get_safe_period("25/05/2025", 28)

print("Last cycle date: " + lcd.strftime(output))

print("Expected next cycle: " + get_next_cycle_date("25/05/2025", 28).strftime(output))

print("Expected ovulation: " + get_ovulation_date("25/05/2025", 28).strftime(output))

print("Expected fertile window:" + fertile_window[0].strftime(output) + "to", fertile_window[1].strftime(output))

print("Expected safe period: " + safe_period[0][0].strftime(output) + " to ", safe_period[0][1].strftime(output) + " and " + safe_period[1][0].strftime(output) + " to " + safe_period[1][1].strftime(output))'''