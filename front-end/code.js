// Do not make changes to this object literal
let classroom = {
  name: "Intro to JavaScript",
  teacher: {
    name: "Mr J.",
  },
  students: [
    {
      id: 1001,
      firstName: "Joe",
      lastName: "Duggins",
      assignmentGrades: [
        {
          assignmentId: "fswd-1",
          score: 5
        },
        {
          assignmentId: "fswd-2",
          score: 8
        },
        {
          assignmentId: "fswd-3",
          score: 6
        },
        {
          assignmentId: "fswd-4",
          score: 27
        }
      ]
    },
    {
      id: 1002,
      firstName: "Sarah",
      lastName: "Crate",
      assignmentGrades: [
        {
          assignmentId: "fswd-1",
          score: 3
        },
        {
          assignmentId: "fswd-2",
          score: 5
        },
        {
          assignmentId: "fswd-3",
          score: 7
        },
        {
          assignmentId: "fswd-4",
          score: 20
        }
      ]
    },
    {
      id: 1003,
      firstName: "Sandra",
      lastName: "Blaggins",
      assignmentGrades: [
        {
          assignmentId: "fswd-1",
          score: 5
        },
        {
          assignmentId: "fswd-2",
          score: 10
        },
        {
          assignmentId: "fswd-3",
          score: 9
        },
        {
          assignmentId: "fswd-4",
          score: 29
        }
      ]
    },
    {
      id: 1004,
      firstName: "Harvey",
      lastName: "Manns",
      assignmentGrades: [
        {
          assignmentId: "fswd-1",
          score: 1
        },
        {
          assignmentId: "fswd-2",
          score: 4
        },
        {
          assignmentId: "fswd-3",
          score: 6
        },
        {
          assignmentId: "fswd-4",
          score: 20
        }
      ]
    },
    {
      id: 1005,
      firstName: "Monica",
      lastName: "Woolsley",
      assignmentGrades: [
        {
          assignmentId: "fswd-1",
          score: 4
        },
        {
          assignmentId: "fswd-2",
          score: 7
        },
        {
          assignmentId: "fswd-3",
          score: 6
        },
        {
          assignmentId: "fswd-4",
          score: 22
        }
      ]
    },
    {
      id: 1006,
      firstName: "Tyrese",
      lastName: "Jenkins",
      assignmentGrades: [
        {
          assignmentId: "fswd-1",
          score: 5
        },
        {
          assignmentId: "fswd-2",
          score: 10
        },
        {
          assignmentId: "fswd-3",
          score: 9
        },
        {
          assignmentId: "fswd-4",
          score: 29
        }
      ]
    }
  ],
  assignments: [
    {
      id: "fswd-1",
      name: "Intro",
      pointsPossible: 5,
    },
    {
      id: "fswd-2",
      name: "Lesson 1",
      pointsPossible: 10,
    },
    {
      id: "fswd-3",
      name: "Lesson 2",
      pointsPossible: 10,
    },
    {
      id: "fswd-4",
      name: "Final",
      pointsPossible: 30,
    }
  ]
};


// -----------------------------------------------------------------------------------
// Here are a few functions to get you started:

// A failing grade is less than 70 %
const FAILING_GRADE_PERCENTAGE = 70;

// Given a grade Percentage, this will return true of false if that is a failing grade
function isFailingGrade(gradePercentage) {
  return gradePercentage < FAILING_GRADE_PERCENTAGE;
}

// Given a number of points and a total possible number of points, this will return the grade percentage
// From 0 - 100
function getGradePercentage(points, totalPossiblePoints) {
  return Math.round((points / totalPossiblePoints) * 100);
}

// Given a grade percentage, this will return a letter grade: A, B, C, D, or F
function getLetterGrade(gradePercentage) {
  if (gradePercentage > 89) {
    return "A";
  } else if (gradePercentage > 79) {
    return "B";
  } else if (gradePercentage > 69) {
    return "C";
  } else if (gradePercentage > 59) {
    return "D";
  } else {
    return "F";
  }
}

// Given a maximum score, this will return a random integer between 0 and that number
// (This is used down below in the addStudent and addAssignment code)
function getRandomScore(maxScore) {
  return Math.round((Math.random() * maxScore));
}

