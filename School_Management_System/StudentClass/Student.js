class Student {
	first_name; middle_name; last_name; student_ID; sex; age;

	constructor (){
		this.first_name = "default_firstName";
		this.middle_name = "default_middleName";
		this.last_name = "default_lastName";
		this.student_ID = "default_student_ID";
		this.sex = "default_sex";
		this.age = 10;
	}

	set first_name(first_name){
		this.first_name = first_name;
	}

	set middle_name(middle_name){
		this.middle_name = middle_name;
	}

	set last_name(last_name){
		this.last_name = last_name;
	}

	set student_ID(student_ID){
		this.student_ID = student_ID;
	}

	set sex(sex){
		this.sex = sex;
	}

	set age(age){
		this.age;
	}

	get first_name(){
		return this.first_name;
	}

	get middle_name(){
		return this.middle_name;
	}

	get last_name(){
		return this.last_name;
	}

	get student_ID(){
		return this.student_ID = student_ID;
	}

	get sex(){
		return this.sex;
	}

	get age(){
		return this.age;
	}

	Student01(first_name, last_name, student_ID, sex, age) {
	 	this.first_name = first_name;
		this.last_name = last_name;
		this.student_ID = student_ID;
		this.sex = sex;
		this.age = age
	 } 

	Student02(first_name, middle_name, last_name, student_ID, sex, age) {
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.student_ID = student_ID;
		this.sex = sex;
		this.age = age
	} 

	toString(){
		   if(this.middle_name != ""){
				return this.first_name + ", " + this.middle_name + ", " +  this.last_name + ", " +  this.student_ID + ", " + 
				       this.sex + ", " +  this.age;
		   }else {
		   	    return this.first_name + ", " +  this.last_name + ", " +  this.student_ID + ", " + 
				       this.sex + ", " +  this.age;
		   }
	}

    static nullObject(){
    	if((this.first_name === "default_firstName" && 
			this.middle_name === "default_middleName" && 
			this.last_name === "default_lastName" && 
			this.student_ID === "default_student_ID" && 
			this.sex === "default_sex" && 
			this.age === 10 ) || 
			(this.first_name === "" && 
			this.middle_name === "" && 
			this.last_name === "" && 
			this.student_ID === "" && 
			this.sex === "" && 
			this.age <= 0 )) {
    		return "STOP";
    	}else {
    		return "GO";
    	}
    }

	//<p id="studentPortal_line_construction"></p> --- Student ID: 0223320 &nbsp &nbsp Ronald Kato

	//Student ID:0223320  --  <br class="student_ID_for_profile" >

	//<br id="Id_2_distinct"> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Student ID:0223320
}


	window.addEventListener("load", addListener);


function Student02(){
	let student = new Student();

	let first_name = document.getElementById("f_name").value;
	let middle_name = document.getElementById("m_name").value;
	let last_name = document.getElementById("l_name").value;
	let student_ID = document.getElementById("student_ID").value;
	let sex = document.getElementById("sex").value;
	let age = document.getElementById("age").value;

	student.Student02(first_name, middle_name, last_name, student_ID, sex, age);
	console.log(student.toString() + "\n");
	console.log(student.last_name+ "\n"+ "\n");


	let studentList = [];
	studentList.push(student);
	console.log(studentList + "\n" + "\n");

	for (student of studentList){
		console.log(student.last_name + "\n");
	}
}

function addListener(){
	if(Student.nullObject === "GO"){
		document.getElementById("submit_button").addEventListener("click", Student02);
	}else {
		
	}
}


