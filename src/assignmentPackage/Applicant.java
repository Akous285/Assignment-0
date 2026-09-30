package assignmentPackage;


public class Applicant {

	public String firstName;
	public String lastName;
	public int age;
	public String maritalStatus;
	public int speak1;
	public int listen1;
	public int read1;
	public int write1;
	public boolean all2;
	public String education;
	public int workExperience;
	public boolean arrangedEmployment;
	public boolean adaptabilitySpouseLanguage;
	public boolean adaptabilitySpouseEducation;
	public boolean adaptabilitySpouseWork;
	public boolean adaptabilityYouEducation;
	public boolean adaptabilityYouWork;
	public boolean adaptabilityYouEmployment;
	public boolean adaptabilityRelatives;
	public int score;
	
    public Applicant(String firstName, String lastName, int age, String maritalStatus,
            int speak1, int listen1, int read1, int write1, boolean all2,
            String education, int workExperience, boolean arrangedEmployment,
            boolean adaptabilitySpouseLanguage2, boolean adaptabilitySpouseEducation2, boolean adaptabilitySpouseWork2,
            boolean adaptabilityYouEducation2, boolean adaptabilityYouWork2, boolean adaptabilityYouEmployment2,
            boolean adaptabilityRelatives2) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.maritalStatus = maritalStatus;
        this.speak1 = speak1;
        this.listen1 = listen1;
        this.read1 = read1;
        this.write1 = write1;
        this.all2 = all2;
        this.education = education;
        this.workExperience = workExperience;
        this.arrangedEmployment = arrangedEmployment;
        this.adaptabilitySpouseLanguage = adaptabilitySpouseLanguage2;
        this.adaptabilitySpouseEducation = adaptabilitySpouseEducation2;
        this.adaptabilitySpouseWork = adaptabilitySpouseWork2;
        this.adaptabilityYouEducation = adaptabilityYouEducation2;
        this.adaptabilityYouWork = adaptabilityYouWork2;
        this.adaptabilityYouEmployment = adaptabilityYouEmployment2;
        this.adaptabilityRelatives = adaptabilityRelatives2;
        
        this.score = 0;
    }
	
    // i considered using printf but i needed to return the value and not print it
    // w3schools.com used for toString
     
    @Override
    public String toString() {
        return String.format("%-20s %-20s %5d %5d", firstName, lastName, age, score);
    }
}
	
	

