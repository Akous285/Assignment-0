package assignmentPackage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Assign0 {

	public static Scanner input = new Scanner(System.in);

	public static final String INPUT_DATA_FOLDER = "data/input/";
	public static final String OUTPUT_DATA_FOLDER = "data/output/";
	public static final int SCORE_THRESHOLD = 67;

	public static void main(String[] args) throws IOException {
		
		//debugging code
		//System.out.println("Working directory: " + System.getProperty("user.dir"));
		//System.out.println("INPUT_DATA_FOLDER = [" + INPUT_DATA_FOLDER + "]");

		// create object of class
		// Applicant apoorve = new Applicant("Apoorve", "Chokshi", 60, "Married", 6, 9,
		// 9, 8, true,
		// "Professional degree needed to practice in a licensed profession", 0, true,
		// true, false, false, true, false, false, true);

		// call class method
		// System.out.println("apoorve = " + apoorve);

		// read the file
		Scanner input = new Scanner(System.in);

		System.out.print("Please provide the name of the input file (to be located in " + INPUT_DATA_FOLDER + "): ");
		String inputFilename = input.nextLine();

		System.out.print("Please provide the name of the output file (to be placed in " + OUTPUT_DATA_FOLDER + "): ");
		String outputFilename = input.nextLine();

		ArrayList<String[]> rawApplicantList = readFile(inputFilename, ",");

		// convert list to object list
		ArrayList<Applicant> applicantList = convertListToListOfApplicants(rawApplicantList);
		// System.out.println("applicantList = " + applicantList);

		System.out.println(rawApplicantList.size());

		// score language skills
		// System.out.println("\nscore language skills:");
		scoreLanguageSkills(applicantList);

		// score education
		// System.out.println("\nscore education:");
		scoreEducation(applicantList);

		// score work experience
		// System.out.println("\nscore work experience:");
		scoreWorkExperience(applicantList);

		// score age
		// System.out.println("\nscore age:");
		scoreAge(applicantList);

		// score employment
		// System.out.println("\nscore employment:");
		scoreEmployment(applicantList);

		// score adaptability
		// System.out.println("\nscore adaptability:");
		scoreAdaptability(applicantList);

		// print the list of people who made the cut
		printQualifiedApplicants(outputFilename, applicantList);
		input.close();
	}

	/**
	 * This method will take the name of the file, writes to that file
	 *
	 * @param filename      the name of the file (i.e. qualified_applicants.txt)
	 *                      that the programmer wants to write to. The assumption is
	 *                      that the file will be placed within a specified folder
	 *                      OUTPUT_DATA_FOLDER
	 * @param applicantList the list of applicants to check and write out
	 */
	public static void printQualifiedApplicants(String filename, ArrayList<Applicant> applicantList)
			throws IOException {

		// build the file path
		String fullPath = OUTPUT_DATA_FOLDER + filename;
		
		//more debugging code
		//System.out.println("Attempting to open: [" + fullPath + "]");
		// System.out.println("results to be found in: " + fullPath);
		// debug print — temporary
		// System.out.println("Working directory: " + System.getProperty("user.dir"));

		int qualifiedApplicants = 0;

		PrintWriter outputFile = new PrintWriter(fullPath);

		outputFile.println("First Name          |Last Name           |  Age|Score");
		outputFile.println("--------------------+--------------------+-----+-----");

		for (Applicant applicant : applicantList) {
			// System.out.println();
			// System.out.println(applicant.score);
			if (applicant.score >= SCORE_THRESHOLD) {
				outputFile.println(applicant);
				qualifiedApplicants++;
				// outputFile.println("");

			}
		}

		outputFile.close();

		System.out.println("\nThere were " + qualifiedApplicants + " qualified applicants ");
	}

	public static boolean convertToBoolean(String answer) {
		boolean valueBoolean = false;
		if (answer == "yes") {
			valueBoolean = true;
		}

		return valueBoolean;
	}

	public static void scoreLanguageSkills(ArrayList<Applicant> applicantList) {
		for (int i = 0; i < applicantList.size(); i++) {
			Applicant applicant = applicantList.get(i);
			int languageScore = 0;

			// speaking
			if (applicant.speak1 == 7) {
				languageScore += 4;
			} else if (applicant.speak1 == 8) {
				languageScore += 5;
			} else if (applicant.speak1 >= 9) {
				languageScore += 6;
			}

			// listening
			if (applicant.listen1 == 7) {
				languageScore += 4;
			} else if (applicant.listen1 == 8) {
				languageScore += 5;
			} else if (applicant.listen1 >= 9) {
				languageScore += 6;
			}

			// reading
			if (applicant.read1 == 7) {
				languageScore += 4;
			} else if (applicant.read1 == 8) {
				languageScore += 5;
			} else if (applicant.read1 >= 9) {
				languageScore += 6;
			}

			// writing
			if (applicant.write1 == 7) {
				languageScore += 4;
			} else if (applicant.write1 == 8) {
				languageScore += 5;
			} else if (applicant.write1 >= 9) {
				languageScore += 6;
			}

			// secondary language
			if (applicant.all2 == true) {
				languageScore += 4;
			} else {
				languageScore += 0;
			}

			applicant.score += languageScore;
		}
	}

	public static void scoreEducation(ArrayList<Applicant> applicantList) {
		for (int i = 0; i < applicantList.size(); i++) {
			Applicant applicant = applicantList.get(i);

			if (applicant.education.equals("Secondary school (high school diploma)")) {
				applicant.score += 5;

			} else if (applicant.education.equals("One-year degree, diploma or certificate")) {
				applicant.score += 15;

			} else if (applicant.education.equals("Two-year degree, diploma or certificate")) {
				applicant.score += 19;

			} else if (applicant.education.equals("Bachelor's degree or other programs (three or more years)")) {
				applicant.score += 21;

			} else if (applicant.education.equals("Two or more certificates, diplomas, or degrees")) {
				applicant.score += 22;

			} else if (applicant.education.equals("Professional degree needed to practice in a licensed profession")) {
				applicant.score += 23;

			} else if (applicant.education.equals("University degree at the Master's level")) {
				applicant.score += 23;

			} else if (applicant.education.equals("University degree at the Doctoral (PhD) level")) {
				applicant.score += 25;
			}
		}
	}

	public static void scoreWorkExperience(ArrayList<Applicant> applicantList) {
		for (int i = 0; i < applicantList.size(); i++) {
			Applicant applicant = applicantList.get(i);

			if (applicant.workExperience == 1) {
				applicant.score += 9;

			} else if (applicant.workExperience == 2 || applicant.workExperience == 3) {
				applicant.score += 11;

			} else if (applicant.workExperience == 4 || applicant.workExperience == 5) {
				applicant.score += 13;

			} else if (applicant.workExperience > 5) {
				applicant.score += 15;
			}
		}
	}

	public static void scoreAge(ArrayList<Applicant> applicantList) {
		for (int i = 0; i < applicantList.size(); i++) {
			Applicant applicant = applicantList.get(i);

			if (applicant.age < 18) {
				applicant.score += 0;

			} else if (applicant.age >= 18 && applicant.age <= 35) {
				applicant.score += 12;

			} else if (applicant.age == 36) {
				applicant.score += 11;

			} else if (applicant.age == 37) {
				applicant.score += 10;

			} else if (applicant.age == 38) {
				applicant.score += 9;

			} else if (applicant.age == 39) {
				applicant.score += 8;

			} else if (applicant.age == 40) {
				applicant.score += 7;

			} else if (applicant.age == 41) {
				applicant.score += 6;

			} else if (applicant.age == 42) {
				applicant.score += 5;

			} else if (applicant.age == 43) {
				applicant.score += 4;

			} else if (applicant.age == 44) {
				applicant.score += 3;

			} else if (applicant.age == 45) {
				applicant.score += 2;

			} else if (applicant.age == 46) {
				applicant.score += 1;

			} else if (applicant.age >= 47) {
				applicant.score += 0;
			}
		}
	}

	public static void scoreEmployment(ArrayList<Applicant> applicantList) {
		for (int i = 0; i < applicantList.size(); i++) {
			Applicant applicant = applicantList.get(i);

			if (applicant.arrangedEmployment == true) {
				applicant.score += 10;
			}
		}
	}

	public static void scoreAdaptability(ArrayList<Applicant> applicantList) {
		for (int i = 0; i < applicantList.size(); i++) {
			Applicant applicant = applicantList.get(i);

			int adaptabilityScore = 0;

			if (applicant.adaptabilitySpouseLanguage == true) {
				adaptabilityScore += 5;
			}

			if (applicant.adaptabilitySpouseEducation == true) {
				adaptabilityScore += 5;
			}

			if (applicant.adaptabilitySpouseWork == true) {
				adaptabilityScore += 5;
			}

			if (applicant.adaptabilityYouEducation == true) {
				adaptabilityScore += 5;
			}

			if (applicant.adaptabilityYouWork == true) {
				adaptabilityScore += 10;
			}

			if (applicant.adaptabilityYouEmployment == true) {
				adaptabilityScore += 5;
			}

			if (applicant.adaptabilityRelatives == true) {
				adaptabilityScore += 5;
			}

			if (adaptabilityScore >= 10) {
				applicant.score += 10;
			} else {
				applicant.score += adaptabilityScore;
			}
		}
	}

	public static ArrayList<Applicant> convertListToListOfApplicants(ArrayList<String[]> applicantList) {
		ArrayList<Applicant> objectApplicantList = new ArrayList<>();
		
		// skip index 0 because it is the header/label information

		// split the string by the comma in order to organize the data

		applicantList.remove(0);

		for (String[] line : applicantList) {

			String firstName = line[0].trim();
			String lastName = line[1].trim();
			int age = Integer.parseInt(line[2]);
			String maritalStatus = line[3].trim();
			int speak1 = Integer.parseInt(line[4]);
			int listen1 = Integer.parseInt(line[5]);
			int read1 = Integer.parseInt(line[6]);
			int write1 = Integer.parseInt(line[7]);
			boolean all2 = convertToBoolean(line[8]);

			String education = line[9].trim();
			int workExperience = Integer.parseInt(line[10].trim());

			boolean arrangedEmployment = convertToBoolean(line[11]);
			boolean adaptabilitySpouseLanguage = convertToBoolean(line[12]);
			boolean adaptabilitySpouseEducation = convertToBoolean(line[13]);
			boolean adaptabilitySpouseWork = convertToBoolean(line[14]);
			boolean adaptabilityYouEducation = convertToBoolean(line[15]);
			boolean adaptabilityYouWork = convertToBoolean(line[16]);
			boolean adaptabilityYouEmployment = convertToBoolean(line[17]);
			boolean adaptabilityRelatives = convertToBoolean(line[18]);

			Applicant applicant = new Applicant(firstName, lastName, age, maritalStatus, speak1, listen1, read1, write1,
					all2, education, workExperience, arrangedEmployment, adaptabilitySpouseLanguage,
					adaptabilitySpouseEducation, adaptabilitySpouseWork, adaptabilityYouEducation, adaptabilityYouWork,
					adaptabilityYouEmployment, adaptabilityRelatives);

			objectApplicantList.add(applicant);

		}

		return objectApplicantList;

	}

	public static ArrayList<String[]> readFile(String filename, String delimeter) throws IOException {

		// build the file path
		String fullPath = INPUT_DATA_FOLDER + filename;
		// System.out.println("fullPath = " + fullPath);

		ArrayList<String[]> linesList = new ArrayList<String[]>();

		//
		// one line at-a-time reading file
		//
		File file = new File(fullPath);
		FileReader fr = new FileReader(file);
		Scanner reader = new Scanner(fr);

		// Read and print the entire file line by line
		while (reader.hasNextLine()) {
			String line = reader.nextLine();

			String[] splitLine = splitCsvLine(line);
			linesList.add(splitLine);
		}
		reader.close();

		return linesList;
	}
	
	public static String[] splitCsvLine(String line) {

		ArrayList<String> fields = new ArrayList<String>();
		boolean insideQuotes = false;

		String currentField = "";

		for (int i = 0; i < line.length(); i++) {

			char c = line.charAt(i);

			if (c == '\"') {
				insideQuotes = !insideQuotes;
			} else if (c == ',' && !insideQuotes) {
				fields.add(currentField.trim());
				currentField = "";
			} else {
				currentField += c;
			}
		}
		fields.add(currentField.trim());

		String[] result = new String[fields.size()];
		for (int i = 0; i < fields.size(); i++) {
			result[i] = fields.get(i);
		}

		return result;
	}

}
