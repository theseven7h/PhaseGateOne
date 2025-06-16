from datetime import datetime, timedelta

entry = "%d/%m/%Y"
output = "%d %B, %Y"

def get_next_cycle_date(date, cycle_days):
	next = datetime.strptime(date, entry).date() + timedelta(days=cycle_days)
	return next

def get_next_flow_dates(lcd):
	ncd = lcd + timedelta(days = 28)
	return [ncd, ncd + timedelta(days=5)]

def get_ovulation_date(date, cycle_days):
	od = get_next_cycle_date(date, cycle_days) - timedelta(days=14)
	return od

def get_fertile_window(date, cycle_days):
	fwb = get_ovulation_date(date, cycle_days) - timedelta(days=5)
	fwa = get_ovulation_date(date, cycle_days) + timedelta(days=1)
	return [fwb,fwa]

def get_safe_period(date, cycle_days):
	last_cycle = datetime.strptime(date, entry)
	safe_period = get_fertile_window(date, cycle_days)
	next_cycle = get_next_cycle_date(date, cycle_days)
	return [[last_cycle, safe_period[0] - timedelta(days=1)],[safe_period[1] + timedelta(days=1), next_cycle]]

def main():
	while True:
		print("Enter your last period date (dd/mm/yyyy): ")
		date = input("--> ").strip()
		try:
			lcd = datetime.strptime(date, entry)
			fertile_window = get_fertile_window(date, 28)
			safe_period = get_safe_period(date, 28)
			print()	
	
			print("Last cycle date: " + lcd.strftime(output))
			print("Expected next flow dates: " + get_next_flow_dates(lcd)[0].strftime(output) + " to " + get_next_flow_dates(lcd)[1].strftime(output))
			print("Expected ovulation: " + get_ovulation_date("25/05/2025", 28).strftime(output))
			print("Expected fertile window:" + fertile_window[0].strftime(output) + " to " + fertile_window[1].strftime(output))

			print("Expected safe period: " + safe_period[0][0].strftime(output) + " to " + safe_period[0][1].strftime(output) + " and " + safe_period[1][0].strftime(output) + " to " + safe_period[1][1].strftime(output))
			break
		except(ValueError):
			print("Invalid date format... Try again!")
			continue
			
main()