// -----------------------------------------------------------------------------------
// Complete the following functions:

// Given a student ID (in the form of the parameter studentId), return the corresponding student's object

let studentArray = classroom.students; // Global Variable: Array stores the students objects.
let assignmentInfo = classroom.assignments; // Retrieves the filtered out assignment by assignmentID.

//Returns a student.
function getStudent(studentId) {
  let getStudentVar = classroom.students[0]; // Sets initial value of student object, But will retrieve 
                                             //the filtered out student by studentID.

  studentArray.forEach(student => {  //Iterating through each student.
    if(student.id === studentId){
        getStudentVar = student;
    }
  }
  );
  return getStudentVar;
}

//Returns an student by studentID filteration.
function getStudentById(studentId) {
  return getStudent(studentId);
}

// Given an assignment ID (in the form of the parameter assignmentId), return the corresponding assignment's object
//Returns an assignment.
function getAssignment(assignmentId) {
  let getAssighnmentVar = classroom.assignments[0]; // Sets initial value of assignment object, But will retrieve 
                                                    //the filtered out assignment by assignmentID.
  classroom.students.forEach(student => {  //Iterating through each student.
    student.assignmentGrades.forEach(assignment => {
      if(assignment.id === assignmentId){
        getAssighnmentVar = assignment;
      }
    });
  }
  );
  return getAssighnmentVar;
}

// Add together the pointsPossible on every assignment and return that number
function totalPossiblePoints(assignmentId) {
  let getPoints = 0;
  assignmentInfo.forEach(assignmentBase => {
    if(assignmentBase.id === assignmentId){
      getPoints = assignmentBase.pointsPossible;
    }
  })
  return getPoints;
}

//Returns the total possible points.
function getTotalPossiblePoints() {
  let TPP = 0; //sumOTPP -> sum of total possible points; Gets thethe total possible points.
  assignmentInfo.forEach(assignment => {
      TPP += assignment.pointsPossible;
  });
  return TPP;
}

// Given a student id (in the form of the parameter studentId), add together their score for every assignment
//Adds the student total points.
function studentTotalPoints(studentId) {
  let sumOSTP = 0 // sumOSTP -> sum of student total points; Gets total score for every assignment
  getStudent(studentId).assignmentGrades.forEach(group => {
      sumOSTP += group.score;
  });
  return sumOSTP;
}

//Implements the "studentTotalPoints()".
function calculateStudentTotalPoints(studentId) {
  return studentTotalPoints(studentId);
}

// Given a student id (in the form of the parameter studentId), calculate their overall grade percentage
// Hint: get their total points (you wrote a function for this), and the total possible points (you wrote another function for this), and use those values with the function getGradePercentage
function calculateStudentOverallGradePercentage(studentId) {
  return getGradePercentage(calculateStudentTotalPoints(studentId), getTotalPossiblePoints());
}

// Given a student id (in the form of the parameter studentId), return their letter grade
// Hint: This can call the previous function and pass it to getLetterGrade
function getLetterGradeForStudent(studentId) {
  return getLetterGrade(calculateStudentOverallGradePercentage(studentArray));
}

// Calculate the average overall grade of all of the students in the classroom
// Get the grade percentage of each student and add them all together
// Divide that by the total number of students

// States Formula for class avaerage grade percentage.
function avgGradePercentage(overallClassPoints, totalPossiblePoints) {
  return Math.round(((overallClassPoints / totalPossiblePoints) * 100) / classroom.students.length);
}

function calculateAvgGradePercentageInClassroom() {
  let getAGP = 0; // getTS -> get the average grade percentage; Gets the average grade percentage in classroom
  let counter = 0;
  studentArray.forEach(student => {
    counter++;
    getAGP += calculateStudentOverallGradePercentage(student.id);
  }
  );
  return (getAGP /= counter).toFixed();
}

// -----------------------------------------------------------------------------------
// Rendering the Gradebook - Complete the following render functions using the 
// functions you have completed above
// Replace Any **Value** with the actual value (anything with double star ** around it.)

