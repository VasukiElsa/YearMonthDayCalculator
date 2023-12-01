public class FunctionsForYearMonthDayCalculations {
	public String calculateAge(String birthdate,String currentdate) {
		String BirthDate = birthdate;
		String CurrentDate = currentdate;
		
		int[] months = { 31, 28, 31, 30, 31, 30, 31,  
                        31, 30, 31, 30, 31}; 
		
		int Full_Year = 0;
		int Full_Month = 0;
		int Full_Day = 0;
		int Current_Year = Integer.parseInt(CurrentDate.substring(6,10));
		int Birth_Year = Integer.parseInt(BirthDate.substring(6,10));
		int Current_Month = Integer.parseInt(CurrentDate.substring(3,5));
		int Birth_Month = Integer.parseInt(BirthDate.substring(3,5));
		int Current_Date = Integer.parseInt(CurrentDate.substring(0,2));
		int Birth_Date = Integer.parseInt(BirthDate.substring(0,2));
		Full_Year = Current_Year - Birth_Year;
		if(Current_Month < Birth_Month) {
			Full_Year -= 1;
			Current_Month += 12;
			Full_Month = Current_Month - Birth_Month;
		}
		else {
			Full_Month = Current_Month - Birth_Month;
		}
		if(Current_Date < Birth_Date) {
			Full_Month -= 1;
			Current_Date += months[Birth_Month - 1];
			Full_Day = Current_Date - Birth_Date;
		}
		else {
			Full_Day = Current_Date - Birth_Date;
		}
		if(Birth_Date < Current_Date && Birth_Month == Current_Month){
			Full_Year -= 1;
			Full_Month += 1;
		
		}

		return Full_Year + " " + "years" + " " + Full_Month + " " + "months" + " " + Full_Day + " " + "days old.";
		
	}
	
	

}

