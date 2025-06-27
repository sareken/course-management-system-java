# course-management-system-java
This is a Java-based Course Management System project developed for an Object-Oriented Programming course. The program runs through a console interface and allows users to manage courses and students (trainees), including saving and reading data from text files.

## Project Features

- Add, search, list, and delete courses
- Add, search, list, and delete trainees (students)
- Display trainees with their enrolled courses
- Calculate the total fee a trainee must pay
- Read and write data to files (`kurs.txt`, `kursiyer.txt`) for persistence

## File Description

- `AnaSayfa.java`: Main class that runs the entire system
- `Kurs.java`: Class representing a course (ID and name)
- `Kursiyer.java`: Class representing a trainee (ID, name, age, and courses taken)

## How to Run

1. Make sure Java is installed on your system.
2. Save all `.java` files in the same directory.
3. Compile the main class:

```bash
javac AnaSayfa.java
java ödev2.AnaSayfa
```

## File Format

### kurs.txt  
Stores course data in the format:  
`courseId + courseName`

### kursiyer.txt  
Stores trainee data in a custom format:

- Lines starting with `*` represent a trainee:  
  `*id + name + age`

- Lines starting with `%` represent courses taken by the last trainee:  
  `%id + name`

## Notes

- All data is **read from** and **written to** files automatically when the program starts and exits.  
- The program includes **input validation** and **duplicate ID checks**.
