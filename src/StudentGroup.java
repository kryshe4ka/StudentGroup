import java.util.Arrays;
import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 *
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
    
	/**
 	* DO NOT remove or change this constructor, it will be used during task check
 	* @param length
 	*/
	public StudentGroup(int length) {
    	this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
    	return students;
	}

	@Override
	public void setStudents(Student[] students) {
    	if (students == null) {
        	throw new IllegalArgumentException();
    	} else
        	this.students = students;
	}

	@Override
	public Student getStudent(int index) {
    	if ((index < 0) || (index >= students.length)) {
        	throw new IllegalArgumentException();
    	} else
        	return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
    	if (student == null) {
        	throw new IllegalArgumentException();
    	} else
        	students[index] =  student;
	}

	@Override
	public void addFirst(Student student) {    
    	if (student == null) {
        	throw new IllegalArgumentException();
    	} else {
    	Student[] temp = new Student[students.length];
    	for (int i=0; i < students.length; i++) {
        	temp[i] = students[i];
    	}
    	students = new Student[students.length+1];
    	students[0] = student;
    	for (int i=0; i < temp.length; i++) {
        	students[i+1] = temp[i];
    	}
    	}
   	 
	}

	@Override
	public void addLast(Student student) {
	    	if (student == null) {
		        	throw new IllegalArgumentException();
		    	} else {
			    	Student[] temp = new Student[students.length];
			    	for (int i=0; i < students.length; i++) {
			        	temp[i] = students[i];
			    	}
			    	students = new Student[students.length+1];
			    	students[students.length-1] = student;
			    	for (int i=0; i < temp.length; i++) {
			        	students[i] = temp[i];
			    	}
	    	}
	}

	@Override
	public void add(Student student, int index) {
    	if (student == null) {
        	throw new IllegalArgumentException();
    	} else {
        	Student[] temp = new Student[students.length];
        	for (int i=0; i < students.length; i++) {
            	temp[i] = students[i];
        	}
        	students = new Student[students.length+1];
       	 
        	if ((index < 0) || (index >= students.length)) {
            	throw new IllegalArgumentException();
        	} else {
            	if (index == 1) {
                	this.addFirst(student);
            	} else {
                	students[index-1] = student;
                	for (int i=0; i < index-1; i++) {
                    	students[i] = temp[i];
                	}
                	for (int i=index; i < students.length; i++) {
                    	students[i] = temp[i-1];
                	}
            	}
        	}
       	 
    	}
	}

    @Override
	public void remove(int index) {
    	if ((index < 0) & (index >= students.length)) {
        	throw new IllegalArgumentException();
    	} else {
        	Student[] temp = new Student[students.length];
        	for (int i=0; i < students.length; i++) {
            	temp[i] = students[i];
        	}
        	students = new Student[students.length-1];
        	for (int i=0; i < index-1; i++) {
            	students[i] = temp[i];
        	}
        	for (int i=index-1; i < students.length; i++) {
            	students[i] = temp[i+1];
        	}
       	 
    	}
	}

	@Override
	public void remove(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
   	 	} else {
   	 		int i = 0,flag = 0;
   	 		while ( i< students.length) {
   	 			if (students[i].equals(student)) {
   	 				flag = 1;
   	 				this.remove(i+1);    
   	 				break;
   	 			}
   	 			i++;   					 
   	 		}
   	 		if ( flag == 0 ) {
   	 			throw new IllegalArgumentException("Student not exist");   		 
   	 		}
   	 	}
	}

	@Override
	public void removeFromIndex(int index) {

   	 if ((index < 0) & (index >= students.length)) {
        	throw new IllegalArgumentException();
    	} else {
   		 Student[] temp = new Student[students.length];
        	for (int i=0; i < students.length; i++) {
            	temp[i] = students[i];
        	}
   		 students = new Student[index];
        	for (int i=0; i < index; i++) {
            	students[i] = temp[i];
        	}
   	 }
   	 
	}

	@Override
	public void removeFromElement(Student student) {
    	if (student == null) {
   		 throw new IllegalArgumentException();
   	 } else {
   		 int i = 0,flag = 0;
   		 while ( i< students.length) {
   			 if (students[i].equals(student)) {
   				flag = 1;
   				 this.removeFromIndex(i);    
   				 break;
   			 }
   			 i++;   					 
   		 }
   		if ( flag == 0 ) {
	 			throw new IllegalArgumentException("Student not exist");   		 
	 		}
   					 
   	 }
	}

	@Override
	public void removeToIndex(int index) {
    	if ((index < 0) & (index >= students.length)) {
        	throw new IllegalArgumentException();
    	} else {
   		 Student[] temp = new Student[students.length];
        	for (int i=0; i < students.length; i++) {
            	temp[i] = students[i];
        	}
   		 students = new Student[ students.length - index + 1];
        	for (int i=0; i < students.length; i++) {
            	students[i] = temp[i + index - 1];
        	}
   	 }
	}

	@Override
	public void removeToElement(Student student) {
    	if (student == null) {
   		 throw new IllegalArgumentException();
   	 } else {
   		 int i = 0, flag = 0;
   		 while ( i < students.length) {
   			 if (students[i].equals(student)) {
   				 flag = 1;
   				 this.removeToIndex(i+1);    
   				 break;
   			 }
   			 i++;   					 
   		 }
   		if ( flag == 0 ) {
	 			throw new IllegalArgumentException("Student not exist");   		 
	 		}
   	 }
	}

	@Override
	public void bubbleSort() {
    	for (int i = students.length -1; i > 0; i--) {
   		 for (int j =0; j < i; j++ ) {
   			 if (students[j].getId() > students[j+1].getId()){
   				 Student stemp = students[j];
   				 students[j] = students[j+1];
   				 students[j+1] = stemp;
   			 }
   		 }
   	 }
	}
	//ПЕРЕДЕЛАТЬ !!!!!!!!!!!!!!!!!!!
	@Override
	public Student[] getByBirthDate(Date date) {
    	if (date == null) {
   		 throw new IllegalArgumentException();
   	 } else {
   		 int[] index = new int[students.length];
   		 int j = 0;
   		 for (int i = 0; i < students.length; i++){
   			 
   			 if (   true ) { //students[i].getBirthDate() <= date) {
   				 index[j] = i;
   				 j++;
   			 }   			 
   		 }
   		 if (j > 0) {
   			 Student[] newStudentsArray = new Student[j];
   			 for (int i = 0; i < newStudentsArray.length; i++) {
   				 newStudentsArray[i] = students[index[i]];
   			 }
   			 return newStudentsArray;
   		 } else return null;
   	 }
	}
	
	//ПЕРЕДЕЛАТЬ !!!!!!!!!!!!!!!!!!!
	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
    	if ((firstDate == null) || (lastDate == null)) {
   		 throw new IllegalArgumentException();
   	 } else {
   		 int[] index = new int[students.length];
   		 int j = 0;
   		 for (int i = 0; i < students.length; i++){
   			 
   			 if ( true ) { //(students[i].getBirthDate() >= firstDate) && (students[i].getBirthDate() <= lastDate)) {
   				 index[j] = i;
   				 j++;
   			 }   			 
   		 }
   		 if (j > 0) {
   			 Student[] newStudentsArray = new Student[j];
   			 for (int i = 0; i < newStudentsArray.length; i++) {
   				 newStudentsArray[i] = students[index[i]];
   			 }
   			 return newStudentsArray;
   		 } else return null;
   	 }
	}

	//ПЕРЕДЕЛАТЬ !!!!!!!!!!!!!!!!!!!
	@Override
	public Student[] getNearBirthDate(Date date, int days) {
    	if ((date == null) || (days < 0) ) {
   		 throw new IllegalArgumentException();
   	 } else {
   		 //ПЕРЕДЕЛАТЬ ИНИЦИАЛИЗАЦИЮ ДАТ!!
   		 Date firstDate = date; //- days;
   		 Date lastDate = date; //+ days;
   		 this.getBetweenBirthDates(firstDate, lastDate);
   		 
   	 }
		return students;
	}

	//ПЕРЕДЕЛАТЬ !!!!!!!!!!!!!!!!!!!
	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
    	if ((indexOfStudent == 0) || (indexOfStudent < 0) || ((indexOfStudent > students.length)) ) {
   		 throw new IllegalArgumentException();
   	 } else {
   		 //Date date = students[indexOfStudent].getBirthDate();
   		 //ПЕРЕДЕЛАТЬ ДАТУ
   		 int age = 2017 ;//- date.getYear();
   		 return age;
   	 }
	}

	@Override
	public Student[] getStudentsByAge(int age) {
   	 
   	 if ( age > 0) {
   		 int j = 0;    
   		 for (int i = 0; i < students.length; i++) {
   			 if (this.getCurrentAgeByDate(i) == age) {
   				 j++;    
   			 }
   		 }
   		 if (j > 0){
	   		 Student[] studentsByAge = new Student[j];
	   		 j = 0;
	   		 for (int i = 0; i < students.length; i++) {
	   			 if (this.getCurrentAgeByDate(i) == age) {
	   				 studentsByAge[j] = students[i];
	   				 j++;
	   			 }
	   		 }
	   		students = studentsByAge;
   		 }
   	 }
   	 return students;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
	   	double maxAvgMark = students[0].getAvgMark();
	    	for (int i = 0; i < students.length; i++) {
	   		 if (students[i].getAvgMark() > maxAvgMark) {
	   			 maxAvgMark = students[i].getAvgMark();
	   		 }
	   	 }
	   	 int j = 0;   	 
	   	 for (int i = 0; i < students.length; i++) {
	   		 if (students[i].getAvgMark() == maxAvgMark) {
	   			 j++;
	   		 }
	   	 }
	   	 if (j > 0){
	   		 Student[] StudentsWithMaxAvgMark = new Student[j];
	   		 j = 0;
	   		 for (int i = 0; i < students.length; i++) {
	   			 if (students[i].getAvgMark() == maxAvgMark) {
	   				 StudentsWithMaxAvgMark[j] = students[i];
	   				 j++;
	   			 }
	   		 }
	   		students = StudentsWithMaxAvgMark;
	   	}
		return students;
    }

	@Override
	public Student getNextStudent(Student student) {
    	if (student == null) {
   		 throw new IllegalArgumentException();
   	 } else {
   		 int i = 0;
   		 while ( i< students.length) {
   			 if (students[i].equals(student) && (i < students.length-1)) {
   				 return students[i+1];    
   			 }
   			 i++;   					 
   		 }
   		 throw new IllegalArgumentException("Student not exist");   		 
   	 }
	}

	@Override
	public String toString() {
		return "StudentGroup [students=" + Arrays.toString(students) + "]";
	}
	
}



