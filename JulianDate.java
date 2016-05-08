
public class JulianDate { // real name is session06.JulianDate
	private double jDate;

	// only one variable monthNames or ALL JulianDate objects (shared)
	private static String[] monthNames = {"Jan", "Feb", "Mar", "Apr","May", "Jun", "Jul", "Aug","Sep", "Oct", "Nov", "Dec" };
	public JulianDate(int year, int mon, int day) {
		this(year,mon,day,0,0,0);	
	}
	public JulianDate(int year, int mon, int day,int hour, int min, int sec) {
		
		jDate= day-32075+1461*(year+4800+(mon-14)/12)/4+367*(mon-2-(mon-14)/12*12)/12-3*((year+4900+(mon-14)/12)/100)/4 + hour/24.0 
				+ min/(24*60.0) + sec/(24*60*60.0);
	}
	
	public int getYear() {
		int year, mon, l ,n;
        l= (int) (jDate+68569);
        n=4*l/146097;
        l=l-(146097*n+3)/4;
        year=4000*(l+1)/1461001;
        l=l-1461*year/4+31;
        mon=80*l/2447;
        l=mon/11;
        return year= 100*(n-49)+year+l;
		
	}
	public int getMonth() {
		int year, mon, l ,n;
        l= (int) (jDate+68569);
        n=4*l/146097;
        l=l-(146097*n+3)/4;
        year=4000*(l+1)/1461001;
        l=l-1461*year/4+31;
        mon=80*l/2447;
        l=mon/11;
        return mon= mon+2-12*l ;
	}
	
	public int getDay() {
		  	int year, mon, day, l ,n;
	        l= (int) (jDate+68569);
	        n=4*l/146097;
	        l=l-(146097*n+3)/4;
	        year=4000*(l+1)/1461001;
	        l=l-1461*year/4+31;
	        mon=80*l/2447;
	        return day=l-2447*mon/80;
	}
	
	// return 0 for Sunday, 1=monday, ... 6 = Saturday
	public int dayOfWeek() {
		return (int) ((jDate)%7+1);
	}
	
	public JulianDate add(int b){
		this.jDate = this.jDate + b;
		int year, mon, day, l ,n;
		l= (int) (jDate +68569);
        n=4*l/146097;
        l=l-(146097*n+3)/4;
        year=4000*(l+1)/1461001;
        l=l-1461*year/4+31;
        mon=80*l/2447;
        day=l-2447*mon/80;
        l=mon/11;
        year= 100*(n-49)+year+l;
        mon= mon+2-12*l ;
        return new JulianDate(year, mon, day);
	}
	
	public JulianDate sub(int b){
		this.jDate = this.jDate - b;
		int year, mon, day, l ,n;
		l= (int) (jDate +68569);
        n=4*l/146097;
        l=l-(146097*n+3)/4;
        year=4000*(l+1)/1461001;
        l=l-1461*year/4+31;
        mon=80*l/2447;
        day=l-2447*mon/80;
        l=mon/11;
        year= 100*(n-49)+year+l;
        mon= mon+2-12*l ;
        return new JulianDate(year, mon, day);
	}
	public double sub(JulianDate b){
		double j1Date = this.jDate - b.jDate;
		return j1Date;
	}

	public String getMonthName(int mon) {
		return monthNames[mon];
	}
	
	public String toString(){
		String []i={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		return getYear()+" "+ monthNames[getMonth()-1]+" "+getDay()+" "+ i[dayOfWeek()-1] ;
	}

	
	
	public static void main(String[] a) {
		JulianDate d1 = new JulianDate(2016, 2, 29);
		JulianDate d2 = new JulianDate(2016, 3, 14);
		JulianDate d8 = new JulianDate(2016, 4, 14);
		System.out.println(d1);
		System.out.println(d2);
		JulianDate d3 = d1.add(1); // tomorrow
		System.out.println(d3);  // 2016 Mar. 1 
		//JulianDate d5 = d1.add(1); //tomorrow noon
		JulianDate d6 = d3.sub(2); // 2 days before d2
		System.out.println(d6);
		double days = d8.sub(d2); // 31 days
		System.out.println(days);
		JulianDate d7 = new JulianDate(2017, 2, 27);
		System.out.println(d7.add(2)); // 2017 Mar. 1
	}
}