// Given a list of assignment grades (student.assignmentGrades) render each assignments and the score
function renderAssignmentsGrades(assignmentGrades) {
  let html = "<ul>";

  for (let assignmentGrade of assignmentGrades) {
    html += `<li>${assignmentGrade.assignmentId} - ${assignmentGrade.score}/${totalPossiblePoints(assignmentGrade.assignmentId)}</li>`
  }
  
  html += "</ul>"
  return html;
}

function isFailingGrade(grade){
  let failingGrade = grade < 60? `<span class="warning"></span>` : grade < 80? `<span class="fair"></span>` : `<span class="success"></span>` ;
  return failingGrade;
} 

// Given a list of students (classroom.students) render each student
function renderStudents(students) {

  let html = `<ul class="studentList">`
  html += `<div class="studentListTitle">Students</div>`;

  for (let student of students) {
    // Hint: Only render the <span class="warning"></span> if the student's overall grade isFailingGrade().  A ternary would be great here...

    let calcSOP = calculateStudentOverallGradePercentage(student.id);
    html += `
      <li>
        <div><strong>${student.firstName} ${student.lastName}</strong></div>
        <div>Grade: ${getLetterGrade(student.id)} - ${calcSOP}  ${isFailingGrade(calcSOP)}</div>
        <div>Assignment Scores:</div>
        ${renderAssignmentsGrades(student.assignmentGrades)}
      </li>
    `;
  }

  html += `</ul>`;
  return html;
}

// Render the entire Gradebook
function renderGradebook() {
  let gradebook = document.getElementById("gradebook");
  gradebook.innerHTML = "";

  let html = `
    <header>
      <h2>Gradebook</h2>
      <h4>${classroom.name} with ${classroom.teacher.name}</h4>
      <h4>Number of Assignments: ${classroom.assignments.length}</h4>
      <h4>Average Grade Percentage: ${calculateAvgGradePercentageInClassroom()}</h4>
    </header>
    ${renderStudents(classroom.students)}
  `;
  gradebook.innerHTML = html;
}

renderGradebook();

// -----------------------------------------------------------------------------------
// Adding a student and assignment - This is already completed for you

function addStudent(firstName, lastName) {
  let lastStudentId = classroom.students[classroom.students.length - 1].id

  let student = {
    id: lastStudentId + 1,
    firstName: firstName,
    lastName: lastName,
    assignmentGrades: [],
  }

  // Give the student a random score for each assighnment
  for (let assignment of classroom.assignments) {
    student.assignmentGrades.push({
      assignmentId: assignment.id,
      score: getRandomScore(assignment.pointsPossible)
    })
  }

  classroom.students.push(student);
}

function addAssignment(name, pointsPossible) {
  let lastAssignmentId = classroom.assignments[classroom.assignments.length - 1].id.split("-")

  let assignment = {
    id: `${lastAssignmentId[0]}-${Number(lastAssignmentId[1]) + 1}`,
    name: name,
    pointsPossible: pointsPossible,
  }

  // Give each student a random score for this assignment
  for (let student of classroom.students) {
    student.assignmentGrades.push({
      assignmentId: assignment.id,
      score: getRandomScore(assignment.pointsPossible)
    });
  }

  classroom.assignments.push(assignment);
}

let addStudentForm = document.getElementById("addStudentForm");
addStudentForm.onsubmit = function(event) {
  event.preventDefault();

  let firstNameInput = document.getElementById("studentFirstName");
  let lastNameInput = document.getElementById("studentLastName");
  if (firstNameInput.value && lastNameInput.value) {
    addStudent(firstNameInput.value, lastNameInput.value);
    renderGradebook();
    firstNameInput.value = "";
    lastNameInput.value = "";
  }
}

let addAssignmentForm = document.getElementById("addAssignmentForm");
addAssignmentForm.onsubmit = function(event) {
  event.preventDefault();
  let nameInput = document.getElementById("assignmentName");
  let pointsPossibleInput = document.getElementById("assignmentPoints");
  if (nameInput.value && pointsPossibleInput.value) {
    addAssignment(nameInput.value, parseInt(pointsPossibleInput.value));
    renderGradebook();
    nameInput.value = "";
    pointsPossibleInput.value = "";
  }
}
