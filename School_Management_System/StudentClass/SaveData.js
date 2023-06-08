//saving data; passwords, names and others....

class SavaData {
	password;

	constructor(password){
		this.password = password;
	}

	set password(newPassword){
		this.password = newPassword;
	}

	get password(){
		return this.password;
	}

	writePassword(){
		let password = document.getElementsById("writePassword");
		password.innerHTML = this.password;
	}

	submitButtonAction(){
		let buttonAction = document.getElementsById("submit_button");
		buttonAction.addEventListener("click", writePassword);
	}

}
let getPassword = document.getElementsById("password_1"); //stores password

let SavaData01 = new SavaData(getPassword);  //initializes the object

let arrayListOfPasswords = [];
arrayListOfPasswords.push(SavaData.password());